package com.ics.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    String namewa;
    TextView nmae;
    LinearLayout lingo;
    ListView mlist;
    // Array of strings...
    String[] mobileArray = {"Samsung Galaxy note 7", "Samsung Galaxy S10", "Samsung Galaxy note 9", "Samsung Galaxy S9+",
            "Samsung Galaxy J7", "Samsung Galaxy j7++", "Samsung Galaxy note 7"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        namewa = getIntent().getStringExtra("namewa");

        nmae = (TextView) findViewById(R.id.nmae);
        nmae.setText(namewa);

       /* lingo = (LinearLayout) findViewById(R.id.lingo);
        lingo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, Order_Products.class);
                intent.putExtra("namewa", namewa);
                startActivity(intent);
            }
        });*/

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.listlist, mobileArray);

        mlist = (ListView) findViewById(R.id.mlist);
        mlist.setAdapter(adapter);

        mlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Main3Activity.this, Order_Products.class);
                intent.putExtra("namewa", namewa);
                startActivity(intent);
            }
        });
    }
}
