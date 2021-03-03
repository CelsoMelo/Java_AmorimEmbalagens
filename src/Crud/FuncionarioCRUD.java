package Crud;

import Classes.DBConnection;
import Classes.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioCRUD {
    
    public void add(Funcionario f) {
        
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Funcionario(nomeFunc) VALUES (?)");
            stmt.setString(1, f.getNome());
            
            stmt.execute();
            
            System.out.println("Insert com sucesso!");
            
        } catch (SQLException ex) {
            System.out.println("ERRO NO DB: " + ex);
        } finally {
            DBConnection.closeConnection(con, stmt);
        }
    }
    
    public int remover(int codFunc) {
        
        Connection con = DBConnection.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM Funcionario WHERE codFunc = ?");
            stmt.setInt(1, codFunc);
            
            stmt.execute();
            
            System.out.println("Funcionario removido com Sucesso!!");
            return 1;
        } catch (SQLException ex) {
            System.out.println("ERRO NO DB: " + ex);
            return 2;
        } finally {
            DBConnection.closeConnection(con, stmt);
        }
    }
    
}
