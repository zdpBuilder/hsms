package com.hsms.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DbBackupUtils {


	/**
	 * 备份数据库
	 * @param username 数据库用户名
	 * @param password 数据库密码
	 * @param dataBaseName 数据库名称
	 * @param host 数据库ip地址 本地支持 localhost
	 * @param port 数据库端口
	 * @param dbBackupBasePath 备份基础路径  eg:D:\\dbback
	 * @return  true 备份成功   false 备份失败
	 */
	public static String  export(String username,String password,String dataBaseName,String host,String port,String dbBackupBasePath) {

		try {
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			String backUpName = date.format(new Date());
			
			String exportPath = dbBackupBasePath + "\\" + backUpName + ".sql";// 导出路径
			StringBuffer command = new StringBuffer();
			
			// 注意空格 // 密码是用的小p，而端口是用的大P。
			command.append("cmd.exe /cmysqldump -u").append(username).append(" -p").append(password).append(" -h")
					.append(host).append(" -P").append(port).append(" ").append(dataBaseName).append(" > ")
					.append(exportPath);
			
			Runtime runtime = Runtime.getRuntime();
			runtime.exec(command.toString());// 执行shell脚本
			System.out.println("数据库备份成功！");
			return exportPath;
		} catch (IOException e) {
			System.out.println("数据库备份异常！");
			e.printStackTrace();
			return null;

		}

	}

	/***
	 * 还原数据库
	 * @param username 数据库用户名
	 * @param password 数据库密码
	 * @param dataBaseName 数据库名称
	 * @param host 数据库ip地址 本地支持 localhost
	 * @param port 数据库端口
	 * @param path 还原数据库的路径
	 * @return true 备份成功   false 备份失败
	 */
	public static boolean importSql(String username,String password,String dataBaseName,String host,String port,String path) {

		Runtime runtime = Runtime.getRuntime();
		// 因为在命令窗口进行mysql数据库的导入一般分三步走，
		// 所以所执行的命令将以字符串数组的形式出现
		String cmdarray[];
		try {
			// 获取拼接的shell字符串
			cmdarray = getImportCommand( username, password, dataBaseName, host, port,path);

			// 执行第一条命令登录到mysql
			Process process = runtime.exec(cmdarray[0]);
			// 进程执行后面的代码
			OutputStream os = process.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(os);
			// 选择数据库和要放在一起执行
			writer.write(cmdarray[1] + "\r\n" + cmdarray[2]);
			writer.flush();
			writer.close();
			os.close();
			System.out.println("数据库还原成功！");
			return true;
		} catch (IOException e) {
			System.out.println("数据库还原异常！");
			e.printStackTrace();
			return false;
		}

	}

	private static String[] getImportCommand(String username,String password,String dataBaseName,String host,String port,String path) throws IOException {

		// 第一步，获取登录命令语句
		String loginCommand = new StringBuffer().append("mysql -u").append(username).append(" -p").append(password)
				.append(" -h")

				.append(host).append(" -P").append(port).toString();

		// 第二步，获取切换数据库到目标数据库的命令语句

		String switchCommand = new StringBuffer("use ").append(dataBaseName).toString();

		// 第三步，获取导入的命令语句

		String importCommand = new StringBuffer("source ").append(path).toString();

		// 需要返回的命令语句数组

		String[] commands = new String[] { loginCommand, switchCommand,

				importCommand };

		return commands;

	}

}
