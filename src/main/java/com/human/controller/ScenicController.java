package com.human.controller;


import com.human.model.PageBean;
import com.human.model.Scenic;
import com.human.service.ScenicService;
import com.human.util.JsonMsg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/Scenic")
public class ScenicController {

    @Resource
    private ScenicService scenicService;

    @RequestMapping(value = "/showScenic")
    @ResponseBody
    public JsonMsg showScenic()
    {
        List<Scenic> sc= null;
        try {
            sc = scenicService.selectAllScenicInfo();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return JsonMsg.success().addInfo("pagebean",sc);
    }


    @RequestMapping(value = "/ShowScenicByPage")
    @ResponseBody
    public JsonMsg ShowScenicByPage(HttpServletRequest request, Model model){
        try {
            String currentPage = request.getParameter("CurrentPage");
            String pageSize = request.getParameter("PageSize");
            String type = request.getParameter("S_ID");
            int cur = Integer.parseInt(currentPage);
            int pag = Integer.parseInt(pageSize);
            PageBean pagebean = scenicService.findScenicByPage(cur,pag,type);
            return JsonMsg.success().addInfo("pageBean_List",pagebean);
        }
        catch(Exception e)
        {
            return JsonMsg.fail().addInfo("log_error","查询失败 "+e);
        }
    }

    @RequestMapping(value = "/SearchScenic")
    @ResponseBody
    public JsonMsg SearchScenic(HttpServletRequest request, Model model){
        try {
            String currentPage = request.getParameter("CurrentPage");
            String pageSize = request.getParameter("PageSize");
            String Search_Id = request.getParameter("Search_Id");
            String Search_Name = request.getParameter("Search_Name");
            int cur = Integer.parseInt(currentPage);
            int pag = Integer.parseInt(pageSize);
            PageBean pageBean=scenicService.SearchScenicByType(cur,pag,Search_Id,Search_Name);
            return JsonMsg.success().addInfo("pagebean",pageBean);
        }
        catch (Exception e)
        {
            return JsonMsg.fail().addInfo("log_error","查询失败   "+ e);
        }
    }

    /**
     * 获取智能推荐的数据
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/GetPostScenic")
    @ResponseBody
    public JsonMsg getPostScenic(HttpServletRequest request, Model model){
        try {
            String currentPage = request.getParameter("CurrentPage");
            String pageSize = request.getParameter("PageSize");
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()){
                return JsonMsg.fail().addInfo("login_error", "未登录，请登录！");
            }
            String username = currentUser.getPrincipal().toString();
            int cur = Integer.parseInt(currentPage);
            int pag = Integer.parseInt(pageSize);
            PageBean pageBean=scenicService.GetPostAIScenic(cur,pag,username);
            return JsonMsg.success().addInfo("pagebean",pageBean);
        }
        catch (Exception e)
        {
            return JsonMsg.fail().addInfo("log_error","请求失败失败   "+ e);
        }
    }





}
