package com.regalix.android.codec;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity {

    private EditText etPssd;
    private Button btEnter, btReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        etPssd = (EditText) findViewById(R.id.et_pssd);
        btEnter = (Button) findViewById(R.id.bt_enter);
        btReset = (Button) findViewById(R.id.bt_reset);
        if (AppPreference.isInstalledFirst(getApplicationContext())) {
            AppPreference.saveToAppPreference(getApplicationContext(), Constant.PASSWORD, Constant.DEFAULT_PIN);
            AppPreference.saveToAppPreference(getApplicationContext(), Constant.IS_INSTALLED_FIRST, false);
        }



    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!AppPreference.isTimerset(getApplicationContext())) {
            long time = Constant.getCurrentTime();
            long thresholdTime = (long) AppPreference.getDataFromAppPreference(getApplicationContext(), Constant.THRESHOLD_TIME, AppPreference.MODE_LONG);
            long sec = (thresholdTime - time) / 1000;
            if (time < thresholdTime) {
                showClosingDialog("" + sec);
            }

        }
    }

    private boolean validate() {
        boolean flag = true;
        if (etPssd.getText().toString().trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "You havent entered anything.", Toast.LENGTH_LONG).show();
            return false;
        }
        return flag;
    }

    private boolean Authenticate() {
        boolean flag = false;
        int pin = Integer.parseInt(etPssd.getText().toString());
        int savedPin = (int) AppPreference.getDataFromAppPreference(getApplicationContext(), Constant.PASSWORD, AppPreference.MODE_INT);
        if (pin == savedPin) {
            flag = true;
        }
        return flag;
    }

    public void onEnter(View view) {
        if (validate()) {
            if (Authenticate()) {
                startActivity(new Intent(PasswordActivity.this, MainActivity.class));
                finish();
                AppPreference.saveToAppPreference(getApplicationContext(), Constant.NO_OF_ATTEMPTS, 0);
                AppPreference.saveToAppPreference(getApplicationContext(), Constant.IS_TIMER_SET, true);
            } else {

                Toast.makeText(getApplicationContext(), "Incorrect Pin", Toast.LENGTH_SHORT).show();
                etPssd.setText("");
                int noOfAttempts = (int) AppPreference.getDataFromAppPreference(getApplicationContext(), Constant.NO_OF_ATTEMPTS, AppPreference.MODE_INT);
                if(noOfAttempts>=0&&noOfAttempts<2){
                    int ii= 2-noOfAttempts;
                    Toast.makeText(getApplicationContext(), "Only "+ii+" attempt left.", Toast.LENGTH_SHORT).show();
                }
                if (noOfAttempts >= 2) {
                    long time = Constant.getCurrentTime();
                    if (AppPreference.isTimerset(getApplicationContext())) {
                        AppPreference.saveToAppPreference(getApplicationContext(), Constant.THRESHOLD_TIME, time + 2 * Constant.MILLSEC_TO_MIN_FACTOR);
                        AppPreference.saveToAppPreference(getApplicationContext(), Constant.IS_TIMER_SET, false);
                    }
                    long thresholdTime = (long) AppPreference.getDataFromAppPreference(getApplicationContext(), Constant.THRESHOLD_TIME, AppPreference.MODE_LONG);
                    if (time < thresholdTime) {
                        Log.d(">>>>>>", "system Blocked");
                        Log.d(">>>>>>", "current time: " + time + "ThresholdTime: " + thresholdTime);
                        long sec = (thresholdTime - time) / 1000;
                        showClosingDialog("" + sec);
                    } else {
                        Log.d(">>>>>>", "system Unlock");
                        Log.d(">>>>>>", "current time: " + time + "ThresholdTime: " + thresholdTime);
                        AppPreference.saveToAppPreference(getApplicationContext(), Constant.NO_OF_ATTEMPTS, 0);
                        AppPreference.saveToAppPreference(getApplicationContext(), Constant.IS_TIMER_SET, true);

                    }
                } else {
                    noOfAttempts++;
                    AppPreference.saveToAppPreference(getApplicationContext(), Constant.NO_OF_ATTEMPTS, noOfAttempts);
                }
            }
        }


    }

    public void onReset(View view) {
        startActivity(new Intent(PasswordActivity.this, ResetActivity.class));
    }

    public void showClosingDialog(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Warning");
        builder.setCancelable(false);
        builder.setMessage("Your App has been blocked.You have tried maximum attempts.Please try after " + msg + " seconds.");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Constant.killApp();
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Constant.killApp();
            }
        });
        builder.show();
    }
}
