package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.example.connect.R;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class LeadsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leads);

        /**hide action bar*/
        getSupportActionBar().hide();

        ArrayList<Lead> leads = new ArrayList<Lead>();

        leads.add(new Lead("Abhi", 3.5, 1.2, 19));
        leads.add(new Lead("Amy", 2.5, 1.4, 13));
        leads.add(new Lead("Suresh", 5, 0.6, 41));
        leads.add(new Lead("Syamala", 4.8, 0.9, 34));
        leads.add(new Lead("Raj", 4.2, 0.7, 32));
        leads.add(new Lead("Harry", 5, 0.3, 37));
        leads.add(new Lead("Hermione", 4.5, 2.1, 29));
        leads.add(new Lead("Narendra", 4.5, 1.8, 23));
        leads.add(new Lead("Ron", 4.7, 1.1, 32));
        leads.add(new Lead("Rahman", 5, 0.2, 38));
        leads.add(new Lead("Vasu", 3.2, 1.1, 32));
        leads.add(new Lead("Dinesh", 4.3, 0.8, 26));
        leads.add(new Lead("Sud", 3.9, 1.5, 23));
        leads.add(new Lead("Sus", 3.7, 1.6, 17));
        leads.add(new Lead("Ravi", 4.1, 2.1, 26));

        LeadAdapter itemsAdapter = new LeadAdapter(this, leads);
        ListView listView = (ListView) findViewById(R.id.leads_list);
        listView.setAdapter(itemsAdapter);

    }

}