package ReparacaoBLL;

import java.util.*;
import java.sql.*;
import HelperDB.*;

public class Avaria {
    //descricao,outro,descricao_outro
    private int avaria_id;
    private String descricao;
    private int outro;
    private String descricao_outro;
    //
    //private List<Author> authors = new ArrayList<Author>();
    //
    //
    private DBAccessObj dbo;

    public int getAvaria_id() {
        return avaria_id;
    }

    public void setAvaria_id(int avaria_id) {
        this.avaria_id = avaria_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao_outro() {
        return descricao_outro;
    }

    public void setDescricao_outro(String descricao_outro) {
        this.descricao_outro = descricao_outro;
    }

    public Avaria(int avaria_id, String descricao, int outro, String descricao_outro) {
        this.avaria_id = avaria_id;
        this.descricao = descricao;
        this.outro = outro;
        this.descricao_outro = descricao_outro;
    }
    
    public Avaria(String descricao, int outro, String descricao_outro) {
        this.descricao = descricao;
        this.outro = outro;
        this.descricao_outro = descricao_outro;
    }

    public Avaria() {
        this.dbo = new DBAccessObj();
        this.dbo.openConnection();
    }

    public Avaria(DBAccessObj dbo) {
        this.dbo = dbo;
        this.dbo.openConnection();
    }


    public void create() throws SQLException{
        String sqlCommand = "INSERT INTO Avaria (descricao,outro,descricao_outro) VALUES('" + this.descricao + "', '" + this.outro + "', '" + this.descricao_outro + "')";
        
        
        this.dbo.executeSQL(sqlCommand);
    }

    public void retrieve(int id) throws SQLException{
        String sqlCommand =  "SELECT descricao,outro,descricao_outro FROM Avaria WHERE ID = '" + id + "'";
        ResultSet avaria;

        //this.dbo.beginTran();
        avaria = this.dbo.executeQuery(sqlCommand);
        
        if (avaria.next()){
             this.avaria_id = id;
             this.descricao = avaria.getString("descricao");
             this.outro = avaria.getInt("outro");
             this.descricao_outro = avaria.getString("descricao_outro");
        }

        //this.dbo.endTran();
    }

    public static ResultSet retrieveAllAvarias(DBAccessObj dbo) throws SQLException{

        String sqlCommand = "SELECT descricao,outro,descricao_outro FROM avaria";
        ResultSet avarias;

        dbo.openConnection();

        avarias = dbo.executeQuery(sqlCommand);

        return avarias;
    }
   

    public void update() {
        String sqlCommand = "UPDATE Avaria SET descricao = '" + this.descricao + "', outro = '" + this.outro + "', descricao_outro = '" + this.descricao_outro + "' WHERE avaria_id = '" + this.avaria_id + "'";
        
        this.dbo.executeSQL(sqlCommand);
       
    }

    public void delete() {
        String sqlCommand = "DELETE FROM Avaria WHERE avaria_id = '" + this.avaria_id + "'";

        
        this.dbo.executeSQL(sqlCommand);
        
    }
}