package org.kh.library.view;

import java.util.ArrayList;
import java.util.Scanner;

import org.kh.library.controller.BookController;
import org.kh.library.controller.CustomerController;
import org.kh.library.controller.LibraryController;
import org.kh.library.model.vo.Book;
import org.kh.library.model.vo.Customer;
import org.kh.library.model.vo.Library;

public class LibraryView implements LibraryViewI {

	public Scanner sc = new Scanner(System.in);
	private BookController bController;
	private CustomerController cController;
	private LibraryController lController;
	
	public LibraryView() {
		bController = new BookController();
		cController = new CustomerController();
		lController = new LibraryController();
	};

	public void startLibrary() {
		finish: while (true) {
			int choice = mainMenu();
			switch (choice) {
			case 1:
				bookMenu();
				// System.out.println("1번");
				break;
			case 2:
				customerMenu();
				// System.out.println("2번");
				break;
			case 3:
				libraryMenu();
				// System.out.println("3번");
				break;
			case 0:
				displayMessage("프로그램을 종료합니다.");
				break finish;
			}
		}
	}

	@Override
	public int mainMenu() {
		// TODO Auto-generated method stub
		System.out.println("메인메뉴");
		System.out.println("1. 책 관리");
		System.out.println("2. 회원 관리");
		System.out.println("3. 대여 관리");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		return sc.nextInt();
	}

	@Override
	public void bookMenu() {
		// TODO Auto-generated method stub
		
		while (true) {
			System.out.println("책관리 서브메뉴");
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 책 코드로 조회");
			System.out.println("3. 책 추가하기");
			System.out.println("4. 책 삭제하기");
			System.out.println("5. 메인 메뉴로 이동");
			System.out.print("메뉴 선택 : ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				ArrayList<Book> bookList = bController.selectAllBook();
				if(bookList == null || bookList.isEmpty()) {
					displayError("책 전체 조회 실패!");
				} else {
					dispalyBookList(bookList);
				}
				break;
			case 2:
				int bookNo = inputBookNo();
				Book book = bController.selectBookOne(bookNo);
				if(book == null) {
					displayError("책 조회 실패!");
				} else {
					displayBook(book);
				}
				break;
			case 3:
				// 책 정보 입력받기
				book = this.inputBook();
				// 책 정보 전달 - 컨트롤러
				int result = bController.insertBook(book);
				if (result > 0) {
					this.displaySuccess("책 등록 완료!");
				} else {
					this.displayError("책 등록이 완료되지 않았습니다!");
				}
				break;
			case 4:
				bookNo = inputBookNo();
				result = bController.deleteBook(bookNo);
				if(result > 0) {
					this.displaySuccess("책 삭제 완료!");
				} else {
					this.displayError("책 삭제가 완료되지 않았습니다!");
				}
				break;
			case 5:
				return;
			}
		}

	}

