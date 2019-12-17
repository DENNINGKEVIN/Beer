package com.mulama.beer_superior;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ContributeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribute);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ContributeActivity.this, BeerActivity.class);
        startActivity(intent);

    }
}
