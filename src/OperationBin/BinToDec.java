package OperationBin;

public class BinToDec {
//
    //Método que retorna a conversão de binario em decimal
    public int conversionBinDec(String entradaBinDec) {
        int potencia = 0;
        int decimal = 0;
        for (int i = entradaBinDec.length() - 1; i>=0; i-- ) {
            decimal += Math.pow(2, potencia) * Character.getNumericValue(entradaBinDec.charAt(i));
            potencia++;
        }return decimal;
    }

}
