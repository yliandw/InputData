//package com.unpam.katalog.activity.activity;
//
//import android.app.ProgressDialog;
//import android.database.Cursor;
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.DefaultItemAnimator;
//import androidx.recyclerview.widget.DividerItemDecoration;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.unpam.katalog.activity.R;
//import com.unpam.katalog.activity.adapter.DaftarAdapter;
//import com.unpam.katalog.activity.kelas.Buku;
//import com.unpam.katalog.activity.kelas.Database;
//
//import java.util.ArrayList;
//
//public class DaftarActivity extends AppCompatActivity {
//
//    private Database db;
//
//    private RecyclerView recyclerView;
//
//    private ArrayList<Buku> bukuArrayList;
//
//    private DaftarAdapter mAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_daftar);
//
//        setTitle("LIST VIEW");
//
//        final ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Tunggu sebentar...");
//        progressDialog.show();
//
//        db = new Database(this);
//
//        recyclerView = findViewById(R.id.rv_view);
//
//        bukuArrayList = new ArrayList<>();
//
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//
//        recyclerView.setLayoutManager(mLayoutManager);
//
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//
//        recyclerView.setAdapter(mAdapter);
//
//        recyclerView.setNestedScrollingEnabled(false);
//
//        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
//
//        mAdapter = new DaftarAdapter(this, bukuArrayList);
//        tampilData();
//
//        progressDialog.dismiss();
//
//    }
//
//    private void tampilData() {
//
//        //Untuk clear data list
//        bukuArrayList.clear();
//
//        Cursor c = db.TampilDataBuku();
//
//        while (c.moveToNext())
//        {
//
//            String kode_bukti = c.getString(0);
//
//            String judul = c.getString(1);
//
//            String pengarang = c.getString(2);
//
//
//            Buku p = new Buku(kode_bukti, judul, pengarang);
//
//            bukuArrayList.add(p);
//        }
//
//        if(!(bukuArrayList.size() < 1))
//        {
//            recyclerView.setAdapter(mAdapter);
//        }
//
//
//    }
//}