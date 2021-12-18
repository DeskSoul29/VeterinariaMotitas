package veterinariamotitas;

import Conexion.Conectar;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static veterinariamotitas.registroM.caja3;


public class newVisit extends JFrame {
    
     public static JTextField caja = new JTextField();
     public static JTextField caja1 = new JTextField();
     public static String idMascota;
     
    public newVisit(){
        this.setLocationRelativeTo(null); 
        main();
    }
    
    public void main(){
        this.setSize(800,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Nueva Visita");
        this.setLocationRelativeTo(null);
        
        JPanel panel =new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
        JLabel text=new JLabel();
        text.setText("Nueva Visita");
        text.setBounds(200, 50, 380, 60);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Broadway",Font.BOLD,30));
        panel.add(text);
        
        
        JLabel text1=new JLabel();
        text1.setText("Mascota: ");
        text1.setBounds(100, 100, 200, 60);
        text1.setFont(new Font("Broadway",Font.BOLD,20));
        panel.add(text1);
        
        caja.setBounds(330,110,260,40);
        caja.setFont(new Font("Broadway",Font.BOLD,15));
        caja.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        caja.setBackground(Color.WHITE);
        caja.setEnabled(false); 
        panel.add(caja);    
        
        JButton botonS = new JButton();
        botonS.setText("Buscar");
        botonS.setBounds(590,110,120,40);
        botonS.setFont(new Font("Broadway",Font.BOLD,15));
        panel.add(botonS);
        
        botonS.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                caja.setText("");
                visitaSuperior alumn = new visitaSuperior();
                alumn.setVisible(true);
            }
        });
        
        
        JLabel text2=new JLabel();
        text2.setText("Cliente: ");
        text2.setBounds(100, 150, 200, 60);
        text2.setFont(new Font("Broadway",Font.BOLD,20));
        panel.add(text2);
        
        caja1.setBounds(330,160,260,40);
        caja1.setFont(new Font("Broadway",Font.BOLD,15));
        caja1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        caja1.setBackground(Color.WHITE);
        caja1.setEnabled(false); 
        panel.add(caja1);
        
        
        
        JLabel text3=new JLabel();
        text3.setText("Motivo: ");
        text3.setBounds(100, 200, 250, 60);
        text3.setFont(new Font("Broadway",Font.BOLD,20));
        panel.add(text3);
        
        JComboBox caja2 = new JComboBox();
        caja2.setBounds(330, 210, 260, 40);
        caja2.setBackground(Color.WHITE);
        caja2.addItem("Compras");
        caja2.addItem("Área clínica");
        caja2.addItem("Área estética");
        caja2.setBounds(330,210,260,40);
        caja2.setFont(new Font("Broadway",Font.BOLD,15));
        caja2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        caja2.setBackground(Color.WHITE);
        panel.add(caja2);
              
        
        
        JLabel text4=new JLabel();
        text4.setText("Se Genero el Turno: ");
        text4.setBounds(330,260,260,40);
        text4.setFont(new Font("Broadway",Font.BOLD,20));
        panel.add(text4);
        
        JTextField caja3 = new JTextField();
        caja3.setBounds(590,260,120,40);
        caja3.setFont(new Font("Broadway",Font.BOLD,15));
        caja3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        caja3.setBackground(Color.WHITE);
        caja3.setEnabled(false); 
        panel.add(caja3);
        
        JButton botonGt = new JButton();
        botonGt.setBounds(100, 250, 180, 60);
        botonGt.setText("Generar turno");
        botonGt.setFont(new Font("Broadway",Font.BOLD,15));
        panel.add(botonGt);
        
                
        
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

                caja.setText("");
                caja1.setText("");
                dispose();
            }
        });
        
        ActionListener oyente = new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent ae) {
               Conectar conecta = new Conectar();
               Connection con = (Connection) conecta.getConexion();
                
               String numero1 = idMascota;
               String numero2 = caja3.getText();
               System.out.println(numero1);
               System.out.println(numero2);
              
              if(numero1.equalsIgnoreCase("") || numero2.equalsIgnoreCase("") ){
                  JOptionPane.showMessageDialog(null, "Debe diligenciar todos los datos");
              }else{
                  try{
                         PreparedStatement ps = con.prepareStatement("INSERT INTO historial (id_mascota_hist, turno_hist) VALUES (?,?)");
                         ps.setString(1, numero1);
                         ps.setString(2, numero2);

                         ps.executeUpdate();
                         
                         JOptionPane.showMessageDialog(null, "Agregado Correctamente");
                         historialVisitas alumn = new historialVisitas();
                         alumn.setVisible(true);
                         dispose();

                     }catch (Exception e){
                          System.out.println("Error al insertar, "+e);

                     }
              }
                
            
            }
         
        };
        ActionListener oyente2 = new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent ae) {
                 Random numAleatorio = new Random();
                 int n = numAleatorio.nextInt(200-25+1) + 25;
                 
                 
                 caja3.setText(""+n);
            }
         
        };
        boton.addActionListener(oyente);
        botonGt.addActionListener(oyente2);
    }
}