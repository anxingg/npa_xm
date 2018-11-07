package jp.chainage.webapp.wp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jodd.bean.BeanUtil;
import jp.chainage.webapp.wp.entity.WpPosts;
import jp.chainage.webapp.wp.page.WpPostsPage;
import jp.chainage.webapp.wp.service.WpPostsServiceI;

@Service("wpPostsService")
@Transactional
public class WpPostsServiceImpl extends CommonServiceImpl implements WpPostsServiceI {
    @Override
    public boolean newsList(WpPosts wpPosts, DataGrid dataGrid, Map<String, String[]> map) throws Exception {
        CriteriaQuery cq = new CriteriaQuery(WpPosts.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wpPosts, map);
        cq.add(Restrictions.eq("postStatus", "publish"));
        cq.addOrder("postDate", SortDirection.desc);
        getDataGridReturn(cq, true);

        // 如果有文章则查询分类和标签
        if (dataGrid.getTotal() > 0)
            assemble_category_tag(dataGrid.getResults());

        return true;
    }

    @Override
    public boolean trendList(WpPosts wpPosts, DataGrid dataGrid, Map<String, String[]> map) throws Exception {
        return true;
    }

    @Override
    public List<WpPostsPage> newsAppClientList(int page, String uod, String cid) {
        StringBuffer sql = new StringBuffer();
        boolean isPaging = false;
        sql.append("select p.id, p.post_title, p.post_content, p.comment_count, p.post_date, u.display_name, m2.meta_value from wp_posts p ")
                .append("JOIN wp_users u ON p.post_author = u.ID ").append("LEFT JOIN wp_postmeta m1 ON p.ID = m1.post_id and m1.meta_key = '_thumbnail_id' ")
                .append("LEFT JOIN wp_postmeta m2 ON m1.meta_value = m2.post_id AND m2.meta_key = '_wp_attached_file' ")
                .append("where p.post_author <> 1 and p.post_status = 'publish' and p.post_title <> '' ");
        if (page == 1) { // 第一次进入，只加载一页数据
            isPaging = true;
        } else {
            if ("u".equals(uod)) { // 上拨操作，加载历史数据, cid是前端view的最后一条post_id
                isPaging = true;
                sql.append("and p.post_date < (select post_date from wp_posts where ID =").append(cid).append(")");
            } else if ("d".equals(uod)) { // 下拉操作，加载新数据, cid是前端view的第一条post_id
                sql.append("and p.post_date > (select post_date from wp_posts where ID =").append(cid).append(")");
            }
        }
        sql.append("order by post_date DESC ");
        if (isPaging)
            sql.append("LIMIT 5");

        List<Map<String, Object>> rs = findForJdbc(sql.toString());
        List<WpPostsPage> list = new ArrayList<WpPostsPage>();
        for (Map<String, Object> rsMap : rs) {
            WpPostsPage item = new WpPostsPage();
            BeanUtil.setProperty(item, "id", rsMap.get("id"));
            BeanUtil.setProperty(item, "postTitle", rsMap.get("post_title"));
            BeanUtil.setProperty(item, "commentCount", rsMap.get("comment_count"));
            BeanUtil.setProperty(item, "postDate", rsMap.get("post_date"));
            BeanUtil.setProperty(item, "authorName", rsMap.get("display_name"));
            BeanUtil.setProperty(item, "specialPictureUrl", rsMap.get("meta_value"));
            BeanUtil.setProperty(item, "readingTime", EstimateReadingTime(rsMap.get("post_content").toString()));
            list.add(item);
        }

        // 如果有文章则查询分类和标签
        if (list.size() > 0)
            assemble_category_tag(list);
        return list;
    }

