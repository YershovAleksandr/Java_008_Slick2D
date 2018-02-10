package com.nam;

import org.newdawn.slick.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class X3 extends BasicGame{

    private Logger log = LoggerFactory.getLogger(X3.class);
    private boolean flag = true;
    private boolean flag2 = true;

    private Image img;


    public X3(String gamename){
        super(gamename);

        log.info("X3");
    }

    @Override
    public void init(GameContainer gc) throws SlickException{
        log.info("Init");

        try{
            img = new Image("res/art/bg5.jpg");
        }
        catch (Exception ex){
            log.error("WTF", ex);
        }

    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException{
        if (flag){
            log.info("Update");

            flag = false;
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException{
        if (flag2){
            log.info("Render");

            flag2 = false;
        }

        img.draw(0,0, 1.0f);

    }


}
