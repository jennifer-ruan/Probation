package com.teamacademicprobation.probation.game.implementations.tappinggame.tapgamemodel;

import android.graphics.Bitmap;
import android.graphics.Paint;

import com.teamacademicprobation.probation.game.implementations.AndroidDrawer;
import com.teamacademicprobation.probation.game.implementations.Drawable;
import com.teamacademicprobation.probation.game.implementations.tappinggame.tapgamedrawers.MoleDrawer;

import java.util.ArrayList;
import java.util.List;

/**
 * A Mole object that the players will tap when playing the game.
 */
public class Mole extends TouchableObject implements Drawable {
    /**
     * The paint of the mole to be drawn.
     */
    private Paint paint = new Paint();
    /**
     * The bitmap of the bole to be drawn.
     */
    private Bitmap bitmap;

    /**
     * Initializes the x and y coordinates of the Mole.
     *
     * @param x The x coordinate of Mole in pixels.
     * @param y The y coordinate of Mole in pixels.
     */
    Mole(int x, int y, int size) {
        super(x, y, size);
    }


    /**
     * @return the bitmap of the Mole Object
     */
    private Bitmap getBitmap() {
        return bitmap;
    }

    /**
     * Sets the input bitmap as the Mole object's bitmap
     */
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }


    /**
     * Resize the bitmap to the desired size.
     */
    private Bitmap getResizedBitmap() {
        return Bitmap.createScaledBitmap(getBitmap(), this.getSize(), this.getSize(), true);
    }

    @Override
    public List<AndroidDrawer> getDrawers() {
        List<AndroidDrawer> drawers = new ArrayList<>();
        AndroidDrawer moleDrawer;
        moleDrawer = new MoleDrawer(getResizedBitmap(), this.getX(), this.getY(), paint);
        drawers.add(moleDrawer);
        return drawers;
  }
}
