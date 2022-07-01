//package com.unpam.katalog.activity.adapter;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.unpam.katalog.activity.R;
//import com.unpam.katalog.activity.kelas.Buku;
//
//import java.util.List;
//
//public class DaftarAdapter extends RecyclerView.Adapter<DaftarAdapter.MyViewHolder> {
//
//    private List<Buku> bukuList;
//
//    private Context mContext;
//
//    public static class MyViewHolder extends RecyclerView.ViewHolder {
//
//        //Ini adalah item dari item_daftar
//        public TextView kode_bukti, judul, pengarang, status;
//
//        public MyViewHolder(View view) {
//
//            super(view);
//
//            //Ini adalah item dari item_daftar
//
//            kode_bukti = view.findViewById(R.id.tv_kodebukti);
//
//            judul = view.findViewById(R.id.tv_judul_item_daftar);
//
//            pengarang = view.findViewById(R.id.tv_pengarang_item_daftar);
//
//        }
//    }
//
//    public DaftarAdapter(Context context, List<Buku> bukuList) {
//
//        mContext = context;
//
//        this.bukuList = bukuList;
//    }
//
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daftar, parent, false);
//
//        return new MyViewHolder(itemView);
//    }
//
//    @SuppressLint("SetTextI18n")
//    @Override
//    public void onBindViewHolder(final MyViewHolder holder, final int position) {
//
//        final Buku buku = bukuList.get(position);
//
//
//        holder.kode_bukti.setText(buku.getKode_bukti());
//
//        holder.judul.setText(buku.getJudul());
//
//        holder.pengarang.setText(buku.getPengarang());
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return bukuList.size();
//    }
//}
//
