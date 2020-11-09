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

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import butterknife.ButterKnife;

public class SupportActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        ButterKnife.bind(this);

        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
        Objects.requireNonNull(getSupportActionBar()).setTitle("Downline");
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
                        startActivity(new Intent(SupportActivity.this,DashboardActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.profile:
                        startActivity(new Intent(SupportActivity.this,ProfileActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.add_member:
                        startActivity(new Intent(SupportActivity.this,AddMemberActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.downline:
                        startActivity(new Intent(SupportActivity.this,DownLineActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.wallet:
                        startActivity(new Intent(SupportActivity.this,WalletActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.about_us:
                        startActivity(new Intent(SupportActivity.this,AboutUsActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.contact_us:
                        startActivity(new Intent(SupportActivity.this,ContactUsActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.support:
                        startActivity(new Intent(SupportActivity.this,SupportActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);break;
                    case R.id.logout:
                        AlertDialog.Builder builder = new AlertDialog.Builder(SupportActivity.this);
                        builder.setTitle("Are You sure, You want to Logout");
                        builder.setPositiveButton("YES",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        startActivity(new Intent(SupportActivity.this,MainActivity.class));
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(t.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

}