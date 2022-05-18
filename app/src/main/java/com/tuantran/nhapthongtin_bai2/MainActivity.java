package com.tuantran.nhapthongtin_bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText edtPhone;
    EditText edtEmail;
    EditText edtTen;
    EditText edtCoquan;
    EditText edtMatkhau;
    TextView edtError;
    Button btntieptuc;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtError.setText("");
                if(edtPhone.getText().length()!=0
                        &&edtEmail.getText().length()!=0
                        &&edtTen.getText().length()!=0
                        && edtCoquan.getText().length()!=0
                        &&edtMatkhau.getText().length()!=0){
                    validateEmail(edtEmail);
                    validatePhone(edtPhone);
                    validatePassword(edtMatkhau);


                }else {
                    edtError.setText("Vui lòng nhập đầy đủ thông tin\n");
                    edtError.setVisibility(View.VISIBLE);
                    s = edtError.getText().toString();
                }

            }
        });


    }
    public void Anhxa(){
         edtPhone = (EditText) findViewById(R.id.edtSdt);
         edtEmail = (EditText) findViewById(R.id.edtEmail);
         edtTen = (EditText) findViewById(R.id.edtTen);
         edtCoquan = (EditText) findViewById(R.id.edtCoquan);
         edtMatkhau = (EditText) findViewById(R.id.edtMatKhau);
         edtError = (TextView) findViewById(R.id.edtError);
         btntieptuc =(Button) findViewById(R.id.btnTieptuc);

    }
    public boolean validateEmail(EditText edtEmail){
        String emailInput = edtEmail.getText().toString();
        if(Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            return  true;
        }else{
             s = s+ "Nhập sai email. Vui lòng nhập lại\n";
            edtError.setText(s);
            return false;
        }

    }
    public boolean validatePhone(EditText edtPhone){
        String phoneInput = edtPhone.getText().toString();
        if(!phoneInput.matches("[0-9]{10}$")){
            s = s + "Nhập sai số điện thoại.Vui lòng nhập lại\n";
            edtError.setText(s);
            return false;
        }else {
            return true;
        }
    }
    public boolean validatePassword(EditText edtMatkhau){
        String MKInput = edtMatkhau.getText().toString();
        if(MKInput.length()<8){
            s = s + "Mật khẩu của bạn quá ngắn.Vui lòng nhập lại\n";
            edtError.setText(s);
            return false;
        }else{
            return true;
        }
    }


}