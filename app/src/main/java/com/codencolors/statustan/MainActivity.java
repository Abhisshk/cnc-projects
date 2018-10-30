package com.codencolors.statustan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import Bottomfragments.FavouriteFragment;
import Bottomfragments.ImageFragment;
import Bottomfragments.SuggestionFragment;
import Bottomfragments.LogInFragment;
import Bottomfragments.TextFragment;
import other.BottomNavigationViewHelper;

public
class MainActivity extends AppCompatActivity {
    private
    Toolbar toolbar;
    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment ( new TextFragment () );
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    {
        mOnNavigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener () {

            @Override
            public
            boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId ()) {
                    case R.id.navigation_text:
                        fragment=new TextFragment ();
                        loadFragment ( fragment );
                        return true;
                    case R.id.navigation_image:
                        fragment=new ImageFragment ();
                        loadFragment ( fragment );
                        return true;
                    case R.id.navigation_suggestion:
                        fragment=new SuggestionFragment ();
                        loadFragment ( fragment );
                        return true;

                    case R.id.navigation_favourite:
                        fragment=new FavouriteFragment ();
                        loadFragment ( fragment );
                        return true;


                    case R.id.navigation_login:
                        fragment=new LogInFragment ();
                        loadFragment ( fragment );
                        return true;


                }
                return false;
            }
        };
    }

    private void loadFragment(Fragment fragment) {
            // load fragment
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }
