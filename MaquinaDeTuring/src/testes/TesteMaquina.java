package testes;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import Projeto.MaquinaDeTuring;

public class TesteMaquina {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
	MaquinaDeTuring mt = new MaquinaDeTuring("C:/Users/pedro/Desktop/UFCG/MaquinaDeTuring/MaquinaDeTuring/src/testes/arquivoPalindromo.txt");
	mt.processa("10010011");
	System.out.println(mt.estadoAtual);
	
	} 
	
/*	@Test
	public void testSomaBinaria(){
		MaquinaDeTuring mt = new MaquinaDeTuring("C:/Users/pedro/Desktop/UFCG/MaquinaDeTuring/MaquinaDeTuring/src/testes/binarioToDecimal.txt");
		mt.processa("0101");
		LinkedList<String> resultado = mt.listaDeCaracteres; 
		

		
	} */

}
