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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class macotaSuperior extends JFrame {
     
     private JPanel contentPane;
     public static javax.swing.JTable jt1;
     
                    
     
     public macotaSuperior(){
          this.setLocationRelativeTo(null); 
          main();
     }
     
          
     public void volver(){

          dispose();
     }
     
     public  String[][] my_db_select() {
          String[][] data = new String[10][10]; // [rows][columns]
	
          try{  
               Conectar conecta = new Conectar();
               Connection con = (Connection) conecta.getConexion();

               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery("SELECT * FROM cliente");
               
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
          String[] column= {"Cedula","Nombre","Telefono","Direccion"};

          jt1 = new JTable(my_db_select(),column);
         
          setEventoMouseClicked(jt1);
          scrollPane.setViewportView(jt1);
     }
     
     private void setEventoMouseClicked(JTable tbl){
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
 
        @Override
        public void mouseClicked(MouseEvent e) {
             tblEjemploMouseClicked(e, tbl);
        }
        });
    }
     
     public void tblEjemploMouseClicked(java.awt.event.MouseEvent evt, JTable jtl) {
 
       String cadena="";
       try{
            
          int fila = jtl.getSelectedRow();
          String name;


          name = jtl.getValueAt(fila, 0).toString();

          registroM.caja3.setText(name);
           volver();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
       }
 
        
    }
     
     public void main(){
        this.setSize(800,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Clientes");
        this.setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.white);
        contentPane.setLayout(null);
        

        JLabel text = new JLabel();
        text.setText("Clientes");
        text.setBounds(300, 50, 400, 60);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Broadway",Font.BOLD,30));
        contentPane.add(text);
        
        
        crearTabla();
               

        JButton boton1=new JButton();
        boton1.setBounds(80, 280, 80, 80);
        boton1.setFont(new Font("Broadway",Font.BOLD,15));
        boton1.setBackground(Color.WHITE);
        boton1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        contentPane.add(boton1);
        
        ImageIcon back=new ImageIcon("imagenes/back.png");
        boton1.setIcon(new ImageIcon(back.getImage().getScaledInstance(80, 80,Image.SCALE_SMOOTH)));
        contentPane.add(boton1);
        
        boton1.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                 volver();
            }
        });     
        
        
    
     }


}
