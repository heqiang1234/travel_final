package com.human.controller;

import com.human.model.PageBean;
import com.human.model.Scenic;
import com.human.model.UserInterest;
import com.human.service.BrowseRecordService;
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
@RequestMapping(value = "/browseRecord")
public class BrowseRecordController {

    @Resource
    @Autowired
    private BrowseRecordService browseRecordService;

    @Autowired
    @Resource
    private ScenicService scenicService;

    @RequestMapping(value = "/addBrowseRecord")
    @ResponseBody
    public JsonMsg addBrwowseRecord(HttpServletRequest request, Model model){
        try {
            String scenic_spot_id = request.getParameter("scenic_spot_id");
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()){
                return JsonMsg.fail().addInfo("log_error", "未登录，请登录！");
            }
            Scenic sc=scenicService.getScenicById(scenic_spot_id);
            String username = currentUser.getPrincipal().toString();
            browseRecordService.addBrowseRecord(scenic_spot_id, username, df.format(date));
                return JsonMsg.success().addInfo("list", "TRUE");
        }
        catch(Exception e)
        {
            return JsonMsg.fail().addInfo("log_error","请求出错！请重试！ "+e);
        }
    }

    @RequestMapping(value = "/selectAllBrowseRecordByName")
    @ResponseBody
    public JsonMsg selectAllBrwowseRecordByName(HttpServletRequest request, Model model){
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
           PageBean pageBean= browseRecordService.selectAllBrowseRecordByName(cur,pag,username);
            return JsonMsg.success().addInfo("pagebean",pageBean);
        }
        catch(Exception e)
        {
            return JsonMsg.fail().addInfo("log_error","请求出错！请重试！ "+e);
        }
    }


    @RequestMapping(value = "/deleteBrowseRecord")
    @ResponseBody
    public JsonMsg deleteBrwowseRecord(HttpServletRequest request, Model model){
        try {
            String record_id = request.getParameter("record_id");
            System.out.println("---------delete    "+record_id);
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()){
                return JsonMsg.fail().addInfo("login_error", "未登录，请登录！");
            }

            int  temp_i= browseRecordService.deleteBrowseRecord(record_id);
            return JsonMsg.success().addInfo("list",temp_i);
        }
        catch(Exception e)
        {
            return JsonMsg.fail().addInfo("log_error","请求出错！请重试！ ");
        }
    }
    @RequestMapping(value = "/deleteAllBrowseRecord")
    @ResponseBody
    public JsonMsg deleteAllBrwowseRecord(HttpServletRequest request, Model model){
        try {
           // String record_username = request.getParameter("record_username");
            System.out.println("---------delete");
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()){
                return JsonMsg.fail().addInfo("login_error", "未登录，请登录！");
            }
            String username = currentUser.getPrincipal().toString();
            int  temp_i= browseRecordService.deleteAllBrowseRecord(username);
            return JsonMsg.success().addInfo("list",temp_i);
        }
        catch(Exception e)
        {
            return JsonMsg.fail().addInfo("log_error","请求出错！请重试！ ");
        }
    }



}
