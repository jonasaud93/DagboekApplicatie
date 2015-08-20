package be.hogent.dagboekapplicatie;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.entity.ContentProducer;

import java.util.Date;

import be.hogent.dagboekapplicatie.persistence.Constants;
import be.hogent.dagboekapplicatie.persistence.MyDB;


public class SubmitEntryActivity extends Activity {
    private EditText txtTitle, txtContent;
    private Button btnSubmit;

    private MyDB db;


    /**
     * Creates this activity. Make sure that (i) you generate the db, (ii) open it, (iii) initialise
     * the references for the view and (iv) you add the code for the button listener.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_entry);

        txtTitle = (EditText) findViewById(R.id.editText_diary_title);
        txtContent = (EditText) findViewById(R.id.editText_content);

        db = new MyDB(this);


        btnSubmit = (Button) findViewById(R.id.submit_button);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToDB();

                Intent intent = new Intent(SubmitEntryActivity.this, DisplayEntry.class);
            }
        });
    }

    /**
     * Saves the information provided in the UI to the database. Check for null or empty strings
     * before entering into the DBA. Make toast messages in case of empty strings.
     */
    private void saveToDB(){
        String title = txtTitle.getText().toString();
        String content = txtContent.getText().toString();
        if(title == null || content == null || title == "" ||content == ""){
            Toast toastie = new Toast(this);
            toastie.setText("The values are invalid or empty");
            toastie.show();
        } else {
            Date date = new Date();

            ContentResolver cr = getContentResolver();

            ContentValues values = new ContentValues();
            values.put(Constants.COL_TITLE, title);
            values.put(Constants.COL_DATE, date.toString());
            values.put(Constants.COL_DESCRIPTION, content);

            cr.insert(DiaryContentProvider.CONTENT_URI, values);
        }
    }

}
