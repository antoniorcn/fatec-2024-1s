public class TesteOperadores { 
    public static void main(String args[]) { 
        int a = 10;
        int b = 20;

        // a++;
        // ++b;

        // int c = a + b;
        int c = a++ + ++b;
        System.out.println("C: " + c);
    }
}