package com.rotimijohnson.cityapp.userBoard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.rotimijohnson.cityapp.R;
import com.rotimijohnson.cityapp.adapter.homeAdapter.CategoriesAdapter;
import com.rotimijohnson.cityapp.adapter.homeAdapter.FeaturedAdapter;
import com.rotimijohnson.cityapp.adapter.homeAdapter.FeaturedCategoriesHelper;
import com.rotimijohnson.cityapp.adapter.homeAdapter.FeaturedHelper;
import com.rotimijohnson.cityapp.adapter.homeAdapter.MostViewedAdapter;
import com.rotimijohnson.cityapp.userBoard.LoginSignup.RetailerStartUpScreen;

import java.util.ArrayList;

public class UserBoardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView featuredRecycler, most_view_Recycler, categories_Recycler;
    FeaturedAdapter adapter;
    MostViewedAdapter mostViewedAdapter;
    CategoriesAdapter categoriesAdapter;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ImageView imageView;
    LinearLayout contentView;

    static final float END_SCALE = 0.7f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_board);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

        featuredRecycler = findViewById(R.id.featured_recycler);
        most_view_Recycler = findViewById(R.id.most_viewed_recycler);
        categories_Recycler = findViewById(R.id.categories_recycler);

        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView.setNavigationItemSelectedListener(this);

        navigationMethod();
        featuredRecyclerMethod();
        mostViewedRecyclerMethod();
        categoriesRecyclerMethod();
    }

    private void navigationMethod() {
        navigationView.bringToFront();
        navigationView.setCheckedItem(R.id.nav_home);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);


                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_categories:
                Intent intent = new Intent(getApplicationContext(), CategoriesActivity.class);
                startActivity(intent);
                break;
            default:
                return true;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void featuredRecyclerMethod() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelper> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelper(R.drawable.darksiders, "darksiders", "fcvcvcvcvcbcnbckbvckbvxjchxbnbcxnbvvcnbvcmvncbvcbcvcncb"));
        featuredLocations.add(new FeaturedHelper(R.drawable.assassins, "assassins", "sdsfsfdvdvdfdvdvdvdcvcvcvc"));
        featuredLocations.add(new FeaturedHelper(R.drawable.battlefield, "battlefield", "qwqwewererfxcxvvfrfrvvffdfdvdbfbfxzdsds"));

        adapter = new FeaturedAdapter(featuredLocations);

        featuredRecycler.setAdapter(adapter);
    }

    private void mostViewedRecyclerMethod() {
        most_view_Recycler.setHasFixedSize(true);
        most_view_Recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelper> MostViewedHelpers = new ArrayList<>();
        MostViewedHelpers.add(new FeaturedHelper(R.drawable.darksiders, "darksiders", "fcvcvcvcvcbcnbckbvckbvxjchxbnbcxnbvvcnbvcmvncbvcbcvcncb"));
        MostViewedHelpers.add(new FeaturedHelper(R.drawable.assassins, "assassins", "sdsfsfdvdvdfdvdvdvdcvcvcvc"));
        MostViewedHelpers.add(new FeaturedHelper(R.drawable.battlefield, "battlefield", "qwqwewererfxcxvvfrfrvvffdfdvdbfbfxzdsds"));

        mostViewedAdapter = new MostViewedAdapter(MostViewedHelpers);
        most_view_Recycler.setAdapter(mostViewedAdapter);
    }

    private void categoriesRecyclerMethod() {
        categories_Recycler.setHasFixedSize(true);
        categories_Recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedCategoriesHelper> categoriesHelpers = new ArrayList<>();
        categoriesHelpers.add(new FeaturedCategoriesHelper(R.drawable.food, "Shops"));
        categoriesHelpers.add(new FeaturedCategoriesHelper(R.drawable.food, "Restaurants"));
        categoriesHelpers.add(new FeaturedCategoriesHelper(R.drawable.food, "Hospital"));

        categoriesAdapter = new CategoriesAdapter(categoriesHelpers);
        categories_Recycler.setAdapter(categoriesAdapter);

    }


    //    Normal Functions
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void callRetailerScreens(View view){
       startActivity(new Intent(getApplicationContext(), RetailerStartUpScreen.class));
    }
}
