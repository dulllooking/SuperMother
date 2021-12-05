package com.example.supermother;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class FnlRecipe4 extends Activity {

	private Button bt1=null;
	private Button bt2=null;
	private Button bt3=null;
	private Button bt4=null;
	private Button bt5=null;
	private Button bt6=null;
	private Button bt7=null;
	private Button bt8=null;
	private RadioButton rb0=null;
	private RadioButton rb1=null;
	private RadioButton rb2=null;
	private RadioButton rb3=null;
	private RadioButton rb4=null;
	private RadioButton rb5=null;
	private TextView tv2=null;
	private TextView tv3=null;
	private TextView tv4=null;
	private TextView tv5=null;
	private TextView tv6=null;
	private TextView tv7=null;
	private WebView wv1=null;
	private String url=null;
	private boolean ch=true;
	private boolean en=false;
	private boolean ja=false;
	@SuppressLint("SetJavaScriptEnabled") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fnl_recipe4);
	
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		bt4=(Button)findViewById(R.id.button4);
		bt5=(Button)findViewById(R.id.button5);
		bt6=(Button)findViewById(R.id.button6);
		bt7=(Button)findViewById(R.id.button7);
		bt8=(Button)findViewById(R.id.button8);
		rb0=(RadioButton)findViewById(R.id.radio0);
		rb1=(RadioButton)findViewById(R.id.radio1);
		rb2=(RadioButton)findViewById(R.id.radio2);
		rb3=(RadioButton)findViewById(R.id.radio3);
		rb4=(RadioButton)findViewById(R.id.radio4);
		rb5=(RadioButton)findViewById(R.id.radio5);
		tv2=(TextView)findViewById(R.id.textView2);
		tv3=(TextView)findViewById(R.id.textView3);
		tv4=(TextView)findViewById(R.id.textView4);
		tv5=(TextView)findViewById(R.id.textView5);
		tv6=(TextView)findViewById(R.id.textView6);
		tv7=(TextView)findViewById(R.id.textView7);
		wv1=(WebView)findViewById(R.id.webView1);
		
		WebViewClient webc=new WebViewClient();
		wv1.setWebViewClient(webc); //建立網頁端
		WebSettings wset=wv1.getSettings();
		wset.setJavaScriptEnabled(true);
		wset.setBuiltInZoomControls(true);
		wset.setJavaScriptCanOpenWindowsAutomatically(true);
		wv1.loadUrl("https://zh.wikipedia.org/wiki/食譜");
		  
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		bt3.setOnClickListener(btlistener3);
		bt4.setOnClickListener(btlistener4);
		bt5.setOnClickListener(btlistener5);
		bt6.setOnClickListener(btlistener6);
		bt7.setOnClickListener(btlistener7);
		bt8.setOnClickListener(btlistener8);
	
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0)
        {
			ch=true;
			en=false;
			ja=false;
			tv2.setText("中式");
			tv3.setText("西式");
			tv4.setText("日式");
			tv5.setText("熱炒");
			tv6.setText("燉煮");
			tv7.setText("甜點");
		}
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			ch=false;
			en=true;
			ja=false;
			tv2.setText("Chinese"); //https://www.bbc.co.uk/food/stir-fries
			tv3.setText("Western"); //https://www.bbc.co.uk/food/risotto
			tv4.setText("Japanese"); //https://www.bbc.co.uk/food/collections/japanese_flavour	
			tv5.setText("Stir-fries"); //https://www.bbc.co.uk/food/butter_bean
			tv6.setText("Stew"); //https://www.bbc.co.uk/food/salmon
			tv7.setText("Dessert"); //https://www.bbc.co.uk/food/oats
		}
	};

	Button.OnClickListener btlistener3=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0)
		{
			ch=false;
			en=false;
			ja=true;
			tv2.setText("中華");
			tv3.setText("洋食");
			tv4.setText("和食");
			tv5.setText("炒め物");
			tv6.setText("煮物");
			tv7.setText("デザート");
		}
	};
	
	Button.OnClickListener btlistener4=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0)
		{
			Intent i1=new Intent(FnlRecipe4.this,FlnfrigStack3.class);
			startActivity(i1);
		}
	};
	
	Button.OnClickListener btlistener5=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			Intent i2=new Intent(FnlRecipe4.this,Fnlcarediary5.class);
			startActivity(i2);
		}
	};
	
	Button.OnClickListener btlistener6=new Button.OnClickListener()
	{
		@Override
		public void onClick(View arg0) 
		{
			Intent i3=new Intent(FnlRecipe4.this,FlnItem2.class);
		    startActivity(i3);
		}
	};
	
	Button.OnClickListener btlistener7=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			Intent i4=new Intent(FnlRecipe4.this,FnlDrink6.class);
			startActivity(i4);
		}
	};
	
	Button.OnClickListener btlistener8=new Button.OnClickListener()
	{

		@SuppressLint("SetJavaScriptEnabled") @Override
		public void onClick(View arg0) 
		{
			if(ch==true){
				if(rb0.isChecked()){
					if(rb3.isChecked())url="https://www.pinterest.com/lalayao/台菜熱炒食譜/";
					else if(rb4.isChecked())url="https://food.ltn.com.tw/article/10726";
					else if(rb5.isChecked())url="https://www.pinterest.com/annswchang/中式點心/";
				}
				else if(rb1.isChecked()){
					if(rb3.isChecked())url="https://www.christinesrecipes.com/p/western-recipes.html";
					else if(rb4.isChecked())url="https://nommagazine.com/十道溫暖人心的法國鄉村菜/";
					else if(rb5.isChecked())url="https://www.xinshipu.com/caipu/112845/";
				}
				else if(rb2.isChecked()){
					if(rb3.isChecked())url="https://tasty-note.com/";
					else if(rb4.isChecked())url="https://www.maruko.tw/2020/04/29.html";
					else if(rb5.isChecked())url="https://cook1cook.com/category/165";
				}
			}
			if(en==true){
				if(rb0.isChecked()){
					if(rb3.isChecked())url="https://www.bbcgoodfood.com/recipes/collection/chicken-stir-fry-recipes";
					else if(rb4.isChecked())url="https://omnivorescookbook.com/top-10-asian-stew-recipes/";
					else if(rb5.isChecked())url="https://www.yumofchina.com/chinese-dessert-recipes/";
				}
				else if(rb1.isChecked()){
					if(rb3.isChecked())url="https://www.epicurious.com/recipes/member/views/western-stir-fry-573546df631b219108a31c16";
					else if(rb4.isChecked())url="https://www.greatbritishchefs.com/recipes/braised-east-west-stew-recipe";
					else if(rb5.isChecked())url="https://www.pinterest.com.au/sandhujatti/western-sweets/";
				}
				else if(rb2.isChecked()){	
					if(rb3.isChecked())url="https://www.yummly.com/recipes/japanese-stir-fry-sauce";
					else if(rb4.isChecked())url="https://www.justonecookbook.com/favorite-japanese-hot-pots-soups-stews/";
					else if(rb5.isChecked())url="https://www.japancentre.com/en/cookings/29-desserts";
				}

			}
			if(ja==true){
				if(rb0.isChecked()){
					if(rb3.isChecked())url="https://www.orangepage.net/recipes/search?search_recipe%5Bkeyword%5D=中華炒め";
					else if(rb4.isChecked())url="https://oceans-nadia.com/recipe/tag/中華煮";
					else if(rb5.isChecked())url="https://macaro-ni.jp/61578";
				}
				else if(rb1.isChecked()){
					if(rb3.isChecked())url="https://erecipe.woman.excite.co.jp/detail/afb801936334b3b21e5df20a42f17bc1.html";
					else if(rb4.isChecked())url="https://recipe.kirin.co.jp/feature/036/index.html";
					else if(rb5.isChecked())url="https://www.asahibeer.co.jp/enjoy/recipe/search/list.psp.html?GENRE=002&DIVIS=006";
				}
				else if(rb2.isChecked()){	
					if(rb3.isChecked())url="https://www.aco-mom.com/recipe-category/vegetable/japanese-stew.php";
					else if(rb4.isChecked())url="https://kurashinista.jp/feature/detail/1054";
					else if(rb5.isChecked())url="https://www.kitchenbook.jp/topics/419";
				}
			}
			WebSettings wset=wv1.getSettings();
			wset.setJavaScriptEnabled(true);
			wset.setBuiltInZoomControls(true);
			wset.setJavaScriptCanOpenWindowsAutomatically(true);
			wv1.loadUrl(url);
		}
	};
	
}
