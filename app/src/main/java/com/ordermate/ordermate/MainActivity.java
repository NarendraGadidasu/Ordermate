package com.ordermate.ordermate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.ordermate.ordermate.R;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.app.SearchManager;

import java.lang.ref.Reference;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();

    private void initFirestore() {
        mFirestore = FirebaseFirestore.getInstance();
    }

    private String userId;
    private long requestId;
    private String location;
    private String business;
    private double yourAmount;
    private double expectedAmount;
    private double maxDist;
    private double maxWait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**hide action bar*/
        getSupportActionBar().hide();

        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        Places.initialize(getApplicationContext(), "-");

        PlacesClient placesClient = Places.createClient(this);

        AutocompleteSupportFragment asf = (AutocompleteSupportFragment) getSupportFragmentManager().
                findFragmentById(R.id.location);

        asf.setPlaceFields(Arrays.asList(Place.Field.LAT_LNG, Place.Field.NAME));

        asf.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                Log.i("On Selection", "Place: "+place.getName()+", "+place.getLatLng());
                location = place.getName();
            }
            @Override
            public void onError(@NonNull Status status) {
                Log.i("OnSelection", "An error occured: "+status);
            }
        });

        Button findMyOrdermate = (Button) findViewById(R.id.find_my_ordermate);

        findMyOrdermate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                EditText business_text = (EditText) findViewById(R.id.business);
                business = business_text.getText().toString();

                EditText yourAmount_text = (EditText) findViewById(R.id.yourAmount);
                yourAmount = Double.parseDouble(yourAmount_text.getText().toString());

                EditText expectedAmount_text = (EditText) findViewById(R.id.expectedAmount);
                expectedAmount = Double.parseDouble(expectedAmount_text.getText().toString());

                EditText maxDist_text = (EditText) findViewById(R.id.maxDist);
                maxDist = Double.parseDouble(maxDist_text.getText().toString());

                EditText maxWait_text = (EditText) findViewById(R.id.maxWait);
                maxWait = Double.parseDouble(maxWait_text.getText().toString());

                DocumentReference new_request = mFirestore.collection("requests").document();
                Request req = new Request(userId, 28, location, business, yourAmount, expectedAmount, maxDist, maxWait, "Sus", 3.7, 1.6, 17);

                new_request.set(req).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Intent intent = new Intent(MainActivity.this, MyRequestsActivity.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "request added", Toast.LENGTH_SHORT);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "failed to add", Toast.LENGTH_SHORT);
                        }
                    }
                });
            }
        });
    }
}
