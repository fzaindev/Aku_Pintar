package com.fzain.akupintar.view;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fzain.akupintar.Adapter.SliderImageAdapter;
import com.fzain.akupintar.Adapter.UniversitasAdapter;
import com.fzain.akupintar.Database;
import com.fzain.akupintar.Model.UniversitasModel;
import com.fzain.akupintar.R;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rvList;

    private Database db;
    private UniversitasAdapter adapter;
    private List<UniversitasModel> univer = new ArrayList<>();
    SliderView sliderMyuniv;
    TextView greetText;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Database(this);
        sliderMyuniv = findViewById(R.id.imageSlider);
        greetText = findViewById(R.id.greeting_text);

        rvList = findViewById(R.id.rv_univ);

        adapter = new UniversitasAdapter(this);
        rvList.setLayoutManager(new LinearLayoutManager(this));

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this, LinearLayoutManager.HORIZONTAL, false
        );
        rvList.setLayoutManager(layoutManager);
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.setAdapter(adapter);

        final SliderImageAdapter sliderImageAdapter = new SliderImageAdapter(this);
        sliderImageAdapter.setCount(4);
        sliderMyuniv.setSliderAdapter(sliderImageAdapter);
        sliderMyuniv.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderMyuniv.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderMyuniv.setIndicatorSelectedColor(Color.WHITE);
        sliderMyuniv.setIndicatorUnselectedColor(Color.GRAY);
        sliderMyuniv.startAutoCycle();
        sliderMyuniv.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                sliderMyuniv.setCurrentPagePosition(position);
            }
        });

        greeting();

    }

    private void greeting() {
        Calendar calendar = Calendar.getInstance();
        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 12) {
            greetText.setText(getString(R.string.salam_pagi));
        } else if (timeOfDay >= 12 && timeOfDay < 15) {
            greetText.setText(getString(R.string.salam_siang));
        } else if (timeOfDay >= 15 && timeOfDay < 18) {
            greetText.setText(getString(R.string.salam_sore));
        } else if (timeOfDay >= 18 && timeOfDay < 24) {
            greetText.setText(getString(R.string.salam_malam));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getUnivtast();
    }

    private void getUnivtast() {
        univer = db.getUniv();
        adapter.setUniver(univer);
    }
}
