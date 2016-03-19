/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperDB;

//import java.io.*;
import java.sql.*;
//import oracle.jdbc.*;

public class DBAccessObjT{
       private Connection conn;
       private Statement st;


       public DBAccessObjT()
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
                System.exit(1);
            }
            try{
                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "libraryuser","libraryuser");
                //conn.setAutoCommit(false);
            }
            catch(Exception e){
                System.out.println("ERRO " + e.getMessage());
                //javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
       }

//       public Statement createStatement()
//       {
//          Statement st=null;
//          if(this.conn==null)
//              this.createDBConnection();
//          try{
//              st = this.conn.createStatement();
//              }
//          catch(Exception e){
//              System.out.println("ERRO " + e.getMessage());
//              //javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO", javax.swing.JOptionPane.ERROR_MESSAGE);
//          }
//          return st;
//       }

       public Connection openConnection()
       {
           if(this.conn==null)
              this.createDBConnection();
           return this.conn;
       }

       public void beginTran()
       {
          st=null;
          if(this.conn==null)
              this.createDBConnection();
          try{
              this.conn.setAutoCommit(false);
              st = this.conn.createStatement();
              }
          catch(Exception e){
              System.out.println("ERRO " + e.getMessage());
              javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO", javax.swing.JOptionPane.ERROR_MESSAGE);
          }
       }


       public void executeSQL(String SqlComm)
       {
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

       public void endTran()
       {
              if(this.conn!=null)
              {
                  try{
                      this.conn.commit();
                       this.conn.close();
                   }
                   catch(Exception e){
                       System.out.println("ERRO " + e.getMessage());
                       //javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO", javax.swing.JOptionPane.ERROR_MESSAGE);
                   }
              }
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
