package Crud;

import Classes.Compra;
import Classes.DBConnection;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompraCRUD {
    
    public void add(Compra c) {
        
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        
        try {
                if (c.getData().isEmpty()) {
                stmt = con.prepareStatement("INSERT INTO Compra(vlrTotCompra, formPagCompra) VALUES (?, ?)");
                stmt.setDouble(1, c.getVlrTot());
                stmt.setString(2, c.getPagForm());
                
                stmt.execute();
                
                System.out.println("Insert com sucesso!");
            } else {
                stmt = con.prepareStatement("INSERT INTO Compra(dataCompra, vlrTotCompra, formPagCompra) VALUES (?, ?, ?)");
                stmt.setString(1, c.getData());
                stmt.setDouble(2, c.getVlrTot());
                stmt.setString(3, c.getPagForm());
                
                stmt.execute();
                
                System.out.println("Insert com sucesso!");
            }
        } catch (SQLException ex) {
            System.out.println("ERRO NO DB: " + ex);
        } finally {
            DBConnection.closeConnection(con, stmt);
        }
    }
    
    public int remover(int codCompra) {
        
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM Compra WHERE codCompra = ?");
            stmt.setInt(1, codCompra);
            
            stmt.execute();
            
            System.out.println("Compra removida com Sucesso!!");
            return 1;
        } catch (SQLException ex) {
            System.out.println("ERRO NO DB: " + ex);
            return 2;
        } finally {
            DBConnection.closeConnection(con, stmt);
        }
    }
    
    public List<Compra> read() {
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Compra> compras = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Compra");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Compra c = new Compra();

                c.setCod(rs.getInt("codCompra"));
                c.setData(rs.getString("dataCompra"));
                c.setVlrTot(rs.getDouble("vlrTotCompra"));
                c.setPagForm(rs.getString("formPagCompra"));
                
                compras.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompraCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.closeConnection(con, stmt, rs);
        }

        return compras;
    }
    public int readCompraAtual() {
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int lastCod = -1;

        try {
            stmt = con.prepareStatement("SELECT codCompra FROM Compra");
            rs = stmt.executeQuery();

            while (rs.next()) {
                lastCod = rs.getInt("codCompra");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompraCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.closeConnection(con, stmt, rs);
        }

        return lastCod;
    }
    
    public int getQuantDados() {
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int count = 0;
        
        try {
            stmt = con.prepareStatement("select count(codCompra) as cont from Compra");
            rs = stmt.executeQuery();
            count = rs.getInt("cont");
            
        } catch(SQLException ex) {
            System.out.println("Erro ao executar a Querry: " + ex);
            count = -1;
        } finally {
            DBConnection.closeConnection(con, stmt, rs);
        }
        return count;
    }
    public void resetar() {
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM Compra");
            stmt.execute();
            
            System.out.println("Tabela resetada com Sucesso!");
        } catch(SQLException ex) {
            System.out.println("Erro ao executar a Querry: " + ex);
        } finally {
            DBConnection.closeConnection(con, stmt);
        }
    }
    
    
}
