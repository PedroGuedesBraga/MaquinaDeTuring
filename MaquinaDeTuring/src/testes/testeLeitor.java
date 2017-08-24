package testes;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;
import org.xml.sax.ext.LexicalHandler;

import Projeto.Leitor;

public class testeLeitor {

	@Test
	public void test() {
		
		Projeto.Leitor leitor = new Leitor("C:/Users/pc1/Desktop/teste.txt");
		LinkedList<String[]> a = leitor.ler();
		a.size();
		
		
		
	}

}
