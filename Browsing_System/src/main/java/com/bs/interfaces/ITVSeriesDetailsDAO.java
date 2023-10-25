package com.bs.interfaces;

import java.util.List;
import com.bs.model.TVSeriesDetails;

public interface ITVSeriesDetailsDAO {

    List<TVSeriesDetails> selectTVSeriesDetails(int series_id);
    boolean insertTVSeriesDetails(TVSeriesDetails series);
    boolean updateTVSeriesDetails(TVSeriesDetails series);
    boolean deleteTVSeriesDetails(int series_id);
}
