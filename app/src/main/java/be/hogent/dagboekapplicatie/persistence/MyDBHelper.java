package be.hogent.dagboekapplicatie.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jbuy519 on 23/10/2014.
 */
public class MyDBHelper extends SQLiteOpenHelper{


    private static final String TAG =" MyDBHelper.class";

    private static final String CREATE_TABLE ="CREATE TABLE "+Constants.TABLE_NAME+ " (" +
            Constants.COL_ID + " integer primary key autoincrement, " +
            Constants.COL_TITLE + " text not null, " +
            Constants.COL_DATE + " date not null " +
            Constants.COL_DESCRIPTION + " text not null);";



    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Generates the tables in the  de SQLiteDatabase
     * @param db The SQLIteDatabase to add the tables to
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    /**
     * Performs an upgrade of the database in case of version mismatch.
     * Implementation here is to drop all the tables and generate new tables.
     * For actual implementations this should perform a clean data migration
     * @param db The database to update
     * @param oldVersion The old version of the database
     * @param newVersion The new version to perform the update for
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading from old version: " + oldVersion + " to new version " + newVersion);

        db.execSQL("DROP TABLE " + Constants.TABLE_NAME);
        onCreate(db);

    }
}
