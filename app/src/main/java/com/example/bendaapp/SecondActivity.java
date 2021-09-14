package com.example.bendaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class SecondActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button btn02;
    private int number;
    private TextView showTxt;
    private LinearLayout linearLayout;
    private static final String TAG2 = SecondActivity.class.getSimpleName();
    public static final String BUNDLE_MSG_2 = "com.example.myapplication.extra.BUNDLE_MSG";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent incomingIntent = getIntent();
        String msgFromFirst = incomingIntent.getStringExtra(MainActivity.BUNDLE_MSG);
        textView = findViewById(R.id.name_out_id);
        editText = findViewById(R.id.inputdata_id);
        showTxt = findViewById(R.id.playtxt_id);
        //number= Integer.parseInt(editText.getText().toString());
        textView.setText(msgFromFirst);
        btn02 = findViewById(R.id.sendbtn_id);
        linearLayout = findViewById(R.id.seclayout);
    }

    public void passNum(View view) {
        number = Integer.parseInt(editText.getText().toString());
        if (number > 0 && number < 5) {
            createLayoutDynamically(number);
        } else {
            Toast.makeText(SecondActivity.this, getString(R.string.input_not_valid), Toast.LENGTH_LONG).show();
        }
    }
    private void createLayoutDynamically(Integer number) {
        LinearLayoutCompat.LayoutParams myBtnLayoutParams = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        for (int i = 0; i < number; i++) {
            Button myBtn = new Button(this);
            myBtn.setText("Choose Me !");
            myBtn.setId(i);
            myBtn.setLayoutParams(myBtnLayoutParams);
            myBtnLayoutParams.setMargins(0, 10, 0, 5);
            Random random = new Random();
            final int color = (Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            myBtn.setBackgroundColor(color);
            final int id_ = myBtn.getId();
            linearLayout.addView(myBtn);
            myBtnLayoutParams.gravity = Gravity.CENTER;
            myBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    //      linearLayout.setBackgroundColor(color); - it works !
                    Log.d(TAG2, "Clicked Continue_btn");
                    Intent intent_id_ = new Intent(SecondActivity.this, ThirdActivity.class);
                    String aString = Integer.toString(color);
                    intent_id_.putExtra(BUNDLE_MSG_2, aString);
                    startActivity(intent_id_);
                }
            });
        }
    }


}