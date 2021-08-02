/*
 * Autor: Carlos Euardo da Silva Lima
 * Tema: Método de Runge-Kutta 5Ordem (Métoo de Butcher)
 * Dados: 06/06/2021
 * Arquivo.java:2
 * Linguegem: Java
 * Livro: Métodos Numéricos para Engenheiros Chapman pagina 610 -> 628/825
 * */

pacote  RungeKutta5OrdemSistema2x2 ;

public class RungeKutta5OSistem2x2
{
    //EDO´s - Entre com as expressões para equações diferenciais
    /*
        f1 (t, x1, x2) = dy1 / dt = f1 (t, x1, x2)
        f2 (t, x1, x2) = dy2 / dt = f (2t, x1, x2)
    */

    // Primeira EDO
    public  double  f1 ( double  t , double  x1 , double  x2 )
    {
        return ( Math . cos (x1) * Math . exp ( - 0,05 * t * t + x1));
    }

    // Segunda EDO
    público  duplo  f2 ( duplo  t , duplo  x1 , duplo  x2 )
    {
        return (x1 * x2 * Math . exp ( - 0,05 * t));
    }


    /* Método de Runge-Kutta 5Ordem  para Sistema de EDO´s*/
    public  void  RungeKutta5OSistema2x2 ( double  t0 , double  x10 , double  x20 , double  h , int  N )
    {
        // Varáveis
        duplo [] t   =  novo  duplo [ N ];
        duplo [] x1 =  novo  duplo [ N ];
        duplo [] x2 =  novo  duplo [ N ];

        //Incialização
        t [ 0 ]   = t0;
        x1 [ 0 ] = x10;
        x2 [ 0 ] = x20;

        /* Dentro do loop for inplementos o algoritmo para
         * o Método de Runge-Kutta 5Ordem  para Sistema de EDO´s */
        para ( int i =  0 ; i < Math . abs ( N - 1 ); i ++ )
        {
            duplo k1 = f1 (t [i], x1 [i], x2 [i]);
            duplo l1 = f2 (t [i], x1 [i], x2 [i]);

            duplo k2 = f1 ((t [i] + (h / 4 )), (x1 [i] + (k1 * h / 4 )), (x2 [i] + (l1 * h / 4 )));
            duplo l2 = f2 ((t [i] + (h / 4 )), (x1 [i] + (k1 * h / 4 )), (x2 [i] + (l1 * h / 4 )));

            duplo k3 = f1 ((t [i] + (h / 4 )), (x1 [i] + (k1 * h / 8 ) + (k2 * h / 8 )), (x2 [i] + (l1 * h / 8 ) + (12 * h / 8 )));
            duplo l3 = f2 ((t [i] + (h / 4 )), (x1 [i] + (k1 * h / 8 ) + (k2 * h / 8 )), (x2 [i] + (l1 * h / 8 ) + (12 * h / 8 )));

            duplo k4 = f1 ((t [i] + (h / 2 )), (x1 [i] - (k2 * h / 2 ) + k3 * h), (x2 [i] - (l2 * h / 2 ) + l3 * h));
            duplo l4 = f2 ((t [i] + (h / 2 )), (x1 [i] - (k2 * h / 2 ) + k3 * h), (x2 [i] - (l2 * h / 2 ) + l3 * h));

            duplo k5 = f1 ((t [i] + ( 3 * h / 4 )), (x1 [i] + ( 3 * k1 * h / 16 ) + ( 9 * k4 * h / 16 )), (x2 [ i] + ( 3 * l1 * h / 16 ) + ( 9 * 14 * h / 16 )));
            duplo l5 = f2 ((t [i] + ( 3 * h / 4 )), (x1 [i] + ( 3 * k1 * h / 16 ) + ( 9 * k4 * h / 16 )), (x2 [ i] + ( 3 * l1 * h / 16 ) + ( 9 * 14 * h / 16 )));

            duplo k6 = f1 ((t [i] + h), (x1 [i] - ( 3 * k1 * h / 7 ) + ( 2 * k2 * h / 7 ) + ( 12 * k3 * h / 7 ) - ( 12 * k4 * h / 7 ) - ( 12 * k4 * h / 7 ) + (8 * k5 * h / 7 )), (x2 [i] - ( 3 * l1 * h / 7 ) + ( 2 * l2 * h / 7 ) + ( 12 * l3 * h / 7 ) - ( 12 * l4 * h / 7 )   + ( 8 * 15 * h / 7 )));
            duplo l6 = f2 ((t [i] + h), (x1 [i] - ( 3 * k1 * h / 7 ) + ( 2 * k2 * h / 7 ) + ( 12 * k3 * h / 7 ) - ( 12 * k4 * h / 7 ) - ( 12 * k4 * h / 7 ) + (8 * k5 * h / 7 )), (x2 [i] - ( 3 * l1 * h / 7 ) + ( 2 * l2 * h / 7 ) + ( 12 * l3 * h / 7 ) - ( 12 * l4 * h / 7 )   + ( 8 * 15 * h / 7 )));

            x1 [i + 1 ] = x1 [i] + (( 7 * k1 * h +  32 * k2 * h +  12 * k4 * h +  32 * k5 * h +  7 * k6 * h) / 90 );
            x2 [i + 1 ] = x2 [i] + (( 7 * l1 * h +  32 * l2 * h +  12 * l4 * h +  32 * l5 * h +  7 * l6 * h) / 90 );
            t [i + 1 ]   = t [i]   + h;

            //Saida os resultados na tela
            Sistema . para fora . println ( " t [ " + i + " ] = " + t [i] + " || x1 [ " + i + " ] = " + x1 [i] + " || x2 [ " + i + " ] = " + x2 [i]);

        }// fim o loop for


    }// Fim o método RungeKutta5OSistema2x2


}// fim a classe RungeKutta5OSistem2x2

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/*
 * Autor: Carlos Euardo da Silva Lima
 * Tema: Método de Runge-Kutta 5Ordem (Métoo de Butcher)
 * Data: 06/06/2021
 * Arquivo.java:2
 * Linguegem: Java
 * Livro: Métodos Numéricos para Engenheiros Chapman pagina 610 -> 628/825
 * */

package RungeKutta5OrdemSistema2x2;

public class MainRungeKutta5OSistem2x2
{

    public static void main(String[] args)
    {
        // Parãmetros
        double t, x10, x20, h;
        int N;

        t   = 0;
        x10 = 1;
        x20 = 1.5;
        h   = 2*Math.pow(10,-6);
        N   = 1000;

        // Objeto
        RungeKutta5OSistem2x2 s = new RungeKutta5OSistem2x2();

        // Chamada de método do objeto s (s = solução) so tipo  RungeKutta5OSistem2x2
        s.RungeKutta5OSistema2x2(t, x10, x20, h, N);

    }// fim do métoo princiapl main
}// fim a classe MainRungeKutta5OSistem2x2
