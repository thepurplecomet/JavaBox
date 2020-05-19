import java.awt.*; 
import javax.swing.*;

public class JavaBox
{
    private JFrame box;
    private ColorGrid mainGrid;
    private int WIDTH;
    private int HEIGHT;
    private boolean closeOnX;
    private boolean visible;
    private boolean resizable;
    private boolean gridInit=false;
    JavaBox(int width,int height){
        this.WIDTH=width;
        this.HEIGHT=height;
        this.box=new JFrame("box");
        this.box.setSize(width,height);
        this.box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.closeOnX=true;
        this.box.setResizable(false);
        this.resizable = false;
        this.box.setVisible(true);
        this.visible=true;
    }

    JavaBox(int width,int height,boolean vis){
        this.WIDTH=width;
        this.HEIGHT=height;
        this.box=new JFrame("box");
        this.box.setSize(width,height);
        this.box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.closeOnX=true;
        if (vis){
            this.box.setVisible(true);
            this.visible=true;
        }
        else{
            this.box.setVisible(false);
            this.visible=false;
        }
    }
    
    public JFrame getFrame(){
        return this.box;
    }
    
    public ColorGrid getGrid(){
        return this.mainGrid;
    }

    public void isVisible(){
        this.box.setVisible(true);
        this.visible=true;
    }

    public void isVisible(boolean factor){
        this.box.setVisible(factor);
        this.visible=factor;
    }

    public void setLocation(int x, int y){
        this.box.setLocation(x,y);
    }

    public void isResizable(){
        this.box.setResizable(true);
        this.resizable=true;
    }
    
    public void addGrid(){
        this.mainGrid=new ColorGrid(this.WIDTH,this.HEIGHT);
        this.box.add(this.mainGrid);
        if (this.visible){
            this.box.setVisible(true);
            this.visible=true;
        }
        gridInit=true;
    }
    
    public void addGrid(int scale){
        this.mainGrid=new ColorGrid(this.WIDTH,this.HEIGHT,scale);
        this.box.add(this.mainGrid);
        if (this.visible){
            this.box.setVisible(true);
            this.visible=true;
        }
        gridInit=true;
    }
}
