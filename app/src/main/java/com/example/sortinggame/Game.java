package com.example.sortinggame;

public class Game {

    //create variables
    int[] array;
    int windowLocation;
    int swaps;

    public Game() {
        array = new int[10];
        windowLocation = (int) (Math.random() * 8);//0-8
        swaps = 0;

        //create array
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100) + 1;//1-100
        }
    }

    public void move()
    {
        //move window location
        windowLocation = (windowLocation+1)%9;

    }

    public void swap(){
        //swap 2 values inside window
       int temp = array[windowLocation];
       array[windowLocation] = array[windowLocation+1];
       array[windowLocation+1] = temp;


        //increment swaps
        swaps++;
    }

    //getter methods
    public int[] getArray(){
        return array;
    }
    public int getWindowLocation(){
        return windowLocation;
    }


    public boolean sorted(){
        //check if array is sorted
        for (int i = 0; i < array.length - 1; i++)
        {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        return true;
    }


    public boolean gameOver(){
        return swaps >= 45 || sorted();

    }


    public String getMessage(){
        if (swaps >= 45){
            return "User lost, hahahaha";
        }
        else if(sorted()){
            return "User won, nice job";
        }
        else
           return 45 - swaps + " Swaps left";
    }

}
