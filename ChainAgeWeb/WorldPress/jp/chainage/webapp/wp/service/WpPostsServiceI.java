package jp.chainage.webapp.wp.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import jp.chainage.webapp.wp.entity.WpPosts;
import jp.chainage.webapp.wp.page.WpPostsPage;

public interface WpPostsServiceI extends CommonService {
    /**
     * 获取资讯列表
     * 
     * @param wpPosts
     * @param dataGrid
     * @param map
     * @return
     * @throws Exception
     */
    public boolean newsList(WpPosts wpPosts, DataGrid dataGrid, Map<String, String[]> map) throws Exception;

    /**
     * 获取快讯列表
     * 
     * @param wpPosts
     * @param dataGrid
     * @param map
     * @return
     * @throws Exception
     */
    public boolean trendList(WpPosts wpPosts, DataGrid dataGrid, Map<String, String[]> map) throws Exception;


    /**
     * 客户端资讯列表
     * 
     * @param page
     * @param uod u:上划 d:下拉
     * @param cid 最后一个文章的id
     * @return
     */
    public List<WpPostsPage> newsAppClientList(int page, String uod, String cid);

    /**
     * 客户端资讯详情页
     * 
     * @param postId
     * @return
     */
    public WpPostsPage newsAppClientDetail(int postId);
}
