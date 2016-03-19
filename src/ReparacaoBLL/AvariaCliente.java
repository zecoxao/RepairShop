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
    
    
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<Avaria> avarias = new ArrayList<Avaria>();
    private java.sql.Date data_entrega;
    private int reparacao;
    private java.sql.Date data_reparacao;
    private DBAccessObj dbo;
    
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Avaria> getAvarias() {
        return avarias;
    }

    public void setAvarias(List<Avaria> avarias) {
        this.avarias = avarias;
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
    
    public void create(int cliente, int avaria) throws SQLException{
        String sqlCommand = "INSERT INTO AvariaCliente (cliente,avaria,data_entrega,reparacao,data_reparacao) VALUES('" + this.getClientes().get(cliente).getCliente_id() + "', '" + this.getAvarias().get(avaria).getAvaria_id() + "', '" + this.data_entrega + "', '" + this.reparacao + "', '" + this.data_reparacao + "')";
        String sqlCommandReparacaoNull = "INSERT INTO AvariaCliente (cliente,avaria,data_entrega,reparacao) VALUES('" + this.getClientes().get(cliente).getCliente_id() + "', '" + this.getAvarias().get(avaria).getAvaria_id() + "', '" + this.data_entrega + "', '" + this.reparacao + "')";

        if (this.getReparacao() == 0)
            sqlCommand = sqlCommandReparacaoNull;
        
        //this.dbo.beginTran();
        this.dbo.executeSQL(sqlCommand);
        //this.dbo.endTran();
    }

    public void retrieve(int id) throws SQLException{
        String sqlCommand =  "SELECT data_entrega,reparacao,data_reparacao FROM avariacliente WHERE cliente = '" + id + "'";
        ResultSet avariacliente;

        //this.dbo.beginTran();
        avariacliente = this.dbo.executeQuery(sqlCommand);
        
        if (avariacliente.next()){
             this.data_entrega = avariacliente.getDate("data_entrega");
             this.reparacao = avariacliente.getInt("reparacao");
             this.data_reparacao = avariacliente.getDate("data_reparacao");
        }
    }

    public void update(int id) {
        String sqlCommand = "UPDATE avariacliente SET data_entrega = '" + this.data_entrega + "', reparacao = '" + this.reparacao + "', data_reparacao = '" + this.data_reparacao + "' WHERE cliente = '" + this.getClientes().get(id).getCliente_id() + "'";
        String sqlCommandReparacaoNull = "UPDATE avariacliente SET data_entrega = '" + this.data_entrega + "', reparacao = '" + this.reparacao + "' WHERE cliente = '" + this.getClientes().get(id).getCliente_id() + "'";
        
        if (this.getReparacao() == 0)
            sqlCommand = sqlCommandReparacaoNull;
                
        //this.dbo.beginTran();
        this.dbo.executeSQL(sqlCommand);
        //this.dbo.endTran();
    }

    public void delete(int id) {
        String sqlCommand = "DELETE FROM avariacliente WHERE cliente = '" + this.getClientes().get(id).getCliente_id() + "'";

        
        this.dbo.executeSQL(sqlCommand);
        
    }
}
