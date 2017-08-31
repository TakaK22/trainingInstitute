package jin.edu.common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnectCommon {
	DataSource ds;
	protected Connection con;
	private static final String LOOKUP_PATH = "java:comp/env/jdbc/mysql";

	/**
	 * コンストラクタ
	 */
	public DBConnectCommon(){
		ds = null;
		con = null;
	}

	/**
	 * DB接続
	 * @throws SQLException
	 * @throws NamingException
	 */
	public void connect() throws SQLException, NamingException{
		Context ctx = new InitialContext();
		// /jdbc/postgres is the name of the resource above
		ds = (DataSource)ctx.lookup(LOOKUP_PATH);
		con = ds.getConnection();
	}

	/**
	 * DB切断
	 * @throws SQLException
	 */
	public void disConnect() throws SQLException{
			if(con != null) con.close();
			con = null;
	}

}