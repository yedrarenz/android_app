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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	EditText Email, Password;
	String email,password;
	Button Signin;
	TextView Signup;
	Context ctx=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Email=(EditText) findViewById(R.id.editText1);
		Password=(EditText) findViewById(R.id.editText2);
		Signin=(Button) findViewById(R.id.button1);
		Signup=(TextView) findViewById(R.id.textView1);
		Signup.setOnClickListener(this);
		Signin.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				email=Email.getText().toString();
				password=Password.getText().toString();
				Database db= new Database(ctx);
				Cursor cr=db.getinfo(db);
				cr.moveToFirst();
				boolean status=false;
				do{
					if(email.equals(cr.getString(5))&&(password.equals(cr.getString(6)))){
						status=true;
					}
				}while(cr.moveToNext());
				if (status){
					Bundle bn=new Bundle();
					bn.putString("Email", email);
					bn.putString("Password", password);
					Intent i=new Intent(v.getContext(),Home.class);
					i.putExtras(bn);
					startActivity(i);
					Toast.makeText(getBaseContext(), "Welcome", Toast.LENGTH_SHORT).show();
					
				}
				else{
					Toast.makeText(getBaseContext(), "Login Failed!", Toast.LENGTH_SHORT).show();
				}
				
			}});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		startActivity(new Intent(this,CreateNewAccount.class));
	}
}
