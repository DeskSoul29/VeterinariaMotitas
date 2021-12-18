package veterinariamotitas;

import Conexion.Conectar;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import static veterinariamotitas.macotaSuperior.jt1;


public class factura extends JFrame{
    
    private JPanel contentPane;
    public static javax.swing.JTable jt1;
    
    public factura(){
        this.setLocationRelativeTo(null); 
        main();
    }
    
    public void volver(){
        admin alumn = new admin();
        alumn.setVisible(true);
        dispose();
    }
    
    public  String[][] my_db_select() {
          String[][] data = new String[10][10]; // [rows][columns]
	
          try{  
               Conectar conecta = new Conectar();
               Connection con = (Connection) conecta.getConexion();

               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery("SELECT `cliente`.`nombre_clien`, `facturacion`.`tipo_fact`, `tipo_valor`.`valor_tiva`, `facturacion`.`fecha_fact`\n" +
                        "FROM `cliente` \n" +
                        "	LEFT JOIN `facturacion` ON `facturacion`.`id_cliente` = `cliente`.`id_clien` \n" +
                        "	LEFT JOIN `tipo_valor` ON `facturacion`.`tipo_valor_fact` = `tipo_valor`.`id_tiva`"
                       + "      WHERE facturacion.tipo_fact != 'NULL';");
               
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
          String[] column= {"Cliente","Tipo de Factura","Valor","Fecha"};

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
        this.setTitle("Facturación");
        this.setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.white);
        contentPane.setLayout(null);
        

        JLabel text = new JLabel();
        text.setText("Facturas");
        text.setBounds(300, 50, 400, 60);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Broadway",Font.BOLD,30));
        contentPane.add(text);
        
        
        crearTabla();
        
        JButton boton=new JButton();
        boton.setText("Nueva Factura");
        boton.setBounds(500, 280, 230, 60);
        boton.setFont(new Font("Broadway",Font.BOLD,15));
        contentPane.add(boton);
        
        boton.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                newFactura alumn = new newFactura();
                alumn.setVisible(true);
                dispose();
            }
        });

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
