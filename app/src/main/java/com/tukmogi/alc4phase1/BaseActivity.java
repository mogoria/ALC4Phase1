package com.tukmogi.alc4phase1;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public abstract class BaseActivity extends AppCompatActivity {
    ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getSupportActionBar();
    }

    void changeActionBarFont() {
        if(actionBar!=null) {
            CharSequence mTitle = actionBar.getTitle();
            Typeface mTypeFace = ResourcesCompat.getFont(getApplicationContext(), R.font.lato);
            SpannableString s = new SpannableString(mTitle);
            s.setSpan(new TypefaceSpan(mTypeFace), 0, s.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            // Update the action bar title with the TypefaceSpan instance
            actionBar.setTitle(s);
        }
    }

    void removeActionBarElevation() {
        if(actionBar!=null) {
            actionBar.setElevation(0);
        }
    }
}
