package my.edu.utar.appoiment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class activity_adult extends AppCompatActivity {

    Button btnAdult;
    EditText a1, a2, a3, a4, a5, a6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adult2);
        a1 = findViewById(R.id.editTextTextPersonName1);
        a2 = findViewById(R.id.editTextTextPersonName2);
        a3 = findViewById(R.id.editTextTextPersonName3);
        a4 = findViewById(R.id.editTextDate);
        a5 = findViewById(R.id.editTextTextPersonName4);
        a6 = findViewById(R.id.editTextTextPersonName5);
        btnAdult = findViewById(R.id.btnSubmit);
        btnAdult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Thank for Register", Toast.LENGTH_SHORT).show();
                new Thread() {
                    @Override
                    public void run() {
                        try {

                            String key = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZpZm5obmJ5ZXhucXZ5Z3lqemZ6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2ODAyMjUxNzcsImV4cCI6MTk5NTgwMTE3N30.k0I9NLl2Xulj6lkLR09NjHxdDD5W-My9Dr8yyoqZNJY";
                            URL a = null;
                            try {
                                a = new URL("https://fifnhnbyexnqvygyjzfz.supabase.co/rest/v1/Vaccination");
                            } catch (
                                    MalformedURLException e) {
                                e.printStackTrace();
                            }

                            HttpURLConnection hv = null;
                            try {
                                hv = (HttpURLConnection) a.openConnection();
                            } catch (
                                    IOException e) {
                                e.printStackTrace();
                            }
                            hv.setRequestProperty("apikey", key);
                            hv.setRequestProperty("Authorization", "Bearer " + key);

                            try {
                                hv.setRequestMethod("POST");
                            } catch (
                                    ProtocolException e) {
                                e.printStackTrace();
                            }
                            hv.setRequestProperty("Content-Type", "application/json");
                            hv.setRequestProperty("Prefer", "return=minimal");
                            hv.setDoOutput(true);

                            JSONObject o0 = new JSONObject();

                            try {
                                o0.put("Name", a1.getText().toString());
                                o0.put("RollNo", a2.getText().toString());
                                o0.put("Department", a3.getText().toString());
                                o0.put("VaccinationDate", a4.getText().toString());
                                o0.put("VaccinationName", a5.getText().toString());
                                o0.put("VaccinationNo", a6.getText().toString());
                            } catch (
                                    JSONException e) {
                                e.printStackTrace();
                            }

                            OutputStream out = null;
                            try {
                                out = hv.getOutputStream();
                            } catch (
                                    IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                out.write(o0.toString().getBytes());
                            } catch (
                                    IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                out.flush();
                            } catch (
                                    IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                if (hv.getResponseCode() == 201) {
                                    Intent loadChildActivity = new Intent(getApplicationContext(), MainActivity2.class);
                                    startActivity(loadChildActivity);
                                } else {
                                    Log.e("This error", "Responcode " + hv.getResponseCode());
                                }
                            } catch (
                                    IOException e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
    }
}
