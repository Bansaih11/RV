package com.example.rv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SeconedActivity extends AppCompatActivity {
    ImageView MainImageView;
    TextView Title,description;
    String data1,data2;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconed);
        MainImageView=findViewById(R.id.MainImageView);
        Title=findViewById(R.id.Title);
        description=findViewById(R.id.description);

        getData();
        setData();
    }
    public void getData(){
        if ( getIntent().hasExtra("myImage")&& getIntent().hasExtra("data1") && getIntent().hasExtra("data2")){}
        else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
    public void setData(){
        Title.setText(data1);
        description.setText(data2);
        MainImageView.setImageResource(myImage);

    }




}