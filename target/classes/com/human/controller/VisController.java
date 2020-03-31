package com.human.controller;

import com.human.model.eChartsData;
import com.human.model.eChartsDataScenicNW;
import com.human.service.eChartsDataService;
import com.human.util.JsonMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/eChartsData")
public class VisController {

    private static final Logger log = LoggerFactory.getLogger(VisController.class);

    @Resource
    private eChartsDataService eChartsDataService;

    /**
     *
     * echarts获取经纬度和数量生成  热力图数据
     * @param request
     * @return
     */
    @RequestMapping(value = "/ShowScenicNW")
    @ResponseBody
    public JsonMsg ShowScenicNW(HttpServletRequest request)
    {
        try {
            log.info("echarts获取经纬度和数量生成 热力图数据");
            List<eChartsDataScenicNW> result_list= eChartsDataService.ShowScenicNW();
            return JsonMsg.success().addInfo("result_list",result_list);
        }
        catch (Exception e)
        {
            return JsonMsg.fail().addInfo("log_error",e+"查询失败");
        }

    }

    /**
     *
     * echarts
     * 获取top20的景点名称和访问量
     * @param request
     * @return
     */
    @RequestMapping(value = "/ShowTopScenic")
    @ResponseBody
    public JsonMsg ShowTopScenic(HttpServletRequest request)
    {
        try {
            log.info("echarts获取top20的景点名称和访问量");
            List<eChartsData> result_list= eChartsDataService.ShowTopScenic();
            return JsonMsg.success().addInfo("result_list",result_list);
        }
        catch (Exception e)
        {
            return JsonMsg.fail().addInfo("log_error",e+"查询失败");
        }

    }

    /**
     *
     * echarts
     * 获取top20的景点名称和访问量
     * @param request
     * @return
     */
    @RequestMapping(value = "/ShowTopScenicCity")
    @ResponseBody
    public JsonMsg ShowScenicCity(HttpServletRequest request)
    {
        try {
            log.info("echarts获取top的景点所在地区和数量");
            List<eChartsData> result_list= eChartsDataService.ShowScenicCity();
            return JsonMsg.success().addInfo("result_list",result_list);
        }
        catch (Exception e)
        {
            return JsonMsg.fail().addInfo("log_error",e+"查询失败");
        }

    }


    /**
     *
     * echarts
     * 获echarts获取top的景点类型数目
     * @param request
     * @return
     */
    @RequestMapping(value = "/ShowScenicType")
    @ResponseBody
    public JsonMsg ShowScenicType(HttpServletRequest request)
    {
        try {
            log.info("echarts获取top的景点类型数目");
            List<eChartsData> result_list= eChartsDataService.ShowScenicType();
            return JsonMsg.success().addInfo("result_list",result_list);
        }
        catch (Exception e)
        {
            return JsonMsg.fail().addInfo("log_error",e+"查询失败");
        }

    }


}
