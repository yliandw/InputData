package com.unpam.katalog.activity.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.unpam.katalog.activity.R;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static final String url = "http://192.168.205.7/Catalog/insert.php";
    EditText tkode, tjudul, tpengarang;
    Button insert, view;
    TextView tket;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tkode = findViewById(R.id.id_kode);
        tjudul = findViewById(R.id.id_judul);
        tpengarang = findViewById(R.id.id_pengarang);
        insert = findViewById(R.id.btnInsert);
        view = findViewById(R.id.btnView);
        tket = findViewById(R.id.tv_ket);
        DB = new DBHelper(this);

                insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kode_bukti = tkode.getText().toString();
                String judul = tjudul.getText().toString();
                String pengarang = tpengarang.getText().toString();

                Boolean checkinsertdata = DB.insertdata(kode_bukti, judul, pengarang);
                if(  checkinsertdata)
                    Toast.makeText(MainActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Data Gagal Dimasukan", Toast.LENGTH_SHORT).show();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                tket.setText(response);

                            }
                            // Display the first 500 characters of the response string.
                            //textView.setText("Response is: " + response.substring(0,500));

                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tket.setText("Error");
                    }
                })
                    {

                        @Override
                        protected Map<String, String> getParams () throws AuthFailureError {
                        // Posting parameters ke post url
                        Map<String, String> params = new HashMap<String, String>();


                        params.put("kode_bukti", kode_bukti);
                        params.put("judul", judul);
                        params.put("pengarang", pengarang);

                        return params;
                    }
                };

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                queue.add(stringRequest);
            }

            {

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Cursor res = DB.getdata();
                        if (res.getCount() == 0) {
                            Toast.makeText(MainActivity.this, "Kosong", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        StringBuffer a = new StringBuffer();
                        while (res.moveToNext()) {
                            a.append("Kode bukti   : " + res.getString(0) + "\n");
                            a.append("Judul            : " + res.getString(1) + "\n");
                            a.append("Pengarang   : " + res.getString(2) + "\n\n");


                        }

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setCancelable(true);
                        builder.setTitle("ListView");
                        builder.setMessage(a.toString());
                        builder.show();
                    }
                });
            }
        });
    }
}
