/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mathtutor;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Eric Sullivan
 */
public class TestGeneral extends JPanel implements PanelTemplate{
    CardLayout cl;
    ArrayList<GeneralTestPanel> test;
    int index;
    public TestGeneral(){
       cl = new CardLayout();
       index = 0;
       setLayout(cl);
       test = new ArrayList<>();
       buildTest();
    }
    public void buildTest(){
        for(int i=0;i<6;i++){
            test.add(new GeneralTestPanel(""+i));
            add(test.get(i),""+i);
        }
    }

    @Override
    public void help() {
        test.get(index).help();
    }

    @Override
    public void back() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void next(){
        cl.next(this);
        index=(index+1)%test.size();
    }
    
    
    public class GeneralTestPanel extends JLayeredPane implements PanelTemplate{
    JPanel top,bot,questionPane,correct,wrong,help1,help2;
    ArrayList<JPanel> answerP;
    JLabel questionLabel;
    ArrayList<JLabel> answerL;
    
    public GeneralTestPanel(String s) {
        setBackground(new Color(144,210,144));
        buildTop();
        buildBot();
        buildBack();
        
        
        questionLabel.setText("Question"+s);
        
        
        add(top,Integer.valueOf(0));
        add(bot,Integer.valueOf(0));
    }
    private void buildTop() {
        top = new JPanel();
        top.setBounds(0, 0, 600, 300);
        top.setLayout(new BoxLayout(top,BoxLayout.X_AXIS));
        top.setBackground(new Color(144,210,144));
        top.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        questionPane = new JPanel();
        questionPane.setBorder(BorderFactory.createDashedBorder(Color.BLACK,10,5));
        questionPane.setBackground(Color.CYAN);
        
        top.add(Box.createRigidArea(new Dimension(10,0)));
        top.add(questionPane);
        top.add(Box.createRigidArea(new Dimension(10,0)));
        
        questionLabel = new JLabel("Question");
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        questionLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        questionPane.add(questionLabel);
        
    }

    private void buildBot() {
        GridLayout gl = new GridLayout(2,2);
        bot = new JPanel(gl);
        bot.setBounds(0,300,600,300);
        bot.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bot.setBackground(new Color(144,210,144));
        gl.setHgap(10);
        gl.setVgap(10);
        answerP = new ArrayList<>();
        answerL = new ArrayList<>();
        for(int i =0; i<4;i++){
            answerP.add(new JPanel());
            
            answerL.add(new JLabel(""+i));
            answerP.get(i).add(answerL.get(i));
            answerL.get(i).setAlignmentX(Component.CENTER_ALIGNMENT);
            answerL.get(i).setAlignmentY(Component.CENTER_ALIGNMENT);
            
            
            
            answerP.get(i).setBackground(Color.GREEN);
            answerP.get(i).setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            answerP.get(i).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            answerP.get(i).addMouseListener(new AnswerHandler());
            
            bot.add(answerP.get(i));
        }
        
        
    }
    public void buildBack(){
    correct = new JPanel();
    wrong = new JPanel();
    help1 = new JPanel();
    help2 = new JPanel();
    
    
    help1.setBackground(Color.BLUE);
    help1.setBounds(0,0,600,300);
    help1.addMouseListener(new AnswerHandler());
    help1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    
    help2.setBackground(Color.BLUE);
    help2.setBounds(0, 300, 600, 300);
    help2.addMouseListener(new AnswerHandler());
    help2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    
    correct.setBackground(Color.GREEN);
    correct.setBounds(155,70,300,150);
    correct.addMouseListener(new AnswerHandler());
    correct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    
    wrong.setBackground(Color.red);
    wrong.setBounds(155,70,300,150);
    wrong.addMouseListener(new AnswerHandler());
    wrong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    
    add(wrong, Integer.valueOf(-300));
    add(help1,Integer.valueOf(-300));
    add(correct, Integer.valueOf(-300));
    add(help2, Integer.valueOf(-300));
    
}
    @Override
    public void help() {
        setLayer(help1,300);
        setLayer(help2,300);
    }

    @Override
    public void back() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public class AnswerHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent e)  
    {  
        if(e.getSource()==answerP.get(0)){
            setLayer(wrong,300);
            repaint();
        }
        else
        if(e.getSource()==answerP.get(1)){
            setLayer(correct,300);
            repaint();
        }
        else
        if(e.getSource()==help1){
            setLayer(help1,-300);
        }
        else
        if(e.getSource()==help2){
            setLayer(help2,-300);
        }
        else
            if(e.getSource()==wrong&&getLayer(wrong)==300){
                next();
            }
        else
            if(e.getSource()==correct&&getLayer(correct)==300){
                next();
            }
        //else
           // JOptionPane.showMessageDialog(null, "Soon");

    }  
}

    

}
}
