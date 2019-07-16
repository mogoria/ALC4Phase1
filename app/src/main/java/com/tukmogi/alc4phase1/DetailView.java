package com.tukmogi.alc4phase1;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class DetailView extends CardView {

    public DetailView(Context context) {
        super(context);
        init(null, 0);
    }

    public DetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public DetailView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load from style
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.view_detail, this);
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.DetailView, defStyle, 0);

        TextView tvTitle = findViewById(R.id.title),
                tvValue = findViewById(R.id.value);
        if(a.hasValue(R.styleable.DetailView_title)) {
            String title = a.getString(R.styleable.DetailView_title);
            if (title.length()!=0 && title.charAt(title.length()-1) != ':') {
                title = title.concat(":");
            }
            tvTitle.setText(title);
        }

        if(a.hasValue(R.styleable.DetailView_value)) {
            tvValue.setText(a.getString(R.styleable.DetailView_value));
        }
        a.recycle();

    }

}
