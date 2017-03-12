package com.example.vietanh.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Dialog d;
    private Button btn_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        btn_dialog = (Button) findViewById(R.id.btn_dialog);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Showdialog();
                btn_dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Showdialog_alert();
                    }
                });
            }

            public void Showdialog() {
                d = new Dialog(MainActivity.this);
                d.setTitle("anhviethy@gmail.com");
                d.setCancelable(false);
                d.setContentView(R.layout.dialog);
                Button btn_y = (Button) d.findViewById(R.id.btn_y);
                Button btn_n = (Button) d.findViewById(R.id.btn_n);

                btn_y.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                        d.dismiss();
                    }
                });
                btn_n.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        d.dismiss();
                    }
                });
                d.show();
            }
        });
    }

    private void Showdialog_alert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("anhviethy@gmail.com");
        builder.setMessage("Ban co muon dang nhap khong?");
        builder.setCancelable(false);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
