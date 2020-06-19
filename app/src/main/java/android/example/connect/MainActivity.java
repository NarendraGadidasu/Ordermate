package android.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**hide action bar*/
        getSupportActionBar().hide();

        Button findMyOrdermate = (Button) findViewById(R.id.find_my_ordermate);

        findMyOrdermate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, LeadsActivity.class);
                startActivity(intent);
            }
        });
    }
}