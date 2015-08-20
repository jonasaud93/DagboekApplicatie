package be.hogent.dagboekapplicatie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DisplayEntry extends Activity {
    private DisplayDiaries displayDiaries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_entry);

        displayDiaries = new DisplayDiaries();
    }





}
