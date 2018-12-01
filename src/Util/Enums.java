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
public class Enums {

    public static enum TipoTransporte {
        Terrestres, Aquaticos, Aeroviarios
    }
    public static enum NaturezaPessoa {
        Juridica, Fisica
    }
    public static enum TipoPessoa {
        Distribuidora, Funcionario, Cliente
    }
    public static enum TipoFreteEncomenda {
        Normal, Rapido, SuperRapido
    }
    public static enum TipoEndereco {
        Entrega, Principal, Coleta
    }
    public static enum Sexo {
        Masculino, Feminino, Coleta
    }
    public static enum StatusEncomenda{
        AguardandoColeta, EmTransito, Entregue
    }
    
}
