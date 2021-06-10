package com.example.day6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OrderDialog extends AppCompatActivity {
    TextView textView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_dialog);

        LayoutInflater layoutInflater;

        textView = findViewById(R.id.order_text);
        btn = findViewById(R.id.order_call);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LinearLayout lin = (LinearLayout)View.inflate(getApplicationContext(), R.layout.order_dialog_layout, null);
                new AlertDialog.Builder(getApplicationContext())
                        .setTitle("주문정보를 입력하세요.")
                        .setIcon(R.mipmap.ic_launcher)
                        .setView(lin)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText product = lin.findViewById(R.id.order_dialof_layout_product_name);
                                EditText number = lin.findViewById(R.id.order_dialof_layout_product_number);
                                CheckBox paymethod = lin.findViewById(R.id.order_dialof_layout_product_paymethod);
                                textView.setText("주문정보 : " + product.getText() + ", " + number.getText() + "개" +
                                        (paymethod.isChecked() ? "착불결제 " : ""));
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                textView.setText("주문을 취소했습니다.");
                            }
                        })
                        .show();
            }
        });
    }
}