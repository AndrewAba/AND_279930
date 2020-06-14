package com.example.and_279930.View;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import com.example.and_279930.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private TextView loggedUsername;
    private ImageView loggedImg;
    private TextView loggedMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.layout_drawer);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        loggedUsername = headerView.findViewById(R.id.header_username);
        loggedImg = headerView.findViewById(R.id.header_img);
        loggedMail = headerView.findViewById(R.id.header_email);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount != null)
        {
            loggedUsername.setText(signInAccount.getDisplayName());
            loggedMail.setText(signInAccount.getEmail());
            loggedImg.setImageURI(signInAccount.getPhotoUrl());
        }

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DiceRollerFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_dice_roll);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_dice_roll:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DiceRollerFragment()).commit();
                break;

            case R.id.nav_chars:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CharactersFragment()).commit();
                break;

            case R.id.nav_add_char:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CreateCharFragment()).commit();
                break;

            case  R.id.nav_web_char_sheets:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WebFragment()).commit();

            case R.id.nav_sign_out:
                FirebaseApp.initializeApp(this);
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
