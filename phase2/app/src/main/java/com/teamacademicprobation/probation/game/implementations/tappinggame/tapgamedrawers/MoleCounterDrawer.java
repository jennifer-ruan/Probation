package com.teamacademicprobation.probation.game.implementations.tappinggame.tapgamedrawers;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.teamacademicprobation.probation.game.implementations.AndroidDrawer;


/**
 * An implementation of AndroidDrawer that draws the mole-counter.
 */
public class MoleCounterDrawer implements AndroidDrawer {
    /**
     * The x coordinate of the start of the text.
     */
    private int x;
    /**
     * The y coordinate of the start of the text.
     */
    private int y;
    /**
     * The moles left in the game.
     */
    private int moleLeft;
    /**
     * The style of the counter
     */
    private Paint paint;

    /**
     * Initializes a new ScoreBoardDrawer.
     *
     * @param x         The x coordinate of the start of the text.
     * @param y         The y coordinate of the start of the text.
     * @param moleLimit The maximum limit of moles appearing.
     * @param moleCount The current count of how many moles appeared.
     * @param paint     The style of the scoreboard.
     */
    public MoleCounterDrawer(int x, int y, int moleLimit, int moleCount, Paint paint) {
        this.x = x;
        this.y = y;
        this.moleLeft = moleLimit - moleCount;
        this.paint = paint;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText("Normal Moles Left:" + moleLeft, this.x, this.y, paint);
    }
}
