package com.regalix.android.codec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
            AppPreference.saveToAppPreference(getApplicationContext(),Constant.IS_INSTALLED_FIRST,false);
        }


    }

    private boolean validate(){
        boolean flag=true;
        if(etPssd.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(),"You havent entered anything.",Toast.LENGTH_LONG).show();
            return false;
        }
        return flag;
    }

    private boolean Authenticate(){
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
            if(Authenticate()){
                startActivity(new Intent(PasswordActivity.this,MainActivity.class));
                finish();
            }
            else {

                Toast.makeText(getApplicationContext(),"Incorrect Pin",Toast.LENGTH_LONG).show();
            }
        }


    }

    public void onReset(View view){
        startActivity(new Intent(PasswordActivity.this,ResetActivity.class));
    }
}
