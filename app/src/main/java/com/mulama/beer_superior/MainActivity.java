package com.mulama.beer_superior;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.viewBeersButton) Button mViewBeersButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    private DatabaseReference mSearchedBeerReference;
    private ValueEventListener mSearchedBeerReferencelistener;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    getSupportActionBar().setTitle("Olla " + user.getDisplayName().toUpperCase() + " !");
                } else {
                    getSupportActionBar().setTitle("Welcome User!");
                }
            }
        };

        //firebase
        mSearchedBeerReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_BEER);

        mSearchedBeerReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot beerSnapshot:dataSnapshot.getChildren()){
                    String beer=beerSnapshot.getValue().toString();
                    Log.d("Beers updated", "beers: " + beer);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

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
//            if(!(name).equals("")){
//                addShredPreferences(name);
//            }
            Intent intent = new Intent(MainActivity.this, BeerActivity.class);
             Toast.makeText(MainActivity.this, "Welcome " , Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
    }

  public void addToFirebase(String beerName){
        mSearchedBeerReference.push().setValue(beerName);
  }
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mSearchedBeerReference.removeEventListener(mSearchedBeerReferencelistener);
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    //logout functionality
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_overflow, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LogInActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
