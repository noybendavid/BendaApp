package com.example.bendaapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class ThirdActivity extends AppCompatActivity {
    private EditText mEditTextSubject;
    private EditText mEditTextMessage;
    private TextView byeTxt;
    private AnimationDrawable animationDrawable;
    private static final String TAG3 = SecondActivity.class.getSimpleName();
    public static final String BUNDLE_MSG_3 = "com.example.myapplication.extra.BUNDLE_MSG";
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imageView = findViewById(R.id.img);
        byeTxt = findViewById(R.id.title_id);
        Intent incomingIntent2 = getIntent();
        String msg = incomingIntent2.getStringExtra(SecondActivity.BUNDLE_MSG_2);
        LinearLayout linearLayout = findViewById(R.id.thirdLayout);
        linearLayout.setBackgroundColor(Integer.parseInt(msg));
        mEditTextSubject = findViewById(R.id.esit_subject_id);
        mEditTextMessage = findViewById(R.id.edit_message_id);
        //בגלל שנתשמש בכפתור רק כאן אין צורך להגדיר למעלה במחלקה
        Button buttonSend = findViewById(R.id.btn_send_id);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });

    }

    private void sendMail() {
        String subject = mEditTextSubject.getText().toString();
        final String[] toSend = {"noybd95@gmail.com"};
        String message = mEditTextMessage.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, toSend);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("message/rfc822");
        try {
            startActivity(Intent.createChooser(intent, "choose an email"));
            String string = getString(R.string.bye_app_txt);
            int color = getColor(R.color.black);
            byeTxt.setTextColor(color);
            byeTxt.setTextSize(16);
            byeTxt.setText(string);
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            String string = getString(R.string.no_email_txt);
            int color = getColor(R.color.black);
            byeTxt.setTextColor(color);
            byeTxt.setTextSize(16);
            byeTxt.setText(string);
        }
        imageView.setBackgroundResource(R.drawable.animation);
        animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
    }
}



