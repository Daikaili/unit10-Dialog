package com.example.dialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.os.Bundle;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	

       private Button simpleDialog,btnStatus;
       final String [] names=new String[]{
    		   "明天会更好","浅川","萍水相逢"
       };
       final String[] info=new String[]{
    		   "个性签名:魔剑","个性签名:爱国","个性签名:诚信"};
       final int[] imageids=new int[]{
    		   
       R.drawable.a,R.drawable.b,R.drawable.c};
       //签名，头像数据
       
       List<Map<String,Object>>listItems=new ArrayList<Map<String,Object>>();
       //创建一个List集合，集合元素是Map
       
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		simpleDialog=(Button) this.findViewById(R.id.simpleDialog);
		btnStatus=(Button)  this.findViewById(R.id.btnStatus);
		final Builder builder=new AlertDialog.Builder(this);
		//得到按钮，创建builder对象
		
		simpleDialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				builder.setMessage("Are you sure you want to exit?");
				builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,"单击了确定", 1000).show();
					}
				});
				//添加Yes按钮
				builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,"单击了取消", 1000).show();
					}
				});
				//添加No按钮
				builder.show();
				//builder.create(),可省略
			}
		});
		
		btnStatus.setOnClickListener(new OnClickListener() {
			//获取选择状态按钮
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String[]items=new String[]{
						"在线","隐身","离开","忙碌","离线","其他"};
				Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("请选择你的状态");
				builder.setIcon(R.drawable.ic_launcher);
				//设置对话框的图标
				builder.setCancelable(false);
				//设置对话框不能取消
				builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						//btnStatus.setText("你当前的状态是:"+items[which]);
						if(which==(items.length-1)){
							//判断是否选择其他
							Builder myBuilder=new Builder(MainActivity.this);
							//创建Builder对象
							final EditText myInput=new EditText(MainActivity.this);
							//创建一个文本编辑框
							myBuilder.setTitle("请输入你的状态");
							myBuilder.setIcon(R.drawable.ic_launcher);
							//设置对话框图标
							myBuilder.setView(myInput);
							//设置对话框标题
				   //设置单项选择列表，包括列表项，默认选中项，单击事件处理
				myBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						btnStatus.setText("你当前的状态是:"+myInput.getText().toString());
					}
				});
				myBuilder.show();
				//创建并显示对话框
				}else{
					btnStatus.setText("你当前的状态是:"+items[which]);
				}
				}
			
		});                                	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
