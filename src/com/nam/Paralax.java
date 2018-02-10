package com.nam;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Paralax {

    Logger log;

    Image mBg;
    Image mStarsPalnet;
    Image mFarPalnet;
    Image mBigPalnet;
    Image mRingPalnet;


    int x;
    int y;

    float scale;

    int starsx;
    int farx;
    int bigx;
    int ringx;

    private final int N = 5;
    private ParalaxLayer[] mLayers;

    private String[] mImgPath = {"res/art/parallax-space-backgound.png",
            "res/art/parallax-space-stars.png",
            "res/art/parallax-space-far-planets.png",
            "res/art/parallax-space-big-planet.png",
            "res/art/parallax-space-ring-planet.png"};


    public Paralax() {

        log = LoggerFactory.getLogger(Paralax.class);

        mLayers = new ParalaxLayer[N];



    }

    public void init(){

        for (int i = 0; i < N; i++){
            mLayers[i] = new ParalaxLayer();
            mLayers[i].ParalaxLayer2(mImgPath[i], 100.f, 100.f, 0.5f * i, 2.f, Image.FILTER_NEAREST);
        }

        //int filter = Image.FILTER_LINEAR;
/*        int filter = Image.FILTER_NEAREST;


        try{
            mBg = new Image("res/art/parallax-space-backgound.png");
            mBg.setFilter(filter);
            mStarsPalnet = new Image("res/art/parallax-space-stars.png");
            mStarsPalnet.setFilter(filter);
            mFarPalnet = new Image("res/art/parallax-space-far-planets.png");
            mFarPalnet.setFilter(filter);
            mBigPalnet = new Image("res/art/parallax-space-big-planet.png");
            mBigPalnet.setFilter(filter);
            mRingPalnet = new Image("res/art/parallax-space-ring-planet.png");
            mRingPalnet.setFilter(filter);
        }
        catch (Exception ex){
            log.error("Wtf", ex);
        }

        x = 100;
        y = 100;

        scale = 2.0f;

        reset();
*/
    }

    private void reset(){
        starsx = x;
        farx = x;
        bigx = x;
        ringx = x;
    }

    public void update(GameContainer gc, int ii){
        if (gc.getInput().isKeyDown(Input.KEY_MINUS)){
            for (int i = 0; i < N; i ++){
                mLayers[i].setDirection(false);
                mLayers[i].update();
            }

        }

        if (gc.getInput().isKeyDown(Input.KEY_EQUALS)){
            for (int i = 0; i < N; i ++){
                mLayers[i].setDirection(true);
                mLayers[i].update();
            }
        }


        /*for (int ii = 0; ii < N; ii ++){
            mLayers[ii].update(gc, i);
        }*/

        //
      /*  starsx++;
        farx += 2;
        bigx += 3;
        ringx += 4;

        //mBg.getWidth();
        if (starsx > gc.getWidth()){
            reset();
        }*/
    }

    public void render(GameContainer gc, Graphics g){

        for (int i = 0; i < N; i ++){
            mLayers[i].render(gc, g);
        }

       /* mBg.draw(x, y, scale);
        mStarsPalnet.draw(starsx, y, scale);
        mFarPalnet.draw(farx, y, scale);
        mBigPalnet.draw(bigx, y, scale);
        mRingPalnet.draw(ringx, y, scale);*/
    }

    public void keyPressed(int key, char c){
        if (key == Input.KEY_ESCAPE){
            System.exit(0);
        }


    }

}
