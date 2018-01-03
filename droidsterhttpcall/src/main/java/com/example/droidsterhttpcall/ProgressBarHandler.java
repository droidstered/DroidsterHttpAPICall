package com.example.droidsterhttpcall;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

/**
 * Created by Piyush on 01-11-2017.
 */
public class ProgressBarHandler {
    public static ProgressBar mProgressBar;
    public Activity mContext;

    public ProgressBarHandler(Activity context) {
        mContext = context;
        ViewGroup layout = (ViewGroup) mContext.findViewById(android.R.id.content).getRootView();

        mProgressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleLarge);

        LinearLayout.LayoutParams params_ = new LinearLayout.LayoutParams(80, 80);

        mProgressBar.setLayoutParams(params_);

        mProgressBar.setIndeterminate(true);

        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        RelativeLayout rl = new RelativeLayout(context);

        rl.setGravity(Gravity.CENTER);
        rl.addView(mProgressBar);

        layout.addView(rl, params);

        hide(mContext);
    }

    public static void show(Activity mContext) {
        mContext.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    public static void hide(Activity mContext) {
        mProgressBar.setVisibility(View.INVISIBLE);
        mContext.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    public static void showCancelableOutsideTouch(Activity mContext) {
        mProgressBar.setVisibility(View.VISIBLE);
    }
}
