package br.unisinos.edu.teoria.encoder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import br.unisinos.edu.teoria.EncondingType;
import br.unisinos.edu.teoria.Util;

public class Program {

	private static void writeHeader(final EncondingType encType, final Integer divider) {
		try {

			if (encType == EncondingType.Golomb && (divider == null || divider < 1)) {
				System.out.println("Em caso de codificação Golomb é necessario ser informado um divisor >= 1");
				System.exit(0);
			}

			File saida = Util.pathResources("saida").toFile();
			if (saida.exists()) {
				saida.delete();
			}
			saida.createNewFile();

			Files.write(saida.toPath(), new byte[] { encType.getCode() });
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeHeader(final EncondingType encType) {
		writeHeader(encType, 0);
	}

	private static void writeContent(byte[] bytes) {
		writeContent(bytes, true);
	}

	private static void writeContent(byte[] bytes, boolean append) {
		try {
			File saida = Util.pathResources("saida").toFile();

			if (append) {
				Files.write(saida.toPath(), bytes, StandardOpenOption.APPEND);
			} else {
				Files.write(saida.toPath(), bytes);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(final String[] args) {
		try {

			// Print argumentos.
			for (final String arg : args) {
				System.out.println(arg);
			}

			// Lendo bytes do arquivo de entrada.
			byte[] bytes = new byte[0];
			bytes = Files.readAllBytes(Util.pathResources("arquivo"));

			// PrintBytes
			for (final byte b : bytes) {
				System.out.println(b);
			}

			writeHeader(EncondingType.Delta);

			byte[] bytesApend = new byte[] { 'A', 'P', 'E', 'N', 'D', 'A', 'N', 'D', 'O', ' ' };

			// Escrevendo APENDANDO
			writeContent(bytesApend);

			// ESCREVENDO A ENTRADA NOVAMENTE.
			writeContent(bytes);

		} catch (Exception ioex) {
			ioex.printStackTrace();
		}
	}

}
