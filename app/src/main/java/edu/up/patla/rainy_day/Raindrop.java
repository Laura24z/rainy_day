package edu.up.patla.rainy_day;

import android.graphics.Paint;

/**
 * @author Laura Patla
 * @version 2/18/25
 */
public class Raindrop {
//initializing instance variables. Each one has a getter and setter method, so that they can be accessed and changed in viewing_time
private boolean _isMain = false;
private int _xvalue;
private int _yvalue;

private int _red;
private int _green;
private int _blue;

private Paint _hue = new Paint(0xFFFFFFFF);

//can't use a default constructor, every raindrop needs an x, y, and paint color.
//don't need to worry about _isMain in the constructor, we're setting the main-ness of only one of them in a method in viewing_time
//but yeah, constructor just initializes the instance variables :)
public Raindrop(int x_val, int y_val, int red, int green, int blue, int a) {
    _xvalue = x_val;
    _yvalue = y_val;
    setHue(red, green, blue, a);

    //the app was having problems with getting my paints into their components of red, green, and blue
    //but I worked really hard making those colors and they are my children.
    _red = red;
    _green = green;
    _blue = blue;
}

public int getX() {
    return _xvalue;
}

public int getY() {
    return _yvalue;
}

public boolean isMain() {
    return _isMain;
}


public void setX(int x) {
    _xvalue = x;
}

public void setY(int y) {
    _yvalue = y;
}

public void setMain(boolean isIt) {
    _isMain = isIt;
}

public void setHue(int red, int green, int blue, int a) {
    if(a>=0 && a<256) {
        if (red >= 0 && red < 256) {
            if (green >= 0 && green < 256) {
                if (blue >= 0 && blue < 256) {
                    _hue.setARGB(a, red, green, blue);
                    _red = red;
                    _green = green;
                    _blue = blue;
                }
            }
        }
    }//outside if
    else{
        _hue.setARGB(255,255,255,255);
        _red = 255;
        _green = 255;
        _blue = 255;
    }
}

public Paint getHue() {
    return _hue;
}

    public int getBlue() {
        return _blue;
    }

    public int getRed() {
        return _red;
    }

    public int getGreen() {
        return _green;
    }
}
