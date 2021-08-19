 package com.javaex.mysite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.javaex.vo.GuestbookVo;

import java.util.List;

public class GuestbookListAdapter extends ArrayAdapter<GuestbookVo> {

    private TextView txtNo;
    private TextView txtName;
    private TextView txtRegDate;
    private TextView txtContent;

    //생성자
    public GuestbookListAdapter(Context context, int textViewResourceId, List<GuestbookVo> items) {
        super(context, textViewResourceId, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(view == null){ //만들어놓은 view 없다 만들어야한다
            //Layout 뻥튀기 기계 받아오기
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());

            //레이아웃 뻥튀기
            view = layoutInflater.inflate(R.layout.activity_list_item, null);
        }

        //1개의 방명록 데이터가 있다.
        //1개의 데이터 처리 (xml 데이터 매칭)
        txtNo = view.findViewById(R.id.txtNo);
        txtName = view.findViewById(R.id.txtName);
        txtRegDate = view.findViewById(R.id.txtDate);
        txtContent = view.findViewById(R.id.txtContent);

        //데이터 가져오기(1개의 데이터) --> 부모쪽에 전체 리스트가 있다.
        GuestbookVo guestbookVo = super.getItem(position);
        txtNo.setText(guestbookVo.getNo());
        txtName.setText(guestbookVo.getName());
        txtRegDate.setText(guestbookVo.getRegDate());
        txtContent.setText(guestbookVo.getContent());

        return super.getView(position, convertView, parent);
    }
}
