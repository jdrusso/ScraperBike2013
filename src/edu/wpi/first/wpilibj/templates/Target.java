/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author robotlab
 */
public class Target {
    
    //Static variables for positions
    static final int tUnassigned = 0;
    
    public static final int tLeft = 1;
    public static final int tRight = 2;
 
    public static final int tBot = 1;
    public static final int tMid = 2;
    public static final int tTop = 3;
    
    public static final double topAspect = 3.100;
    public static final double midAspect = 2.138;
    public static final double botAspect = 1.156;
    
    private final double tolerance = 0.4;
    
    public boolean isNull = true;
    
    public double height;   //height of the detected rectangle
    public double width;    //width of the detected rectangle
    
    public double cenX;     //x coordinate of the center of the detected rectangle
    public double cenY;     //y coordinate of the center of the detected rectangle

    public double aspect;   //aspect ratio of the detected rectangle
    
    public int vertPos;     //(0, 1, 2) = low, mid, high
    public int horPos;      //(0, 1) = left, right
    
    public Target(double h, double w){
        
        this.height = h;
        this.width = w;
        if (h == 0 | w == 0)
            this.isNull = true;
        else if (h != 0 && w !=0)
            this.isNull = false;
        this.horPos = tUnassigned;
        this.vertPos = tUnassigned;
    }
    
    public void setCenter(double x, double y){
        
        this.cenX = x;
        this.cenY = y;
    }
    
    public void setSize(double h, double w){
        
        this.height = h;
        this.width = w;
        
        if (h == 0 | w == 0)
            this.isNull = true;
        
        else if (h != 0 && w !=0)
            this.isNull = false;
        
        this.aspect = w/h;
        
        
        if(Math.abs(this.aspect - topAspect) < tolerance){
            this.vertPos = this.tTop;
            RobotMap.Top = this;
        }
        
        if(Math.abs(this.aspect - midAspect) < tolerance){
            this.vertPos = this.tMid;
            this.horPos = this.tUnassigned;
            RobotMap.unsortedMid.add(this);
        }
        
        if(Math.abs(this.aspect - botAspect) < tolerance){
            this.vertPos = this.tBot;
            this.horPos = this.tUnassigned;
            RobotMap.unsortedBot.add(this);
        }
        
        this.horPos = tUnassigned;
    }
    
    public int getHorPos(){
        
        return this.horPos;
    }
    
    public int getVertPos(){
        
        return this.vertPos;
    }
    
    public void setHorPos(int pos){
        
        this.horPos = pos;
        switch(pos){
            
            case tLeft:
                if (this.vertPos == tBot)
                    RobotMap.LBot = this;
                else if (this.vertPos == tMid)
                    RobotMap.LMid = this;
                break;
            case tRight:
                if (this.vertPos == tBot)
                    RobotMap.RBot = this;
                else if (this.vertPos == tMid)
                    RobotMap.RMid = this;
                break;
        }
    }
    
    public void setVertPos(int pos){
        
        this.vertPos = pos;
    }
}
