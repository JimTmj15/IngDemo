package com.example.jimmy_pc.ingdemo.Model;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.jimmy_pc.ingdemo.Model.ApiPojo.ApiInfo;
import com.example.jimmy_pc.ingdemo.Utils.Helper.OnRequestListener;
import com.example.jimmy_pc.ingdemo.Utils.Network.RetrofitClient;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jimmy-PC on 11/8/2017.
 */

public class ApiDataImpl implements ApiDataModel {

    /**
     * Define necesseary paramas
     */
    private OnRequestListener mOnRequestListener;
    RetrofitClient retrofitClient;

    public ApiDataImpl(Context context){
        retrofitClient = new RetrofitClient(context);
    }

    /**
     *
     * This method attempts to prompt data from remote server and
     * return the results obtained via OnRequesListener to
     * caller class.
     *
     * @see OnRequestListener
     * @param onRequestListener
     */
    @Override
    public void getApiData(OnRequestListener onRequestListener) {
        mOnRequestListener = onRequestListener;

        Observable<List<ApiInfo>> networkReq = retrofitClient.apiServiceCall().getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()); //Return the result to main thread

        networkReq.subscribe(new Observer<List<ApiInfo>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
            }

            @Override
            public void onNext(@NonNull List<ApiInfo> apiInfos) {
                mOnRequestListener.onSuccess(apiInfos);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mOnRequestListener.onFailure(e.toString());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}