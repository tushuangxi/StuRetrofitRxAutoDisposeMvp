package com.example.azheng.rxjavamvpdemo.libding.rerxmvp.presenter;

import com.example.azheng.rxjavamvpdemo.libding.entity.GetListRsp;
import com.example.azheng.rxjavamvpdemo.libding.rerxmvp.base.BasePresenter;
import com.example.azheng.rxjavamvpdemo.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.example.azheng.rxjavamvpdemo.libding.rerxmvp.model.MainModel;
import com.example.azheng.rxjavamvpdemo.libding.http.manage.RxScheduler;

import java.util.Map;

import io.reactivex.functions.Consumer;

public class MainPresenter extends BasePresenter<interfaceUtilsAll.IBaseView> implements interfaceUtilsAll.Presenter {

    private interfaceUtilsAll.Model model;

    public MainPresenter() {
        model = new MainModel();
    }

    @Override
    public void login(Map<String, String> params) {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.login(params)
                .compose(RxScheduler.<GetListRsp>Obs_io_main())
                .as(mView.<GetListRsp>bindAutoDispose())
                .subscribe(new Consumer<GetListRsp>() {
                    @Override
                    public void accept(GetListRsp bean) throws Exception {
                        mView.onSuccess(bean);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }

}
