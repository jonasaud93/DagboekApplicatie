package be.hogent.dagboekapplicatie.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import be.hogent.dagboekapplicatie.DiaryEntry;

/**
 * Created by jbuy519 on 23/10/2014.
 */
public class MyDB {

    private static final String TAG = "MyDB.class";
    private MyDBHelper dbHelper;
    private SQLiteDatabase db;

    /**
     * Initialises this DB. Make sure the dbHelper object is also initialised.
     * @param context
     */
    public MyDB(Context context) {
        dbHelper = new MyDBHelper(context, Constants.DATABASE_NAME, null, 1);
        open();
    }

    /**
     * Closes the database
     */
    public void close(){
        if(db.isOpen())
            db.close();
    }
    /**
     * Tries to open a writable database. If this is not possible, open a readable database.
     * Log the necessary messages for debugging purposes.
     */
    public void open(){
        db = dbHelper.getWritableDatabase();
    }

    /**
     * Adds an diary entry to the database.
     * http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html#insert%28java.lang.String,%20java.lang.String,%20android.content.ContentValues%29
     * @return the row ID of the newly inserted row, or -1 if an error occurred
     */
    public long insertDiary(ContentValues newDiaryValue){
        return db.insert(Constants.TABLE_NAME,null, newDiaryValue);
    }

    /**
     * Fetches all diary entries from the database
     * @return The diary entries from the database.
     */
    public Cursor getDiaries(){
        String[] cols = {Constants.COL_ID, Constants.COL_TITLE,Constants.COL_DATE, Constants.COL_DESCRIPTION};
        Cursor cursor = db.query(Constants.TABLE_NAME, cols, null, null, null, null, null);
        return cursor;
    }

    public MyDBHelper getDbHelper() {
        return dbHelper;
    }

    public void setDbHelper(MyDBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }
}
