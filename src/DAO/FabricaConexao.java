package DAO;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class FabricaConexao {
 
    private static final String STR_DRIVER = "org.gjt.mm.mysql.Driver";  // definição de qual banco será utilizado
    private static final String DATABASE = "fretejobdb"; // Nome do banco de dados         
    private static final String IP = "127.0.0.1";  // ip de conexao
    private static final String STR_CON = "jdbc:mysql://" + IP + ":3306/" + DATABASE; // string de conexao com o banco de dados
    private static final String USER = "root"; // Nome do usuário
    private static final String PASSWORD = "123456"; // senha
    private static Connection objConexao = null;
 
    public FabricaConexao() {
        try{
            Class.forName(STR_DRIVER);
            objConexao = DriverManager.getConnection(STR_CON, USER, PASSWORD);
            if(objConexao == null)
                System.out.println("O servidor de banco de dados não está online!");
        }catch (ClassNotFoundException e) {   
            String errorMsg = "Driver nao encontrado: "+e.getMessage();    
            System.out.println(errorMsg);
        } catch (SQLException e) {   
            String errorMsg = "Erro ao obter a conexao: "+e.getMessage();   
            System.out.println(errorMsg);
        }   
    }
 
    public static Connection GeraConexaoSINGLETON() {
        if (objConexao == null) {
            FabricaConexao MANTERCONEXAO = new FabricaConexao();
        }
        return objConexao;
    }
    public static Connection GeraTransaction(){
        Connection cnx = null;
        try {
            cnx = DriverManager.getConnection(STR_CON, USER, PASSWORD);
            cnx.setAutoCommit(false);
            cnx.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (SQLException ex) {
            Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cnx;
    }
     
}