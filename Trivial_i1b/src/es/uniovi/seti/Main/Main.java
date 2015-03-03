package es.uniovi.seti.Main;

import es.uniovi.seti.Parser.GIFTParser;

public class Main {

	public static void main(String[] args) {
		System.out.println(new GIFTParser(args[0]).getQuestions());
	}

}
