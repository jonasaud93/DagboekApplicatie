package be.hogent.dagboekapplicatie;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import be.hogent.dagboekapplicatie.persistence.Constants;
import be.hogent.dagboekapplicatie.persistence.MyDB;


public class SubmitEntryActivity extends Activity {



    /**
     * Creates this activity. Make sure that (i) you generate the db, (ii) open it, (iii) initialise
     * the references for the view and (iv) you add the code for the button listener.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

    }

    /**
     * Saves the information provided in the UI to the database. Check for null or empty strings
     * before entering into the DBA. Make toast messages in case of empty strings.
     */
    private void saveToDB(){


    }

}
