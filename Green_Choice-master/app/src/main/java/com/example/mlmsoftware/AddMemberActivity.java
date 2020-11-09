package com.example.mlmsoftware;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddMemberActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @BindView(R.id.linear1) LinearLayout linear1;
    @BindView(R.id.linear2) LinearLayout linear2;
    @BindView(R.id.linear3) LinearLayout linear3;
    @BindView(R.id.save1) Button save1;
    @BindView(R.id.save2) Button save2;
    @BindView(R.id.save3) Button save3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        ButterKnife.bind(this);

        linear1.setVisibility(View.VISIBLE);
        linear2.setVisibility(View.GONE);
        linear3.setVisibility(View.GONE);

        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
        Objects.requireNonNull(getSupportActionBar()).setTitle("Add New Member");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dl = (DrawerLayout)findViewById(R.id.dashboard);
        t = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        dl.addDrawerListener(t);
        t.syncState();

        nv = (NavigationView)findViewById(R.id.navigation_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.home:
                        startActivity(new Intent(AddMemberActivity.this,DashboardActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.profile:
                        startActivity(new Intent(AddMemberActivity.this,ProfileActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.add_member:
                        startActivity(new Intent(AddMemberActivity.this,AddMemberActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.downline:
                        startActivity(new Intent(AddMemberActivity.this,DownLineActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.wallet:
                        startActivity(new Intent(AddMemberActivity.this,WalletActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.about_us:
                        startActivity(new Intent(AddMemberActivity.this,AboutUsActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.contact_us:
                        startActivity(new Intent(AddMemberActivity.this,ContactUsActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.support:
                        startActivity(new Intent(AddMemberActivity.this,SupportActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.logout:
                        AlertDialog.Builder builder = new AlertDialog.Builder(AddMemberActivity.this);
                        builder.setTitle("Are You sure, You want to Logout");
                        builder.setPositiveButton("YES",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        startActivity(new Intent(AddMemberActivity.this,MainActivity.class));
                                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                                    }
                                });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        builder.setCancelable(false);
                        builder.show();
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });

        View navView =  nv.inflateHeaderView(R.layout.nav_header);
    }

    @OnClick(R.id.save1)
    public void Save1(){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right);
        linear1.setVisibility(View.GONE);
        linear2.setVisibility(View.VISIBLE);
        linear2.setAnimation(animation);
        linear3.setVisibility(View.GONE);
    }
    @OnClick(R.id.save2)
    public void Save2(){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right);
        linear1.setVisibility(View.GONE);
        linear2.setVisibility(View.GONE);
        linear3.setAnimation(animation);
        linear3.setVisibility(View.VISIBLE);
    }
    @OnClick(R.id.save3)
    public void Save3(){
            startActivity(new Intent(AddMemberActivity.this,DashboardActivity.class));
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(t.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}