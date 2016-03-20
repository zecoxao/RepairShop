/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReparacaoBLL;

import HelperDB.DBAccessObj;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author zecoxao
 */
public class AvariaCliente {
    //cliente,avaria,data_entrega,reparacao,data_reparacao
    
    
    private int avaria;
    private int cliente;
    private java.sql.Date data_entrega;
    private int reparacao;
    private java.sql.Date data_reparacao;
    private DBAccessObj dbo;

    public int getAvaria() {
        return avaria;
    }

    public void setAvaria(int avaria) {
        this.avaria = avaria;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
    
    public AvariaCliente() {
        this.dbo = new DBAccessObj();
        this.dbo.openConnection();
    }

    public AvariaCliente(DBAccessObj dbo) {
        this.dbo = dbo;
        this.dbo.openConnection();
    }

    public Date getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    public int getReparacao() {
        return reparacao;
    }

    public void setReparacao(int reparacao) {
        this.reparacao = reparacao;
    }

    public Date getData_reparacao() {
        return data_reparacao;
    }

    public void setData_reparacao(Date data_reparacao) {
        this.data_reparacao = data_reparacao;
    }
    
    public void create() throws SQLException{
        String sqlCommand = "INSERT INTO Avaria_Cliente (cliente,avaria,data_entrega,reparacao,data_reparacao) VALUES('" + this.cliente + "', '" + this.avaria + "', to_date('" + this.data_entrega + "','yyyy-MM-dd') , '" + this.reparacao + "', to_date('" + this.data_reparacao + "','yyyy-MM-dd'))";
        String sqlCommandNoRepair = "INSERT INTO Avaria_Cliente (cliente,avaria,data_entrega,reparacao) VALUES('" + this.cliente + "', '" + this.avaria + "', to_date('" + this.data_entrega + "','yyyy-MM-dd') , '" + this.reparacao + "')";
        
        if(this.getReparacao()==0){
            sqlCommand=sqlCommandNoRepair;
        }
        
        //this.dbo.beginTran();
        this.dbo.executeSQL(sqlCommand);
        //this.dbo.endTran();
    }
    
    public static ResultSet retrieveAll(DBAccessObj dbo) throws SQLException{
        String sqlCommand =  "SELECT * FROM Avaria_Cliente";
        ResultSet avariacliente;

        dbo.openConnection();
        
        avariacliente = dbo.executeQuery(sqlCommand);
        
        return avariacliente;
    }

    public void retrieve() throws SQLException{
        String sqlCommand =  "SELECT * FROM Avaria_Cliente WHERE cliente = '" + this.cliente + "' and avaria = '" + this.avaria+"'";
        ResultSet avariacliente;

        //this.dbo.beginTran();
        avariacliente = this.dbo.executeQuery(sqlCommand);
        
        if (avariacliente.next()){
             this.data_entrega = avariacliente.getDate("data_entrega");
             this.reparacao = avariacliente.getInt("reparacao");
             this.data_reparacao = avariacliente.getDate("data_reparacao");
        }
    }
    
     public void retrieve(int cli_id,int av_id) throws SQLException{
        String sqlCommand =  "SELECT * FROM Avaria_Cliente WHERE cliente = '" + cli_id + "' and avaria = '" + av_id+"'";
        ResultSet avariacliente;

        //this.dbo.beginTran();
        avariacliente = this.dbo.executeQuery(sqlCommand);
        
        if (avariacliente.next()){
             this.data_entrega = avariacliente.getDate("data_entrega");
             this.reparacao = avariacliente.getInt("reparacao");
             this.data_reparacao = avariacliente.getDate("data_reparacao");
        }
    }

    public void update() {
        String sqlCommand = "UPDATE Avaria_Cliente SET data_entrega = to_date('" + this.data_entrega + "' , 'yyyy-MM-dd'), reparacao = '" + this.reparacao + "', data_reparacao = to_date('" + this.data_reparacao + "' , 'yyyy-MM-dd') WHERE cliente = '" + this.cliente + "' AND avaria = '" + this.avaria +"'";
        String sqlCommandNoRepair = "UPDATE Avaria_Cliente SET data_entrega = to_date('" + this.data_entrega + "' , 'yyyy-MM-dd'), reparacao = '" + this.reparacao + "', data_reparacao = NULL WHERE cliente = '" + this.cliente + "' AND avaria = '" + this.avaria +"'";
        
        if(this.getReparacao()==0){
            sqlCommand=sqlCommandNoRepair;
        }
        
        //this.dbo.beginTran();
        this.dbo.executeSQL(sqlCommand);
        //this.dbo.endTran();
    }

    public void delete() {
        String sqlCommand = "DELETE FROM Avaria_Cliente WHERE cliente = '" + this.getCliente() + "' and avaria = '" + this.getAvaria()+"'";

        
        this.dbo.executeSQL(sqlCommand);
        
    }
}
