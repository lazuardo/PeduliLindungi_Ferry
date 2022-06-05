package pedulilindungi.ferry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;


    public SliderAdapter(Context context){

        this.context = context;
    }

    //Arrays
    public int[] slide_images = {
            R.drawable.ic_maps,
            R.drawable.ic_camera,
            R.drawable.ic_camera2
    };

    public String[] slide_headings = {
            "Aktifkan Sekarang",
            "Akses Foto, Media & File",
            "Akses Kamera"
    };

    public String[] slide_descs = {
            "PeduliLindungi membutuhkan izin untuk mengaktifkan akses lokasi anda setiap waktu dibelakang layar untuk dapat melihat aktivitas dan memberikan informasi terkait paparan COVID-19 di sekitar Anda.",
            "Untuk mengganti foto profil yang diinginkan atau meyimpan tiket dan sertifikat vaksin COVID-19, PeduliLindungi membutuhkan akases penyimpanan ke dalam perangkat Anda.",
            "Untuk dapat masuk kedalam gedung atau tempat umum yang bekerjasama, PeduliLindungi membutuhkan akses kamera Anda untuk memindai QR Code pada gedung/tenant Secara langsung."
    };

    @Override
    public int getCount() {
        return slide_headings.length;

    }

    @Override
    public boolean isViewFromObject(View view, Object o) {

        return view == (ConstraintLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_headings);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }

}
