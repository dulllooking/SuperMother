package com.example.supermother;


import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

public class FnlDrink6 extends Activity {

	private Spinner sp1=null;
	private Button bt1=null;
	private Button bt2=null;
	private Button bt3=null;
	private Button bt4=null;
	private Button bt5=null;
	private WebView wv1=null;
	@SuppressLint("SetJavaScriptEnabled") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fnl_drink6);
		
		sp1=(Spinner)findViewById(R.id.spinner1);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		bt4=(Button)findViewById(R.id.button4);
		bt5=(Button)findViewById(R.id.button5);
		wv1=(WebView)findViewById(R.id.webView1);
		
		WebViewClient webc=new WebViewClient();
		wv1.setWebViewClient(webc); //建立網頁端
		WebSettings wset=wv1.getSettings();
		wset.setJavaScriptEnabled(true);
		wset.setBuiltInZoomControls(true); 
		wset.setJavaScriptCanOpenWindowsAutomatically(true);
		wv1.loadUrl("https://www.google.com/maps/search/50嵐/");
		
		String[] data={"50嵐","清心福全","茶聚","迷客夏","茶湯會","一芳水果茶",
				"珍煮丹","春陽茶事","幸福堂","丸作食茶","可不可熟成紅茶","大苑子",
				"COMEBUY","鮮茶道","小茶齋","樺達奶茶","老虎堂TIGERSUGAR","翰林茶館",
				"麻古茶坊","圓石","茶的魔手","台灣第一味","八曜和茶","烏弄"};
		
		ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,data);
		sp1.setAdapter(ad1); //<String>泛型(限制)
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		bt3.setOnClickListener(btlistener3);
		bt4.setOnClickListener(btlistener4);
		bt5.setOnClickListener(btlistener5);
		
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener()
	{
		@SuppressLint("SetJavaScriptEnabled") @Override
		public void onClick(View arg0) 
		{
			String store=sp1.getSelectedItem().toString(); //取值
			String mapurl="https://www.google.com/maps/search/"+store+"/";
			WebSettings wset=wv1.getSettings();
			wset.setJavaScriptEnabled(true);
			wset.setBuiltInZoomControls(true); //縮放
			wset.setJavaScriptCanOpenWindowsAutomatically(true);
			wv1.loadUrl(mapurl); //載入網頁
		}
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener()
	{
		@Override
		public void onClick(View arg0) 
		{
			Intent i1=new Intent(FnlDrink6.this,FlnfrigStack3.class);
			startActivity(i1);
		}
	};
	
	Button.OnClickListener btlistener3=new Button.OnClickListener()
	{
		@Override
		public void onClick(View arg0) 
		{
			Intent i2=new Intent(FnlDrink6.this,Fnlcarediary5.class);
			startActivity(i2);
		}
	};

	Button.OnClickListener btlistener4=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			Intent i3=new Intent(FnlDrink6.this,FlnItem2.class);
			startActivity(i3);
		}
	};
	
	Button.OnClickListener btlistener5=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			Intent i4=new Intent(FnlDrink6.this,FnlRecipe4.class);
			startActivity(i4);
		}
	};
	
}
