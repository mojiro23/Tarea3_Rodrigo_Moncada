package com.example.tarea3_rodrigo_moncada_jimenez.Fragments;


import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.tarea3_rodrigo_moncada_jimenez.R;

import org.json.JSONException;
import org.json.JSONObject;



public class CurrencyFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main, container, false);

        try {
            SetupUI(view);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return view;

    }

    public void SetupUI(final View view) throws JSONException{
        Button mButton = (Button) view.findViewById(R.id.buttondescarga);
        final EditText editTextdolar = (EditText) view.findViewById(R.id.edittextusd);
        final EditText editTextcalculo = (EditText) view.findViewById(R.id.edittextcalculo);
        final EditText editTextcolon = (EditText) view.findViewById(R.id.edittextcrc);
        final EditText editTexturu = (EditText) view.findViewById(R.id.edittextuyu);
        final EditText editTextven = (EditText) view.findViewById(R.id.edittextvef);
        final EditText editTextmex = (EditText) view.findViewById(R.id.edittextmxn);


       mButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {



               try {

                   JSONObject response = new JSONObject("{\n" +
                           "  \"success\":true,\n" +
                           "  \"terms\":\"https:\\/\\/currencylayer.com\\/terms\",\n" +
                           "  \"privacy\":\"https:\\/\\/currencylayer.com\\/privacy\",\n" +
                           "  \"timestamp\":1558622885,\n" +
                           "  \"source\":\"USD\",\n" +
                           "  \"quotes\":{\n" +
                           "    \"USDUSD\":1,\n" +
                           "    \"USDCRC\":587.794989,\n" +
                           "    \"USDUYU\":35.296502,\n" +
                           "    \"USDVEF\":9.9875,\n" +
                           "    \"USDMXN\":19.01302\n" +
                           "  }\n" +
                           "}");

                   final JSONObject currencies = response.getJSONObject("quotes");
                   //double usa = currencies.getDouble("USDUSD"); //Devuelve el value del key
                   double cr = currencies.getDouble("USDCRC"); //Devuelve el value del key
                   double uru = currencies.getDouble("USDUYU"); //Devuelve el value del key
                   double ven = currencies.getDouble("USDVEF"); //Devuelve el value del key
                   double mex = currencies.getDouble("USDMXN"); //Devuelve el value del key




                    double edittextus = Double.parseDouble(editTextcalculo.getText().toString());


                   double resultcolon = cr * edittextus;
                   editTextcolon.setText(String.valueOf(resultcolon));



                   Double resulturu = uru * edittextus;
                   editTexturu.setText(resulturu.toString());



                   Double resultven = ven * edittextus;
                   editTextven.setText(resultven.toString());


                   Double resultmex = mex *edittextus;
                   editTextmex.setText(resultmex.toString());

               } catch (JSONException e) {
                   e.printStackTrace();
               }

           }

        });
    }

    }

