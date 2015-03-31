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
public class GeneralTestPanel extends JLayeredPane implements PanelTemplate{
    JPanel top,bot,questionPane,correct,wrong;;//,help1,help2,
    ArrayList<JPanel> answerP;
    JLabel questionLabel;
    ArrayList<JLabel> answerL;
    
    public GeneralTestPanel() {
        setBackground(new Color(144,210,144));
        buildTop();
        buildBot();
        buildBack();
        add(top,Integer.valueOf(0));
        add(bot,Integer.valueOf(0));
    }
    private void buildTop() {
        top = new JPanel();
        top.setBounds(0, 0, 620, 300);
        top.setLayout(new BoxLayout(top,BoxLayout.X_AXIS));
        top.setBackground(new Color(144,210,144));
        top.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
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
        bot.setBounds(0,300,620,265);
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
    correct.setBackground(Color.GREEN);
    correct.setBounds(155,70,300,150);
    wrong.setBackground(Color.red);
    wrong.setBounds(155,70,300,150);
    add(wrong, Integer.valueOf(-300));
    add(correct, Integer.valueOf(-300));
    
}
    @Override
    public void help() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void back() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public class AnswerHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent e)  
    {  
        if(e.getSource()==answerP.get(0)){
            System.out.println("failed");
            setLayer(wrong,300);
            repaint();
        }
        else
        if(e.getSource()==answerP.get(1)){
            setLayer(correct,300);
            repaint();
        }
        else
            JOptionPane.showMessageDialog(null, "Soon");

    }  
}

    

}
