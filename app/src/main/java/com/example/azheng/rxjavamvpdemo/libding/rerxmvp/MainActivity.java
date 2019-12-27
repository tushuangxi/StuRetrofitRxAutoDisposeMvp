package com.example.azheng.rxjavamvpdemo.libding.rerxmvp;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.widget.Toast;
import com.example.azheng.rxjavamvpdemo.R;
import com.example.azheng.rxjavamvpdemo.libding.entity.GetListRsp;
import com.example.azheng.rxjavamvpdemo.libding.http.ServiceMapParams;
import com.example.azheng.rxjavamvpdemo.libding.rerxmvp.base.BaseMvpActivity;
import com.example.azheng.rxjavamvpdemo.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.example.azheng.rxjavamvpdemo.libding.rerxmvp.presenter.MainPresenter;
import com.example.azheng.rxjavamvpdemo.libding.util.ProgressDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements interfaceUtilsAll.IBaseView {

    @BindView(R.id.et_username_login)
    TextInputEditText etUsernameLogin;
    @BindView(R.id.et_password_login)
    TextInputEditText etPasswordLogin;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);

    }

    /**
     * @return 帐号
     */
    private String getUsername() {
        return etUsernameLogin.getText().toString().trim();
    }

    /**
     * @return 密码
     */
    private String getPassword() {
        return etPasswordLogin.getText().toString().trim();
    }

    @Override
    public void onSuccess(GetListRsp bean) {

        Toast.makeText(this, bean.getFemale().iterator().next().getName(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showLoading() {
        ProgressDialog.getInstance().show(this);
    }

    @Override
    public void hideLoading() {
        ProgressDialog.getInstance().dismiss();
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_signin_login)
    public void onViewClicked() {
//        if (getUsername().isEmpty() || getPassword().isEmpty()) {
//            Toast.makeText(this, "帐号密码不能为空", Toast.LENGTH_SHORT).show();
//            return;
//        }
        mPresenter.login(ServiceMapParams.getGetListRspMapParams());
    }
}
