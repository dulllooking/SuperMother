package com.example.supermother;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

@SuppressLint("Registered") 
public class FlnEnter1 extends Activity {

	private TextView tv1=null;
	private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    private int count=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fln_enter1);
		
		tv1=(TextView)findViewById(R.id.textView2);
		progressBar=(ProgressBar)findViewById(R.id.progressBar1);
        // Start long running operation in a background thread
        
		new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                	int random=(int)(Math.random()*30);
                    progressStatus += random;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                        	if(progressStatus>=100){
                        		progressStatus=0;
                        		count++;
                        	}
                        	if(count==0){
                        		tv1.setText("冰箱庫存資料讀取進度:"+progressStatus+"/"+progressBar.getMax());
                        	}
                        	if(count==1){
                        		tv1.setText("食譜幫手資料讀取進度:"+progressStatus+"/"+progressBar.getMax());
                        	}
                        	if(count==2){
                        		tv1.setText("照護日記資料讀取進度:"+progressStatus+"/"+progressBar.getMax());
                        	}
                        	if(count==3){
                        		tv1.setText("飲料小幫手資料讀取進度:"+progressStatus+"/"+progressBar.getMax());
                        	}
                        	if(count==4){
                        		progressStatus=100;
                        	}
                            progressBar.setProgress((int)progressStatus);
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(count==4){
            		startActivity(new Intent(FlnEnter1.this, FlnItem2.class));
            		finish();
            	}
            }
        }).start();
	}

}
