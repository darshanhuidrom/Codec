package com.regalix.android.codec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PasswordActivity extends AppCompatActivity {

    private EditText etPssd;
    private Button btEnter,btReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        etPssd= (EditText) findViewById(R.id.et_pssd);
        btEnter= (Button) findViewById(R.id.bt_enter);
        btReset= (Button) findViewById(R.id.bt_reset);
        if(AppPreference.isInstalledFirst(getApplicationContext())){
            AppPreference.saveToAppPreference(getApplicationContext(),Constant.PASSWORD,Constant.DEFAULT_PIN);
        }

    }

    private boolean validate(){
        boolean flag=false;
        int pin = Integer.parseInt(etPssd.getText().toString());
        int savedPin= (int) AppPreference.getDataFromAppPreference(getApplicationContext(),Constant.PASSWORD,AppPreference.MODE_INT);
        if(pin==savedPin){
            flag=true;
        }
        return flag;
    }

    public void onEnter(View view){
        if(validate()){
            startActivity(new Intent(PasswordActivity.this,MainActivity.class));
            finish();
        }
        else {

            etPssd.setError("Invalid Pin");
        }

    }

    public void onReset(View view){
        startActivity(new Intent(PasswordActivity.this,ResetActivity.class));
    }
}
