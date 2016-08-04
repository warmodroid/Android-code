package com.example.kharchamanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class third_k extends Activity {
	double aa,bb,cc,dd,tt,ph,rc,ra,rd,rb;
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.third_k);
	Intent in =getIntent();
	aa=in.getDoubleExtra("aaa",0);
	bb=in.getDoubleExtra("bbb",0);
	cc=in.getDoubleExtra("ccc",0);
	dd=in.getDoubleExtra("ddd",0);
	tt=aa+bb+cc+dd;ph=tt/4;
	TextView tv1=(TextView) findViewById(R.id.textView1);
	TextView tv2=(TextView) findViewById(R.id.textView2);
	TextView tv3=(TextView) findViewById(R.id.textView3);
	TextView tv4=(TextView) findViewById(R.id.textView4);
	TextView tv5=(TextView) findViewById(R.id.textView5);
	TextView tv6=(TextView) findViewById(R.id.textView6);
	TextView tv7=(TextView) findViewById(R.id.textView7);
	TextView tv8=(TextView) findViewById(R.id.textView8);
	TextView tv9=(TextView) findViewById(R.id.textView9);
	tv1.setText("Amount given by A="+aa);
	tv2.setText("Amount given by B="+bb);
	tv3.setText("Amount given by C="+cc);
	tv4.setText("Amount given by D="+dd);
	tv5.setText("Total Amount="+tt);
	tv6.setText("Per head expenditure="+ph);
	if(aa>bb&&aa>cc&&aa>dd)
	{
		if(bb>ph&&!(cc>ph)&&!(dd>ph))
		{
			if((ph-cc)>=(aa-ph))
			{
				tv7.setText("C will give to A="+(aa-ph));
				rc=(ph-cc)-(aa-ph);
				tv8.setText("C will give to B="+rc);
				tv9.setText("D will give to B="+(ph-dd));
			}
			else if((ph-dd)>=(aa-ph))
			{
				tv7.setText("D will give to A="+(aa-ph));
				rd=(ph-dd)-(aa-ph);
				tv8.setText("D will give to B="+rd);
				tv9.setText("C will give to B="+(ph-cc));
			}
			else                                                    //8,7,6,6
			{
				tv7.setText("C will give to A="+(ph-cc));
				ra=(aa-ph)-(ph-cc);
				tv8.setText("D will give to A="+ra);
				tv9.setText("D will give to B="+(bb-ph));
			}
		}
		else if(cc>ph&&!(bb>ph)&&!(dd>ph))
		{
			if((ph-bb)>=(aa-ph))
			{
				tv7.setText("B will give to A="+(aa-ph));
				rb=(ph-bb)-(aa-ph);
				tv8.setText("B will give to C="+rb);
				tv9.setText("D will give to C="+(ph-dd));
			}
			else if((ph-dd)>=(aa-ph))
			{
				tv7.setText("D will give to A="+(aa-ph));
				rd=(ph-dd)-(aa-ph);
				tv8.setText("D will give to C="+rd);
				tv9.setText("B will give to C="+(ph-bb));
			}
			else                                                    //8,7,6,6
			{
				tv7.setText("B will give to A="+(ph-bb));
				ra=(aa-ph)-(ph-bb);
				tv8.setText("D will give to A="+ra);
				tv9.setText("D will give to C="+(cc-ph));
			}
		}
		else if(dd>ph&&!(bb>ph)&&!(cc>ph))
		{
			if((ph-cc)>=(aa-ph))
			{
				tv7.setText("C will give to A="+(aa-ph));
				rc=(ph-cc)-(aa-ph);
				tv8.setText("C will give to D="+rc);
				tv9.setText("B will give to D="+(ph-cc));
			}
			else if((ph-bb)>=(aa-ph))
			{
				tv7.setText("B will give to A="+(aa-ph));
				rb=(ph-bb)-(aa-ph);
				tv8.setText("B will give to D="+rb);
				tv9.setText("C will give to D="+(ph-cc));
			}
			else                                                    //8,7,6,6
			{
				tv7.setText("C will give to A="+(ph-cc));
				ra=(aa-ph)-(ph-cc);
				tv8.setText("B will give to A="+ra);
				tv9.setText("B will give to D="+(dd-ph));
			}
		}
		else if(bb>ph&&cc>ph)
		{
			tv7.setText("D will give to A="+(aa-ph));
			tv8.setText("D will give to B="+(bb-ph));
			tv9.setText("D will give to C="+(cc-ph));
		}
		else if(bb>ph&&dd>ph)
		{
			tv7.setText("C will give to A="+(aa-ph));
			tv8.setText("C will give to B="+(bb-ph));
			tv9.setText("C will give to D="+(dd-ph));
		}
		else if(cc>ph&&dd>ph)
		{
			tv7.setText("B will give to A="+(aa-ph));
			tv8.setText("B will give to C="+(cc-ph));
			tv9.setText("B will give to D="+(dd-ph));
		}
		else
		{
			tv7.setText("B will give to A="+(ph-bb));
			tv8.setText("C will give to A="+(ph-cc));
			tv9.setText("D will give to A="+(ph-dd));
		}
	}
	if(bb>aa&&bb>cc&&bb>dd)
	{
		if(aa>ph&&!(cc>ph)&&!(dd>ph))
		{
			if((ph-cc)>=(bb-ph))
			{
				tv7.setText("C will give to B="+(bb-ph));
				rc=(ph-cc)-(bb-ph);
				tv8.setText("C will give to A="+rc);
				tv9.setText("D will give to A="+(ph-dd));
			}
			else if((ph-dd)>=(bb-ph))
			{
				tv7.setText("D will give to B="+(bb-ph));
				rd=(ph-dd)-(bb-ph);
				tv8.setText("D will give to A="+rd);
				tv9.setText("C will give to A="+(ph-cc));
			}
			else                                                    //8,7,6,6
			{
				tv7.setText("C will give to B="+(ph-cc));
				rb=(bb-ph)-(ph-cc);
				tv8.setText("D will give to B="+rb);
				tv9.setText("D will give to A="+(aa-ph));
			}
		}
		else if(cc>ph&&!(aa>ph)&&!(dd>ph))
		{
			if((ph-aa)>=(bb-ph))
			{
				tv7.setText("A will give to B="+(bb-ph));
				ra=(ph-aa)-(bb-ph);
				tv8.setText("A will give to C="+ra);
				tv9.setText("D will give to C="+(ph-dd));
			}
			else if((ph-dd)>=(bb-ph))
			{
				tv7.setText("D will give to B="+(bb-ph));
				rd=(ph-dd)-(bb-ph);
				tv8.setText("D will give to C="+rd);
				tv9.setText("A will give to C="+(ph-aa));
			}
			else                                                    //8,7,6,6
			{
				tv7.setText("A will give to B="+(ph-aa));
				rb=(bb-ph)-(ph-aa);
				tv8.setText("D will give to B="+rb);
				tv9.setText("D will give to C="+(cc-ph));
			}
		}
		else if(dd>ph&&!(aa>ph)&&!(cc>ph))
		{
			if((ph-cc)>=(bb-ph))
			{
				tv7.setText("C will give to B="+(bb-ph));
				rc=(ph-cc)-(bb-ph);
				tv8.setText("C will give to D="+rc);
				tv9.setText("A will give to D="+(ph-cc));
			}
			else if((ph-aa)>=(bb-ph))
			{
				tv7.setText("A will give to B="+(bb-ph));
				ra=(ph-aa)-(bb-ph);
				tv8.setText("C will give to D="+ra);
				tv9.setText("C will give to D="+(ph-cc));
			}
			else                                                    //8,7,6,6
			{
				tv7.setText("C will give to B="+(ph-cc));
				rb=(bb-ph)-(ph-cc);
				tv8.setText("A will give to B="+rb);
				tv9.setText("A will give to D="+(dd-ph));
			}
		}
		else if(aa>ph&&cc>ph)
		{
			tv7.setText("D will give to B="+(bb-ph));
			tv8.setText("D will give to A="+(aa-ph));
			tv9.setText("D will give to C="+(cc-ph));
		}
		else if(aa>ph&&dd>ph)
		{
			tv7.setText("C will give to B="+(bb-ph));
			tv8.setText("C will give to A="+(aa-ph));
			tv9.setText("C will give to D="+(dd-ph));
		}
		else if(cc>ph&&dd>ph)
		{
			tv7.setText("A will give to B="+(bb-ph));
			tv8.setText("A will give to C="+(cc-ph));
			tv9.setText("A will give to D="+(dd-ph));
		}
		else
		{
			tv7.setText("A will give to B="+(ph-aa));
			tv8.setText("C will give to B="+(ph-cc));
			tv9.setText("D will give to B="+(ph-dd));
		}
	}
	if(cc>bb&&cc>aa&&cc>dd)
	{
		if(bb>ph&&!(aa>ph)&&!(dd>ph))
		{
			if((ph-aa)>=(cc-ph))
			{
				tv7.setText("A will give to C="+(cc-ph));
				ra=(ph-aa)-(cc-ph);
				tv8.setText("A will give to B="+ra);
				tv9.setText("D will give to B="+(ph-dd));
			}
			else if((ph-dd)>=(cc-ph))
			{
				tv7.setText("D will give to C="+(cc-ph));
				rd=(ph-dd)-(cc-ph);
				tv8.setText("D will give to B="+rd);
				tv9.setText("A will give to B="+(ph-aa));
			}
			else                                                    //8,7,6,6
			{
				tv7.setText("A will give to C="+(ph-aa));
				rc=(cc-ph)-(ph-aa);
				tv8.setText("D will give to C="+rc);
				tv9.setText("D will give to B="+(bb-ph));
			}
		}
		else if(aa>ph&&!(bb>ph)&&!(dd>ph))
		{
			if((ph-bb)>=(cc-ph))
			{
				tv7.setText("B will give to C="+(cc-ph));
				rb=(ph-bb)-(cc-ph);
				tv8.setText("B will give to A="+rb);
				tv9.setText("D will give to A="+(ph-dd));
			}
			else if((ph-dd)>=(cc-ph))
			{
				tv7.setText("D will give to C="+(cc-ph));
				rd=(ph-dd)-(cc-ph);
				tv8.setText("D will give to A="+rd);
				tv9.setText("B will give to A="+(ph-bb));
			}
			else                                                    //8,7,6,6
			{
				tv7.setText("B will give to C="+(ph-bb));
				rc=(cc-ph)-(ph-bb);
				tv8.setText("D will give to C="+rc);
				tv9.setText("D will give to A="+(aa-ph));
			}
		}
		else if(dd>ph&&!(bb>ph)&&!(aa>ph))
		{
			if((ph-aa)>=(cc-ph))
			{
				tv7.setText("A will give to C="+(cc-ph));
				ra=(ph-aa)-(cc-ph);
				tv8.setText("A will give to D="+ra);
				tv9.setText("B will give to D="+(ph-aa));
			}
			else if((ph-bb)>=(cc-ph))
			{
				tv7.setText("B will give to C="+(cc-ph));
				rb=(ph-bb)-(cc-ph);
				tv8.setText("B will give to D="+rb);
				tv9.setText("A will give to D="+(ph-aa));
			}
			else                                                    //8,7,6,6
			{
				tv7.setText("A will give to C="+(ph-aa));
				rc=(cc-ph)-(ph-aa);
				tv8.setText("B will give to C="+rc);
				tv9.setText("B will give to D="+(dd-ph));
			}
		}
		else if(bb>ph&&aa>ph)
		{
			tv7.setText("D will give to C="+(cc-ph));
			tv8.setText("D will give to B="+(bb-ph));
			tv9.setText("D will give to A="+(aa-ph));
		}
		else if(bb>ph&&dd>ph)
		{
			tv7.setText("A will give to C="+(cc-ph));
			tv8.setText("A will give to B="+(bb-ph));
			tv9.setText("A will give to D="+(dd-ph));
		}
		else if(aa>ph&&dd>ph)
		{
			tv7.setText("B will give to C="+(cc-ph));
			tv8.setText("B will give to A="+(aa-ph));
			tv9.setText("B will give to D="+(dd-ph));
		}
		else
		{
			tv7.setText("B will give to C="+(ph-bb));
			tv8.setText("A will give to C="+(ph-aa));
			tv9.setText("D will give to C="+(ph-dd));
		}
	}
	if(dd>bb&&dd>cc&&dd>aa)
	{
		if(bb>ph&&!(aa>ph)&&!(cc>ph))
		{
			if((ph-cc)>=(dd-ph))
			{
				tv7.setText("C will give to D="+(dd-ph));
				rc=(ph-cc)-(dd-ph);
				tv8.setText("C will give to B="+rc);
				tv9.setText("A will give to B="+(ph-aa));
			}
			else if((ph-aa)>=(dd-ph))
			{
				tv7.setText("A will give to D="+(dd-ph));
				ra=(ph-aa)-(dd-ph);
				tv8.setText("A will give to B="+ra);
				tv9.setText("C will give to B="+(ph-cc));
			}
			else                                                    //8,7,6,6
			{
				tv7.setText("C will give to D="+(ph-cc));
				rd=(dd-ph)-(ph-cc);
				tv8.setText("A will give to D="+rd);
				tv9.setText("A will give to B="+(bb-ph));
			}
		}
		else if(cc>ph&&!(aa>ph)&&!(bb>ph))
		{
			if((ph-bb)>=(dd-ph))
			{
				tv7.setText("B will give to D="+(dd-ph));
				rb=(ph-bb)-(dd-ph);
				tv8.setText("B will give to C="+rb);
				tv9.setText("A will give to C="+(ph-aa));
			}
			else if((ph-aa)>=(dd-ph))
			{
				tv7.setText("A will give to D="+(dd-ph));
				ra=(ph-aa)-(dd-ph);
				tv8.setText("A will give to C="+ra);
				tv9.setText("B will give to C="+(ph-bb));
			}
			else                                                    //8,7,6,6
			{
				tv7.setText("B will give to D="+(ph-bb));
				rd=(dd-ph)-(ph-bb);
				tv8.setText("A will give to D="+rd);
				tv9.setText("A will give to C="+(cc-ph));
			}
		}
		else if(aa>ph&&!(bb>ph)&&!(cc>ph))
		{
			if((ph-cc)>=(dd-ph))
			{
				tv7.setText("C will give to D="+(dd-ph));
				rc=(ph-cc)-(dd-ph);
				tv8.setText("C will give to A="+rc);
				tv9.setText("B will give to A="+(ph-cc));
			}
			if((ph-bb)>=(dd-ph))
			{
				tv7.setText("B will give to D="+(dd-ph));
				rb=(ph-bb)-(dd-ph);
				tv8.setText("B will give to A="+rb);
				tv9.setText("C will give to A="+(ph-cc));
			}
			else                                                    //8,7,6,6
			{
				tv7.setText("C will give to D="+(ph-cc));
				rd=(dd-ph)-(ph-cc);
				tv8.setText("B will give to D="+rd);
				tv9.setText("B will give to D="+(aa-ph));
			}
		}
		else if(bb>ph&&cc>ph)
		{
			tv7.setText("A will give to D="+(dd-ph));
			tv8.setText("A will give to B="+(bb-ph));
			tv9.setText("A will give to C="+(cc-ph));
		}
		else if(bb>ph&&aa>ph)
		{
			tv7.setText("C will give to D="+(dd-ph));
			tv8.setText("C will give to B="+(bb-ph));
			tv9.setText("C will give to A="+(aa-ph));
		}
		else if(cc>ph&&aa>ph)
		{
			tv7.setText("B will give to D="+(dd-ph));
			tv8.setText("B will give to C="+(cc-ph));
			tv9.setText("B will give to A="+(aa-ph));
		}
		else
		{
			tv7.setText("B will give to D="+(ph-bb));
			tv8.setText("C will give to D="+(ph-cc));
			tv9.setText("D will give to D="+(ph-aa));
		}
	}

}
}
