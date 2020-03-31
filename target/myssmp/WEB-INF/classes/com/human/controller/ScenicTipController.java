package com.human.controller;


import com.human.model.Scenic;
import com.human.model.ScenicDetailTip;
import com.human.service.ScenicDetailTipService;
import com.human.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/ScenicTip")
public class ScenicTipController {

    @Resource
    private ScenicDetailTipService scenicDetailTipService;

    @RequestMapping(value = "/showScenicTip")
    @ResponseBody
    public JsonMsg showScenic(HttpServletRequest request, Model model)
    {
        List<ScenicDetailTip> sc= null;
        try {
            String S_SIGN = request.getParameter("S_SIGN");
            String S_ID = request.getParameter("S_ID");
            sc = scenicDetailTipService.selectAllTipByScenic_Id(S_SIGN,S_ID);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return JsonMsg.success().addInfo("pagebean",sc);
    }
}
