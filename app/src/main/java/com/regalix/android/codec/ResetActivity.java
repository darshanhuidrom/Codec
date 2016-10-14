package com.regalix.android.codec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetActivity extends AppCompatActivity {

    EditText etCurPssd, etNewPssd;
    Button btDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        etCurPssd = (EditText) findViewById(R.id.et_current_password);
        etNewPssd = (EditText) findViewById(R.id.et_new_password);
        btDone = (Button) findViewById(R.id.bt_done);
    }

    public void onDone(View view) {
        if (validateField()) {
            if (validate()) {
                int pin = Integer.parseInt(etNewPssd.getText().toString().trim());
                AppPreference.saveToAppPreference(getApplicationContext(), Constant.PASSWORD, pin);
                Toast.makeText(getApplicationContext(), "New Pin Changed Successfully.", Toast.LENGTH_LONG).show();
                finish();

            } else {
                etCurPssd.setError("Incorrect Pin");
            }
        }

    }

    private boolean validate() {
        boolean flag = false;
        int pin = Integer.parseInt(etCurPssd.getText().toString());
        int savedPin = (int) AppPreference.getDataFromAppPreference(getApplicationContext(), Constant.PASSWORD, AppPreference.MODE_INT);
        if (pin == savedPin) {
            flag = true;
        }
        return flag;
    }

    private boolean validateField() {
        boolean flag = true;
        if (etCurPssd.getText().toString().trim().isEmpty() || etNewPssd.getText().toString().trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "There is a missing field", Toast.LENGTH_LONG).show();
            return false;
        } else if (etCurPssd.getText().toString().trim().length() < 4) {
            Toast.makeText(getApplicationContext(), "Pin should have atleast 4 digits.", Toast.LENGTH_LONG).show();
            return false;
        }
        return flag;
    }
}
