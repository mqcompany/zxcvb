package com.example.shopka;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    List<Msg> msglist = new ArrayList<>();
    RecyclerView recyclerView;
    DatabaseReference bd;
    ProgressBar pr;
    Boolean isVisible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bd = FirebaseDatabase.getInstance().getReference("Table");
        pr = (ProgressBar)findViewById(R.id.pr);
        recyclerView = (RecyclerView)findViewById(R.id.list);
        Listener();

    }
    private void Listener(){
        pr.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
        bd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (msglist.size() > 0) {
                                    msglist.clear();
                               }
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Msg msg = snapshot.getValue(Msg.class);
                    msglist.add(msg);
                }
                Adapter adapter = new Adapter(MainActivity.this,msglist);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(adapter);
                pr.setVisibility(View.INVISIBLE);
                recyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
