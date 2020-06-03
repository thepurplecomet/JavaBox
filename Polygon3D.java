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

    public Point3D medianPoint(){
        int x = 0;
        int y = 0;
        int z = 0;
        for (Point3D p : this.points){
            x += p.x;
            y += p.y;
            z += p.z;
        }
        return new Point3D(x/this.points.length,y/this.points.length,z/this.points.length);
    }

    public void translate(double x,double y,double z){
        for (Point3D p : this.points){
            p.translate(x,y,z);
        }
    }

    public void rotateX(int x){
        for (Point3D p : points){
            p.rotateX(x);
        }
    }

    public void rotateY(int y){
        for (Point3D p : points){
            p.rotateY(y);
        }
    }

    public void rotateZ(int z){
        for (Point3D p : points){
            p.rotateZ(z);
        }
    }

    public void rotateX(int x,Point3D pivot){
        translate(-pivot.x,-pivot.y,-pivot.z);
        rotateX(x);
        translate(pivot.x,pivot.y,pivot.z);
    }

    public void rotateY(int y,Point3D pivot){
        translate(-pivot.x,-pivot.y,-pivot.z);
        rotateY(y);
        translate(pivot.x,pivot.y,pivot.z);
    }

    public void rotateZ(int z,Point3D pivot){
        translate(-pivot.x,-pivot.y,-pivot.z);
        rotateZ(z);
        translate(pivot.x,pivot.y,pivot.z);
    }
}