package br.unisinos.edu.teoria;

import java.nio.file.Path;

/**
 * Classe utilitaria.
 * 
 * @author Cristiano Farias <cristiano@ccfdeveloper.com>
 * @since 12/09/2020
 */
public class Util {

	/**
	 * Retorna o caminho da pasta de recursos do sistema.
	 * 
	 * @author Cristiano Farias <cristiano@ccfdeveloper.com>
	 * @since 12/09/2020
	 * @return
	 */
	public static Path pathResources() {
		try {
			return Path.of(Util.class.getResource("resources").toURI());
		} catch (Exception e) {
			System.out.println("Impossivel resolver o Path");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Retorna o caminhoda pasta de recursos somado com os paths informados por
	 * parametro.
	 * 
	 * @author Cristiano Farias <cristiano@ccfdeveloper.com>
	 * @since 12/09/2020
	 * @param paths
	 * @return
	 */
	public static Path pathResources(String... paths) {
		Path thisPath = pathResources();
		return Path.of(thisPath.toString(), paths);
	}

	// public static void main(String[] args) {
	// System.out.println(Util.pathResources());
	// System.out.println(Util.pathResources("novo", "velho", "arquivo.txt"));
	// }
}
