package Application;

import OperationDec.DecToAny;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int number = 0;
		String numberHexa = "";
		int baseOut = 0;
		int baseInput = 0;
		float result;

		// Menu selection input base.
		System.out.print("\n 1 Decimal \n 2 Octal \n 3 Binário \n 4 Hexadecimal\nEscolha a base de entrada: ");

		// Input data verification
		try {
			baseInput =  input.nextInt();
			boolean verify = Integer.toString(baseInput).matches("-?[1-4]{1,1}+");
			if (verify == false){
				throw new Exception();
			}
		} catch (Exception err) {
			System.out.print("Opção inválida");
			System.exit(0);
		}

		// To input Decimal
		if (baseInput == 1) {
			System.out.print("\nDigite um número Decimal: ");

			// Input data verification
			try {
				number = input.nextInt();
				boolean verify = Integer.toString(number).matches("-?[0-9]{1,}+");
				if (verify == false){
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.print("Não foi inserido um número na base Decimal");
				System.exit(0);
			}

			// Menu selection output base.
			System.out.print("\n 1 Octal \n 2 Binário \n 3 Hexadecimal \nEscolha a base de saída: ");

			// Option Output verification
			try {
				baseOut = input.nextInt();
				boolean verify = Integer.toString(baseOut).matches("-?[1-3]{1,1}+");
				if (verify == false){
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.print("Opção inválida");
				System.exit(0);
			}

			if(baseOut == 1) {
				DecToAny dec = new DecToAny();
				ArrayList res =  new ArrayList();
				res = dec.decToAny(number,8);
				System.out.print("\nO número decimal "+number+" convertido em octal é: \n" );
				for (int i = res.size()-1; i>=0 ; i--){
					System.out.print(res.get(i));
				}
				System.out.println("\n");

			} else if(baseOut == 2) {
				DecToAny dec = new DecToAny();
				ArrayList res =  new ArrayList();
				res = dec.decToAny(number,2);
				System.out.print("\nO número decimal "+number+" convertido em binário é: \n" );
				for (int i = res.size()-1; i>=0 ; i--){
					System.out.print(res.get(i));
				}
				System.out.println("\n");

			} else if(baseOut == 3) {
				DecToAny dec = new DecToAny();
				ArrayList res =  new ArrayList();
				res = dec.decToAny(number,16);
				Object check;
				Object A = 10;
				Object B = 11;
				Object C = 12;
				Object D = 13;
				Object E = 14;
				Object F = 15;
				System.out.print("\nO número decimal "+number+" convertido em hexadecimal é: \n" );
				for (int i = res.size()-1; i>=0 ; i--){
					check = res.get(i);
					if(check == A){
						System.out.print("A");
					} else if(res.get(i) == B){
						System.out.print("B");
					} else if (res.get(i) == C){
						System.out.print("C");
					}else if (res.get(i) == D){
						System.out.print("D");
					}else if (res.get(i) == E){
						System.out.print("E");
					}else if (res.get(i) == F){
						System.out.print("F");
					} else{
						System.out.print(res.get(i));
					}
				}
				System.out.println("\n");
			}
		}
		// To input Octal
		else if (baseInput == 2) {
			System.out.print("\nDigite um número octal: ");

			// Input data verification
			try {
				number = input.nextInt();
				boolean verify = Integer.toString(number).matches("-?[0-7]{1,}+");
				if (verify == false){
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.print("Não foi inserido um número na base Octal");
				System.exit(0);
			}

			// Menu selection output base.
			System.out.print("\n 1 Decimal \n 2 Binário \n 3 Hexadecimal\nEscolha a base de saída: ");

			// Option Output verification
			try {
				baseOut = input.nextInt();
				boolean verify = Integer.toString(baseOut).matches("-?[1-3]{1,1}+");
				if (verify == false){
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.print("Opção inválida");
				System.exit(0);
			}

			if(baseOut == 1) {
				OperationOct.OctToDec octToDec = new OperationOct.OctToDec();
				int response = octToDec.conversionOctDec(number);
				System.out.print("\nO número octal "+number+" convertido em decimal é: \n" );
				System.out.print(response);

			} else if(baseOut == 2) {
				// First Convert Oct To Dec
				OperationOct.OctToDec octToDec = new OperationOct.OctToDec();
				int response = octToDec.conversionOctDec(number);

				// Now Convert Dec To Bin
				DecToAny dec = new DecToAny();
				ArrayList res = new ArrayList();
				res = dec.decToAny(response,2);
				System.out.print("\nO número octal "+number+" convertido em binário é: \n" );
				for (int i = res.size()-1; i>=0 ; i--){
					System.out.print(res.get(i));
				}
				System.out.println("\n");

			} else if(baseOut == 3) {
				// First Convert Oct To Dec
				OperationOct.OctToDec octToDec = new OperationOct.OctToDec();
				int response = octToDec.conversionOctDec(number);

				// Now, Convert Dec To Hex
				DecToAny dec = new DecToAny();
				ArrayList res =  new ArrayList();
				res = dec.decToAny(response,16);
				Object check;
				Object A = 10;
				Object B = 11;
				Object C = 12;
				Object D = 13;
				Object E = 14;
				Object F = 15;
				System.out.print("\nO número Octal "+number+" convertido em hexadecimal é: \n" );
				for (int i = res.size()-1; i>=0 ; i--){
					check = res.get(i);
					if(check == A){
						System.out.print("A");
					} else if(res.get(i) == B){
						System.out.print("B");
					} else if (res.get(i) == C){
						System.out.print("C");
					}else if (res.get(i) == D){
						System.out.print("D");
					}else if (res.get(i) == E){
						System.out.print("E");
					}else if (res.get(i) == F){
						System.out.print("F");
					} else{
						System.out.print(res.get(i));
					}
				}
				System.out.println("\n");
			}
		}
		// To input Binário
		else if (baseInput == 3) {
			System.out.print("\nDigite um número binário: ");

			// Input data verification
			try {
				number = input.nextInt();
				boolean verify = Integer.toString(number).matches("-?[0-1]{1,}+");
				if (verify == false){
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.print("Não foi inserido um número na base Binária");
				System.exit(0);
			}

			// Menu selection output base.
			System.out.print("\n 1 Octal \n 2 Decimal \n 3 Hexadecimal\nEscolha a base de saída: ");

			// Option Output verification
			try {
				baseOut = input.nextInt();
				boolean verify = Integer.toString(baseOut).matches("-?[1-3]{1,1}+");
				if (verify == false){
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.print("Opção inválida");
				System.exit(0);
			}

			if(baseOut == 1) {
				// First Convert Bin To Dec
				OperationBin.BinToDec binToDec = new OperationBin.BinToDec();
				int response = binToDec.conversionBinDec(Integer.toString(number));

				// Now, Convert Dec To Oct
				DecToAny dec = new DecToAny();
				ArrayList res =  new ArrayList();
				res = dec.decToAny(response,8);
				System.out.print("\nO número binário "+number+" convertido em octal é: \n" );
				for (int i = res.size()-1; i>=0 ; i--){
					System.out.print(res.get(i));
				}
				System.out.println("\n");

			} else if(baseOut == 2) {
				// First Convert Bin To Dec
				OperationBin.BinToDec binToDec = new OperationBin.BinToDec();
				int response = binToDec.conversionBinDec(Integer.toString(number));
				System.out.print("\nO número binário "+number+" convertido em decimal é: \n" );
				System.out.println(response);

			}else if(baseOut == 3) {
				// First Convert Bin To Dec
				OperationBin.BinToDec binToDec = new OperationBin.BinToDec();
				int response = binToDec.conversionBinDec(Integer.toString(number));

				// Now, Convert Dec To Hex
				DecToAny dec = new DecToAny();
				ArrayList res =  new ArrayList();
				res = dec.decToAny(response,16);
				Object check;
				Object A = 10;
				Object B = 11;
				Object C = 12;
				Object D = 13;
				Object E = 14;
				Object F = 15;
				System.out.print("\nO número binário "+number+" convertido em hexadecimal é: \n" );
				for (int i = res.size()-1; i>=0 ; i--){
					check = res.get(i);
					if(check == A){
						System.out.print("A");
					} else if(res.get(i) == B){
						System.out.print("B");
					} else if (res.get(i) == C){
						System.out.print("C");
					}else if (res.get(i) == D){
						System.out.print("D");
					}else if (res.get(i) == E){
						System.out.print("E");
					}else if (res.get(i) == F){
						System.out.print("F");
					} else{
						System.out.print(res.get(i));
					}
				}

				System.out.println("\n");
			}
		}
		// To input Hexadecimal
		else if (baseInput == 4) {
			System.out.print("\nDigite um número hexadecimal: ");

			// Input data verification
			try {
				numberHexa = input.next();
				boolean verify = numberHexa.matches("-?[0-9a-fA-F]+");
				if (verify == false){
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.print("Não foi inserido um número na base Hexadecimal");
				System.exit(0);
			}

			// Menu selection output base.
			System.out.print("\n 1 Octal \n 2 Decimal \n 3 Binário\nEscolha a base de saída: ");

			// Option Output verification
			try {
				baseOut = input.nextInt();
				boolean verify = Integer.toString(baseOut).matches("-?[1-3]{1,1}+");
				if (verify == false){
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.print("Opção inválida");
				System.exit(0);
			}

			if(baseOut == 1) {
				// First Convert Hex to Dec
				OperationHex.HexToDec hexToDec = new OperationHex.HexToDec();
				int response = hexToDec.conversionHexDec(numberHexa);

				// Now, Convert Dec to Oct
				DecToAny dec = new DecToAny();
				ArrayList res =  new ArrayList();
				res = dec.decToAny(response,8);
				System.out.print("\nO número hexadecimal "+numberHexa+" convertido em octal é: \n" );
				for (int i = res.size()-1; i>=0 ; i--){
					System.out.print(res.get(i));
				}
				System.out.println("\n");

			} else if(baseOut == 2) {
				// Convert Hex to Dec
				OperationHex.HexToDec hexToDec = new OperationHex.HexToDec();
				int response = hexToDec.conversionHexDec(numberHexa);
				System.out.print("\nO número hexadecimal "+numberHexa+" convertido em Decimal é: \n" );
				System.out.println(response);
			} else if(baseOut == 3) {
				// First Convert Hex to Dec
				OperationHex.HexToDec hexToDec = new OperationHex.HexToDec();
				int response = hexToDec.conversionHexDec(numberHexa);

				// Now Convert Dec To Bin
				DecToAny dec = new DecToAny();
				ArrayList res = new ArrayList();
				res = dec.decToAny(response,2);
				System.out.print("\nO número Hexadecimal "+numberHexa+" convertido em binário é: \n" );
				for (int i = res.size()-1; i>=0 ; i--){
					System.out.print(res.get(i));
				}
				System.out.println("\n");
			}
		}
	}
}

