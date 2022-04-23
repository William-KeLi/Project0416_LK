package com.example.onlyforpractise.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlyforpractise.R;

public class dengji extends AppCompatActivity implements View.OnClickListener {
  EditText tushu;
  Button dengji;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dengji);
    init();
    }
    private void init(){
        tushu=(EditText) findViewById(R.id.editTextTextPersonName2);
        dengji=(Button) findViewById(R.id.button7);
        dengji.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        SharedPreferences s1 =getSharedPreferences("tushudengji",MODE_PRIVATE);
        SharedPreferences.Editor editor=s1.edit();
        if (view.getId()==R.id.button7){
            if(tushu.getText().toString().isEmpty()){
                Toast.makeText(this, "请输入要登记的图书", Toast.LENGTH_SHORT).show();
                return;
            }else {
                editor.putString("book",tushu.getText().toString().trim());
                editor.commit();
                Toast.makeText(this, "登记成功", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }
}