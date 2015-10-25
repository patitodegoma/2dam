__author__ = 'Andrés Macías Jiménez'
# -*- coding: utf-8 -*-

""" Define una clase Linea con dos atributos, puntoA y puntoB. La clase debe tener los métodos de desplazamiento y uno
    de impresión. """

class Punto:
    def __init__(self, x, y):
        self.x = x
        self.y = y

class Linea:
    def __init__(self, puntoA, puntoB):
        self.puntoA = puntoA
        self.puntoB = puntoB

    def mueve_derecha(self, desplazamiento):
        self.puntoA = Punto (self.puntoA.x + desplazamiento, self.puntoA.y)
        self.puntoB = Punto (self.puntoB.x + desplazamiento, self.puntoB.y)

    def mueve_izquierda(self, desplazamiento):
        self.puntoA = Punto (self.puntoA.x - desplazamiento, self.puntoA.y)
        self.puntoB = Punto (self.puntoB.x - desplazamiento, self.puntoB.y)

    def mueve_abajo(self, desplazamiento):
        self.puntoA = Punto (self.puntoA.x, self.puntoA.y + desplazamiento)
        self.puntoB = Punto (self.puntoB.x, self.puntoB.y + desplazamiento)

    def mueve_arriba(self, desplazamiento):
        self.puntoA = Punto (self.puntoA.x, self.puntoA.y - desplazamiento)
        self.puntoB = Punto (self.puntoB.x, self.puntoB.y - desplazamiento)

    def to_string(self):    # Se pide un metodo propiamente dicho en el enunciado, se podria sobrescribir __str__
                            # como he hecho en los demás ejercicios.
        return print("[(%.1f, %.1f), (%.1f, %.1f)]" % (self.puntoA.x, self.puntoA.y, self.puntoB.x, self.puntoB.y))


mi_linea = Linea (Punto(1,2), Punto(3, 3))

mi_linea.to_string()

mi_linea.mueve_abajo(5)
mi_linea.mueve_izquierda(3)
mi_linea.mueve_derecha(10)
mi_linea.mueve_arriba(8)

mi_linea.to_string()