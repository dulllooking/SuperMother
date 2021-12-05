package com.example.supermother;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class FlnfrigDatePicker extends Activity {

	private Button bt1=null;
	private DatePicker dk1=null;
	private int y=0;
	private int m=0;
	private int d=0;
	private String date="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flnfrig_date_picker);
		
		bt1=(Button)findViewById(R.id.button1);
		dk1=(DatePicker)findViewById(R.id.datePicker1);
		dk1.setSpinnersShown(true);
		
		bt1.setOnClickListener(btlistener1);
		
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener()
	{
		@SuppressLint("SimpleDateFormat") @Override
		public void onClick(View arg0) 
		{
			y=dk1.getYear();
			m=dk1.getMonth()+1;
			d=dk1.getDayOfMonth();
			date=String.valueOf(y)+"-"+String.valueOf(m)+"-"+String.valueOf(d);
			DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date dfdate = null;
			try {
				dfdate = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String sdate=sdf.format(dfdate);
			Intent i1=new Intent(FlnfrigDatePicker.this,FlnfrigStack3.class);
			Bundle bundle=new Bundle();
			bundle.putString("frigpickerDate", sdate);
			i1.putExtras(bundle);
			startActivity(i1);
		}
	};
	
}
