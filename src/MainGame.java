import java.io.IOException;import java.io.UnsupportedEncodingException;import java.util.Arrays;import java.util.Scanner;import nappulat.Hevonen;import nappulat.Torni;import utils.Lauta;public class MainGame {	final String[] codes = {"♔","♕","♖","♗","♘","♙","♚","♛","♜","♝","♞","♟"};	final static String[] characters = {"A","B","C","D","E","F","G","H"};	static Scanner reader = new Scanner(System.in);	public static void main(String[] args) throws IOException {		Lauta pelilauta = new Lauta();		pelilauta.setNappula(4, 5, new Hevonen(false));		pelilauta.setNappula(5, 3, new Torni(false));		System.out.print(pelilauta);	}		public static String[] getInput() {		System.out.println("From where to where? [xy;xy] (Example: A4;A6): ");		String n = reader.next();				if (!legitString(n)){			System.out.println("Not proper input");			return getInput();		}				String[] inputs = n.split(";");		boolean temp = true;		for (String text : inputs) {			if(!legitPositionString(text)) {				temp = false;			}		}				if (!temp){			System.out.println("Not proper input");			return getInput();		} else {			return inputs;		}	}		public static boolean legitString(String str) {		if(str.length() == 5 && str.substring(2, 3).equals(";")) {			return true;		}				return false;	}		public static boolean legitPositionString(String pos) {		if(pos.length() == 2) {			String start = pos.substring(0, 1);			int end = 0;			try {				String endString = pos.substring(1);				end = Integer.parseInt(endString);			} catch (NumberFormatException e) {				return false;			}			if(Arrays.asList(characters).contains(start.toUpperCase()) && end-1 < 8) {				return true;			}		}				return false;	}}