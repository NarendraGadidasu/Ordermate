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

        locationTextView.setText("My Location : " + currentRequest.getLocation());

        TextView businessTextView = (TextView) listItemView.findViewById(R.id.my_requests_business);

        businessTextView.setText("Website : " + currentRequest.getBusiness());

        TextView myAmountTextView = listItemView.findViewById(R.id.my_requests_my_amount);

        myAmountTextView.setText("My Amount: " + currentRequest.getYourAmount());

        TextView expectedAmountTextView = listItemView.findViewById(R.id.my_requests_expected_amount);

        expectedAmountTextView.setText("Expected Amount: " + currentRequest.getExpectedAmount());

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.list_item_name);

        nameTextView.setText(currentRequest.getName());

        RatingBar ratingBar = (RatingBar) listItemView.findViewById(R.id.list_item_rating);

        ratingBar.setRating(Float.parseFloat(currentRequest.getRating()+""));

        TextView distanceTextView = listItemView.findViewById(R.id.list_item_distance);

        distanceTextView.setText("Distance: "+currentRequest.getDistance());

        TextView amountTextView = listItemView.findViewById(R.id.list_item_amount);

        amountTextView.setText("Amount: "+currentRequest.getAmount());

        Button mapButton = (Button) listItemView.findViewById(R.id.list_item_map);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = RequestAdapter.super.getContext();
                String uri = "http://maps.google.com/maps?saddr=" + 33.777671 + "," + -84.397297 + "&daddr=" + 33.763587 + "," + -84.35056;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                context.startActivity(intent);
            }
        });

        Button callButton = (Button) listItemView.findViewById(R.id.list_item_call);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = RequestAdapter.super.getContext();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0123456789"));
                context.startActivity(intent);
            }
        });

        Button textButton = (Button) listItemView.findViewById(R.id.list_item_text);
        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Request currentRequest = getItem(pos);
                Context context = RequestAdapter.super.getContext();
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"gdv.narendra@gmail.com;"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Connect Lead notification");
                intent.putExtra(Intent.EXTRA_TEXT, "Hello "+currentRequest.getName()+", "+
                        "\n\nI would like to order along with you!" +
                        "\nMy order value is "+currentRequest.getAmount()+
                        "\nMy distance from you is "+currentRequest.getDistance()+
                        "\nMy rating is "+currentRequest.getRating()+
                        "\n\nRegards\n"+"Damodara");
                if (intent.resolveActivity(context.getPackageManager()) != null){
                    context.startActivity(intent);
                }
            }
        });

        Button closeButton = (Button) listItemView.findViewById(R.id.list_item_close);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        return listItemView;

    }
}

