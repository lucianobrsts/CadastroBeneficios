package br.com.cadastrobeneficios.backup;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MysqlBackup2 {

	private static String dump;

	/**
	 * Classe que realiza de banco de dados MySql
	 * 
	 * @param host
	 *            - Endereço host do banco de Dados ex:localhost
	 * @param bd
	 *            - Nome do Banco de Dados ex:meubd
	 * @param usuario
	 *            - Usuario de acesso ao banco de dados : ex:root
	 * @param senha
	 *            - Senha de Acesso ao banco de dados : ex:1234
	 * @param location
	 *            - Local que será salvo o sql contendo apenas o nome sem a extensão
	 *            ex:c:\\backup
	 * @return - uma string informando se o processo foi salvo com sucesso ou não
	 */
	// public static String exportarBD(String host, String bd, String usuario,
	// String senha, String location) {

	// // local onde se encontra o MysqlDump
	// dump.append("C:\\Program Files\\MySQL\\MySQL Workbench 6.3
	// CE\\mysqldump.exe");
	// // solicitando o host ex:localhost
	// dump.append(" -h");
	// dump.append(host);
	// // solicitando o usuario
	// dump.append(" -u");
	// dump.append(usuario);
	// // solicitando a senha
	// dump.append(" -p");
	// dump.append(senha);
	// // solicitando o bd
	// dump.append(" --add-drop-database -B");// se existir o sql, sobrescreverá
	// dump.append(bd);
	// // solicitando o local para salvar ex:c\\mysql
	// dump.append(" -r");
	// dump.append(location);
	// dump.append(gerarNomeComData());// esse metodo devolverá o ano seguido da
	// hora ex:mysql20170609_073230
	// dump.append(".sql");// add a extensão .sql
	//
	// Process p;
	// try {
	// p = Runtime.getRuntime().exec(dump.toString());
	// p.waitFor();
	// } catch (IOException e) {
	// e.printStackTrace();
	// return "Erro ao realizar Backup";
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// return "Erro ao realizar Backup";
	// }
	// return "Banco de Dados foi Exportado com sucesso para a pasta \n" + location;
	//
	// }
	//
	// /**
	// *
	// * @return a data com o horario
	// */
	// private static String gerarNomeComData() {
	//
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd _ hh:mm:ss");
	//
	// Calendar c = Calendar.getInstance();
	// String s = sdf.format(c.getTime());
	// return s.replace("/", "").replace(" ", "").replace(":", "");
	// }

}
