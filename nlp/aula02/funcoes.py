def nome_funcao():
    print("Faz algo")

def somar(num1=0, num2=0):
    s = num1 + num2
    print(f"A soma é: {s}")

def somar_varios(*numeros):
    s = 0
    for n in numeros:
        s += n
    print(f"Soma é: {s}")
    return s

s2 = somar_varios(10, 20, 30, 40) + 200
print("Resultado: ", s2)