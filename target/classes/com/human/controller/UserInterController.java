package com.human.controller;

import com.human.model.PageBean;
import com.human.model.Scenic;
import com.human.model.UserInterest;
import com.human.service.ScenicService;
import com.human.service.UserInterestService;
import com.human.util.JsonMsg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/userInterest")
public class UserInterController {

    @Resource
    @Autowired
    private UserInterestService userInterestService;

    @Autowired
    @Resource
    private ScenicService scenicService;

    @RequestMapping(value = "/addUserInterest")
    @ResponseBody
    public JsonMsg AddUserInterest(HttpServletRequest request, Model model){
        try {
            String user_spot_id = request.getParameter("user_spot_id");
            System.out.println(user_spot_id);

            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            System.out.println(user_spot_id);
            System.out.println(df.format(date));
            Subject currentUser = SecurityUtils.getSubject();
            System.out.println("AFTER");
            System.out.println(currentUser);
            System.out.println(currentUser.toString());
            System.out.println(currentUser.isAuthenticated());
            if (!currentUser.isAuthenticated()){
                return JsonMsg.fail().addInfo("log_error", "未登录，请登录11！");
            }
            Scenic sc=scenicService.getScenicById(user_spot_id);
            String username = currentUser.getPrincipal().toString();
            System.out.println(user_spot_id);
            System.out.println(username);
            System.out.println(sc.getScenic_type());
            System.out.println(df.format(date));
            List<UserInterest> listt=userInterestService.checkIsHave(sc.getScenic_type(),username,user_spot_id);
            if(listt.size()==0) {
                userInterestService.addUser_Interest(user_spot_id, username, sc.getScenic_type(), df.format(date));
                return JsonMsg.success().addInfo("list", "TRUE");
            }
            else
            {
                userInterestService.updateUser_Interest(listt.get(0).getUser_interset_id()+"",user_spot_id, username, sc.getScenic_type(), df.format(date));
                return JsonMsg.fail().addInfo("log_error","已关注，请勿重复关注！ ");
            }
        }
        catch(Exception e)
        {
            return JsonMsg.fail().addInfo("log_error","请求出错！请重试！ "+e);
        }
    }

    @RequestMapping(value = "/selectAllUserInterByName")
    @ResponseBody
    public JsonMsg selectAllUserInterByName(HttpServletRequest request, Model model){
        try {
            String currentPage = request.getParameter("CurrentPage");
            String pageSize = request.getParameter("PageSize");
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()){
                return JsonMsg.fail().addInfo("log_error", "未登录，请登录！");
            }
            String username = currentUser.getPrincipal().toString();
            int cur = Integer.parseInt(currentPage);
            int pag = Integer.parseInt(pageSize);
           PageBean pageBean= userInterestService.selectAllUserInterByName(cur,pag,username);
            return JsonMsg.success().addInfo("pagebean",pageBean);
        }
        catch(Exception e)
        {
            return JsonMsg.fail().addInfo("log_error","请求出错！请重试！ ");
        }
    }


    @RequestMapping(value = "/deleteUserInter")
    @ResponseBody
    public JsonMsg deleteUserInter(HttpServletRequest request, Model model){
        try {
            String user_interest_id = request.getParameter("user_interest_id");
            System.out.println("---------delete");
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()){
                return JsonMsg.fail().addInfo("login_error", "未登录，请登录！");
            }

            int  temp_i= userInterestService.deleteUserInter(user_interest_id);
            return JsonMsg.success().addInfo("list",temp_i);
        }
        catch(Exception e)
        {
            return JsonMsg.fail().addInfo("log_error","请求出错！请重试！ ");
        }
    }


    @RequestMapping(value = "/PostScenicByfocus")
    @ResponseBody
    public JsonMsg PostScenicByfocus(HttpServletRequest request, Model model){
        try {
            String currentPage = request.getParameter("CurrentPage");
            String pageSize = request.getParameter("PageSize");
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()){
                return JsonMsg.fail().addInfo("log_error", "未登录，请登录！");
            }
            String username = currentUser.getPrincipal().toString();
            int cur = Integer.parseInt(currentPage);
            int pag = Integer.parseInt(pageSize);
            PageBean pageBean= userInterestService.selectAllUserInterByName(cur,pag,username);
            return JsonMsg.success().addInfo("pagebean",pageBean);
        }
        catch(Exception e)
        {
            return JsonMsg.fail().addInfo("log_error","请求出错！请重试！ ");
        }
    }




}
