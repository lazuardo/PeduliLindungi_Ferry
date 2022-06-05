package pedulilindungi.ferry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class homeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView imgView = findViewById(R.id.ic_img6);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(homeActivity.this, "Coming Soon By Ferry F", Toast.LENGTH_LONG).show();
            }
        });
        ImageView imgView2 = findViewById(R.id.ic_img7);
        imgView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(homeActivity.this, "Coming Soon By Ferry F", Toast.LENGTH_LONG).show();
            }
        });

        ImageView imgView3 = findViewById(R.id.ic_img8);
        imgView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(homeActivity.this, "Coming Soon By Ferry F", Toast.LENGTH_LONG).show();
            }
        });
    }
}