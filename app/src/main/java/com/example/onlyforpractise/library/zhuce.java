package com.example.onlyforpractise.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlyforpractise.R;

public class zhuce extends AppCompatActivity implements View.OnClickListener{
    EditText yonghumming,mima;
    Button denglu,zhuce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        init();
    }
    private void init(){
        yonghumming=(EditText) findViewById(R.id.yonghuming);
        mima=(EditText) findViewById(R.id.yonghumima);
        denglu=(Button) findViewById(R.id.button8);
        zhuce=(Button) findViewById(R.id.button6);
        denglu.setOnClickListener(this);
        zhuce.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        SharedPreferences s1 =getSharedPreferences("zhucezhuanyong",MODE_PRIVATE);
        SharedPreferences.Editor editor=s1.edit();
        String mm=yonghumming.getText().toString().trim();
        String MM=mima.getText().toString().trim();
        switch (view.getId()){
            case R.id.button6://注册
                if (yonghumming.getText().toString().isEmpty()||mima.getText().toString().isEmpty()){
                    Toast.makeText(this, "用户名或者密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    editor.putString("uesename",yonghumming.getText().toString().trim());
                    editor.putString("password",mima.getText().toString().trim());

                    editor.commit();
                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button8://登录
                String a = s1.getString("uesename","未设置");
                String b =s1.getString("password","一个");
                if (a.equals("未设置")||b.equals("一个")){
                    Toast.makeText(this, "请先注册！！", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    if(yonghumming.getText().toString().isEmpty()||mima.getText().toString().isEmpty()){
                        Toast.makeText(this, "账号或者密码不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    }else {
                        if (a.equals(mm)||b.equals(MM)) {
                            Intent intent = new Intent(com.example.onlyforpractise.library.zhuce.this, dengji.class);
                            startActivity(intent);
                        }
                    }
                }
                break;
        }
    }
}