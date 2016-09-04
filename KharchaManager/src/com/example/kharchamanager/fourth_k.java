package com.example.kharchamanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class fourth_k extends Activity {
	double aa,bb,cc,dd,ee,tt,ph,ra,rb,rc,rd,re,tot,ra2,rb2,rc2,rd2,re2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fourth_k);
		Intent in =getIntent();
		aa=in.getDoubleExtra("aaa",0);
		bb=in.getDoubleExtra("bbb",0);
		cc=in.getDoubleExtra("ccc",0);
		dd=in.getDoubleExtra("ddd",0);
		dd=in.getDoubleExtra("ddd",0);
		ee=in.getDoubleExtra("eee",0);
		tot=(aa+bb+cc+dd+ee);
		ph=(aa+bb+cc+dd+ee)/5;
		TextView tv1=(TextView) findViewById(R.id.textView1);
		TextView tv2=(TextView) findViewById(R.id.textView2);
		TextView tv3=(TextView) findViewById(R.id.textView3);
		TextView tv4=(TextView) findViewById(R.id.textView4);
		TextView tv5=(TextView) findViewById(R.id.textView5);
		TextView tv6=(TextView) findViewById(R.id.textView6);
		TextView tv7=(TextView) findViewById(R.id.textView7);
		TextView tv8=(TextView) findViewById(R.id.textView8);
		TextView tv9=(TextView) findViewById(R.id.textView9);
		TextView tv10=(TextView) findViewById(R.id.textView10);
		TextView tv11=(TextView) findViewById(R.id.textView11);
		
		tv1.setText("Amount given by A="+aa);
		tv2.setText("Amount given by B="+bb);
		tv3.setText("Amount given by C="+cc);
		tv4.setText("Amount given by D="+dd);
		tv5.setText("Amount given by E="+ee);
		tv6.setText("Total Amount ="+tot);
		tv7.setText("Per head expenditure="+ph);
		if(aa>bb && aa>cc && aa>dd && aa>ee)
		{
		
			//all the case for one queen
			
			if(ee>ph && !(bb>ph) && !(cc>ph) && !(dd>ph) )  
			//E as one queen 
			{
				if((ph-dd)>(ph-bb) && (ph-dd)>(ph-cc))
				{
					tv8.setText("D will give to A = "+(ph-dd));
					ra=(aa-ph)-(ph-dd);
					if((ph-bb)>(ph-cc))
					{
						tv9.setText("B will give to A = "+ra);
						rb=(ph-bb)-ra;
						tv10.setText("C will give to E = "+(ph-cc));
						tv11.setText("B will give to E = "+rb);
					}
					else
					{
						tv9.setText("C will give to A = "+ra);
						rc=(ph-cc)-ra;
						tv10.setText("B will give to E = "+(ph-bb));
						tv11.setText("C will give to E = "+rc);
					}
				}
				else if((ph-bb)>(ph-dd) && (ph-bb)>(ph-cc))
				{
					tv8.setText("B will give to A = "+(ph-bb));
					ra=(aa-ph)-(ph-bb);
					if((ph-dd)>(ph-cc))
					{
						tv9.setText("D will give to A = "+ra);
						rd=(ph-dd)-ra;
						tv10.setText("C will give to E = "+(ph-cc));
						tv11.setText("D will give to E = "+rb);
					}
					else
					{
						tv9.setText("C will give to A = "+ra);
						rc=(ph-cc)-ra;
						tv10.setText("D will give to E = "+(ph-dd));
						tv11.setText("C will give to E = "+rc);
					}
				}
				else if((ph-cc)>(ph-bb) && (ph-cc)>(ph-dd))
				{
					tv8.setText("C will give to A = "+(ph-cc));
					ra=(aa-ph)-(ph-cc);
					if((ph-bb)>(ph-dd))
					{
						tv9.setText("B will give to A = "+ra);
						rb=(ph-bb)-ra;
						tv10.setText("D will give to E = "+(ph-dd));
						tv11.setText("B will give to E = "+rb);
					}
					else
					{
						tv9.setText("D will give to A = "+ra);
						rd=(ph-dd)-ra;
						tv10.setText("B will give to E = "+(ph-bb));
						tv11.setText("D will give to E = "+rd);
					}
				}
			}
			 
			//now D as one queen
			else if(dd>ph && !(bb>ph)&& !(cc>ph) && !(ee>ph))
			{
				if((ph-ee)>(ph-bb) && (ph-ee)>(ph-cc))
				{
					tv8.setText("E will give to A = "+(ph-ee));
					ra=(aa-ph)-(ph-ee);
					if((ph-bb)>(ph-cc))
					{
						tv9.setText("B will give to A = "+ra);
						rb=(ph-bb)-ra;
						tv10.setText("C will give to D = "+(ph-cc));
						tv11.setText("B will give to D = "+rb);
					}
					else
					{
						tv9.setText("C will give to A = "+ra);
						rc=(ph-cc)-ra;
						tv10.setText("B will give to D = "+(ph-bb));
						tv11.setText("C will give to D = "+rc);
					}
				}
				else if((ph-bb)>(ph-ee) && (ph-bb)>(ph-cc))
				{
					tv8.setText("B will give to A = "+(ph-bb));
					ra=(aa-ph)-(ph-bb);
					if((ph-ee)>(ph-cc))
					{
						tv9.setText("E will give to A = "+ra);
						re=(ph-ee)-ra;
						tv10.setText("C will give to D = "+(ph-cc));
						tv11.setText("E will give to D = "+rb);
					}
					else
					{
						tv9.setText("C will give to A = "+ra);
						rc=(ph-cc)-ra;
						tv10.setText("E will give to D = "+(ph-ee));
						tv11.setText("C will give to D = "+rc);
					}
				}
				else if((ph-cc)>(ph-bb) && (ph-cc)>(ph-ee))
				{
					tv8.setText("C will give to A = "+(ph-cc));
					ra=(aa-ph)-(ph-cc);
					if((ph-bb)>(ph-ee))
					{
						tv9.setText("B will give to A = "+ra);
						rb=(ph-bb)-ra;
						tv10.setText("E will give to D = "+(ph-ee));
						tv11.setText("B will give to D = "+rb);
					}
					else
					{
						tv9.setText("E will give to A = "+ra);
						re=(ph-ee)-ra;
						tv10.setText("B will give to D = "+(ph-bb));
						tv11.setText("E will give to D = "+re);
					}
				}
			}
			//now C as one queen
			else if(cc>ph && !(bb>ph)&& !(dd>ph) && !(ee>ph))
			{
				if((ph-ee)>(ph-bb) && (ph-ee)>(ph-dd))
				{
					tv8.setText("E will give to A = "+(ph-ee));
					ra=(aa-ph)-(ph-ee);
					if((ph-bb)>(ph-dd))
					{
						tv9.setText("B will give to A = "+ra);
						rb=(ph-bb)-ra;
						tv10.setText("D will give to C = "+(ph-dd));
						tv11.setText("B will give to C = "+rb);
					}
					else
					{
						tv9.setText("D will give to A = "+ra);
						rd=(ph-dd)-ra;
						tv10.setText("B will give to C = "+(ph-bb));
						tv11.setText("D will give to C = "+rd);
					}
				}
				else if((ph-bb)>(ph-ee) && (ph-bb)>(ph-dd))
				{
					tv8.setText("B will give to A = "+(ph-bb));
					ra=(aa-ph)-(ph-bb);
					if((ph-ee)>(ph-dd))
					{
						tv9.setText("E will give to A = "+ra);
						re=(ph-ee)-ra;
						tv10.setText("D will give to C = "+(ph-dd));
						tv11.setText("E will give to C = "+rb);
					}
					else
					{
						tv9.setText("D will give to A = "+ra);
						rd=(ph-dd)-ra;
						tv10.setText("E will give to C = "+(ph-ee));
						tv11.setText("D will give to C = "+rd);
					}
				}
				else if((ph-dd)>(ph-bb) && (ph-dd)>(ph-ee))
				{
					tv8.setText("D will give to A = "+(ph-dd));
					ra=(aa-ph)-(ph-dd);
					if((ph-bb)>(ph-ee))
					{
						////////////////////////
						if(ra>=(ph-bb))
						{
							tv9.setText("B will give to A = "+(ph-bb));
							ra2=ra-(ph-bb);		
							tv10.setText("E will give to A = "+ra2);
							re=(ph-ee)-ra2;
							tv11.setText("E will give to D = "+re);
						}
					else
						{
						tv9.setText("B will give to A = "+ra);
						rb=(ph-bb)-ra;
						tv10.setText("E will give to C = "+(ph-ee));
						tv11.setText("B will give to C = "+rb);
						}
					}
					else
					{
						tv9.setText("E will give to A = "+ra);
						re=(ph-ee)-ra;
						tv10.setText("B will give to C = "+(ph-bb));
						tv11.setText("E will give to C = "+re);
					}
				}
			}
			//now B as one queen
			else if(bb>ph && !(cc>ph)&& !(dd>ph) && !(ee>ph))
			{
				if((ph-ee)>(ph-dd) && (ph-ee)>(ph-cc))
				{
					tv8.setText("E will dive to A = "+(ph-ee));
					ra=(aa-ph)-(ph-ee);
					if((ph-dd)>(ph-cc))
					{
						tv9.setText("D will dive to A = "+ra);
						rd=(ph-dd)-ra;
						tv10.setText("C will dive to B = "+(ph-cc));
						tv11.setText("D will dive to B = "+rd);
					}
					else
					{
						tv9.setText("C will dive to A = "+ra);
						rc=(ph-cc)-ra;
						tv10.setText("D will dive to B = "+(ph-dd));
						tv11.setText("C will dive to B = "+rc);
					}
				}
				else if((ph-dd)>(ph-ee) && (ph-dd)>(ph-cc))
				{
					tv8.setText("D will dive to A = "+(ph-dd));
					ra=(aa-ph)-(ph-dd);
					if((ph-ee)>(ph-cc))
					{
						tv9.setText("E will dive to A = "+ra);
						re=(ph-ee)-ra;
						tv10.setText("C will dive to B = "+(ph-cc));
						tv11.setText("E will dive to B = "+rd);
					}
					else
					{
						tv9.setText("C will dive to A = "+ra);
						rc=(ph-cc)-ra;
						tv10.setText("E will dive to B = "+(ph-ee));
						tv11.setText("C will dive to B = "+rc);
					}
				}
				else if((ph-cc)>(ph-dd) && (ph-cc)>(ph-ee))
				{
					tv8.setText("C will dive to A = "+(ph-cc));
					ra=(aa-ph)-(ph-cc);
					if((ph-dd)>(ph-ee))
					{
						tv9.setText("D will dive to A = "+ra);
						rd=(ph-dd)-ra;
						tv10.setText("E will dive to B = "+(ph-ee));
						tv11.setText("D. will dive to B = "+rd);
					}
					else
					{
						tv9.setText("E will dive to A = "+ra);
						re=(ph-ee)-ra;
						tv10.setText("D will dive to B = "+(ph-dd));
						tv11.setText("E will dive to B = "+re);
					}
				}
			}
			//ALL cases for 1 queen has been completed
			//Now cases for 2 queen STARTS
			//D and E as 2 queen
			else if(ee>ph && dd>ph && !(cc>ph) && !(bb>ph))
			{
				if(((aa-ph)>=(ph-bb))&&((aa-ph)>=(ph-cc)))
				{
					tv8.setText("B will give to A ="+(ph-bb));
					ra=(aa-ph)-(ph-bb);
					tv9.setText("C will give to A ="+ra);
					tv10.setText("C will give to D ="+(dd-ph));
					tv11.setText("C will give to E ="+(ee-ph));
				}
				if((ph-bb)>(aa-ph) && !((ph-cc)>(aa-ph)))
				{
					tv8.setText("C will give to A ="+(ph-cc));
					ra=(aa-ph)-(ph-cc);
					tv9.setText("B will give to A ="+ra);
					tv10.setText("B will give to D ="+(dd-ph));
					tv11.setText("B will give to E ="+(ee-ph));
				}
				if(!((ph-bb)>(aa-ph)) && (ph-cc)>(aa-ph))
				{
					tv8.setText("B will give to A ="+(ph-bb));
					ra=(aa-ph)-(ph-bb);
					tv9.setText("C will give to A ="+ra);
					tv10.setText("C will give to D ="+(dd-ph));
					tv11.setText("C will give to E ="+(ee-ph));
				}
			}
			//C and E as queen
			else if(ee>ph && cc>ph && !(dd>ph) && !(bb>ph))
			{
				if(((aa-ph)>=(ph-bb))&&((aa-ph)>=(ph-dd)))
				{
					tv8.setText("B will give to A ="+(ph-bb));
					ra=(aa-ph)-(ph-bb);
					tv9.setText("D will give to A ="+ra);
					tv10.setText("D will give to C ="+(cc-ph));
					tv11.setText("D will give to E ="+(ee-ph));
				}
				if((ph-bb)>(aa-ph) && !((ph-dd)>(aa-ph)))
				{
					tv8.setText("D will give to A ="+(ph-dd));
					ra=(aa-ph)-(ph-dd);
					tv9.setText("B will give to A ="+ra);
					tv10.setText("B will give to C ="+(cc-ph));
					tv11.setText("B will give to E ="+(ee-ph));
				}
				if(!((ph-bb)>(aa-ph)) && (ph-dd)>(aa-ph))
				{
					tv8.setText("B will give to A ="+(ph-bb));
					ra=(aa-ph)-(ph-bb);
					tv9.setText("D will give to A ="+ra);
					tv10.setText("D will give to C ="+(cc-ph));
					tv11.setText("D will give to E ="+(ee-ph));
				}
			}
			//C and D as queen
			else if(dd>ph && cc>ph && !(ee>ph) && !(bb>ph))
			{
				if(((aa-ph)>=(ph-bb))&&((aa-ph)>=(ph-ee)))
				{
					tv8.setText("B will give to A ="+(ph-bb));
					ra=(aa-ph)-(ph-bb);
					tv9.setText("E will give to A ="+ra);
					tv10.setText("E will give to C ="+(cc-ph));
					tv11.setText("E will give to D ="+(dd-ph));
				}
				if((ph-bb)>(aa-ph) && !((ph-ee)>(aa-ph)))
				{
					tv8.setText("E will give to A ="+(ph-ee));
					ra=(aa-ph)-(ph-ee);
					tv9.setText("B will give to A ="+ra);
					tv10.setText("B will give to C ="+(cc-ph));
					tv11.setText("B will give to D ="+(dd-ph));
				}
				if(!((ph-bb)>(aa-ph)) && (ph-ee)>(aa-ph))
				{
					tv8.setText("B will give to A ="+(ph-bb));
					ra=(aa-ph)-(ph-bb);
					tv9.setText("E will give to A ="+ra);
					tv10.setText("E will give to C ="+(cc-ph));
					tv11.setText("E will give to D ="+(dd-ph));
				}
			}
			//B and E as queen
			else if(ee>ph && bb>ph && !(dd>ph) && !(cc>ph))
			{
				if(((aa-ph)>=(ph-cc))&&((aa-ph)>=(ph-dd)))
				{
					tv8.setText("C will give to A ="+(ph-cc));
					ra=(aa-ph)-(ph-cc);
					tv9.setText("D will give to A ="+ra);
					tv10.setText("D will give to B ="+(bb-ph));
					tv11.setText("D will give to E ="+(ee-ph));
				}
				if((ph-cc)>(aa-ph) && !((ph-dd)>(aa-ph)))
				{
					tv8.setText("D will give to A ="+(ph-dd));
					ra=(aa-ph)-(ph-dd);
					tv9.setText("C will give to A ="+ra);
					tv10.setText("C will give to B ="+(bb-ph));
					tv11.setText("C will give to E ="+(ee-ph));
				}
				if(!((ph-cc)>(aa-ph)) && (ph-dd)>(aa-ph))
				{
					tv8.setText("C will give to A ="+(ph-cc));
					ra=(aa-ph)-(ph-cc);
					tv9.setText("D will give to A ="+ra);
					tv10.setText("D will give to B ="+(bb-ph));
					tv11.setText("D will give to E ="+(ee-ph));
				}
			}
			//B and D as queen
			else if(dd>ph && bb>ph && !(ee>ph) && !(cc>ph))
			{
				if(((aa-ph)>=(ph-cc))&&((aa-ph)>=(ph-ee)))
				{
					tv8.setText("C will give to A ="+(ph-cc));
					ra=(aa-ph)-(ph-cc);
					tv9.setText("E will give to A ="+ra);
					tv10.setText("E will give to B ="+(bb-ph));
					tv11.setText("E will give to D ="+(dd-ph));
				}
				if((ph-cc)>(aa-ph) && !((ph-ee)>(aa-ph)))
				{
					tv8.setText("E will give to A ="+(ph-ee));
					ra=(aa-ph)-(ph-ee);
					tv9.setText("C will give to A ="+ra);
					tv10.setText("C will give to B ="+(bb-ph));
					tv11.setText("C will give to D ="+(dd-ph));
				}
				if(!((ph-cc)>(aa-ph)) && (ph-ee)>(aa-ph))
				{
					tv8.setText("C will give to A ="+(ph-cc));
					ra=(aa-ph)-(ph-cc);
					tv9.setText("E will give to A ="+ra);
					tv10.setText("E will give to B ="+(bb-ph));
					tv11.setText("E will give to D ="+(dd-ph));
				}
			}
			//B and C as queen
			else if(cc>ph && bb>ph && !(ee>ph) && !(dd>ph))
			{
				if(((aa-ph)>=(ph-dd))&&((aa-ph)>=(ph-ee)))
				{
					tv8.setText("D will give to A ="+(ph-dd));
					ra=(aa-ph)-(ph-dd);
					tv9.setText("E will give to A ="+ra);
					tv10.setText("E will give to B ="+(bb-ph));
					tv11.setText("E will give to C ="+(cc-ph));
				}
				if((ph-dd)>(aa-ph) && !((ph-ee)>(aa-ph)))
				{
					tv8.setText("E will give to A ="+(ph-ee));
					ra=(aa-ph)-(ph-ee);
					tv9.setText("D will give to A ="+ra);
					tv10.setText("D will give to B ="+(bb-ph));
					tv11.setText("D will give to C ="+(cc-ph));
				}
				if(!((ph-dd)>(aa-ph)) && (ph-ee)>(aa-ph))
				{
					tv8.setText("D will give to A ="+(ph-dd));
					ra=(aa-ph)-(ph-dd);
					tv9.setText("E will give to A ="+ra);
					tv10.setText("E will give to B ="+(bb-ph));
					tv11.setText("E will give to C ="+(cc-ph));
				}
			}
			//CASES for all 2 queens has been over here.
			//NOW cases for all three queens STARTS...
			//C,D,E as queens
			else if(ee>ph && dd>ph && cc>ph && !(bb>ph))
			{
				tv8.setText("B will give to A ="+(aa-ph));
				tv9.setText("B will give to C ="+(cc-ph));
				tv10.setText("B will give to D ="+(dd-ph));
				tv11.setText("B will give to E ="+(ee-ph));
			}
			//B,D,E as queen
			else if(ee>ph && dd>ph && dd>ph && !(cc>ph))
			{
				tv8.setText("C will give to A ="+(aa-ph));
				tv9.setText("C will give to B ="+(bb-ph));
				tv10.setText("C will give to D ="+(dd-ph));
				tv11.setText("C will give to E ="+(ee-ph));
			}
			//B,C,E as queen
			else if(ee>ph && cc>ph && bb>ph && !(dd>ph))
			{
				tv8.setText("D will give to A ="+(aa-ph));
				tv9.setText("D will give to B ="+(bb-ph));
				tv10.setText("D will give to C ="+(cc-ph));
				tv11.setText("D will give to E ="+(ee-ph));
			}
			//B,C,D as queen
			else if(dd>ph && cc>ph && bb>ph && !(ee>ph))
			{
				tv8.setText("E will give to A ="+(aa-ph));
				tv9.setText("E will give to B ="+(bb-ph));
				tv10.setText("E will give to C ="+(cc-ph));
				tv11.setText("E will give to D ="+(dd-ph));
			}
			
			//case of zero queen
			else 
			{
				tv8.setText("B will give to A ="+(ph-bb));
				tv9.setText("C will give to A ="+(ph-cc));
				tv10.setText("D will give to A ="+(ph-dd));
				tv11.setText("E will give to A ="+(ph-ee));
			}
		}
		//B as queen
		else if(bb>aa && bb>cc && bb>dd && bb>ee)
		{
		
			//bll the cbse for one queen
			
			if(ee>ph && !(aa>ph) && !(cc>ph) && !(dd>ph) )  
			//E bs one queen 
			{
				if((ph-dd)>(ph-aa) && (ph-dd)>(ph-cc))
				{
					tv8.setText("D will give to B = "+(ph-dd));
					rb=(bb-ph)-(ph-dd);
					if((ph-aa)>(ph-cc))
					{
						tv9.setText("A will give to B = "+rb);
						ra=(ph-aa)-rb;
						tv10.setText("C will give to E = "+(ph-cc));
						tv11.setText("A will give to E = "+ra);
					}
					else
					{
						tv9.setText("C will give to B = "+rb);
						rc=(ph-cc)-rb;
						tv10.setText("A will give to E = "+(ph-aa));
						tv11.setText("C will give to E = "+rc);
					}
				}
				else if((ph-aa)>(ph-dd) && (ph-aa)>(ph-cc))
				{
					tv8.setText("A will give to B = "+(ph-aa));
					rb=(bb-ph)-(ph-aa);
					if((ph-dd)>(ph-cc))
					{
						tv9.setText("D will give to B = "+rb);
						rd=(ph-dd)-rb;
						tv10.setText("C will give to E = "+(ph-cc));
						tv11.setText("D will give to E = "+ra);
					}
					else
					{
						tv9.setText("C will give to B = "+rb);
						rc=(ph-cc)-rb;
						tv10.setText("D will give to E = "+(ph-dd));
						tv11.setText("C will give to E = "+rc);
					}
				}
				else if((ph-cc)>(ph-aa) && (ph-cc)>(ph-dd))
				{
					tv8.setText("C will give to B = "+(ph-cc));
					rb=(bb-ph)-(ph-cc);
					if((ph-aa)>(ph-dd))
					{
						tv9.setText("A will give to B = "+rb);
						ra=(ph-aa)-rb;
						tv10.setText("D will give to E = "+(ph-dd));
						tv11.setText("A will give to E = "+ra);
					}
					else
					{
						tv9.setText("D will give to B = "+rb);
						rd=(ph-dd)-rb;
						tv10.setText("A will give to E = "+(ph-aa));
						tv11.setText("D will give to E = "+rd);
					}
				}
			}
			 
			//now D bs one queen
			else if(dd>ph && !(aa>ph)&& !(cc>ph) && !(ee>ph))
			{
				if((ph-ee)>(ph-aa) && (ph-ee)>(ph-cc))
				{
					tv8.setText("E will give to B = "+(ph-ee));
					rb=(bb-ph)-(ph-ee);
					if((ph-aa)>(ph-cc))
					{
						tv9.setText("A will give to B = "+rb);
						ra=(ph-aa)-rb;
						tv10.setText("C will give to D = "+(ph-cc));
						tv11.setText("A will give to D = "+ra);
					}
					else
					{
						tv9.setText("C will give to B = "+rb);
						rc=(ph-cc)-rb;
						tv10.setText("A will give to D = "+(ph-aa));
						tv11.setText("C will give to D = "+rc);
					}
				}
				else if((ph-aa)>(ph-ee) && (ph-aa)>(ph-cc))
				{
					tv8.setText("A will give to B = "+(ph-aa));
					rb=(bb-ph)-(ph-aa);
					if((ph-ee)>(ph-cc))
					{
						tv9.setText("E will give to B = "+rb);
						re=(ph-ee)-rb;
						tv10.setText("C will give to D = "+(ph-cc));
						tv11.setText("E will give to D = "+ra);
					}
					else
					{
						tv9.setText("C will give to B = "+rb);
						rc=(ph-cc)-rb;
						tv10.setText("E will give to D = "+(ph-ee));
						tv11.setText("C will give to D = "+rc);
					}
				}
				else if((ph-cc)>(ph-aa) && (ph-cc)>(ph-ee))
				{
					tv8.setText("C will give to B = "+(ph-cc));
					rb=(bb-ph)-(ph-cc);
					if((ph-aa)>(ph-ee))
					{
						tv9.setText("A will give to b = "+rb);
						ra=(ph-aa)-rb;
						tv10.setText("E will give to D = "+(ph-ee));
						tv11.setText("A will give to D = "+ra);
					}
					else
					{
						tv9.setText("E will give to B = "+rb);
						re=(ph-ee)-rb;
						tv10.setText("A will give to D = "+(ph-aa));
						tv11.setText("E will give to D = "+re);
					}
				}
			}
			//now C bs one queen
			else if(cc>ph && !(aa>ph)&& !(dd>ph) && !(ee>ph))
			{
				if((ph-ee)>(ph-aa) && (ph-ee)>(ph-dd))
				{
					tv8.setText("E will give to B = "+(ph-ee));
					rb=(bb-ph)-(ph-ee);
					if((ph-aa)>(ph-dd))
					{
						tv9.setText("A will give to B = "+rb);
						ra=(ph-aa)-rb;
						tv10.setText("D will give to C = "+(ph-dd));
						tv11.setText("A will give to C = "+ra);
					}
					else
					{
						tv9.setText("D will give to B = "+rb);
						rd=(ph-dd)-rb;
						tv10.setText("A will give to C = "+(ph-aa));
						tv11.setText("D will give to C = "+rd);
					}
				}
				else if((ph-aa)>(ph-ee) && (ph-aa)>(ph-dd))
				{
					tv8.setText("A will give to B = "+(ph-aa));
					rb=(bb-ph)-(ph-aa);
					if((ph-ee)>(ph-dd))
					{
						tv9.setText("E will give to B = "+rb);
						re=(ph-ee)-rb;
						tv10.setText("D will give to C = "+(ph-dd));
						tv11.setText("E will give to C = "+ra);
					}
					else
					{
						tv9.setText("D will give to B = "+rb);
						rd=(ph-dd)-rb;
						tv10.setText("E will give to C = "+(ph-ee));
						tv11.setText("D will give to C = "+rd);
					}
				}
				else if((ph-dd)>(ph-aa) && (ph-dd)>(ph-ee))
				{
					tv8.setText("D will give to B = "+(ph-dd));
					rb=(bb-ph)-(ph-dd);
					if((ph-aa)>(ph-ee))
					{
						tv9.setText("A will give to B = "+rb);
						ra=(ph-aa)-rb;
						tv10.setText("E will give to C = "+(ph-ee));
						tv11.setText("A will give to C = "+ra);
					}
					else
					{
						tv9.setText("E will give to B = "+rb);
						re=(ph-ee)-rb;
						tv10.setText("A will give to C = "+(ph-aa));
						tv11.setText("E will give to C = "+re);
					}
				}
			}
			//now a bs one queen
			else if(aa>ph && !(cc>ph)&& !(dd>ph) && !(ee>ph))
			{
				if((ph-ee)>(ph-dd) && (ph-ee)>(ph-cc))
				{
					tv8.setText("E will dive to B = "+(ph-ee));
					rb=(bb-ph)-(ph-ee);
					if((ph-dd)>(ph-cc))
					{
						tv9.setText("D will dive to B = "+rb);
						rd=(ph-dd)-rb;
						tv10.setText("C will dive to A = "+(ph-cc));
						tv11.setText("D will dive to A = "+rd);
					}
					else
					{
						tv9.setText("C will dive to B = "+rb);
						rc=(ph-cc)-rb;
						tv10.setText("D will dive to A = "+(ph-dd));
						tv11.setText("C will dive to A = "+rc);
					}
				}
				else if((ph-dd)>(ph-ee) && (ph-dd)>(ph-cc))
				{
					tv8.setText("D will dive to B = "+(ph-dd));
					rb=(bb-ph)-(ph-dd);
					if((ph-ee)>(ph-cc))
					{
						tv9.setText("E will dive to B = "+rb);
						re=(ph-ee)-rb;
						tv10.setText("C will dive to A = "+(ph-cc));
						tv11.setText("E will dive to A = "+rd);
					}
					else
					{
						tv9.setText("C will dive to B = "+rb);
						rc=(ph-cc)-rb;
						tv10.setText("E will dive to A = "+(ph-ee));
						tv11.setText("C will dive to A = "+rc);
					}
				}
				else if((ph-cc)>(ph-dd) && (ph-cc)>(ph-ee))
				{
					tv8.setText("C will dive to b = "+(ph-cc));
					rb=(bb-ph)-(ph-cc);
					if((ph-dd)>(ph-ee))
					{
						tv9.setText("D will dive to B = "+rb);
						rd=(ph-dd)-rb;
						tv10.setText("E will dive to A = "+(ph-ee));
						tv11.setText("D. will dive to A = "+rd);
					}
					else
					{
						tv9.setText("E will dive to B = "+rb);
						re=(ph-ee)-rb;
						tv10.setText("D will dive to A = "+(ph-dd));
						tv11.setText("E will dive to A = "+re);
					}
				}
			}
			//bLL cbses for 1 queen hbs aeen completed
			//Now cbses for 2 queen STbRTS
			//D bnd E bs 2 queen
			else if(ee>ph && dd>ph && !(cc>ph) && !(aa>ph))
			{
				if(((bb-ph)>=(ph-aa))&&((bb-ph)>=(ph-cc)))
				{
					tv8.setText("A will give to B ="+(ph-aa));
					rb=(bb-ph)-(ph-aa);
					tv9.setText("C will give to B ="+rb);
					tv10.setText("C will give to D ="+(dd-ph));
					tv11.setText("C will give to E ="+(ee-ph));
				}
				if((ph-aa)>(bb-ph) && !((ph-cc)>(bb-ph)))
				{
					tv8.setText("C will give to B ="+(ph-cc));
					rb=(bb-ph)-(ph-cc);
					tv9.setText("A will give to B ="+rb);
					tv10.setText("A will give to D ="+(dd-ph));
					tv11.setText("A will give to E ="+(ee-ph));
				}
				if(!((ph-aa)>(bb-ph)) && (ph-cc)>(bb-ph))
				{
					tv8.setText("A will give to B ="+(ph-aa));
					rb=(bb-ph)-(ph-aa);
					tv9.setText("C will give to B ="+rb);
					tv10.setText("C will give to D ="+(dd-ph));
					tv11.setText("C will give to E ="+(ee-ph));
				}
			}
			//C bnd E bs queen
			else if(ee>ph && cc>ph && !(dd>ph) && !(aa>ph))
			{
				if(((bb-ph)>=(ph-aa))&&((bb-ph)>=(ph-dd)))
				{
					tv8.setText("A will give to B ="+(ph-aa));
					rb=(bb-ph)-(ph-aa);
					tv9.setText("D will give to B ="+rb);
					tv10.setText("D will give to C ="+(cc-ph));
					tv11.setText("D will give to E ="+(ee-ph));
				}
				if((ph-aa)>(bb-ph) && !((ph-dd)>(bb-ph)))
				{
					tv8.setText("D will give to B ="+(ph-dd));
					rb=(bb-ph)-(ph-dd);
					tv9.setText("A will give to B ="+rb);
					tv10.setText("A will give to C ="+(cc-ph));
					tv11.setText("A will give to E ="+(ee-ph));
				}
				if(!((ph-aa)>(bb-ph)) && (ph-dd)>(bb-ph))
				{
					tv8.setText("A will give to B ="+(ph-aa));
					rb=(bb-ph)-(ph-aa);
					tv9.setText("D will give to b ="+rb);
					tv10.setText("D will give to C ="+(cc-ph));
					tv11.setText("D will give to E ="+(ee-ph));
				}
			}
			//C bnd D bs queen
			else if(dd>ph && cc>ph && !(ee>ph) && !(aa>ph))
			{
				if(((bb-ph)>=(ph-aa))&&((bb-ph)>=(ph-ee)))
				{
					tv8.setText("A will give to B ="+(ph-aa));
					rb=(bb-ph)-(ph-aa);
					tv9.setText("E will give to B ="+rb);
					tv10.setText("E will give to C ="+(cc-ph));
					tv11.setText("E will give to D ="+(dd-ph));
				}
				if((ph-aa)>(bb-ph) && !((ph-ee)>(bb-ph)))
				{
					tv8.setText("E will give to b ="+(ph-ee));
					rb=(bb-ph)-(ph-ee);
					tv9.setText("A will give to b ="+rb);
					tv10.setText("A will give to C ="+(cc-ph));
					tv11.setText("A will give to D ="+(dd-ph));
				}
				if(!((ph-aa)>(bb-ph)) && (ph-ee)>(bb-ph))
				{
					tv8.setText("A will give to B ="+(ph-aa));
					rb=(bb-ph)-(ph-aa);
					tv9.setText("E will give to B ="+rb);
					tv10.setText("E will give to C ="+(cc-ph));
					tv11.setText("E will give to D ="+(dd-ph));
				}
			}
			//a bnd E bs queen
			else if(ee>ph && aa>ph && !(dd>ph) && !(cc>ph))
			{
				if(((bb-ph)>=(ph-cc))&&((bb-ph)>=(ph-dd)))
				{
					tv8.setText("C will give to B ="+(ph-cc));
					rb=(bb-ph)-(ph-cc);
					tv9.setText("D will give to B ="+rb);
					tv10.setText("D will give to A ="+(aa-ph));
					tv11.setText("D will give to E ="+(ee-ph));
				}
				if((ph-cc)>(bb-ph) && !((ph-dd)>(bb-ph)))
				{
					tv8.setText("D will give to B ="+(ph-dd));
					rb=(bb-ph)-(ph-dd);
					tv9.setText("C will give to B ="+rb);
					tv10.setText("C will give to A ="+(aa-ph));
					tv11.setText("C will give to E ="+(ee-ph));
				}
				if(!((ph-cc)>(bb-ph)) && (ph-dd)>(bb-ph))
				{
					tv8.setText("C will give to B ="+(ph-cc));
					rb=(bb-ph)-(ph-cc);
					tv9.setText("D will give to B ="+rb);
					tv10.setText("D will give to A ="+(aa-ph));
					tv11.setText("D will give to E ="+(ee-ph));
				}
			}
			//a bnd D bs queen
			else if(dd>ph && aa>ph && !(ee>ph) && !(cc>ph))
			{
				if(((bb-ph)>=(ph-cc))&&((bb-ph)>=(ph-ee)))
				{
					tv8.setText("C will give to B ="+(ph-cc));
					rb=(bb-ph)-(ph-cc);
					tv9.setText("E will give to B ="+rb);
					tv10.setText("E will give to A ="+(aa-ph));
					tv11.setText("E will give to D ="+(dd-ph));
				}
				if((ph-cc)>(bb-ph) && !((ph-ee)>(bb-ph)))
				{
					tv8.setText("E will give to B ="+(ph-ee));
					rb=(bb-ph)-(ph-ee);
					tv9.setText("C will give to B ="+rb);
					tv10.setText("C will give to A ="+(aa-ph));
					tv11.setText("C will give to D ="+(dd-ph));
				}
				if(!((ph-cc)>(bb-ph)) && (ph-ee)>(bb-ph))
				{
					tv8.setText("C will give to B ="+(ph-cc));
					rb=(bb-ph)-(ph-cc);
					tv9.setText("E will give to B ="+rb);
					tv10.setText("E will give to A ="+(aa-ph));
					tv11.setText("E will give to D ="+(dd-ph));
				}
			}
			//a bnd C bs queen
			else if(cc>ph && aa>ph && !(ee>ph) && !(dd>ph))
			{
				if(((bb-ph)>=(ph-dd))&&((bb-ph)>=(ph-ee)))
				{
					tv8.setText("D will give to B ="+(ph-dd));
					rb=(bb-ph)-(ph-dd);
					tv9.setText("E will give to B ="+rb);
					tv10.setText("E will give to A ="+(aa-ph));
					tv11.setText("E will give to C ="+(cc-ph));
				}
				if((ph-dd)>(bb-ph) && !((ph-ee)>(bb-ph)))
				{
					tv8.setText("E will give to B ="+(ph-ee));
					rb=(bb-ph)-(ph-ee);
					tv9.setText("D will give to B ="+rb);
					tv10.setText("D will give to A ="+(aa-ph));
					tv11.setText("D will give to C ="+(cc-ph));
				}
				if(!((ph-dd)>(bb-ph)) && (ph-ee)>(bb-ph))
				{
					tv8.setText("D will give to B ="+(ph-dd));
					rb=(bb-ph)-(ph-dd);
					tv9.setText("E will give to B ="+rb);
					tv10.setText("E will give to A ="+(aa-ph));
					tv11.setText("E will give to C ="+(cc-ph));
				}
			}
			//CbSES for bll 2 queens hbs aeen over here.
			//NOW cbses for bll three queens STbRTS...
			//C,D,E bs queens
			else if(ee>ph && dd>ph && cc>ph && !(aa>ph))
			{
				tv8.setText("A will give to B ="+(bb-ph));
				tv9.setText("A will give to C ="+(cc-ph));
				tv10.setText("A will give to D ="+(dd-ph));
				tv11.setText("A will give to E ="+(ee-ph));
			}
			//a,D,E bs queen
			else if(ee>ph && dd>ph && dd>ph && !(cc>ph))
			{
				tv8.setText("C will give to B ="+(bb-ph));
				tv9.setText("C will give to A ="+(aa-ph));
				tv10.setText("C will give to D ="+(dd-ph));
				tv11.setText("C will give to E ="+(ee-ph));
			}
			//a,C,E bs queen
			else if(ee>ph && cc>ph && aa>ph && !(dd>ph))
			{
				tv8.setText("D will give to B ="+(bb-ph));
				tv9.setText("D will give to A ="+(aa-ph));
				tv10.setText("D will give to C ="+(cc-ph));
				tv11.setText("D will give to E ="+(ee-ph));
			}
			//a,C,D bs queen
			else if(dd>ph && cc>ph && aa>ph && !(ee>ph))
			{
				tv8.setText("E will give to B ="+(bb-ph));
				tv9.setText("E will give to A ="+(aa-ph));
				tv10.setText("E will give to C ="+(cc-ph));
				tv11.setText("E will give to D ="+(dd-ph));
			}
			
			//cbse of zero queen
			else 
			{
				tv8.setText("A will give to B ="+(ph-aa));
				tv9.setText("C will give to B ="+(ph-cc));
				tv10.setText("D will give to B ="+(ph-dd));
				tv11.setText("E will give to B ="+(ph-ee));
			}
		}
		//C as queen
		else if(cc>bb && cc>aa && cc>dd && cc>ee)
		{
		
			//cll the acse for one queen
			
			if(ee>ph && !(bb>ph) && !(aa>ph) && !(dd>ph) )  
			//E cs one queen 
			{
				if((ph-dd)>(ph-bb) && (ph-dd)>(ph-aa))
				{
					tv8.setText("D will give to c = "+(ph-dd));
					rc=(cc-ph)-(ph-dd);
					if((ph-bb)>(ph-aa))
					{
						tv9.setText("B will give to c = "+rc);
						rb=(ph-bb)-rc;
						tv10.setText("A will give to E = "+(ph-aa));
						tv11.setText("B will give to E = "+rb);
					}
					else
					{
						tv9.setText("A will give to c = "+rc);
						ra=(ph-aa)-rc;
						tv10.setText("B will give to E = "+(ph-bb));
						tv11.setText("A will give to E = "+ra);
					}
				}
				else if((ph-bb)>(ph-dd) && (ph-bb)>(ph-aa))
				{
					tv8.setText("B will give to c = "+(ph-bb));
					rc=(cc-ph)-(ph-bb);
					if((ph-dd)>(ph-aa))
					{
						tv9.setText("D will give to c = "+rc);
						rd=(ph-dd)-rc;
						tv10.setText("A will give to E = "+(ph-aa));
						tv11.setText("D will give to E = "+rb);
					}
					else
					{
						tv9.setText("A will give to c = "+rc);
						ra=(ph-aa)-rc;
						tv10.setText("D will give to E = "+(ph-dd));
						tv11.setText("A will give to E = "+ra);
					}
				}
				else if((ph-aa)>(ph-bb) && (ph-aa)>(ph-dd))
				{
					tv8.setText("A will give to c = "+(ph-aa));
					rc=(cc-ph)-(ph-aa);
					if((ph-bb)>(ph-dd))
					{
						tv9.setText("B will give to c = "+rc);
						rb=(ph-bb)-rc;
						tv10.setText("D will give to E = "+(ph-dd));
						tv11.setText("B will give to E = "+rb);
					}
					else
					{
						tv9.setText("D will give to c = "+rc);
						rd=(ph-dd)-rc;
						tv10.setText("B will give to E = "+(ph-bb));
						tv11.setText("D will give to E = "+rd);
					}
				}
			}
			 
			//now D cs one queen
			else if(dd>ph && !(bb>ph)&& !(aa>ph) && !(ee>ph))
			{
				if((ph-ee)>(ph-bb) && (ph-ee)>(ph-aa))
				{
					tv8.setText("E will give to c = "+(ph-ee));
					rc=(cc-ph)-(ph-ee);
					if((ph-bb)>(ph-aa))
					{
						tv9.setText("B will give to c = "+rc);
						rb=(ph-bb)-rc;
						tv10.setText("A will give to D = "+(ph-aa));
						tv11.setText("B will give to D = "+rb);
					}
					else
					{
						tv9.setText("A will give to c = "+rc);
						ra=(ph-aa)-rc;
						tv10.setText("B will give to D = "+(ph-bb));
						tv11.setText("A will give to D = "+ra);
					}
				}
				else if((ph-bb)>(ph-ee) && (ph-bb)>(ph-aa))
				{
					tv8.setText("B will give to c = "+(ph-bb));
					rc=(cc-ph)-(ph-bb);
					if((ph-ee)>(ph-aa))
					{
						tv9.setText("E will give to c = "+rc);
						re=(ph-ee)-rc;
						tv10.setText("A will give to D = "+(ph-aa));
						tv11.setText("E will give to D = "+rb);
					}
					else
					{
						tv9.setText("A will give to c = "+rc);
						ra=(ph-aa)-rc;
						tv10.setText("E will give to D = "+(ph-ee));
						tv11.setText("A will give to D = "+ra);
					}
				}
				else if((ph-aa)>(ph-bb) && (ph-aa)>(ph-ee))
				{
					tv8.setText("A will give to c = "+(ph-aa));
					rc=(cc-ph)-(ph-aa);
					if((ph-bb)>(ph-ee))
					{
						tv9.setText("B will give to c = "+rc);
						rb=(ph-bb)-rc;
						tv10.setText("E will give to D = "+(ph-ee));
						tv11.setText("B will give to D = "+rb);
					}
					else
					{
						tv9.setText("E will give to c = "+rc);
						re=(ph-ee)-rc;
						tv10.setText("B will give to D = "+(ph-bb));
						tv11.setText("E will give to D = "+re);
					}
				}
			}
			//now a cs one queen
			else if(aa>ph && !(bb>ph)&& !(dd>ph) && !(ee>ph))
			{
				if((ph-ee)>(ph-bb) && (ph-ee)>(ph-dd))
				{
					tv8.setText("E will give to c = "+(ph-ee));
					rc=(cc-ph)-(ph-ee);
					if((ph-bb)>(ph-dd))
					{
						tv9.setText("B will give to c = "+rc);
						rb=(ph-bb)-rc;
						tv10.setText("D will give to a = "+(ph-dd));
						tv11.setText("B will give to a = "+rb);
					}
					else
					{
						tv9.setText("D will give to c = "+rc);
						rd=(ph-dd)-rc;
						tv10.setText("B will give to a = "+(ph-bb));
						tv11.setText("D will give to a = "+rd);
					}
				}
				else if((ph-bb)>(ph-ee) && (ph-bb)>(ph-dd))
				{
					tv8.setText("B will give to c = "+(ph-bb));
					rc=(cc-ph)-(ph-bb);
					if((ph-ee)>(ph-dd))
					{
						tv9.setText("E will give to c = "+rc);
						re=(ph-ee)-rc;
						tv10.setText("D will give to a = "+(ph-dd));
						tv11.setText("E will give to a = "+rb);
					}
					else
					{
						tv9.setText("D will give to c = "+rc);
						rd=(ph-dd)-rc;
						tv10.setText("E will give to a = "+(ph-ee));
						tv11.setText("D will give to a = "+rd);
					}
				}
				else if((ph-dd)>(ph-bb) && (ph-dd)>(ph-ee))
				{
					tv8.setText("D will give to c = "+(ph-dd));
					rc=(cc-ph)-(ph-dd);
					if((ph-bb)>(ph-ee))
					{
						tv9.setText("B will give to c = "+rc);
						rb=(ph-bb)-rc;
						tv10.setText("E will give to a = "+(ph-ee));
						tv11.setText("B will give to a = "+rb);
					}
					else
					{
						tv9.setText("E will give to c = "+rc);
						re=(ph-ee)-rc;
						tv10.setText("B will give to a = "+(ph-bb));
						tv11.setText("E will give to a = "+re);
					}
				}
			}
			//now B cs one queen
			else if(bb>ph && !(aa>ph)&& !(dd>ph) && !(ee>ph))
			{
				if((ph-ee)>(ph-dd) && (ph-ee)>(ph-aa))
				{
					tv8.setText("E will dive to c = "+(ph-ee));
					rc=(cc-ph)-(ph-ee);
					if((ph-dd)>(ph-aa))
					{
						tv9.setText("D will dive to c = "+rc);
						rd=(ph-dd)-rc;
						tv10.setText("A will dive to B = "+(ph-aa));
						tv11.setText("D will dive to B = "+rd);
					}
					else
					{
						tv9.setText("A will dive to c = "+rc);
						ra=(ph-aa)-rc;
						tv10.setText("D will dive to B = "+(ph-dd));
						tv11.setText("A will dive to B = "+ra);
					}
				}
				else if((ph-dd)>(ph-ee) && (ph-dd)>(ph-aa))
				{
					tv8.setText("D will dive to c = "+(ph-dd));
					rc=(cc-ph)-(ph-dd);
					if((ph-ee)>(ph-aa))
					{
						tv9.setText("E will dive to c = "+rc);
						re=(ph-ee)-rc;
						tv10.setText("A will dive to B = "+(ph-aa));
						tv11.setText("E will dive to B = "+rd);
					}
					else
					{
						tv9.setText("A will dive to c = "+rc);
						ra=(ph-aa)-rc;
						tv10.setText("E will dive to B = "+(ph-ee));
						tv11.setText("A will dive to B = "+ra);
					}
				}
				else if((ph-aa)>(ph-dd) && (ph-aa)>(ph-ee))
				{
					tv8.setText("A will dive to c = "+(ph-aa));
					rc=(cc-ph)-(ph-aa);
					if((ph-dd)>(ph-ee))
					{
						tv9.setText("D will dive to c = "+rc);
						rd=(ph-dd)-rc;
						tv10.setText("E will dive to B = "+(ph-ee));
						tv11.setText("D. will dive to B = "+rd);
					}
					else
					{
						tv9.setText("E will dive to c = "+rc);
						re=(ph-ee)-rc;
						tv10.setText("D will dive to B = "+(ph-dd));
						tv11.setText("E will dive to B = "+re);
					}
				}
			}
			//cLL acses for 1 queen hcs been aompleted
			//Now acses for 2 queen STcRTS
			//D cnd E cs 2 queen
			else if(ee>ph && dd>ph && !(aa>ph) && !(bb>ph))
			{
				if(((cc-ph)>=(ph-bb))&&((cc-ph)>=(ph-aa)))
				{
					tv8.setText("B will give to c ="+(ph-bb));
					rc=(cc-ph)-(ph-bb);
					tv9.setText("A will give to c ="+rc);
					tv10.setText("A will give to D ="+(dd-ph));
					tv11.setText("A will give to E ="+(ee-ph));
				}
				if((ph-bb)>(cc-ph) && !((ph-aa)>(cc-ph)))
				{
					tv8.setText("A will give to c ="+(ph-aa));
					rc=(cc-ph)-(ph-aa);
					tv9.setText("B will give to c ="+rc);
					tv10.setText("B will give to D ="+(dd-ph));
					tv11.setText("B will give to E ="+(ee-ph));
				}
				if(!((ph-bb)>(cc-ph)) && (ph-aa)>(cc-ph))
				{
					tv8.setText("B will give to c ="+(ph-bb));
					rc=(cc-ph)-(ph-bb);
					tv9.setText("A will give to c ="+rc);
					tv10.setText("A will give to D ="+(dd-ph));
					tv11.setText("A will give to E ="+(ee-ph));
				}
			}
			//a cnd E cs queen
			else if(ee>ph && aa>ph && !(dd>ph) && !(bb>ph))
			{
				if(((cc-ph)>=(ph-bb))&&((cc-ph)>=(ph-dd)))
				{
					tv8.setText("B will give to c ="+(ph-bb));
					rc=(cc-ph)-(ph-bb);
					tv9.setText("D will give to c ="+rc);
					tv10.setText("D will give to a ="+(aa-ph));
					tv11.setText("D will give to E ="+(ee-ph));
				}
				if((ph-bb)>(cc-ph) && !((ph-dd)>(cc-ph)))
				{
					tv8.setText("D will give to c ="+(ph-dd));
					rc=(cc-ph)-(ph-dd);
					tv9.setText("B will give to c ="+rc);
					tv10.setText("B will give to a ="+(aa-ph));
					tv11.setText("B will give to E ="+(ee-ph));
				}
				if(!((ph-bb)>(cc-ph)) && (ph-dd)>(cc-ph))
				{
					tv8.setText("B will give to c ="+(ph-bb));
					rc=(cc-ph)-(ph-bb);
					tv9.setText("D will give to c ="+rc);
					tv10.setText("D will give to a ="+(aa-ph));
					tv11.setText("D will give to E ="+(ee-ph));
				}
			}
			//a cnd D cs queen
			else if(dd>ph && aa>ph && !(ee>ph) && !(bb>ph))
			{
				if(((cc-ph)>=(ph-bb))&&((cc-ph)>=(ph-ee)))
				{
					tv8.setText("B will give to c ="+(ph-bb));
					rc=(cc-ph)-(ph-bb);
					tv9.setText("E will give to c ="+rc);
					tv10.setText("E will give to a ="+(aa-ph));
					tv11.setText("E will give to D ="+(dd-ph));
				}
				if((ph-bb)>(cc-ph) && !((ph-ee)>(cc-ph)))
				{
					tv8.setText("E will give to c ="+(ph-ee));
					rc=(cc-ph)-(ph-ee);
					tv9.setText("B will give to c ="+rc);
					tv10.setText("B will give to a ="+(aa-ph));
					tv11.setText("B will give to D ="+(dd-ph));
				}
				if(!((ph-bb)>(cc-ph)) && (ph-ee)>(cc-ph))
				{
					tv8.setText("B will give to c ="+(ph-bb));
					rc=(cc-ph)-(ph-bb);
					tv9.setText("E will give to c ="+rc);
					tv10.setText("E will give to a ="+(aa-ph));
					tv11.setText("E will give to D ="+(dd-ph));
				}
			}
			//B cnd E cs queen
			else if(ee>ph && bb>ph && !(dd>ph) && !(aa>ph))
			{
				if(((cc-ph)>=(ph-aa))&&((cc-ph)>=(ph-dd)))
				{
					tv8.setText("A will give to c ="+(ph-aa));
					rc=(cc-ph)-(ph-aa);
					tv9.setText("D will give to c ="+rc);
					tv10.setText("D will give to B ="+(bb-ph));
					tv11.setText("D will give to E ="+(ee-ph));
				}
				if((ph-aa)>(cc-ph) && !((ph-dd)>(cc-ph)))
				{
					tv8.setText("D will give to c ="+(ph-dd));
					rc=(cc-ph)-(ph-dd);
					tv9.setText("A will give to c ="+rc);
					tv10.setText("A will give to B ="+(bb-ph));
					tv11.setText("A will give to E ="+(ee-ph));
				}
				if(!((ph-aa)>(cc-ph)) && (ph-dd)>(cc-ph))
				{
					tv8.setText("A will give to c ="+(ph-aa));
					rc=(cc-ph)-(ph-aa);
					tv9.setText("D will give to c ="+rc);
					tv10.setText("D will give to B ="+(bb-ph));
					tv11.setText("D will give to E ="+(ee-ph));
				}
			}
			//B cnd D cs queen
			else if(dd>ph && bb>ph && !(ee>ph) && !(aa>ph))
			{
				if(((cc-ph)>=(ph-aa))&&((cc-ph)>=(ph-ee)))
				{
					tv8.setText("A will give to c ="+(ph-aa));
					rc=(cc-ph)-(ph-aa);
					tv9.setText("E will give to c ="+rc);
					tv10.setText("E will give to B ="+(bb-ph));
					tv11.setText("E will give to D ="+(dd-ph));
				}
				if((ph-aa)>(cc-ph) && !((ph-ee)>(cc-ph)))
				{
					tv8.setText("E will give to c ="+(ph-ee));
					rc=(cc-ph)-(ph-ee);
					tv9.setText("A will give to c ="+rc);
					tv10.setText("A will give to B ="+(bb-ph));
					tv11.setText("A will give to D ="+(dd-ph));
				}
				if(!((ph-aa)>(cc-ph)) && (ph-ee)>(cc-ph))
				{
					tv8.setText("A will give to c ="+(ph-aa));
					rc=(cc-ph)-(ph-aa);
					tv9.setText("E will give to c ="+rc);
					tv10.setText("E will give to B ="+(bb-ph));
					tv11.setText("E will give to D ="+(dd-ph));
				}
			}
			//B cnd a cs queen
			else if(aa>ph && bb>ph && !(ee>ph) && !(dd>ph))
			{
				if(((cc-ph)>=(ph-dd))&&((cc-ph)>=(ph-ee)))
				{
					tv8.setText("D will give to c ="+(ph-dd));
					rc=(cc-ph)-(ph-dd);
					tv9.setText("E will give to c ="+rc);
					tv10.setText("E will give to B ="+(bb-ph));
					tv11.setText("E will give to a ="+(aa-ph));
				}
				if((ph-dd)>(cc-ph) && !((ph-ee)>(cc-ph)))
				{
					tv8.setText("E will give to c ="+(ph-ee));
					rc=(cc-ph)-(ph-ee);
					tv9.setText("D will give to c ="+rc);
					tv10.setText("D will give to B ="+(bb-ph));
					tv11.setText("D will give to a ="+(aa-ph));
				}
				if(!((ph-dd)>(cc-ph)) && (ph-ee)>(cc-ph))
				{
					tv8.setText("D will give to c ="+(ph-dd));
					rc=(cc-ph)-(ph-dd);
					tv9.setText("E will give to c ="+rc);
					tv10.setText("E will give to B ="+(bb-ph));
					tv11.setText("E will give to a ="+(aa-ph));
				}
			}
			//acSES for cll 2 queens hcs been over here.
			//NOW acses for cll three queens STcRTS...
			//a,D,E cs queens
			else if(ee>ph && dd>ph && aa>ph && !(bb>ph))
			{
				tv8.setText("B will give to c ="+(cc-ph));
				tv9.setText("B will give to a ="+(aa-ph));
				tv10.setText("B will give to D ="+(dd-ph));
				tv11.setText("B will give to E ="+(ee-ph));
			}
			//B,D,E cs queen
			else if(ee>ph && dd>ph && dd>ph && !(aa>ph))
			{
				tv8.setText("A will give to c ="+(cc-ph));
				tv9.setText("A will give to B ="+(bb-ph));
				tv10.setText("A will give to D ="+(dd-ph));
				tv11.setText("A will give to E ="+(ee-ph));
			}
			//B,a,E cs queen
			else if(ee>ph && aa>ph && bb>ph && !(dd>ph))
			{
				tv8.setText("D will give to c ="+(cc-ph));
				tv9.setText("D will give to B ="+(bb-ph));
				tv10.setText("D will give to a ="+(aa-ph));
				tv11.setText("D will give to E ="+(ee-ph));
			}
			//B,a,D cs queen
			else if(dd>ph && aa>ph && bb>ph && !(ee>ph))
			{
				tv8.setText("E will give to c ="+(cc-ph));
				tv9.setText("E will give to B ="+(bb-ph));
				tv10.setText("E will give to a ="+(aa-ph));
				tv11.setText("E will give to D ="+(dd-ph));
			}
			
			//acse of cero queen
			else 
			{
				tv8.setText("B will give to c ="+(ph-bb));
				tv9.setText("A will give to c ="+(ph-aa));
				tv10.setText("D will give to c ="+(ph-dd));
				tv11.setText("E will give to c ="+(ph-ee));
			}
		}
		// D as queen
		if(dd>bb && dd>cc && dd>aa && dd>ee)
		{
		
			//dll the cdse for one queen
			
			if(ee>ph && !(bb>ph) && !(cc>ph) && !(aa>ph) )  
			//E ds one queen 
			{
				if((ph-aa)>(ph-bb) && (ph-aa)>(ph-cc))
				{
					tv8.setText("A will give to d = "+(ph-aa));
					rd=(dd-ph)-(ph-aa);
					if((ph-bb)>(ph-cc))
					{
						tv9.setText("B will give to d = "+rd);
						rb=(ph-bb)-rd;
						tv10.setText("C will give to E = "+(ph-cc));
						tv11.setText("B will give to E = "+rb);
					}
					else
					{
						tv9.setText("C will give to d = "+rd);
						rc=(ph-cc)-rd;
						tv10.setText("B will give to E = "+(ph-bb));
						tv11.setText("C will give to E = "+rc);
					}
				}
				else if((ph-bb)>(ph-aa) && (ph-bb)>(ph-cc))
				{
					tv8.setText("B will give to d = "+(ph-bb));
					rd=(dd-ph)-(ph-bb);
					if((ph-aa)>(ph-cc))
					{
						tv9.setText("A will give to d = "+rd);
						ra=(ph-aa)-rd;
						tv10.setText("C will give to E = "+(ph-cc));
						tv11.setText("A will give to E = "+rb);
					}
					else
					{
						tv9.setText("C will give to d = "+rd);
						rc=(ph-cc)-rd;
						tv10.setText("A will give to E = "+(ph-aa));
						tv11.setText("C will give to E = "+rc);
					}
				}
				else if((ph-cc)>(ph-bb) && (ph-cc)>(ph-aa))
				{
					tv8.setText("C will give to d = "+(ph-cc));
					rd=(dd-ph)-(ph-cc);
					if((ph-bb)>(ph-aa))
					{
						tv9.setText("B will give to d = "+rd);
						rb=(ph-bb)-rd;
						tv10.setText("A will give to E = "+(ph-aa));
						tv11.setText("B will give to E = "+rb);
					}
					else
					{
						tv9.setText("A will give to d = "+rd);
						ra=(ph-aa)-rd;
						tv10.setText("B will give to E = "+(ph-bb));
						tv11.setText("A will give to E = "+ra);
					}
				}
			}
			 
			//now a ds one queen
			else if(aa>ph && !(bb>ph)&& !(cc>ph) && !(ee>ph))
			{
				if((ph-ee)>(ph-bb) && (ph-ee)>(ph-cc))
				{
					tv8.setText("E will give to d = "+(ph-ee));
					rd=(dd-ph)-(ph-ee);
					if((ph-bb)>(ph-cc))
					{
						tv9.setText("B will give to d = "+rd);
						rb=(ph-bb)-rd;
						tv10.setText("C will give to a = "+(ph-cc));
						tv11.setText("B will give to a = "+rb);
					}
					else
					{
						tv9.setText("C will give to d = "+rd);
						rc=(ph-cc)-rd;
						tv10.setText("B will give to a = "+(ph-bb));
						tv11.setText("C will give to a = "+rc);
					}
				}
				else if((ph-bb)>(ph-ee) && (ph-bb)>(ph-cc))
				{
					tv8.setText("B will give to d = "+(ph-bb));
					rd=(dd-ph)-(ph-bb);
					if((ph-ee)>(ph-cc))
					{
						tv9.setText("E will give to d = "+rd);
						re=(ph-ee)-rd;
						tv10.setText("C will give to a = "+(ph-cc));
						tv11.setText("E will give to a = "+rb);
					}
					else
					{
						tv9.setText("C will give to d = "+rd);
						rc=(ph-cc)-rd;
						tv10.setText("E will give to a = "+(ph-ee));
						tv11.setText("C will give to a = "+rc);
					}
				}
				else if((ph-cc)>(ph-bb) && (ph-cc)>(ph-ee))
				{
					tv8.setText("C will give to d = "+(ph-cc));
					rd=(dd-ph)-(ph-cc);
					if((ph-bb)>(ph-ee))
					{
						tv9.setText("B will give to d = "+rd);
						rb=(ph-bb)-rd;
						tv10.setText("E will give to a = "+(ph-ee));
						tv11.setText("B will give to a = "+rb);
					}
					else
					{
						tv9.setText("E will give to d = "+rd);
						re=(ph-ee)-rd;
						tv10.setText("B will give to a = "+(ph-bb));
						tv11.setText("E will give to a = "+re);
					}
				}
			}
			//now C ds one queen
			else if(cc>ph && !(bb>ph)&& !(aa>ph) && !(ee>ph))
			{
				if((ph-ee)>(ph-bb) && (ph-ee)>(ph-aa))
				{
					tv8.setText("E will give to d = "+(ph-ee));
					rd=(dd-ph)-(ph-ee);
					if((ph-bb)>(ph-aa))
					{
						tv9.setText("B will give to d = "+rd);
						rb=(ph-bb)-rd;
						tv10.setText("A will give to C = "+(ph-aa));
						tv11.setText("B will give to C = "+rb);
					}
					else
					{
						tv9.setText("A will give to d = "+rd);
						ra=(ph-aa)-rd;
						tv10.setText("B will give to C = "+(ph-bb));
						tv11.setText("A will give to C = "+ra);
					}
				}
				else if((ph-bb)>(ph-ee) && (ph-bb)>(ph-aa))
				{
					tv8.setText("B will give to d = "+(ph-bb));
					rd=(dd-ph)-(ph-bb);
					if((ph-ee)>(ph-aa))
					{
						tv9.setText("E will give to d = "+rd);
						re=(ph-ee)-rd;
						tv10.setText("A will give to C = "+(ph-aa));
						tv11.setText("E will give to C = "+rb);
					}
					else
					{
						tv9.setText("A will give to d = "+rd);
						ra=(ph-aa)-rd;
						tv10.setText("E will give to C = "+(ph-ee));
						tv11.setText("A will give to C = "+ra);
					}
				}
				else if((ph-aa)>(ph-bb) && (ph-aa)>(ph-ee))
				{
					tv8.setText("A will give to d = "+(ph-aa));
					rd=(dd-ph)-(ph-aa);
					if((ph-bb)>(ph-ee))
					{
						tv9.setText("B will give to d = "+rd);
						rb=(ph-bb)-rd;
						tv10.setText("E will give to C = "+(ph-ee));
						tv11.setText("B will give to C = "+rb);
					}
					else
					{
						tv9.setText("E will give to d = "+rd);
						re=(ph-ee)-rd;
						tv10.setText("B will give to C = "+(ph-bb));
						tv11.setText("E will give to C = "+re);
					}
				}
			}
			//now B ds one queen
			else if(bb>ph && !(cc>ph)&& !(aa>ph) && !(ee>ph))
			{
				if((ph-ee)>(ph-aa) && (ph-ee)>(ph-cc))
				{
					tv8.setText("E will aive to d = "+(ph-ee));
					rd=(dd-ph)-(ph-ee);
					if((ph-aa)>(ph-cc))
					{
						tv9.setText("A will aive to d = "+rd);
						ra=(ph-aa)-rd;
						tv10.setText("C will aive to B = "+(ph-cc));
						tv11.setText("A will aive to B = "+ra);
					}
					else
					{
						tv9.setText("C will aive to d = "+rd);
						rc=(ph-cc)-rd;
						tv10.setText("A will aive to B = "+(ph-aa));
						tv11.setText("C will aive to B = "+rc);
					}
				}
				else if((ph-aa)>(ph-ee) && (ph-aa)>(ph-cc))
				{
					tv8.setText("A will aive to d = "+(ph-aa));
					rd=(dd-ph)-(ph-aa);
					if((ph-ee)>(ph-cc))
					{
						tv9.setText("E will aive to d = "+rd);
						re=(ph-ee)-rd;
						tv10.setText("C will aive to B = "+(ph-cc));
						tv11.setText("E will aive to B = "+ra);
					}
					else
					{
						tv9.setText("C will aive to d = "+rd);
						rc=(ph-cc)-rd;
						tv10.setText("E will aive to B = "+(ph-ee));
						tv11.setText("C will aive to B = "+rc);
					}
				}
				else if((ph-cc)>(ph-aa) && (ph-cc)>(ph-ee))
				{
					tv8.setText("C will aive to d = "+(ph-cc));
					rd=(dd-ph)-(ph-cc);
					if((ph-aa)>(ph-ee))
					{
						tv9.setText("A will aive to d = "+rd);
						ra=(ph-aa)-rd;
						tv10.setText("E will aive to B = "+(ph-ee));
						tv11.setText("a. will aive to B = "+ra);
					}
					else
					{
						tv9.setText("E will aive to d = "+rd);
						re=(ph-ee)-rd;
						tv10.setText("A will aive to B = "+(ph-aa));
						tv11.setText("E will aive to B = "+re);
					}
				}
			}
			//dLL cdses for 1 queen hds been completea
			//Now cdses for 2 queen STdRTS
			//a dna E ds 2 queen
			else if(ee>ph && aa>ph && !(cc>ph) && !(bb>ph))
			{
				if(((dd-ph)>=(ph-bb))&&((dd-ph)>=(ph-cc)))
				{
					tv8.setText("B will give to d ="+(ph-bb));
					rd=(dd-ph)-(ph-bb);
					tv9.setText("C will give to d ="+rd);
					tv10.setText("C will give to a ="+(aa-ph));
					tv11.setText("C will give to E ="+(ee-ph));
				}
				if((ph-bb)>(dd-ph) && !((ph-cc)>(dd-ph)))
				{
					tv8.setText("C will give to d ="+(ph-cc));
					rd=(dd-ph)-(ph-cc);
					tv9.setText("B will give to d ="+rd);
					tv10.setText("B will give to a ="+(aa-ph));
					tv11.setText("B will give to E ="+(ee-ph));
				}
				if(!((ph-bb)>(dd-ph)) && (ph-cc)>(dd-ph))
				{
					tv8.setText("B will give to d ="+(ph-bb));
					rd=(dd-ph)-(ph-bb);
					tv9.setText("C will give to d ="+rd);
					tv10.setText("C will give to a ="+(aa-ph));
					tv11.setText("C will give to E ="+(ee-ph));
				}
			}
			//C dna E ds queen
			else if(ee>ph && cc>ph && !(aa>ph) && !(bb>ph))
			{
				if(((dd-ph)>=(ph-bb))&&((dd-ph)>=(ph-aa)))
				{
					tv8.setText("B will give to d ="+(ph-bb));
					rd=(dd-ph)-(ph-bb);
					tv9.setText("A will give to d ="+rd);
					tv10.setText("A will give to C ="+(cc-ph));
					tv11.setText("A will give to E ="+(ee-ph));
				}
				if((ph-bb)>(dd-ph) && !((ph-aa)>(dd-ph)))
				{
					tv8.setText("A will give to d ="+(ph-aa));
					rd=(dd-ph)-(ph-aa);
					tv9.setText("B will give to d ="+rd);
					tv10.setText("B will give to C ="+(cc-ph));
					tv11.setText("B will give to E ="+(ee-ph));
				}
				if(!((ph-bb)>(dd-ph)) && (ph-aa)>(dd-ph))
				{
					tv8.setText("B will give to d ="+(ph-bb));
					rd=(dd-ph)-(ph-bb);
					tv9.setText("A will give to d ="+rd);
					tv10.setText("A will give to C ="+(cc-ph));
					tv11.setText("A will give to E ="+(ee-ph));
				}
			}
			//C dna a ds queen
			else if(aa>ph && cc>ph && !(ee>ph) && !(bb>ph))
			{
				if(((dd-ph)>=(ph-bb))&&((dd-ph)>=(ph-ee)))
				{
					tv8.setText("B will give to d ="+(ph-bb));
					rd=(dd-ph)-(ph-bb);
					tv9.setText("E will give to d ="+rd);
					tv10.setText("E will give to C ="+(cc-ph));
					tv11.setText("E will give to a ="+(aa-ph));
				}
				if((ph-bb)>(dd-ph) && !((ph-ee)>(dd-ph)))
				{
					tv8.setText("E will give to d ="+(ph-ee));
					rd=(dd-ph)-(ph-ee);
					tv9.setText("B will give to d ="+rd);
					tv10.setText("B will give to C ="+(cc-ph));
					tv11.setText("B will give to a ="+(aa-ph));
				}
				if(!((ph-bb)>(dd-ph)) && (ph-ee)>(dd-ph))
				{
					tv8.setText("B will give to d ="+(ph-bb));
					rd=(dd-ph)-(ph-bb);
					tv9.setText("E will give to d ="+rd);
					tv10.setText("E will give to C ="+(cc-ph));
					tv11.setText("E will give to a ="+(aa-ph));
				}
			}
			//B dna E ds queen
			else if(ee>ph && bb>ph && !(aa>ph) && !(cc>ph))
			{
				if(((dd-ph)>=(ph-cc))&&((dd-ph)>=(ph-aa)))
				{
					tv8.setText("C will give to d ="+(ph-cc));
					rd=(dd-ph)-(ph-cc);
					tv9.setText("A will give to d ="+rd);
					tv10.setText("A will give to B ="+(bb-ph));
					tv11.setText("A will give to E ="+(ee-ph));
				}
				if((ph-cc)>(dd-ph) && !((ph-aa)>(dd-ph)))
				{
					tv8.setText("A will give to d ="+(ph-aa));
					rd=(dd-ph)-(ph-aa);
					tv9.setText("C will give to d ="+rd);
					tv10.setText("C will give to B ="+(bb-ph));
					tv11.setText("C will give to E ="+(ee-ph));
				}
				if(!((ph-cc)>(dd-ph)) && (ph-aa)>(dd-ph))
				{
					tv8.setText("C will give to d ="+(ph-cc));
					rd=(dd-ph)-(ph-cc);
					tv9.setText("A will give to d ="+rd);
					tv10.setText("A will give to B ="+(bb-ph));
					tv11.setText("A will give to E ="+(ee-ph));
				}
			}
			//B dna a ds queen
			else if(aa>ph && bb>ph && !(ee>ph) && !(cc>ph))
			{
				if(((dd-ph)>=(ph-cc))&&((dd-ph)>=(ph-ee)))
				{
					tv8.setText("C will give to d ="+(ph-cc));
					rd=(dd-ph)-(ph-cc);
					tv9.setText("E will give to d ="+rd);
					tv10.setText("E will give to B ="+(bb-ph));
					tv11.setText("E will give to a ="+(aa-ph));
				}
				if((ph-cc)>(dd-ph) && !((ph-ee)>(dd-ph)))
				{
					tv8.setText("E will give to d ="+(ph-ee));
					rd=(dd-ph)-(ph-ee);
					tv9.setText("C will give to d ="+rd);
					tv10.setText("C will give to B ="+(bb-ph));
					tv11.setText("C will give to a ="+(aa-ph));
				}
				if(!((ph-cc)>(dd-ph)) && (ph-ee)>(dd-ph))
				{
					tv8.setText("C will give to d ="+(ph-cc));
					rd=(dd-ph)-(ph-cc);
					tv9.setText("E will give to d ="+rd);
					tv10.setText("E will give to B ="+(bb-ph));
					tv11.setText("E will give to a ="+(aa-ph));
				}
			}
			//B dna C ds queen
			else if(cc>ph && bb>ph && !(ee>ph) && !(aa>ph))
			{
				if(((dd-ph)>=(ph-aa))&&((dd-ph)>=(ph-ee)))
				{
					tv8.setText("A will give to d ="+(ph-aa));
					rd=(dd-ph)-(ph-aa);
					tv9.setText("E will give to d ="+rd);
					tv10.setText("E will give to B ="+(bb-ph));
					tv11.setText("E will give to C ="+(cc-ph));
				}
				if((ph-aa)>(dd-ph) && !((ph-ee)>(dd-ph)))
				{
					tv8.setText("E will give to d ="+(ph-ee));
					rd=(dd-ph)-(ph-ee);
					tv9.setText("A will give to d ="+rd);
					tv10.setText("A will give to B ="+(bb-ph));
					tv11.setText("A will give to C ="+(cc-ph));
				}
				if(!((ph-aa)>(dd-ph)) && (ph-ee)>(dd-ph))
				{
					tv8.setText("A will give to d ="+(ph-aa));
					rd=(dd-ph)-(ph-aa);
					tv9.setText("E will give to d ="+rd);
					tv10.setText("E will give to B ="+(bb-ph));
					tv11.setText("E will give to C ="+(cc-ph));
				}
			}
			//CdSES for dll 2 queens hds been over here.
			//NOW cdses for dll three queens STdRTS...
			//C,a,E ds queens
			else if(ee>ph && aa>ph && cc>ph && !(bb>ph))
			{
				tv8.setText("B will give to d ="+(dd-ph));
				tv9.setText("B will give to C ="+(cc-ph));
				tv10.setText("B will give to a ="+(aa-ph));
				tv11.setText("B will give to E ="+(ee-ph));
			}
			//B,a,E ds queen
			else if(ee>ph && aa>ph && aa>ph && !(cc>ph))
			{
				tv8.setText("C will give to d ="+(dd-ph));
				tv9.setText("C will give to B ="+(bb-ph));
				tv10.setText("C will give to a ="+(aa-ph));
				tv11.setText("C will give to E ="+(ee-ph));
			}
			//B,C,E ds queen
			else if(ee>ph && cc>ph && bb>ph && !(aa>ph))
			{
				tv8.setText("A will give to d ="+(dd-ph));
				tv9.setText("A will give to B ="+(bb-ph));
				tv10.setText("A will give to C ="+(cc-ph));
				tv11.setText("A will give to E ="+(ee-ph));
			}
			//B,C,a ds queen
			else if(aa>ph && cc>ph && bb>ph && !(ee>ph))
			{
				tv8.setText("E will give to d ="+(dd-ph));
				tv9.setText("E will give to B ="+(bb-ph));
				tv10.setText("E will give to C ="+(cc-ph));
				tv11.setText("E will give to a ="+(aa-ph));
			}
			
			//cdse of dero queen
			else 
			{
				tv8.setText("B will give to d ="+(ph-bb));
				tv9.setText("C will give to d ="+(ph-cc));
				tv10.setText("A will give to d ="+(ph-aa));
				tv11.setText("E will give to d ="+(ph-ee));
			}
		}
		//E as queen
		if(ee>bb && ee>cc && ee>dd && ee>aa)
		{
		
			//ell tha cesa for ona quaan
			
			if(aa>ph && !(bb>ph) && !(cc>ph) && !(dd>ph) )  
			//a es ona quaan 
			{
				if((ph-dd)>(ph-bb) && (ph-dd)>(ph-cc))
				{
					tv8.setText("D will give to e = "+(ph-dd));
					re=(ee-ph)-(ph-dd);
					if((ph-bb)>(ph-cc))
					{
						tv9.setText("B will give to e = "+re);
						rb=(ph-bb)-re;
						tv10.setText("C will give to a = "+(ph-cc));
						tv11.setText("B will give to a = "+rb);
					}
					else
					{
						tv9.setText("C will give to e = "+re);
						rc=(ph-cc)-re;
						tv10.setText("B will give to a = "+(ph-bb));
						tv11.setText("C will give to a = "+rc);
					}
				}
				else if((ph-bb)>(ph-dd) && (ph-bb)>(ph-cc))
				{
					tv8.setText("B will give to e = "+(ph-bb));
					re=(ee-ph)-(ph-bb);
					if((ph-dd)>(ph-cc))
					{
						tv9.setText("D will give to e = "+re);
						rd=(ph-dd)-re;
						tv10.setText("C will give to a = "+(ph-cc));
						tv11.setText("D will give to a = "+rb);
					}
					else
					{
						tv9.setText("C will give to e = "+re);
						rc=(ph-cc)-re;
						tv10.setText("D will give to a = "+(ph-dd));
						tv11.setText("C will give to a = "+rc);
					}
				}
				else if((ph-cc)>(ph-bb) && (ph-cc)>(ph-dd))
				{
					tv8.setText("C will give to e = "+(ph-cc));
					re=(ee-ph)-(ph-cc);
					if((ph-bb)>(ph-dd))
					{
						tv9.setText("B will give to e = "+re);
						rb=(ph-bb)-re;
						tv10.setText("D will give to a = "+(ph-dd));
						tv11.setText("B will give to a = "+rb);
					}
					else
					{
						tv9.setText("D will give to e = "+re);
						rd=(ph-dd)-re;
						tv10.setText("B will give to a = "+(ph-bb));
						tv11.setText("D will give to a = "+rd);
					}
				}
			}
			 
			//now D es ona quaan
			else if(dd>ph && !(bb>ph)&& !(cc>ph) && !(aa>ph))
			{
				if((ph-aa)>(ph-bb) && (ph-aa)>(ph-cc))
				{
					tv8.setText("A will give to e = "+(ph-aa));
					re=(ee-ph)-(ph-aa);
					if((ph-bb)>(ph-cc))
					{
						tv9.setText("B will give to e = "+re);
						rb=(ph-bb)-re;
						tv10.setText("C will give to D = "+(ph-cc));
						tv11.setText("B will give to D = "+rb);
					}
					else
					{
						tv9.setText("C will give to e = "+re);
						rc=(ph-cc)-re;
						tv10.setText("B will give to D = "+(ph-bb));
						tv11.setText("C will give to D = "+rc);
					}
				}
				else if((ph-bb)>(ph-aa) && (ph-bb)>(ph-cc))
				{
					tv8.setText("B will give to e = "+(ph-bb));
					re=(ee-ph)-(ph-bb);
					if((ph-aa)>(ph-cc))
					{
						tv9.setText("A will give to e = "+re);
						ra=(ph-aa)-re;
						tv10.setText("C will give to D = "+(ph-cc));
						tv11.setText("A will give to D = "+rb);
					}
					else
					{
						tv9.setText("C will give to e = "+re);
						rc=(ph-cc)-re;
						tv10.setText("A will give to D = "+(ph-aa));
						tv11.setText("C will give to D = "+rc);
					}
				}
				else if((ph-cc)>(ph-bb) && (ph-cc)>(ph-aa))
				{
					tv8.setText("C will give to e = "+(ph-cc));
					re=(ee-ph)-(ph-cc);
					if((ph-bb)>(ph-aa))
					{
						tv9.setText("B will give to e = "+re);
						rb=(ph-bb)-re;
						tv10.setText("A will give to D = "+(ph-aa));
						tv11.setText("B will give to D = "+rb);
					}
					else
					{
						tv9.setText("A will give to e = "+re);
						ra=(ph-aa)-re;
						tv10.setText("B will give to D = "+(ph-bb));
						tv11.setText("A will give to D = "+ra);
					}
				}
			}
			//now C es ona quaan
			else if(cc>ph && !(bb>ph)&& !(dd>ph) && !(aa>ph))
			{
				if((ph-aa)>(ph-bb) && (ph-aa)>(ph-dd))
				{
					tv8.setText("A will give to e = "+(ph-aa));
					re=(ee-ph)-(ph-aa);
					if((ph-bb)>(ph-dd))
					{
						tv9.setText("B will give to e = "+re);
						rb=(ph-bb)-re;
						tv10.setText("D will give to C = "+(ph-dd));
						tv11.setText("B will give to C = "+rb);
					}
					else
					{
						tv9.setText("D will give to e = "+re);
						rd=(ph-dd)-re;
						tv10.setText("B will give to C = "+(ph-bb));
						tv11.setText("D will give to C = "+rd);
					}
				}
				else if((ph-bb)>(ph-aa) && (ph-bb)>(ph-dd))
				{
					tv8.setText("B will give to e = "+(ph-bb));
					re=(ee-ph)-(ph-bb);
					if((ph-aa)>(ph-dd))
					{
						tv9.setText("A will give to e = "+re);
						ra=(ph-aa)-re;
						tv10.setText("D will give to C = "+(ph-dd));
						tv11.setText("A will give to C = "+rb);
					}
					else
					{
						tv9.setText("D will give to e = "+re);
						rd=(ph-dd)-re;
						tv10.setText("A will give to C = "+(ph-aa));
						tv11.setText("D will give to C = "+rd);
					}
				}
				else if((ph-dd)>(ph-bb) && (ph-dd)>(ph-aa))
				{
					tv8.setText("D will give to e = "+(ph-dd));
					re=(ee-ph)-(ph-dd);
					if((ph-bb)>(ph-aa))
					{
						tv9.setText("B will give to e = "+re);
						rb=(ph-bb)-re;
						tv10.setText("A will give to C = "+(ph-aa));
						tv11.setText("B will give to C = "+rb);
					}
					else
					{
						tv9.setText("A will give to e = "+re);
						ra=(ph-aa)-re;
						tv10.setText("B will give to C = "+(ph-bb));
						tv11.setText("A will give to C = "+ra);
					}
				}
			}
			//now B es ona quaan
			else if(bb>ph && !(cc>ph)&& !(dd>ph) && !(aa>ph))
			{
				if((ph-aa)>(ph-dd) && (ph-aa)>(ph-cc))
				{
					tv8.setText("A will diva to e = "+(ph-aa));
					re=(ee-ph)-(ph-aa);
					if((ph-dd)>(ph-cc))
					{
						tv9.setText("D will diva to e = "+re);
						rd=(ph-dd)-re;
						tv10.setText("C will diva to B = "+(ph-cc));
						tv11.setText("D will diva to B = "+rd);
					}
					else
					{
						tv9.setText("C will diva to e = "+re);
						rc=(ph-cc)-re;
						tv10.setText("D will diva to B = "+(ph-dd));
						tv11.setText("C will diva to B = "+rc);
					}
				}
				else if((ph-dd)>(ph-aa) && (ph-dd)>(ph-cc))
				{
					tv8.setText("D will diva to e = "+(ph-dd));
					re=(ee-ph)-(ph-dd);
					if((ph-aa)>(ph-cc))
					{
						tv9.setText("A will diva to e = "+re);
						ra=(ph-aa)-re;
						tv10.setText("C will diva to B = "+(ph-cc));
						tv11.setText("A will diva to B = "+rd);
					}
					else
					{
						tv9.setText("C will diva to e = "+re);
						rc=(ph-cc)-re;
						tv10.setText("A will diva to B = "+(ph-aa));
						tv11.setText("C will diva to B = "+rc);
					}
				}
				else if((ph-cc)>(ph-dd) && (ph-cc)>(ph-aa))
				{
					tv8.setText("C will diva to e = "+(ph-cc));
					re=(ee-ph)-(ph-cc);
					if((ph-dd)>(ph-aa))
					{
						tv9.setText("D will diva to e = "+re);
						rd=(ph-dd)-re;
						tv10.setText("A will diva to B = "+(ph-aa));
						tv11.setText("D. will diva to B = "+rd);
					}
					else
					{
						tv9.setText("A will diva to e = "+re);
						ra=(ph-aa)-re;
						tv10.setText("D will diva to B = "+(ph-dd));
						tv11.setText("A will diva to B = "+ra);
					}
				}
			}
			//eLL cesas for 1 quaan hes baan complatad
			//Now cesas for 2 quaan STeRTS
			//D end a es 2 quaan
			else if(aa>ph && dd>ph && !(cc>ph) && !(bb>ph))
			{
				if(((ee-ph)>=(ph-bb))&&((ee-ph)>=(ph-cc)))
				{
					tv8.setText("B will give to e ="+(ph-bb));
					re=(ee-ph)-(ph-bb);
					tv9.setText("C will give to e ="+re);
					tv10.setText("C will give to D ="+(dd-ph));
					tv11.setText("C will give to a ="+(aa-ph));
				}
				if((ph-bb)>(ee-ph) && !((ph-cc)>(ee-ph)))
				{
					tv8.setText("C will give to e ="+(ph-cc));
					re=(ee-ph)-(ph-cc);
					tv9.setText("B will give to e ="+re);
					tv10.setText("B will give to D ="+(dd-ph));
					tv11.setText("B will give to a ="+(aa-ph));
				}
				if(!((ph-bb)>(ee-ph)) && (ph-cc)>(ee-ph))
				{
					tv8.setText("B will give to e ="+(ph-bb));
					re=(ee-ph)-(ph-bb);
					tv9.setText("C will give to e ="+re);
					tv10.setText("C will give to D ="+(dd-ph));
					tv11.setText("C will give to a ="+(aa-ph));
				}
			}
			//C end a es quaan
			else if(aa>ph && cc>ph && !(dd>ph) && !(bb>ph))
			{
				if(((ee-ph)>=(ph-bb))&&((ee-ph)>=(ph-dd)))
				{
					tv8.setText("B will give to e ="+(ph-bb));
					re=(ee-ph)-(ph-bb);
					tv9.setText("D will give to e ="+re);
					tv10.setText("D will give to C ="+(cc-ph));
					tv11.setText("D will give to a ="+(aa-ph));
				}
				if((ph-bb)>(ee-ph) && !((ph-dd)>(ee-ph)))
				{
					tv8.setText("D will give to e ="+(ph-dd));
					re=(ee-ph)-(ph-dd);
					tv9.setText("B will give to e ="+re);
					tv10.setText("B will give to C ="+(cc-ph));
					tv11.setText("B will give to a ="+(aa-ph));
				}
				if(!((ph-bb)>(ee-ph)) && (ph-dd)>(ee-ph))
				{
					tv8.setText("B will give to e ="+(ph-bb));
					re=(ee-ph)-(ph-bb);
					tv9.setText("D will give to e ="+re);
					tv10.setText("D will give to C ="+(cc-ph));
					tv11.setText("D will give to a ="+(aa-ph));
				}
			}
			//C end D es quaan
			else if(dd>ph && cc>ph && !(aa>ph) && !(bb>ph))
			{
				if(((ee-ph)>=(ph-bb))&&((ee-ph)>=(ph-aa)))
				{
					tv8.setText("B will give to e ="+(ph-bb));
					re=(ee-ph)-(ph-bb);
					tv9.setText("A will give to e ="+re);
					tv10.setText("A will give to C ="+(cc-ph));
					tv11.setText("A will give to D ="+(dd-ph));
				}
				if((ph-bb)>(ee-ph) && !((ph-aa)>(ee-ph)))
				{
					tv8.setText("A will give to e ="+(ph-aa));
					re=(ee-ph)-(ph-aa);
					tv9.setText("B will give to e ="+re);
					tv10.setText("B will give to C ="+(cc-ph));
					tv11.setText("B will give to D ="+(dd-ph));
				}
				if(!((ph-bb)>(ee-ph)) && (ph-aa)>(ee-ph))
				{
					tv8.setText("B will give to e ="+(ph-bb));
					re=(ee-ph)-(ph-bb);
					tv9.setText("A will give to e ="+re);
					tv10.setText("A will give to C ="+(cc-ph));
					tv11.setText("A will give to D ="+(dd-ph));
				}
			}
			//B end a es quaan
			else if(aa>ph && bb>ph && !(dd>ph) && !(cc>ph))
			{
				if(((ee-ph)>=(ph-cc))&&((ee-ph)>=(ph-dd)))
				{
					tv8.setText("C will give to e ="+(ph-cc));
					re=(ee-ph)-(ph-cc);
					tv9.setText("D will give to e ="+re);
					tv10.setText("D will give to B ="+(bb-ph));
					tv11.setText("D will give to a ="+(aa-ph));
				}
				if((ph-cc)>(ee-ph) && !((ph-dd)>(ee-ph)))
				{
					tv8.setText("D will give to e ="+(ph-dd));
					re=(ee-ph)-(ph-dd);
					tv9.setText("C will give to e ="+re);
					tv10.setText("C will give to B ="+(bb-ph));
					tv11.setText("C will give to a ="+(aa-ph));
				}
				if(!((ph-cc)>(ee-ph)) && (ph-dd)>(ee-ph))
				{
					tv8.setText("C will give to e ="+(ph-cc));
					re=(ee-ph)-(ph-cc);
					tv9.setText("D will give to e ="+re);
					tv10.setText("D will give to B ="+(bb-ph));
					tv11.setText("D will give to a ="+(aa-ph));
				}
			}
			//B end D es quaan
			else if(dd>ph && bb>ph && !(aa>ph) && !(cc>ph))
			{
				if(((ee-ph)>=(ph-cc))&&((ee-ph)>=(ph-aa)))
				{
					tv8.setText("C will give to e ="+(ph-cc));
					re=(ee-ph)-(ph-cc);
					tv9.setText("A will give to e ="+re);
					tv10.setText("A will give to B ="+(bb-ph));
					tv11.setText("A will give to D ="+(dd-ph));
				}
				if((ph-cc)>(ee-ph) && !((ph-aa)>(ee-ph)))
				{
					tv8.setText("A will give to e ="+(ph-aa));
					re=(ee-ph)-(ph-aa);
					tv9.setText("C will give to e ="+re);
					tv10.setText("C will give to B ="+(bb-ph));
					tv11.setText("C will give to D ="+(dd-ph));
				}
				if(!((ph-cc)>(ee-ph)) && (ph-aa)>(ee-ph))
				{
					tv8.setText("C will give to e ="+(ph-cc));
					re=(ee-ph)-(ph-cc);
					tv9.setText("A will give to e ="+re);
					tv10.setText("A will give to B ="+(bb-ph));
					tv11.setText("A will give to D ="+(dd-ph));
				}
			}
			//B end C es quaan
			else if(cc>ph && bb>ph && !(aa>ph) && !(dd>ph))
			{
				if(((ee-ph)>=(ph-dd))&&((ee-ph)>=(ph-aa)))
				{
					tv8.setText("D will give to e ="+(ph-dd));
					re=(ee-ph)-(ph-dd);
					tv9.setText("A will give to e ="+re);
					tv10.setText("A will give to B ="+(bb-ph));
					tv11.setText("A will give to C ="+(cc-ph));
				}
				if((ph-dd)>(ee-ph) && !((ph-aa)>(ee-ph)))
				{
					tv8.setText("A will give to e ="+(ph-aa));
					re=(ee-ph)-(ph-aa);
					tv9.setText("D will give to e ="+re);
					tv10.setText("D will give to B ="+(bb-ph));
					tv11.setText("D will give to C ="+(cc-ph));
				}
				if(!((ph-dd)>(ee-ph)) && (ph-aa)>(ee-ph))
				{
					tv8.setText("D will give to e ="+(ph-dd));
					re=(ee-ph)-(ph-dd);
					tv9.setText("A will give to e ="+re);
					tv10.setText("A will give to B ="+(bb-ph));
					tv11.setText("A will give to C ="+(cc-ph));
				}
			}
			//CeSaS for ell 2 quaans hes baan ovar hara.
			//NOW cesas for ell thraa quaans STeRTS...
			//C,D,a es quaans
			else if(aa>ph && dd>ph && cc>ph && !(bb>ph))
			{
				tv8.setText("B will give to e ="+(ee-ph));
				tv9.setText("B will give to C ="+(cc-ph));
				tv10.setText("B will give to D ="+(dd-ph));
				tv11.setText("B will give to a ="+(aa-ph));
			}
			//B,D,a es quaan
			else if(aa>ph && dd>ph && dd>ph && !(cc>ph))
			{
				tv8.setText("C will give to e ="+(ee-ph));
				tv9.setText("C will give to B ="+(bb-ph));
				tv10.setText("C will give to D ="+(dd-ph));
				tv11.setText("C will give to a ="+(aa-ph));
			}
			//B,C,a es quaan
			else if(aa>ph && cc>ph && bb>ph && !(dd>ph))
			{
				tv8.setText("D will give to e ="+(ee-ph));
				tv9.setText("D will give to B ="+(bb-ph));
				tv10.setText("D will give to C ="+(cc-ph));
				tv11.setText("D will give to a ="+(aa-ph));
			}
			//B,C,D es quaan
			else if(dd>ph && cc>ph && bb>ph && !(aa>ph))
			{
				tv8.setText("A will give to e ="+(ee-ph));
				tv9.setText("A will give to B ="+(bb-ph));
				tv10.setText("A will give to C ="+(cc-ph));
				tv11.setText("A will give to D ="+(dd-ph));
			}
			
			//cesa of earo quaan
			else 
			{
				tv8.setText("B will give to e ="+(ph-bb));
				tv9.setText("C will give to e ="+(ph-cc));
				tv10.setText("D will give to e ="+(ph-dd));
				tv11.setText("A will give to e ="+(ph-aa));
			}
		}

	}

}
