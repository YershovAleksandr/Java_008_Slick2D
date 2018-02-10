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
    private float mSpeed;
    private float mScale;
    private int mFilter;
    private boolean mLtR;   //Left ot Right

    void ParalaxLayer(){
        //
    }

    public void ParalaxLayer2(String pathimg, float x, float y, float speed, float scale, int filter){
        log = LoggerFactory.getLogger(Paralax.class);

        mPathimg = pathimg;
        mFilter = filter;
        mScale = scale;
        mX = x;
        mY = y;
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

    //public void update(GameContainer gc, int i){
    public void update(){
        if (mLtR){
            mX += mSpeed;
        }
        else{
            mX -= mSpeed;
        }
    }

    public void render(GameContainer gc, Graphics g){
        //gc.getGraphics().
        mImg.draw(mX, mY, mScale);
        //g.drawImage(mImg, mX, mY);
    }

}
