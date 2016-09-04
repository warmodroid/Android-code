package com.example.kharchamanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class second_k  extends Activity {
	double aa,bb,cc,tt,ph;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.second_k);
	Intent in =getIntent();
	aa=in.getDoubleExtra("aaa",0);
	bb=in.getDoubleExtra("bbb",0);
	cc=in.getDoubleExtra("ccc",0);
	tt=aa+bb+cc;
	ph=tt/3;
	TextView tv1=(TextView) findViewById(R.id.textView1);
	TextView tv2=(TextView) findViewById(R.id.textView2);
	TextView tv3=(TextView) findViewById(R.id.textView3);
	TextView tv4=(TextView) findViewById(R.id.textView4);
	TextView tv5=(TextView) findViewById(R.id.textView5);
	TextView tv6=(TextView) findViewById(R.id.textView6);
	TextView tv7=(TextView) findViewById(R.id.textView7);
	tv1.setText("Amount given by A="+aa);
	tv2.setText("Amount given by B="+bb);
	tv3.setText("Amount given by C="+cc);
	tv4.setText("Total Amount="+tt);
	tv5.setText("Per Head expenditure="+ph);
	if(aa>bb&&aa>cc)
	{
		if(bb>ph)
		{
			tv6.setText("C will give to A="+(aa-ph));
			tv7.setText("C will give to B="+(bb-ph));

		}
		else if(cc>ph)
		{
			tv6.setText("B will give to A="+(aa-ph));
			tv7.setText("B will give to C="+(cc-ph));

		}
		else
		{
		tv6.setText("B will give to A="+(ph-bb));
		tv7.setText("C will give to A="+(ph-cc));
		}
	}
	if(bb>aa&&bb>cc)
	{
		if(aa>ph)
		{
			tv6.setText("C will give to A="+(aa-ph));
			tv7.setText("C will give to B="+(bb-ph));

		}
		else if(cc>ph)
		{
			tv6.setText("A will give to B="+(bb-ph));
			tv7.setText("A will give to C="+(cc-ph));

		}
		else
		{
		tv6.setText("A will give to B="+(ph-aa));
		tv7.setText("C will give to B="+(ph-cc));
		}
	}
	if(cc>aa&&cc>bb)
	{
		if(aa>ph)
		{
			tv6.setText("B will give to A="+(aa-ph));
			tv7.setText("B will give to C="+(cc-ph));

		}
		else if(bb>ph)
		{
			tv6.setText("A will give to B="+(bb-ph));
			tv7.setText("A will give to C="+(cc-ph));

		}
		else
		{
		tv6.setText("A will give to C="+(ph-aa));
		tv7.setText("B will give to C="+(ph-bb));
		}
	}
	
	
}
}
