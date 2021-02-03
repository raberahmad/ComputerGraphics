''''
Raber Ahmad 0921954 TI5X

Code is hergebruikt uit mijn eigen opdracht van voorgaande jaren.
'''


from grid import Grid

def rasterline(x0, y0, x1, y1):

    if (y1-y0 == 0): #stukje code voor als de lijn niet niet stijgt of daalt y0 == y1
        
        if x1 > x0:
            for x in range (x0, x1+1):
                g.addPoint(x, y1)
        else:
            for x in range (x1, x0+1):
                g.addPoint(x, y1)    
    elif (x1-x0 == 0): #stukje code voor als de lijn verticaal is x0 == x1
        
        if y1 > y0:
            for y in range(y0, y1+1):
                g.addPoint(x1, y) 

        else: 
            for y in range(y1, y0+1):
                g.addPoint(x1, y)
    else:
        a = (y1-y0)/(x1-x0)
        print(a)
        if a == 1:
            print("dalend")
            if x1 > x0:
                for x in range (x0, x1+1):
                    g.addPoint(x, y0)
                    y0+=1
            else:
                for x in range (x1, x0+1):
                    g.addPoint(x, y1)
                    y1+=1         
        elif a == -1:
            print("stijgend")
            if x1 > x0:
                for x in range (x0, x1+1):
                    g.addPoint(x, y0)
                    y0-=1
            else:
                for x in range (x1, x0+1):
                    g.addPoint(x, y1)
                    y1-=1
        elif (a > 0) and (a < 1): ##Bresenham-algoritme
            print("algo")
            if x0 > x1:
                x0, x1 = x1, x0
                y0, y1 = y1, y0
                print("reversed")
            for x in range (x0 , x1+1):
                    g.addPoint(x, round(a*(x-(x0))+y0))            
        elif (a < 0) and (a > -1): ##Bresenham-algoritme voor in andere octant 
            if x0 > x1:
                x0, x1 = x1, x0
                y0, y1 = y1, y0
                print("reversed")
            for x in range (x0 , x1+1):
                    g.addPoint(x, round(a*(x-(x0))+y0))
        else:
            print("kan alleen hellingen van 0 tot 45 graden berekenen")







# testcode
# let op: de beoordeling wordt gedaan op basis van andere waarden
g = Grid(20, 20)
rasterline(0, 0, 19, 19)
rasterline(0, 10, 19, 0)
g.draw()
