package com.example.mlmsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class ProfileDetailsActivity extends AppCompatActivity {

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.title) TextView title;

    @BindView(R.id.linear1) LinearLayout linear1;
    @BindView(R.id.linear2) LinearLayout linear2;
    @BindView(R.id.linear3) LinearLayout linear3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);
        ButterKnife.bind(this);

        String Details = getIntent().getStringExtra("Details");
        title.setText(Details);

        linear1.setVisibility(View.VISIBLE);
        linear2.setVisibility(View.GONE);
        linear3.setVisibility(View.GONE);

        if(Details.equals("Account")){
            linear1.setVisibility(View.VISIBLE);
            linear2.setVisibility(View.GONE);
            linear3.setVisibility(View.GONE);
        }else if(Details.equals("Personal")){
            linear1.setVisibility(View.GONE);
            linear2.setVisibility(View.VISIBLE);
            linear3.setVisibility(View.GONE);
        }else if(Details.equals("Bank")){
            linear1.setVisibility(View.GONE);
            linear2.setVisibility(View.GONE);
            linear3.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.back)
    public void onClick(){
        finish();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}