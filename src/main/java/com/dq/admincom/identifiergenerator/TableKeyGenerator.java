package com.dq.admincom.identifiergenerator;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public class TableKeyGenerator implements IdentifierGenerator, Configurable {
	private static Logger log = Logger.getLogger(TableKeyGenerator.class);
	private String prefixe;
	private String sqlSelect;
	private String sqlInsert;
	private String sqlUpdate;

	/**
	 * generate
	 */
	@Override
	public synchronized Serializable generate(SessionImplementor session,
			Object object) throws HibernateException {
		Serializable id = "1";

		if ((this.sqlSelect != null) && (this.sqlInsert != null)
				&& (this.sqlUpdate != null)) {
			try {
				id = initializePreviousValueHolder(session);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new HibernateException(e.getMessage());
			}
		}

		id = this.prefixe + id /* NumberUtil.format(id, "") */;

		if (log.isDebugEnabled()) {
			log.debug("-- id:" + id);
		}

		return id;
	}

	/**
	 * configure
	 * 
	 * @param type
	 * @param params
	 * @param dialect
	 * @throws MappingException
	 */
	@Override
	public void configure(Type type, Properties params, ServiceRegistry dialect)
			throws MappingException {
		String coltable = params.getProperty("coltable", "tab");
		String colkey = params.getProperty("colkey", "num");
		String table = params.getProperty("table", "sequencekey");
		String key = params.getProperty("key");

		this.prefixe = params.getProperty("prefixe", "");

		this.sqlSelect = "SELECT " + colkey + " FROM " + table + " WHERE "
				+ coltable + "='" + key + "'";

		this.sqlInsert = "INSERT INTO " + table + " (" + coltable + ", "
				+ colkey + ") VALUES ('" + key + "', ?)";

		this.sqlUpdate = "UPDATE " + table + " SET " + colkey + " = ? WHERE "
				+ coltable + "='" + key + "'";
	}

	/**
	 * initializePreviousValueHolder
	 * 
	 * @param session
	 */
	private Serializable initializePreviousValueHolder(
			SessionImplementor session) throws SQLException {
		Serializable id = "1";

		PreparedStatement st = session.connection().prepareStatement(
				this.sqlSelect);

		try {
			ResultSet rs = st.executeQuery();

			try {
				if (rs.next()) {
					id = new Integer(rs.getInt(1) + 1);
					this.increment(session, ((Integer) id).intValue());
				} else {
					id = new Integer(1);
					this.initialize(session, ((Integer) id).intValue());
				}
			} finally {
				rs.close();
			}
		} finally {
			st.close();
		}

		return id;
	}

	/**
	 * initialize
	 * 
	 * @param session
	 * @param value
	 */
	private void initialize(SessionImplementor session, int value)
			throws SQLException {
		log.debug("-- First Load --");

		PreparedStatement st = session.connection().prepareStatement(
				this.sqlInsert);
		st.setInt(1, value);

		try {
			st.executeUpdate();
		} finally {
			st.close();
		}
	}

	/**
	 * increment
	 * 
	 * @param session
	 * @param value
	 */
	private void increment(SessionImplementor session, int value)
			throws SQLException {
		log.debug("-- Next Load --");

		PreparedStatement st = session.connection().prepareStatement(
				this.sqlUpdate);
		st.setInt(1, value);

		try {
			st.executeUpdate();
		} finally {
			st.close();
		}
	}

	


}
