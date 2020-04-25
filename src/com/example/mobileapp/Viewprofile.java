package com.example.mobileapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Viewprofile extends Activity {
	EditText fname,lname,address,contact,email,password,eml,pass;
	Button update;
	Context ctx=this;
	String Email,Password,Eml,Pass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewprofile);
		Bundle bn=getIntent().getExtras();
		Email=bn.getString("Email");
		Password=bn.getString("Password");
		fname=(EditText) findViewById(R.id.editText1);
		lname=(EditText) findViewById(R.id.editText2);
		address=(EditText) findViewById(R.id.editText3);
		contact=(EditText) findViewById(R.id.editText4);
		email=(EditText) findViewById(R.id.editText5);
		password=(EditText) findViewById(R.id.editText6);
		//eml=(TextView) findViewById(R.id.textView13);
		//pass=(TextView) findViewById(R.id.textView14);
		//eml.setText(Email);
		//pass.setText(Password);
		//Eml=eml.getText().toString();
		//Pass=pass.getText().toString();
		update=(Button) findViewById(R.id.button1);
		Database db=new Database(ctx);
		Cursor cr=db.getinfo(db);
		cr.moveToFirst();
		do{
			if (Email.equals(cr.getString(5))&&Password.equals(cr.getString(6))){
				fname.setText(cr.getString(1));
				lname.setText(cr.getString(2));
				address.setText(cr.getString(3));
				contact.setText(cr.getString(4));
				email.setText(cr.getString(5));
				password.setText(cr.getString(6));
			}
		}while(cr.moveToNext());
		update.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Eml=email.getText().toString();
				Pass=password.getText().toString();
				Database db=new Database(ctx);
				Cursor cr=db.getinfo(db);
				cr.moveToFirst();
				do{
					if(Eml.equals(cr.getString(5))&&Pass.equals(cr.getString(6))){
						Bundle bn=new Bundle();
						bn.putString("Email",cr.getString(5));
						bn.putString("Password",cr.getString(6));
						Intent u= new Intent(v.getContext(),Home.class);
						u.putExtras(bn);
						startActivity(u);
					}
				}while(cr.moveToNext());
				
			}});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.viewprofile, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