    /**
     * 查询文章的分类及标签
     * 
     * @param list
     */
    private void assemble_category_tag(@SuppressWarnings("rawtypes") List list) {
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.term_id, t1.name, t2.taxonomy, t3.object_id, t5.display_name ")
                .append("from wp_terms t1, wp_term_taxonomy t2, wp_term_relationships t3, wp_posts t4, wp_users t5 where ").append("t1.term_id = t2.term_id ")
                .append("and t2.term_taxonomy_id = t3.term_taxonomy_id ").append("and t3.object_id = t4.id ").append("and t4.post_author = t5.id ")
                .append("and (t2.taxonomy = 'category' or t2.taxonomy = 'post_tag') ").append("and t3.object_id in(");
        Map<Long, Object> wpPostsMap = new HashMap<Long, Object>(); // 方便查找数组，不用顺序遍历

        for (Object obj : list) {
            Long id = Long.valueOf(BeanUtil.getProperty(obj, "id").toString());
            wpPostsMap.put(id, obj);
            sql.append(id).append(",");
        }
        sql.deleteCharAt(sql.lastIndexOf(",")).append(") order by t3.object_id"); // 去掉最后一个逗号
        List<Map<String, Object>> c_n_list = this.findForJdbc(sql.toString()); // 存储文章的分类和标签

        // 遍历查询出来的标签和分类信息
        for (Map<String, Object> rsMap : c_n_list) {
            Long id_t = Long.valueOf(rsMap.get("object_id").toString());
            Object obj = wpPostsMap.get(id_t);

            if (StringUtil.isNotEmpty(BeanUtil.getProperty(obj, "authorName"))) { // 作者赋值
                BeanUtil.setProperty(obj, "authorName", rsMap.get("display_name").toString());
            }
            String taxonomy = (String) rsMap.get("taxonomy");
            String name = (String) rsMap.get("name");
            if ("category".equals(taxonomy)) { // 分类赋值
                if (StringUtil.isNotEmpty(BeanUtil.getProperty(obj, "categories"))) {
                    BeanUtil.setProperty(obj, "categories", BeanUtil.getProperty(obj, "categories") + ", " + name);
                } else {
                    BeanUtil.setProperty(obj, "categories", name);
                }
            } else if ("post_tag".equals(taxonomy)) { // 标签赋值
                if (StringUtil.isNotEmpty(BeanUtil.getProperty(obj, "postTags"))) {
                    BeanUtil.setProperty(obj, "postTags", BeanUtil.getProperty(obj, "postTags") + ", " + name);
                } else {
                    BeanUtil.setProperty(obj, "postTags", name);
                }
            }
        }
    }

    /**
     * 估计阅读时常
     * 
     * @param txt
     * @return
     */
    private int EstimateReadingTime(String txt) {
        int minute = 0;
        String xx = txt.replaceAll("<\\/?.+?\\/?>", "");
        minute = xx.length() / 300 + 1;
        return minute;
    }

    @Override
    public WpPostsPage newsAppClientDetail(int postId) {
        StringBuffer sql = new StringBuffer();
        sql.append("select p.id, p.post_title, p.post_content, p.comment_count, p.post_date, u.display_name, m2.meta_value from wp_posts p ")
                .append("JOIN wp_users u ON p.post_author = u.ID ").append("LEFT JOIN wp_postmeta m1 ON p.ID = m1.post_id and m1.meta_key = '_thumbnail_id' ")
                .append("LEFT JOIN wp_postmeta m2 ON m1.meta_value = m2.post_id AND m2.meta_key = '_wp_attached_file' ").append("where p.id = ").append(postId);

        List<Map<String, Object>> rs = findForJdbc(sql.toString());
        List<WpPostsPage> list = new ArrayList<WpPostsPage>();
        for (Map<String, Object> rsMap : rs) {
            WpPostsPage item = new WpPostsPage();
            BeanUtil.setProperty(item, "id", rsMap.get("id"));
            BeanUtil.setProperty(item, "postTitle", rsMap.get("post_title"));
            BeanUtil.setProperty(item, "postContent", rsMap.get("post_content"));
            BeanUtil.setProperty(item, "commentCount", rsMap.get("comment_count"));
            BeanUtil.setProperty(item, "postDate", rsMap.get("post_date"));
            BeanUtil.setProperty(item, "authorName", rsMap.get("display_name"));
            BeanUtil.setProperty(item, "specialPictureUrl", rsMap.get("meta_value"));
            BeanUtil.setProperty(item, "readingTime", EstimateReadingTime(rsMap.get("post_content").toString()));
            list.add(item);
        }

        // 如果有文章则查询分类和标签
        if (list.size() > 0) {
            assemble_category_tag(list);
            return list.get(0);
        } else {
            return new WpPostsPage();
        }
    }
}
