package PenduloDuploComMolas;


import java.io.FileOutputStream;
import java.io.PrintWriter;

public class PenduloDuploMolas
{
    // Parâmetros (Atributos) do pêndulo duplo com molas

    double m1 = 2.0;
    double m2 = 2.0;
    double l1 = 1.0;
    double l2 = 1.0;
    double k1 = 10.0;
    double k2 = 10.0;
    double b1 = 0.0;
    double b2 = 0.0;
    double g  = 9.81;

    // Definimos as equações diferenciais no corpos dos métodos

    // EDO 1
    public double f1(double t, double r1, double r2, double x1, double x2, double v1x, double v1y, double v2x, double v2y)
    {
        return(v1x);
    }

    // EDO 2
    public double f2(double t, double r1, double r2, double x1, double x2, double v1x, double v1y, double v2x, double v2y)
    {
        return(v1y);
    }

    // EDO 3
    public double f3(double t, double r1, double r2, double x1, double x2, double v1x, double v1y, double v2x, double v2y)
    {
        return(v2x);
    }

    // EDO 4
    public double f4(double t, double r1, double r2, double x1, double x2, double v1x, double v1y, double v2x, double v2y)
    {
        return(v2y);
    }

    // EDO 5
    public double f5(double t, double r1, double r2, double x1, double x2, double v1x, double v1y, double v2x, double v2y)
    {
        double s1 = Math.abs(l1-r1);
        double s2 = Math.abs(l2-r2);
        return(-(k1/m1)*s1*Math.sin(x1) - (b1/m1)*v1x + (k2/m1)*s2*Math.sin(x2) + g);
    }

    // EDO 6
    public double f6(double t, double r1, double r2, double x1, double x2, double v1x, double v1y, double v2x, double v2y)
    {
        double s1 = Math.abs(l1-r1);
        double s2 = Math.abs(l2-r2);
        return(-(k1/m1)*s1*Math.cos(x1) - (b1/m1)*v1y + (k2/m1)*s2*Math.cos(x2) + g);
    }

    // EDO 7
    public double f7(double t, double r1, double r2, double x1, double x2, double v1x, double v1y, double v2x, double v2y)
    {
        double s1 = Math.abs(l1-r1);
        double s2 = Math.abs(l2-r2);
        return(-(k2/m2)*s2*Math.sin(x2) - (b2/m2)*v2x);
    }

    // EDO 8
    public double f8(double t, double r1, double r2, double x1, double x2, double v1x, double v1y, double v2x, double v2y)
    {
        double s1 = Math.abs(l1-r1);
        double s2 = Math.abs(l2-r2);
        return(-(k2/m2)*s2*Math.cos(x2) - (b2/m2)*v2y + g);
    }



