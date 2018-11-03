/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Otavio
 */
public class Error extends Exception{
    private static final long serialVersionUID = 1149241039409861914L;
    
    // constrói um objeto Error com a mensagem passada por parâmetro
    public Error(String msg){
        super(msg);
    }

    // contrói um objeto Error com mensagem e a causa dessa exceção, utilizado para encadear exceptions
    public Error(String msg, Throwable cause){
        super(msg, cause);
    }
}
