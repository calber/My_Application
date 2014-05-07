package com.example.myapplication.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.widget.*;


public class MainActivity extends ActionBarActivity {

    LayoutInflater inflater ;

    String items[] = {
            "uno","due","tre","quattro",
            "cinque","sei","sette","otto"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater = getLayoutInflater();

        TextView t = (TextView) this.findViewById(R.id.id);

        ListView l = (ListView) findViewById(R.id.listView);
//        l.setAdapter(new ArrayAdapter<String>(this,R.layout.item,R.id.textView,items));

        final MyBaseAdapter adapter = new MyBaseAdapter();
        l.setAdapter(adapter);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent  = new Intent();
                intent.setClass(MainActivity.this,DetailActivity.class);
                intent.putExtra("item",adapter.getItem(position));
                startActivity(intent);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.webview:
                startActivity(new Intent().setClass(MainActivity.this,WebActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class MyBaseAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public String getItem(int position) {
            return items[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView==null) {
                convertView = getLayoutInflater().inflate(R.layout.item, null);
            }
            ((TextView) convertView.findViewById(R.id.textView)).setText(getItem(position));

            return convertView;
        }
    }

    public String[] getItems() {
        return items;
    }
}
