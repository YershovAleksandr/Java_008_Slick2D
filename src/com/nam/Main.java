package com.nam;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.util.logging.PlatformLogger;*/

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    //public static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
	// write your code here

      /*  log.info("Info");

        log.error("Error");

        log.warn("Warn");

        log.debug("Debug");*/

        try{
            Main mn = new Main();
            mn.StartSlick();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void StartSlick() throws Exception{

        try {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new GameApp("Simple Fuck Motherfucka"));
            appgc.setDisplayMode(640, 480, false);
            appgc.start();
        }
        catch (SlickException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public class GameApp extends BasicGame{
        public GameApp(String gamename){
            super(gamename);
        }

        @Override
        public void init(GameContainer gc) throws SlickException{
            //
        }

        @Override
        public void update(GameContainer gc, int i) throws SlickException{
            //
        }

        @Override
        public void render(GameContainer gc, Graphics g) throws SlickException{
            g.drawString("Hello Fuck you", 100, 100);
            g.drawString("Пидор сука", 200, 200);
        }
    }

}
