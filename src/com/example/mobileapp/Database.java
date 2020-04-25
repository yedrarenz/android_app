package com.example.mobileapp;

import com.example.mobileapp.Table.Tinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {

	public Database(Context context) {
		super(context,Tinfo.DBname, null, 1);
		Log.d("Database","Created");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE "+Tinfo.Tname+"("+Tinfo.C_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+Tinfo.C_Fname+" TEXT,"+Tinfo.C_Lname+" TEXT,"+Tinfo.C_Add+" TEXT,"+Tinfo.C_Contact+" TEXT,"+Tinfo.C_UName+" TEXT,"+Tinfo.C_Pass+" TEXT);");
		Log.d("Table", "Table Created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	public long putInfo(Database db, Integer id, String fname, String lname, String address, String contact, String email, String password) {
		SQLiteDatabase sq=db.getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put(Tinfo.C_ID, id);
		cv.put(Tinfo.C_Fname, fname);
		cv.put(Tinfo.C_Lname, lname);
		cv.put(Tinfo.C_Add, address);
		cv.put(Tinfo.C_Contact, contact);
		cv.put(Tinfo.C_UName, email);
		cv.put(Tinfo.C_Pass, password);
		return sq.insert(Tinfo.Tname, null, cv);
	}
	public Cursor getinfo(Database db) {
		SQLiteDatabase sq=db.getReadableDatabase();
		String [] colval={Tinfo.C_ID,Tinfo.C_Fname,Tinfo.C_Lname,Tinfo.C_Add,Tinfo.C_Contact,Tinfo.C_UName,Tinfo.C_Pass};
		Cursor cr=sq.query(Tinfo.Tname, colval, null, null, null, null, null);
		return cr;
	}
	public void updateInfo(Database db, String Email, String Password, String nfname, String nlname, String naddress, String ncontact, String nemail, String npassword) {
		SQLiteDatabase sq=db.getWritableDatabase();
		String Selection=Tinfo.C_UName+" LIKE ? AND "+Tinfo.C_Pass+" LIKE ?";
		String args []={Email,Password};
		ContentValues cv=new ContentValues();
		cv.put(Tinfo.C_Fname, nfname);
		cv.put(Tinfo.C_Lname, nlname);
		cv.put(Tinfo.C_Add, naddress);
		cv.put(Tinfo.C_Contact, ncontact);
		cv.put(Tinfo.C_UName, nemail);
		cv.put(Tinfo.C_Pass, npassword);
		sq.update(Tinfo.Tname, cv, Selection, args);
	}

}
