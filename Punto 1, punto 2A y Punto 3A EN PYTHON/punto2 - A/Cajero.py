#Diapositiva 22
BILLETES=[100000, 50000, 20000, 10000]
CANTIDAD_BILLETES=[300, 200, 100, 50]
BILLETES_DEVUELTOS=[0,0,0,0]

def cambiar(cantidadCambiar, billetesDevueltos):
    if(cantidadCambiar % 10000 != 0):
        print("La cantidad a cambiar no es divisible por 10.000")
        return False
    indice = 0
    while (cantidadCambiar > 0) and indice< len(BILLETES):
        if(BILLETES[indice]<=cantidadCambiar and CANTIDAD_BILLETES[indice]>0):
            cantidadCambiar-=BILLETES[indice]
            CANTIDAD_BILLETES[indice]-=1
            billetesDevueltos[indice]+=1
        else:
            indice+=1
    if cantidadCambiar > 0:
        return False
    return billetesDevueltos

def isDivisible(cantidad):
    esDivisible=False
    if(cantidad % 10000 == 0):
        esDivisible= True
    return esDivisible

def main():
    cantidadDevolver=180000
    billetesDevueltos = [0,0,0,0]
    if(isDivisible(cantidadDevolver)):
        resultado = cambiar(cantidadDevolver, billetesDevueltos)
        if(resultado == False):
            print("No se puede cambiar esa suma de dinero")
        else:
            print("Los billetes cambiados son: " 
                  "\n100.000: ", billetesDevueltos[0],
                  "\n50.000: ", billetesDevueltos[1],
                  "\n20.000: ", billetesDevueltos[2], 
                  "\n10.000: ", billetesDevueltos[3])
    else:
        print("La cantidad a cambiar no es divisible por 10.000")

if __name__ == "__main__":
    main()