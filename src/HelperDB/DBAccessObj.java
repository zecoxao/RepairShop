/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperDB;

//import java.io.*;
import java.sql.*;
//import oracle.jdbc.*;

public class DBAccessObj{
       private Connection conn;


       public DBAccessObj()
       {
              this.createDBConnection();
       }

       private void createDBConnection()
       {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            }
            catch(ClassNotFoundException e) {
                System.out.println("Oops! Can't find class oracle.jdbc.driver.OracleDriver");
                //System.exit(1);
            }
            try{
                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "zecoxao","invisible");
                //conn.setAutoCommit(false);
            }
            catch(Exception e){
                System.out.println("ERRO " + e.getMessage());
                //javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
       }

       public Statement createStatement()
       {
          Statement st=null;
          if(this.conn==null)
              this.createDBConnection();
          try{
              st = this.conn.createStatement();
              }
          catch(Exception e){
              System.out.println("ERRO " + e.getMessage());
              //javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO", javax.swing.JOptionPane.ERROR_MESSAGE);
          }
          return st;
       }

       public Connection openConnection()
       {
           if(this.conn==null)
              this.createDBConnection();
           else{
               try{
                   if (this.conn.isClosed())
                       this.createDBConnection();
               }
               catch(Exception e){
                   System.out.println("ERRO " + e.getMessage());
               }
           }

           return this.conn;
       }

       public void executeSQL(String SqlComm)
       {
        Statement st = this.createStatement();
        try{
              st.execute(SqlComm);
              }
          catch(Exception e){
              System.out.println("ERRO " + e.getMessage());
              //javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO", javax.swing.JOptionPane.ERROR_MESSAGE);
          }

       }

       public ResultSet executeQuery(String SqlComm)
       {
          Statement st = this.createStatement();
          ResultSet rs=null;

          try{
              rs = st.executeQuery(SqlComm);
          }
          catch(Exception e){
              System.out.println("ERRO " + e.getMessage());
              //javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO", javax.swing.JOptionPane.ERROR_MESSAGE);
          }
          return rs;
       }

    public ResultSet executeQueryNavigate(String SqlComm)
       {
          Statement st = null;
          ResultSet rs=null;

          try{
              st = this.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                     ResultSet.CONCUR_READ_ONLY);
              rs = st.executeQuery(SqlComm);
          }
          catch(Exception e){
              System.out.println("ERRO " + e.getMessage());
              //javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO", javax.swing.JOptionPane.ERROR_MESSAGE);
          }
          return rs;
       }

       public void closeConnection()
       {
              if(this.conn!=null)
              {
                  try{
                   this.conn.close();
                   }
                   catch(Exception e){
                       System.out.println("ERRO " + e.getMessage());
                       //javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO", javax.swing.JOptionPane.ERROR_MESSAGE);
                   }
              }
       }
}
