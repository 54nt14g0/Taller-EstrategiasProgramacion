#Diapositiva 18

def lucasDinamicoTabulacion(n, calculados):
    calculados[0]=2
    calculados[1]=1
    for i in range(2, n+1):  
        calculados[i]= calculados[i-1]+calculados[i-2]
    return calculados[n]

def lucasDinamicoMemorizacion(n, memoria):
    memoria[0]=2
    memoria[1]=1

    if(n in memoria):
        return memoria[n]
    valorLucas= lucasDinamicoMemorizacion(n-1, memoria)+ lucasDinamicoMemorizacion(n-2, memoria)
    memoria[n]=valorLucas
    return valorLucas

n = 8 
memoria = {}
calculados=[0]*(n+1)
resultadoMemorizacion = lucasDinamicoMemorizacion(n, memoria)
print(f"El termino {n} de la sucesion de Lucas por memorizacion es: {resultadoMemorizacion}")
resultadoTabulacion = lucasDinamicoTabulacion(n, calculados)
print(f"El termino {n} de la sucesion de Lucas por tabulacion es: {resultadoTabulacion}")