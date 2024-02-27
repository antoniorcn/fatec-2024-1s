public class TesteStrings { 
    public static void main(String args[]) { 
        String nome1 = "Maria";
        String nome2 = "MARIA";

        nome2 = nome2 + "";

        System.out.println("Nome1: " + nome1);
        System.out.println("Nome2: " + nome2);

        if (nome1.equalsIgnoreCase(nome2)) { 
            System.out.println("São iguais");
        } else { 
            System.out.println("São diferentes");
        }
    }
}