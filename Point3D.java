public class Point3D
{
    public double x,y,z;
    
    public Point3D(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void translate(double x,double y,double z){
        this.x += x;
        this.y += y;
        this.z += z;
    }
    
    public void rotateX(int x){
        double angleSin = 0;
        double angleCos = 0;
        if (y != 0){
            angleSin = Math.sin(Math.toRadians(x));
            angleCos = Math.cos(Math.toRadians(x));
            double newY = this.y * angleCos - this.z * angleSin;
            double newZ = this.y * angleSin + this.z * angleCos;
            this.y = newY;
            this.z = newZ;
        }
    }

    public void rotateY(int y){
        double angleSin = 0;
        double angleCos = 0;
        if (y != 0){
            angleSin = Math.sin(Math.toRadians(y));
            angleCos = Math.cos(Math.toRadians(y));
            double newX = this.x * angleCos - this.z * angleSin;
            double newZ = this.x * angleSin + this.z * angleCos;
            this.x = newX;
            this.z = newZ;
        }
    }

    public void rotateZ(int z){
        double angleSin = 0;
        double angleCos = 0;
        if (z != 0){
            angleSin = Math.sin(Math.toRadians(z));
            angleCos = Math.cos(Math.toRadians(z));
            double newY = this.y * angleCos - this.x * angleSin;
            double newX = this.y * angleSin + this.x * angleCos;
            this.y = newY;
            this.x = newX;
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
