package com.example.kharchamanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class fifth_k extends Activity {
	double aa,bb,cc,dd,ee,ff,tt,ph;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fifth_k);
		Intent in =getIntent();
		aa=in.getDoubleExtra("aaa",0);
		bb=in.getDoubleExtra("bbb",0);
		cc=in.getDoubleExtra("ccc",0);
		dd=in.getDoubleExtra("ddd",0);
		ee=in.getDoubleExtra("eee",0);
		ff=in.getDoubleExtra("fff",0);
		tt=(aa+bb+cc+dd+ee+ff);
		ph=tt/6;
		TextView tv1=(TextView) findViewById(R.id.textView1);
		
		tv1.setText("COMING SOON>>>>");
		
		
	}

}
