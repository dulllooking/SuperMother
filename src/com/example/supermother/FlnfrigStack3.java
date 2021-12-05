package com.example.supermother;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class FlnfrigStack3 extends Activity {
	
	private EditText et1=null;
	private EditText et2=null;
	private ListView lv1=null;
	private Spinner sp1=null;
	private Spinner sp2=null;
	private Button bt1=null;
	private Button bt2=null;
	private Button bt3=null;
	private Button bt4=null;
	private Button bt5=null;
	private Button bt6=null;
	private Button bt7=null;
	private Button bt8=null;
	private Button bt9=null;
	private String nowday="";
	private Date overdate=null;
	private String overday="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flnfrig_stack3);
		
		sp1=(Spinner)findViewById(R.id.spinner1);
		sp2=(Spinner)findViewById(R.id.spinner2);
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		bt4=(Button)findViewById(R.id.button4);
		bt5=(Button)findViewById(R.id.button5);
		bt6=(Button)findViewById(R.id.button6);
		bt7=(Button)findViewById(R.id.button7);
		bt8=(Button)findViewById(R.id.button8);
		bt9=(Button)findViewById(R.id.button9);
		lv1=(ListView)findViewById(R.id.listView1);
		
		//取得nowday日期
		Calendar mCal=Calendar.getInstance();
		CharSequence cs=DateFormat.format("yyyy-MM-dd", mCal.getTime()); 
		nowday=String.valueOf(cs);
		
		String[] data1={"無分類","生鮮蔬果","肉品類","醃漬食品","調味料","液體飲料"};
		ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,data1);
		sp1.setAdapter(ad1);
		
		String[] data2={"已過期","3天內過期","5天內過期","1週(7天)內過期","2週(14天)內過期","3週(21天)內過期","1個月(30天)內過期"};
		ArrayAdapter<String> ad2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,data2);
		sp2.setAdapter(ad2); 
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		bt3.setOnClickListener(btlistener3);
		bt4.setOnClickListener(btlistener4);
		bt5.setOnClickListener(btlistener5);
		bt6.setOnClickListener(btlistener6);
		bt7.setOnClickListener(btlistener7);
		bt8.setOnClickListener(btlistener8);
		bt9.setOnClickListener(btlistener9);
		//bt3.setVisibility(View.GONE); //取消顯示此元件
	
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			openDatabase od=new openDatabase(FlnfrigStack3.this);
			SQLiteDatabase sd=od.getWritableDatabase();
			
			//取得日期挑選頁日期傳送值
			Bundle bundle=getIntent().getExtras();
			String sdate=bundle.getString("frigpickerDate");
			bt9.setText(sdate);
			String sfoodname=et1.getText().toString();
			if(sfoodname.trim().equals("")){sfoodname="未命名";}
			String samount=et2.getText().toString();
			if(samount.trim().equals("")){samount="未定義";}
			String sitem=sp1.getSelectedItem().toString();
			
			ContentValues cv=new ContentValues();
			cv.put("foodname", sfoodname);
			cv.put("overdate", sdate);
			cv.put("amount", samount);
			cv.put("item", sitem);
			sd.insert("PRODUCT", null, cv);
			
			od.close();
			sd.close();
			
			String[] sfield={"_id","foodname","overdate","amount","item"};
			int[] stext={R.id.textView2,R.id.textView4,R.id.textView6,R.id.textView8,R.id.textView10};
			
			openDatabase od1=new openDatabase(FlnfrigStack3.this);
			SQLiteDatabase sd1=od1.getWritableDatabase();
			String sql="SELECT * FROM PRODUCT WHERE overdate = '"+sdate+"'";
			Cursor c=sd1.rawQuery(sql, null);
			@SuppressWarnings("deprecation")
			SimpleCursorAdapter sca=new SimpleCursorAdapter(FlnfrigStack3.this,R.layout.listviewfrigstack1,c,sfield,stext);
			lv1.setAdapter(sca);
			
			od1.close();
			sd1.close();
			
			Toast.makeText(FlnfrigStack3.this, "新增資料成功", Toast.LENGTH_SHORT).show();
		}
	};
	
	
	Button.OnClickListener btlistener2=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			String[] sfield={"_id","foodname","overdate","amount","item"};
			int[] stext={R.id.textView2,R.id.textView4,R.id.textView6,R.id.textView8,R.id.textView10};
			
			openDatabase od=new openDatabase(FlnfrigStack3.this);
			SQLiteDatabase sd=od.getWritableDatabase();
			String sql="SELECT * FROM PRODUCT ORDER BY overdate ASC";
			Cursor c=sd.rawQuery(sql, null);
			@SuppressWarnings("deprecation")
			SimpleCursorAdapter sca=new SimpleCursorAdapter(FlnfrigStack3.this,R.layout.listviewfrigstack1,c,sfield,stext);
			lv1.setAdapter(sca);
			
			od.close();
			sd.close();
			
			Toast.makeText(FlnfrigStack3.this, "全部資料載入完畢", Toast.LENGTH_SHORT).show();
		}
	};
	
	Button.OnClickListener btlistener3=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			String[] sfield={"_id","foodname","overdate","amount","item"};
			int[] stext={R.id.textView2,R.id.textView4,R.id.textView6,R.id.textView8,R.id.textView10};
			
			openDatabase od=new openDatabase(FlnfrigStack3.this);
			SQLiteDatabase sd=od.getWritableDatabase();
			String sql="DELETE FROM PRODUCT WHERE overdate > '1911-01-01' AND overdate < '"+nowday+"'";
			sd.execSQL(sql);
			
			String sqlall="SELECT * FROM PRODUCT ORDER BY overdate ASC";
			Cursor c=sd.rawQuery(sqlall, null);
			@SuppressWarnings("deprecation")
			SimpleCursorAdapter sca=new SimpleCursorAdapter(FlnfrigStack3.this,R.layout.listviewfrigstack1,c,sfield,stext);
			lv1.setAdapter(sca);
			
			od.close();
			sd.close();
			
			Toast.makeText(FlnfrigStack3.this, "過期資料刪除成功", Toast.LENGTH_SHORT).show();
		}
	};
	
	Button.OnClickListener btlistener4=new Button.OnClickListener()
	{

		@SuppressLint("SimpleDateFormat") @Override
		public void onClick(View arg0) 
		{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			try {
				overdate=sdf.parse(nowday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Calendar cNow=Calendar.getInstance();
			cNow.setTime(overdate);
			String sitem=sp2.getSelectedItem().toString();
			if(sitem.equals("已過期")){cNow.add(Calendar.DAY_OF_YEAR, 0);}
			if(sitem.equals("3天內過期")){cNow.add(Calendar.DAY_OF_YEAR, 3);}
			if(sitem.equals("5天內過期")){cNow.add(Calendar.DAY_OF_YEAR, 5);}
			if(sitem.equals("1週(7天)內過期")){cNow.add(Calendar.DAY_OF_YEAR, 7);}
			if(sitem.equals("2週(14天)內過期")){cNow.add(Calendar.DAY_OF_YEAR, 14);}
			if(sitem.equals("3週(21天)內過期")){cNow.add(Calendar.DAY_OF_YEAR, 21);}
			if(sitem.equals("1個月(30天)內過期")){cNow.add(Calendar.DAY_OF_YEAR, 30);}
			Date ovdate=cNow.getTime();
			overday=sdf.format(ovdate);
			
			String[] sfield={"_id","foodname","overdate","amount","item"};
			int[] stext={R.id.textView2,R.id.textView4,R.id.textView6,R.id.textView8,R.id.textView10};
			
			openDatabase od=new openDatabase(FlnfrigStack3.this);
			SQLiteDatabase sd=od.getWritableDatabase();
			String sql="SELECT * FROM PRODUCT WHERE overdate > '1911-01-01' AND overdate < '"+overday+"' ORDER BY overdate DESC";
			Cursor c=sd.rawQuery(sql, null);
			@SuppressWarnings("deprecation")
			SimpleCursorAdapter sca=new SimpleCursorAdapter(FlnfrigStack3.this,R.layout.listviewfrigstack1,c,sfield,stext);
			lv1.setAdapter(sca);
			
			od.close();
			sd.close();
			
			Toast.makeText(FlnfrigStack3.this, "過期查詢完畢", Toast.LENGTH_SHORT).show();
		}
	};
  	
	Button.OnClickListener btlistener5=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			Intent i1=new Intent(FlnfrigStack3.this,Fnlcarediary5.class);
			startActivity(i1);
		}
	};
	
	Button.OnClickListener btlistener6=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0)
		{
			Intent i2=new Intent(FlnfrigStack3.this,FnlDrink6.class);
			startActivity(i2);
		}
	};
	
	Button.OnClickListener btlistener7=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0)
		{
			Intent i3=new Intent(FlnfrigStack3.this,FlnItem2.class);
			startActivity(i3);
		}
		
	};
	
	Button.OnClickListener btlistener8=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			Intent i4=new Intent(FlnfrigStack3.this,FnlRecipe4.class);
			startActivity(i4);
		}
	};
	
	Button.OnClickListener btlistener9=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			Intent i5=new Intent(FlnfrigStack3.this,FlnfrigDatePicker.class);
			startActivity(i5);
		}
	};

}
