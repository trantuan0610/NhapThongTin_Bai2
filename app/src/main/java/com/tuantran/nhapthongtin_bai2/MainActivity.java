package com.tuantran.nhapthongtin_bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText edtPhone;
    EditText edtEmail;
    EditText edtTen;
    EditText edtCoquan;
    EditText edtMatkhau;
    TextView edtError;
    Button btntieptuc;
    String checkEmail = "",checkSDT= "",checkName= "",checkCoquan= "",checkPass= "";
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();

        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 0;
                validatePhone(edtPhone);
                validateEmail(edtEmail);
                validateName(edtTen);
                validateCoQuan(edtCoquan);
                validatePassword(edtMatkhau);
                edtError.setText(checkSDT+checkEmail+checkName+checkCoquan+checkPass);
                if(i == 0){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
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

    public void validateEmail(EditText edtEmail){
        String emailInput = edtEmail.getText().toString();

        if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches() && emailInput.length()==0){
            edtEmail.setBackground(getDrawable(R.drawable.botron));
            checkEmail = "Email của bạn không đúng. Vui lòng nhập lại\n";
            edtEmail.setBackground(getDrawable(R.drawable.botron_loi));
            i = i+1;
        }else {
            checkEmail = " ";
            edtEmail.setBackground(getDrawable(R.drawable.botron));
        }

    }
    public void validateCoQuan(EditText edtCoquan){
        String Input = edtCoquan.getText().toString();

        if(Input.length()==0){
            checkCoquan = "Cơ quan của bạn không đúng.Vui lòng nhập lại\n";
            edtCoquan.setBackground(getDrawable(R.drawable.botron_loi));
            i = i+1;
        }else{
            checkCoquan = " ";
            edtCoquan.setBackground(getDrawable(R.drawable.botron));
        }

    }
    public void validateName(EditText edtTen){
        String Input = edtTen.getText().toString();

        if(Input.length()==0){
            checkName = "Tên của bạn không đúng.Vui lòng nhập lại\n";
            edtTen.setBackground(getDrawable(R.drawable.botron_loi));
            i = i+1;

        }else{
            checkName = " ";
            edtTen.setBackground(getDrawable(R.drawable.botron));
        }

    }
    public void validatePhone(EditText edtPhone){
        String phoneInput = edtPhone.getText().toString();
        String regex = "^0\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneInput);
        if(matcher.find()){

            edtPhone.setBackground(getDrawable(R.drawable.botron));
            checkSDT = " ";


        }else {
            checkSDT = "Số điện thoại của bạn không đúng.Vui lòng nhập lại\n";
            edtPhone.setBackground(getDrawable(R.drawable.botron_loi));
            i = i+1;
        }
    }
    public void validatePassword(EditText edtMatkhau){
        String MKInput = edtMatkhau.getText().toString();
        if(MKInput.length()<8){
            checkPass = "Mật khẩu của bạn quá ngắn.Vui lòng nhập lại\n";
            edtMatkhau.setBackground(getDrawable(R.drawable.botron_loi));
            i = i+1;

        }else{
            checkPass = " ";
            edtMatkhau.setBackground(getDrawable(R.drawable.botron));
        }
    }


}