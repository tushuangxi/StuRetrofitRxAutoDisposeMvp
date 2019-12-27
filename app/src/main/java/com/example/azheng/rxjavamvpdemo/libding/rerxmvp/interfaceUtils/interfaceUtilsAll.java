package com.example.azheng.rxjavamvpdemo.libding.rerxmvp.interfaceUtils;

import com.example.azheng.rxjavamvpdemo.libding.entity.GetListRsp;
import com.example.azheng.rxjavamvpdemo.libding.rerxmvp.base.BaseView;

import java.util.Map;

import io.reactivex.Observable;

public interface interfaceUtilsAll {
    interface Model {
        Observable<GetListRsp> login(Map<String, String> params);
    }

    interface IBaseView extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(GetListRsp bean);
    }

    interface Presenter {
        /**
         * 登陆
         */
        void login(Map<String, String> params);
    }
}
