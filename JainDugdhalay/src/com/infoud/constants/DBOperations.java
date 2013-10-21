package com.infoud.constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;

import com.infoud.db.DBConnection;

public class DBOperations {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Object> selectAllRecordsForModel(String query, Class className) {
		List<Object> list = new ArrayList<Object>();

		Connection conn = DBConnection.connect();

		try {

			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);

			BeanProcessor beanProcessor = new BeanProcessor();
			list = beanProcessor.toBeanList(rs, className);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBConnection.close(conn);

		return list;
	}
}
