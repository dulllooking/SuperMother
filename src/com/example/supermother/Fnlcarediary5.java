package com.example.supermother;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Fnlcarediary5 extends Activity {

	private Button bt1=null;
	private Button bt2=null;
	private Button bt3=null;
	private Button bt4=null;
	private Button bt5=null;
	private Button bt6=null;
	private Button bt7=null;
	private DatePicker dk1=null;
	private ListView lv1=null;
	private int y=0;
	private int m=0;
	private int d=0;
	private String date="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fnlcarediary5);
		
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		bt4=(Button)findViewById(R.id.button4);
		bt5=(Button)findViewById(R.id.button5);
		bt6=(Button)findViewById(R.id.button6);
		bt7=(Button)findViewById(R.id.button7);
		lv1=(ListView)findViewById(R.id.listView1);
		dk1=(DatePicker)findViewById(R.id.datePicker1);
		dk1.setSpinnersShown(true);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		bt3.setOnClickListener(btlistener3);
		bt4.setOnClickListener(btlistener4);
		bt5.setOnClickListener(btlistener5);
		bt6.setOnClickListener(btlistener6);
		bt7.setOnClickListener(btlistener7);
		
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener()
	{
		@Override
		public void onClick(View arg0) 
		{
			y=dk1.getYear();
			m=dk1.getMonth()+1;
			d=dk1.getDayOfMonth();
			date=String.valueOf(y)+"-"+String.valueOf(m)+"-"+String.valueOf(d);
			
			Intent i1=new Intent(Fnlcarediary5.this,Fnldiray5.class);
			Bundle bundle=new Bundle();
			bundle.putString("pickerDate", date);
			i1.putExtras(bundle);
			startActivity(i1);
		}
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener()
	{
		@Override
		public void onClick(View arg0) 
		{
			String[] sfield={"_id","date","period","foodtype","state","medicine","wound","note"};
			int[] stext={R.id.textView2,R.id.textView4,R.id.textView6,R.id.textView8,
					R.id.textView10,R.id.textView12,R.id.textView14,R.id.textView16};
			
			y=dk1.getYear();
			m=dk1.getMonth()+1;
			d=dk1.getDayOfMonth();
			date=String.valueOf(y)+"-"+String.valueOf(m)+"-"+String.valueOf(d);
			
			openDatabase od=new openDatabase(Fnlcarediary5.this);
			SQLiteDatabase sd=od.getWritableDatabase();
			String sql="SELECT * FROM CARE WHERE date = '"+date+"'";
			Cursor c2=sd.rawQuery(sql, null);
			@SuppressWarnings("deprecation")
			SimpleCursorAdapter sca=new SimpleCursorAdapter(Fnlcarediary5.this,R.layout.carelistview,c2,sfield,stext);
			lv1.setAdapter(sca);
			
			sd.close();
			od.close();
			
			Toast.makeText(Fnlcarediary5.this, "資料查詢完畢", Toast.LENGTH_SHORT).show();
		}
	};
	
	Button.OnClickListener btlistener3=new Button.OnClickListener()
	{
		@Override
		public void onClick(View arg0) 
		{
			y=dk1.getYear();
			m=dk1.getMonth()+1;
			d=dk1.getDayOfMonth();
			date=String.valueOf(y)+"-"+String.valueOf(m)+"-"+String.valueOf(d);
			
			openDatabase od=new openDatabase(Fnlcarediary5.this);
			SQLiteDatabase sd=od.getWritableDatabase();
			String sql="DELETE FROM CARE WHERE date = '"+date+"'";
			sd.execSQL(sql);
			
			lv1.setAdapter(null);
			
			od.close();
			sd.close();
			Toast.makeText(Fnlcarediary5.this, "資料刪除成功", Toast.LENGTH_SHORT).show();
		}
	};
	
	Button.OnClickListener btlistener4=new Button.OnClickListener()
	{
		@Override
		public void onClick(View arg0) 
		{
			Intent i2=new Intent(Fnlcarediary5.this,FlnfrigStack3.class);
			startActivity(i2);
		}
	};

	Button.OnClickListener btlistener5=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			Intent i3=new Intent(Fnlcarediary5.this,FnlDrink6.class);
			startActivity(i3);
		}
	};
	
	Button.OnClickListener btlistener6=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			Intent i4=new Intent(Fnlcarediary5.this,FlnItem2.class);
			startActivity(i4);
		}
	};
	
	Button.OnClickListener btlistener7=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			Intent i5=new Intent(Fnlcarediary5.this,FnlRecipe4.class);
			startActivity(i5);
		}
	};

}
