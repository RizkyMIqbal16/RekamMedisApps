package com.example.rekammedisapps.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rekammedisapps.Activity.DetailRekamMedisActivity;
import com.example.rekammedisapps.Model.RekamMedisModel;
import com.example.rekammedisapps.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListRekamMedisAdapter extends RecyclerView.Adapter<ListRekamMedisAdapter.ViewHolder> {

    private Activity mActivity;
    private ArrayList<RekamMedisModel> rekamMedisModelArrayList;

    public ListRekamMedisAdapter(Activity mActivity, ArrayList<RekamMedisModel> rekamMedisModelArrayList) {
        this.mActivity = mActivity;
        this.rekamMedisModelArrayList = rekamMedisModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_list_rekammedis, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RekamMedisModel rekamMedisModel = rekamMedisModelArrayList.get(position);

        holder.bulan.setText(rekamMedisModel.getBulanPelayanan());
        holder.tanggal.setText(rekamMedisModel.getTanggalPelayanan());
        holder.tahun.setText(rekamMedisModel.getTahunPelayanan());
        holder.time.setText(rekamMedisModel.getTimePelayanan());

        holder.itemView.setOnClickListener(view -> {
            String time = rekamMedisModel.getTimePelayanan();
            String tanggal = rekamMedisModel.getTanggalPelayanan();
            String bulan = rekamMedisModel.getBulanPelayanan();
            String tahun = rekamMedisModel.getTahunPelayanan();
            String namaPasien = rekamMedisModel.getNamaPasien();
            String namaPerawat = rekamMedisModel.getNamaPerawat();
            String keluhan = rekamMedisModel.getKeluhanPasien();
            String alamat = rekamMedisModel.getAlamatPasien();
            String imagePerawat = rekamMedisModel.getImageURLPerawat();
            String riwayat = rekamMedisModel.getRiwayatPasien();
            String diagnosa = rekamMedisModel.getDiagnosaPasien();
            String rencana = rekamMedisModel.getRencanaPenataPasien();
            String pengobatan = rekamMedisModel.getPengobatanPasien();

            //put to Detail Activity
            Intent sendData = new Intent(mActivity, DetailRekamMedisActivity.class);
            sendData.putExtra("time", time);
            sendData.putExtra("tanggal", tanggal);
            sendData.putExtra("bulan", bulan);
            sendData.putExtra("tahun", tahun);
            sendData.putExtra("namapasien", namaPasien);
            sendData.putExtra("namaperawat", namaPerawat);
            sendData.putExtra("keluhan", keluhan);
            sendData.putExtra("alamat", alamat);
            sendData.putExtra("imageperawat", imagePerawat);
            sendData.putExtra("riwayat", riwayat);
            sendData.putExtra("diagnosa",diagnosa);
            sendData.putExtra("rencana", rencana);
            sendData.putExtra("pengobatan", pengobatan);

            mActivity.startActivity(sendData);
            mActivity.finish();
        });
    }

    @Override
    public int getItemCount() {
        return rekamMedisModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tanggal, bulan, tahun, time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tanggal = itemView.findViewById(R.id.tv_lrkm_tanggal);
            bulan = itemView.findViewById(R.id.tv_lrkm_bulan);
            tahun = itemView.findViewById(R.id.tv_lrkm_tahun);
            time = itemView.findViewById(R.id.tv_lrkm_time);
        }
    }
}
