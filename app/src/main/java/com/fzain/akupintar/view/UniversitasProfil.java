package com.fzain.akupintar.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fzain.akupintar.R;

public class UniversitasProfil extends AppCompatActivity {

    private Context context;
    ImageView id;
    TextView nama, akreditas, status, jenis, alamat, kota, provinsi, website, singkat;
    Button maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universitas_profil);

        id = (ImageView)findViewById(R.id.logo);
        nama = (TextView)findViewById(R.id.nama);
        akreditas = (TextView)findViewById(R.id.akreditas);
        status = (TextView)findViewById(R.id.status);
        jenis = (TextView)findViewById(R.id.jenis);
        alamat = (TextView)findViewById(R.id.alamat);
        kota = (TextView)findViewById(R.id.kota);
        provinsi = (TextView)findViewById(R.id.provinsi);
        website = (TextView)findViewById(R.id.website);
        singkat = (TextView)findViewById(R.id.singkat);
        maps = (Button)findViewById(R.id.maps);

        Intent i = getIntent();
        String a = i.getStringExtra("id");
        String b = i.getStringExtra("nama");
        String c = i.getStringExtra("akreditas");
        String d = i.getStringExtra("status");
        String e = i.getStringExtra("jenis");
        String f = i.getStringExtra("alamat");
        String g = i.getStringExtra("kota");
        String h = i.getStringExtra("provinsi");
        String ii = i.getStringExtra("website");
        String j = i.getStringExtra("singkat");

        //String a = "1";
        int ip = Integer.parseInt(a);
        final Integer[] kampus = {R.drawable.itb, R.drawable.ugm, R.drawable.ipb, R.drawable.its, R.drawable.ui, R.drawable.undip, R.drawable.unair, R.drawable.unhas, R.drawable.ub, R.drawable.unpad,};


        id.setImageResource(kampus[ip-1]);
        nama.setText(b);
        akreditas.setText(c);
        status.setText(d);
        jenis.setText(e);
        alamat.setText(f);
        kota.setText(g);
        provinsi.setText(h);
        website.setText(ii);
        singkat.setText(j);



        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:-6.365695,106.827284");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

    }

}




