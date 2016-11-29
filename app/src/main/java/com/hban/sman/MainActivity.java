package com.hban.sman;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.TextView;

import com.hban.sman.data.Drug;
import com.hban.sman.mvpp.MvppActivity;
import com.hban.sman.scan.WeChatCaptureActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import db.DBManager;

public class MainActivity extends Activity {

    @BindView(R.id.main_text)
    TextView mainText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.main_text)
    public void onClick() {
        Intent a = new Intent(this, MvppActivity.class);
        startActivity(a);
        DBManager dbManager=DBManager.getInstance(this);
        for (int i = 0; i < 5; i++) {
            Drug drug = new Drug();
            drug.setDrugName("testName"+i);
            drug.setDrugCode("testCode"+i);
            dbManager.insertUser(drug);
        }
        List<Drug> userList = dbManager.queryUserList();
        for (Drug drug : userList) {
            Log.e("TAG", "queryUserList--before-->" + drug.getDrugCode()+ "--" + drug.getDrugName());
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.main_qr)
    public void onQRClick() {
        Intent a = new Intent(this, WeChatCaptureActivity.class);
        startActivity(a);
    }
}
