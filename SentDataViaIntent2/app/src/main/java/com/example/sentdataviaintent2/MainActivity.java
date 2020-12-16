package com.example.sentdataviaintent2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnSend;
    EditText edtNumber;
    TextView txtResult;

    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinkViews();
        addEvents();
    }

    private void LinkViews() {

        btnSend=findViewById(R.id.btnSend);
        edtNumber=findViewById(R.id.edtNumber);
        txtResult=findViewById(R.id.txtResult);
    }

    private void addEvents() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                //attract data
                intent.putExtra("Number",edtNumber.getText().toString());
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE && resultCode== Activity.RESULT_OK && data !=null){
            txtResult.setText(data.getDoubleExtra("result",0)+"");

        }
    }
}