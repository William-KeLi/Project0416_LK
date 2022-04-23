package com.example.onlyforpractise.loginandlogout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlyforpractise.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class registPage extends AppCompatActivity implements View.OnClickListener {
    EditText username, password, surepassword;
    Button sure;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_page);
        db = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString() + "/user.db", null);
        db.execSQL("create table if not exists user(username varchar(50),password varchar(50),primary key(username))");
        username = (EditText) findViewById(R.id.regist_name);
        password = (EditText) findViewById(R.id.regist_word);
        surepassword = (EditText) findViewById(R.id.regist_sureword);
        sure = (Button) findViewById(R.id.regist_button);
        sure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regist_button:
                String name = username.getText().toString();
                String pass = password.getText().toString();
                String surepass = surepassword.getText().toString();
                if (name.equals("") || pass.equals("") || surepass.equals("")) {
                    Toast.makeText(this, "各项数据均不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                //name必须是中文
                if (!name.matches("[\u4e00-\u9fa5]{2,4}")) {
                    Toast.makeText(this, "用户名必须是中文", Toast.LENGTH_SHORT).show();
                    return;
                }
                //密码必须一致
                if (!pass.equals(surepass)) {
                    Toast.makeText(this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                    return;
                }
                //pass必须长度为8-10位并且以字母开头，必须包含数字和下划线
                if (!pass.matches("^[a-zA-Z][\\w]{7,9}$")) {
                    Toast.makeText(this, "密码必须是8-10位，以字母开头，必须包含数字和下划线！", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    String regex="[_0-9]";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(pass);
                    if(!matcher.find()){
                        Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }




                db.execSQL("insert into user(username,password)values(?,?)", new String[]{name, pass});
                db.close();
                Intent intent = getIntent();
                intent.putExtra("username", name);
                intent.putExtra("password", pass);
                setResult(RESULT_OK, intent);
                finish();
                break;
                }
        }
    }

