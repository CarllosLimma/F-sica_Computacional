/*
 * Autor: Carlos Eduardo a Silva Lima
 * Tema: Regressão Linear Simples
 * Data: 22/05/2021
 *
 * */
package RegressaoLinearSimples;

// Classe
public class RegressaoLinearSimplesB
{

    // Neste método entramos com pares ordenados (xi, yi) de dados de uma tabela.
    public void regressaoLinear(double [] x, double [] y)
    {

        if(x.length > y.length)
        {
            System.out.println("O conjunto (xi,yi) não tem a mesma quantiade e elementos!");

        }else if(x.length < y.length)
        {
            System.out.println("O conjunto (xi,yi) não tem a mesma quantiade e elementos!");

        }else if(x.length == y.length)
        {

            // Somas
             double sx = 0, sxx = 0, sy = 0, sxy = 0;

             for(int i = 0; i<x.length; i++)
             {
                 sx += x[i];
                 sy += y[i];
                 sxx += Math.pow((x[i]),2);
                 sxy += x[i]*y[i];
             }

            // delta
            double delta = x.length*sxx - Math.pow(sx,2);

             if(delta != 0)
             {
                 //A
                 double A = ((sxx*sy - sx*sxy)/delta);
                 System.out.println("A = "+A);

                 //B
                 double B = ((x.length*sxy  - sx*sy)/delta);
                 System.out.println("B = "+B);

                 // Reta de Regressão Linear
                 System.out.println("Y = "+A+" + ("+B+")*x");

             }else if(delta == 0)
             {
                 System.out.println(" Não existe solução!, ou seja, para este conjunto de dados não existe a reta regressora!.");
             }

        }

    }// fim do método regressaoLinear



}// fim da classe RegressaoLinearSimplesB
