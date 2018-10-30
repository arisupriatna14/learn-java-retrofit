package com.arisupriatna.learnretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arisupriatna.learnretrofit.retrofit.RetrofitActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnClickGwDong;
    private Button btnViewGroup;
    private Button btnDrawerActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClickGwDong =  (Button)findViewById(R.id.btn_click);
        btnClickGwDong.setOnClickListener(this);
        btnViewGroup = (Button)findViewById(R.id.btn_view_group_layout);
        btnViewGroup.setOnClickListener(this);
        btnDrawerActivity = (Button)findViewById(R.id.btn_drawer);
        btnDrawerActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_click: {
                Intent retrofitIntent = new Intent(MainActivity.this, RetrofitActivity.class);
                startActivity(retrofitIntent);
                break;
            }
            case R.id.btn_view_group_layout: {
                Intent viewGroupIntent = new Intent(this, ViewAndViewGroup.class);
                startActivity(viewGroupIntent);
                break;
            }
            case R.id.btn_drawer: {
                Intent drawerActivityIntent = new Intent(this, DrawerActivity.class);
                startActivity(drawerActivityIntent);
                break;
            }
        }
    }
}
