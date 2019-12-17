package com.mulama.beer_superior;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mulama.beer_superior.adapters.BeerAdapter;
import com.mulama.beer_superior.models.BeerModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeerActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.beerTextView) TextView mBeerTextView;
    @BindView(R.id.beerRecyclerView)
    RecyclerView beerRecyclerView;
    ArrayList<BeerModel> beerModelArrayList=new ArrayList<>();
    BeerAdapter beerAdapter;
    @BindView(R.id.addBeerButton) Button mAddBeerButton;
//    private String[] beers = new String[] {"pilsner","tusker","guiness","senator","balozi","carlsberg","whitecap","bavaria","redds","castle"};
//    private Integer[] ratings=new Integer[] {4,5,3,6,3,2,5,2,5,2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
//        MyBeerArrayAdapter adapter = new MyBeerArrayAdapter(this, android.R.layout.simple_list_item_1, beers, ratings);
//        mBeerListView.setAdapter(adapter);
//        mBeerListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
//                String beer = ((TextView)view).getText().toString();
//                Toast.makeText(BeerActivity.this, beer, Toast.LENGTH_LONG).show();
//            }
//        });
//        mAddBeerButton.setOnClickListener(this);

        beerAdapter=new BeerAdapter(BeerActivity.this,beerModelArrayList);
//        beerRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        beerRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        beerRecyclerView.setAdapter(beerAdapter);
        loadBeer();
        mBeerTextView.setText("Here are the Beers: " + name);
    }

    private void loadBeer() {
        BeerModel  beerModel=new BeerModel("https://wallpapercave.com/wp/wp2697155.jpg","Guiness");
        BeerModel beerModel1=new BeerModel("https://www.bigbeaverdiaries.com/wp-content/uploads/2016/02/1220063-1024x768.jpg","Balozi");
        BeerModel beerModel2=new BeerModel("https://pbs.twimg.com/media/Cpz94CjWIAAc5Ro.jpg","Senator");
        BeerModel beerModel3=new BeerModel("https://cdn.mpasho.co.ke/wp-content/uploads/2018/06/White-Cap.jpg","WhiteCap");
        BeerModel beerModel4=new BeerModel("https://www.oaksncorks.com/wp-content/uploads/2017/09/blog-covers-21-1024x614.png","Tusker");
        BeerModel beerModel5=new BeerModel("https://d3czfiwbzom72b.cloudfront.net/wp-content/uploads/2018/10/REDDS-APPLE-ALE-6PK-12OZ-Beer.png","Redds");
        BeerModel beerModel6=new BeerModel("https://images.squarespace-cdn.com/content/5bb894db16b640604a4d1ca9/1541494520185-XMB8WVT5XH5X8AH3WIHT/Castle.jpg?content-type=image%2Fjpeg","Castle");
        BeerModel beerModel7=new BeerModel("https://packagingeurope.com/downloads/6809/download/Carlsberg-GFB-3.jpg?cb=3c6c3ff5313a29572b53e5b4e3d32a41&w=640","Carlsberg");




        beerModelArrayList.add(beerModel);
        beerModelArrayList.add(beerModel1);
        beerModelArrayList.add(beerModel2);
        beerModelArrayList.add(beerModel3);
        beerModelArrayList.add(beerModel4);
        beerModelArrayList.add(beerModel5);
        beerModelArrayList.add(beerModel6);
        beerModelArrayList.add(beerModel7);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(BeerActivity.this, ContributeActivity.class);
        startActivity(intent);
    }
}