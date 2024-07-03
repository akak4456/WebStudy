package org.kh.library.controller;

import java.util.ArrayList;

import org.kh.library.model.service.LibraryServiceImpl;
import org.kh.library.model.vo.Library;

public class LibraryController implements LibraryControllerI {
	LibraryServiceImpl lService;
	
	public LibraryController() {
		lService = new LibraryServiceImpl();
	}
	@Override
	public ArrayList<Library> selectAll() {
		ArrayList<Library> result = lService.selectAll();
		return result;
	}

	@Override
	public Library selectOne(String userId) {
		Library result = lService.selectOne(userId);
		return result;
	}

	@Override
	public Library selectOneByName(String bookName) {
		Library result = lService.selectOneByName(bookName);
		return result;
	}

	@Override
	public int insertLibrary(Library library) {
		int result = lService.insertLibrary(library);
		return result;
	}

}
