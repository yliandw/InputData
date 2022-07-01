//package com.unpam.katalog.activity.kelas;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//public class Database extends SQLiteOpenHelper {
//
//    private static final int DATABASE_VERSION = 1;
//
//    //Nama Database Local
//    private static final String DATABASE_NAME = "catalog";
//
//    //Nama Tabel Local
//    private static final String TABLE_NAME = "buku";
//
//    //Nama Kolom Local
//
//    private static final String KODE_BUKTI = "kode_bukti";
//    private static final String JUDUL = "judul";
//    private static final String PENGARANG = "pengarang";
//
//
//    public Database(Context context) {
//
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + KODE_BUKTI + " TEXT," + JUDUL + " TEXT," + PENGARANG + " TEXT " + ")");
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
//    }
//
//    //Prosedure Tambah Data
//    public boolean TambahData(String kode_bukti, String judul, String pengarang) {
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(KODE_BUKTI, kode_bukti);
//        contentValues.put(JUDUL, judul);
//        contentValues.put(PENGARANG, pengarang);
//        long result = db.insert(TABLE_NAME, null, contentValues);
//        if (result == -1)
//            return false;
//        else
//            return true;
//    }
//
//
//    //Prosedure Tampil Data RecyclerView
//    public Cursor TampilDataBuku() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        String[] columns = {KODE_BUKTI, JUDUL, PENGARANG};
//        return db.query(TABLE_NAME, columns, null, null, null, null, null);
//    }
//}
