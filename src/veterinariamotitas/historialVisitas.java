package veterinariamotitas;

import Conexion.Conectar;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import static veterinariamotitas.visitaSuperior.jt1;

public class historialVisitas extends JFrame {

     private JPanel contentPane;
     public static javax.swing.JTable jt1;
    
    public historialVisitas(){
        this.setLocationRelativeTo(null); 
        main();
    }
    
    public  String[][] my_db_select() {
          String[][] data = new String[10][10]; // [rows][columns]
	
          try{  
               Conectar conecta = new Conectar();
               Connection con = (Connection) conecta.getConexion();

               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery("SELECT `cliente`.`nombre_clien`, `mascota`.`nombre_masc`, `historial`.`turno_hist`, `historial`.`fecha_hist`\n" +
                            "FROM `historial` \n" +
                            "	LEFT JOIN `mascota` ON `historial`.`id_mascota_hist` = `mascota`.`id_masc` \n" +
                            "	LEFT JOIN `cliente` ON `mascota`.`id_prop` = `cliente`.`id_clien`;");
               
               int i=0;
               
               while(rs.next())  {
                    for(int j=0;j<4;j++) {
                         data[i][j]=rs.getString(j+1);
                    }
                    i=i+1;
               }
          con.close();  
          }catch(Exception e){ 
               System.out.println(e);
          } 

          return data;
     }
    
   public void crearTabla(){
          JScrollPane scrollPane = new JScrollPane();
          scrollPane.setBounds(200, 164, 366, 107);
          contentPane.add(scrollPane);
          String[] column = {"Propietario","Mascota","Turno","Fecha"};

          jt1 = new JTable(my_db_select(),column);
          jt1.setBounds(200, 50, 400, 60);
          scrollPane.setViewportView(jt1);
     }
    
    public void main(){
        this.setSize(800,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Historial de Visitas");
        this.setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.white);
        contentPane.setLayout(null);
        
        
        JLabel text = new JLabel();
        text.setText("Historial de Visitas");
        text.setBounds(200, 50, 400, 60);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Broadway",Font.BOLD,30));
        contentPane.add(text);
        
        
        crearTabla();
        
        JButton boton=new JButton();
        boton.setText("Nueva Visita");
        boton.setBounds(500, 400, 230, 60);
        boton.setFont(new Font("Broadway",Font.BOLD,15));
        contentPane.add(boton);
        
        boton.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                newVisit alumn = new newVisit();
                alumn.setVisible(true);
                dispose();
            }
        });
         

        JButton boton1=new JButton();
        boton1.setBounds(150, 380, 80, 80);
        boton1.setFont(new Font("Broadway",Font.BOLD,15));
        boton1.setBackground(Color.WHITE);
        boton1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        contentPane.add(boton1);
        
        ImageIcon back=new ImageIcon("imagenes/back.png");
        boton1.setIcon(new ImageIcon(back.getImage().getScaledInstance(80, 80,Image.SCALE_SMOOTH)));
        contentPane.add(boton1);
        
        boton1.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                admin alumn = new admin();
                alumn.setVisible(true);
                dispose();
            }
        });     
        
        
    }

}