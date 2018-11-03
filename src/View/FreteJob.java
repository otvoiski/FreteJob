/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class FreteJob {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String[]> a = (new Controller.ClienteController()).GetAll();
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i)[0]);
        }
    }
    
}
