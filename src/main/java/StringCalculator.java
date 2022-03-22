//import org.omg.CORBA.SystemException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StringCalculator {
    public int add(String values) throws Exception { //"1,1"
        if (values.length() > 0) {
            int temp;
            String delimiter = null;

            //List delimiters = new ArrayList<>();
            int auxcount = 0;
            try {
                temp = Integer.parseInt("" + values.charAt(0));
            } catch (Exception e) {
                if (("" + values.charAt(0)) == "-") {
                    delimiter = null;
                } else
                    //en este if itero el values para sacar la informacion de los caracteres que tengo antes del primer numero

                    if (values.contains("][")) {
                        System.out.println("aca1");
                        for (int i = 0; i < values.length(); i++) {
                            if (values.charAt(i) == ']') {

                                auxcount = i;

                            }
                        }
                        String aux = "";

                        for (int i = 0; i <= auxcount; i++) {
                            aux += "" + values.charAt(i);
                        }
                        //tambien consigo llegar al limite y encontrar el delimitador

                        delimiter = "" + values.charAt(auxcount + 2);
                        System.out.println("delimiter " + delimiter);

                        values = values.replace(aux, delimiter);
                        System.out.println(values);
                    } else
                        //este if lo hice para cuando solo hay  delimitadores en un grupo de []
                        if (("" + values.charAt(0)).equals("[")) {
                            /*values.replace("[", ".").replace("]","@");*/
                            String aux = "[";
                            int count = 0;
                            delimiter = "" + values.charAt(1);
                            System.out.println("delimiter" + delimiter);
                            while (!("" + values.charAt(count)).equals("]")) {

                                count++;
                                aux += "" + values.charAt(count);

                            }
                            System.out.println("aux aqui" + aux);
                            values = values.replace(aux, delimiter);
                        } else {
                            delimiter = "" + values.charAt(0);
                        }
            }


            //splitedlist va a contener los numeros posteriormente para sumarlos
            String[] splittedList = null;
            if (delimiter != null) {

                splittedList = values.substring(1, values.length()).split(delimiter);
                System.out.println("splittedlist" + splittedList);
            } else {
                splittedList = values.split("[,|\n]");
            }
            //aca hace la suma
            ArrayList<Integer> numberList = new ArrayList<Integer>();
            int accumulator = 0;
            for (String element : splittedList) {
                System.out.println(element);
                int tempValue = Integer.parseInt(element);
                if (tempValue < 0) {
                    throw new Exception("NegativeNumberException");
                }
                if (tempValue > 1000) {
                    continue;
                }
                numberList.add(tempValue);
            }
            for (Integer number : numberList) {
                accumulator += number;
            }
            return accumulator;
        }
        return 0;
    }

}