package com.example.mobileapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNewAccount extends Activity {
	EditText Fname,Lname,Address,Contact,Email,Password;
	Button create;
	String fname,lname,address,email,password,contact;
	Context ctx=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_new_account);
		Fname=(EditText) findViewById(R.id.editText1);
		Lname=(EditText) findViewById(R.id.editText2);
		Address=(EditText) findViewById(R.id.editText3);
		Contact=(EditText) findViewById(R.id.editText4);
		Email=(EditText) findViewById(R.id.editText5);
		Password=(EditText) findViewById(R.id.editText6);
		create=(Button) findViewById(R.id.button1);
		create.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				fname=Fname.getText().toString();
				lname=Lname.getText().toString();
				address=Address.getText().toString();
				contact=Contact.getText().toString();
				email=Email.getText().toString();
				password=Password.getText().toString();
				Database db=new Database(ctx);
				db.putInfo(db, null, fname, lname, address, contact, email, password);
				Toast.makeText(getBaseContext(), "Successfully Registered!", Toast.LENGTH_SHORT).show();
				finish();
			}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_new_account, menu);
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
