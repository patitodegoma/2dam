__author__ = 'Andrés Macías Jiménez'
# -*- coding: utf-8 -*-

""" Implementar un script con python que nos ofrezca la funcionalidad de una calculadora estándar.

Debe imprimir, inicialmente, un menú que se parezca al siguiente:

CALCULADORA
=============
1. Sumar
2. Restar
3. Multiplicar
4. Dividir
0. Salir

Cada una de las operaciones deben ser binarias (con dos números), y deben realizarse en una función diferente.

El programa debe repetirse hasta que se escoja la opción de salida.  """


def calculator():
    print ("\nCALCULADORA"
           "\n============="
           "\n1.- Sumar"
           "\n2.- Restar"
           "\n3.- Multiplicar"
           "\n4.- Dividir"
           "\n0.- Salir")

    operacion = int (input("\nPor favor, introduzca el código correspondiente a la operación a realizar: "))
    while (operacion < 0 or operacion > 4):
        print ("\nOpción incorrecta")
        operacion = int (input("\nPor favor, introduzca el código correspondiente a la operación a realizar: "))

    return operacion


def sumar():
    a = int (input ("Introduzca el primer sumando: "))
    b = int (input ("Introduzca el segundo sumando: "))
    print("\nEl resultado de sumar %d y %d es %d" % (a, b, a + b))


def restar ():
    a = int (input ("Introduzca el minuendo: "))
    b = int (input ("Introduzca el sustraendo: "))
    print("\nEl resultado de restar %d menos %d es %d" % (a, b, a - b))


def multiplicar ():
    a = int (input ("Introduzca el primer factor: "))
    b = int (input ("Introduzca el segundo factor: "))
    print("\nEl resultado de multiplicar %d por %d es %d" % (a, b, a * b))


def dividir ():
    a = int (input ("Introduzca el dividendo: "))
    b = int (input ("Introduzca el divisor: "))
    while (b == 0):
        b = int (input("Por favor, introduzca un valor distinto de cero para el divisor: "))
    print("\nEl resultado de dividir %d entre %d es %.3f" % (float(a), float(b), a / b))


operacion = calculator()

while (operacion != 0):
    if (operacion == 1):
        sumar()
    elif (operacion == 2):
        restar ()
    elif (operacion == 3):
        multiplicar ()
    else:
        dividir ()

    operacion = calculator()

print("\nGracias por usar mi calculadora")
