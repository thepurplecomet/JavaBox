import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(){
        JavaBox window = new JavaBox(400,400,true);
        window.isVisible(true);
        window.addGrid();
        Cube3D cube1 = new Cube3D(100,Color.BLUE,false);
        window.getGrid().addToGrid(cube1);
        window.getGrid().render();
    }
}