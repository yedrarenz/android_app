package com.example.mobileapp;

import android.provider.BaseColumns;

public class Table {
	public static abstract class Tinfo implements BaseColumns{
		public static final String DBname="DBmobileApp";
		public static final String Tname="Users";
		public static final String C_ID="UID";
		public static final String C_Fname="FName";
		public static final String C_Lname="Lname";
		public static final String C_Add="Address";
		public static final String C_Contact="Contac";
		public static final String C_UName="Email";
		public static final String C_Pass="Password";
	}
}

