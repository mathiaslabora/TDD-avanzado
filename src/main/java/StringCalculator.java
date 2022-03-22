//import org.omg.CORBA.SystemException;

import java.util.ArrayList;
import java.util.Locale;

public class StringCalculator {
    public int add(String values) throws Exception { //"1,1"
        if (values.length() > 0) {
            int temp;
            String delimiter = null;
            try {
                temp = Integer.parseInt("" + values.charAt(0));
            } catch (Exception e) {
                if (("" + values.charAt(0)) == "-") {
                    delimiter = null;
                } else /*{
                    delimiter = "" + values.charAt(0);
                }*/
                if (("" + values.charAt(0)).equals("[")) {
                    /*values.replace("[", ".").replace("]","@");*/
                    String aux = "[";
                    int count = 0;
                    System.out.println("acaa");
                    delimiter = "" + values.charAt(1);
                    System.out.println("delimiter"+delimiter);
                    while (!("" + values.charAt(count)).equals("]")) {

                        count++;
                        aux += "" + values.charAt(count);

                    }System.out.println("aux aqui" + aux);
                    values = values.replace(aux, delimiter);
                }else { delimiter = "" + values.charAt(0);}
            }


            System.out.println(values);
            String[] splittedList = null;
            if (delimiter != null) {
                /*if(delimiter.length()>1){
                    splittedList = values.substring(values.length()+1).split(delimiter);
                    System.out.println("Estoy dentro del if"+splittedList);
                }*/
                splittedList = values.substring(1, values.length()).split(delimiter);
                System.out.println("splittedlist"+splittedList);
            } else {
                splittedList = values.split("[,|\n]");
            }

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