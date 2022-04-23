package com.example.onlyforpractise.qiandao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onlyforpractise.R;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    Context context;
    ArrayList<Little> datalist;
    public Adapter(Context context, ArrayList<Little> datalist) {
        this.context = context;
        this.datalist = datalist;
    }
    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int i) {
        return datalist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //2.定义一个空的控件缓存器对象(1在最下面)
        ViewHolder viewHolder=null;
        //3.根据回收站中是否有缓存的View视图，来选择走哪一条路
        //3.1如果回收站中还没有View的缓存
        if (view==null) {
            //使用布局加载其将小布局加载到内存中，并且设置成一个view
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.little_qiandao, null);
            //创建ViewHold对象
            viewHolder=new ViewHolder(view);
            //为了方便服用，将ViewHold作为附件保存到convertView中，这样复用convertView时，就可以直接取出来使用，而不用再findViewById了
            //附件就相当于发送邮件时，你在邮件里发的附件，一个附件就写带了你想发送的信息，在这里的附件里的信息就是对应的布局位置！
            //这一步主要是为了第二次使用缓存视图时使用！！
            //绑定附件的方法时setTag（）
            view.setTag(viewHolder);
        }else {//3.2如果回收站中已经有了缓存视图
            viewHolder= (ViewHolder) view.getTag();
        }
        //4.将数据填充到View视图中（convertView）
        Little little=datalist.get(i);
        viewHolder.image.setImageResource(little.getImage());
        viewHolder.name.setText(little.getName());
        //6.将填充好的视图返回
        return view;
    }
    //1.创建控件缓存器，便于控件多次利用，避免重复创造，占用空间内存和cpu资源
    class ViewHolder{
        private View rootView;
        private ImageView image;
        private TextView name;


        public ViewHolder(View rootView) {
            this.rootView = rootView;
            image=rootView.findViewById(R.id.imageView13);
            name=rootView.findViewById(R.id.textView25);
        }
    }
    }

