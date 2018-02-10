package com.nam;

import org.newdawn.slick.*;

//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.util.logging.PlatformLogger;

import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.*;
import java.util.logging.LogManager;
import org.slf4j.bridge.SLF4JBridgeHandler;


public class Main {

    public static org.slf4j.Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
	// write your code here

        log.info("Info");

        log.error("Error");

        log.warn("Warn");

        log.debug("Debug");

        LogManager.getLogManager().reset();
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        Logger llg = Logger.getLogger("global");
        llg.setLevel(Level.FINEST);


        llg.fine("FIne");


        try{
            Main mn = new Main();
            //mn.StartSlick();

            mn.StartSlick2();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void StartSlick() throws Exception{

        try {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new X2());
            //appgc = new AppGameContainer(new X2("Simple Fuck Motherfucka"));
            //appgc.setDisplayMode(640, 480, false);
            appgc.setDisplayMode(800, 600, false);
            appgc.start();
        }
        catch (SlickException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void StartSlick2() throws Exception{
        try{
            AppGameContainer appgc;

            appgc = new AppGameContainer(new X3("Fuck"));
            appgc.setDisplayMode(1024, 768, false);
            appgc.start();
        }
        catch (SlickException ex){
            log.error("WTF", ex);
        }


    }


    public class GameApp extends BasicGame{

        private Logger llg;

        public GameApp(String gamename){
            super(gamename);

            llg = Logger.getLogger("global");
            llg.setLevel(Level.FINEST);
        }

        @Override
        public void init(GameContainer gc) throws SlickException{
            //
            llg.fine("INIT");
            log.info("init");

        }

        @Override
        public void update(GameContainer gc, int i) throws SlickException{
            //
/*            llg.fine("UPDATE");
            log.info("update");*/

            //if (gc.getInput().consumed());

           /* log.info("MouseX " + gc.getInput().getMouseX());
            log.info("Absolute MouseX " + gc.getInput().getAbsoluteMouseX());
            log.info("MouseY " + gc.getInput().getMouseY());
            log.info("Absolute MouseY " + gc.getInput().getAbsoluteMouseY());*/

            if (gc.getInput().isKeyDown(Input.KEY_0)){
                log.info("KeyDown 0 ");
            }


            if (gc.getInput().isKeyPressed(Input.KEY_ENTER)){
                log.info("KeyPressed ENTER ");
            }

            if (gc.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
                log.info("MouseButtonDown LEFT");
            }

            if (gc.getInput().isMousePressed(Input.MOUSE_MIDDLE_BUTTON)){
                log.info("MousePressed MIDDLE");
            }

        }

        @Override
        public void mouseWheelMoved(int change){
            log.info("Mouse Whell Change = " + change);
        }

        @Override
        public void render(GameContainer gc, Graphics g) throws SlickException{
            g.drawString("Hello Fuck you", 100, 100);

        }
    }

}
