package es.uniovi.seti.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import es.uniovi.seti.Parser.GIFTParser;
import es.uniovi.seti.Parser.XMLParser;

public class Main {

	public static void main(String[] args) {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		showHelp();
		while(true){
			
			try {
				System.out.print("> ");
				
				String[] line = input.readLine().split(" ");
				
				if(line[0].equals("read")){
					readCommand(line);
				} else if (line[0].equals("exit"))
					return ;	
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private static void readCommand(String[] line){
		String file = line[1];
		String extenssion = file.substring(file.lastIndexOf("."));
		if(extenssion.equals(".gift")){
			System.out.println(new GIFTParser(file).getQuestions());
		} else if (extenssion.equals(".xml")){
			System.out.println(new XMLParser(file).getQuestions());
		}
	}

	private static void showHelp() {
		System.out.println("This is the help:");
		System.out.println("Introduce read and the name of the file to read a file");
		System.out.println("Introduce exit to exit the program");
		
	}

}
