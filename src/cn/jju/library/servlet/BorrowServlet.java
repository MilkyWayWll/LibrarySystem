package cn.jju.library.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jju.library.daoImpl.BookDaoImpl;
import cn.jju.library.daoImpl.BorrowDaoImpl;
import cn.jju.library.daoImpl.ReaderDaoImpl;
import cn.jju.library.entity.BookForm;
import cn.jju.library.entity.ReaderForm;

/**
 * Servlet implementation class BorrowServlet
 */
@WebServlet("/borrow")
public class BorrowServlet extends HttpServlet {

	// 在构造方法中实例化Borrow类中应用的持久层类的对象
	private BorrowDaoImpl borrowdaoimpl = null;
	private ReaderDaoImpl readerdaoimpl = null;
	private BookDaoImpl bookdaoimpl = null;
	private ReaderForm readerForm = new ReaderForm();

	public BorrowServlet() {

		this.borrowdaoimpl = new BorrowDaoImpl();
		this.readerdaoimpl = new ReaderDaoImpl();
		this.bookdaoimpl = new BookDaoImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action == null || "".equals(action)) {
			request.setAttribute("error", "您的操作有误！");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} else if ("bookBorrowSort".equals(action)) {
			bookBorrowSort(request, response);
		} else if ("bookborrow".equals(action)) {
			bookborrow(request, response); // 图书借阅
		} else if ("bookrenew".equals(action)) {
			bookrenew(request, response); // 图书续借
		} else if ("bookback".equals(action)) {
			bookback(request, response); // 图书归还
		} else if ("Bremind".equals(action)) {
			bremind(request, response); // 借阅到期提醒
		} else if ("borrowQuery".equals(action)) {
			borrowQuery(request, response); // 借阅信息查询
		}

	}

	/********************* 图书借阅排行 ***********************/
	private void bookBorrowSort(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("bookBorrowSort", borrowdaoimpl.bookBorrowSort());
		request.getRequestDispatcher("bookBorrowSort.jsp").forward(request, response);
	}

	/********************* 图书借阅查询 ***********************/
	private void borrowQuery(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = null;
		String flag[] = request.getParameterValues("flag");
		if (flag != null) {
			String aa = flag[0];
			if ("a".equals(aa)) {
				if (request.getParameter("f") != null) {
					str = request.getParameter("f") + " like '%" + request.getParameter("key") + "%'";
				}
			}
			if ("b".equals(aa)) {
				String sdate = request.getParameter("sdate");
				String edate = request.getParameter("edate");
				if (sdate != null && edate != null) {
					str = "borrowTime between '" + sdate + "' and '" + edate + "'";
				}
				System.out.println("日期" + str);
			}
			// 同时选择日期和条件进行查询
			if (flag.length == 2) {
				if (request.getParameter("f") != null) {
					str = request.getParameter("f") + " like '%" + request.getParameter("key") + "%'";
				}
				System.out.println("日期和条件");
				String sdate = request.getParameter("sdate");
				String edate = request.getParameter("edate");
				String str1 = null;
				if (sdate != null && edate != null) {
					str1 = "borrowTime between '" + sdate + "' and '" + edate + "'";
				}
				str = str + " and borr." + str1;
				System.out.println("条件和日期：" + str);
			}
		}
		request.setAttribute("borrowQuery", borrowdaoimpl.borrowQuery(str));
		System.out.print("条件查询图书借阅信息时的str:" + str);
		request.getRequestDispatcher("borrowQuery.jsp").forward(request, response);
	}

	/********************* 到期提醒 ***********************/
	private void bremind(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("Bremind", borrowdaoimpl.bremind());
		request.getRequestDispatcher("bremind.jsp").forward(request, response);
	}

	/********************* 图书借阅 ***********************/
	private void bookborrow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 查询读者信息
		readerForm.setBarcode(request.getParameter("barcode")); // 获取读者条形码
		ReaderForm reader = (ReaderForm) readerdaoimpl.queryM(readerForm); // 根据读者条形码获取读者信息
		request.setAttribute("readerinfo", reader); // 保存读者信息到request中
		// 查询读者的借阅信息
		request.setAttribute("borrowinfo", borrowdaoimpl.borrowinfo(request.getParameter("barcode")));
		// 完成借阅
		String f = request.getParameter("f"); // 获取查询条件
		String key = request.getParameter("inputkey"); // 获取输入的关键字
		if (key != null && !key.equals("")) { // 判断是否有符合条件的图书
			String operator = request.getParameter("operator"); //
			BookForm bookForm = bookdaoimpl.queryB(f, key); // 根据查询条件获取图书信息
			if (bookForm != null) {
				int ret = borrowdaoimpl.insertBorrow(reader, bookdaoimpl.queryB(f, key), operator); // 保存图书借阅信息
				if (ret == 1) {
					request.setAttribute("bar", request.getParameter("barcode"));
					request.getRequestDispatcher("bookBorrow_ok.jsp").forward(request, response);

				} else {
					request.setAttribute("error", "添加借阅信息失败!"); // 保存提示信息到request中
					request.getRequestDispatcher("error.jsp").forward(request, response); // 转到错误提示页
				}
			} else {
				request.setAttribute("error", "没有该图书!"); // 保存提示信息到request中
				request.getRequestDispatcher("error.jsp").forward(request, response); // 转到错误提示页
			}
		} else {
			request.getRequestDispatcher("bookBorrow.jsp").forward(request, response);
		}
	}

	/********************* 图书继借 ***********************/
	private void bookrenew(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 查询读者信息
		readerForm.setBarcode(request.getParameter("barcode")); // 获取读者条形码
		ReaderForm reader = (ReaderForm) readerdaoimpl.queryM(readerForm); // 根据读者条形码查询读者信息
		request.setAttribute("readerinfo", reader);
		// 查询读者的借阅信息
		request.setAttribute("borrowinfo", borrowdaoimpl.borrowinfo(request.getParameter("barcode")));
		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			if (id > 0) { // 执行继借操作
				int ret = borrowdaoimpl.renew(id);
				if (ret == 0) {
					request.setAttribute("error", "图书继借失败!");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				} else {
					request.setAttribute("bar", request.getParameter("barcode"));
					request.getRequestDispatcher("bookRenew_ok.jsp").forward(request, response);
				}
			}
		} else {
			request.getRequestDispatcher("bookRenew.jsp").forward(request, response);
		}
	}

	/********************* 图书归还 ***********************/
	private void bookback(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 查询读者信息
		readerForm.setBarcode(request.getParameter("barcode"));
		ReaderForm reader = (ReaderForm) readerdaoimpl.queryM(readerForm);
		request.setAttribute("readerinfo", reader);
		// 查询读者的借阅信息
		request.setAttribute("borrowinfo", borrowdaoimpl.borrowinfo(request.getParameter("barcode")));
		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			String operator = request.getParameter("operator");
			if (id > 0) { // 执行归还操作
				int ret = borrowdaoimpl.back(id, operator);
				if (ret == 0) {
					request.setAttribute("error", "图书归还失败!");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				} else {
					request.setAttribute("bar", request.getParameter("barcode"));
					request.getRequestDispatcher("bookBack_ok.jsp").forward(request, response);
				}
			}
		} else {
			request.getRequestDispatcher("bookBack.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
