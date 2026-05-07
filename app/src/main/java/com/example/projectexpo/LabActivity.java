package com.example.projectexpo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.projectexpo.Adapter.SliderAdapter;

public class LabActivity extends AppCompatActivity {

    ViewPager2 slider1;
    LinearLayout dotLayout1;
    View[] dots1;

    Handler handler = new Handler(Looper.getMainLooper());

    int[] images = {
            R.drawable.img_26,
            R.drawable.img_27,
            R.drawable.img_28,
            R.drawable.img_29,
            R.drawable.img_30,
            R.drawable.img_31,
            R.drawable.img_32,
            R.drawable.img_33,
            R.drawable.img_34,
            R.drawable.img_35

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab);

        slider1 = findViewById(R.id.imageSlider1_11);
        dotLayout1 = findViewById(R.id.dotLayout1);

        createDots(); // 🔥 dynamic dots
        setupSlider(slider1);

        WebView webView = findViewById(R.id.aboutWebView1);
        webView.getSettings().setJavaScriptEnabled(false);
        webView.getSettings().setDefaultTextEncodingName("utf-8");

        String htmlText =
                "<html><body style='text-align:justify; font-size:14px; color:#000000; line-height:1.6;'>" +
                        "C. U. Shah Government Polytechnic, Surendranagar offers quality technical education through " +
                        "its well-established departments including Computer Engineering, Civil Engineering, Mechanical Engineering," +
                        " CADD/CAM, Automobile Engineering, and Electrical Engineering. Each department is supported by modern " +
                        "laboratories and workshops that focus on practical learning and skill development. " +
                        "The Computer Department has well-equipped computer labs with updated software and networking facilities. " +
                        "Civil Engineering labs provide hands-on training in surveying, material testing, and construction practices. Mechanical and Automobile workshops are designed for machining, fitting, welding, engine systems, and maintenance work. The CADD/CAM department trains students in computer-aided design and manufacturing using advanced tools and software. Electrical labs and workshops offer practical exposure to wiring, machines, control systems, and power equipment. These facilities help students gain real-world experience, technical confidence, and industry-ready skills." +
                        "</body></html>";

        webView.loadDataWithBaseURL(null, htmlText, "text/html", "UTF-8", null);
    }

    // 🔥 Create dots dynamically
    private void createDots() {
        dots1 = new View[images.length];
        dotLayout1.removeAllViews();

        for (int i = 0; i < images.length; i++) {
            dots1[i] = new View(this);
            dots1[i].setBackgroundResource(R.drawable.dot_gray);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            params.setMargins(8, 0, 8, 0);

            dots1[i].setLayoutParams(params);
            dotLayout1.addView(dots1[i]);
        }

        updateDots(0);
    }

    private void setupSlider(ViewPager2 viewPager) {
        SliderAdapter adapter = new SliderAdapter(images, this);
        viewPager.setAdapter(adapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                updateDots(position);
            }
        });

        startAutoSlide(viewPager);
    }

    private void updateDots(int position) {
        for (int i = 0; i < dots1.length; i++) {
            dots1[i].setBackgroundResource(
                    i == position ? R.drawable.dot_green : R.drawable.dot_gray
            );
        }
    }

    private void startAutoSlide(ViewPager2 viewPager) {
        Runnable runnable = new Runnable() {
            boolean reverse = false;

            @Override
            public void run() {
                int current = viewPager.getCurrentItem();

                if (!reverse) {
                    if (current < images.length - 1)
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
}