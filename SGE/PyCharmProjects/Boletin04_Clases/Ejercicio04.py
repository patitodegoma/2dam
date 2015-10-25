__author__ = 'Andrés Macías Jiménez'
# -*- coding: utf-8 -*-

""" Desarrolla una clase Cafetera con atributos capacidadMaxima y cantidadActual. Implementar los métodos:
    - Constructor con la capacidad máxima de la cafetera, inicializando la actual igual a la máxima
    - Llenar Cafetera, que llena la cafetera
    - Servir Taza(int), que llena una taza de tamaño int. Si no hay suficiente, se echa lo que haya
    - Vaciar cafetera
    - Agregar café """


class Cafetera():
    def __init__(self, capacidad_maxima):
        self.capacidad_maxima = capacidad_maxima
        self.cantidad_actual = capacidad_maxima

    def llenar_cafetera(self):
        self.cantidad_actual = self.capacidad_maxima

    def servir_taza(self, tamano_taza):
        if (self.cantidad_actual >= tamano_taza):
            self.cantidad_actual-=tamano_taza
        else:
            self.cantidad_actual = 0

    def vaciar_cafetera(self):
        self.cantidad_actual = 0

    def agregar_cafe(self, cantidad):
        if (cantidad > self.capacidad_maxima):
            self.llenar_cafetera()
        else:
            self.cantidad_actual+=cantidad

    def __str__(self):
        return "La cafetera, en la que caben %d cc, tiene ahora mismo %d cc" % (self.capacidad_maxima, self.cantidad_actual)



mi_cafetera = Cafetera(150)

print (mi_cafetera)

mi_cafetera.servir_taza(25)

print (mi_cafetera)

mi_cafetera.llenar_cafetera()

print (mi_cafetera)

mi_cafetera.vaciar_cafetera()

print (mi_cafetera)

mi_cafetera.agregar_cafe(70)

print (mi_cafetera)

mi_cafetera.agregar_cafe(1500)

print (mi_cafetera)
