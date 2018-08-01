package br.com.cadastrobeneficios.backup;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import br.com.cadastrobeneficios.util.FacesUtil;

public class MysqlBackup {

	public MysqlBackup() {

	}

	public void realizarBackup() {
		final List<String> comandos = new ArrayList<String>();
		String dir = "C:/BKControlAtividades";
		List<String> lista = new ArrayList<>(10);
		File diretorio = new File(dir);
		File fList[] = diretorio.listFiles();
		if (fList.length == 0) {
			comandos.add("C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysqlpump.exe");

			comandos.add("-h");
			comandos.add("localhost");
			comandos.add("-p");
			comandos.add("3306");
			comandos.add("-U");
			comandos.add("root");
			comandos.add("-F");
			comandos.add("c");
			comandos.add("-b");
			comandos.add("-v");
			comandos.add("-f");

			comandos.add("C:\\BKControlAtividades" + 1 + " " + getDateTime() + ".backup");
			comandos.add("cadastrobeneficios");
			ProcessBuilder pb = new ProcessBuilder(comandos);
			pb.environment().put("password", "123456");

			try {
				final Process process = pb.start();
				final BufferedReader r = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				String line = r.readLine();
				while (line != null) {
					System.err.println(line);
					line = r.readLine();
				}
				r.close();

				process.waitFor();
				process.destroy();
				FacesUtil.adicionarMensagemInfo("Backup realizado com sucesso.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			for (int i = 0; i < fList.length; i++) {
				lista.add(fList[i].getName());
			}

			char recebe = Collections.max(lista).charAt(0);

			comandos.add("C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysqlpump.exe");

			comandos.add("-h");
			comandos.add("localhost");
			comandos.add("-p");
			comandos.add("3306");
			comandos.add("-U");
			comandos.add("root");
			comandos.add("-F");
			comandos.add("c");
			comandos.add("-b");
			comandos.add("-v");
			comandos.add("-f");

			comandos.add("C:\\BKControlAtividades\\" + (Character.getNumericValue(recebe) + 1) + " " + getDateTime()
					+ ".backup");
			comandos.add("cadastrobeneficios");
			ProcessBuilder pb = new ProcessBuilder(comandos);

			pb.environment().put("password", "123456");

			try {
				final Process process = pb.start();
				final BufferedReader r = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				String line = r.readLine();
				while (line != null) {
					System.err.println(line);
					line = r.readLine();
				}
				r.close();

				process.waitFor();
				process.destroy();
				FacesUtil.adicionarMensagemInfo("Backup realizado com sucesso.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		MysqlBackup backup = new MysqlBackup();
		backup.realizarBackup();
	}

	private static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy HHmm");
		Date date = new Date();
		return dateFormat.format(date);
	}

}
