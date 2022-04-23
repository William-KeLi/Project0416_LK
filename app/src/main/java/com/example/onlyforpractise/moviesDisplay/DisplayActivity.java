package com.example.onlyforpractise.moviesDisplay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.onlyforpractise.R;

public class DisplayActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bianxingjingang,nidemingzi,xialuote;
    Button xianshi;
    int choice=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        init();
    }
    private void init(){
        bianxingjingang=(TextView) findViewById(R.id.qishi);
        nidemingzi=(TextView) findViewById(R.id.dongman);
        xialuote=(TextView) findViewById(R.id.yuanhuade);
        xianshi=(Button) findViewById(R.id.button5);
        bianxingjingang.setOnClickListener(this);
        nidemingzi.setOnClickListener(this);
        xialuote.setOnClickListener(this);
        xianshi.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Fragment jingang =new bianxing();
        Fragment you = new yourname();
        Fragment xia = new yuanhua();
        Fragment mingzijin=new mingzi_xianshi();
        Fragment niming=new ni_mingzi();
        Fragment xiaming=new xia_mingzi();
        switch (view.getId()){
            case R.id.qishi:
                fragmentTransaction.replace(R.id.xianshipic,jingang);
                choice=1;
                break;
            case R.id.dongman:
                choice=2;
                fragmentTransaction.replace(R.id.xianshipic,you);
                break;
            case R.id.yuanhuade:
                choice=3;
                fragmentTransaction.replace(R.id.xianshipic,xia);
                break;
            case R.id.button5:
                switch (choice){
                    case 1:
                        fragmentTransaction.replace(R.id.mingzi,mingzijin);
                        break;
                    case 2:
                        fragmentTransaction.replace(R.id.mingzi,niming);
                        break;
                    case 3:
                        fragmentTransaction.replace(R.id.mingzi,xiaming);
                        break;
                }

        }
        fragmentTransaction.commit();
    }
}