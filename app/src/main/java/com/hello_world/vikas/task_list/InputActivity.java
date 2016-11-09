package com.hello_world.vikas.task_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    Intent intent = new  Intent();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        Toolbar toolbar = (Toolbar)findViewById(R.id.too);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void toolclick1(View view)
    {
        EditText edit_text   = (EditText)findViewById(R.id.editText4);
        String title= edit_text.getText().toString();
        edit_text   = (EditText)findViewById(R.id.editText5);
        String description = edit_text.getText().toString();
        intent.putExtra("MESSAGE",title);
        intent.putExtra("det",description);
        setResult(1,intent);
        finish();
    }
}
