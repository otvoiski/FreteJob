package Base;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class FabricaConexaoJDBC {
 
    private static final String STR_DRIVER = "org.gjt.mm.mysql.Driver";  // definição de qual banco será utilizado
    private static final String DATABASE = "fretejobdb"; // Nome do banco de dados         
    private static final String IP = "localhost";  // ip de conexao
    private static final String STR_CON_DB = "jdbc:mysql://" + IP + ":3306/" + DATABASE; // string de conexao com o banco de dados
    private static final String USER = "root"; // Nome do usuário
    private static final String PASSWORD = ""; // senha
    private static Connection objConexao = null;
 
    public FabricaConexaoJDBC() {
        try{
            Class.forName(STR_DRIVER);
            objConexao = DriverManager.getConnection(STR_CON_DB, USER, PASSWORD);
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
    public FabricaConexaoJDBC(String stringConexao) {
        try{
            Class.forName(STR_DRIVER);
            objConexao = DriverManager.getConnection(stringConexao);
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
    public static Connection GetConnection(){
        if (objConexao == null) {
            FabricaConexaoJDBC MANTERCONEXAO = new FabricaConexaoJDBC("jdbc:mysql://" + IP + "/?user="+USER+"&"+"password="+PASSWORD);
        }
        return objConexao;
    }
    public static Connection NewSingleton() {
        if (objConexao == null) {
            FabricaConexaoJDBC MANTERCONEXAO = new FabricaConexaoJDBC();
        }
        return objConexao;
    }
    public static Connection GetTransaction(){
        Connection cnx = null;
        try {
            cnx = DriverManager.getConnection(STR_CON_DB, USER, PASSWORD);
            cnx.setAutoCommit(false);
            cnx.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (SQLException ex) {
            Logger.getLogger(FabricaConexaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cnx;
    }

    public static boolean CommitTransaction(Connection conn, boolean bCommit) throws SQLException {
        if (bCommit) {
            conn.commit();
        } else {
            conn.rollback();
        }
        return bCommit;
    }

    public static void CloseConnection(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FabricaConexaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}