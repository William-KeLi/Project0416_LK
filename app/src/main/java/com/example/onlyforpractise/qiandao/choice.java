package com.example.onlyforpractise.qiandao;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.onlyforpractise.R;

import java.util.ArrayList;

public class choice extends AppCompatActivity implements View.OnClickListener{
    GridView yundong,yinyue;
    ArrayList<Little> datalist1,datalist2;
    int[] image1={R.drawable.ic_basketball,R.drawable.ic_football,R.drawable.ic_yumao};
    String[] name1={"篮球","足球","羽毛球"};
    int[] image2={R.drawable.ic_gudian,R.drawable.ic_tongyao,R.drawable.ic_yaogun};
    String name2[]={"古典音乐","童谣","摇滚乐"};
    TextView t1,t2;
    ImageButton b1;
    String str1 ="";
    String str2="";

    int[]count={1,1,1,1,1,1};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        init();
    }
    private void init(){
        yundong=findViewById(R.id.grid_yundong);
        yinyue=findViewById(R.id.grid_yinyue);
        t1=findViewById(R.id.textView22);
        t2=findViewById(R.id.textView24);
        b1=findViewById(R.id.imageView212);
        b1.setOnClickListener(this);
        datalist1=new ArrayList<>();
        datalist2=new ArrayList<>();
        for(int i=0;i<image1.length;i++){
            Little little1=new Little(image1[i],name1[i]);
            Little little2=new Little(image2[i],name2[i]);
            datalist1.add(little1);
            datalist2.add(little2);
        }
        yundong.setAdapter(new Adapter(this,datalist1));
        yinyue.setAdapter(new Adapter(this,datalist2));
        yinyue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                count[i]++;
                Little little=datalist2.get(i);
                if (count[i]==2){
                    str2+=little.getName();
                }else if(count[i]%2!=0){
                    str2.replace(little.getName(),"");
                    str2+="";
                }else if(count[i]%2==0){
                    str2+=little.getName();
                }

                t2.setText(str2);
            }
        });
        yundong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                count[i]++;
           Little little=datalist1.get(i);
                if (count[i]==2){
                    str1+=little.getName();
                }else if(count[i]%2!=0){
                    str1.replace(little.getName(),"");
                }else if(count[i]%2==0){
                    str1+="";
                }
           t1.setText(str1);
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageButton4:
                Intent intent1=new Intent(this,My.class);
                startActivity(intent1);
                break;
            case R.id.imageButton2:
                Intent intent2=new Intent(this,MainActivity.class);
                startActivity(intent2);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1&&resultCode==0){
            t1.setText(data.getStringExtra("yundong"));
            t2.setText(data.getStringExtra("yinyue"));
        }
    }
}