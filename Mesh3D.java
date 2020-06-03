import java.awt.*;

public class Mesh3D
{
    public Polygon3D[] polygons;
    public Point3D origin;

    public Mesh3D(Polygon3D... polys){
        this.polygons = polys;
        origin = new Point3D(0,0,0);
    }

    public Color getColor(int index){
        return this.polygons[index].col;
    }
    
    public void setColor(Color col){
        for(Polygon3D p : this.polygons){
            p.col = col;
        }
    }

    public void setColor(Color col,int index){
        this.polygons[index].col = col;
    }

    public Point3D medianPoint(){
        int x = 0;
        int y = 0;
        int z = 0;
        for(Polygon3D p : this.polygons){
            x += p.medianPoint().x;
            y += p.medianPoint().y;
            x += p.medianPoint().z;
        }
        return new Point3D(x/polygons.length,y/polygons.length,z/polygons.length);
    }

    public void translate(double x,double y,double z){
        for (Polygon3D p : this.polygons){
            p.translate(x,y,z);
        }
        this.origin.x += x;
        this.origin.y += y;
        this.origin.z += z;
    }

    public void rotateX(int x){
        for (Polygon3D p : this.polygons){
            p.rotateX(x);
        }
        this.origin.rotateX(x);
    }

    public void rotateY(int y){
        for (Polygon3D p : this.polygons){
            p.rotateY(y);
        }
        this.origin.rotateY(y);
    }

    public void rotateZ(int z){
        for (Polygon3D p : this.polygons){
            p.rotateZ(z);
        }
        this.origin.rotateZ(z);
    }

    public void rotateX(int x,Point3D pivot){
        translate(-pivot.x,-pivot.y,-pivot.z);
        rotateX(x);
        translate(pivot.x,pivot.y,pivot.z);
        this.origin.rotateX(x,pivot);
    }

    public void rotateY(int y,Point3D pivot){
        translate(-pivot.x,-pivot.y,-pivot.z);
        rotateY(y);
        translate(pivot.x,pivot.y,pivot.z);
        this.origin.rotateY(y,pivot);
    }

    public void rotateZ(int z,Point3D pivot){
        translate(-pivot.x,-pivot.y,-pivot.z);
        rotateZ(z);
        translate(pivot.x,pivot.y,pivot.z);
        this.origin.rotateZ(z,pivot);
    }
}