package be.hogent.dagboekapplicatie;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.ContentProvider;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import be.hogent.dagboekapplicatie.persistence.Constants;
import be.hogent.dagboekapplicatie.persistence.MyDB;

/**
 * Created by jbuy519 on 26/10/2014.
 */
public class DisplayDiaries extends ListActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int URL_LOADER = 0;
    private MyDB dba;

    private DiaryAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dba = new MyDB(this);
        adapter = new DiaryAdapter(dba,this);

        getLoaderManager().initLoader(URL_LOADER, null, this);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
         String[] projection = {Constants.COL_TITLE, Constants.COL_DATE, Constants.COL_DESCRIPTION};
         return new CursorLoader(this, DiaryContentProvider.CONTENT_URI, projection, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.notifyDataSetChanged();
        //adapter.swapCursor(data)
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.notifyDataSetChanged();
        //adapter.swapCursor(null);
    }
}

