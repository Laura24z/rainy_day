package edu.up.patla.rainy_day;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
@author Laura Patla
@version 2/5/2025
 This is a class that paints raindrops.
I used interesting names and descriptions for the colors
 for the sanity and enjoyment of one Andrew Nuxoll.
 */

public class viewing_time extends SurfaceView {

    //instance variables (all the colors and/or styles I plan to use later in draw, I'm just initializing rn)
    Paint morningSnow = new Paint();
    Paint turquoiseWall = new Paint();
    Paint selkieBlue = new Paint();
    Paint royalBlue = new Paint();
    Paint dustyBlue = new Paint();
    Paint trueIndigo = new Paint();
    Paint lavenderSecrets = new Paint();
    Paint imSoBlue = new Paint();
    Paint purpleWall = new Paint();
    Paint dreamingInLilac = new Paint();
    Paint putrescentPink = new Paint();
    Paint barbieDay = new Paint();

    int _x;
    int _y;


    public viewing_time(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);//this is the constructor Nux used in class, and he set the
        //WillNotDraw property to false. I decided to just copy that because he's probably right
        //this is also where Nux gave the colors their values, so I will also :)
        //I'm going to use all "my own" colors for aesthetic purposes
        //(hex code comes from https://htmlcolorcodes.com/color-picker/, where I created the colors on a color wheel)
        this.morningSnow.setColor(0xFFf1fdff);//light whitish blue, like melting snow on a cool morning
        this.turquoiseWall.setColor(0xFF66B1BD);//medium teal, like you see in paint commercials
        this.selkieBlue.setColor(0xFF47F9FF);//piercingly bright electric blue
        this.royalBlue.setColor(0xFF002CD3);//dark prussian blue
        this.dustyBlue.setColor(0xFF3F86B7);//greyish teal, like a stormy semidesert sky
        this.trueIndigo.setColor(0xFF663EFF);//classic medium indigo color, maybe more purple? I have my screen's brightness pretty low right now
        this.lavenderSecrets.setColor(0xFFCAA3FB);//light pinkish purple, not that pink tho
        this.imSoBlue.setColor(0xFF7743FF);//color of a blueberry if they were more purple, inspired by veggie tales (https://www.youtube.com/watch?v=nl5uSNhB_oo)
        this.purpleWall.setColor(0xFF7B19D7);//classic violet color, probably would also be featured in a paint commercial
        this.dreamingInLilac.setColor(0xFFDD85FF);//the color of a lilac, but like one of the pink ones, not the purple or white ones. Those are different colors.
        this.putrescentPink.setColor(0xFFF8D3FF);//"baby pink", the kind you see everywhere and it just fills you with existential dread. Or calm if you're weird I guess
        this.barbieDay.setColor(0xFFFF00CA);//the color you think of when you hear "Barbie". Like that pink jumpsuit I wore to watch the Barbie movie. I let Brianna borrow it and she never gave it back, but I'm pretty sure she stained it, so maybe I don't want it back. Anyway, she looked way more like a barbie in it than I did. I have a funny picture if you want to see it. You'll have to remind me though. Why in the world are you still reading this comment?!?
    }

    //this canvas thing should draw 6-12 randomly placed circles on the drawing surface thing.
    //Each circle should be a different color
    //I'm thinking that I'll start by just making a long if statement, and each section will draw one circle of a different color
    //that way, I can have an if for >=6, >=7, and so forth, and they won't be exclusive
   @Override
    public void onDraw(Canvas g) {
        //so, need to make 6 raindrops in random positions, and also maybe up to 6 others using if statements.

        double luckyNumber = Math.random()*7;//there are 7 different scenarios: one with 6 drops, one with 7, and so forth on to 12.
        //I'll just need to count down by 1's starting at 7 in order to have the most equal distribution of "randomness"

        if(luckyNumber<=7) {
            //draw the 6 main circles
            g.drawOval(giveX(), giveY(), _x+30, _y+30,turquoiseWall);
            g.drawOval(giveX(), giveY(), _x+30, _y+30,putrescentPink);
            g.drawOval(giveX(), giveY(), _x+30, _y+30,lavenderSecrets);
            g.drawOval(giveX(), giveY(), _x+30, _y+30,dustyBlue);
            g.drawOval(giveX(), giveY(), _x+30, _y+30,dreamingInLilac);
            g.drawOval(giveX(), giveY(), _x+30, _y+30,selkieBlue);
        }
        if(luckyNumber<=6) {
            //draw an extra circle (7 total)
            g.drawOval(giveX(), giveY(), _x+30, _y+30,morningSnow);
        }
        if(luckyNumber<=5) {
            //draw an extra circle (8 total)
            g.drawOval(giveX(), giveY(), _x+30, _y+30,purpleWall);
        }
        if(luckyNumber<=4) {
            //9 total circles
            g.drawOval(giveX(), giveY(), _x+30, _y+30,royalBlue);
        }
        if(luckyNumber<=3) {
            //10 total circles
            g.drawOval(giveX(), giveY(), _x+30, _y+30,trueIndigo);
        }
        if(luckyNumber<=2) {
            //11 total circles
            g.drawOval(giveX(), giveY(), _x+30, _y+30,imSoBlue);
        }
        if(luckyNumber<=1) {
            //12 total circles
            g.drawOval(giveX(), giveY(), _x+30, _y+30,barbieDay);
        }
    }//canvas end

    //so, there need to be 6-12 circles, 30dp in radius, with random coords between (0,0) and (800,800)
    //so, I think if I just do a math.random and * it by 801, I can cast int to make it round down, so there will only be 800 different options. There's probably a better way to go about this, but now my brain is locked on this one.
    public int giveX() {
         _x = (int)(Math.random()*801);//the parentheses should make it so that it multiplies before being cast to an int.
        return _x;
    }

    public int giveY() {
        _y = (int)(Math.random()*801);
        return _y;
    }
}//class end
