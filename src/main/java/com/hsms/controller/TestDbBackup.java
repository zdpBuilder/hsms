package com.hsms.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class TestDbBackup {
   
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.databaseName}")
	private String dataBaseName;
	
	@Value("${jdbc.host}")
	private String host;
	
	@Value("${jdbc.port}")
	private String port;
	
	@Value("${jdbc.dbBackupBasePath}")
	private String dbBackupBasePath;

	/**
	 * 根据属性文件的配置导出指定位置的指定数据库到指定位置
	 * 
	 * 备份数据库
	 * @return
	 */
	
	@RequestMapping("import")
	@ResponseBody
	public int  importSqlTest() {
		importSql("D:\\dbback\\2018-12-09.sql");
		return 1; 
	}
	
	@RequestMapping("export")
	@ResponseBody
	public int  exportSqlTest() {
		  export();
		return 1; 
	}
	public void export() {

		try {
			String command = getExportCommand();// 拼接shell脚本命令字符串
			Runtime runtime = Runtime.getRuntime();
			runtime.exec(command);// 执行shell脚本
			System.out.println("数据库备份成功！");
		} catch (IOException e) {
			System.out.println("数据库备份异常！");
			e.printStackTrace();

		}

	}

	/**
	 * 
	 * 根据属性文件的配置导出指定位置的指定数据库到指定位置
	 * 
	 * 备份数据库
	 */
	public void importSql(String url) {

		Runtime runtime = Runtime.getRuntime();

		// 因为在命令窗口进行mysql数据库的导入一般分三步走，
		//所以所执行的命令将以字符串数组的形式出现

		String cmdarray[];

		try {

			cmdarray = getImportCommand(url);

			Process process = runtime.exec(cmdarray[0]);
      
			// 执行了第一条命令登录到mysql

			// 进程执行后面的代码

			OutputStream os = process.getOutputStream();

			OutputStreamWriter writer = new OutputStreamWriter(os);

			// 选择数据库和要放在一起执行

			writer.write(cmdarray[1] + "\r\n" +cmdarray[2]);
			writer.flush();
			writer.close();
			os.close();

			System.out.println("数据库还原成功！");

		} catch (IOException e) {

			System.out.println("数据库还原异常！");

			e.printStackTrace();

		}

	}

	private String getExportCommand() throws IOException {

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String backUpName = date.format(new Date());

		String exportPath = dbBackupBasePath + "\\" + backUpName + ".sql";// 导出路径
		StringBuffer command = new StringBuffer();

		// 注意空格 // 密码是用的小p，而端口是用的大P。
		command.append("cmd.exe /cmysqldump -u").append(username).append(" -p").append(password).append(" -h")
				.append(host).append(" -P").append(port)
				.append(" ").append(dataBaseName).append(" > ")
				.append(exportPath);
		
		return command.toString();
 
	}

	private String[] getImportCommand(String path) throws IOException {

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
