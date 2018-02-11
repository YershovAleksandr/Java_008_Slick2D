package com.nam;

import org.newdawn.slick.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Paralax {

    Logger log;

    int x;
    int y;

    float scale;

    int starsx;
    int farx;
    int bigx;
    int ringx;

    float x0;
    float x1;

    float y0;
    float y1;

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

        scale = 2.f;
        x0 = 100.f;
        y0 = 100.f;

        x1 = 272.f*scale;
        y1 = 160.f*scale;


    }

    public void init(){

        for (int i = 0; i < N; i++){
            mLayers[i] = new ParalaxLayer();
            mLayers[i].ParalaxLayer2(mImgPath[i],
                    x0,
                    y0,
                    0.5f * i,
                    scale,
                    Image.FILTER_NEAREST,
                    x0,
                    x1);
        }
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

    }

    public void render(GameContainer gc, Graphics g){

        for (int i = 0; i < N; i ++){
            mLayers[i].render(gc, g);
        }

        g.setColor(Color.red);
        g.drawRect(x0, y0, x1, y1);
    }

    public void keyPressed(int key, char c){
        if (key == Input.KEY_ESCAPE){
            System.exit(0);
        }


    }

}
