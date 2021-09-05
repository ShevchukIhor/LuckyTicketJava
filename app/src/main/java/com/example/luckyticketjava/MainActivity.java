package com.example.luckyticketjava;
import static android.widget.Toast.*;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView etNumber;
    private ImageView bulb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNumber = findViewById(R.id.et_ticket_number);
        bulb = findViewById(R.id.iv_image);
    }

    public void onClick(View view)
    {
        String etResult = etNumber.getText().toString().trim();
        if (etResult.length() != 6) 
        {
            bulb.setImageResource(R.drawable.grey_bulb);
            makeText(getApplicationContext(), "Minimum number of characters 6", LENGTH_SHORT).show();
        }
        else 
            {
            if(luckCheck(etResult))
                    {
                    bulb.setImageResource(R.drawable.green_bulb);
                    }
            else{
                    bulb.setImageResource(R.drawable.red_bulb);
                }
            }
    }

    boolean luckCheck(String etResult)
    {
        return sumNum(etResult, 0) == sumNum(etResult, etResult.length() - 3);
    }

    int sumNum(String etResult, int index)
    {
        int sum = 0;
           for (int i = index; i < index + 3; i++) {
                sum += Character.digit(etResult.charAt(i), 10);
            }
        return sum;
    }

}