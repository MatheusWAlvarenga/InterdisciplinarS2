package OperationHex;

public class HexToDec {
    //

    //Método que retorna a conversão de hexadecimal em decimal
    public int conversionHexDec(String hex) {
        String digits = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        int value = 0;

        for (int i = 0; i < hex.length(); ++i) {
            char c = hex.charAt(i);
            int d = digits.indexOf(c);
            value = 16 * value + d;
        }
        return value;
    }
}
