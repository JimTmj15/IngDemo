package com.example.jimmy_pc.ingdemo.Utils.Helper;

import com.example.jimmy_pc.ingdemo.Model.ApiPojo.ApiInfo;

import java.util.List;

/**
 * Created by Jimmy-PC on 11/8/2017.
 */

public interface OnRequestListener {

    /**
     *
     * This method is to pass a list of json object back to the caller
     * function when the network return the data from server successfully.
     *
     * @see com.example.jimmy_pc.ingdemo.Model.ApiPojo.ApiInfo
     * @param apiInfo
     */
    void onSuccess(List<ApiInfo> apiInfo);

    /**
     * This method is to pass error back to the caller
     * function when the network fails to return data from server.
     *
     * @param errorMsg
     */
    void onFailure(String errorMsg);
}
