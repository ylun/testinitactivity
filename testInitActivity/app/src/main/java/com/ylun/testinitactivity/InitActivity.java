package com.ylun.testinitactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class InitActivity extends Activity {

    private static final String LOG_TAG = "InitActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        launchLoginActivity();
    }

    private void launchLoginActivity(){
        new LaunchLoginTask().execute();
    }

    private class LaunchLoginTask extends AsyncTask<Void, Void, Void>{

        private static final long THREAD_SLEEP_TIME = 2000;

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(THREAD_SLEEP_TIME);
            } catch (InterruptedException e) {
                Log.e(LOG_TAG, "[doInBackground] thread sleep got exception.", e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent i = new Intent();
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setClass(InitActivity.this, LoginActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            InitActivity.this.finish();
        }
    }
}
