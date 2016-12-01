package com.example.da.openclass;


import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnTouchListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView text = new TextView(this);
        text.setText(R.string.app_name);
        setContentView(text);


        RelativeLayout layout =(RelativeLayout) RelativeLayout.inflate(this, R.layout.activity_main, null);
        Button btn = (Button) layout.findViewById(R.id.button);
        ((TextView) layout.findViewById(R.id.resultView)).setText("enter number and click OK");

        //Listener 1: on click
        //anonymous class
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //long method
                //((TextView) findViewById(R.id.text)).setText("Ok ca marche"); //checking
                double a = Double.parseDouble(((EditText) findViewById(R.id.editText5)).getText().toString());
                double b = Double.parseDouble(((EditText) findViewById(R.id.editText6)).getText().toString());
                double c = Double.parseDouble(((EditText) findViewById(R.id.editText7)).getText().toString());


                double x[] = polynome(a, b, c);
                TextView txt = (TextView) findViewById(R.id.resultView);
                if(x != null){
                    txt.setText("x1 = "+x[0]+"\nx2 = "+x[1]);
                }else{
                    txt.setText("No solution");
                }
            }
        });

        btn.setOnTouchListener(this);
        setContentView(layout);
        //setContentView(R.layout.activity_main);
    }


    @Override
    //by implementing the interface View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event){
        //What have we touch?
        switch(v.getId()) {
            case R.id.button:
                break;
            case R.id.text:
                break;
            default:
                break;
        }
        return true;
    }



    protected double[] polynome(double a, double b, double c){
        double delta = b*b - 4*a*c;
        if(delta >= 0){
            double x[] = new double[2];
            x[0] = (-b+Math.sqrt(delta))/(2*a);
            x[1] = (-b-Math.sqrt(delta))/(2*a);
            return x;
        }else{
            return null;
        }
    }


}
