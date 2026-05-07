package com.example.projectexpo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        drawerLayout = findViewById(R.id.main);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("C.U. Shah Polytechnic");
        }

        // ================= ABOUT WEBVIEW =================
        WebView aboutWeb = findViewById(R.id.aboutWebView);
        aboutWeb.getSettings().setJavaScriptEnabled(false);
        aboutWeb.getSettings().setDefaultTextEncodingName("utf-8");
        aboutWeb.setNestedScrollingEnabled(false);

        String aboutHtml =
                "<html><body style='text-align:justify; font-size:14px; color:#000000; line-height:1.6;'>" +
                        "Established in June 1984, C U Shah Government Polytechnic, Wadhwan City, is a premier institute dedicated to providing high-quality education, research, and training in various fields of engineering and technology. Named after Sheth Shri C U Shah, the institute is affiliated with Gujarat Technological University (GTU), Ahmedabad, and is administrated by the Department of Technical Education, Gujarat State, Gandhinagar.<br><br>" +
                        "Our campus is strategically located near the GIDC and adjacent to Boda Talav in Wadhwan City, Surendranagar. Spread across a well-planned campus, we offer state-of-the-art facilities, including buildings for various departments, administrative offices, hostels, and residences for the Principal, rector, and wardens.<br><br>" +
                        "At C U Shah Government Polytechnic, we are committed to nurturing the next generation of engineers through a blend of academic rigor and hands-on experience, ensuring our students are well-equipped to meet the challenges of the dynamic field of engineering and technology." +
                        "</body></html>";

        aboutWeb.loadDataWithBaseURL(null, aboutHtml, "text/html", "UTF-8", null);

        // ================= PRINCIPAL MESSAGE WEBVIEW =================
        WebView sectionWeb = findViewById(R.id.sectionDescriptionWeb);
        sectionWeb.getSettings().setJavaScriptEnabled(false);
        sectionWeb.getSettings().setDefaultTextEncodingName("utf-8");
        sectionWeb.setNestedScrollingEnabled(false);

        String principalHtml =
                "<html><head>" +
                        "<style>" +
                        "body { text-align: justify; font-size: 14px; color: #000000; line-height: 1.6; }" +
                        "</style>" +
                        "</head><body>" +

                        "Welcome to C U Shah Government Polytechnic, Wadhwan City.<br><br>" +
                        "Since our establishment in 1984, we have been dedicated to the mission of delivering top-tier education, fostering innovation, and providing hands-on training in various engineering and technology disciplines. As an institution affiliated with Gujarat Technological University and under the administration of the Department of Technical Education, Gujarat State, we hold ourselves to the highest standards of academic excellence and integrity.<br><br>" +
                        "Our goal is not only to impart technical knowledge but also to nurture our students’ overall development, preparing them to excel in their professional careers and contribute positively to society.<br><br>" +
                        "Warm regards,<br><br>" +
                        "<b>- Dr. K. P. SHAH</b><br>" +
                        "I/C Principal, C U Shah Polytechnic" +

                        "</body></html>";

        sectionWeb.loadDataWithBaseURL(null, principalHtml, "text/html", "UTF-8", null);

        // ================= FIREBASE USER =================
        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        View headerView = navigationView.getHeaderView(0);
        TextView tvUserName = headerView.findViewById(R.id.tvUserName);
        TextView tvUserEmail = headerView.findViewById(R.id.tvUserEmail);

        if (currentUser != null && !currentUser.isAnonymous()) {
            tvUserName.setText(
                    currentUser.getDisplayName() != null ?
                            currentUser.getDisplayName() : "User");
            tvUserEmail.setText(currentUser.getEmail());

            navigationView.getMenu().findItem(R.id.nav_login).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_register).setVisible(false);

        } else {
            tvUserName.setText("Guest User");
            tvUserEmail.setText("Please Login / Register");

            navigationView.getMenu().findItem(R.id.nav_profile).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_logout).setVisible(false);
        }

        // ================= DRAWER TOGGLE =================
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.open, R.string.close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this::handleNavigationItem);
    }

    private boolean handleNavigationItem(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (currentUser != null && !currentUser.isAnonymous()) {

            if (id == R.id.nav_profile) {
                startActivity(new Intent(this, ProfileActivity.class));

            } else if (id == R.id.nav_logout) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(this, WelcomeActivity.class));
                finish();

            } else if (id == R.id.nav_developer) {
                startActivity(new Intent(this, Aboutas.class));
            }
            else if (id == R.id.nav_feedback) {
                startActivity(new Intent(this,feedbackActivity.class));
            }

        } else {

            if (id == R.id.nav_login) {
                startActivity(new Intent(this, LoginActivity.class));

            } else if (id == R.id.nav_register) {
                startActivity(new Intent(this, RegisterActivity.class));

            } else if (id == R.id.nav_developer) {
                startActivity(new Intent(this, Aboutas.class));
            }
            else if (id == R.id.nav_admin) {
                startActivity(new Intent(this, Admission.class));
            }
            else if (id == R.id.nav_feedback) {
                startActivity(new Intent(this, feedbackActivity.class));
            }

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @SuppressLint("GestureBackNavigation")
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
