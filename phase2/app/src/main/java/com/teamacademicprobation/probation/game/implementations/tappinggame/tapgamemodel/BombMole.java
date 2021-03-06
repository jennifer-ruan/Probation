package com.teamacademicprobation.probation.game.implementations.tappinggame.tapgamemodel;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.teamacademicprobation.probation.R;

/**
 * A BombMole object that when the players tap, they lose a point. BombMole object extends Mole.
 */
public class BombMole extends Mole {

    /**
     * Initializes the BombMole Object.
     *
     * @param context The context to get resources.
     * @param x       The x coordinate of BombMole in pixels.
     * @param y       The y coordinate of BombMole in pixels.
     */
    public BombMole(Context context, int x, int y) {
        super(x, y);
        this.setBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.bomb_mole));
    }
}
