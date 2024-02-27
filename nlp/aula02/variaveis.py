a = "ola..."

b = 10

b = "10"    # colocando o valor de B como string

c = a + b
'''
    Bloco de Comentário geral
'''
"""
    Bloco de comentario para métodos e documentação
"""
# print(a)
# print(c)


# while True:
#    print('Valor 1')
#    print("Valor 2")

# print("Fora do bloco de codigo")

#         0  1  2  3    4    5    6     7
# lista1 = [1, 2, 3, "A", "b", "c", None, [4, 5, 6]]
# print( lista1[5] )
# print( lista1[7] )

from random import random, randint

lista_aleatorios = []

i = 0       # Inicialização
while i < 50:   # Condição
    lista_aleatorios.append( randint(0, 1000) )
    i = i + 1   # Incremento    # i += 1

lista_aleatorios.clear()

#              |--------- Inicialização
#              |  |------ Maximo
#              |  |   |-- Incremento             
for i in range(0, 50, 1):
    lista_aleatorios.append( randint(0, 1000) )

lista_aleatorios = [randint(0, 1000)   for i in range(0, 50, 1)]

print("Lista aleatorio contem: ", len(lista_aleatorios), " elementos")
print(lista_aleatorios)

#          0    1    2
tupla1 = (100, 200, 300)
tupla1[2] = 150
print("Valor 0 da tupla: ", tupla1[1])



