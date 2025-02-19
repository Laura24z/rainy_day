package edu.up.patla.rainy_day;

import android.os.Bundle;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * @author Laura Patla
 * @version 2/18/2025
 * I didn't write any of this code. I'm pretty sure it's just here to make the app run smoothly.
 * If I'm wrong about that, that's my bad.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        viewing_time currentGuy = findViewById(R.id.rainView);
        Raindrop main_guy = currentGuy.getDroplet();
        rain_controller rainMan = new rain_controller(currentGuy, main_guy);

        SeekBar x_dudes = findViewById(R.id.sideways_seek);//I want the x of the main raindrop to always = this
        SeekBar y_dudes = findViewById(R.id.upright_seek);

        //set the starting values of the seekbars to the x and y coords of the main raindrop
        x_dudes.setProgress(main_guy.getX());
        y_dudes.setProgress(main_guy.getY());

        //set a listener on the seekbars so we know when they're changed
        x_dudes.setOnSeekBarChangeListener(rainMan);
        y_dudes.setOnSeekBarChangeListener(rainMan);
    }
}