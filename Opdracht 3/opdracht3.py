from grid import *

def rasterline(x1, y1, x2, y2):
   
    #stukje code voor als de lijn niet niet stijgt of daalt Y1 == Y2
    if (y2-y1 == 0):
        
        if x2 > x1:
            for x in range (x1, x2+1):
                g.addPoint(x, y2)
        else:
            for x in range (x2, x1+1):
                g.addPoint(x, y2)
        
        
    #stukje code voor als de lijn verticaal is x1 == x2
    elif (x2-x1 == 0):
        
        if y2 > y1:
            for y in range(y1, y2+1):
                g.addPoint(x2, y) 

        else: 
            for y in range(y2, y1+1):
                g.addPoint(x2, y)
        
        
    
    else:
        a = (y2-y1)/(x2-x1)
        print(a)
        if a == 1:
            print("dalend")
            if x2 > x1:
                for x in range (x1, x2+1):
                    g.addPoint(x, y1)
                    y1+=1
            else:
                for x in range (x2, x1+1):
                    g.addPoint(x, y2)
                    y2+=1         

        elif a == -1:
            print("stijgend")
            if x2 > x1:
                for x in range (x1, x2+1):
                    g.addPoint(x, y1)
                    y1-=1
            else:
                for x in range (x2, x1+1):
                    g.addPoint(x, y2)
                    y2-=1
        ##Bresenham-algoritme
        elif (a > 0) and (a < 1):
            print("algo")
            if x1 > x2:
                x1, x2 = x2, x1
                y1, y2 = y2, y1
                print("reversed")
            for x in range (x1 , x2+1):
                    g.addPoint(x, round(a*(x-(x1))+y1))            
        ##Bresenham-algoritme voor in andere octant 
        elif (a < 0) and (a > -1):
            if x1 > x2:
                x1, x2 = x2, x1
                y1, y2 = y2, y1
                print("reversed")
            for x in range (x1 , x2+1):
                    g.addPoint(x, round(a*(x-(x1))+y1))
        else:
            print("kan alleen hellingen van 0 tot 45 graden berekenen")

    g.draw() 

g = Grid(50,50)             
rasterline(0, 1, 50, 10)
