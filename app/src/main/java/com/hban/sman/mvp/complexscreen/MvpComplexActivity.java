package com.hban.sman.mvp.complexscreen;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hban.sman.R;
import com.hban.sman.mvp.base.MvpBaseActivity;
import com.hban.sman.mvp.data.LoginUser;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhuchuntao on 16-11-18.
 */

public class MvpComplexActivity extends MvpBaseActivity<ComplexPresenter> implements IComplexView {


    @BindView(R.id.complex_login)
    TextView complexLogin;
    @BindView(R.id.complex_all)
    TextView complexAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complex_mvp_layout);
        ButterKnife.bind(this);
        getPresenter().sendRequestList();
        getPresenter().sendRequestLoginUser();
    }

    @Override
    public ComplexPresenter createPresenter() {
        return new ComplexPresenter(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().destroy();
    }

    @Override
    public void showHint(String hint) {
        Toast.makeText(this, hint, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUserList(List<LoginUser> userList) {
        String info="";
        for(LoginUser user:userList){
            info+=user.getUserName()+" "+user.getUserPassword()+"\n";
        }
        complexAll.setText(info);
    }

    @Override
    public void setLoginUser(LoginUser user) {
        complexLogin.setText(user.getUserName()+" "+user.getUserPassword());
    }

    @OnClick(R.id.complex_back)
    public void onClick() {
        finish();
    }
}
