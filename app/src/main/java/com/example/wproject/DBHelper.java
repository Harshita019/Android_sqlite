package com.example.wproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBName = "fdetails.db";


    public DBHelper(Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table Admin(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Address TEXT, Mobile TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Admin");
        onCreate(db);
    }

    public long insertdata(String id, String name, String address, String mobile){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("Name", name);
        contentValues.put("Address", address);
        contentValues.put("Mobile", mobile);

        long result = db.insert("Admin", null, contentValues);
        return result;

    }


    public ArrayList<Modal>  fetchData() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Admin", null);

     ArrayList<Modal> arrayList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                // on below line we are adding the data from
                // cursor to our array list.
                arrayList.add(new Modal(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)));
            } while (cursor.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursor.close();
        return arrayList;
    }

}

