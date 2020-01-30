package com.fzain.akupintar;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "UniversitasDB";
    private static final String T_UNIVERSITAS = "tb_notes";

    private static final String KEY_ID = "id_universitas";
    private static final String KEY_NAMA = "nama_universitas";
    private static final String KEY_AKREDITAS = "akreditas";
    private static final String KEY_STATUS = "status";

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + T_UNIVERSITAS + " (" +
                KEY_ID + " INTEGER PRIMARY KEY, " +
                KEY_NAMA + " TEXT, " +
                KEY_AKREDITAS + " TEXT, " +
                KEY_STATUS + " TEXT" + ")";
        Log.d("Data", "onCreate: " + query);
        db.execSQL(query);

        query = "insert into tb_notes values(1,'Firman','sdfsdfdsfsxczxc','xcvxcvxcvxc')";
        db.execSQL(query);
        query = "insert into tb_notes values(2,'Vanli','sdfsdfdsfsxczxc','xcvxcvxcvxc')";
        db.execSQL(query);
        query = "insert into tb_notes values(3,'Adi','sdfsdfdsfsxczxc','xcvxcvxcvxc')";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion >= newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS " + T_UNIVERSITAS);

        onCreate(db);
    }



    public List<UniversitasModel> getNotes() {
        List<UniversitasModel> noteList = new ArrayList<>();
        String query = "SELECT * FROM " + T_UNIVERSITAS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String desc = cursor.getString(2);
                String date = cursor.getString(3);

                UniversitasModel universitasModel = new UniversitasModel(id, title, desc, date);

                noteList.add(universitasModel);
            } while (cursor.moveToNext());
        }

        return noteList;
    }


}
