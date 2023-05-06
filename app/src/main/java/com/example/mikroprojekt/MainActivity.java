package com.example.mikroprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {
    private TextView textView1, textView2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView);
        textView2= (TextView) findViewById(R.id.textView2);
        button = (Button) findViewById(R.id.open_dialog_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

    }
    public void openDialog()
    {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void applyTexts(String jeden, String dwa) {
        textView1.setText("ilosc cyfr: "+jeden);
        textView2.setText("ilość znaków specjalnych: "+dwa);
    }
}