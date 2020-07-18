package com.ordermate.ordermate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.ordermate.ordermate.R;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

/**Creating a custom class LeadAdapter as a sub-class of
 * the class ArrayAdapter<Lead>
 */
public class LeadAdapter extends ArrayAdapter<Lead> {

    /**Defining the constructor to use the constructor of
     * the super class ArrayAdapter<Lead>
     * @param context
     * @param leads Array list of Word objects
     */
    public LeadAdapter(Activity context, ArrayList<Lead> leads){
        super(context, 0, leads);
    }

    /**Overriding the behavior of getView function defined in the
     * ArrayAdapter<Lead> class
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

        final int pos = position;

        Lead currentLead = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.list_item_name);

        nameTextView.setText(currentLead.getName());

        RatingBar ratingBar = (RatingBar) listItemView.findViewById(R.id.list_item_rating);

        ratingBar.setRating(Float.parseFloat(currentLead.getRating()+""));

        TextView distanceTextView = listItemView.findViewById(R.id.list_item_distance);

        distanceTextView.setText("Distance: "+currentLead.getDistance());

        TextView amountTextView = listItemView.findViewById(R.id.list_item_amount);

        amountTextView.setText("Amount: "+currentLead.getAmount());

        Button connectButton = (Button) listItemView.findViewById(R.id.list_item_map);
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = LeadAdapter.super.getContext();
                /**Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);*/

                Lead currentLead = getItem(pos);

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"gdv.narendra@gmail.com;"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Connect Lead notification");
                intent.putExtra(Intent.EXTRA_TEXT, "Hello "+currentLead.getName()+", "+
                        "\n\nI would like to order along with you!" +
                        "\nMy order value is "+currentLead.getAmount()+
                        "\nMy distance from you is "+currentLead.getDistance()+
                        "\nMy rating is "+currentLead.getRating()+
                        "\n\nRegards\n"+"Damodara");
                if (intent.resolveActivity(context.getPackageManager()) != null){
                    context.startActivity(intent);
                }


            }
        });

        return listItemView;

    }
}
