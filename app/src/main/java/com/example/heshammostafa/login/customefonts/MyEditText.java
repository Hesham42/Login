package com.example.heshammostafa.login.customefonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by Hesham Mostafa on 7/2/2017.
 */

public class MyEditText extends android.support.v7.widget.AppCompatEditText {
    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public MyEditText(Context context) {
        super(context);
        init();

    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "font/Lato-Light.ttf");
            setTypeface(tf);
        }
    }

}

