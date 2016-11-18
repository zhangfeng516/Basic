package com.meikoz.basic.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.meikoz.basic.R;
import com.meikoz.basic.presenter.MainLogicI;
import com.meikoz.core.base.BaseActivity;
import com.meikoz.core.ui.SweetAlertDialog;

public class MainActivity extends BaseActivity implements MainLogicI.MainView {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void onInitView(Bundle bundle) {
        findViewById(R.id.main_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.app_name)
                        .setMessage("您确定要删除此品牌么?")
                        .setCancelable(false)
                        .setPositiveButton("确认", new SweetAlertDialog.OnDialogClickListener() {
                            @Override
                            public void onClick(Dialog dialog, int which) {
                                Toast.makeText(MainActivity.this, "确定操作" + which, Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    protected Class getLogicClazz() {
        return MainLogicI.class;
    }

    @Override
    protected void onInitData2Remote() {
        super.onInitData2Remote();
    }

    @Override
    public void onLoadSuccessHandler(String responce) {

    }
}
