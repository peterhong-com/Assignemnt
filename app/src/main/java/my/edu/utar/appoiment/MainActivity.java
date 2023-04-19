package my.edu.utar.appoiment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView btnChild;
    ImageView btnAdult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChild = findViewById(R.id.btnChild);
        btnAdult = findViewById(R.id.btnAdult);

        btnChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Child Clicked", Toast.LENGTH_SHORT).show();
                Intent loadChildActivity = new Intent(getApplicationContext(), activity_student.class);
                startActivity(loadChildActivity);
            }


        });

        btnAdult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Adult Clicked", Toast.LENGTH_SHORT).show();
                Intent loadAdultActivity = new Intent(getApplicationContext(), activity_adult.class);
                startActivity(loadAdultActivity);
            }


        });
    }
}