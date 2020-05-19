import java.awt.*;

public class Square extends Polygon3D
{
    public Square(){
        this.full = false;
        this.col = Color.WHITE;
        Point3D[] points = new Point3D[4];
        points[0] = new Point3D(0,1,1);
        points[1] = new Point3D(0,1,-1);
        points[2] = new Point3D(0,-1,-1);
        points[3] = new Point3D(0,-1,1);
    }
    
    public Square(double scale){
        Point3D[] points = new Point3D[4];
        points[0] = new Point3D(0,(int)scale/2,(int)scale/2);
        points[1] = new Point3D(0,(int)scale/2,(int)-scale/2);
        points[2] = new Point3D(0,-(int)scale/2,-(int)scale/2);
        points[3] = new Point3D(0,-(int)scale/2,(int)scale/2);
    }
    
    public Square(boolean full,double scale){
        this.full = full;
        this.col = Color.WHITE;
        Point3D[] points = new Point3D[4];
        points[0] = new Point3D(0,(int)scale/2,(int)scale/2);
        points[1] = new Point3D(0,(int)scale/2,(int)-scale/2);
        points[2] = new Point3D(0,-(int)scale/2,-(int)scale/2);
        points[3] = new Point3D(0,-(int)scale/2,(int)scale/2);
    }
    
    public Square(Color col,double scale){
        this.full = false;
        this.col = col;
        Point3D[] points = new Point3D[4];
        points[0] = new Point3D(0,(int)scale/2,(int)scale/2);
        points[1] = new Point3D(0,(int)scale/2,(int)-scale/2);
        points[2] = new Point3D(0,-(int)scale/2,-(int)scale/2);
        points[3] = new Point3D(0,-(int)scale/2,(int)scale/2);
    }
    
    public Square(boolean full,Color col){
        this.full = full;
        this.col = col;
        Point3D[] points = new Point3D[4];
        points[0] = new Point3D(0,1,1);
        points[1] = new Point3D(0,1,-1);
        points[2] = new Point3D(0,-1,-1);
        points[3] = new Point3D(0,-1,1);
    }
    
    public Square(boolean full,Color col,double scale){
        this.full = full;
        this.col = col;
        Point3D[] points = new Point3D[4];
        points[0] = new Point3D(0,(int)scale/2,(int)scale/2);
        points[1] = new Point3D(0,(int)scale/2,(int)-scale/2);
        points[2] = new Point3D(0,-(int)scale/2,-(int)scale/2);
        points[3] = new Point3D(0,-(int)scale/2,(int)scale/2);
    }
}
