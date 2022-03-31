package Models;


import lombok.NonNull;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class DB {

	private static DB _instance = null;
	private String _sql;
	private final String _url;
	private final Connection _connection;
	private Statement _statement;


	private DB() throws Exception {
		Properties prop = new Properties();
		FileInputStream config = new FileInputStream("src/config.properties");
		prop.load(config);
		this._url = prop.getProperty("db.name");
		if (this._url == null)
			throw new Exception("No database name found in config");
		this._connection = DriverManager.getConnection(this._url);
	}

	public static DB GetInstance() throws Exception {
		if (_instance == null)
			_instance = new DB();
		return _instance;
	}

	public int CreateTable(@NonNull String TableName, @NonNull HashMap<String, String> Fields) {
		this._sql = "CREATE TABLE " + TableName + " (";
		for (var key : Fields.entrySet()) {
			this._sql += "%s %s,".formatted(key.getKey(), key.getValue());
		}
		return 0;
	}

	public <T> List<T> Select() {
		return null;
	}

	public int Insert(String Table,@NonNull HashMap<String, String> Fields) {
		this._sql = "INSERT INTO %".formatted(Table);
//		Fields.forEach();

		return 0;
	}

	public int Update() {
		return 0;
	}

	public int delete() {
		return 0;
	}


}

