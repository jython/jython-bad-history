
/*
 * Jython Database Specification API 2.0
 *
 * $Id$
 *
 * Copyright (c) 2001 brian zimmer <bzimmer@ziclix.com>
 *
 */
package com.ziclix.python.sql.handler;

import java.io.*;
import java.sql.*;
import java.math.*;
import org.python.core.*;
import com.ziclix.python.sql.*;
import com.ziclix.python.sql.procedure.*;

/**
 * SQLServer specific data handling.
 *
 * @author brian zimmer
 * @author last revised by $Author$
 * @version $Revision$
 */
public class SQLServerDataHandler extends FilterDataHandler {

	/** Field UNICODE_VARCHAR */
	public static final int UNICODE_VARCHAR = -9;

	/**
	 * Decorator for handling SQLServer specific issues.
	 *
	 * @param datahandler the delegate DataHandler
	 */
	public SQLServerDataHandler(DataHandler datahandler) {
		super(datahandler);
	}

	public Procedure getProcedure(PyCursor cursor, PyObject name) throws SQLException {
		return new SQLServerProcedure(cursor, name);
	}

	/**
	 * Given a ResultSet, column and type, return the appropriate
	 * Jython object.
	 *
	 * <p>Note: DO NOT iterate the ResultSet.
	 *
	 * @param set the current ResultSet set to the current row
	 * @param col the column number (adjusted properly for JDBC)
	 * @param type the column type
	 * @throws SQLException if the type is unmappable
	 */
	public PyObject getPyObject(ResultSet set, int col, int type) throws SQLException {

		PyObject obj = Py.None;

		switch (type) {

			case UNICODE_VARCHAR :
				obj = super.getPyObject(set, col, Types.VARCHAR);
				break;

			default :
				obj = super.getPyObject(set, col, type);
		}

		return (set.wasNull() || (obj == null)) ? Py.None : obj;
	}
}
