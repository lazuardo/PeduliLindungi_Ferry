package pedulilindungi.ferry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView imgView = findViewById(R.id.btnBack);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Nationality.class));
            }
        });

        Button btnNext = findViewById(R.id.bt_subscribe);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, walkthroughActivity.class));
            }
        });

        String akun = getColoredSpanned("Belum Punya Akun PeduliLindungi?", "#000000");
        String daftar = getColoredSpanned("Daftar","#229BD8");

        TextView txtView = (TextView)findViewById(R.id.daftar);
        txtView.setText(Html.fromHtml(akun+" "+daftar));

    }

    private String getColoredSpanned(String text, String color) {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;
    }

}