package com.example.kharchamanager;





import android.support.v7.app.ActionBarActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	double a,b,c,d,e,f,t;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText e1=(EditText) findViewById(R.id.editText1);
		final EditText e2=(EditText) findViewById(R.id.editText2);
		final EditText e3=(EditText) findViewById(R.id.editText3);
		final EditText e4=(EditText) findViewById(R.id.editText4);
		final EditText e5=(EditText) findViewById(R.id.editText5);
		final EditText e6=(EditText) findViewById(R.id.editText6);
		Button b1=(Button) findViewById(R.id.button1);
		final CheckBox c4=(CheckBox) findViewById(R.id.checkBox4);
		final CheckBox c5=(CheckBox) findViewById(R.id.checkBox5);
		final CheckBox c6=(CheckBox) findViewById(R.id.checkBox6);
		Toast.makeText(getBaseContext(), "GIVE ATLEAST THREE INPUTS", Toast.LENGTH_SHORT).show();
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if((e1.getText().toString().equals("")) || (e2.getText().toString().equals("")) || (e3.getText().toString().equals("")))
				{
					Toast.makeText(getBaseContext(), "ATLEAST THREE INPUTS", Toast.LENGTH_SHORT).show();
				}
				else{
				if(!c4.isChecked()&&!c5.isChecked()&&!c6.isChecked())
				{
					a=Double.parseDouble(e1.getText().toString());
					b=Double.parseDouble(e2.getText().toString());
					c=Double.parseDouble(e3.getText().toString());
					final Intent intent=new Intent(getApplicationContext(),second_k.class);
					intent.putExtra("aaa",a);
					intent.putExtra("bbb",b);
					intent.putExtra("ccc",c);
					startActivity(intent);
				}
				else if(c4.isChecked()&&!c5.isChecked()&&!c6.isChecked())
				{
					if(e4.getText().toString().equals(""))
					{
						Toast.makeText(getBaseContext(), "INPUT FOR D???", Toast.LENGTH_SHORT).show();
					}
					else
					{
					a=Double.parseDouble(e1.getText().toString());
					b=Double.parseDouble(e2.getText().toString());
					c=Double.parseDouble(e3.getText().toString());
					d=Double.parseDouble(e4.getText().toString());
					Intent intent2=new Intent (getApplicationContext(),third_k.class);
					intent2.putExtra("aaa",a);
					intent2.putExtra("bbb",b);
					intent2.putExtra("ccc",c);
					intent2.putExtra("ddd",d);
					startActivity(intent2);
					}
				}
				else if(c4.isChecked()&&c5.isChecked()&&!c6.isChecked())
				{
					if((e4.getText().toString().equals("")) || (e5.getText().toString().equals("")))
					{
						Toast.makeText(getBaseContext(), "INPUT FOR D or E???", Toast.LENGTH_SHORT).show();
					}
					else
					{
					a=Double.parseDouble(e1.getText().toString());
					b=Double.parseDouble(e2.getText().toString());
					c=Double.parseDouble(e3.getText().toString());
					d=Double.parseDouble(e4.getText().toString());
					e=Double.parseDouble(e5.getText().toString());
					Intent intent3=new Intent (getApplicationContext(),fourth_k.class);
					intent3.putExtra("aaa",a);
					intent3.putExtra("bbb",b);
					intent3.putExtra("ccc",c);
					intent3.putExtra("ddd",d);
					intent3.putExtra("eee",e);
					startActivity(intent3);
					}
				}
				else if(c4.isChecked()&&c5.isChecked()&&c6.isChecked())
				{
					if((e4.getText().toString().equals("")) || (e5.getText().toString().equals("")) || (e6.getText().toString().equals("")))
					{
						Toast.makeText(getBaseContext(), "INPUT FOR D or E or F ???", Toast.LENGTH_SHORT).show();
					}
					else
					{
					a=Double.parseDouble(e1.getText().toString());
					b=Double.parseDouble(e2.getText().toString());
					c=Double.parseDouble(e3.getText().toString());
					d=Double.parseDouble(e4.getText().toString());
					e=Double.parseDouble(e5.getText().toString());
					f=Double.parseDouble(e6.getText().toString());
					Intent intent4=new Intent (getApplicationContext(),fifth_k.class);
					intent4.putExtra("aaa",a);
					intent4.putExtra("bbb",b);
					intent4.putExtra("ccc",c);
					intent4.putExtra("ddd",d);
					intent4.putExtra("eee",e);
					intent4.putExtra("fff",f);
					startActivity(intent4);
					}
				}
				else
				{
					Toast tt=Toast.makeText(MainActivity.this,"Opps!!! Checkbox should be in SEQUENCE", 6000);
					tt.setGravity(Gravity.CENTER,0,0);
					tt.show();
				}
					
			}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.cus_menu,menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch(item.getItemId()){
		case R.id.help:
			
			startActivity(new Intent(MainActivity.this,help.class));
			
			}
		return super.onOptionsItemSelected(item);
	}
}
