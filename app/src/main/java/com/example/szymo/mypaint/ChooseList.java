package com.example.szymo.mypaint;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class ChooseList extends ActionBarActivity {


    ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_list);

        RowBean RowBean_data[] = new RowBean[] {

                new RowBean(R.drawable.k1),
                new RowBean(R.drawable.k2),
                new RowBean(R.drawable.k3)

        };

        RowAdapter adapter = new RowAdapter(this,
                R.layout.custom_row, RowBean_data);

        listView1 = (ListView)findViewById(R.id.list);

        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                switch(position){
                    case 0:
                        intent.putExtra("k",R.drawable.k1);
                        break;
                    case 1:
                        intent.putExtra("k",R.drawable.k2);
                        break;
                    case 2:
                        intent.putExtra("k",R.drawable.k3);
                        break;
                    //add more if you have more items in listview
                    //0 is the first item 1 second and so on...
                }
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
