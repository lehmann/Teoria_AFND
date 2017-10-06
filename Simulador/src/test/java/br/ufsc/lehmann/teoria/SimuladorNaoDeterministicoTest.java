package br.ufsc.lehmann.teoria;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import br.ufsc.lehmann.teoria.util.io.AutomatoLoad;

public class SimuladorNaoDeterministicoTest {

	SimuladorNaoDeterministico simulador = new SimuladorNaoDeterministico();
	
	@Test
	public void emptyAutomaton() throws Exception {
		/**
		 *  -> q0
		 */
		AutomatoND automato = new AutomatoLoad().carregaArquivo(new File("./src/test/resources/empty.automaton"));
		assertTrue(simulador.aceitacao(automato, ""));
		assertFalse(simulador.aceitacao(automato, "a"));
		assertFalse(simulador.aceitacao(automato, "b"));
	}
	
	@Test
	public void basicDeterministic() throws Exception {
		/**
		 *  -> q0 ---a---> q1 ---b---> q2
		 */
		AutomatoND automato = new AutomatoLoad().carregaArquivo(new File("./src/test/resources/basicDeterministic.automaton"));
		assertFalse(simulador.aceitacao(automato, ""));
		assertFalse(simulador.aceitacao(automato, "a"));
		assertTrue(simulador.aceitacao(automato, "ab"));
		assertFalse(simulador.aceitacao(automato, "abab"));
	}
	
	@Test
	public void basicLoopDeterministic() throws Exception {
		/**
		 *  -> q0 ---a---> q1 ---b---> q2
		 *                 ^           |
		 *                 |-----a-----|
		 */
		AutomatoND automato = new AutomatoLoad().carregaArquivo(new File("./src/test/resources/basicLoopDeterministic.automaton"));
		assertFalse(simulador.aceitacao(automato, ""));
		assertFalse(simulador.aceitacao(automato, "a"));
		assertTrue(simulador.aceitacao(automato, "ab"));
		assertFalse(simulador.aceitacao(automato, "aba"));
		assertTrue(simulador.aceitacao(automato, "abab"));
	}
	
	@Test
	public void basicNonDeterministic() throws Exception {
		/**
		 *  -> q0 ---&---> q1 ---b---> q2
		 */
		AutomatoND automato = new AutomatoLoad().carregaArquivo(new File("./src/test/resources/basicNonDeterministic.automaton"));
		assertFalse(simulador.aceitacao(automato, ""));
		assertFalse(simulador.aceitacao(automato, "a"));
		assertFalse(simulador.aceitacao(automato, "ab"));
		assertTrue(simulador.aceitacao(automato, "b"));
		assertFalse(simulador.aceitacao(automato, "ba"));
	}
	
	@Test
	public void basicNonDeterministic2() throws Exception {
		/**
		 *  -> q0 ---&a---> q1 ---b---> q2
		 */
		AutomatoND automato = new AutomatoLoad().carregaArquivo(new File("./src/test/resources/basicNonDeterministic2.automaton"));
		assertFalse(simulador.aceitacao(automato, ""));
		assertFalse(simulador.aceitacao(automato, "a"));
		assertTrue(simulador.aceitacao(automato, "ab"));
		assertTrue(simulador.aceitacao(automato, "b"));
		assertFalse(simulador.aceitacao(automato, "ba"));
	}
	
	@Test
	public void forkingPathNonDeterministic() throws Exception {
		/**
		 *        ---&---> q3 ---a---
		 *       /                   \
		 *  -> q0 ---&---> q1 ---b---> q2
		 */
		AutomatoND automato = new AutomatoLoad().carregaArquivo(new File("./src/test/resources/forkingPathNonDeterministic.automaton"));
		assertFalse(simulador.aceitacao(automato, ""));
		assertTrue(simulador.aceitacao(automato, "a"));
		assertFalse(simulador.aceitacao(automato, "ab"));
		assertTrue(simulador.aceitacao(automato, "b"));
		assertFalse(simulador.aceitacao(automato, "ba"));
	}
	
	@Test
	public void loopingPathNonDeterministic() throws Exception {
		/**
		 *     a,b
		 *    /   \ 
		 *    \   /
		 *  -> q0 ---b---> q1
		 */
		AutomatoND automato = new AutomatoLoad().carregaArquivo(new File("./src/test/resources/loopingPathNonDeterministic.automaton"));
		assertFalse(simulador.aceitacao(automato, ""));
		assertFalse(simulador.aceitacao(automato, "a"));
		assertTrue(simulador.aceitacao(automato, "ab"));
		assertTrue(simulador.aceitacao(automato, "b"));
		assertFalse(simulador.aceitacao(automato, "ba"));
		assertFalse(simulador.aceitacao(automato, "aaabbbabaaba"));
		assertTrue(simulador.aceitacao(automato, "bbbab"));
		assertTrue(simulador.aceitacao(automato, "babab"));
	}
}
