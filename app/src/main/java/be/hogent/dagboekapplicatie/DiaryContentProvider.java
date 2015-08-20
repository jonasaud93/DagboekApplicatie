package be.hogent.dagboekapplicatie;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

import org.apache.http.auth.AUTH;

import be.hogent.dagboekapplicatie.persistence.Constants;
import be.hogent.dagboekapplicatie.persistence.MyDB;
import be.hogent.dagboekapplicatie.persistence.MyDBHelper;

/**
 * Created by jbuy519 on 26/10/2014.
 */
public class DiaryContentProvider extends ContentProvider {
    private static final String TAG = DiaryContentProvider.class.getSimpleName();
    public static final Uri CONTENT_URI = Uri.parse("content://be.hogent.dagboekapplicatie");

    private MyDB db;

    private static final UriMatcher uriMatcher;
    private static final int ALLROWS = 1;
    private static final int SINGLE_ROW = 2;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("be.hogent.dagboekapplicatie", "diaries", ALLROWS);
        uriMatcher.addURI("be.hogent.dagboekapplicatie", "diaries/#", SINGLE_ROW);
    }

    @Override
    public boolean onCreate() {
        db = new MyDB(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        String groupBy = null;
        String having = null;

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        switch (uriMatcher.match(uri)){
            case SINGLE_ROW :
                String rowId = uri.getPathSegments().get(1);
                queryBuilder.appendWhere(rowId);
                default: break;
        }

        return queryBuilder.query(db.getDbHelper().getReadableDatabase(), projection, selection, selectionArgs, groupBy, having, sortOrder);
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        long id = db.insertDiary(values);
        if(id > -1){
            Uri insertedId = ContentUris.withAppendedId(CONTENT_URI, id);
            getContext().getContentResolver().notifyChange(insertedId, null);

            return insertedId;
        }
        Log.i(TAG, "no insert happened");
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
