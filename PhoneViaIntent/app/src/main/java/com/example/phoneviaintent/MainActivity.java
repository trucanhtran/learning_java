package com.example.phoneviaintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.UriPermission;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnCall, btnDial;
    EditText edtNumb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkViews();
        addEvents();
        openSite();
    }




    private void linkViews() {
        edtNumb = findViewById(R.id.edtNumb);
        btnCall = findViewById(R.id.btnCall);
        btnCall = findViewById(R.id.btnDial);
    }

    /*private void addEvents() {
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_CALL)
            }
        });}*/
    private void addEvents() {
        btnDial.setOnClickListener(myClick);
        btnCall.setOnClickListener(myClick);

    }

    View.OnClickListener myClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btnDial) {
                //thuc hien goi quay so
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri uri = Uri.parse("text:" + edtNumb.getText().toString());
                intent.setData(uri);
                startActivity(intent);
            } else if (view.getId() == R.id.btnCall) {
                //thuc hien cuoc goi
                Intent intent = new Intent(Intent.ACTION_CALL);
                Uri uri = Uri.parse("text:" + edtNumb.getText().toString());
                intent.setData(uri);
                startActivity(intent);
            }
        }
    };

    public void openSite(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://tuoitre.vn"));
        startActivity(intent);
    }
}
