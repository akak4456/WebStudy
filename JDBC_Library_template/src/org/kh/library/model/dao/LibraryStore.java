package org.kh.library.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.kh.library.model.vo.Library;

public interface LibraryStore {
	public ArrayList<Library> selectList(Connection conn) throws SQLException;
	public Library selectOne(String userId, Connection conn) throws SQLException;
	public Library selectOneByName(String bookName, Connection conn) throws SQLException;
	public int insertLibrary(Library library, Connection conn) throws SQLException;
}
