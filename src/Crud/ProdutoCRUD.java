package Crud;

import Classes.DBConnection;
import Classes.Produto;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoCRUD {
    
    public void add(Produto p) {
        
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Produto(descProd, quantProd, unidProd, prAtaProd) VALUES (?, ?, ?, ?)");
            stmt.setString(1, p.getDesc());
            stmt.setDouble(2, p.getQuant());
            stmt.setString(3, p.getUnidade());
            stmt.setDouble(4, p.getPrecAtac());
            
            stmt.execute();
            
            System.out.println("Insert com sucesso!");
            
        } catch (SQLException ex) {
            System.out.println("ERRO NO DB: " + ex);
        } finally {
            DBConnection.closeConnection(con, stmt);
        }
    }
    public int remover(int codProd) {
        
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM Produto WHERE codProd = ?");
            stmt.setInt(1, codProd);
            
            stmt.execute();
            
            System.out.println("Item removido com Sucesso!!");
            return 1;
        } catch (SQLException ex) {
            System.out.println("ERRO NO DB: " + ex);
            return 2;
        } finally {
            DBConnection.closeConnection(con, stmt);
        }
    }
    public int editar(int codProd, String descProd, double quantProd, String unidProd, double precAtac) {
        
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE Produto SET descProd  = ? WHERE codProd = ?");
            stmt.setString(1, descProd);
            stmt.setInt(2, codProd);
            stmt.execute();
            stmt = con.prepareStatement("UPDATE Produto SET quantProd  = ? WHERE codProd = ?");
            stmt.setDouble(1, quantProd);
            stmt.setInt(2, codProd);
            stmt.execute();
            stmt = con.prepareStatement("UPDATE Produto SET unidProd  = ? WHERE codProd = ?");
            stmt.setString(1, unidProd);
            stmt.setInt(2, codProd);
            stmt.execute();
            stmt = con.prepareStatement("UPDATE Produto SET prAtaProd  = ? WHERE codProd = ?");
            stmt.setDouble(1, precAtac);
            stmt.setInt(2, codProd);
            stmt.execute();
            
            System.out.println("Item Editado com Sucesso!!");
            return 1;
        } catch (SQLException ex) {
            System.out.println("ERRO NO DB: " + ex);
            return 2;
        } finally {
            DBConnection.closeConnection(con, stmt);
        }
    }
    
    public List<Produto> read() {
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Produto");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Produto p = new Produto();
                
                p.setCod(rs.getInt("codProd"));
                p.setDesc(rs.getString("descProd"));
                p.setQuant(rs.getDouble("quantProd"));
                p.setUnidade(rs.getString("unidProd"));
                p.setPrecAtac(rs.getDouble("prAtaProd"));
                produtos.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.closeConnection(con, stmt, rs);
        }
        
        return produtos;
    }
    public List<Produto> readDescProd(String desc) {
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Produto WHERE descProd LIKE ? ");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Produto p = new Produto();
                
                p.setCod(rs.getInt("codProd"));
                p.setDesc(rs.getString("descProd"));
                p.setQuant(rs.getDouble("quantProd"));
                p.setUnidade(rs.getString("unidProd"));
                p.setPrecAtac(rs.getDouble("prAtaProd"));
                produtos.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.closeConnection(con, stmt, rs);
        }
        
        return produtos;
    }
    public List<Produto> readCodProd(int codPr) {
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Produto WHERE codProd = ? ");
            stmt.setInt(1, codPr);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Produto p = new Produto();
                
                p.setCod(rs.getInt("codProd"));
                p.setDesc(rs.getString("descProd"));
                p.setQuant(rs.getDouble("quantProd"));
                p.setUnidade(rs.getString("unidProd"));
                p.setPrecAtac(rs.getDouble("prAtaProd"));
                produtos.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.closeConnection(con, stmt, rs);
        }
        
        return produtos;
    }
    
    public int getQuantDados() {
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int count = 0;
        
        try {
            stmt = con.prepareStatement("select count(codProd) as cont from Produto");
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
            stmt = con.prepareStatement("DELETE FROM Produto");
            stmt.execute();
            
            System.out.println("Tabela resetada com Sucesso!");
        } catch(SQLException ex) {
            System.out.println("Erro ao executar a Querry: " + ex);
        } finally {
            DBConnection.closeConnection(con, stmt);
        }
    }
    
}
