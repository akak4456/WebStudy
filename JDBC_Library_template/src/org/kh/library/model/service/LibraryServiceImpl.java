package org.kh.library.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.kh.library.common.JDBCTemplate;
import org.kh.library.model.dao.LibraryStoreImpl;
import org.kh.library.model.vo.Library;

public class LibraryServiceImpl implements LibraryService {
	
	LibraryStoreImpl lStore;
	
	public LibraryServiceImpl() {
		lStore = new LibraryStoreImpl();
	}
	
	@Override
	public ArrayList<Library> selectAll() {
		Connection conn = null;
		ArrayList<Library> result = null;
		try {
			conn = JDBCTemplate.getConnection();
			result = lStore.selectList(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Library selectOne(String userId) {
		Connection conn = null;
		Library result = null;
		try {
			conn = JDBCTemplate.getConnection();
			result = lStore.selectOne(userId, conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Library selectOneByName(String bookName) {
		Connection conn = null;
		Library result = null;
		try {
			conn = JDBCTemplate.getConnection();
			result = lStore.selectOneByName(bookName, conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int insertLibrary(Library library) {
		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCTemplate.getConnection();
			result = lStore.insertLibrary(library, conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
