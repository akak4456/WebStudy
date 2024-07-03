package org.kh.library.controller;

import java.util.ArrayList;

import org.kh.library.model.vo.Library;

public interface LibraryControllerI {
	public ArrayList<Library> selectAll();
	public Library selectOne(String userId);
	public Library selectOneByName(String bookName);
	public int insertLibrary(Library library);
}
