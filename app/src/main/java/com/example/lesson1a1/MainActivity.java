package com.example.lesson1a1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lesson1a1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    protected ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(intent, 22);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 22 && resultCode == RESULT_OK && data != null) {
            String textUri = data.getStringExtra(MainActivity2.NARKOTA);
            // распаковка нашего товара, т.е. наркотики
            Uri uri = Uri.parse(textUri);
            binding.imageView.setImageURI(uri);

            String justText = data.getStringExtra(MainActivity2.KEY);
            binding.textView.setText(justText);
        }
    }
}