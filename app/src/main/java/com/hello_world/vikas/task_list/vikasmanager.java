package com.hello_world.vikas.task_list;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by vikas on 11/9/2016.
 */
public class vikasmanager
{
    private ArrayList<Item> list;
    private static vikasmanager reference;

    public static vikasmanager get()
    {
        Log.i("vikas","enter");
        if(reference == null){
            reference = new vikasmanager();
        }
        return reference;
    }

    public vikasmanager(){
        list = new ArrayList<>();
        Log.i("ujjwal",list.size()+"");
    }

    public ArrayList<Item> getList(){

        return list;
    }
}
