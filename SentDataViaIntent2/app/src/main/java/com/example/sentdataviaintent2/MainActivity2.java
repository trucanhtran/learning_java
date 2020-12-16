package com.example.sentdataviaintent2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView txtNumb;
    Button btnReturn;
    Intent intent=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        linkViews();
        getData();
        addEvents();
    }




    private void linkViews() {

        txtNumb=findViewById(R.id.txtNumb);
        btnReturn=findViewById(R.id.btnReturn);
    }

    private void getData() {
        intent =getIntent();
        String data=intent.getStringExtra("Number");
        txtNumb.setText(data);
    }
    private void addEvents() {
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnResult();
            }
        });

    }
    private void returnResult(){
        int numb=Integer.parseInt(txtNumb.getText().toString());
        double result=Math.sqrt(numb);
        //intent.putExtra("sqrt",result);
       // Log.i("Test",result+"");
        //hay
        //Toast.makeText(MainActivity2.this,result+"",Toast.LENGTH_LONG.show());

        intent.putExtra("result",result);

        setResult(Activity.RESULT_OK,intent);
        finish();


    }
}