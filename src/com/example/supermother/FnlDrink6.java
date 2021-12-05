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
		wv1.setWebViewClient(webc); //�إߺ�����
		WebSettings wset=wv1.getSettings();
		wset.setJavaScriptEnabled(true);
		wset.setBuiltInZoomControls(true); 
		wset.setJavaScriptCanOpenWindowsAutomatically(true);
		wv1.loadUrl("https://www.google.com/maps/search/50�P/");
		
		String[] data={"50�P","�M�ߺ֥�","���E","�g�ȮL","�����|","�@�ڤ��G��",
				"�õN��","�K������","���ְ�","�Y�@����","�i���i��������","�j�b�l",
				"COMEBUY","�A���D","�p���N","��F����","�Ѫ��TIGERSUGAR","���L���]",
				"�¥j���{","���","�����]��","�x�W�Ĥ@��","�K�`�M��","�Q��"};
		
		ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,data);
		sp1.setAdapter(ad1); //<String>�x��(����)
		
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
			String store=sp1.getSelectedItem().toString(); //����
			String mapurl="https://www.google.com/maps/search/"+store+"/";
			WebSettings wset=wv1.getSettings();
			wset.setJavaScriptEnabled(true);
			wset.setBuiltInZoomControls(true); //�Y��
			wset.setJavaScriptCanOpenWindowsAutomatically(true);
			wv1.loadUrl(mapurl); //���J����
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
