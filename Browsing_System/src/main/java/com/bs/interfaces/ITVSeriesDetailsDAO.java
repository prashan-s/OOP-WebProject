package com.bs.interfaces;

import java.util.List;
import com.bs.model.TVSeriesDetails;

public interface ITVSeriesDetailsDAO {

    List<TVSeriesDetails> selectTVSeries(int series_id);
    void insertTVSeries(TVSeriesDetails series);
    boolean updateTVSeries(TVSeriesDetails series);
    boolean deleteTVSeries(int series_id);
}
