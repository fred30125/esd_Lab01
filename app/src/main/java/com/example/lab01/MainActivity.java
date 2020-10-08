package com.example.lab01;

import android.graphics.Color;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    Button btn_toast, btn_pop;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btn_toast = findViewById(R.id.btn_toast);
        btn_pop = findViewById(R.id.btn_pop);
        textView=findViewById(R.id.textView);
        editText=findViewById(R.id.EditText);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().isEmpty()){

                    Toast.makeText(MainActivity.this, "editText is empty", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, editText.getText(), Toast.LENGTH_LONG).show();
                }

            }
        });
        btn_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, v);
                popup.setOnMenuItemClickListener(MainActivity.this);
                popup.inflate(R.menu.menu_main);
                popup.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_set, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {

            case R.id.tem1:
                String tmp=editText.getText().toString();
                textView.setText((Float.parseFloat(tmp)-32)*1.8+"");
                break;
            case R.id.tem2:
                String tmp2=editText.getText().toString();
                textView.setText((Float.parseFloat(tmp2)/1.8+32)+"");
                break;
            case R.id.color1:
                btn_pop.setBackgroundColor(Color.RED);
                break;
            case R.id.color2:
                btn_pop.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.color3:
                btn_pop.setBackgroundColor(Color.GREEN);
                break;

        }
        return false;

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.color1:
                btn_pop.setBackgroundColor(Color.RED);
                break;
            case R.id.color2:
                btn_pop.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.color3:
                btn_pop.setBackgroundColor(Color.GREEN);
                break;


        }
        return false;
    }
}