import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class ColorGrid extends JPanel
{
    public static int CAMDISTANCE = 4;
    public int WIDTH;
    public int HEIGHT;
    public int SCALE;
    public ArrayList<Polygon3D> world;
    private int depthMultiplier = 100; 
    private Graphics2D mod;
    private BufferedImage grid; 

    public ColorGrid(int width,int height){
        this.WIDTH = width;
        this.HEIGHT = height;
        this.SCALE = 1;
        this.world = new ArrayList<Polygon3D>();
        this.grid = new BufferedImage(
            this.WIDTH,
            this.HEIGHT,
            BufferedImage.TYPE_INT_RGB);
        this.mod=(Graphics2D) this.grid.getGraphics();
        repaint();
    }

    public ColorGrid(int width,int height, int scale){
        this.WIDTH = width;
        this.HEIGHT = height;
        this.SCALE = scale;
        this.world = new ArrayList<Polygon3D>();
        this.grid=new BufferedImage(
            this.WIDTH * scale,
            this.HEIGHT * scale,
            BufferedImage.TYPE_INT_RGB);
        this.mod=(Graphics2D) this.grid.getGraphics();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(
            grid,
            0,0,
            this.WIDTH,this.HEIGHT,
            null);
    }

    public void setPixel(int x,int y,int rgb){
        this.mod.setColor(new Color(rgb));
        this.mod.fillRect(x,y,1,1);
        repaint();
    }

    public Graphics2D getG2D(){
        return mod;
    }

    public void addToGrid(Polygon3D poly){
        this.world.add(poly);
    }

    public void addToGrid(Mesh3D mesh){
        for (int i = 0; i < mesh.polygons.length; i++){
            this.world.add(mesh.polygons[i]);
        }
    }

    public void removeFromGrid(Polygon3D poly){
        this.world.remove(poly);
    }

    public void removeFromGrid(Mesh3D mesh){
        for (int i = 0; i < mesh.polygons.length; i++){
            this.world.remove(mesh.polygons[i]);
        }
    }

    public Point orthographicPoint(Point3D point){
        return new Point(
            (int)(this.WIDTH/2 + point.y),
            (int)(this.HEIGHT/2 + point.z));
    }

    public void renderOrthoPolygon3D(Color col,boolean full,Polygon3D poly){
        Polygon object = new Polygon();
        Point temp;
        for (int i = 0; i < poly.points.length; i++){
            temp = orthographicPoint(poly.getPoint3D(i));
            object.addPoint(temp.x,temp.y);
        }
        this.mod.setColor(col);
        if (full)
            this.mod.fillPolygon(object);
        else
            this.mod.drawPolygon(object);
        repaint();
    }

    public Point perspectivePoint(Point3D point){
        double x3D = point.y;
        double y3D = point.z;
        double z3D = point.x;
        double[] persp = new double[3];
        double camDisplacement = CAMDISTANCE - z3D;
        double localScale = Math.abs(depthMultiplier/(camDisplacement+depthMultiplier));
        double newX = x3D * localScale;
        double newY = y3D * localScale;
        int x2D = (int)(this.WIDTH/2 + newX);
        int y2D = (int)(this.HEIGHT/2 - newY);
        return new Point(x2D,y2D);
    }

    private void renderPerspPolygon3D(Polygon3D poly){
        Point temp;
        Polygon object = new Polygon();
        for (Point3D p : poly.points){
            if (p.x>CAMDISTANCE){
                temp = perspectivePoint(p);
                object.addPoint(temp.x,temp.y);
            }
        }
        this.mod.setColor(poly.col);
        if (poly.full)
            this.mod.fillPolygon(object);
        else
            this.mod.drawPolygon(object);
        repaint();
    }

    public void render(){
        this.mod.setColor(Color.BLACK);
        this.mod.fillRect(0,0,WIDTH,HEIGHT);
        Collections.sort(this.world,new Comparator<Polygon3D>(){
            @Override
            public int compare(Polygon3D poly1,Polygon3D poly2){
                if (poly1.getClosestX() - poly2.getClosestX() < 0)
                    return 1;
                else
                    return -1;
            }
            
        });
        for (int i = 0; i < this.world.size(); i++){
            renderPerspPolygon3D((Polygon3D)this.world.get(i));
        }
    }
}