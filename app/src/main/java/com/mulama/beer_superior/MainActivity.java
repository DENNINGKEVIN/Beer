package com.mulama.beer_superior;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
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

    private SharedPreferences msharedpreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        msharedpreferences= PreferenceManager.getDefaultSharedPreferences(this);
        mEditor=msharedpreferences.edit();

        mViewBeersButton.setOnClickListener(this);
    }
    public void addShredPreferences (String beertext){
        mEditor.putString(Constants.PREFERENCES_BEER_ENTER_KEY,beertext).apply();
    }

    @Override
    public void onClick(View v) {
        if(v == mViewBeersButton) {
            String name = mEnterNameEditText.getText().toString();
            if(!(name).equals("")){
                addShredPreferences(name);
            }

            Intent intent = new Intent(MainActivity.this, BeerActivity.class);
             Toast.makeText(MainActivity.this, "Welcome " , Toast.LENGTH_LONG).show();
            intent.putExtra("name", name);
            startActivity(intent);
        }
    }


}
