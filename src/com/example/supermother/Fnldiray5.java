package com.example.supermother;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Fnldiray5 extends Activity {

	private RadioButton rbt1=null;
	private RadioButton rbt2=null;
	private RadioButton rbt3=null;
	private RadioButton rbt4=null;
	private RadioButton rbt5=null;
	private RadioButton rbt6=null;
	private RadioButton rbt7=null;
	private RadioButton rbt8=null;
	private RadioButton rbt9=null;
	private EditText et1=null;
	private EditText et2=null;
	private EditText et3=null;
	private Button bt1=null;
	private Button bt2=null;
	private Button bt3=null;
	private Button bt4=null;
	private Button bt5=null;
	private Button bt6=null;
	private ListView lv1=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fnldiray5);
		
		rbt1=(RadioButton)findViewById(R.id.radio1);
		rbt2=(RadioButton)findViewById(R.id.radio2);
		rbt3=(RadioButton)findViewById(R.id.radio3);
		rbt4=(RadioButton)findViewById(R.id.radio4);
		rbt5=(RadioButton)findViewById(R.id.radio5);
		rbt6=(RadioButton)findViewById(R.id.radio6);
		rbt7=(RadioButton)findViewById(R.id.radio7);
		rbt8=(RadioButton)findViewById(R.id.radio8);
		rbt9=(RadioButton)findViewById(R.id.radio9);
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		et3=(EditText)findViewById(R.id.editText3);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		bt4=(Button)findViewById(R.id.button4);
		bt5=(Button)findViewById(R.id.button5);
		bt6=(Button)findViewById(R.id.button6);
		lv1=(ListView)findViewById(R.id.listView1);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		bt3.setOnClickListener(btlistener3);
		bt4.setOnClickListener(btlistener4);
		bt5.setOnClickListener(btlistener5);
		bt6.setOnClickListener(btlistener6);
		
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener()
	{
		@Override
		public void onClick(View arg0) 
		{
			openDatabase od=new openDatabase(Fnldiray5.this);
			SQLiteDatabase sd=od.getWritableDatabase();
			
			//取得日期挑選頁日期傳送值
			Bundle bundle=getIntent().getExtras();
			String sdate=bundle.getString("pickerDate");
			
			String speriod="";
			if(rbt1.isChecked()){speriod="早上";}
			if(rbt2.isChecked()){speriod="中午";}
			if(rbt3.isChecked()){speriod="晚上";}
			String sfoodtype="";
			if(rbt4.isChecked()){sfoodtype="乾乾";}
			if(rbt5.isChecked()){sfoodtype="濕食";}
			if(rbt6.isChecked()){sfoodtype="其它";}
			String sstate="";
			if(rbt7.isChecked()){sstate="良好";}
			if(rbt8.isChecked()){sstate="一般";}
			if(rbt9.isChecked()){sstate="萎靡";}
			
			String strmedicine=et1.getText().toString();
			if(strmedicine.trim().equals("")){strmedicine="無";}
			String strwound=et2.getText().toString();
			if(strwound.trim().equals("")){strwound="無";}
			String strnote=et3.getText().toString();
			if(strnote.trim().equals("")){strnote="無";}
			
			ContentValues cv=new ContentValues();
			cv.put("date", sdate);
			cv.put("period", speriod);
			cv.put("foodtype", sfoodtype);
			cv.put("state", sstate);
			cv.put("medicine", strmedicine);
			cv.put("wound", strwound);
			cv.put("note", strnote);
			sd.insert("CARE", null, cv);
			
			od.close();
			sd.close();
			
			String[] sfield={"_id","date","period","foodtype","state","medicine","wound","note"};
			int[] stext={R.id.textView2,R.id.textView4,R.id.textView6,R.id.textView8,
					R.id.textView10,R.id.textView12,R.id.textView14,R.id.textView16};
			
			openDatabase od1=new openDatabase(Fnldiray5.this);
			SQLiteDatabase sd1=od1.getWritableDatabase();
			String sql="SELECT * FROM CARE WHERE date = '"+sdate+"'";
			Cursor c=sd1.rawQuery(sql, null);
			@SuppressWarnings("deprecation")
			SimpleCursorAdapter sca=new SimpleCursorAdapter(Fnldiray5.this,R.layout.carelistview,c,sfield,stext);
			lv1.setAdapter(sca);
			
			od1.close();
			sd1.close();
			
			Toast.makeText(Fnldiray5.this, "新增資料成功", Toast.LENGTH_SHORT).show();
		}
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener()
	{
		@Override
		public void onClick(View arg0) 
		{
			Intent i2=new Intent(Fnldiray5.this,Fnlcarediary5.class);
			startActivity(i2);
		}
	};

	Button.OnClickListener btlistener3=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			Intent i3=new Intent(Fnldiray5.this,FlnfrigStack3.class);
			startActivity(i3);
		}
	};
	
	Button.OnClickListener btlistener4=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			Intent i4=new Intent(Fnldiray5.this,FnlDrink6.class);
			startActivity(i4);
		}
	};
	
	Button.OnClickListener btlistener5=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			Intent i5=new Intent(Fnldiray5.this,FlnItem2.class);
			startActivity(i5);
		}
	};
	
	Button.OnClickListener btlistener6=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			Intent i6=new Intent(Fnldiray5.this,FnlRecipe4.class);
			startActivity(i6);
		}
	};

}
