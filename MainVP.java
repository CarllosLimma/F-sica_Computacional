package VanDerPolEquation;// pacote onde se encontra esta aplicação
/*
* Autor: Carlos Eduardo da Silva Lima
* Tema: Plot orbits of the forced Van der Pol equation, book CHAOS: An Introduction to Dynamical Systems
*
* */

import java.io.FileOutputStream;
import java.io.PrintWriter;

/* Na classe VanDerPolEquation definimos
* os métodos na qual entramos com as EDO´s
* além do algoritmimo de Runge-Kutta de 4Ordem*/
class VanDerPolEquation
{
    // Parãmetros, atributos para o problema a equação VanDer Pol
    double c = 0.1;
    double r = 5.0;

    // EDO 1
    public double f1(double t, double x, double u)
    {
        return (u);
    }

    // EDO 2
    public double f2(double t, double x, double u)
    {
        return (-c*(Math.pow(x,2)-1)*u - Math.pow(x,3) + r*Math.sin(t));
    }


    /*No método vanDerPolEquation implementamos o algoritimo de Runge-Kutta de
    4Ordem, para a resolução numérica das equações diferenciais de 1Ordem definias
    acima.*/
    public void vanDerPolEquation(double [] s0, double h, int N)
    {
        //Variáveis
        double [] t = new double[N];
        double [] x = new double[N];
        double [] u = new double[N];

        // Inicialização
        t[0] = s0[0]; // t[0] = t0, tempo inicial
        x[0] = s0[1]; // x[0] = x0, posição inicial
        u[0] = s0[2]; // u[0] = u0, velocidade inicial

        /* No loop for implementamos o algoritimo de Runge-Kutta de 4Ordem*/
        for(int i = 0; i<(N-1); i++)
        {
            double k11 = h*f1(t[i],x[i],u[i]);
            double k12 = h*f2(t[i],x[i],u[i]);

            double k21 = h*f1(t[i]+(h/2),x[i]+(k11/2),u[i]+(k12/2));
            double k22 = h*f2(t[i]+(h/2),x[i]+(k11/2),u[i]+(k12/2));

            double k31 = h*f1(t[i]+(h/2),x[i]+(k21/2),u[i]+(k22/2));
            double k32 = h*f2(t[i]+(h/2),x[i]+(k21/2),u[i]+(k22/2));

            double k41 = h*f1(t[i]+h,x[i]+k31,u[i]+k32);
            double k42 = h*f2(t[i]+h,x[i]+k31,u[i]+k32);

            x[i+1] = x[i] + ((k11 + 2*k21 + 2*k31 + k41)/6);
            u[i+1] = u[i] + ((k12 + 2*k22 + 2*k32 + k42)/6);
            t[i+1] = t[i] + h;

        }// fim o loop


        //Saida
        for(int i = 0; i<(N-1); i++)
        {
            System.out.println("t = "+t[i]+" || x = "+x[i]+" || u = "+u[i]);
        }


        //Saída em um arquivo .txt, entre um try e catch
        try
        {
            // Cria um arquivo para ser escrito
            FileOutputStream vanDePol  = new FileOutputStream("vanDePol.txt");

            // Algo para escrever, neste caso pr.
            PrintWriter pr = new PrintWriter(vanDePol);

            //Saída no arquivo
            for(int i = 1; i<(N-1); i++)
            {
                //double t0, double r10, double r20, double x10, double x20, double v1x0, double v1y0, double v2x0, double v2y0
                pr.println(x[i]+"   "+u[i]);
            }

            pr.close();
            vanDePol.close();

        }catch (Exception e)
        {
            System.out.println("Algo deu errado!");
        }

    }// fim o método vanDerPolEquation


}// fim da classe VanDerPolEquation



// Classe MainVP, nesta classe definimos o método main, este, o método principal
public class MainVP
{
    public static void main(String[] args)
    {
        // Valores iniciais
        double [] s0 = {0,0,0}; // s0[0] = t0, s0[1] = x0 e s0[2] = u0

        //Objeto
        VanDerPolEquation s = new VanDerPolEquation();

        //Chamada de método do Objeto acima definido
        s.vanDerPolEquation(s0,0.01,4000000);

    }// fim do método principal
}// fim da classe MainVP
