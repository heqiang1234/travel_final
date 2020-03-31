package com.human.controller;


import com.human.dao.ScenicDetailDao;
import com.human.model.Scenic;
import com.human.model.ScenicDetail;
import com.human.service.ScenicDetailService;
import com.human.util.JsonMsg;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/ScenicDetail")
public class ScenicDetailController {

    @Resource
    private ScenicDetailService scenicDetailService;


    @RequestMapping(value = "/showScenicDetail")
    @ResponseBody
    public JsonMsg getScenic_DetailByScenic_Id(HttpServletRequest request, Model model)
    {
     //   List<Scenic> sc= null;
        ScenicDetail sc=new ScenicDetail();
        try {
            String S_ID = request.getParameter("S_ID");
            sc = scenicDetailService.getScenic_DetailByScenic_Id(S_ID);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return JsonMsg.success().addInfo("pagebean",sc);
    }

}
