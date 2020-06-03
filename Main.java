import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(){
        JavaBox window = new JavaBox(800,600,true);
        window.isVisible(true);
        window.addGrid();
        Cube3D cube1 = new Cube3D(100,Color.BLUE);
        cube1.translate(60,0,0);
        window.getGrid().addToGrid(cube1);
        Cube3D cube2 = new Cube3D(100,Color.BLUE);
        cube2.translate(100,0,0);
        window.getGrid().addToGrid(cube2);
        int multiplier = 1;
        int count = 0;
        long x = System.nanoTime();
        while (1==1){
            if (System.nanoTime()>(x + 1000000000/60)){
                x = System.nanoTime();
                cube1.rotateZ(1,new Point3D(80,0,0));
                if(cube1.getColor(0) == Color.BLUE)
                    cube1.setColor(Color.RED);
                else
                    cube1.setColor(Color.BLUE);
                cube2.translate(0,0,multiplier);
                count += multiplier;
                if (count>=100 || count<= -100){
                    multiplier *= -1;
                    cube2.rotateZ(5,new Point3D(100,0,0));
                }
                window.getGrid().render();
            }
        }
    }
}