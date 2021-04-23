package com.example.sortinggame;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class appInterface extends RelativeLayout {
    //initialize variables
    TextView[] text;
    TextView messageBox;

    public appInterface(Context context,int screenHeight){
        super(context);

        //create message box and create array of textviews
        messageBox = new TextView(context);
        text = new TextView[10];
        for (int i = 0; i< text.length; i++){
            text[i] = new TextView(context);
            text[i].setId(TextView.generateViewId());
            text[i].setBackgroundColor(Color.parseColor("#009900"));
            text[i].setTextColor(Color.BLACK);
            text[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            text[i].setGravity(Gravity.CENTER);

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0, 0);
            if (i > 0) params.addRule(RelativeLayout.BELOW, text[i-1].getId());
            params.width = LayoutParams.MATCH_PARENT;
            params.height = screenHeight/10;
            params.topMargin = 1;
            text[i].setLayoutParams(params);
            addView(text[i]);
        }
        addView(messageBox);

    }
    public void showCurrent(int[] arr,int windowLocation, String message){

        //fill textview array with integer values
        for (int i = 0; i < arr.length;i++) text[i].setText(arr[i] + " ");

        //display message in messageBox
        messageBox.setText(message);

        //change color at window location
        if(windowLocation-1 == -1) {
            text[9].setBackgroundColor(Color.parseColor("#009900"));
            text[8].setBackgroundColor(Color.parseColor("#009900"));
        }
        else
        text[windowLocation-1].setBackgroundColor(Color.parseColor("#009900"));

        text[windowLocation].setBackgroundColor(Color.parseColor("#990000"));
        text[windowLocation+1].setBackgroundColor(Color.parseColor("#990000"));

    }
}
