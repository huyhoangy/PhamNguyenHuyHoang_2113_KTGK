package com.example.kiemtragiuaky;

import static android.app.ProgressDialog.show;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etCao,etNang;
    Button btnTinh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etCao=findViewById(R.id.ettCao);
        etNang=findViewById(R.id.ettNang);
        btnTinh=findViewById(R.id.btnTinh);
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cao=etCao.getText().toString();
                String nang=etNang.getText().toString();
                if(!cao.isEmpty()&&!nang.isEmpty())
                {
                    float caoo=Float.parseFloat(cao);
                    float nangg=Float.parseFloat(nang);
                    Intent intent =new Intent(MainActivity.this,KqActivity.class);
                    intent.putExtra("caoo",caoo);
                    intent.putExtra("nangg",nangg);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(MainActivity.this, "Vui long nhao du", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}