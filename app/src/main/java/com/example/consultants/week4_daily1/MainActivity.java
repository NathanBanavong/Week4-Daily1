package com.example.consultants.week4_daily1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

//public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    private OkHttpHelper okhttpHelper;
    private Spinner sp_nationality;
    private Spinner sp_gender;
    private Object pNationality;
    private Object pGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onBind();
        okhttpHelper = new OkHttpHelper();

        sp_nationality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                pNationality = adapterView.getItemAtPosition(position);
                if (pNationality != null) {
                    Log.d(TAG, "onItemSelected: " + pNationality.toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                pGender = adapterView.getItemAtPosition(position);
                if (pGender != null) {
                    Log.d(TAG, "onItemSelected: " + pGender.toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void onBind() {
        sp_gender = findViewById(R.id.sp_gender);
        sp_nationality = findViewById(R.id.sp_nationality);

//        sp_gender.setOnItemSelectedListener(this);
//        sp_nationality.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapterNationlity =
                ArrayAdapter.createFromResource(this, R.array.nationality_array,
                        android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterGender =
                ArrayAdapter.createFromResource(this, R.array.gender_array,
                        android.R.layout.simple_spinner_item);
        sp_nationality.setAdapter(adapterNationlity);

        sp_gender.setAdapter(adapterGender);
    }

    public void onSearch(View view) {
        okhttpHelper.execute(pNationality.toString(), pGender.toString());
    }

//TODO gender and nationality get passed same adapterView -> ERROR!!!!
//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
//        pNationality = adapterView.getItemAtPosition(position);
//        if (pNationality != null) {
//            Log.d(TAG, "onItemSelected: " + pNationality.toString());
//        }
//        pGender = adapterView.getItemAtPosition(position);
//        if(pGender != null) {
//            Log.d(TAG, "onItemSelected: " + pGender.toString());
//        }
//
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
}
