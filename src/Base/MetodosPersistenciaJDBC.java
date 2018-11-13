/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
 * @author Aluno
 */
public class MetodosPersistencia {

    public static boolean Query(String query, String[] array) {
        Connection conn = FabricaConexao.GetTransaction();
        try {            
            PreparedStatement ps = conn.prepareStatement(query);
            
            // Evita o SQL Inject
            for (int i = 0; i < array.length; i++) {
                ps.setString(i+1, array[i]);
            }
            
            return FabricaConexao.CommitTransaction(conn, (ps.executeUpdate() > 0));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            FabricaConexao.CloseConnection(conn);
        }
    }
    
    private static ObjectBase SetObject(Object obj, ResultSet rs){
        try {             
            Method method = obj.getClass().getMethod("toObjectBase",ResultSet.class);
            method.setAccessible(true);
            return (ObjectBase) method.invoke(obj,rs);                        
        } catch (IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private static ArrayList<?> getValueOfArrayList(Field field, Object obj) {
       try { 
            field.setAccessible(true);
            return (ArrayList<?>) field.get(obj);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);    
            return null;
        }
   }
    
    private static String getValue(Field field, Object obj) {
       try { 
            field.setAccessible(true);
            return (String) field.get(obj).toString();
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);    
            return null;
        }
   }
    /**
     * Inserir
     * @param obj 
     * @return  
     */
    public static boolean persistir(Object obj) {        
        int length = obj.getClass().getDeclaredFields().length;
        
        int count = 0;
        for (int i = 0; i < length; i++) {
            
            try {
                Field field = obj.getClass().getDeclaredField(   obj.getClass().getDeclaredFields()[i].getName()   );
                
                if(!field.getType().toString().equals("class java.util.ArrayList")){
                    count++;
                }
                
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        length = count;
        
        String query = "insert into " + obj.getClass().getSimpleName() + " ( ";
        
        for (int i = 0; i < length; i++) { //i = 1; persistir o obj, não precisaremos do codigo!
            Field field;
            try {
                field = obj.getClass().getDeclaredField(   obj.getClass().getDeclaredFields()[i].getName()   );
                System.out.println(field.getName().toString());
                if(!field.getType().toString().equals("class java.util.ArrayList")){
                    String name = obj.getClass().getDeclaredFields()[i].getName();             
                    query += name;
                    if(i < length-1)
                        query += ", ";
                }
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        query += " ) values ( ";
        
        String[] datas = new String[length]; //-1 significa que estarei tirando o atributo Codigo!
        try {
            for (int i = 0; i < datas.length; i++) {
                Field field = obj.getClass().getDeclaredField(   obj.getClass().getDeclaredFields()[i].getName()   );
                query += "?";
                if(!field.getType().toString().equals("class java.util.ArrayList")) {           
                    datas[i] = getValue(field, obj);
                    if(i < datas.length-1)
                        query += ", ";
                } else {                  
                    //Aqui deve inserir o Elemento que tem um Arraylist
                    System.out.println(field.getType().toString());
                    ArrayList<ObjectBase> array = (ArrayList<ObjectBase>) getValueOfArrayList(field, obj);
                    for( ObjectBase T : array ) {
                        System.out.println(T.toString());
                    }
                }
            }         
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
          
        }        
        query += " )";
        
        return Query(query, datas);
    }
    
    /**
     * Update
     * @param obj 
     */
    public static boolean fundir(Object obj) {        
        int length = obj.getClass().getDeclaredFields().length;
        String query = "update " + obj.getClass().getSimpleName() + " set ";
        
        for (int i = 1; i < length; i++) { //i = 1; Como iremos persistir o obj, não precisaremos do codigo!
            String name = obj.getClass().getDeclaredFields()[i].getName();             
            query += name + " = ?";
            if(i < length-1)
                query += ", ";
        }
        
        query += " where Codigo = ?";        
        
        String[] datas = new String[length];
        try {
            for (int i = 0; i < datas.length-1; i++) {
                Field field = obj.getClass().getDeclaredField(   obj.getClass().getDeclaredFields()[i+1].getName()   );
                datas[i] = getValue(field, obj);
            }  
            datas[length-1] = getValue(obj.getClass().getDeclaredField(   obj.getClass().getDeclaredFields()[0].getName()   ), obj);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return Query(query, datas);
    }
    
    public static boolean excluir(String chave, Class classe) throws SQLException{
        String query = "delete from " + classe.getSimpleName() + " where Codigo = " + chave;        
        return Query(query, (new String[]{chave}));        
    }
  
    public static ObjectBase recuperar(String chave, Class classe) throws SQLException{
        Connection conexao = FabricaConexao.NewSingleton();
        String query = "select * from " + classe.getSimpleName() + " where Codigo = " + chave;        
        PreparedStatement ps = conexao.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        try 
        {            
            if(rs.next())
            {
                return SetObject(classe.newInstance(), rs);
            } else
                return null;
        } catch (SQLException ex){            
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static List<?> selecionar(Class classe, String whereJPQL) throws SQLException {
        Connection conn = FabricaConexao.NewSingleton();
        String sJPQL = "select * from " + classe.getSimpleName() + " " + whereJPQL;
        
        try {
            PreparedStatement ps = conn.prepareStatement(sJPQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Object> list = new ArrayList<>();
            int colunas = rs.getMetaData().getColumnCount();
        
            while (rs.next()) {
                //Object obj = classe.newInstance();
                //for (int i = 0; i < colunas; i++) {
                //String nomeColuna = classe.getDeclaredFields()[i].getName();
                //System.out.println(rs.getString(nomeColuna));
                //}
                list.add(SetObject(classe.newInstance(), rs));
            }
            return list;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (InstantiationException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
    }

    public List<?> selecionar(Class classe, String[][] parametros) {
        String where = "";
        if (parametros.length > 0) {
            for (int i = 0; i < parametros.length; i++) {
                if (i == 0) {
                    where = where + " where ";
                } else {
                    where = where + " and ";
                }

                String campo = parametros[i][0];
                String valor = parametros[i][1];
                where = where + campo + " = '" + valor + "'";
            }
        }
        try {
            return selecionar(classe, where);
        } catch (SQLException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static List<?> selecionar(Class classe) {
        try {
            return selecionar(classe, "");
        } catch (SQLException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
