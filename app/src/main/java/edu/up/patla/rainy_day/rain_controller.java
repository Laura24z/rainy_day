package edu.up.patla.rainy_day;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.widget.SeekBar;

/**
 * @author Laura Patla
 * @version 2/18/2025
 * This class doesn't do anything right now :)
 */
public class rain_controller implements SeekBar.OnSeekBarChangeListener {
    viewing_time _view;
    int x_coord;
    int y_coord;
    Paint rainPaint;
    Raindrop bigGuy;

    public rain_controller(viewing_time view, Raindrop rain) {
        _view = view;
        x_coord = rain.getX();
        y_coord = rain.getY();
        rainPaint = rain.getHue();
        bigGuy = rain;
    }

    private void checkBuddies() {
        Raindrop[] rainArray = _view.getRains();
        //this loop checks each raindrop in the array to see if it has coords that make it overlap with the main drop.
        //if they do, it sends them to combineColors
        for (int i = 0; i < rainArray.length; i++) {
            if (rainArray[i].isMain()) {
            }
            else {
                //check if it's within 15 pixels of the main guy's x coord
                //first on the left
                if(rainArray[i].getX() < x_coord && rainArray[i].getX() > x_coord - 30) {
                    //now check if it's within the y-coord of the main drop
                    if(rainArray[i].getY() < y_coord && rainArray[i].getY() > y_coord-30) {
                        combineColors(rainArray[i]);
                    }
                    else if(rainArray[i].getY() > y_coord && rainArray[i].getY() < y_coord + 30) {
                            combineColors(rainArray[i]);
                        }
                }
                //then on the right
                else if(rainArray[i].getX()>x_coord && rainArray[i].getX()< x_coord+30) {
                    if(rainArray[i].getY() < y_coord && rainArray[i].getY() > y_coord-30) {
                        combineColors(rainArray[i]);
                    }
                    else if(rainArray[i].getY() > y_coord && rainArray[i].getY() < y_coord + 30) {
                        combineColors(rainArray[i]);
                    }
                }
            }//close outside else loop
        }//close for loop
    }//close checkBuddies


            //this method takes the paint colors of the raindrop being absorbed (eaten) and the main raindrop (bigGuy), and sets bigGuy's new paint value to an average of the two colors
            private void combineColors (Raindrop eaten){
                //the following two chunks of code are getting the red, green, and blue values of each raindrop
                //first, I get the info of the raindrop that's going to be combined with the main drop
                int eatRed = eaten.getRed();
                int eatGreen = eaten.getGreen();
                int eatBlue = eaten.getBlue();

                //now I'm getting the info from the main raindrop
                int bigRed = bigGuy.getRed();
                int bigGreen = bigGuy.getGreen();
                int bigBlue = bigGuy.getBlue();

                //now average the red, green, and blue values of the two raindrop paints
                if(eatRed>0 || eatGreen>0 || eatBlue >0) {
                    int newRed = (eatRed + bigRed) / 2;
                    int newGreen = (eatGreen + bigGreen) / 2;
                    int newBlue = (eatBlue + bigBlue) / 2;

                    //and finally set the head honcho raindrop to the new combined color
                    bigGuy.setHue(newRed, newGreen, newBlue, 255);
                    //don't forget to send the eaten raindrop to the deleteDrop method where its doom awaits
                    deleteDrop(eaten);
                }
            }

            //this method will "delete" the chosen raindrop. In actuality, it just sets its color to clear using its setter method, but the drop still exists
            private void deleteDrop (Raindrop manOverboard){
                manOverboard.setHue(00,00,00,00);
            }

            @Override
            //this method is automatically called when the progress changes I'm pretty sure
            //when the person changes the seekbar, the system goes "here's the changed seekbar, its progress, and true"
            public void onProgressChanged (SeekBar seekBar,int progress, boolean hasIt){
                if (seekBar.getMax() == 799) {
                    x_coord = progress;
                    bigGuy.setX(progress);
                } else if (seekBar.getMax() == 800) {
                    y_coord = progress;
                    bigGuy.setY(progress);
                }
                checkBuddies();
                _view.invalidate();
            }

            @Override
            public void onStartTrackingTouch (SeekBar seekBar){

            }

            @Override
            public void onStopTrackingTouch (SeekBar seekBar){

            }

            //eventually, I need a loop to go through the rain array and check if the x and y are within 15 of the main guy's x and y, and if so, call delete on them, and also combine their colors with the main dude
}//close class