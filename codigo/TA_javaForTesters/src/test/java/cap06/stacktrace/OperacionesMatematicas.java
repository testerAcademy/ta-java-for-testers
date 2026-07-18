package cap06.stacktrace;

import cap06.throw_throws.Utils;

public class OperacionesMatematicas {
    public static void main(String[] args) throws Exception {
        int num1 = 10;
        int num2 = 0;
        try{
            int res = Utils.divicionEnteros(num1, num2);
            System.out.println("Resultado = " + res);
        } catch (Exception e){
            //e.printStackTrace();
            throw new Exception("Error al dividir 2 numeros enteros. ", e);
        }
    }
}
