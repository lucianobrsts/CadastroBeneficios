package br.com.cadastrobeneficios.backup;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MysqlBackup {

	// Constantes da classe
	private static String VERSION = "4.0.3";
	private static String SEPARATOR = File.separator;
	private static String MYSQL_PATH = "C:" + SEPARATOR + "Arquivos de programas" + SEPARATOR + "MySQL" + SEPARATOR
			+ "MySQL Server 5.7" + SEPARATOR + "bin" + SEPARATOR;
	private static String PRESENTATION = "================================================\n"
			+ " Backup do banco de dados MySQL - Versão " + VERSION + "\n" + " Autor: Luciano Brito dos Santos\n\n"
			+ " Desenvolvido em Julho de 2018\n\n" + " DevSoftware/2018\n "
			+ "===========================================================\n\n";

	// Bancos de dados a serem backupeados
	private static String DATABASE = "controlebeneficios";
	private List<String> dbList = new ArrayList<String>();

	public MysqlBackup() {
		String command = MYSQL_PATH + "mysqldump.exe";
		String[] databases = DATABASE.split("");

		for (int i = 0; i < databases.length; i++) {
			dbList.add(databases[i]);
		}

		// Mostra a apresentação
		System.out.println(PRESENTATION);

		System.out.println("Iniciando backups.\n\n");

		// Contador
		int i = 1;

		// Time
		long time1, time2, time;

		// Início
		time1 = System.currentTimeMillis();

		for (String dbName : dbList) {
			ProcessBuilder pb = new ProcessBuilder(command, "--user=root", "--password=123456", dbName,
					"--result-file=" + "." + SEPARATOR + "Backup" + SEPARATOR + dbName + ".sql");

			try {
				System.out.println("Backup do banco de dados(" + i + "): " + dbName + ".");
				pb.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
			i++;
		}

		// Fim
		time2 = System.currentTimeMillis();

		// Tempo total da operação
		time = time2 - time1;

		// Aviso de sucesso
		System.out.println("\nBackup realizado com sucesso.\n\n");
		System.out.println("Tempo total de processamento: " + time + " ms\n");
		System.out.println("Finalizado.");

		try {
			// paralisa por 2 segundos
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Termina o aplicativo
		System.exit(0);
	}

	public static void main(String[] args) {
		MysqlBackup app = new MysqlBackup();
	}
}
