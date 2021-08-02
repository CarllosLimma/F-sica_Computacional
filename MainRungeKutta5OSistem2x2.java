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
