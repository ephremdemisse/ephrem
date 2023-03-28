package com.example.bmical;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt1 = findViewById(R.id.Height);
        TextView txt2 = findViewById(R.id.Weight);
        TextView out = findViewById(R.id.BMI);
        Button bt1 = findViewById(R.id.Btn1);
        Button bt2 = findViewById(R.id.Btn2);

        String text1 = txt1.getText().toString();
        String text2 = txt1.getText().toString();

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText("");
            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt2.setText("");
            }
        });
//        txt2.setOnContextClickListener(v -> {
//
//            return true;
//        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.setText("");
                boolean error = false;
                if(TextUtils.isDigitsOnly(text1) && TextUtils.isDigitsOnly(text2)){
                    float text11 = Float.parseFloat(text1);
                    float text22 = Float.parseFloat(text2) / 100;
                    float total = text11 / (text22 * text22);
                    out.setText(total + "");
                }
                else if(!TextUtils.isDigitsOnly(text1) && !TextUtils.isDigitsOnly(text2)) {
                    Toast.makeText(getApplicationContext(), "Please insert the numbers correctly", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {out.setText("BMI");
                txt1.setText("Height (cm)");
                txt2.setText("Weight(Kg)");
                out.setText("BMI");
            }
        });

    }
}