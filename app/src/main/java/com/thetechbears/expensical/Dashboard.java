package com.thetechbears.expensical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button logout = findViewById(R.id.logout);
        PieChart pieChart = findViewById(R.id.pieChart);

//        Logout Button

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Dashboard.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

//        Charts
        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        for (int i = 0; i<10; i++){
            float value = (float) (i*10.0);
            PieEntry pieEntry = new PieEntry(i, value);
            pieEntries.add(pieEntry);
        }

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Employees");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.setData(new PieData(pieDataSet));
        pieChart.animateXY(5000, 5000);
        pieChart.getDescription().setEnabled(false);


    }
}