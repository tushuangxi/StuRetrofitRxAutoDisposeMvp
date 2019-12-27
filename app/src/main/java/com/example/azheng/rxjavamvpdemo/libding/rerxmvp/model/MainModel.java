package com.example.azheng.rxjavamvpdemo.libding.rerxmvp.model;

import com.example.azheng.rxjavamvpdemo.libding.entity.GetListRsp;
import com.example.azheng.rxjavamvpdemo.libding.http.manage.RetrofitClient;
import com.example.azheng.rxjavamvpdemo.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;

import java.util.Map;

import io.reactivex.Observable;


public class MainModel  implements interfaceUtilsAll.Model {
//    @Override
//    public Flowable<GetListRsp> login(String username, String password) {
//        return RetrofitClient.getInstance().getApi().login(username,password);
//    }

    @Override
    public Observable<GetListRsp> login(Map<String, String> params) {
        return RetrofitClient.getInstance().getApi().login(params);
    }
}