    /* No método penduloDuploMolas inplementamos o algoritimo de Runge-Kutta de 4Ordem, na qual resolveremos
    * as equações iferenciais escritas acima.*/
    public void penduloDuploMolas(double t0, double r10, double r20, double x10, double x20, double v1x0, double v1y0, double v2x0, double v2y0, double h, int N)
    {

        // Variáveis para a implementação do algoritimo de Runge-Kutta de 4Ordem
        double [] t  = new double[N];
        double [] x1 = new double[N];
        double [] x2 = new double[N];
        double [] x3 = new double[N];
        double [] x4 = new double[N];
        double [] x5 = new double[N];
        double [] x6 = new double[N];
        double [] x7 = new double[N];
        double [] x8 = new double[N];

        //Inicialização das novas variáveis, nos consdições iniciais de entrada o método.
        t[0]  = t0;
        x1[0] = r10;
        x2[0] = r20;
        x3[0] = x10;
        x4[0] = x20;
        x5[0] = v1x0;
        x6[0] = v1y0;
        x7[0] = v2x0;
        x8[0] = v2y0;

        // Runge-Kutta de 4Ordem
        for(int i = 0; i<(N-1); i++)
        {
            double k11 = h*f1(t[i], x1[i], x2[i], x3[i], x4[i], x5[i], x6[i], x7[i], x8[i]);
            double k12 = h*f2(t[i], x1[i], x2[i], x3[i], x4[i], x5[i], x6[i], x7[i], x8[i]);
            double k13 = h*f3(t[i], x1[i], x2[i], x3[i], x4[i], x5[i], x6[i], x7[i], x8[i]);
            double k14 = h*f4(t[i], x1[i], x2[i], x3[i], x4[i], x5[i], x6[i], x7[i], x8[i]);
            double k15 = h*f5(t[i], x1[i], x2[i], x3[i], x4[i], x5[i], x6[i], x7[i], x8[i]);
            double k16 = h*f6(t[i], x1[i], x2[i], x3[i], x4[i], x5[i], x6[i], x7[i], x8[i]);
            double k17 = h*f7(t[i], x1[i], x2[i], x3[i], x4[i], x5[i], x6[i], x7[i], x8[i]);
            double k18 = h*f8(t[i], x1[i], x2[i], x3[i], x4[i], x5[i], x6[i], x7[i], x8[i]);

            double k21 = h*f1(t[i]+(h/2), x1[i] + (k11/2), x2[i] + (k12/2), x3[i] + (k13/2), x4[i] + (k14/2), x5[i] + (k15/2), x6[i] + (k16/2), x7[i] + (k17/2), x8[i] + (k18/2));
            double k22 = h*f2(t[i]+(h/2), x1[i] + (k11/2), x2[i] + (k12/2), x3[i] + (k13/2), x4[i] + (k14/2), x5[i] + (k15/2), x6[i] + (k16/2), x7[i] + (k17/2), x8[i] + (k18/2));
            double k23 = h*f3(t[i]+(h/2), x1[i] + (k11/2), x2[i] + (k12/2), x3[i] + (k13/2), x4[i] + (k14/2), x5[i] + (k15/2), x6[i] + (k16/2), x7[i] + (k17/2), x8[i] + (k18/2));
            double k24 = h*f4(t[i]+(h/2), x1[i] + (k11/2), x2[i] + (k12/2), x3[i] + (k13/2), x4[i] + (k14/2), x5[i] + (k15/2), x6[i] + (k16/2), x7[i] + (k17/2), x8[i] + (k18/2));
            double k25 = h*f5(t[i]+(h/2), x1[i] + (k11/2), x2[i] + (k12/2), x3[i] + (k13/2), x4[i] + (k14/2), x5[i] + (k15/2), x6[i] + (k16/2), x7[i] + (k17/2), x8[i] + (k18/2));
            double k26 = h*f6(t[i]+(h/2), x1[i] + (k11/2), x2[i] + (k12/2), x3[i] + (k13/2), x4[i] + (k14/2), x5[i] + (k15/2), x6[i] + (k16/2), x7[i] + (k17/2), x8[i] + (k18/2));
            double k27 = h*f7(t[i]+(h/2), x1[i] + (k11/2), x2[i] + (k12/2), x3[i] + (k13/2), x4[i] + (k14/2), x5[i] + (k15/2), x6[i] + (k16/2), x7[i] + (k17/2), x8[i] + (k18/2));
            double k28 = h*f8(t[i]+(h/2), x1[i] + (k11/2), x2[i] + (k12/2), x3[i] + (k13/2), x4[i] + (k14/2), x5[i] + (k15/2), x6[i] + (k16/2), x7[i] + (k17/2), x8[i] + (k18/2));

            double k31 = h*f1(t[i]+(h/2), x1[i] + (k21/2), x2[i] + (k22/2), x3[i] + (k23/2), x4[i] + (k24/2), x5[i] + (k25/2), x6[i] + (k26/2), x7[i] + (k27/2), x8[i] + (k28/2));
            double k32 = h*f2(t[i]+(h/2), x1[i] + (k21/2), x2[i] + (k22/2), x3[i] + (k23/2), x4[i] + (k24/2), x5[i] + (k25/2), x6[i] + (k26/2), x7[i] + (k27/2), x8[i] + (k28/2));
            double k33 = h*f3(t[i]+(h/2), x1[i] + (k21/2), x2[i] + (k22/2), x3[i] + (k23/2), x4[i] + (k24/2), x5[i] + (k25/2), x6[i] + (k26/2), x7[i] + (k27/2), x8[i] + (k28/2));
            double k34 = h*f4(t[i]+(h/2), x1[i] + (k21/2), x2[i] + (k22/2), x3[i] + (k23/2), x4[i] + (k24/2), x5[i] + (k25/2), x6[i] + (k26/2), x7[i] + (k27/2), x8[i] + (k28/2));
            double k35 = h*f5(t[i]+(h/2), x1[i] + (k21/2), x2[i] + (k22/2), x3[i] + (k23/2), x4[i] + (k24/2), x5[i] + (k25/2), x6[i] + (k26/2), x7[i] + (k27/2), x8[i] + (k28/2));
            double k36 = h*f6(t[i]+(h/2), x1[i] + (k21/2), x2[i] + (k22/2), x3[i] + (k23/2), x4[i] + (k24/2), x5[i] + (k25/2), x6[i] + (k26/2), x7[i] + (k27/2), x8[i] + (k28/2));
            double k37 = h*f7(t[i]+(h/2), x1[i] + (k21/2), x2[i] + (k22/2), x3[i] + (k23/2), x4[i] + (k24/2), x5[i] + (k25/2), x6[i] + (k26/2), x7[i] + (k27/2), x8[i] + (k28/2));
            double k38 = h*f8(t[i]+(h/2), x1[i] + (k21/2), x2[i] + (k22/2), x3[i] + (k23/2), x4[i] + (k24/2), x5[i] + (k25/2), x6[i] + (k26/2), x7[i] + (k27/2), x8[i] + (k28/2));

            double k41 = h*f1(t[i]+h, x1[i]+k31, x2[i]+k32, x3[i]+k33, x4[i]+k34, x5[i]+k35, x6[i]+k36, x7[i]+k37, x8[i]+k38);
            double k42 = h*f2(t[i]+h, x1[i]+k31, x2[i]+k32, x3[i]+k33, x4[i]+k34, x5[i]+k35, x6[i]+k36, x7[i]+k37, x8[i]+k38);
            double k43 = h*f3(t[i]+h, x1[i]+k31, x2[i]+k32, x3[i]+k33, x4[i]+k34, x5[i]+k35, x6[i]+k36, x7[i]+k37, x8[i]+k38);
            double k44 = h*f4(t[i]+h, x1[i]+k31, x2[i]+k32, x3[i]+k33, x4[i]+k34, x5[i]+k35, x6[i]+k36, x7[i]+k37, x8[i]+k38);
            double k45 = h*f5(t[i]+h, x1[i]+k31, x2[i]+k32, x3[i]+k33, x4[i]+k34, x5[i]+k35, x6[i]+k36, x7[i]+k37, x8[i]+k38);
            double k46 = h*f6(t[i]+h, x1[i]+k31, x2[i]+k32, x3[i]+k33, x4[i]+k34, x5[i]+k35, x6[i]+k36, x7[i]+k37, x8[i]+k38);
            double k47 = h*f7(t[i]+h, x1[i]+k31, x2[i]+k32, x3[i]+k33, x4[i]+k34, x5[i]+k35, x6[i]+k36, x7[i]+k37, x8[i]+k38);
            double k48 = h*f8(t[i]+h, x1[i]+k31, x2[i]+k32, x3[i]+k33, x4[i]+k34, x5[i]+k35, x6[i]+k36, x7[i]+k37, x8[i]+k38);

            x1[i+1] = x1[i] + ((k11 + 2*k21 + 2*k31 + k41)/6);
            x2[i+1] = x2[i] + ((k12 + 2*k22 + 2*k32 + k42)/6);
            x3[i+1] = x3[i] + ((k13 + 2*k23 + 2*k33 + k43)/6);
            x4[i+1] = x4[i] + ((k14 + 2*k24 + 2*k34 + k44)/6);
            x5[i+1] = x5[i] + ((k15 + 2*k25 + 2*k35 + k45)/6);
            x6[i+1] = x6[i] + ((k16 + 2*k26 + 2*k36 + k46)/6);
            x7[i+1] = x7[i] + ((k17 + 2*k27 + 2*k37 + k47)/6);
            x8[i+1] = x8[i] + ((k18 + 2*k28 + 2*k38 + k48)/6);
            t[i+1]  = t[i]  + h;

        }// fim o loop for

        //Saída na tela
        for(int i = 1; i<(N-1); i++)
        {
            //double t0, double r10, double r20, double x10, double x20, double v1x0, double v1y0, double v2x0, double v2y0
            System.out.println("t = "+t[i]+" || r1 = " + x1[i] + " || r2 = "+ x2[i] + " || teta1 = "+ x3[i] + " || teta2 = " + x4[i] + " || vel.teta1x = " + x5[i] + " || vel.teta1y = " + x6[i] + " || vel.teta2x = " + x7[i] + " || vel.teta2y = " + x8[i]);
        }


        // Arquivo .txt
        try
        {
            // Cria um arquivo para ser escrito
            FileOutputStream arquivo  = new FileOutputStream("arquivo.txt");

            // Algo para escrever, neste caso pr.
            PrintWriter pr = new PrintWriter(arquivo);

            //Saída no arquivo
            for(int i = 1; i<(N-1); i++)
            {
                //double t0, double r10, double r20, double x10, double x20, double v1x0, double v1y0, double v2x0, double v2y0
               //pr.println("t = "+t[i]+" || r1 = " + x1[i] + " || r2 = "+ x2[i] + " || teta1 = "+ x3[i] + " || teta2 = " + x4[i] + " || vel.teta1x = " + x5[i] + " || vel.teta1y = " + x6[i] + " || vel.teta2x = " + x7[i] + " || vel.teta2y = " + x8[i]);
                pr.println(t[i]+"   "+x1[i]);
            }

            pr.close();
            arquivo.close();
        }//try
        catch (Exception e)
        {
            System.out.println("Erro escrever o arquivo");

        }//catch


    }// fim o método penduloDuploMolas




}// fim da classe PenduloDuploMolas
