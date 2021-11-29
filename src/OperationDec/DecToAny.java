package OperationDec;

import java.util.ArrayList;
//

public class DecToAny {

    public ArrayList decToAny(int input, int base){
        ArrayList convert = new ArrayList();
        String output = "";

        while(input > 0 ) {
            convert.add(input%base);
            input /= base;
        }
        return convert;

    }
}
