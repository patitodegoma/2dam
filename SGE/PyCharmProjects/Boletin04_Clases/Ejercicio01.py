__author__ = 'Andrés Macías Jiménez'
# -*- coding: utf-8 -*-

""" NÚMEROS FRACCIONARIOS:
    Implementar la clase de los números fraccionarios. El constructor debe, por defecto, poner el denominador a 1.
    Eso permite representar los números enteros como fracciones. Implementar la suma, resta, multiplicacion y division.
    Si el resultado es simplificable, aplicar el algoritmo de Euclides para hacerlo. """


class Fraccion:
    def __init__(self, numerador, denominador = 1):
        self.numerador = numerador
        self.denominador = denominador

    def __str__(self): # Sobrescribimos el método __str__ para que muestre la fracción como numerador/denominador
        return "%d/%d" % (self.numerador, self.denominador)


def mcd (a, b):
    """ Calcula el Máximo Común Divisor de dos números a y b """
    if (b == 0):
        return a
    else:
        return mcd (b, a % b)


def mcm (a, b):
    """ Calcula el Mínimo Común Múltiplo de dos números a y b, basándose en su MCD """
    return a * b / mcd(a, b)


def simplificar (frac):
    return Fraccion (frac.numerador / mcd (frac.numerador, frac.denominador), frac.denominador / mcd (frac.numerador, frac.denominador))


def suma (frac1, frac2):
    return simplificar(Fraccion (frac1.numerador * mcm(frac1.denominador, frac2.denominador) / frac1.denominador +
                     frac2.numerador * mcm(frac1.denominador, frac2.denominador) / frac2.denominador,
                     mcm(frac1.denominador, frac2.denominador)))


def resta (frac1, frac2):
    return simplificar(Fraccion (frac1.numerador * mcm(frac1.denominador, frac2.denominador) / frac1.denominador -
                     frac2.numerador * mcm(frac1.denominador, frac2.denominador) / frac2.denominador,
                     mcm(frac1.denominador, frac2.denominador)))


def multiplicacion (frac1, frac2):
    return simplificar(Fraccion (frac1.numerador * frac2.numerador, frac1.denominador * frac2.denominador))


def division (frac1, frac2):
    return simplificar(Fraccion (frac1.numerador * frac2.denominador, frac1.denominador * frac2.numerador))


