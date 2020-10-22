import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class NBody extends JPanel implements ActionListener{
    private final static int maxX = 768;
    private final static int maxY = 768;
    private List<Bodies> list;
    private double scale;
    private double force;
    private double totalMass;
    public NBody(List<Bodies> new_list, double new_scale){
        list = new_list;
        scale = new_scale;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Timer tm = new Timer(500, this);
       
        try{
            for (int i = 0; i < list.size(); i++){ //creates the celestial bodies 
                g.setColor(list.get(i).getColor());
                g.fillOval(list.get(i).getX(), list.get(i).getY(), list.get(i).getSize(), list.get(i).getSize());
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        tm.start();
    }

    public void actionPerformed(ActionEvent a){
        update();
        repaint();
    }

    public void update(){
        try{    //updates the position of the celestial bodies so that it moves 
            int i;
            for(i = 0; i < list.size() - 1; i++){
                list.get(i).force(list.get(i + 1), scale);
                list.get(i).updatePos();
                list.get(i).reset();
            }
            if(list.size() > 1){    //makes sure last body is accounted for 
                list.get(i).force(list.get(i - 1), scale);
                list.get(i).updatePos();
                list.get(i).reset();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{

        List<Bodies> temp_list = null;
        double temp_scale = 0;
        File input = new File(args[0]);
        try{
            Scanner scan = new Scanner(input);
            String type = scan.nextLine();
            if(type.equals("ArrayList")){ //creates arraylist if input is ArrayList
                temp_list = new ArrayList<Bodies>();
            }
            else if(type.equals("LinkedList")){ //creates linkedlist if input is LinkedList 
                temp_list = new LinkedList<Bodies>();
            }
            else{
                throw new Exception("Invalid List Type. Try again");
            }

            temp_scale = Double.parseDouble(scan.nextLine());
            scan.useDelimiter(",");
            while (scan.hasNext()){ //instantiates a list of celestial bodies 
                temp_list.add(new Bodies(scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.nextLine()));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        NBody nBody = new NBody(temp_list, temp_scale);
        JFrame jf = new JFrame();
        jf.setTitle("N_Bodies");
        jf.setSize(nBody.maxX, nBody.maxY); // Window size defined in the class
        jf.add(nBody); // This appears below "setVisible" in the video
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
