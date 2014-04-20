package com.example.myapplication2.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication2.services.ServiceDemo;


public class LoginActivity extends ActionBarActivity {


    private final String TAG = this.getClass().getName();
    boolean isExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        Log.d(TAG, "onCreate...");
        startService(new Intent(ServiceDemo.ACTION));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

                @Override
                public boolean onOptionsItemSelected(MenuItem item) {
                    // Handle action bar item clicks here. The action bar will
                    // automatically handle clicks on the Home/Up button, so long
                    // as you specify a parent activity in AndroidManifest.xml.
                    int id = item.getItemId();
                    if (id == R.id.action_settings) {
//            Intent intent = new Intent(this, SettingsActivity.class);
                        Intent intent = new Intent(this, SettingsActivity.class);
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    }
                    if (id == R.id.test_scrollview) {
//            Intent intent = new Intent(this, SettingsActivity.class);
                        Intent intent = new Intent(this, Test_ScrollView.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
            }
        return super.onOptionsItemSelected(item);
    }

    public void onLogin(View view) {
        System.out.println("Login button clicked.");

//
        Intent intent = new Intent(this, ResultActivity.class);
        Log.d(TAG, "Going to get widget value");


        String username = ((TextView) findViewById(R.id.username)).getText().toString();
        String password = ((TextView) findViewById(R.id.password)).getText().toString();
        Log.d(TAG, "username:" + username);
        Log.d(TAG, "password:" + password);
        intent.putExtra("username", username);
        intent.putExtra("password", password);

//        intent.putExtra("username",username);
//        intent.putExtra("password",password);
        startActivity(intent);

        //Ev1.setText(strTmp);
    }

//
//    public void clickMenuSettings(MenuItem menuItem) {
//        Log.d(TAG, "settings....");
//
//    }

    public void makePhoneCall(View view) {

        Uri uri = Uri.parse("tel:12345678901234");

        Intent intent = new Intent(Intent.ACTION_CALL, uri);

        startActivity(intent);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!isExit) {
                isExit = true;
                Toast.makeText(getApplicationContext(), R.string.RepeatBackKeyToExit, Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        isExit = false;
                    }
                }, 2000);
                ;
                return false;
            }
        }

        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart...");
    }
}
