package com.javaex.mysite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.javaex.vo.GuestbookVo;

public class MainActivity extends AppCompatActivity {

    //Field
    private EditText editName, editPassword, editContent;
    private Button btnWrite;

    //Constructor

    //Method G/S

    //Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWrite = (Button) findViewById(R.id.btnWrite);
        editName = (EditText) findViewById(R.id.editName);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editContent = (EditText) findViewById(R.id.editContent);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //저장버튼을 클릭
        btnWrite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("javaStudy", "저장버튼 클릭");

                //방ㅇ명록데이터를 vo로 만든다
                String name = editName.getText().toString();
                String password = editPassword.getText().toString();
                String content = editContent.getText().toString();

                GuestbookVo guestbookVo = new GuestbookVo(name, password, content);
                Log.d("javaStudy", "vo= " + guestbookVo);

                //서버 전송
                Log.d("javaStudy", "서버전송");

                //리스트 액티비티로 전환
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("javaStudy", "home버튼클릭");
        Log.d("javaStudy", "item.getItemId(0 --> " + item.getItemId());
        Log.d("javaStudy", "android.R.id.home --> " + android.R.id.home);

        switch(item.getItemId()){
            case R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}