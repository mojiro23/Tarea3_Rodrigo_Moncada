package com.example.tarea3_rodrigo_moncada_jimenez;

import android.app.ProgressDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.tarea3_rodrigo_moncada_jimenez.Fragments.CurrencyFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        FragmentTransaction ft =getSupportFragmentManager().beginTransaction();

        //FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        CurrencyFragment fragment2 = new CurrencyFragment();
        //Bundle bundle = new Bundle();
        //fragment2.setArguments(bundle);
        ft.replace(android.R.id.content, fragment2);
        ft.addToBackStack(null); //Add fragment in back stack
        ft.commit();
    }

}
