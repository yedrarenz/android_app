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

public class Home extends Activity {
	Button vp,up,d,l;
	String Email,Password;
	Context ctx=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Bundle bn=getIntent().getExtras();
		Email=bn.getString("Email");
		Password=bn.getString("Password");
		vp=(Button) findViewById(R.id.button1);
		up=(Button) findViewById(R.id.button2);
		d=(Button) findViewById(R.id.button3);
		l=(Button) findViewById(R.id.button4);
		vp.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Bundle bn=new Bundle();
				bn.putString("Email", Email);
				bn.putString("Password", Password);
				Intent p=new Intent(v.getContext(),Viewprofile.class);
				p.putExtras(bn);
				startActivity(p);
			}});	
		up.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Bundle bn=new Bundle();
				bn.putString("Email", Email);
				bn.putString("Password", Password);
				Intent up=new Intent(v.getContext(),Editprofile.class);
				up.putExtras(bn);
				startActivity(up);
			}});
		d.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}});
		l.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(v.getContext(),MainActivity.class));
			}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
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
