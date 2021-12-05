package com.example.supermother;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;

@SuppressLint("Registered") @SuppressWarnings("deprecation")
public class FlnItem2 extends Activity {
	
	private Button bt1=null;
	private Button bt2=null;
	private Button bt3=null;
	private Button bt4=null;

	private int[] imageIds = {R.drawable.drinktakeaway,R.drawable.catndog,R.drawable.foodre,R.drawable.large};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fln_item2);
		
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		bt4=(Button)findViewById(R.id.button4);
	
		Gallery gal=(Gallery)findViewById(R.id.gallery1);
		MyAdapter ad1=new MyAdapter(this);
		
		gal.setAdapter(ad1);

		gal.setSelection(Integer.MAX_VALUE/2);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		bt3.setOnClickListener(btlistener3);
		bt4.setOnClickListener(btlistener4);
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener()
	{
		@Override
		public void onClick(View arg0) 
		{
			Intent i1=new Intent(FlnItem2.this,FlnfrigStack3.class);
			startActivity(i1);
		}
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener()
	{
		@Override
		public void onClick(View arg0) 
		{
			Intent i2=new Intent(FlnItem2.this,FnlRecipe4.class);
			startActivity(i2);
		}
	};
	
	Button.OnClickListener btlistener3=new Button.OnClickListener()
	{
		@Override
		public void onClick(View arg0) 
		{
			Intent i3=new Intent(FlnItem2.this,Fnlcarediary5.class);
			startActivity(i3);
		}
	};

	Button.OnClickListener btlistener4=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			Intent i4=new Intent(FlnItem2.this,FnlDrink6.class);
			startActivity(i4);
		}
	};
	
	// 自訂的 MyAdapter 類別，繼承 BaseAdapter 類別
	class MyAdapter extends BaseAdapter {
		private Context mContext;
		public MyAdapter(Context c){
			mContext=c;
		}
		public int getCount(){
			return Integer.MAX_VALUE; // 圖片共有多少張
		}
		
		public Object getItem(int position){
			return position;
		}
		
		public long getItemId(int position){
			return position; // 目前圖片索引
		}

		@Override
		public View getView(int position, View contextView, ViewGroup parent) {
			ImageView iv = new ImageView(mContext);
			// iv.setImageResource(imageIds[position]);
			iv.setImageResource(imageIds[position % imageIds.length]);
			iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
			return iv;
		}
	}

}