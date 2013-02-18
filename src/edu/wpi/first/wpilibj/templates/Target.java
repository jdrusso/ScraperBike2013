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
    public static final double topAspect = RobotMap.topAspect;
    //public static final double midAspect = 62/29;
    public static final double midAspect = RobotMap.midAspect;
    //public static final double botAspect = 37/32;
    public static final double botAspect = RobotMap.botAspect;
    
    private final double tolerance = RobotMap.targetTolerance;
    
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
        this.setSize(h, w);
        this.setCenter(x, y);
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
        
        ScraperBike.debugPrintln("Size set.");
        
        if (h == 0 | w == 0)
            this.isNull = true;
        
        else if (h != 0 && w !=0)
            this.isNull = false;
        
        ScraperBike.debugPrintln("Null conditions checked.");
        ScraperBike.debugToTable("CurrTarget", "X = " + this.cenX + ", Y = " + this.cenY + ", W = " + w + ", H = " + h + ", A = " + this.aspect);
        this.aspect = w/h;
        
        if(Math.abs(this.aspect - topAspect) < tolerance){
            this.vertPos = this.tTop;
            if(!(this == null))
                RobotMap.Top = this.cloneTarget();
            ScraperBike.debugToTable("Top (RobotMap)", RobotMap.Top.toString());
            ScraperBike.debugToTable("Top (Target)", this.toString());
        }
        
        else if(Math.abs(this.aspect - midAspect) < tolerance){
            this.vertPos = this.tMid;
            this.horPos = this.tUnassigned;
            if(!(this == null))
                RobotMap.unsortedMid.addElement(this.cloneTarget());
            ScraperBike.debugToTable("MidTargetSTR", this.toString());
            ScraperBike.debugToTable("MidTargetSTR'", ((Target)RobotMap.unsortedMid.elementAt(0)).toString());
        }
        
        else if(Math.abs(this.aspect - botAspect) < tolerance){
            this.vertPos = this.tBot;
            this.horPos = this.tUnassigned;
            RobotMap.unsortedBot.addElement(this.cloneTarget());
            ScraperBike.debugPrintln("Bot -- " + this.toString());
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
  /**
   * Calculates the average range to all detected targets.
   * Attempts to get a more accurate distance for range by measuring 
   * the distance to all the detected targets, and taking an average.
   * @return double - Average Distance
   */  
    public static double getAvgRange(){
        
        double avgRange = 0;
        double totRange = 0;
        int validTargets = 0;
        
        for (int i = 0; i < RobotMap.numTargets; i++){
            
            switch(i){
                
                case 1:
                    totRange += RobotMap.t1.getRange();
                    validTargets++; break;
                case 2:
                    totRange += RobotMap.t2.getRange();
                    validTargets++; break;
                case 3:
                    totRange += RobotMap.t3.getRange();
                    validTargets++; break;
                case 4:
                    totRange += RobotMap.t4.getRange();
                    validTargets++; break;
                case 5:
                    totRange += RobotMap.t5.getRange();
                    validTargets++; break;
                case 6:
                    totRange += RobotMap.t6.getRange();
                    validTargets++; break;
            }
        }
        
        avgRange = totRange/validTargets;
        
        ScraperBike.nt.putNumber("Averaged Range", avgRange);
        return avgRange;
    }
    
    /**
     * Calculates the range to a target.
     * Calculates range to a detected Target object, using trig and similar triangles.
     * 
     * 
     * @return double - Distance in feet
     */
    
    public double getRange(){
        
        double range;
        
        double Tft;
        double FOVpx;
        double Tpx;
        double theta;
        
        range = 0;
        FOVpx = 240;
        Tpx = this.height;
        theta = 47/2;
        Tft = 0;
        
        switch(this.vertPos){
            case 1:
                Tft = RobotMap.botH/12; break;
            case 2:
                Tft = RobotMap.midH/12; break;
            case 3:
                Tft = RobotMap.topH/12; break;
        }
        
        range = (.5*((Tft*FOVpx)/Tpx))/(Math.tan(Math.toRadians(theta)));
        
        /*Correct ranges based on a polynomial equation for error 
        *derived from empirical data
        */
        range = range*(1);
        
        return range;
    }
}
