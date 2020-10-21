import java.awt.Color;
import java.util.*;

public class Bodies{
    private String name;
    private double mass;
    private int x;
    private int y;
    private double velX;
    private double velY;
    private String size;
    private Color color;
    private Random random;
    private double forceX;
    private double forceY;
    public Bodies(String name, String mass, String x, String y, String velX, String velY, String size){
        this.name = name;
        this.mass = Double.parseDouble(mass);
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
        this.velX = Double.parseDouble(velX);
        this.velY = Double.parseDouble(velY);
        this.size = size.substring(1, size.length());
        random = new Random();
        color = new Color (random.nextInt(256), random.nextInt(256), random.nextInt(256)); //creates a new color for each body
    }
    public double getMass(){
        return mass;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public double getVelX(){
        return velX;
    }
    public double getVelY(){
        return velY;
    }
    public int getSize(){
        return Integer.parseInt(size);
    }
    public void printBodies(){
        System.out.println(name + ", " + mass + ", " + x + ", " + y + ", " + velX + ", " + velY + ", " + size);
    }
    public Color getColor(){
        return color;
    }
    //Finds the force of the body based off of another body 
    public void force(Bodies b, double scale){
        Bodies a = this;
        double dx = b.x - a.x;
        double dy = b.y - a.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        double f = (6.673e-11 * a.mass * b.mass / ((distance * distance) / scale));
        a.forceX += f * dx / distance;
        a.forceY += f * dy / distance;

    }
    public void reset(){
        forceX = 0.0;
        forceY = 0.0;
    }
    //Updates the position of the body creating the "animation"
    public void updatePos(){
        velX += forceX / mass;
        velY += forceY / mass;
        x += velX;
        y += velY;
    }
}