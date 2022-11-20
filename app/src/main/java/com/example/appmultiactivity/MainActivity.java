package com.example.appmultiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appmultiactivity.models.Student;

public class MainActivity extends AppCompatActivity {

    private EditText studentName;
    private EditText firstGrade;
    private EditText secondGrade;
    private EditText frequency;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
    }

    private void initializeComponents(){
        initializeFields();
        initializeButtonsActions();
    }

    private void initializeFields(){
        studentName = findViewById(R.id.edtxt_nome);
        firstGrade = findViewById(R.id.edtxt_nota1);
        secondGrade = findViewById(R.id.edtxt_nota2);
        calculate = findViewById(R.id.btn_calcular);
        frequency = findViewById(R.id.edtxt_freq);
    }

    private void initializeButtonsActions(){
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateResultActivity();
            }
        });
    }


    private void generateResultActivity(){
        Student student = createStudent();
        if(student == null) return;
        callResultActivity(student);
    }

    private void callResultActivity(Student student){
        Intent resultActivity = new Intent(this, ResultActivity.class);
        Bundle params = new Bundle();
        params.putString("name", student.getName());
        params.putDouble("finalGrade", student.getFinalGrade());
        params.putInt("frequency", student.getFrequency());
        resultActivity.putExtras(params);
        startActivity(resultActivity);
    }

    private Student createStudent(){
        try {
            return new Student(studentName.getText().toString(),
                    Double.parseDouble(firstGrade.getText().toString()),
                    Double.parseDouble(secondGrade.getText().toString()),
                    Integer.parseInt(frequency.getText().toString()));

        }catch (NumberFormatException ex){
            Toast.makeText(this,R.string.validation_message,Toast.LENGTH_LONG).show();
            return null;
        }
    }
}