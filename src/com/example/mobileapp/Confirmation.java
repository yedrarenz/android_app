package com.example.mobileapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Confirmation extends Activity {
	EditText Cpass;
	Button ok;
	String Email,Password,Fname,Lname,Address,Contact,Email1,Password1,cpass;
	Context ctx=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirmation);
		Bundle bn=getIntent().getExtras();
		Email=bn.getString("Email");
		Password=bn.getString("Password");
		Fname=bn.getString("Fname");
		Lname=bn.getString("Lname");
		Address=bn.getString("Address");
		Contact=bn.getString("Contact").toString();
		Email1=bn.getString("Email1");
		Password1=bn.getString("Password1");
		Cpass=(EditText) findViewById(R.id.editText1);
		ok=(Button) findViewById(R.id.button1);
		ok.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cpass=Cpass.getText().toString();
				if(cpass.equals(Password)){
					Database db= new Database(ctx);
					db.updateInfo(db, Email, Password, Fname, Lname, Address, Contact, Email1, Password1);
					startActivity(new Intent(v.getContext(),MainActivity.class));
					
				}
			}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.confirmation, menu);
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
