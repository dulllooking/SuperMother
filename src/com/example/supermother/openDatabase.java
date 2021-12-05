package com.example.supermother;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class openDatabase extends SQLiteOpenHelper{

	private static final int databaseversion=1; //資料庫版本
	private static final String databasename="carediary.db"; //資料庫名稱
	private Context mycontext;
	private String strcreate="CREATE TABLE CARE(_id INTEGER PRIMARY KEY AUTOINCREMENT,date TEXT,period TEXT," +
			"foodtype TEXT,state TEXT,medicine TEXT,wound TEXT,note TEXT)"; //CARE
	private String strcreate2="CREATE TABLE PRODUCT(_id INTEGER PRIMARY KEY AUTOINCREMENT,foodname TEXT,overdate TEXT," +
			"amount TEXT,item TEXT)"; //PRODUCT
	
	public openDatabase(Context context) {
		super(context, databasename, null, databaseversion);
		mycontext=context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(strcreate); //開始執行資料庫建立
		db.execSQL(strcreate2); //開始執行資料庫建立
		Toast.makeText(mycontext, "資料庫建立完成", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		Toast.makeText(mycontext, "資料庫已開啟", Toast.LENGTH_SHORT).show();
	}

}
