package com.human.dao;

import com.human.model.eChartsData;

import java.util.List;

public interface eChartsDataDao {

    public List<eChartsData> ShowTopScenic();

    public List<eChartsData> ShowScenicNW();

    public List<eChartsData> ShowScenicCity();

    public List<eChartsData> ShowScenicType();
}
