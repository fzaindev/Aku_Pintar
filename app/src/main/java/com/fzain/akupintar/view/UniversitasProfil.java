package com.fzain.akupintar.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fzain.akupintar.R;

public class UniversitasProfil extends AppCompatActivity {

    ImageView id;
    TextView nama, akreditas, status, jenis, alamat, kota, provinsi, website, singkat;

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

        Intent i = getIntent();

        String b = i.getStringExtra("nama");
        String c = i.getStringExtra("akreditas");
        String d = i.getStringExtra("status");
        String e = i.getStringExtra("jenis");
        String f = i.getStringExtra("alamat");
        String g = i.getStringExtra("kota");
        String h = i.getStringExtra("provinsi");
        String ii = i.getStringExtra("website");
        String j = i.getStringExtra("singkat");

        id.setImageResource(R.drawable.soekarno);
        nama.setText(b);
        akreditas.setText(c);
        status.setText(d);
        jenis.setText(e);
        alamat.setText(f);
        kota.setText(g);
        provinsi.setText(h);
        website.setText(ii);
        singkat.setText(j);

    }
}