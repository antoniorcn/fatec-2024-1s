public class TesteString2 { 

    public static void main(String [] args) { 
        String numeros = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) { 
            numeros = numeros + i;
        }
        long end = System.currentTimeMillis();
        double diffSegundos = (end - start) / 1000;
        System.out.println("Segundos: " + diffSegundos);
    }

}