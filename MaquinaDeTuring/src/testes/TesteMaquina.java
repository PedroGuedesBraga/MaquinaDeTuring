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
	MaquinaDeTuring mt = new MaquinaDeTuring("C:/Users/pedro/Desktop/UFCG/MaquinaDeTuring/MaquinaDeTuring/src/testes/binarioToDecimal.txt");
	
	mt.processa("10101");
	System.out.println("Teste binarioToDecimal");
	System.out.println(mt.estadoAtual);
	
	} 

	
	@Test
	public void testMaquina(){
		MaquinaDeTuring mt = new MaquinaDeTuring("C:/Users/pedro/Desktop/UFCG/MaquinaDeTuring/MaquinaDeTuring/src/testes/arquivoPalindromo.txt");
		mt.processa("010");
		LinkedList<String> resultado = mt.listaDeCaracteres; 
		for(String i : mt.listaDeCaracteres){
			System.out.print(i);
		}
		
		System.out.println("Teste palindromo");
		System.out.println();
		System.out.println(mt.estadoAtual ); 
		
	} 
	
	@Test
	public void test3(){
		MaquinaDeTuring mt = new MaquinaDeTuring("C:/Users/pedro/Desktop/UFCG/MaquinaDeTuring/MaquinaDeTuring/src/testes/soma_Binaria.txt");
		mt.processa("1_1");
		
		System.out.println("Teste soma_Binaria");
		System.out.println(mt.listaDeCaracteres);
		System.out.println(mt.estadoAtual);
	} 
	
	
	//ParentesesChecker CONSIDERA "_" PERTENCENTE A *
	//BINARY MULTIPLICATION - TAMBÉM CONSIDERA "_" PERTENCENTE A *
/*	@Test
	public void test4(){
		MaquinaDeTuring mt = new MaquinaDeTuring("C:/Users/pedro/Desktop/UFCG/MaquinaDeTuring/MaquinaDeTuring/src/testes/parentesesChecker.txt");
		mt.processa("12(2+(3^(4-1)))");
		System.out.println(mt.estadoAtual);
		
	} */
	
	/*@Test
	public void test5(){
		MaquinaDeTuring mt = new MaquinaDeTuring("C:/Users/pedro/Desktop/UFCG/MaquinaDeTuring/MaquinaDeTuring/src/testes/binaryMultiplication.txt");
		mt.processa("1101_1100");
	} */

}
