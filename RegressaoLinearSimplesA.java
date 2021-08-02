/*
* Autor: Carlos Eduardo a Silva Lima
* Tema: Regressão Linear Simples
* Data: 22/05/2021
*
* */
package RegressaoLinearSimples;

// Classe
public class RegressaoLinearSimplesA
{
    public static void main(String[] args)
    {

        // Dados - Pares ordenaos (xi,yi)
        double [] x = {2,4,6,8,10};
        double [] y = {42,48.4,51.3,56.3,58.6};

        //Objeto
        RegressaoLinearSimplesB solution = new RegressaoLinearSimplesB();

        //Chamada de método
        solution.regressaoLinear(x,y);


    }// fim o método main
}// fim da classe RegressaoLinearSimplesA
