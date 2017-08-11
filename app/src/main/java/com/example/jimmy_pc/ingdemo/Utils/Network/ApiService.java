package com.example.jimmy_pc.ingdemo.Utils.Network;

/**
 * Created by Jimmy-PC on 11/8/2017.
 */


import com.example.jimmy_pc.ingdemo.Model.ApiPojo.ApiInfo;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 *
 * List down required api service details & HTTP method needed
 */
public interface ApiService {

    /**
     *
     * This is a HTTP get method to retrieve
     * @return Return observable with a list of json obj from remote server.
     */
    @GET("/bins/a9eh1")
    Observable<List<ApiInfo>> getData();
}
