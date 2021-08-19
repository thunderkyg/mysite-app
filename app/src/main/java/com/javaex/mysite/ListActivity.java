package com.javaex.mysite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.javaex.vo.GuestbookVo;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView lvGuestbookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //데이터를 가져온다(서버로부터)
        List<GuestbookVo> guestbookList = getListFromServer();
        Log.d("javaStudy", "서버로부터 데이터수신.......");
        Log.d("javaStudy", "list: " + guestbookList.toString());

        //ListView를 객체화 한다.
        lvGuestbookList = (ListView) findViewById(R.id.lvGuestbookList);

        //어댑터를 생성
        GuestbookListAdapter guestbookListAdapter =
                new GuestbookListAdapter(getApplicationContext(), R.id.lvGuestbookList, guestbookList);

        lvGuestbookList.setAdapter(guestbookListAdapter);

        lvGuestbookList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //현재 클릭한 뷰의 리스트의 index값
                Log.d("javaStudy", "index=" + i);

                // 화면에 있는 값을 읽어본다
                TextView txtContent = (TextView)view.findViewById(R.id.txtContent);
                Log.d("javaStudy", "content=" + txtContent.getText().toString());

                //화면에 출력되지 않은 데이터를 가져올때 --> 리스트의 값을 사용할때
                GuestbookVo guestbookVo = (GuestbookVo) adapterView.getItemAtPosition(i);
                Log.d("javaStudy", "vo=" + guestbookVo.toString());
                Log.d("javaStudy", "regDate=" + guestbookVo.getRegDate());

                //클릭한 아이템의 pk값을 읽어온다
                int no = guestbookVo.getNo();
                Log.d("javaStudy", "vo.no=" + no);

            }
        });
    }

    //방명록 정보 만들기 (가상)
    public List<GuestbookVo> getListFromServer(){

        List<GuestbookVo> guestbookList = new ArrayList<GuestbookVo>();

        for(int i = 1; i <= 50; i++){
            GuestbookVo guestbookVo = new GuestbookVo();
            guestbookVo.setNo(i);
            guestbookVo.setName("정우성");
            guestbookVo.setRegDate("2021-08-19" + i);

            guestbookList.add(guestbookVo);
        }

        return guestbookList;
    }
}