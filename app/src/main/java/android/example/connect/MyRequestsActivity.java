package android.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MyRequestsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_requests);

        /**hide action bar*/
        getSupportActionBar().hide();

        ArrayList<Request> requests = new ArrayList<Request>();

        requests.add(new Request(1, 21, "a", "l", 21, 31, 1.2, 1));
        requests.add(new Request(2, 22, "b", "m", 21, 31, 1.2, 1));
        requests.add(new Request(3, 23, "c", "n", 21, 31, 1.2, 1));
        requests.add(new Request(4, 24, "d", "o", 21, 31, 1.2, 1));
        requests.add(new Request(5, 25, "e", "p", 21, 31, 1.2, 1));
        requests.add(new Request(6, 26, "f", "q", 21, 31, 1.2, 1));
        requests.add(new Request(7, 27, "g", "r", 21, 31, 1.2, 1));
        requests.add(new Request(8, 28, "h", "s", 21, 31, 1.2, 1));
        requests.add(new Request(1, 21, "a", "l", 21, 31, 1.2, 1));
        requests.add(new Request(2, 22, "b", "m", 21, 31, 1.2, 1));
        requests.add(new Request(3, 23, "c", "n", 21, 31, 1.2, 1));
        requests.add(new Request(4, 24, "d", "o", 21, 31, 1.2, 1));
        requests.add(new Request(5, 25, "e", "p", 21, 31, 1.2, 1));
        requests.add(new Request(6, 26, "f", "q", 21, 31, 1.2, 1));
        requests.add(new Request(7, 27, "g", "r", 21, 31, 1.2, 1));
        requests.add(new Request(8, 28, "h", "s", 21, 31, 1.2, 1));


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