#               0               1                  2
# contato1 = ["João Silva", "(11) 1111-1111", "joao@teste.com"]
# contato2 = ["Maria Silva", "maria@teste.com", "(11) 2222-2222"]

# "chave":"valor"
contato1 = {    "nome": "João Silva", 
                "tel":"(11) 1111-1111",
                "email": "joao@teste.com",
                "rg": "11.111.111-1"  }

contato2 = {    "tel": "(11) 2222-2222",
                "email": "maria@teste.com",
                "nome": "Maria Silva" }

contato2["email"] = "maria@fatec.edu"

print( contato1["email"])
print( contato2["email"])

# if "rg" in contato1:
#     print(contato1["rg"])

print("RG: ", contato1.get("rg", "desconhecido"))