/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/**
 *
 * @author Otavio
 */
public class Files {
    
    private String Path = "Caminho do arquivo";

    public Files(String path) {
        this.Path = System.getProperty("user.dir") + path;
    }
    
    public JSONObject Read() throws IOException{
        BufferedReader reader = null;
        JSONObject json = null;
        try (FileReader fileReader = new FileReader(new File(Path))) {
            reader = new BufferedReader(fileReader);
            json = new JSONObject();
            if(reader.ready()){
                json.getJSONObject(reader.readLine());
                System.out.println(json);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        reader.close();
        return json;
    }
    public void Write(JSONObject json) throws IOException {
            File file = new File(Path);
            long begin = System.currentTimeMillis();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(json.toString());
            long end = System.currentTimeMillis();
            //Criando o conteúdo do arquivo
            writer.flush();
            //Fechando conexão e escrita do arquivo.
            writer.close();
    }
}
