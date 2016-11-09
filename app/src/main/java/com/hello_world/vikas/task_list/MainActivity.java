package com.hello_world.vikas.task_list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView rcv;
    private ArrayList<Item> list;
    private Adapter adapter;

    private static MainActivity reference;

    public static MainActivity get()
    {
        Log.i("vikas","enter");
        if(reference == null){
            reference = new MainActivity();
        }
        return reference;
    }

    public ArrayList<Item> getList(){
        Toast.makeText(this,list.size(),Toast.LENGTH_SHORT).show();
        Log.i("vikas","afaf"+list.size());
        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vikasmanager man = vikasmanager.get();
        list = man.getList();
        try {

            File file = new File(getFilesDir(), "File11"); // Pass getFilesDir() and "MyFile" to read file
            BufferedReader input = null;
            input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            StringBuffer data = new StringBuffer();
            String line;
            while ((line = input.readLine()) != null) {
                String titleForTask=line;
                line = input.readLine();
                String detailForTask=line;
                list.add(new Item(titleForTask,detailForTask));
            }
            input.close();
        }catch(Exception e){

        }
        man = vikasmanager.get();
        adapter = new Adapter(this, list);
        Log.i("vikkkk",man.getList().size()+"");
        rcv=(RecyclerView) findViewById(R.id.recyclerView);

        rcv.setAdapter(adapter);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        ItemTouchHelper.SimpleCallback temp = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP,ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int i = viewHolder.getAdapterPosition();
                list.remove(i);
                adapter.notifyItemRemoved(i);
            }
        };
        ItemTouchHelper helper = new ItemTouchHelper(temp);
        helper.attachToRecyclerView(rcv);

    }
    public void toolclick(View view)
    {
        Intent intent = new Intent(this, InputActivity.class);
        startActivityForResult(intent,1);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            String message=data.getStringExtra("MESSAGE");
            String message1=data.getStringExtra("det");

            if(message.equals(""))
            {

            }
            else
            {
                Item item1= new Item(message,message1);
                list.add(item1);
                adapter.notifyDataSetChanged();
            }
        }
    }
    @Override
    public void onPause() {
        try {
            File dir = getFilesDir();
            File file = new File(dir, "File11");
            boolean deleted = file.delete();
            File file1;
            FileOutputStream outputStream;
            file1 = new File(getFilesDir(), "File11");

            outputStream = new FileOutputStream(file1);

            for(Item taskD : list){
                outputStream.write(taskD.getTitle().getBytes());
                outputStream.write("\n".getBytes());
                outputStream.write(taskD.getDetails().getBytes());
                outputStream.write("\n".getBytes());
            }
            outputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        super.onPause();
        // Always call the superclass method first

    }
}


