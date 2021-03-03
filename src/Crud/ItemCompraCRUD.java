package Crud;

import Classes.DBConnection;
import Classes.EstatsItem;
import Classes.ItemCompra;
import Classes.ListaCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LUANA
 */
public class ItemCompraCRUD {

    public void add(ItemCompra ic) {

        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;

        try {
            /*Antigo
            stmt = con.prepareStatement("INSERT INTO ItemCompra(quantItem, unidItem, precUnidItem precItem, Produto, Compra) VALUES (?, ?, ?, ?, ?, ?)");
            */
            stmt = con.prepareStatement("INSERT INTO ItemCompra(quantItem, unidItem, precItem, Produto, Compra) VALUES (?, ?, ?, ?, ?)");
            stmt.setDouble(1, ic.getQuantItem());
            stmt.setString(2, ic.getUnidade());
            //stmt.setDouble(3, ic.getPrecUnit());
            stmt.setDouble(3, ic.getPrecTotal());
            stmt.setInt(4, ic.getProduto());
            stmt.setInt(5, ic.getCompra());

            stmt.execute();

            System.out.println("Insert com sucesso!");

        } catch (SQLException ex) {
            System.out.println("ERRO NO DB: " + ex);
        } finally {
            DBConnection.closeConnection(con, stmt);
        }
    }

    public int remover(int codItem) {

        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM ItemCompra WHERE codItem = ?");
            stmt.setInt(1, codItem);

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

    public List<ItemCompra> read() {
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ItemCompra> itens = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Produto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ItemCompra ic = new ItemCompra();

                ic.setCodItem(rs.getInt("codItem"));
                ic.setQuantItem(rs.getDouble("quantItem"));
                ic.setUnidade(rs.getString("unidItem"));
                //ic.setPrecUnit(rs.getDouble("precUnidItem"));
                ic.setPrecTotal(rs.getDouble("precItem"));
                ic.setProduto(rs.getInt("Produto"));
                ic.setCompra(rs.getInt("Compra"));
                itens.add(ic);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemCompraCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.closeConnection(con, stmt, rs);
        }

        return itens;
    }

    //RESOLVER COMO EXIBIR O A LISTA DE COMPRAS - Resolvido
    public List<ListaCompra> readListaCompra(int codCompra) {
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ListaCompra> itens = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT Compra, Produto, descProd, precItem, quantItem, unidItem, codItem FROM ItemCompra\n"
                    + "INNER JOIN Produto\n"
                    + "on ItemCompra.Produto = Produto.codProd\n"
                    + "and Compra = ?;");
            stmt.setInt(1, codCompra);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ListaCompra lc = new ListaCompra();
                
                lc.setCodCompra(rs.getInt("Compra"));
                lc.setCodProd(rs.getInt("Produto"));
                lc.setDescProd(rs.getString("descProd"));
                lc.setPrecProd(rs.getDouble("precItem"));
                lc.setQuantProd(rs.getDouble("quantItem"));
                lc.setUnidProd(rs.getString("unidItem"));
                lc.setCodItem(rs.getInt("codItem"));
               
                itens.add(lc);
            }
            
            

        } catch (SQLException ex) {
            Logger.getLogger(ItemCompraCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.closeConnection(con, stmt, rs);
        }

        return itens;
    }
    public List<EstatsItem> readEstats() {
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<EstatsItem> Estats = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * from EstatsItens");
            rs = stmt.executeQuery();

            while (rs.next()) {
                EstatsItem ei = new EstatsItem();
                
                ei.setCodItem(rs.getInt("codProd"));
                ei.setNomeProd(rs.getString("descProd"));
                ei.setUnidItem(rs.getString("unidItem"));
                ei.setQuantItem(rs.getDouble("quantVendido"));
                ei.setPrecItem(rs.getDouble("prAtaProd"));
                ei.setVlrTot(rs.getDouble("vlrTotV"));
               
                Estats.add(ei);
            }
            
            

        } catch (SQLException ex) {
            Logger.getLogger(ItemCompraCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.closeConnection(con, stmt, rs);
        }

        return Estats;
    }
    
    public int getQuantDados() {
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int count = 0;
        
        try {
            stmt = con.prepareStatement("select count(codItem) as cont from ItemCompra");
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
    
    public int getQuantDadosEstats() {
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int count = 0;
        
        try {
            stmt = con.prepareStatement("select count(codProd) as cont from EstatsItens");
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
            stmt = con.prepareStatement("DELETE FROM ItemCompra");
            stmt.execute();
            
            System.out.println("Tabela resetada com Sucesso!");
        } catch(SQLException ex) {
            System.out.println("Erro ao executar a Querry: " + ex);
        } finally {
            DBConnection.closeConnection(con, stmt);
        }
    }
}
