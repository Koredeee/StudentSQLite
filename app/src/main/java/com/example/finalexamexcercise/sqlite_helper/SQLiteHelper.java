package com.example.finalexamexcercise.sqlite_helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.finalexamexcercise.model.Student;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "finalexamdb";
    private static final int DB_VERSION = 2;
    private static final String STUDENT_TABLE = "msstudent";
    private static final String ID_COLUMN = "studentid";
    private static final String NAME_COLUMN = "studentname";
    private static final String NIM_COLUMN = "studentnim";
    private static final String EMAIL_COLUMN = "studentemail";
    private static final String PHONE_COLUMN = "stduentphone";

    public SQLiteHelper(@Nullable Context context) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = String.format("CREATE TABLE %s " +
                "(%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL)",
                STUDENT_TABLE, ID_COLUMN, NAME_COLUMN, NIM_COLUMN, EMAIL_COLUMN, PHONE_COLUMN);
        db.execSQL(createTableQuery);
    }

    public Boolean insertStudent(String name, String nim, String email, String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues insertData = new ContentValues();
        insertData.put(NAME_COLUMN, name);
        insertData.put(NIM_COLUMN, nim);
        insertData.put(EMAIL_COLUMN, email);
        insertData.put(PHONE_COLUMN, phone);

        Long isSuccess = db.insert(STUDENT_TABLE, null, insertData);
        if (isSuccess == -1){
            return  false;
        } else {
            return true;
        }
    }

    public List<Student> getAllStudent(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor getQuery = db.rawQuery("SELECT * FROM " + STUDENT_TABLE, null);

        List<Student> studentList = new ArrayList<>();

        if(getQuery.moveToFirst()){
            do {
                String name = getQuery.getString(1);
                String nim = getQuery.getString(2);
                String email = getQuery.getString(3);
                String phone = getQuery.getString(3);
                Student newStudent = new Student(name, nim, email, phone);
                studentList.add(newStudent);
            } while (getQuery.moveToNext());
        }
        getQuery.close();

        return  studentList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        onCreate(db);
    }
}
