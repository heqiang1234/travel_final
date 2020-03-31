package com.human.service;

import com.human.model.eChartsData;
import com.human.model.eChartsDataScenicNW;

import java.util.List;

public interface eChartsDataService {

    public List<eChartsData> ShowTopScenic();

    public List<eChartsData> ShowScenicCity();

    public List<eChartsData> ShowScenicType();

    public List<eChartsDataScenicNW> ShowScenicNW();


}
