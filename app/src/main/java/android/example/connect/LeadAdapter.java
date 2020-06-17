package android.example.connect;

import android.app.Activity;
import android.content.Context;
import android.example.connect.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

/**Creating a custom class LeaddAdapter as a sub-class of
 * the class ArrayAdapter<Word>
 */
public class WordAdapter extends ArrayAdapter<Lead> {

    /**Defining the constructor to use the constructor of
     * the super class ArrayAdapter<Word>
     * @param context
     * @param words Array list of Word objects
     */
    public WordAdapter(Activity context, ArrayList<Lead> words){
        super(context, 0, words);
    }

    /**Overriding the behavior of getView function defined in the
     * ArrayAdapter<Word> class
     * *
     * @param position The position from which the data needs to be fetched from the array list words
     * @param convertView The view which needs to be populated with the data
     * @param parent
     * @return The populated view
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null){
            listItemView =  LayoutInflater.from(getContext()).inflate(R.layout.leads_list_item, parent, false);
        }

        Lead currentLead = getItem(position);

        TextView mTextView = (TextView) listItemView.findViewById(R.id.list_item_text_1);

        mTextView.setText(currentWord.getMiwokTranslation());

        TextView dTextView = listItemView.findViewById(R.id.list_item_text_2);

        dTextView.setText(currentWord.getDefaultTranslation());

        return listItemView;

    }
}
