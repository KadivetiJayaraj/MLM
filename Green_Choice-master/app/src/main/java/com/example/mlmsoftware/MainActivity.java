package com.example.mlmsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.register) TextView register;
    @BindView(R.id.signin)
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.register)
    public void onRegister(){
        startActivity(new Intent(MainActivity.this, SignupActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.signin)
    public void onLogin(){
        startActivity(new Intent(MainActivity.this, DashboardActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}