package com.example.mlmsoftware;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardActivity extends AppCompatActivity {

    @BindView(R.id.profile_id) TextView profile_id;
    @BindView(R.id.name) TextView name;
    @BindView(R.id.email) TextView email;
    @BindView(R.id.sponsor_id) TextView sponsor_id;

    @BindView(R.id.account_card) CardView account_card;
    @BindView(R.id.downline_card) CardView downline_card;
    @BindView(R.id.add_member_card) CardView add_member_card;
    @BindView(R.id.wallet_card) CardView wallet_card;
    @BindView(R.id.aboutus_card) CardView aboutus_card;
    @BindView(R.id.contactus_card) CardView contactus_card;

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    SwipeRefreshLayout swipeRefreshLayout;
    public static int confirmation = 0;
    public static boolean isRefreshed;
    private long backPressTime;
    private Toast backToast;


    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
        Objects.requireNonNull(getSupportActionBar()).setTitle("Green Choice");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        profile_id.setText("Profile Id: 0352");
        name.setText("Name: Charan");
        email.setText("Email: kosuricharan@gmail.com");
        sponsor_id.setText("Sponsor Id: 1234");


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
                        startActivity(new Intent(DashboardActivity.this,DashboardActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.profile:
                        startActivity(new Intent(DashboardActivity.this,ProfileActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.add_member:
                        startActivity(new Intent(DashboardActivity.this,AddMemberActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.downline:
                        startActivity(new Intent(DashboardActivity.this,DownLineActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.wallet:
                        startActivity(new Intent(DashboardActivity.this,WalletActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.about_us:
                        startActivity(new Intent(DashboardActivity.this,AboutUsActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.contact_us:
                        startActivity(new Intent(DashboardActivity.this,ContactUsActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.support:
                        startActivity(new Intent(DashboardActivity.this,SupportActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.logout:
                        AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
                        builder.setTitle("Are You sure, You want to Logout");
                        builder.setPositiveButton("YES",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        startActivity(new Intent(DashboardActivity.this,MainActivity.class));
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

    @OnClick(R.id.account_card)
    public void onAccount(){
        startActivity(new Intent(DashboardActivity.this,ProfileActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.downline_card)
    public void onDownline(){
        startActivity(new Intent(DashboardActivity.this,DownLineActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.add_member_card)
    public void onAddMember(){
        startActivity(new Intent(DashboardActivity.this,AddMemberActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.wallet_card)
    public void onWallet(){
        startActivity(new Intent(DashboardActivity.this,WalletActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.aboutus_card)
    public void onAboutUs(){
        startActivity(new Intent(DashboardActivity.this,AboutUsActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.contactus_card)
    public void onContactUs(){
        startActivity(new Intent(DashboardActivity.this,ContactUsActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(t.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if (backPressTime + 800 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressTime = System.currentTimeMillis();
    }

}