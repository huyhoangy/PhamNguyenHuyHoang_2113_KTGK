package com.example.kiemtragiuaky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class KqActivity extends AppCompatActivity {
    TextView tvTrangthai,tvChiso,tvMess;
    Button btnTinhlai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kq);
        tvTrangthai=findViewById(R.id.tvTrangthai);
        tvChiso=findViewById(R.id.tvChiso);
        tvMess=findViewById(R.id.tvMess);
        btnTinhlai=findViewById(R.id.btnTinhlai);
        Intent intent =getIntent();
        float caoo=intent.getFloatExtra("caoo",0);
        float nangg=intent.getFloatExtra("nangg",0);
        float caoinm=caoo/100;
        float bmi=nangg/(caoinm*caoinm);
        tvChiso.setText(String.format(("%.1f"),bmi));
        String status,mess;
        if (bmi<18.5){
            status="Trang thai: Thiếu cân";
            mess="Bạn nên ăn thêm";
        } else if (bmi>18.5&&bmi<24.9) {
            status="Trang thai: Khỏe mạnh";
            mess="Bạn có sức khỏe tốt";

        }
        else if (bmi>25&&bmi<29.9) {
            status="Trang thai: Thừa cân";
            mess="Bạn nên ăn ít lại";

        }
        else{
            status="Trang thai: Béo phì";
            mess="Bạn phải giảm cân";
        }
        tvTrangthai.setText(status);
        tvMess.setText(mess);
        btnTinhlai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

}
