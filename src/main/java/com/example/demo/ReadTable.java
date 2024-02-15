package com.example.demo;

import java.sql.*;
import java.util.ArrayList;

public class ReadTable {
    static String url = "jdbc:postgresql://127.0.0.1:5432/Cafedral";
    static String user = "postgres";
    static String password = "1";

    private static ArrayList<String> readColumn(ResultSet tableSet, String columnName) throws SQLException {
        ArrayList<String> arr_data = new ArrayList<String>();
        while (tableSet.next()) {
            arr_data.add(tableSet.getString(columnName));
            System.out.println(tableSet.getString(columnName));
        }
        return arr_data;
    }

    private static ArrayList<ArrayList<String>> readColumns(ResultSet tableSet, String tableName) throws SQLException {
        ResultSetMetaData metaData = tableSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        ArrayList<ArrayList<String>> arr_data = new ArrayList<ArrayList<String>>();
        for (int column = 1; column <= columnCount; column++) {
            String name = metaData.getColumnName(column);
            System.out.println("Имя текущей колонки: " + name);
            arr_data.add(readColumn(tableSet, name));

        }
        return arr_data;
    }

    public static ArrayList<ArrayList<String>> readTable(String tableName) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM \"" + tableName + "\"");
            ArrayList<ArrayList<String>> arr_data = new ArrayList<ArrayList<String>>();
            arr_data = readColumns(resultSet, tableName);
            connection.close();
            return arr_data;
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к базе данных: " + e.getMessage());
        }
        return null;
    }
}