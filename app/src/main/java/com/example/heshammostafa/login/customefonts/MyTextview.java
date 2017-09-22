package com.example.heshammostafa.login.customefonts;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Hesham Mostafa on 7/2/2017.
 */

public class MyTextview extends android.support.v7.widget.AppCompatTextView {
    public MyTextview(Context context) {
        super(context);
        init();
    }


    public MyTextview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public MyTextview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }


    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "font/Lato-Light.ttf");
            setTypeface(tf);
        }
    }

}
