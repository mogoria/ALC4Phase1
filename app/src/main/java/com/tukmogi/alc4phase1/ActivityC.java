package com.tukmogi.alc4phase1;

import android.os.Bundle;

public class ActivityC extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        removeActionBarElevation();
        // changeActionBarFont();
    }
}
