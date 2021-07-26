# F-sica_Computacional

'''
                              Universidade Federal de Goiás (UFG)
                                Instituto de Física (IF UFG)

Autor: Carlos Eduardo da Silva Lima
Tema: Atrator de Lorentz
Linguagem: Python
Diciplina: Física Computacional - UFG
'''

-#Apresentação
print("Método de Runge-Kutta de 4Ordem na linguagem python - Atrator de Loretnz")

-# Inportando bibliotecas externa
import numpy as np
import matplotlib.pyplot as plt
plt.style.use('dark_background')

-# Parâmetros de entrada para o atrator de Lorentz
s = 10
r = 28
b = 8/3

-# Condições iniciais
t0 = 0
x0 = 5.00
y0 = 5.01
z0 = 5.02 
N = 10000
h = 0.01

-# Equações Diferenciais
def f1(t,x,y,z):
    return (s*(y-x))

def f2(t,x,y,z):
    return(r*x-y-x*z)

def f3(t,x,y,z):
    return(x*y-b*z)

-# Arrays para o método de Runge-Kutta de 4Ordem
t  = np.empty(N)
x1 = np.empty(N)
x2 = np.empty(N)
x3 = np.empty(N)

t[0]  = t0
x1[0] = x0
x2[0] = y0
x3[0] = z0

for i in range(N-1):
    
    k11 = h*f1(t[i], x1[i], x2[i], x3[i])
    k12 = h*f2(t[i], x1[i], x2[i], x3[i])
    k13 = h*f3(t[i], x1[i], x2[i], x3[i])

    k21 = h*f1(t[i] + (h/2), x1[i] + (k11/2), x2[i] + (k12/2), x3[i] + (k13/2))
    k22 = h*f2(t[i] + (h/2), x1[i] + (k11/2), x2[i] + (k12/2), x3[i] + (k13/2))
    k23 = h*f3(t[i] + (h/2), x1[i] + (k11/2), x2[i] + (k12/2), x3[i] + (k13/2))

    k31 = h*f1(t[i] + (h/2), x1[i] + (k21/2), x2[i] + (k22/2), x3[i] + (k23/2))
    k32 = h*f2(t[i] + (h/2), x1[i] + (k21/2), x2[i] + (k22/2), x3[i] + (k23/2))
    k33 = h*f3(t[i] + (h/2), x1[i] + (k21/2), x2[i] + (k22/2), x3[i] + (k23/2))

    k41 = h*f1(t[i] +h, x1[i] + k31, x2[i] + k32, x3[i] + k33)
    k42 = h*f2(t[i] +h, x1[i] + k31, x2[i] + k32, x3[i] + k33)
    k43 = h*f3(t[i] +h, x1[i] + k31, x2[i] + k32, x3[i] + k33)

    x1[i+1] = x1[i] + ((k11 + 2*(k21 + k31) + k41)/6)
    x2[i+1] = x2[i] + ((k12 + 2*(k22 + k32) + k42)/6)
    x3[i+1] = x3[i] + ((k13 + 2*(k23 + k33) + k43)/6)
    t[i+1] = t[i] + h

    # Saída na tela
    print("t = ",t[i]," || x = ",x1[i]," || y = ",x2[i]," || z = ",x3[i])

-# Fim do loop for


-# Gráfico
plt.figure(figsize = (10,10))
plt.plot(x1,x2,'-', color='red', alpha = 2, markersize=5)
plt.title("Atrator de Lorentz", color='red', alpha = 10)
plt.xlabel("x1", color='red', alpha = 10)
plt.ylabel("x2", color='red', alpha = 10)
plt.grid(0.5)
