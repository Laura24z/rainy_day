package edu.up.patla.rainy_day;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.graphics.Color;

/**
@author Laura Patla
@version 2/18/2025
 This is a class that paints raindrops.
I used interesting names and descriptions for the colors. You're welcome :)
 */

public class viewing_time extends SurfaceView {
    private int luckyNumber = (int)(Math.random()*7)+6;//there are 7 different scenarios: one with 6 drops, one with 7, and so forth on to 12.
    //this is an instance variable because I'm going to access it a couple times for arrays, for loops, and the initDrops
    //having coded further, maybe I should've given this guy a shorter name...
    private Raindrop[] rains = new Raindrop[luckyNumber];//this array will hold each raindrop (it's initialized down in initDrops)

    private Raindrop droplet;

    public viewing_time(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);//this is the constructor Nux used in class, and he set the
        //WillNotDraw property to false. I decided to just copy that because he's probably right

        //this guy will actually create the entire raindrops set for this instance of the view
        this.initDrops();
    }

    //this canvas should draw all the raindrops in the rains array at their specified location
    //I can use a for loop to draw all the raindrops in the array, which will make this wayyyy cleaner than it used to be
   @Override
    public void onDraw(Canvas g) {
        //so, I just need to draw each raindrop, and use its x, y, and paint color for the parameters here
        setWillNotDraw(false);
        for(int i=0;i<luckyNumber;i++) {
            Raindrop dude = rains[i];
            g.drawOval(dude.getX()-15, dude.getY()-15, dude.getX()+15, dude.getY()+15, dude.getHue());
        }
    }//canvas end

    //so, there need to be 6-12 circles, 30dp in radius, with random coords between (0,0) and (800,800)
    //so, I think if I just do a math.random and * it by 801, I can cast int to make it round down, so there will only be 800 different options. There's probably a better way to go about this, but now my brain is locked on this one.
    private int giveX() {
         int x = (int)(Math.random()*801);//the parentheses should make it so that it multiplies before being cast to an int.
        return x;
    }

    private int giveY() {
        int y = (int)(Math.random()*801);
        return y;
    }

    //initDrops creates the different raindrops. It gives each an x and y (for center coords) and a red, green, and blue value, as per the constructor's parameters
    private void initDrops() {
        //the following loop creates a new Raindrop object and saves it to the rains array
        for(int i = 0; i<luckyNumber;i++) {
            int red = (int)(Math.random()*256);
            int green = (int)(Math.random()*256);
            int blue = (int)(Math.random()*256);
            Raindrop dude = new Raindrop(giveX(), giveY(), red, green, blue, 255);
            rains[i] = dude;
        }
        //choose a random number between 0 and the luckyNumber instance variable (so it's choosing a location in the rains array)
        //then setMain of that headHoncho Raindrop to true, so it knows it's the big deal
        int headHoncho = (int)(Math.random()*(luckyNumber+1));
        droplet = rains[headHoncho];
        rains[headHoncho].setMain(true);
    }

    public Raindrop getDroplet() {
        return droplet;
    }

    public Raindrop[] getRains() {
        return rains;
    }
}//class end
