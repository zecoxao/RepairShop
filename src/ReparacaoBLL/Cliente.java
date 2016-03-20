/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReparacaoBLL;

import java.util.*;
import java.sql.*;
import HelperDB.*;

/**
 *
 * @author zecoxao
 */
public class Cliente {
    
    //nome,equipamento,contacto,entrada,pagamento_caucao
    
    private int cliente_id;
    private String nome;
    private String equipamento;
    private int contacto;
    private double entrada;
    private double pagamento_caucao;
    //private java.sql.Date date;
    private DBAccessObj dbo;

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public double getEntrada() {
        return entrada;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }

    public double getPagamento_caucao() {
        return pagamento_caucao;
    }

    public void setPagamento_caucao(double pagamento_caucao) {
        this.pagamento_caucao = pagamento_caucao;
    }
    
    public Cliente() {
        this.dbo = new DBAccessObj();
        this.dbo.openConnection();
    }

    public Cliente(DBAccessObj dbo) {
        this.dbo = dbo;
        this.dbo.openConnection();
    }

    public Cliente(int cliente_id, String nome, String equipamento, int contacto, double entrada, double pagamento_caucao) {
        this.cliente_id = cliente_id;
        this.nome = nome;
        this.equipamento = equipamento;
        this.contacto = contacto;
        this.entrada = entrada;
        this.pagamento_caucao = pagamento_caucao;
    }
    
    public void create() throws SQLException{
        String sqlCommand = "INSERT INTO Cliente (nome,equipamento,contacto,entrada,pagamento_caucao) VALUES('" + this.nome + "', '" + this.equipamento + "', " + this.contacto + ", " + this.entrada + ", " + this.pagamento_caucao + ")";
        
        
        this.dbo.executeSQL(sqlCommand);
        
    }

    public void retrieve(int id) throws SQLException{
        String sqlCommand =  "SELECT nome,equipamento,contacto,entrada,pagamento_caucao FROM Cliente WHERE cliente_id = " + id + "";
        ResultSet cliente;

        //this.dbo.beginTran();
        cliente = this.dbo.executeQuery(sqlCommand);
        
        if (cliente.next()){
             this.cliente_id = id;
             this.nome = cliente.getString("nome");
             this.equipamento = cliente.getString("equipamento");
             this.contacto = cliente.getInt("contacto");
             this.entrada = cliente.getDouble("entrada");
             this.pagamento_caucao = cliente.getDouble("pagamento_caucao");
        }

        //this.dbo.endTran();
    }
    
    public static ResultSet retrieveAllClientes(DBAccessObj dbo) throws SQLException{
        String sqlCommand =  "SELECT nome,equipamento,contacto,entrada,pagamento_caucao FROM Cliente";
        ResultSet clientes;

        dbo.openConnection();

        clientes = dbo.executeQuery(sqlCommand);

        return clientes;
    }

    

    public void update() {
        //nome,equipamento,contacto,entrada,pagamento_caucao
        String sqlCommand = "UPDATE Cliente SET nome = '" + this.nome + "', equipamento = '" + this.equipamento + "', contacto = '" + this.contacto + "', entrada = '" + this.entrada + "', pagamento_caucao = '" + this.pagamento_caucao + "' WHERE cliente_id = '" + this.cliente_id + "'";
        this.dbo.executeSQL(sqlCommand);
        
    }

    public void delete() {
        String sqlCommand = "DELETE FROM Cliente WHERE ID = '" + this.cliente_id + "'";

        
        this.dbo.executeSQL(sqlCommand);
        
    }
}
