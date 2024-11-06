def sumaArreglo( inicio, final, arreglo):
    if(final == inicio):
        return arreglo[inicio]
    splitter = (inicio + final) // 2
    return sumaArreglo(inicio, splitter, arreglo) + sumaArreglo(splitter+1, final, arreglo)

def main():
    arreglo = [1,2,3,4,5,6]
    resultado = sumaArreglo(0, len(arreglo)-1, arreglo)
    print("La suma del arreglo es:", resultado)

if __name__ == "__main__":
    main()