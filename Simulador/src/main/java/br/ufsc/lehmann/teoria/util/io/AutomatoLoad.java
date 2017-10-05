package br.ufsc.lehmann.teoria.util.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import br.ufsc.lehmann.teoria.AutomatoND;

public class AutomatoLoad {

	public AutomatoND carregaArquivo(File input) throws JsonSyntaxException, JsonIOException, FileNotFoundException, IOException {
		try(FileReader reader = new FileReader(input);) {
			return new Gson().fromJson(reader, AutomatoNDArquivo.class);
		}
	}
}
