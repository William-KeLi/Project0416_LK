package com.example.onlyforpractise.qiandao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.onlyforpractise.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton b1,b2,b3,b4;
    TextView t1,t2;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();
    }
    private void init(){
        b1=findViewById(R.id.imageButton2);
        b2=findViewById(R.id.imageView12);
        b3=findViewById(R.id.imageButton3);
        b4=findViewById(R.id.imageButton4);
        t1=findViewById(R.id.textView9);
        t2=findViewById(R.id.textView16);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageButton2:
                Date date=new Date();
                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                t1.setText(format.format(date));
                count++;
                t2.setText("完成第"+count+"次签到");
                break;
            case R.id.imageButton3:
                Intent intent=new Intent(this,choice.class);
                startActivity(intent);
                break;
        }
    }
}