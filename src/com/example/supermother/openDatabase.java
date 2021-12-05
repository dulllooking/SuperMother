package com.example.supermother;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class openDatabase extends SQLiteOpenHelper{

	private static final int databaseversion=1; //��Ʈw����
	private static final String databasename="carediary.db"; //��Ʈw�W��
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
		db.execSQL(strcreate); //�}�l�����Ʈw�إ�
		db.execSQL(strcreate2); //�}�l�����Ʈw�إ�
		Toast.makeText(mycontext, "��Ʈw�إߧ���", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		Toast.makeText(mycontext, "��Ʈw�w�}��", Toast.LENGTH_SHORT).show();
	}

}
