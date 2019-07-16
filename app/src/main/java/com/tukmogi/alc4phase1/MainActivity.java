package com.tukmogi.alc4phase1;

import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        removeActionBarElevation();
        // changeActionBarFont();

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnAbout)
    void onClickAbout() {
        openActivity(ActivityB.class);
    }

    @OnClick(R.id.btnProfile)
    void onClickProfile() {
        openActivity(ActivityC.class);
    }

    void openActivity(Class destinationAcivity) {
        startActivity(new Intent(MainActivity.this, destinationAcivity));
    }

}
