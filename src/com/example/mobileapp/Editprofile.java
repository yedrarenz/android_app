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

public class Editprofile extends Activity {
EditText fname,lname,address,contact,email,password;
Button back,save;
String Email,Password,Fname,Lname,Address,Contact,Email1,Password1;
Context ctx=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editprofile);
		Bundle bn=getIntent().getExtras();
		Email=bn.getString("Email").toString();
		Password=bn.getString("Password").toString();
		fname=(EditText) findViewById(R.id.editText1);
		lname=(EditText) findViewById(R.id.editText2);
		address=(EditText) findViewById(R.id.editText3);
		contact=(EditText) findViewById(R.id.editText4);
		email=(EditText) findViewById(R.id.editText5);
		password=(EditText) findViewById(R.id.editText6);
		back=(Button) findViewById(R.id.button2);
		save=(Button) findViewById(R.id.button1);
		Database db=new Database(ctx);
		Cursor cr=db.getinfo(db);
		cr.moveToFirst();
		do{
			if(Email.equals(cr.getString(5))&&Password.equals(cr.getString(6))){
				fname.setText(cr.getString(1));
				lname.setText(cr.getString(2));
				address.setText(cr.getString(3));
				contact.setText(cr.getString(4));
				email.setText(cr.getString(5));
				password.setText(cr.getString(6));
			}
			
		}while(cr.moveToNext());
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Bundle bn=new Bundle();
				bn.putString("Email", Email);
				bn.putString("Password", Password);
				Intent bac=new Intent(v.getContext(),Home.class);
				bac.putExtras(bn);
				startActivity(bac);
			}});
		save.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Fname=fname.getText().toString();
				Lname=lname.getText().toString();
				Address=address.getText().toString();
				Contact=contact.getText().toString();
				Email1=email.getText().toString();
				Password1=password.getText().toString();
				Bundle bn=new Bundle();
				bn.putString("Email", Email);
				bn.putString("Password", Password);
				bn.putString("Fname", Fname);
				bn.putString("Lname", Lname);
				bn.putString("Address", Address);
				bn.putString("Contact", Contact);
				bn.putString("Email1", Email1);
				bn.putString("Password1", Password1);
				Intent sa=new Intent(v.getContext(),Confirmation.class);
				sa.putExtras(bn);
				startActivity(sa);
				finish();
			}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.editprofile, menu);
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
