package android.example.connect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.example.connect.R;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**Creating a custom class RequestAdapter as a sub-class of
 * the class ArrayAdapter<Request>
 */
public class RequestAdapter extends ArrayAdapter<Request> {

    /**Defining the constructor to use the constructor of
     * the super class ArrayAdapter<Request>
     * @param context
     * @param requests Array list of Word objects
     */
    public RequestAdapter(Activity context, ArrayList<Request> requests){
        super(context, 0, requests);
    }

    /**Overriding the behavior of getView function defined in the
     * ArrayAdapter<Request> class
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
            listItemView =  LayoutInflater.from(getContext()).inflate(R.layout.my_requests_list_item, parent, false);
        }

        final int pos = position;

        Request currentRequest = getItem(position);

        TextView locationTextView = (TextView) listItemView.findViewById(R.id.my_requests_location);

        locationTextView.setText(currentRequest.getLocation());

        TextView businessTextView = (TextView) listItemView.findViewById(R.id.my_requests_business);

        businessTextView.setText(currentRequest.getBusiness());

        TextView myAmountTextView = listItemView.findViewById(R.id.my_requests_my_amount);

        myAmountTextView.setText("My Amount: "+currentRequest.getYourAmount());

        TextView expectedAmountTextView = listItemView.findViewById(R.id.my_requests_expected_amount);

        expectedAmountTextView.setText("Expected: "+currentRequest.getExpectedAmount());

        Button findLeadsButton = (Button) listItemView.findViewById(R.id.my_requests_find_leads);
        findLeadsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = RequestAdapter.super.getContext();
                Intent intent = new Intent(context, LeadsActivity.class);
                context.startActivity(intent);
            }
        });

        return listItemView;

    }
}

