package com.example.mostafa.sindbad;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   ListView listView;
    ArrayAdapter arrayAdapter;
    ImageView share,email,more,exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   listView=(ListView)findViewById(R.id.List1);
        String array[]=getResources().getStringArray(R.array.stories);
        arrayAdapter=new ArrayAdapter(getApplicationContext(),R.layout.row_item,R.id.textview,array);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getApplicationContext(),webview.class);
                i.putExtra("page",position);
                startActivity(i);


            }
        });

    share=(ImageView)findViewById(R.id.img4);
      email=(ImageView)findViewById(R.id.img3);
        exit=(ImageView)findViewById(R.id.img1);
share.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
String appname="عالم السندباد";
        String applink="http://play.google.com/store/apps/details?id=com.example.mostafa.sindbad";
        Intent share=new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,appname+applink);
        startActivity(share);

    }
});

    }

    public void email(View view) {

        try {
            String text = "اقتراحي هو: ";
            Intent intent = new Intent((Intent.ACTION_SEND));
            intent.setData(Uri.parse("mailto:"));
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL, "mostafamahmoud199612@gmail.com");
            intent.putExtra(Intent.EXTRA_TEXT, text);
            intent.putExtra(Intent.EXTRA_SUBJECT, "تطبيق السندباد");
            startActivity(intent);
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), " لايوجد تطبيق بريد ",Toast.LENGTH_LONG).show();
        }

    }

    public void exit(View view) {
finish();
    }
}

