package com.example.boombz.myapplication.Modules;

import java.util.List;


/**
 * Created by boombz on 23/09/16.
 */
public interface DirectionFinderListener {
    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);

}
