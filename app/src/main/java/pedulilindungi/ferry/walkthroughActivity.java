package pedulilindungi.ferry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class walkthroughActivity extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private Button mNextBtn;
    private Button mBackBtn;
    private int mCurrentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);
        mSlideViewPager = (ViewPager)    findViewById(R.id.slideviewpager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotslayout);

        mNextBtn = (Button)findViewById(R.id.nextBtn);
        mBackBtn = (Button)findViewById(R.id.prevBtn);


        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);


        //check activity
        if(restorePrefData()){

            Intent homeActivity = new Intent(getApplicationContext(),homeActivity.class);
            startActivity(homeActivity);
            finish();

        }

        //OnClickListener Button
        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mSlideViewPager.getCurrentItem() + 1 < sliderAdapter.getCount()){
                    mSlideViewPager.setCurrentItem(mSlideViewPager.getCurrentItem() + 1);
                }else{
                    startActivity(new Intent(getApplicationContext(), homeActivity.class));
                    savePrefData();
                    finish();
                }
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });
    }

    private boolean restorePrefData() {

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        Boolean introOpenbefore = preferences.getBoolean("introOpen",false);
        return introOpenbefore;

    }

    private void savePrefData() {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("introOpen",true);
        editor.commit();
    }

    public void addDotsIndicator(int position){

        mDots = new TextView[3];
        mDotLayout.removeAllViews();
        for (int i = 0; i < mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override

        public void onPageScrolled(int i, float  v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);

            mCurrentPage = i;
            if(i == 0){

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText("Berikutnya");
                mBackBtn.setText("");
            }else if (i == mDots.length - 1) {
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("Berikutnya");
                mBackBtn.setText("Kembali");

            }else {

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("Berikutnya");
                mBackBtn.setText("Kembali");
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
