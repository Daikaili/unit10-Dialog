package com.example.dialog;

import android.os.Bundle;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
       private Button simpleDialog,btnStatus;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		simpleDialog=(Button) this.findViewById(R.id.simpleDialog);
		btnStatus=(Button)  this.findViewById(R.id.btnStatus);
		final Builder builder=new AlertDialog.Builder(this);
		//�õ���ť������builder����
		
		simpleDialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				builder.setMessage("Are you sure you want to exit?");
				builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,"������ȷ��", 1000).show();
					}
				});
				//���Yes��ť
				builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,"������ȡ��", 1000).show();
					}
				});
				//���No��ť
				builder.show();
				//builder.create(),��ʡ��
			}
		});
		
		btnStatus.setOnClickListener(new OnClickListener() {
			//��ȡѡ��״̬��ť
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String[]items=new String[]{
						"����","����","�뿪","æµ","����","����"};
				Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("��ѡ�����״̬");
				builder.setIcon(R.drawable.ic_launcher);
				//���öԻ����ͼ��
				builder.setCancelable(false);
				//���öԻ�����ȡ��
				builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						btnStatus.setText("�㵱ǰ��״̬��:"+items[which]);
						
					}
				});
				//���õ���ѡ���б������б��Ĭ��ѡ��������¼�����
				builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				});
				builder.create().show();
				//��������ʾ�Ի���
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
