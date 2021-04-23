package com.example.sortinggame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Point;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    //create variables
    Game game;
    appInterface  appInterface;
    GestureDetector gestureDetector;
    boolean gameOver;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //initialize game and set view
        game = new Game();
        appInterface = new appInterface(this,screenHeight());
        setContentView(appInterface);

        //show current game
        appInterface.showCurrent(game.getArray(),game.getWindowLocation(),game.getMessage());

        //create touchchangehandler and gesture detector
        TouchHandler temp = new TouchHandler();
        gestureDetector = new GestureDetector(this, temp);

        gameOver = false;
    }
    private int screenHeight()
    {
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);

        return size.y - 160;
    }


    public boolean onTouchEvent(MotionEvent event){
        if(!gameOver)
            gestureDetector.onTouchEvent(event);

            return true;
    }
    private class TouchHandler extends GestureDetector.SimpleOnGestureListener
    {
        public boolean onSingleTapConfirmed(MotionEvent event){
            game.move();

            //update game
            int[] arr = game.getArray();
            int windowLocation = game.getWindowLocation();
            String message = game.getMessage();

            appInterface.showCurrent(arr,windowLocation,message);
            return true;
        }

        public boolean onDoubleTap(MotionEvent event){
            game.swap();

            //update game
            int[] arr = game.getArray();
            int windowLocation = game.getWindowLocation();
            String message = game.getMessage();

            appInterface.showCurrent(arr,windowLocation,message);

            if(game.gameOver()){
                gameOver = true;
            }
            return true;
        }
    }
}