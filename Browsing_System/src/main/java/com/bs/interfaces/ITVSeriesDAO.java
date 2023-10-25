package com.bs.interfaces;

import java.util.List;
import com.bs.model.TVSeries;

public interface ITVSeriesDAO {

    List<TVSeries> selectTVSeries(int seriesId);
    public boolean insertTVSeries(TVSeries series);
    public boolean updateTVSeries(TVSeries series);
    public boolean deleteTVSeries(int seriesId);
}

