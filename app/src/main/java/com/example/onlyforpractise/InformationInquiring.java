package com.example.onlyforpractise;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class InformationInquiring extends AppCompatActivity {
    RadioGroup radioGroup;
    EditText editTextname,editTextrace;
    RadioButton radioButtonMale,radioButtonFemale;
    CheckBox checkBoxsing,checkBoxjump,checkBoxplay,checkBoxrap;
    Button button,button2,button3,button4;
   SeekBar progressBar;
   int num1,num2,num3,num5,num4,num6=0;

   String race1="";
   String sex="";
    String information="";
    TextView textView13,textView15;
    boolean flag[]=new boolean[]{false,false,true};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_inquiring);
        init();
        checkBoxrap.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBoxrap.isChecked()){
                    num1=1;
                    //information+="，喜欢rap";
                }else {
                    num1=2;
                }
            }
        });
        checkBoxjump.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (checkBoxjump.isChecked()){
                   // information+="，喜欢跳";
                    num4=1;
                }else {num4=0;}

            }
        });
        checkBoxplay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (checkBoxplay.isChecked()){
                  //  information+="，喜欢打篮球";
                    num5=1;
                }else {num5=0;}

            }
        });
        checkBoxsing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (checkBoxsing.isChecked()){
                   // information+="，喜欢唱";
                    num6=1;
                }else {
                    num6=0;
                }

            }
        });


    }
    private void init(){
        radioGroup=(RadioGroup)findViewById(R.id.radiog);
        editTextname=(EditText) findViewById(R.id.editTextname);
        editTextrace=(EditText) findViewById(R.id.editTextrace);
        radioButtonFemale=(RadioButton) findViewById(R.id.radioButtonFemale);
        radioButtonMale=(RadioButton) findViewById(R.id.radioButtonMale);
        checkBoxjump=(CheckBox) findViewById(R.id.checkBoxJump);
        checkBoxsing=(CheckBox) findViewById(R.id.checkSing);
        checkBoxplay=(CheckBox) findViewById(R.id.checkBoxPlayBall);
        checkBoxrap=(CheckBox) findViewById(R.id.checkBoxRap);
        textView13=(TextView)findViewById(R.id.textView13);
        button=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        textView15=(TextView) findViewById(R.id.textView15);
        progressBar=(SeekBar) findViewById(R.id.progressBar);
        button.setOnClickListener(new MyListener());
        button2.setOnClickListener(new MyListener());
        button3.setOnClickListener(new MyListener());
        button4.setOnClickListener(new MyListener());
        progressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                  i =progressBar.getProgress();
                  textView15.setText(i+"岁");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i==radioButtonFemale.getId()){
                    num2=2;
                    sex="女";
                }else if (i==radioButtonMale.getId()){

                    num2=1;
                    sex="男";
                }

            }

        }
        );

    }
    class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int progress=progressBar.getProgress();
            textView15.setText(progress+"岁");
          switch (view.getId()) {
              case R.id.button3:
                  progress -= 1;
                  progressBar.setProgress(progress);
                  textView15.setText(progress + "岁");
                  break;
              case R.id.button4:
                  progress += 1;
                  progressBar.setProgress(progress);
                  textView15.setText(progress + "岁");
                  break;

              case R.id.button:

                  AlertDialog.Builder builder3 = new AlertDialog.Builder(InformationInquiring.this);
                  builder3.setTitle("成年人的第二个多选通知对话框");
                  builder3.setIcon(R.drawable.star1);
                  String game[] = new String[]{"英雄联盟", "王者荣耀", "原神"};
                  //设置多选按钮
                  builder3.setMultiChoiceItems(game, flag, new DialogInterface.OnMultiChoiceClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                          flag[i] = b;
                      }
                  });
                  builder3.setPositiveButton("确认", ((dialogInterface, i) -> {
                      for (int a = 0; a <= 2; a++) {
                          if (flag[a] == true) {
                              information += "，爱玩" + game[a];
                              num3++;
                          }
                      }

                      Toast.makeText(InformationInquiring.this, "添加成功", Toast.LENGTH_SHORT).show();
                  }));
                  builder3.setNegativeButton("取消", ((dialogInterface, i) -> {
                      Toast.makeText(InformationInquiring.this, "取消添加", Toast.LENGTH_SHORT).show();
                  }));
                  AlertDialog dialog3 = builder3.create();
                  dialog3.show();
                  break;
              case R.id.button2:
                  if (num1 == 1) {
                      information += "，爱好Rap";
                  }
                  if (num4 == 1) {
                      information += "，爱好跳";
                  }
                  if (num5 == 1) {
                      information += "，爱好篮球";
                  }
                  if (num6 == 1) {
                      information += "，爱好唱";
                  }


                  race1 = editTextrace.getText().toString().trim();

                  if (num1 != 0 && num2 != 0 && num3 != 0 && editTextname.getText().toString().length() != 0 && editTextrace.getText().toString().length() != 0) {

                      textView13.setText("姓名" + editTextname.getText().toString() + "，年龄" + textView15.getText().toString() + "，种族" +race1+ "，性别" + sex  + information);
                  } else {
                      Toast.makeText(InformationInquiring.this, "不能有空缺", Toast.LENGTH_SHORT).show();
                  }

                  break;


          }
        }

    }
}