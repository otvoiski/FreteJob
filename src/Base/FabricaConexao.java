package Base;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class FabricaConexao {
    private static EntityManagerFactory Fabrica = null;
    
    private FabricaConexao(){
        Fabrica = Persistence.createEntityManagerFactory(Global.PS_NAME);
    }
    
    public static EntityManager getManager(){
        try {
            if(Fabrica == null){
                FabricaConexao conn = new FabricaConexao();
                System.out.println("Fabrica JPA aberta");
            }
            return Fabrica.createEntityManager();
        } catch (Exception e) {
            System.err.println("Erro ao abrir conexão JPA ou criar gerenciador: " );
            return null;
        }
    }
    
    public static void fecharFabrica(){
        Fabrica.close();
    }
 
}