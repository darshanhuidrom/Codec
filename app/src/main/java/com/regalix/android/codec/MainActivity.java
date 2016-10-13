package com.regalix.android.codec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvOutput;
    private EditText etInput;
    private Button btCodec;
    private static final String ENCODE = "Encode";
    private static final String DECODE = "Decode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput = (EditText) findViewById(R.id.et_input);
        tvOutput = (TextView) findViewById(R.id.tv_output);
        btCodec = (Button) findViewById(R.id.bt_codec);
        etInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {


                String txt = s.toString();
                String extCodes;
                try {
                    extCodes = txt.substring(txt.length() - 8, txt.length());
                    if (extCodes.equals(Decoder.CODE_ID)) {
                        btCodec.setText(DECODE);
                    } else {
                        btCodec.setText(ENCODE);
                    }
                } catch (Exception e) {
                    Log.d(">>>>>>", "crash at afterTextChanged");
                }
            }
        });

    }

    public void onCodec(View view) {
        if (btCodec.getText().toString().equals(DECODE)) {
            tvOutput.setText(Decoder.decode(etInput.getText().toString()));
        } else if (btCodec.getText().toString().equals(ENCODE)) {
            tvOutput.setText(Encoder.encode(etInput.getText().toString()));
        }
        //   tvOutput.setText(Encoder.encode(etInput.getText().toString()));
        // tvOutput.setText(Decoder.decode(etInput.getText().toString()));

        // n~`vu`qxt~G` ~`e~rg`l~urQ`
    }

}
