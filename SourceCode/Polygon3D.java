import java.awt.*;

public class Polygon3D

{
    public Point3D[] points;
    public boolean full;
    public Color col;
    
    public Polygon3D(Point3D... points){
        this.full = false;
        this.points = points;
        this.col = Color.WHITE;
    }
    
    public Polygon3D(boolean full,Point3D... points){
        this.full = full;
        this.col = Color.WHITE;
        this.points = points;
    }
    
    public Polygon3D(Color col,Point3D... points){
        this.full = false;
        this.col = col;
        this.points = points;
    }
    
    public Polygon3D(boolean full,Color col,Point3D... points){
        this.full = full;
        this.col = col;
        this.points = points;
    }
    
    public Point3D getPoint3D(int i){
        return this.points[i];
    }
    
    public void setPoint3D(int i,Point3D newPoint){
        this.points[i] = newPoint;
    }
    
    public int getClosestX(){
        int camDistance = ColorGrid.CAMDISTANCE;
        int result = (int)Math.hypot(this.points[0].x-camDistance,this.points[0].y);
        for (int i = 0; i < this.points.length; i++){
            if ((int)Math.hypot(this.points[i].x-camDistance,this.points[i].y) <= result)
                result = (int)Math.hypot(this.points[i].x-camDistance,this.points[i].y);;
        }
        return result; 
    }
    
    public int compare(Polygon3D poly){
        int comparison = poly.getClosestX();
        return getClosestX()-comparison;
    }
}