	@Override
	public void customerMenu() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("회원관리 서브메뉴");
			System.out.println("1. 전체 회원 조회");
			System.out.println("2. 회원 이름으로 조회");
			System.out.println("3. 회원 아이디로 조회");
			System.out.println("4. 회원 가입");
			System.out.println("5. 회원 정보수정");
			System.out.println("6. 회원 탈퇴");
			System.out.println("7. 메인 메뉴로 이동");
			System.out.print("메뉴 선택 : ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				ArrayList<Customer> customer = cController.selectAllCustomer();
				if(customer == null || customer.isEmpty()) {
					displayError("회원 정보 전체 조회 실패!");
				} else {
					dispalyCustomerList(customer);
				}
				break;
			case 2:
				String cName = inputCName();
				Customer cResult = cController.selectNameSearch(cName);
				if(cResult == null) {
					displayError("회원 정보 조회 실패!");
				} else {
					diplayCutomerOne(cResult);
				}
				break;
			case 3:
				String cId = inputCId();
				cResult = cController.selectIdSearch(cId);
				if(cResult == null) {
					displayError("회원 정보 조회 실패!");
				} else {
					diplayCutomerOne(cResult);
				}
				break;
			case 4:
				Customer c = inputCustomer();
				int result = cController.insertCustomer(c);
				if(result > 0) {
					displaySuccess("회원 가입 성공!");
				} else {
					displayError("회원 가입 실패!");
				}
				break;
			case 5:
				cId = inputCId();
				cResult = cController.selectIdSearch(cId);
				if(cResult == null) {
					displayError("회원 정보 조회 실패!");
				} else {
					cResult = modifyCustomer();
					cResult.setUserId(cId);
					result = cController.updateCustomer(cResult);
					if(result > 0) {
						displaySuccess("회원 정보 수정 성공!");
					}
				}
				break;
			case 6:
				cId = inputCId();
				result = cController.deleteCustomer(cId);
				if(result > 0) {
					displaySuccess("회원 탈퇴 성공!");
				} else {
					displayError("회원 탈퇴 실패!");
				}
				break;
			case 7:
				return;
			}
		}
	}

	@Override
	public void libraryMenu() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("대여관리 서브메뉴");
			System.out.println("1. 전체 대여 조회");
			System.out.println("2. 대여 회원 아이디로 조회");
			System.out.println("3. 대여 책이름으로 조회");
			System.out.println("4. 대여정보 추가");
			System.out.println("5. 메인 메뉴로 이동");
			System.out.print("메뉴 선택 : ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				ArrayList<Library> lList = lController.selectAll();
				if(lList == null || lList.isEmpty()) {
					displayError("대여 정보 전체 조회 실패!");
				} else {
					displayLibraryList(lList);
				}
				break;
			case 2:
				String cId = inputCId();
				Library result = lController.selectOne(cId);
				if(result == null) {
					displayError("대여 정보 조회 실패!");
				} else {
					displayLibrary(result);
				}
				break;
			case 3:
				String bookName = inputBookName();
				result = lController.selectOneByName(bookName);
				if(result == null) {
					displayError("대여 정보 조회 실패!");
				} else {
					displayLibrary(result);
				}
				break;
			case 4:
				result = insertLibrary();
				int insertResult = lController.insertLibrary(result);
				if(insertResult > 0) {
					displaySuccess("대여 정보 입력 성공!");
				} else {
					displayError("대여 정보 입력 실패!");
				}
				break;
			case 5:
				return;
			}
		}
	}

	@Override
	public void displayLibraryList(ArrayList<Library> list) {
		System.out.println("===== 대여 정보 전체 조회 =====");
		for(Library library : list) {
			System.out.printf("대여 번호 : %d, 이름 : %s, 나이 : %d, 주소 : %s, 책 제목 : %s, 저자명 : %s, 대여날짜 : %s, 반납날짜 : %s\n", 
					library.getLeaseNo(),
					library.getUser().getUserName(),
					library.getUser().getUserAge(),
					library.getUser().getAddr(),
					library.getBook().getBookName(),
					library.getBook().getBookWriter(),
					library.getLeaseDate(),
					library.getReturnDate());
		}
	}

	@Override
	public void displayLibrary(Library library) {
		System.out.println("===== 대여 정보 조회 =====");
		System.out.printf("대여 번호 : %d, 이름 : %s, 나이 : %d, 주소 : %s, 책 제목 : %s, 저자명 : %s, 대여날짜 : %s, 반납날짜 : %s\n", 
				library.getLeaseNo(),
				library.getUser().getUserName(),
				library.getUser().getUserAge(),
				library.getUser().getAddr(),
				library.getBook().getBookName(),
				library.getBook().getBookWriter(),
				library.getLeaseDate(),
				library.getReturnDate());
	}

	@Override
	public void displaySuccess(String message) {
		System.out.println("[서비스 성공] : " + message);
	}

	@Override
	public String inputBookName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("책 제목 : ");
		return sc.nextLine();
	}

	@Override
	public Library insertLibrary() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 대여 정보 =====");
		System.out.print("책 번호 : ");
		int bookNo = sc.nextInt();
		System.out.print("회원 아이디 : ");
		String userId = sc.next();
		Library library = new Library();
		library.setBookNo(bookNo);
		library.setUserId(userId);
		return library;
	}

	@Override
	public void dispalyBookList(ArrayList<Book> list) {
		System.out.println("===== 전체 책 조회 =====");
		for (Book book : list) {
			System.out.printf("관리번호 : %d, 책 제목 : %s, 저자명 : %s, 가격 : %d원, 출판사 : %s, 장르 : %s\n", book.getBookNo(),
					book.getBookName(), book.getBookWriter(), book.getBookPrice(), book.getPublisher(),
					book.getGenre());
		}
	}

	@Override
	public void displayMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void displayError(String message) {
		System.out.println("[서비스 실패] : " + message);
	}

	@Override
	public void dispalyCustomerList(ArrayList<Customer> list) {
		System.out.println("===== 전체 회원 조회 =====");
		for(Customer customer : list) {
			System.out.printf("회원번호 : %d, 아이디 : %s, 이름 : %s, 나이 : %d, 주소 : %s, 성별 : %s, 가입 날짜 : %s\n", 
					customer.getUserNo(),
					customer.getUserId(),
					customer.getUserName(),
					customer.getUserAge(),
					customer.getAddr(),
					customer.getGender(),
					customer.getEnrollDate());
		}
	}

	@Override
	public void diplayCutomerOne(Customer customer) {
		System.out.println("===== 회원 조회 =====");
		System.out.printf("회원번호 : %d, 아이디 : %s, 이름 : %s, 나이 : %d, 주소 : %s, 성별 : %s, 가입 날짜 : %s\n", 
				customer.getUserNo(),
				customer.getUserId(),
				customer.getUserName(),
				customer.getUserAge(),
				customer.getAddr(),
				customer.getGender(),
				customer.getEnrollDate());
			
	}

	@Override
	public void displayBook(Book book) {
		System.out.println("===== 책 조회 =====");
		System.out.printf("관리번호 : %d, 책 제목 : %s, 저자명 : %s, 가격 : %d원, 출판사 : %s, 장르 : %s\n", book.getBookNo(),
				book.getBookName(), book.getBookWriter(), book.getBookPrice(), book.getPublisher(),
				book.getGenre());
	}

	@Override
	public String inputCName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("회원 이름 : ");
		return sc.next();
	}

	@Override
	public String inputCId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("회원 아이디 : ");
		return sc.next();
	}

	@Override
	public Customer inputCustomer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 회원 가입 =====");
		System.out.print("아이디 : ");
		String userId = sc.next();
		System.out.print("이름 : ");
		String userName = sc.next();
		System.out.print("나이 : ");
		int userAge = sc.nextInt();
		System.out.print("주소 : ");
		sc.nextLine();
		String addr = sc.nextLine();
		System.out.print("성별 : ");
		String gender = sc.next();
		Customer customer = new Customer();
		customer.setUserId(userId);
		customer.setUserName(userName);
		customer.setUserAge(userAge);
		customer.setAddr(addr);
		customer.setGender(gender);
		return customer;
	}

	@Override
	public Customer modifyCustomer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 회원 정보 수정 =====");
		System.out.print("나이 : ");
		int userAge = sc.nextInt();
		System.out.print("주소 : ");
		sc.nextLine();
		String addr = sc.nextLine();
		System.out.print("성별 : ");
		String gender = sc.next();
		Customer customer = new Customer();
		customer.setUserAge(userAge);
		customer.setAddr(addr);
		customer.setGender(gender);
		return customer;
	}

	@Override
	public int inputBookNo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("책 관리번호 입력 : ");
		return sc.nextInt();
	}

	@Override
	public Book inputBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 책 정보 등록 =====");
		System.out.print("책 이름 : ");
		String bookName = sc.nextLine();
		System.out.print("책 저자 : ");
		String bookWriter = sc.nextLine();
		System.out.print("책 가격 : ");
		int bokPrice = sc.nextInt();
		System.out.print("출판사 : ");
		sc.nextLine();
		String publisher = sc.nextLine();
		System.out.print("장르 : ");
		String genre = sc.nextLine();
		Book book = new Book();
		book.setBookName(bookName);
		book.setBookWriter(bookWriter);
		book.setBookPrice(bokPrice);
		book.setPublisher(publisher);
		book.setGenre(genre);
		return book;
	}

}
