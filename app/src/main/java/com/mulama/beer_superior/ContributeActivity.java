package com.mulama.beer_superior;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContributeActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.submitButton) Button mSubmitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribute);
        ButterKnife.bind(this);

        mSubmitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ContributeActivity.this, BeerActivity.class);
        startActivity(intent);
        Toast.makeText(ContributeActivity.this, "Beer Submited!", Toast.LENGTH_LONG).show();

    }
}
