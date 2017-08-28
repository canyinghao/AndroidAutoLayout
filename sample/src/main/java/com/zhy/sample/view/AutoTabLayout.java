package com.zhy.sample.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by zhy on 16/3/3.
 */
public class AutoTabLayout extends TabLayout {


    public AutoTabLayout(Context context) {
        this(context, null);
    }

    public AutoTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AutoTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    @Override
    public void addTab(@NonNull Tab tab, int position, boolean setSelected) {
        super.addTab(tab, position, setSelected);
        setUpTabTextSize(tab);
    }

    @Override
    public void addTab(@NonNull Tab tab, boolean setSelected) {
        super.addTab(tab, setSelected);
        setUpTabTextSize(tab);
    }

    private void setUpTabTextSize(Tab tab) {


        ViewGroup tabGroup = (ViewGroup) getChildAt(0);
        ViewGroup tabContainer = (ViewGroup) tabGroup.getChildAt(tab.getPosition());
        TextView textView = (TextView) tabContainer.getChildAt(1);


        if (AutoUtils.autoed(textView)) {
            return;
        }
        int autoTextSize = 0;


        autoTextSize = AutoUtils.getPercentWidthSize(30);

        Log.e("xxxx","autoTextSize"+autoTextSize);

        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, autoTextSize);
    }


}
