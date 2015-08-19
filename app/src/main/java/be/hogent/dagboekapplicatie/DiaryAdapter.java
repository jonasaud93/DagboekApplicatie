package be.hogent.dagboekapplicatie;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import be.hogent.dagboekapplicatie.persistence.Constants;
import be.hogent.dagboekapplicatie.persistence.MyDB;

/**
 * Created by jbuy519 on 26/10/2014.
 */
public class DiaryAdapter extends BaseAdapter {
    /**
     * The database where we are going to retrieve information from
     */
    private MyDB dba;

    /**
     * Layout inflater
     */
    private LayoutInflater inflater;
    /**
     * Arraylist containing the diary entries
     */
    private ArrayList<DiaryEntry> diaries;


    public DiaryAdapter(MyDB dba, Context context) {

    }

    /**
     * Retrieves the data from the database and populates the arraylist
     */
    public  void setData(Cursor c){

    }

    public void setDataToNull(){
        diaries.clear();
        notifyDataSetChanged();
    }

    /**
     * Returns the number of diary entries
     * @return
     */
    @Override
    public int getCount() {

    }

    /**
     * Returns the item at position
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {

    }

    /**
     * Returns the id of the item (here it is the same as the position)
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

    }

    /**
     * Private class which is used to improve the UI performance. When getView() is called
     * the view currently displayed to the user is also passed in, when it is saved
     * in the ViewHolder and tagged. on subsequent calls to getView with the same view, the tag
     * identiefies the view as already in the Viewholder. In this case the content can be changed
     * on the existing view rahter than a newly created one.
     */
    private class ViewHolder {
        private DiaryEntry entry;
        private TextView title;
        private TextView date;

        public DiaryEntry getEntry() {
            return entry;
        }

        public void setEntry(DiaryEntry entry) {
            this.entry = entry;
        }

        public TextView getDate() {
            return date;
        }

        public void setDate(TextView date) {
            this.date = date;
        }

        public TextView getTitle() {
            return title;
        }

        public void setTitle(TextView title) {
            this.title = title;
        }
    }
}
