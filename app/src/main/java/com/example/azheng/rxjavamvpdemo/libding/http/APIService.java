package com.example.azheng.rxjavamvpdemo.libding.http;

import com.example.azheng.rxjavamvpdemo.libding.entity.GetListRsp;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Flowable  POST  Observable GET POST
 */
public interface APIService {

     String baseUrl = "http://api.zhuishushenqi.com";

    /**
     */
//    @FormUrlEncoded
//    @POST("/cats/lv2/statistics/")
//    Flowable<GetListRsp> login(@Field("username") String username,
//                               @Field("password") String password);

    /**
     * GetListRsp
     */
    @GET("/cats/lv2/statistics/")
    Observable<GetListRsp> login(@QueryMap Map<String, String> params);
}
