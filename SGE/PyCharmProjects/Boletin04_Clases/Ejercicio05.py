__author__ = 'Andrés Macías Jiménez'
# -*- coding: utf-8 -*-

""" Crear una clase fecha, con atributos día, mes y año y sus métodos: """

class Fecha():
    def __init__(self, dia, mes, anyo):
        self.dia = dia
        self.mes = mes
        self.anyo = anyo
        self.validar()

    def leer(self):
        self.dia = int(input("Introduzca el día: "))
        self.mes = int(input("Introduzca el mes: "))
        self.anyo = int(input("Introduzca el año (1900 - 2050): "))
        self.validar()

    def bisiesto(self):
        if ((self.anyo % 4 == 0 and self.anyo % 100 != 0) or self.anyo % 400 == 0):
            return True
        else:
            return False

    def dias_mes(self, mes):
        if (mes == 1 or mes == 3 or mes == 5 or mes == 7 or mes == 8 or mes == 10 or mes == 12):
            return 31
        elif (mes == 2 and self.bisiesto()):
            return 29
        elif (mes == 2 and not self.bisiesto()):
            return 28
        else:
            return 30

    def validar(self):
        if (self.mes < 1 or self.mes > 12):
            self.mes = 1
        if (self.anyo < 1900 or self.anyo > 2050):
            self.anyo = 1900
        if (self.dia < 1 or self.dia > self.dias_mes(self.mes)):
            self.dia = 1

    def corta(self):
        return print("%02d-%02d-%04d" % (self.dia, self.mes, self.anyo))

    def dias_transcurridos(self):
        dias = 0
        anyos_transcurridos = self.anyo - 1900
        for i in range (1, self.mes):
            dias += self.dias_mes(i)
        dias += anyos_transcurridos * 365
        num_bisiestos = 0
        for i in range (1900, self.anyo):
            dummy_fecha = Fecha(1, 1, i)
            if (dummy_fecha.bisiesto()):
                num_bisiestos+=1
        dias += num_bisiestos
        dias_transcurridos = self.dia - 1
        dias += dias_transcurridos
        return dias

    def dia_semana(self):
        return self.dias_transcurridos() % 7

    def larga(self):   #EL ENUNCIADO ES INCORRECTO, EL DÍA 1/1/1900 FUE LUNES, NO DOMINGO
        diasem = ""
        txtmes = ""
        if (self.dia_semana() == 0):
            diasem = "Lunes"
        elif (self.dia_semana() == 1):
            diasem = "Martes"
        elif (self.dia_semana() == 2):
            diasem = "Miércoles"
        elif (self.dia_semana() == 3):
            diasem = "Jueves"
        elif (self.dia_semana() == 4):
            diasem = "Viernes"
        elif (self.dia_semana() == 5):
            diasem = "Sábado"
        else:
            diasem = "Domingo"

        if (self.mes == 1):
            txtmes = "enero"
        elif (self.mes == 2):
            txtmes = "febrero"
        elif (self.mes == 3):
            txtmes = "marzo"
        elif (self.mes == 4):
            txtmes = "abril"
        elif (self.mes == 5):
            txtmes = "mayo"
        elif (self.mes == 6):
            txtmes = "junio"
        elif (self.mes == 7):
            txtmes = "julio"
        elif (self.mes == 8):
            txtmes = "agosto"
        elif (self.mes == 9):
            txtmes = "septiembre"
        elif (self.mes == 10):
            txtmes = "octubre"
        elif (self.mes == 11):
            txtmes = "noviembre"
        else:
            txtmes = "diciembre"

        return print("%s %d de %s de %d" % (diasem, self.dia, txtmes, self.anyo))

    def dias_entre(self, fecha_usuario):
        tamanyo_primera = self.dias_transcurridos()
        tamanyo_usuario = fecha_usuario.dias_transcurridos()
        if (tamanyo_primera > tamanyo_usuario):
            return tamanyo_primera - tamanyo_usuario
        else:
            tamanyo_usuario - tamanyo_primera

    def siguiente(self):
        if (self.dia == 28 and self.mes == 2 and not self.bisiesto()):
            self.dia = 1
            self.mes += 1
        elif (self.dia == 29 and self.mes == 2):
            self.dia = 1
            self.mes += 1
        elif (self.dia == 30 and (self.mes == 4 or self.mes == 6 or self.mes == 9 or self.mes == 11)):
            self.dia = 1
            self.mes += 1
        elif (self.dia == 31 and (self.mes == 1 or self.mes == 3 or self.mes == 5 or self.mes == 7 or self.mes == 8 or self.mes == 10)):
            self.dia = 1
            self.mes += 1
        elif (self.dia == 31 and self.mes == 12 and self.anyo < 2050):
            self.dia = 1
            self.mes = 1
            self.anyo += 1
        elif (self.dia == 31 and self.mes == 12 and self.anyo == 2050):
            self.dia = 1
            self.mes = 1
            self.anyo = 1900
        else:
            self.dia += 1
        return self

    def anterior(self):
        if (self.dia == 1):
            if (self.mes == 1 and self.anyo > 1900):
                self.dia = 31
                self.mes = 12
                self.anyo -= 1
            elif (self.mes == 2 or self.mes == 4 or self.mes == 6 or self.mes == 8 or self.mes == 9 or self.mes == 11):
                self.dia = 31
                self.mes -= 1
            elif (self.mes == 5 or self.mes == 7 or self.mes == 10 or self.mes == 12):
                self.dia = 30
                self.mes -= 1
            elif (self.mes == 3 and self.bisiesto()):
                self.dia = 29
                self.mes = 2
            elif (self.mes == 3 and not self.bisiesto()):
                self.dia = 28
                self.mes = 2
        else:
            self.dia -=1
        return self


    def igual_que(self, fecha_usuario):
        if (fecha_usuario.dia == self.dia and fecha_usuario.mes == self.mes and fecha_usuario.anyo == self.anyo):
            return True
        else:
            return False

    def menor_que(self, fecha_usuario):
        if (self.dias_transcurridos() > fecha_usuario.dias_transcurridos):
            return True
        else:
            return False

    def mayor_que(self, fecha_usuario):
        if (self.dias_transcurridos() < fecha_usuario.dias_transcurridos):
            return True
        else:
            return False



mi_fecha = Fecha (19, 10, 2015)
mi_fecha.corta()
mi_fecha.larga()
