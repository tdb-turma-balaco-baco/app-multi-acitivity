package com.example.appmultiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView txtFinalGrade;
    private TextView txtResult;
    private TextView txtStudentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initializeFields();

        Intent it = getIntent();
        Bundle params = it.getExtras();
        populateFields(params);
    }

    private void initializeFields(){
        txtResult = findViewById(R.id.txtResult);
        txtFinalGrade = findViewById(R.id.txtFinalGrade);
        txtStudentName = findViewById(R.id.txtNameStudent);
    }

    private void populateFields(Bundle params){
        if(params == null) return;

        txtStudentName.setText(params.getString("name"));
        Double finalGrade = params.getDouble("finalGrade");
        txtFinalGrade.setText(String.valueOf(finalGrade));
        int frequency = params.getInt("frequency");
        txtResult.setText(getStatusStudent(frequency, finalGrade));

    }

    private String getStatusStudent(int freq, Double finalGrade) {
        if(freq >= 75 && finalGrade >= 7.0) return "APROVADO";
        if(freq >= 75 && finalGrade >= 4) return "FINAL";
        if(freq < 75) return "REPROVADO POR FALTA";
        if(finalGrade < 4) return "REPROVADO POR NOTA";
        return "";
    }
}