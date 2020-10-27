package com.artyushin.hw092;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner languageSpinner;
    private Spinner themeSpinner;
    String selectedLanguage;
    String selectedTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Utils.onActivityCreateSetTheme(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchSettings();
    }

    private void switchSettings() {

        Button buttonSettings = findViewById(R.id.buttonSettings);

        languageSpinner = findViewById(R.id.languageSpinner);

        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.languageSpinner,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        languageSpinner.setAdapter(adapter);

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                selectedLanguage = languageSpinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView parent) {
            }
        });

        themeSpinner = findViewById(R.id.themeSpinner);

        ArrayAdapter<?> adapterTheme = ArrayAdapter.createFromResource(this, R.array.themeSpinner,
                android.R.layout.simple_spinner_item);
        adapterTheme.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        themeSpinner.setAdapter(adapterTheme);

        themeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                selectedTheme = themeSpinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView parent) {
            }
        });

        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                switch (selectedLanguage) {
                    case "Russian":
                        russian();
                        break;
                    case "English":
                        english();
                        break;
                    case "Английский":
                        english();
                        break;
                    case "Русский":
                        russian();
                        break;
                }
                switch (selectedTheme) {
                    case "Крупная тема":
                        Utils.changeToTheme(MainActivity.this, R.style.bigMargin);
                        break;
                    case "Средняя тема":
                        Utils.changeToTheme(MainActivity.this, R.style.middleMargin);
                        break;
                    case "Мелкая тема":
                        Utils.changeToTheme(MainActivity.this, R.style.smallMargin);
                        break;
                    case "Big theme":
                        Utils.changeToTheme(MainActivity.this, R.style.bigMargin);
                        break;
                    case "Middle theme":
                        Utils.changeToTheme(MainActivity.this, R.style.middleMargin);
                        break;
                    case "Small theme":
                        Utils.changeToTheme(MainActivity.this, R.style.smallMargin);
                        break;
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void russian() {
        Locale locale = new Locale("ru");
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void english() {
        Locale locale = new Locale("en");
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }
}