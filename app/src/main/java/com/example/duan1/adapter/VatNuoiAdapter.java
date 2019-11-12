package com.example.duan1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan1.QL_VatNuoiActivity;
import com.example.duan1.R;
import com.example.duan1.dao.VatNuoiDao;
import com.example.duan1.model.VatNuoi;

import java.util.List;

public class VatNuoiAdapter extends BaseAdapter {
    List<VatNuoi> arrVatNuoi;
    public LayoutInflater inflater;
    VatNuoiDao vatNuoiDao;
    public Activity context;

    public VatNuoiAdapter(Activity context, List<VatNuoi> arrVatNuoi) {
        this.arrVatNuoi = arrVatNuoi;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        vatNuoiDao = new VatNuoiDao(context);

    }


    @Override
    public int getCount() {
        return arrVatNuoi.size();
    }

    @Override
    public Object getItem(int position) {
        return arrVatNuoi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder {
        ImageView img;
        TextView txtMaVN;
        TextView txtLoai;
        TextView txtDacdiem;
        ImageView imgDelete;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.itemvatnuoi, null);
            viewHolder.img = (ImageView) view.findViewById(R.id.img);
            viewHolder.txtMaVN = (TextView) view.findViewById(R.id.txtmavn);
            viewHolder.txtLoai = (TextView) view.findViewById(R.id.txtloai);
            viewHolder.txtDacdiem = (TextView) view.findViewById(R.id.txtdacdiem);
            viewHolder.imgDelete = (ImageView) view.findViewById(R.id.imgdelete);
            viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vatNuoiDao.deleteVatnuoi(arrVatNuoi.get(position).getMavatnuoi());
                    arrVatNuoi.remove(position);
                    notifyDataSetChanged();
                }
            });
            view.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) view.getTag();
        VatNuoi _entry = (VatNuoi) arrVatNuoi.get(position);
        if (position % 3 == 0) {
            viewHolder.img.setImageResource(R.drawable.vatnuoi);
        } else if (position % 3 == 1) {
            viewHolder.img.setImageResource(R.drawable.vatnuoi);
        } else {
            viewHolder.img.setImageResource(R.drawable.vatnuoi);
        }
        viewHolder.txtMaVN.setText(_entry.getMavatnuoi());
        viewHolder.txtLoai.setText(_entry.getLoai());
        viewHolder.txtDacdiem.setText(_entry.getDacdiem());
        return view;
    }
}
