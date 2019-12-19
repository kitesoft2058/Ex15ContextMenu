package com.kitesoft.ex15contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= findViewById(R.id.btn);

        //액티비티에게 btn객체를 ContextMenu로 등록
        registerForContextMenu(btn);
    }

    //ContextMenu로 등록된 뷰가 롱클릭되면
    //컨텍스트메뉴를 만드는 메소드가 자동으로 실행되는 콜백메소드..
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        //context.xml파일을 메뉴객체로 생성(부플리다..)
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.context, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //콘텍스트메뉴의 아이템을 선택했을때 자동으로 실행되는 콜백메소드..
    @Override
    public boolean onContextItemSelected(MenuItem item) {


        switch ( item.getItemId() ){
            case R.id.menu_save:
                Toast.makeText(this, "SAVED", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_delete:
                Toast.makeText(this, "DELETED", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    // 기본적인 버튼으로서의 클릭이벤트 동작 확인 콜백메소드...
    public void clickBtn(View v){
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
    }
}
