package com.example.jimmy_pc.ingdemo.Model;

import com.example.jimmy_pc.ingdemo.Utils.Helper.OnRequestListener;

/**
 * Created by Jimmy-PC on 11/8/2017.
 */

public interface ApiDataModel {

    /**
     *
     * This method is to retrieve images' url from remote server.
     * It is also consists of network response callback - OnSuccess & OnFailure
     *
     * @see OnRequestListener
     * @param onRequestListener
     */
    void getApiData(OnRequestListener onRequestListener);
}
