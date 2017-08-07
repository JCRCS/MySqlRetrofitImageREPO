package com.example.sanros.mysqlretrofitimagerepo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText Img_title;
    private Button BnChoose,BnUpload;
    private ImageView Img;
    private static final int IMG_REQUEST = 777;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Img_title = (EditText) findViewById(R.id.img_title);
        BnChoose = (Button) findViewById(R.id.chooseBn);
        BnUpload = (Button) findViewById(R.id.uploadBn);
        Img = (ImageView) findViewById(R.id.imageView);
        BnChoose.setOnClickListener(this);
        BnUpload.setOnClickListener(this);


    }


    @Override
    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.chooseBn:
                selectImage();
                break;
            case R.id.uploadBn:
                break;

        }

    }

    private void selectImage()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMG_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode, data);
        if(requestCode == IMG_REQUEST && resultCode == RESULT_OK && data!=null)
        {
            Uri path = data.getData();
            try
            {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                Img.setImageBitmap(bitmap);
                BnChoose.setEnabled(false);
                BnUpload.setEnabled(true);
                Img.setVisibility(View.VISIBLE);
                Img_title.setVisibility(View.VISIBLE);

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }


}
