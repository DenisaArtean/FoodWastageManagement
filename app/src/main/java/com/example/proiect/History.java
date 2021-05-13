package com.example.proiect;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {
    
    RecyclerView recyclerView;
    private List<Info> infoList ;
    private RecyclerView.Adapter adapter;
    private String URL = "http://10.0.2.2/PDM/getInfo.php";
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        infoList = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        user = extras.getString("username");

        getInfo();
    }

    private void getInfo() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> {
            try{
                JSONArray array = new JSONArray(response);
                for(int i=0; i<array.length(); i++){
                    JSONObject obj = array.getJSONObject(i);

                    /*String address = obj.getString("Address");
                    String city = obj.getString("City");
                    String county = obj.getString("County");
                    int code = obj.getInt("ZipCode");
                    String date = obj.getString("Date");
                    String username = obj.getString("Username");
                    String phone = obj.getString("PhoneNumber");
                    String food = obj.getString("FoodLeft");

                    Info info = new Info(username, address, city, code, county, date, phone, food);

                    infoList.add(info); */

                    infoList.add(new Info(
                            obj.getString("Username"),
                            obj.getString("Address"),
                            obj.getString("City"),
                            obj.getInt("ZipCode"),
                            obj.getString("County"),
                            obj.getString("Date"),
                            obj.getString("PhoneNumber"),
                            obj.getString("FoodLeft")
                    ));

                }
                adapter = new InfoAdapter(History.this, infoList);
                recyclerView.setAdapter(adapter);
            }catch(Exception e){
                e.printStackTrace();
            }

        }, error -> Toast.makeText(History.this, error.toString().trim(), Toast.LENGTH_SHORT).show());
        Volley.newRequestQueue(this).add(stringRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                logout();
                return true;
            case R.id.location:
                location();
                return true;
            case R.id.all:
                showAll();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void showAll() {
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }

    private void location() {
        Intent intent = new Intent(this, User.class);
        intent.putExtra("username", user);
        startActivity(intent);
    }

    private void logout() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}