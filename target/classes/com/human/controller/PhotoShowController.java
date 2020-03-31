package com.human.controller;

import com.human.dao.ScenicDetailImgDao;
import com.human.model.ScenicDetailImg;
import com.human.service.ScenicDetailImgService;
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
@RequestMapping(value = "/Photo")
public class PhotoShowController {

    @Resource
    private ScenicDetailImgService scenicDetailImgService;

    @RequestMapping(value = "/ShowScenicDetailImg")
    @ResponseBody
    public JsonMsg ShowScenicDetailImg(HttpServletRequest request)
    {
        try {
            List<ScenicDetailImg> list = scenicDetailImgService.getScenic_DetailImg();
            return JsonMsg.success().addInfo("list", list);
        }
        catch (Exception e)
        {
            return JsonMsg.fail().addInfo("error_info",e+"返回失败");
        }
    }

    @RequestMapping(value = "/ShowScenicDetailImgAd")
    @ResponseBody
    public JsonMsg ShowScenicDetailImgAd(HttpServletRequest request)
    {
        try {
            List<ScenicDetailImg> list = scenicDetailImgService.getScenic_DetailImgAd();
            return JsonMsg.success().addInfo("list", list);
        }
        catch (Exception e)
        {
            return JsonMsg.fail().addInfo("error_info",e+"返回失败");
        }
    }

    @RequestMapping(value = "/ShowScenicDetailImgByScenic_Id")
    @ResponseBody
    public JsonMsg ShowScenicDetailImgByScenic_Id(HttpServletRequest request, Model model)
    {
        try {
            String type = request.getParameter("S_ID");
            List<ScenicDetailImg> list = scenicDetailImgService.selectScenicDetailImgByScenic_Id(type);
            return JsonMsg.success().addInfo("list", list);
        }
        catch (Exception e)
        {
            return JsonMsg.fail().addInfo("error_info",e+"返回失败");
        }
    }

    @RequestMapping(value = "/ShowScenicDetailImgByScenic_Id_SP")
    @ResponseBody
    public JsonMsg ShowScenicDetailImgByScenic_Id_SP(HttpServletRequest request, Model model)
    {
        try {
            String type = request.getParameter("S_ID");
            List<ScenicDetailImg> list = scenicDetailImgService.selectScenicDetailImgByScenic_Id_SP(type);
            return JsonMsg.success().addInfo("list", list);
        }
        catch (Exception e)
        {
            return JsonMsg.fail().addInfo("error_info",e+"返回失败");
        }
    }

}
