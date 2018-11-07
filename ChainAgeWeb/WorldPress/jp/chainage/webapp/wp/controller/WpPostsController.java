package jp.chainage.webapp.wp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Min;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jp.chainage.webapp.wp.entity.WpPosts;
import jp.chainage.webapp.wp.page.WpPostsPage;
import jp.chainage.webapp.wp.service.WpPostsServiceI;

/**
 * @Title: Controller
 * @Description: wp文章信息控制
 * @author 赵琦
 * @date 2018-08-14 18:00:00
 * @version V1.0
 *
 */
@Api(value = "wpPosts", description = "worldpress的文章信息控制", tags = "wpPostsController")
@Controller
@RequestMapping("/wp/postsController")
public class WpPostsController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(WpPostsController.class);

    /*--------------------------------------------
    |             Variable                       |
    ============================================*/

    /*--------------------------------------------
    |             Injection                      |
    ============================================*/
    @Autowired
    private WpPostsServiceI wpPostsService;

    /*--------------------------------------------
    |             method                       |
    ============================================*/
    /**
     * 资讯信息列表 页面跳转
     * 
     * @return
     */
    @RequestMapping(params = "newsList", method = RequestMethod.GET)
    public ModelAndView newsList(HttpServletRequest request) {
        return new ModelAndView("jp/chainage/webapp/wp/posts/newsList");
    }

    /**
     * 
     * @param wpPosts
     * @param request
     * @param response
     * @param dataGrid
     */
    @RequestMapping(params = "newsDatagrid")
    public void newsDatagrid(WpPosts wpPosts, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        try {
            wpPostsService.newsList(wpPosts, dataGrid, request.getParameterMap());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 快讯信息列表 页面跳转
     * 
     * @return
     */
    @RequestMapping(params = "trendList", method = RequestMethod.GET)
    public ModelAndView trendList(HttpServletRequest request) {
        return new ModelAndView("jp/chainage/webapp/wp/posts/trendList");
    }

    /**
     * 
     * @param wpPosts
     * @param request
     * @param response
     * @param dataGrid
     */
    @RequestMapping(params = "trendDatagrid")
    public void trendDatagrid(WpPosts wpPosts, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        try {
            wpPostsService.trendList(wpPosts, dataGrid, request.getParameterMap());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 客户端资讯列表
     * 
     * @param page
     * @param uod
     * @param cid
     * @param request
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "客户端资讯列表", notes = "客户端资讯列表", httpMethod = "POST")
    @RequestMapping(params = "newsAppClientList", method = RequestMethod.POST)
    @ResponseBody
    public List<WpPostsPage> newsAppClientList(
            @ApiParam(name = "page", value = "加载的页码", required = true) @RequestParam(value = "page", required = true, defaultValue = "1") @Min(value = 1) Integer page,
            @ApiParam(name = "uod", value = "上拉还是下滑", required = true) @RequestParam(value = "uod", required = false) String uod,
            @ApiParam(name = "cid", value = "需加载的文章id", required = true) @RequestParam(value = "cid", required = false) String cid, HttpServletRequest request) throws Exception {
        List<WpPostsPage> list = wpPostsService.newsAppClientList(page.intValue(), uod, cid);
        return list;
    }

    /**
     * 客户端资讯列表
     * 
     * @param postId
     * @param request
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "客户端资讯详情", notes = "客户端资讯详情", httpMethod = "POST")
    @RequestMapping(params = "newsAppClientDetail", method = RequestMethod.POST)
    @ResponseBody
    public WpPostsPage newsAppClientDetail(
            @ApiParam(name = "postId", value = "文章id", required = true) @RequestParam(value = "postId", required = true) @Min(value = 1) Integer postId,
            HttpServletRequest request) throws Exception {
        WpPostsPage postPage = wpPostsService.newsAppClientDetail(postId.intValue());
        return postPage;
    }


}
