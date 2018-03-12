package com.example.chaoice3240.firstactivity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button2= (Button) findViewById(R.id.sendbutton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:15053814876"));
                startActivity(intent);
            }
        });
        Intent intent=getIntent();
        Log.d(TAG, "onCreate: getcontent"+intent.getStringExtra("key"));



    }

    @Override
    public void onBackPressed() {
        Intent intentResult=new Intent();
        intentResult.putExtra("result","second data");
        setResult(RESULT_OK,intentResult);
        finish();
    }
}
