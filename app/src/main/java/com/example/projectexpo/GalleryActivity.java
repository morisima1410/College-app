package com.example.projectexpo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.projectexpo.Adapter.SliderAdapter;

public class GalleryActivity extends AppCompatActivity {

    ViewPager2 slider1, slider2, slider3, slider4;

    LinearLayout dotLayout1, dotLayout2, dotLayout3, dotLayout4;
    View[] dots1, dots2, dots3, dots4;

    Handler handler = new Handler(Looper.getMainLooper());

    // IMAGES
    int[] images1 = {R.drawable.img_15, R.drawable.img_12, R.drawable.img_13};
    int[] images2 = {R.drawable.img_17, R.drawable.img_18, R.drawable.img_19};
    int[] images3 = {R.drawable.img_20, R.drawable.img_21, R.drawable.img_22};
    int[] images4 = {R.drawable.img_23, R.drawable.img_24, R.drawable.img_25};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        // Sliders
        slider1 = findViewById(R.id.imageSlider1);
        slider2 = findViewById(R.id.imageSlider2);
        slider3 = findViewById(R.id.imageSlider3);
        slider4 = findViewById(R.id.imageSlider4);

        // Dot Layouts
        dotLayout1 = findViewById(R.id.dotLayout1);
        dotLayout2 = findViewById(R.id.dotLayout2);
        dotLayout3 = findViewById(R.id.dotLayout3);
        dotLayout4 = findViewById(R.id.dotLayout4);

        // Create dots dynamically
        dots1 = createDots(dotLayout1, images1.length);
        dots2 = createDots(dotLayout2, images2.length);
        dots3 = createDots(dotLayout3, images3.length);
        dots4 = createDots(dotLayout4, images4.length);

        // Setup sliders
        setupSlider(slider1, dots1, images1);
        setupSlider(slider2, dots2, images2);
        setupSlider(slider3, dots3, images3);
        setupSlider(slider4, dots4, images4);

        // WebViews
        loadWebView(R.id.aboutWebView2, getBharatVikasHtml());
        loadWebView(R.id.aboutWebView3, getEnvironmentHtml());
        loadWebView(R.id.aboutWebView4, getProjectExpoHtml());
        loadWebView(R.id.aboutWebView5, getPlacementHtml());
    }

    // 🔥 CREATE DOTS DYNAMICALLY
    private View[] createDots(LinearLayout layout, int count) {
        View[] dots = new View[count];
        layout.removeAllViews();

        for (int i = 0; i < count; i++) {
            dots[i] = new View(this);
            dots[i].setBackgroundResource(R.drawable.dot_gray);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            params.setMargins(8, 0, 8, 0);

            dots[i].setLayoutParams(params);
            layout.addView(dots[i]);
        }
        return dots;
    }

    // ---------------- SLIDER ----------------
    private void setupSlider(ViewPager2 viewPager, View[] dots, int[] images) {
        SliderAdapter adapter = new SliderAdapter(images, this);
        viewPager.setAdapter(adapter);

        updateDots(dots, 0);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                updateDots(dots, position);
            }
        });

        startAutoSlide(viewPager, images.length);
    }

    private void updateDots(View[] dots, int position) {
        for (int i = 0; i < dots.length; i++) {
            dots[i].setBackgroundResource(
                    i == position ? R.drawable.dot_green : R.drawable.dot_gray
            );
        }
    }

    private void startAutoSlide(ViewPager2 viewPager, int size) {
        Runnable runnable = new Runnable() {
            boolean reverse = false;

            @Override
            public void run() {
                int current = viewPager.getCurrentItem();

                if (!reverse) {
                    if (current < size - 1)
                        viewPager.setCurrentItem(current + 1, true);
                    else {
                        reverse = true;
                        viewPager.setCurrentItem(current - 1, true);
                    }
                } else {
                    if (current > 0)
                        viewPager.setCurrentItem(current - 1, true);
                    else {
                        reverse = false;
                        viewPager.setCurrentItem(current + 1, true);
                    }
                }
                handler.postDelayed(this, 2000);
            }
        };
        handler.postDelayed(runnable, 2000);
    }

    // ---------------- WEBVIEW ----------------
    @SuppressLint("SetJavaScriptEnabled")
    private void loadWebView(int id, String html) {
        WebView webView = findViewById(id);
        webView.getSettings().setJavaScriptEnabled(false);
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        webView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
    }

    // ---------------- HTML ----------------
    private String getBharatVikasHtml() {
        return "<html><body style='text-align:justify;font-size:14px;line-height:1.6;'>" +
                "The Bharat Vikas Pledge was organized to encourage students to develop a sense of responsibility towards the nation. " +
                "During this event, students took an oath to work sincerely for the progress and development of India. " +
                "They pledged to perform their duties honestly, respect the Constitution and national values, and promote unity and harmony among all citizens. " +
                "The event inspired students to become disciplined, self-reliant, and socially responsible individuals who contribute positively to society." +
                "</body></html>";
    }

    private String getEnvironmentHtml() {
        return "<html><body style='text-align:justify;font-size:14px;line-height:1.6;'>" +
                "World Environment Day was celebrated to create awareness about environmental protection and sustainability. " +
                "Students actively participated in activities such as tree plantation, cleanliness drives, and awareness campaigns. " +
                "They pledged to reduce plastic usage, save water and electricity, and adopt eco-friendly practices in their daily lives. " +
                "The event highlighted the importance of protecting nature and encouraged everyone to contribute towards a greener future." +
                "</body></html>";
    }

    private String getProjectExpoHtml() {
        return "<html><body style='text-align:justify;font-size:14px;line-height:1.6;'>" +
                "The Project Expo 2025 was organized to showcase the innovative ideas and technical skills of students. " +
                "Students presented their projects based on real-world problems and practical solutions. " +
                "The event provided a platform for creativity, teamwork, and knowledge sharing among students. " +
                "It also helped in improving confidence and preparing students for industry-level challenges." +
                "</body></html>";
    }

    private String getPlacementHtml() {
        return "<html><body style='text-align:justify;font-size:14px;line-height:1.6;'>" +
                "The Placement Fair 2025 was conducted to connect students with various companies and job opportunities. " +
                "Many reputed organizations participated in the event and interacted with students for recruitment. " +
                "Students got the opportunity to showcase their skills and knowledge through interviews and discussions. " +
                "This event helped bridge the gap between academic learning and industry requirements." +
                "</body></html>";
    }
}