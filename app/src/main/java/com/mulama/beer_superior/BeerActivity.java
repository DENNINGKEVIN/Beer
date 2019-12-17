package com.mulama.beer_superior;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeerActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.beerTextView) TextView mBeerTextView;
    @BindView(R.id.beerListView) ListView mBeerListView;
    @BindView(R.id.addBeerButton) Button mAddBeerButton;
    private String[] beers = new String[] {"pilsner","tusker","guiness","senator","balozi","carlsberg","whitecap","bavaria","redds","castle"};
    private Integer[] ratings=new Integer[] {4,5,3,6,3,2,5,2,5,2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        MyBeerArrayAdapter adapter = new MyBeerArrayAdapter(this, android.R.layout.simple_list_item_1, beers, ratings);
        mBeerListView.setAdapter(adapter);
        mBeerListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String beer = ((TextView)view).getText().toString();
                Toast.makeText(BeerActivity.this, beer, Toast.LENGTH_LONG).show();
            }
        });
        mAddBeerButton.setOnClickListener(this);
        mBeerTextView.setText("Here are the Beers: " + name);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(BeerActivity.this, ContributeActivity.class);
        startActivity(intent);
    }
}