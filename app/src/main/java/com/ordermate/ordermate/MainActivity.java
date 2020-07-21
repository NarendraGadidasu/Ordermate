package com.ordermate.ordermate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.ordermate.ordermate.R;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();

    private void initFirestore() {
        mFirestore = FirebaseFirestore.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Places.initialize(getApplicationContext(), "AIzaSyBv93mUyDCvgNUcrP95-NnqsSGlAV6VxXA");

        PlacesClient placesClient = Places.createClient(this);

        AutocompleteSupportFragment asf = (AutocompleteSupportFragment) getSupportFragmentManager().
                findFragmentById(R.id.location);

        asf.setPlaceFields(Arrays.asList(Place.Field.LAT_LNG, Place.Field.NAME));

        asf.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                Log.i("On Selection", "Place: "+place.getName()+", "+place.getLatLng());
            }
            @Override
            public void onError(@NonNull Status status) {
                Log.i("OnSelection", "An error occured: "+status);
            }
        });

        /**hide action bar*/
        getSupportActionBar().hide();

        Button findMyOrdermate = (Button) findViewById(R.id.find_my_ordermate);

        findMyOrdermate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                CollectionReference requests = mFirestore.collection("requests");
                requests.add(new Request(8, 28, "paces", "dunkin.com", 21, 31, 1.2, 1, "Sus", 3.7, 1.6, 17));
                Toast.makeText(getApplicationContext(), "request added", Toast.LENGTH_SHORT);
                Intent intent = new Intent(MainActivity.this, MyRequestsActivity.class);
                startActivity(intent);
            }
        });
    }
}