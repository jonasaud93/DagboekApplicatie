package be.hogent.dagboekapplicatie;

import android.app.ListActivity;
import android.app.LoaderManager;
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

    /**
     * The database we are storing the database entries
     */
    private MyDB dba;
    /**
     * The DiaryAdapter to show the diary entries
     */
    private DiaryAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        ;
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
