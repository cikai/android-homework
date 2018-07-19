package com.mxnavi.homework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mxnavi.homework.jiahuan.JiaHuan;
import com.mxnavi.homework.jiangdi.JiangDi;
import com.mxnavi.homework.liuhe.LiuHe;
import com.mxnavi.homework.zhaoyunlong.ZhaoYunlong;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    private String[] menu = new String[]{
            "贾焕",
            "姜迪",
            "刘贺",
            "赵云龙"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, menu);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                Intent jiahuan = new Intent(MainActivity.this, JiaHuan.class);
                startActivity(jiahuan);
                break;
            case 1:
                Intent jiangdi = new Intent(MainActivity.this, JiangDi.class);
                startActivity(jiangdi);
                break;
            case 2:
                Intent liuhe = new Intent(MainActivity.this, LiuHe.class);
                startActivity(liuhe);
                break;
            case 10:
                Intent zhaoyunlong = new Intent(MainActivity.this, ZhaoYunlong.class);
                startActivity(zhaoyunlong);
                break;
            default:
                break;
        }
    }
}
