package com.example.restapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Objects;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    ArrayList<CountryModel> countryModelArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetCountries();
    }

    public Object GetCountries() {
        GetCountryDataService getCountryDataService = RetrofitInstance.getService();
        Call<Result> call = getCountryDataService.getResults();
    }
}