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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.viewBeersButton) Button mViewBeersButton;
    @BindView(R.id.enterNameEditText) EditText mEnterNameEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

//    private SharedPreferences msharedpreferences;
//    private SharedPreferences.Editor mEditor;

    private DatabaseReference mSearchedBeerReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //firebase
        mSearchedBeerReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_BEER);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        msharedpreferences= PreferenceManager.getDefaultSharedPreferences(this);
//        mEditor=msharedpreferences.edit();

        mViewBeersButton.setOnClickListener(this);
    }
//    public void addShredPreferences (String beertext){
//        mEditor.putString(Constants.PREFERENCES_BEER_ENTER_KEY,beertext).apply();
//    }

    @Override
    public void onClick(View v) {
        if(v == mViewBeersButton) {
            String name = mEnterNameEditText.getText().toString();
//            if(!(name).equals("")){
//                addShredPreferences(name);
//            }
            addToFirebase(name);
            Intent intent = new Intent(MainActivity.this, BeerActivity.class);
             Toast.makeText(MainActivity.this, "Welcome " , Toast.LENGTH_LONG).show();
            intent.putExtra("name", name);
            startActivity(intent);
        }
    }

  public void addToFirebase(String beerName){
        mSearchedBeerReference.push().setValue(beerName);
  }
}
