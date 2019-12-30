package com.mahmoud.dahdouh.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private List<Student> students;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private EditText ed_name;
    private EditText ed_school;
    private Button btn_add;
    private Button btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inflate
        recyclerView = findViewById(R.id.recycler);
        radioGroup = findViewById(R.id.radio_group);
        ed_name = findViewById(R.id.ed_name);
        ed_school = findViewById(R.id.ed_school);
        btn_add = findViewById(R.id.btn_add);
        btn_delete = findViewById(R.id.btn_delete);

        students = new ArrayList<>();
        students.add(new Student("Moahmmed", "Al-Quds School", R.drawable.ic_male));


        adapter = new RecyclerAdapter(students);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed_name.getText().toString().trim().equals("")
                        || ed_school.getText().toString().trim().equals("")
                ) {
                    Toast.makeText(MainActivity.this, "please add ed_name and ed_school !!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(MainActivity.this, "please choose gender", Toast.LENGTH_SHORT).show();
                    return;
                }

                Student student = new Student();

                student.setName(ed_name.getText().toString().trim());
                student.setSchool(ed_school.getText().toString().trim());


                radioButton = findViewById(radioGroup.getCheckedRadioButtonId());

                switch (radioButton.getId()) {
                    case R.id.rb_male:
                        student.setImage(R.drawable.ic_male);
                        break;

                    case R.id.rb_female:
                        student.setImage(R.drawable.ic_female);
                        break;
                }
                students.add(student);
                adapter.notifyDataSetChanged();

            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (students.size() == 0) {
                    Toast.makeText(MainActivity.this, "There is no elements !", Toast.LENGTH_SHORT).show();
                } else
                    students.remove(students.size() - 1);
                adapter.notifyDataSetChanged();
            }


        });

    }


}
