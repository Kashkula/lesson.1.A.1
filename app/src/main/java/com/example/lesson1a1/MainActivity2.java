package com.example.lesson1a1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson1a1.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    private static final int REQUEST_MAIN_2 = 100;
    public static final String KEY = "key";
    public static final String NARKOTA = "narkota";

    protected String textUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_MAIN_2);
            }
        });

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = binding.editText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(KEY, text);
                intent.putExtra(NARKOTA, textUri);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_MAIN_2 && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            textUri = String.valueOf(uri);
            binding.imageView.setImageURI(uri);
        }
    }
}
