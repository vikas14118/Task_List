package com.hello_world.vikas.task_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by vikas on 11/9/2016.
 */
public class fragmentClass extends Fragment
{
    private Item item;
    private static ArrayList<Item> list;

    private EditText title;
    private EditText details;

    public static fragmentClass instance(ArrayList<Item> list1, int pos){
        Bundle bundle = new Bundle();
        bundle.putInt("position", pos);
        fragmentClass fragment = new fragmentClass();
        fragment.setArguments(bundle);
        list = list1;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);

        title = (EditText)view.findViewById(R.id.editText2);
        details = (EditText)view.findViewById(R.id.editText5);
        details.setText(item.getDetails());
        title.setText(item.getTitle());



        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int pos = (int)getArguments().getInt("position");
        item = list.get(pos);

    }
}
