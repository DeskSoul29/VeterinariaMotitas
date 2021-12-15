package veterinariamotitas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class historialFrame extends JFrame {

    
    public historialFrame(){
        this.setLocationRelativeTo(null); 
        main();
    }
    
    public void crearTabla(){
        
    }
    
    public void main(){
        this.setSize(800,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Historial de Visitas");
        this.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
        JLabel text = new JLabel();
        text.setText("Historial de Visitas");
        text.setBounds(200, 50, 400, 60);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Broadway",Font.BOLD,30));
        panel.add(text);
        
        
        crearTabla();
        
        
        JButton boton=new JButton();
        boton.setText("Nueva Visita");
        boton.setBounds(500, 400, 130, 30);
        boton.setFont(new Font("Broadway",Font.BOLD,15));
        panel.add(boton);
        
        boton.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                newVisit alumn = new newVisit();
                alumn.setVisible(true);
            }
        });
         

        JButton boton1=new JButton();
        boton1.setBounds(150, 380, 80, 80);
        boton1.setFont(new Font("Broadway",Font.BOLD,15));
        boton1.setBackground(Color.WHITE);
        boton1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel.add(boton1);
        
        ImageIcon back=new ImageIcon("imagenes/back.png");
        boton1.setIcon(new ImageIcon(back.getImage().getScaledInstance(80, 80,Image.SCALE_SMOOTH)));
        panel.add(boton1);
        
        boton1.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                admin alumn = new admin();
                alumn.setVisible(true);
                dispose();
            }
        });     
        
        
    }

}