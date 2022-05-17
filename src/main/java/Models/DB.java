package Models;


import lombok.NonNull;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class DB {


	private static DB _instance = null;
	private String _sql;
	private final Connection _connection;
	private Statement _statement;

	public static DB GetInstance() throws Exception {
		if (_instance == null)
			_instance = new DB();
		return _instance;
	}

	public void CreateTable(@NonNull String TableName, @NonNull HashMap<String, String> Fields) throws SQLException {
		StringBuilder values = new StringBuilder();
		int x = 1;
		for (var key : Fields.entrySet()) {

			values.append("%s %s".formatted(key.getKey(), key.getValue()));
			if (x < Fields.size())
				values.append(",");
			x++;
		}
		this._sql = "CREATE TABLE IF NOT EXISTS %s (%s)".formatted(TableName, values.toString());
		System.out.println(this._sql);
		this._statement = this._connection.createStatement();
		this._statement.executeUpdate(this._sql);
	}

	public <T> ArrayList<T> Select(String sql, Class<T> tClass) throws SQLException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
		this._sql = sql;
		this._statement = this._connection.createStatement();
		var results = this._statement.executeQuery(this._sql);
		return MapResults(tClass, results);
	}

	public int Insert(@NonNull String Table, @NonNull HashMap<String, String> Fields) throws SQLException {
		StringBuilder values = new StringBuilder();
		int x = 1;
		for (var ignored : Fields.entrySet()) {

			values.append("?");
			if (x < Fields.size())
				values.append(",");
			x++;
		}
		this._sql = "INSERT INTO %s (%s) values (%s)".formatted(Table, String.join(",", Fields.keySet()), values.toString());
		System.out.println(this._sql);

		var prepareStatement = this._connection.prepareStatement(this._sql, Statement.RETURN_GENERATED_KEYS);
		x = 1;
		for (var key : Fields.entrySet()) {
			prepareStatement.setString(x, key.getValue());
			x++;
		}
		prepareStatement.executeUpdate();
		var resultSet = prepareStatement.getGeneratedKeys();
		int id = 0;
		if (resultSet.next()) {
			id = resultSet.getInt(1);
		}
		return id;

	}

	public void Update(@NonNull String TableName, HashMap<String, String> fields, String operation, HashMap<String, String> where ) throws SQLException {
		StringBuilder values = new StringBuilder();
		var x = 1;
		this._statement = this._connection.createStatement();
		for (var key : fields.entrySet()) {

			values.append(key.getKey()).append(" = ?");
			if (x < fields.size())
				values.append(",");
			x++;
		}
		var sql = "UPDATE %s set %s WHERE %s %s %s".formatted(TableName, values, where.keySet().stream().findFirst().get(), operation, where.entrySet().stream().findFirst().get().getValue());
		System.out.println(sql);
		var prepareStatement = this._connection.prepareStatement(sql);
		x = 1;
		for (var key : fields.entrySet()) {
			System.out.println("index: " + x + " value: " + key.getValue());
			prepareStatement.setString(x, key.getValue());
			x++;
		}
		int result = prepareStatement.executeUpdate();
		System.out.println(result);
	}


	private DB() throws Exception {
		Properties prop = new Properties();
		FileInputStream config = new FileInputStream("src/config.properties");
		prop.load(config);
		String _url = prop.getProperty("db.name");
		if (_url == null)
			throw new Exception("No database name found in config");
		this._connection = DriverManager.getConnection(_url);
	}

	private <T> ArrayList<T> MapResults(Class<T> tClass, ResultSet results) throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
		var list = new ArrayList<T>();

		while (results.next()) {
			T record = tClass.getDeclaredConstructor().newInstance();
			for (var i = 0; i < results.getMetaData().getColumnCount(); i++) {
				Class<?> type = record.getClass();
				Field prop = type.getField(results.getMetaData().getColumnName(i + 1));
				prop.set(record, prop.getType().cast(results.getObject(i + 1)));
			}
			list.add(record);
		}
		return list;
	}

}

