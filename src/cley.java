/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics2D;
import robocode.*;
import robocode.util.*;
import java.awt.geom.*;


/**
 * Robocode - Projeto Final de Inteligencia Artificial
 * Higor Oliveira e Amanda Couto
 */
public class cley extends AdvancedRobot{
  Double energia;
    @Override
    public void run(){
     setAdjustRadarForGunTurn(true);   
     setTurnRadarLeft(360);
     while(true){
     energia = this.getEnergy();
        execute();
    }
    }
 
     
    @Override
    public void onScannedRobot (ScannedRobotEvent e){
   // double angulo = Math.toRadians((e.getHeading()+e.getBearing())%360);
    do{setTurnRadarRight(getHeading()- getRadarHeading()+e.getBearing());
    setTurnGunRight(getHeading()-getGunHeading()+e.getBearing());
    fire(1);
    setTurnRadarRight(90);
    }while(e.getEnergy()<=getEnergy() && e.getBearing()==getGunHeading()); //tem q normalizar o angulo... em determinado quadrante a formula da ruim
            
            
          // if (angulo>0 && angulo<181){   
           //setTurnGunRight(getHeading()-angulo);
           //fire(1);
           //}
           //else if (angulo>180 && angulo<361){
           //back(10);
          // setTurnGunLeft(getHeading()- angulo);
           //fire(1);
           //}
         //fire(1);  
         //execute();  
       // }
    }
    
    @Override
    public void onHitByBullet (HitByBulletEvent e){
        //pegar a direção q a bala veio e mover no sentido oposto
        setTurnRadarRight(90);
     
        
    }
    public void onHitWall(HitWallEvent e){
    setTurnRadarRight(360);    
    } 
}

