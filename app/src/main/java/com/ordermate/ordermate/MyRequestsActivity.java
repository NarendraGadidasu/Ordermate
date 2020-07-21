package com.ordermate.ordermate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.ordermate.ordermate.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyRequestsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_requests);

        /**hide action bar*/
        getSupportActionBar().hide();

        ArrayList<Request> requests = new ArrayList<Request>();

        requests.add(new Request(1, 21, "decatur", "amazon.com", 21, 16, 1.2, 1,"Manasa", 5, 0.4, 18));
        requests.add(new Request(2, 22, "hemphill", "doordash.com", 21, 31, 1.2, 1, "Abhi", 3.5, 1.2, 19));
        requests.add(new Request(3, 23, "14th streer", "mconalds.com", 21, 31, 1.2, 1, "Amy", 2.5, 1.4, 13));
        requests.add(new Request(4, 24, "10th street", "antico.com", 21, 31, 1.2, 1, "Suresh", 5, 0.6, 41));
        requests.add(new Request(5, 25, "hampton street", "costco.com", 21, 31, 1.2, 1, "Syamala", 4.8, 0.9, 34));
        requests.add(new Request(6, 26, "mcmillan street", "krogers.com", 21, 31, 1.2, 1, "Raj", 4.2, 0.7, 32));
        requests.add(new Request(7, 27, "peidmont heights", "publix.com", 21, 31, 1.2, 1, "Harry", 5, 0.3, 37));
        requests.add(new Request(8, 28, "peachtree hills", "rockymountain.com", 21, 31, 1.2, 1.2, "Hermione", 3.2, 4.5, 2.1));
        requests.add(new Request(1, 21, "underwood hills", "dominos.com", 21, 31, 1.2, 1, "Narendra", 4.5, 1.8, 23));
        requests.add(new Request(2, 22, "bankhead", "pizzahut.com", 21, 31, 1.2, 1, "Ron", 4.7, 1.1, 32));
        requests.add(new Request(3, 23, "colonial homes", "waffles.com", 21, 31, 1.2, 1, "Rahman", 5, 0.2, 38));
        requests.add(new Request(4, 24, "midtown", "chickfila.com", 21, 31, 1.2, 1, "Rahman", 5, 0.2, 38));
        requests.add(new Request(5, 25, "downtown", "wendys.com", 21, 31, 1.2, 1, "Vasu", 3.2, 1.1, 32));
        requests.add(new Request(6, 26, "greenbriar", "subway.com", 21, 31, 1.2, 1, "Dinesh", 4.3, 0.8, 26));
        requests.add(new Request(7, 27, "lakewood", "tacobell.com", 21, 31, 1.2, 1, "Sud", 3.9, 1.5, 23));
        requests.add(new Request(8, 28, "paces", "dunkin.com", 21, 31, 1.2, 1, "Sus", 3.7, 1.6, 17));


        RequestAdapter itemsAdapter = new RequestAdapter(this, requests);
        ListView listView = (ListView) findViewById(R.id.my_requests_list);
        listView.setAdapter(itemsAdapter);

        Button addRequest = (Button) findViewById(R.id.add_request);

        addRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MyRequestsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}