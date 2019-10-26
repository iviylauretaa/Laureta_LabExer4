package com.example.oct25;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] names, countries ,industries, ceos, des;
    ListView lstcompany;

    int[] logo = {R.drawable.icbc, R.drawable.jpmorgan, R.drawable.china, R.drawable.agricultural, R.drawable.america, R.drawable.apple, R.drawable.pingan, R.drawable.bankofchina, R.drawable.shell, R.drawable.wellsfargo, R.drawable.exxon, R.drawable.atnt, R.drawable.samsung, R.drawable.citi};

    ArrayList<AndroidVersion> details = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("TOP GLOBAL COMPANIES");

        names = getResources().getStringArray(R.array.company);
        countries = getResources().getStringArray(R.array.country);
        industries = getResources().getStringArray(R.array.industry);
        ceos = getResources().getStringArray(R.array.ceo);
        des = getResources().getStringArray(R.array.description);

        for(int i = 0; i < names.length; i++){
            details.add(new AndroidVersion(names[i], countries[i], industries[i], ceos[i], logo[i]));
        }

        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.item, details);
        lstcompany = findViewById(R.id.cCompany);
        lstcompany.setAdapter(adapter);
        lstcompany.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(logo[i]);
        dialog.setTitle(names[i]);
        dialog.setMessage(des[i]);
        dialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                //Toast.makeText(MainActivity.this, names[i], Toast.LENGTH_LONG).show();
            }
        });
        dialog.create().show();

    }
}
