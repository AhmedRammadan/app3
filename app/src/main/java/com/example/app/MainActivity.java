package com.example.app;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mrecyclerView;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrecyclerView=findViewById(R.id.recycler_view);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        //mrecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        // mrecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        adapter = new Adapter(MainActivity.this,getData());
        mrecyclerView.setAdapter(adapter);
        mrecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    private ArrayList<Modle> getData(){
        ArrayList<Modle> modles=new ArrayList<>();
        modles.add(new Modle("Osama Abuzid","descrpition for ahmed",R.drawable.osama_abuzid));
        modles.add(new Modle("Hassan Ahmed ","descrpition for ahmed",R.drawable.hassan_ahmed));
        modles.add(new Modle("Gamal Abomera","descrpition for ahmed",R.drawable.gamal_abomera));
        modles.add(new Modle("Mohamed","descrpition for ahmed",R.drawable.mohamed));
        modles.add(new Modle("My pro","descrpition for ahmed",R.drawable.my_pro));
        modles.add(new Modle("Policeman","descrpition for ahmed",R.drawable.policeman));
        return modles;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem item =menu.findItem(R.id.action_search);
        SearchView searchView =(SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                adapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

}
