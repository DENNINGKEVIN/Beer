package com.mulama.beer_superior;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.viewBeersButton) Button mViewBeersButton;
    @BindView(R.id.enterNameEditText) EditText mEnterNameEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mViewBeersButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mViewBeersButton) {
            String name = mEnterNameEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, BeerActivity.class);
             Toast.makeText(MainActivity.this, "Welcome " + name, Toast.LENGTH_LONG).show();
            intent.putExtra("name", name);
            startActivity(intent);
        }
    }


}
