package com.example.luckyticketjava;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private TextView etNumber;
    private ImageView bulb;
    int maxLength = 6;
    static int hulflenth = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.et_ticket_number);
        bulb = findViewById(R.id.iv_image);
    }
    public void onClick(View view) {

        String etResult = etNumber.getText().toString().trim();

        if (etResult.length() == maxLength){
            try {
                if(LuckCheck(etResult)){
                    bulb.setImageResource(R.drawable.green_bulb);}
                else
                    {
                        bulb.setImageResource(R.drawable.red_bulb);
                    }
            }
            catch (NumberFormatException nfe)
            {
                Toast.makeText(getApplicationContext(), "Enter your ticket number", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            bulb.setImageResource(R.drawable.grey_bulb);
            Toast.makeText(getApplicationContext(), "Minimum number of characters 6", Toast.LENGTH_SHORT).show();
        }

    }


    static boolean LuckCheck(String etResult){

        return sumNum(etResult,0) == sumNum(etResult, etResult.length()-hulflenth);
    }
    static int sumNum(String etResult, int index){
        hulflenth = etResult.length()/2;
        int sum = 0;
                for (int i=index;i<index+hulflenth;i++)
            sum += Character.digit(etResult.charAt(i), 10);
        return sum;
            }

}