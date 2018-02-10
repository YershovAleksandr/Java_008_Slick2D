package com.nam;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ParalaxLayer{

    private Logger log;

    private Image mImg;
    private String mPathimg;
    private float mX;
    private float mY;

    /*For second image*/
    private float mXX;
    private float mYY;

    private float mSpeed;
    private float mScale;

    /*window where we show our paralax */
    private float mX0;
    private float mX1;

    private int mFilter;
    private boolean mLtR;   //Left ot Right

    void ParalaxLayer(){
        //
    }

    public void ParalaxLayer2(String pathimg, float x, float y, float speed, float scale, int filter, float x0, float x1){
        log = LoggerFactory.getLogger(Paralax.class);

        mPathimg = pathimg;
        mFilter = filter;
        mScale = scale;
        mX = x;
        mY = y;

        mX0 = x0;
        mX1 = x1;

        mXX = mX + mX1;
        mYY = mY;

        mSpeed = speed;
        mLtR = true;

        init();
    }

    public void init(){
        try{
            mImg = new Image(mPathimg);
            mImg.setFilter(mFilter);
        }
        catch (Exception ex){
            log.error("Wtf", ex);
        }
    }

    public void setDirection(Boolean ltr){
        mLtR = ltr;
    }

    public void update(){
        if (mLtR){
            mX += mSpeed;
            mXX += mSpeed;
        }
        else{
            mX -= mSpeed;
            mXX -= mSpeed;
        }
    }

    public void render(GameContainer gc, Graphics g){
        mImg.draw(mX, mY, mScale);
        mImg.draw(mXX, mYY, mScale);
    }

}
