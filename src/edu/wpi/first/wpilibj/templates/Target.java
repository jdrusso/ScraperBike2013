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
    
    //public static final double topAspect = 3.100;
    //public static final double midAspect = 2.138;
    //public static final double botAspect = 1.156;
    public static final double topAspect = 62/20;
    //public static final double midAspect = 62/29;
    public static final double midAspect = 24/18;
    //public static final double botAspect = 37/32;
    public static final double botAspect = 69;
    
    private final double tolerance = 0.4;
    
    public boolean isNull = true;
    
    public double height;   //height of the detected rectangle
    public double width;    //width of the detected rectangle
    
    public double cenX;     //x coordinate of the center of the detected rectangle
    public double cenY;     //y coordinate of the center of the detected rectangle

    public double aspect;   //aspect ratio of the detected rectangle
    
    public int vertPos;     //(0, 1, 2) = low, mid, high
    public int horPos;      //(0, 1) = left, right
    
    public Target(double h, double w, double x, double y){
        
        //this.height = h;
        //this.width = w;
        this.horPos = tUnassigned;
        this.vertPos = tUnassigned;
        ScraperBike.debugPrint("B - Height: " + h + ", Width: " + w + ", X: " + x + ", Y: " + y);
        this.setSize(h, w);
        this.setCenter(x, y);
        ScraperBike.debugPrint("A - Height: " + this.height + ", Width: " + this.width + ", X: " + this.cenX + ", Y: " + this.cenY + ", Aspect: " + this.aspect);
        if (h == 0 | w == 0)
            this.isNull = true;
        else if (h != 0 && w !=0)
            this.isNull = false;
    }
    
    public Target(boolean makingCopy){
        
    }
    
    public void setCenter(double x, double y){
        
        this.cenX = x;
        this.cenY = y;
    }
    
    public synchronized void setSize(double h, double w){
        
        ScraperBike.debugPrint("Setting size.");
        this.height = h;
        this.width = w;
        
        ScraperBike.debugPrint("Size set.");
        
        if (h == 0 | w == 0)
            this.isNull = true;
        
        else if (h != 0 && w !=0)
            this.isNull = false;
        
        ScraperBike.debugPrint("Null conditions checked.");
        ScraperBike.debugPrint("X = " + this.cenX + ", Y = " + this.cenY + ", W = " + w + ", H = " + h);
        this.aspect = w/h;
        ScraperBike.debugPrint(", A = " + this.aspect);
        
        
        if(Math.abs(this.aspect - topAspect) < tolerance){
            this.vertPos = this.tTop;
            RobotMap.Top = this.cloneTarget();
            ScraperBike.debugPrint("Top -- " + RobotMap.Top.toString());
            ScraperBike.nt.putString("TopTargetSTR", this.toString());
            ScraperBike.nt.putNumber("TopTargetSTR'", RobotMap.Top.aspect);
        }
        
        else if(Math.abs(this.aspect - midAspect) < tolerance){
            this.vertPos = this.tMid;
            this.horPos = this.tUnassigned;
            RobotMap.unsortedMid.addElement(this.cloneTarget());
            ScraperBike.debugPrint("Mid -- " + RobotMap.unsortedMid.elementAt(0).toString());
            //ScraperBike.nt.putValue("MidTarget", ((Object)this));
            ScraperBike.nt.putString("MidTargetSTR", this.toString());
            ScraperBike.nt.putString("MidTargetSTRL", ((Target)RobotMap.unsortedMid.elementAt(0)).toString());
            ScraperBike.nt.putNumber("MidTargetSTR'", RobotMap.LMid.aspect);
        }
        
        else if(Math.abs(this.aspect - botAspect) < tolerance){
            this.vertPos = this.tBot;
            this.horPos = this.tUnassigned;
            RobotMap.unsortedBot.addElement(this.cloneTarget());
            ScraperBike.debugPrint("Bot");
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
                    RobotMap.LBot = this.cloneTarget();
                else if (this.vertPos == tMid)
                    RobotMap.LMid = this.cloneTarget();
                break;
                
            case tRight:
                if (this.vertPos == tBot)
                    RobotMap.RBot = this.cloneTarget();
                else if (this.vertPos == tMid)
                    RobotMap.RMid = this.cloneTarget();
                break;
        }
    }
    
    public void setVertPos(int pos){
        
        this.vertPos = pos;
    }
    
    public void clear(){
        
        this.cenX = 0;
        this.cenY = 0;
        this.height = 0;
        this.width = 0;
        this.aspect = 0;
    }
    
    public String toString(){
        
        String str = ("Height: " + this.height + ", Width: " + this.width + ", CenX: " + this.cenX + ", CenY: " + this.cenY + ", AR: " + this.aspect);
        return str;
    }
    
    public Target cloneTarget(){
        Target copy = new Target(true);
        copy.aspect = this.aspect;
        copy.horPos = this.horPos;
        copy.cenX = this.cenX;
        copy.cenY = this.cenY;
        copy.height = this.height;
        copy.isNull = this.isNull;
        copy.vertPos = this.vertPos;
        copy.width = this.width;
        return copy;
    }
}
