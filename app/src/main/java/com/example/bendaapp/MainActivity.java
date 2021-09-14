package com.example.bendaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_Continue;
    private EditText editText;
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String BUNDLE_MSG ="com.example.myapplication.extra.BUNDLE_MSG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btn_Continue = findViewById(R.id.btnContinue_id);
        editText = (EditText) findViewById(R.id.Name_id);
    }

    @SuppressLint("ResourceAsColor")
    public void PassName(View view){
        Log.d(TAG,"Clicked Continue_btn");
        btn_Continue.setBackgroundColor(android.R.color.darker_gray);
        Intent intent = new Intent(this, SecondActivity.class);
        String message = editText.getText().toString();
        if(editText.length()==0) {
            Toast.makeText(MainActivity.this, getString(R.string.toast_name), Toast.LENGTH_LONG).show();
            return;
        }
        intent.putExtra(BUNDLE_MSG, message);
        startActivity(intent);
    }
}
