package com.ylun.testinitactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Lun on 2016/4/9.
 */
public class LoginActivity extends Activity {

    private static final String LOG_TAG = "LoginActivity";
    private ViewGroup mMainView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainView = createView();
        if(mMainView == null){
            Log.e(LOG_TAG, "[onCreate] mMainView is null");
            return;
        }
        setContentView(mMainView);
    }

    private ViewGroup createView(){
        RelativeLayout rl = new RelativeLayout(this);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        rl.setLayoutParams(lp);
        TextView tv = new TextView(this);
        tv.setGravity(Gravity.CENTER);
        tv.setLayoutParams(lp);
        tv.setText(LOG_TAG);
        rl.addView(tv);
        return rl;
    }
}
