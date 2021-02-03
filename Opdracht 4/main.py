from lines import Lines
import math as m


class Rendering:
    l = Lines(1920, 1080)


    """
    Hier wordt de matrix vermenigvuldiging plaatsgevonden
    als eerste wordt er gekeken of de of dimensies kloppen zodat de vermenigvulding uitgevoerd kan worden
    """
    def matrix_multiplication(self, matrix, vector):
        final_matrix = [0] * len(vector)
        if len(matrix[0]) == len(vector):
            for kolom in range(0, len(matrix)):
                for rij in range(0, len(vector)):
                    final_matrix[kolom] += matrix[kolom][rij] * vector[rij]
        
        return final_matrix


    def draw(self, coordinaten, ribben):
        for rib in ribben:
            self.l.addLine(
                coordinaten[rib[0]], coordinaten[rib[1]])

    def run(self, rotatie):
        kubus = Kubus(0, -100, 150, -200)
        final_punten = self.isometric(kubus.to_coordinates(), rotatie)
        self.draw(final_punten, kubus.ribben)
        self.l.draw()

    def isometric(self, coordinaten, rotatie):

        isometrische_coordinaten = []

        alpha = m.asin(m.tan(m.radians(30)))
        beta = m.radians(45 + rotatie)

        matrix_1 = ((m.cos(beta), 0, -1 * m.sin(beta)),
                   (0, 1, 0), (m.sin(beta), 0, m.cos(beta)))
        matrix_2 = ((1, 0, 0), (0, m.cos(alpha), m.sin(alpha)),
                   (0, -1 * m.sin(alpha), m.cos(alpha)))
        

        for c in coordinaten:
            final_matrix_1 = self.matrix_multiplication(matrix_1, c)
            final_matrix_2 = self.matrix_multiplication(matrix_2, final_matrix_1)
            isometrische_coordinaten.append((final_matrix_2[0] + 500, final_matrix_2[1] + 250))
        return isometrische_coordinaten



class Kubus():

    """
    hoekpunten van de kubus
    """
    hoekpunten = [[-1, -1, -1],
                  [1, -1, -1],
                  [1,  1, -1],
                  [-1,  1, -1],
                  [-1, -1,  1],
                  [1, -1,  1],
                  [1,  1,  1],
                  [-1,  1,  1]]


    """
    ribben van de kubus
    """
    ribben = ((0, 1),
              (1, 2),
              (2, 3),
              (0, 3),
              (0, 4),
              (1, 5),
              (2, 6),
              (3, 7),
              (4, 5),
              (5, 6),
              (6, 7),
              (4, 7))


    """
    x, y, z coordinaten
    en de schaal
    """
    def __init__(self, x, y, z, schaal):
        self.x = x
        self.y = y
        self.z = z
        self.schaal = schaal

    """
    de vertexen worden naar coordinaten omgezet
    """
    def to_coordinates(self):
        
        coordinates = []
        for v in self.hoekpunten:
            x = v[0] * 0.5 * self.schaal + self.x
            y = v[1] * 0.5 * self.schaal + self.y
            z = v[2] * 0.5 * self.schaal + self.z
            coordinates.append((x, y, z))
        return coordinates


    
graden = 30
render = Rendering()
render.run(graden)