package veterinariamotitas;

import Conexion.Conectar;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class registroP extends JFrame {
    
        
    public registroP(){
        this.setLocationRelativeTo(null); 
        main();
    }
    
    public void cerrar(){
          menuPrincipal alumn = new menuPrincipal();
          alumn.setVisible(true);
          dispose();
    }
    
       
    public void main(){
        this.setSize(800,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Registro de Cliente");
        this.setLocationRelativeTo(null);
        
        JPanel panel =new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
        JLabel text=new JLabel();
        text.setText("Registro de Cliente");
        text.setBounds(200, 50, 380, 60);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Broadway",Font.BOLD,30));
        panel.add(text);
        
        
        JLabel text1=new JLabel();
        text1.setText("Identificación: ");
        text1.setBounds(100, 100, 200, 60);
        text1.setFont(new Font("Broadway",Font.BOLD,20));
        panel.add(text1);
        
        JTextField caja = new JTextField();
        caja.setBounds(300,110,260,40);
        caja.setFont(new Font("Broadway",Font.BOLD,15));
        caja.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        caja.setBackground(Color.WHITE);
        panel.add(caja);    
        
        
        
        JLabel text2=new JLabel();
        text2.setText("Nombre: ");
        text2.setBounds(100, 150, 200, 60);
        text2.setFont(new Font("Broadway",Font.BOLD,20));
        panel.add(text2);
        
        JTextField caja1 = new JTextField();
        caja1.setBounds(300,160,260,40);
        caja1.setFont(new Font("Broadway",Font.BOLD,15));
        caja1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        caja1.setBackground(Color.WHITE);
        panel.add(caja1);
        
        
        
        JLabel text3=new JLabel();
        text3.setText("Telefono: ");
        text3.setBounds(100, 200, 200, 60);
        text3.setFont(new Font("Broadway",Font.BOLD,20));
        panel.add(text3);
        
        JTextField caja2 = new JTextField();
        caja2.setBounds(300,210,260,40);
        caja2.setFont(new Font("Broadway",Font.BOLD,15));
        caja2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        caja2.setBackground(Color.WHITE);
        panel.add(caja2);
        
        
        
        JLabel text4=new JLabel();
        text4.setText("Dirección: ");
        text4.setBounds(100, 250, 200, 60);
        text4.setFont(new Font("Broadway",Font.BOLD,20));
        panel.add(text4);
        
        JTextField caja3 = new JTextField();
        caja3.setBounds(300,260,260,40);
        caja3.setFont(new Font("Broadway",Font.BOLD,15));
        caja3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        caja3.setBackground(Color.WHITE);
        panel.add(caja3);
              
        
        
        JButton boton=new JButton();
        boton.setText("Registrar");
        boton.setBounds(500, 400, 130, 30);
        boton.setFont(new Font("Broadway",Font.BOLD,15));
        panel.add(boton);
       
         

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
                 cerrar();
            }
        });
        
        
        ActionListener oyente = new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent ae) {
                 
               Conectar conecta = new Conectar();
               Connection con = (Connection) conecta.getConexion();
               
               String numero1=caja.getText();
               String numero2=caja1.getText();
               String numero3=caja2.getText();
               String numero4=caja3.getText();
              
              
              if(numero1.equalsIgnoreCase("") || numero2.equalsIgnoreCase("") || numero3.equalsIgnoreCase("") || numero4.equalsIgnoreCase("") ){
                  JOptionPane.showMessageDialog(null, "Debe diligenciar todos los datos", "Error", JOptionPane.WARNING_MESSAGE);
              }else if(numero1.length() <= 9 || numero1.length() > 10){
                   JOptionPane.showMessageDialog(null, "Identificacion fuera de rango", "Error", JOptionPane.WARNING_MESSAGE);
              }else if(numero3.length() <= 9 || numero3.length() > 10){
                   JOptionPane.showMessageDialog(null, "Telefono fuera de rango", "Error", JOptionPane.WARNING_MESSAGE);
              }else{
                   try{
                         PreparedStatement ps = con.prepareStatement("INSERT INTO cliente (id_clien, nombre_clien, telefono, direccion) VALUES (?,?,?,?)");
                         ps.setString(1, numero1);
                         ps.setString(2, numero2);
                         ps.setString(3, numero3);
                         ps.setString(4, numero4);

                         ps.executeUpdate();
                         
                         JOptionPane.showMessageDialog(null, "Agregado Correctamente");
                         
                         cerrar();
                     }catch (Exception e){
                          System.out.println("Error al insertar ,"+e);

                     }
              }
                
            
            }
         
        };
        boton.addActionListener(oyente);
    }
    
}
