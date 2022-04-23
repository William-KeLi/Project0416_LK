package com.example.onlyforpractise.loginandlogout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlyforpractise.R;

public class loginPage extends AppCompatActivity implements View.OnClickListener {
    EditText loginusername,loginpassword;
    Button denglu,zhuce;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        init();
    }
    private void init(){
        db=SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString() + "/user.db", null);
        loginusername=findViewById(R.id.login_username);
        loginpassword=findViewById(R.id.login_password);
        denglu=findViewById(R.id.login_button);
        zhuce=findViewById(R.id.login_button_register);
        denglu.setOnClickListener(this);
        zhuce.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_button:
                //如过loginusername为空，就提示用户
                if(loginusername.getText().toString().equals("")){
                    Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                //如过loginpassword为空，就提示用户
                if(loginpassword.getText().toString().equals("")){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }

                //查询数据库中是否有该用户,如果有，就判断密码是否匹配。如果匹配就提示登陆成功，如果不匹配，就提示密码错误
                Cursor cursor=db.rawQuery("select * from user where username=?",new String[]{loginusername.getText().toString()});
                if(cursor.moveToNext()){
                    if(cursor.getString(0).equals(loginusername.getText().toString())){
                        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
                    }
                }


                break;
            case R.id.login_button_register:
                Intent intent=new Intent(loginPage.this,registPage.class);
                startActivityForResult(intent,0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0&&resultCode==RESULT_OK){
            String username=data.getStringExtra("username");
            String password=data.getStringExtra("password");
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            loginusername.setText(username);
            loginpassword.setText(password);
        }
    }
}