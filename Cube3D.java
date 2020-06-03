import java.awt.*;

public class Cube3D extends Mesh3D
{
    public Cube3D(double scale){
        Point3D[] points = new Point3D[8];
        points[0] = new Point3D((int)scale/2,(int)scale/2,(int)scale/2);
        points[1] = new Point3D((int)scale/2,(int)scale/2,(int)-scale/2);
        points[2] = new Point3D((int)scale/2,-(int)scale/2,-(int)scale/2);
        points[3] = new Point3D((int)scale/2,-(int)scale/2,(int)scale/2);
        points[4] = new Point3D(-(int)scale/2,(int)scale/2,(int)scale/2);
        points[5] = new Point3D(-(int)scale/2,(int)scale/2,(int)-scale/2);
        points[6] = new Point3D(-(int)scale/2,-(int)scale/2,-(int)scale/2);
        points[7] = new Point3D(-(int)scale/2,-(int)scale/2,(int)scale/2);
        Polygon3D[] polygons = new Polygon3D[6];
        polygons[0] = new Polygon3D(points[0],points[1],points[2],points[3]);
        polygons[1] = new Polygon3D(points[0],points[4],points[5],points[1]);
        polygons[2] = new Polygon3D(points[1],points[5],points[6],points[2]);
        polygons[3] = new Polygon3D(points[2],points[6],points[7],points[3]);
        polygons[4] = new Polygon3D(points[0],points[4],points[7],points[3]);
        polygons[5] = new Polygon3D(points[4],points[5],points[6],points[7]);
        this.polygons = polygons;
    }
    
    public Cube3D(double scale,Color col){
        Point3D[] points = new Point3D[8];
        points[0] = new Point3D((int)scale/2,(int)scale/2,(int)scale/2);
        points[1] = new Point3D((int)scale/2,(int)scale/2,(int)-scale/2);
        points[2] = new Point3D((int)scale/2,-(int)scale/2,-(int)scale/2);
        points[3] = new Point3D((int)scale/2,-(int)scale/2,(int)scale/2);
        points[4] = new Point3D(-(int)scale/2,(int)scale/2,(int)scale/2);
        points[5] = new Point3D(-(int)scale/2,(int)scale/2,(int)-scale/2);
        points[6] = new Point3D(-(int)scale/2,-(int)scale/2,-(int)scale/2);
        points[7] = new Point3D(-(int)scale/2,-(int)scale/2,(int)scale/2);
        Polygon3D[] polygons = new Polygon3D[6];
        polygons[0] = new Polygon3D(col,points[0],points[1],points[2],points[3]);
        polygons[1] = new Polygon3D(col,points[0],points[4],points[5],points[1]);
        polygons[2] = new Polygon3D(col,points[1],points[5],points[6],points[2]);
        polygons[3] = new Polygon3D(col,points[2],points[6],points[7],points[3]);
        polygons[4] = new Polygon3D(col,points[0],points[4],points[7],points[3]);
        polygons[5] = new Polygon3D(col,points[4],points[5],points[6],points[7]);
        this.polygons = polygons;
    }
    
    public Cube3D(double scale,Color col,boolean full){
        Point3D[] points = new Point3D[8];
        points[0] = new Point3D((int)scale/2,(int)scale/2,(int)scale/2);
        points[1] = new Point3D((int)scale/2,(int)scale/2,(int)-scale/2);
        points[2] = new Point3D((int)scale/2,-(int)scale/2,-(int)scale/2);
        points[3] = new Point3D((int)scale/2,-(int)scale/2,(int)scale/2);
        points[4] = new Point3D(-(int)scale/2,(int)scale/2,(int)scale/2);
        points[5] = new Point3D(-(int)scale/2,(int)scale/2,(int)-scale/2);
        points[6] = new Point3D(-(int)scale/2,-(int)scale/2,-(int)scale/2);
        points[7] = new Point3D(-(int)scale/2,-(int)scale/2,(int)scale/2);
        Polygon3D[] polygons = new Polygon3D[6];
        polygons[0] = new Polygon3D(full,col,points[0],points[1],points[2],points[3]);
        polygons[1] = new Polygon3D(full,col,points[0],points[4],points[5],points[1]);
        polygons[2] = new Polygon3D(full,col,points[1],points[5],points[6],points[2]);
        polygons[3] = new Polygon3D(full,col,points[2],points[6],points[7],points[3]);
        polygons[4] = new Polygon3D(full,col,points[0],points[4],points[7],points[3]);
        polygons[5] = new Polygon3D(full,col,points[4],points[5],points[6],points[7]);
        this.polygons = polygons;
    }
    
    public Cube3D(double scale,boolean full){
        Point3D[] points = new Point3D[8];
        points[0] = new Point3D((int)scale/2,(int)scale/2,(int)scale/2);
        points[1] = new Point3D((int)scale/2,(int)scale/2,(int)-scale/2);
        points[2] = new Point3D((int)scale/2,-(int)scale/2,-(int)scale/2);
        points[3] = new Point3D((int)scale/2,-(int)scale/2,(int)scale/2);
        points[4] = new Point3D(-(int)scale/2,(int)scale/2,(int)scale/2);
        points[5] = new Point3D(-(int)scale/2,(int)scale/2,(int)-scale/2);
        points[6] = new Point3D(-(int)scale/2,-(int)scale/2,-(int)scale/2);
        points[7] = new Point3D(-(int)scale/2,-(int)scale/2,(int)scale/2);
        Polygon3D[] polygons = new Polygon3D[6];
        polygons[0] = new Polygon3D(full,points[0],points[1],points[2],points[3]);
        polygons[1] = new Polygon3D(full,points[0],points[4],points[5],points[1]);
        polygons[2] = new Polygon3D(full,points[1],points[5],points[6],points[2]);
        polygons[3] = new Polygon3D(full,points[2],points[6],points[7],points[3]);
        polygons[4] = new Polygon3D(full,points[0],points[4],points[7],points[3]);
        polygons[5] = new Polygon3D(full,points[4],points[5],points[6],points[7]);
        this.polygons = polygons;
    }
}