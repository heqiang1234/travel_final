package com.human.service.impl;

import com.human.dao.eChartsDataDao;
import com.human.model.eChartsData;
import com.human.model.eChartsDataScenicNW;
import com.human.service.eChartsDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class eChartsDataServiceImpl implements eChartsDataService {

    @Resource
    private eChartsDataDao eChartsDataDao;

    @Override
    public List<eChartsDataScenicNW> ShowScenicNW()
    {
     List<eChartsData> temp_ec=eChartsDataDao.ShowScenicNW();
     List<eChartsDataScenicNW> res=new ArrayList<>();
        for (int i = 0; i < temp_ec.size(); i++) {
            eChartsDataScenicNW top_c=new eChartsDataScenicNW();
            String[] splitlatlong=temp_ec.get(i).getValue_name().split(",");
            top_c.setLongitude(splitlatlong[0]);
            top_c.setLatitude(splitlatlong[1]);
            top_c.setValuenum(temp_ec.get(i).getVaule());
            res.add(top_c);
        }
     return res;
    }

    @Override
    public List<eChartsData> ShowTopScenic()
    {
        return eChartsDataDao.ShowTopScenic();
    }

    @Override
    public List<eChartsData> ShowScenicCity() {
        return eChartsDataDao.ShowScenicCity();
    }
    @Override
    public List<eChartsData> ShowScenicType() {
        return eChartsDataDao.ShowScenicType();
    }


}
