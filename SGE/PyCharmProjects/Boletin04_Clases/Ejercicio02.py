__author__ = 'Andrés Macías Jiménez'
# -*- coding: utf-8 -*-

""" Crea una clase rectángulo que modele rectángulos por medio de cuatro puntos (los vértices). Dispondrá de un
    constructor, que cree un rectángulo partiendo de sus cuatro vértices. La clase también incluirá un método para
    calcular la superficie y otro que desplace el rectángulo en el plano. """

class Punto:
    def __init__(self, x, y):
        self.x = x
        self.y = y


class Rectangulo:
    def __init__(self, sup_izq, sup_der, inf_izq, inf_der):
        self.sup_izq = sup_izq
        self.sup_der = sup_der
        self.inf_izq = inf_izq
        self.inf_der = inf_der

    def superficie(self):
        return (self.inf_izq.y - self.sup_izq.y) * (self.sup_der.x - self.sup_izq.x)

    def desplazamiento (self, x, y):
        self.sup_izq.x = Punto(self.sup_izq.x + x, self.sup_izq.y + y)
        self.sup_der.x = Punto(self.sup_der.x + x, self.sup_der.y + y)
        self.inf_izq.x = Punto(self.inf_izq.x + x, self.inf_izq.y + y)
        self.inf_der.x = Punto(self.inf_der.x + x, self.inf_der.y + y)


rect = Rectangulo (Punto(0, 1), Punto(5, 1), Punto(0, 6), Punto(5, 6))
print (rect.superficie())
