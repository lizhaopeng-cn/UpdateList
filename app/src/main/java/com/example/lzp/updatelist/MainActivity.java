package com.example.lzp.updatelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> datas;
    private MyAdapter myAdapter;
    private boolean tag;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        textView = (TextView) findViewById(R.id.textView);
        datas = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            datas.add("第"+i);
        }
        myAdapter = new MyAdapter(this, datas, new MyAdapter.OnUpdateClickListener() {
            @Override
            public void OnUpdate() {
                tag = true;
                for(int i = 0; i < myAdapter.getCount(); i++){
//                    LinearLayout linearLayout = (LinearLayout) listView.getAdapter().getView(i,null,null);
//                    Button button = (Button) linearLayout.getChildAt(0);
////                    button.setTextColor(getResources().getColor(R.color.colorPrimary));
////                    button.setBackgroundDrawable(getResources().getDrawable(R.color.colorPrimary));
//                    Log.d("text", button.getText().toString());
//                    button.setText("btn");
                    listView.getAdapter().getView(i,null,null);
                }

                myAdapter.notifyDataSetChanged();
            }
        });
        listView.setAdapter(myAdapter);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag = false;
                for(int i = 0; i < myAdapter.getCount(); i++){
                    myAdapter.getView(i,null,null);
                }
                myAdapter.notifyDataSetChanged();
            }
        });
    }

    public List<String> getDatas() {
        return datas;
    }

    public boolean getTag(){
        return tag;
    }
}
