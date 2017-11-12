package cn.jju.library.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jju.library.daoImpl.BookDaoImpl;
import cn.jju.library.entity.BookForm;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDaoImpl bookdaoimpl = null;
	
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        this.bookdaoimpl = new BookDaoImpl();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		System.out.println("\nbook*********************action=" + action);
		if (action == null || "".equals(action)) {
			request.setAttribute("error", "您的操作有误！");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else if ("bookAdd".equals(action)) {
			bookAdd(request, response);
		} else if ("bookQuery".equals(action)) {
			bookQuery(request, response);
		} else if ("bookModifyQuery".equals(action)) {
			bookModifyQuery(request, response);
		} else if ("bookModify".equals(action)) {
			bookModify(request, response);
		} else if ("bookDel".equals(action)) {
			bookDel(request, response);
		} else if ("bookDetail".equals(action)) {
			bookDetail(request, response);
		} else if ("bookifQuery".equals(action)) {
			bookifQuery(request, response);
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	//添加图书信息
	private void bookAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BookForm book = new BookForm();
		book.setBarcode(request.getParameter("barcode"));
		book.setBookName(request.getParameter("bookName"));
		book.setTypeId(Integer.parseInt(request.getParameter("typeId")));
		book.setAuthor(request.getParameter("author"));
		book.setTranslator(request.getParameter("translator"));
		book.setIsbn(request.getParameter("isbn"));
		book.setPrice(Float.valueOf(request.getParameter("price")));
		book.setPage(request.getParameter("page")==""?0:Integer.parseInt(request.getParameter("page")));
		book.setBookcaseid(Integer.parseInt(request
				.getParameter("bookcaseid")));
		// 获取系统日期
		Date date1 = new Date();
		java.sql.Date date = new java.sql.Date(date1.getTime());
		book.setInTime(date.toString());
		book.setOperator(request.getParameter("operator"));
		int a = bookdaoimpl.insert(book);
		if (a == 1) {
			request.getRequestDispatcher("book_ok.jsp?para=1").forward(request, response);
		} else if (a == 2) {
			request.setAttribute("error", "该图书信息已经添加");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else {
			request.setAttribute("error", "图书信息添加失败");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		}
	}

	//查询全部图书信息
	private void bookQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String str = null;
		request.setAttribute("book", bookdaoimpl.query(str)); // ����ѯ������浽book��
		request.getRequestDispatcher("book.jsp").forward(request, response);
	}
	
	
	
	
	
	//查询修改图书信息 
	private void bookModifyQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BookForm bookForm = new BookForm();
		System.out.println("查询修改图书信息：" + request.getParameter("ID"));
		bookForm.setId(Integer.valueOf(request.getParameter("ID")));
		request.setAttribute("bookQueryif", bookdaoimpl.queryM(bookForm));
		request.getRequestDispatcher("book_Modify.jsp").forward(request,
				response);
	}
	
	


	/*********************** 条件查询图书信息 **************************/
	private void bookifQuery(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String str = null;
		if (request.getParameter("f") != null) {
			str = request.getParameter("f") + " like '%"
					+ request.getParameter("key") + "%";
		}
		request.setAttribute("ifbook", bookdaoimpl.query(str));
		System.out.print("条件查询图书信息时的str:" + str);
		request.getRequestDispatcher("bookQuery.jsp").forward(request, response);
	}

	/*********************** 查询图书详细信息 **************************/
	private void bookDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BookForm bookForm = new BookForm();
		bookForm.setId(Integer.valueOf(request.getParameter("ID")));
		request.setAttribute("bookDetail", bookdaoimpl.queryM(bookForm));
		request.getRequestDispatcher("book_detail.jsp").forward(request,
				response);
	}

	/*********************** 修改图书信息 **************************/
	private void bookModify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BookForm bookForm = new BookForm(); // 实例化BookForm类
		bookForm.setId(Integer.parseInt(request.getParameter("id")));
		bookForm.setBarcode(request.getParameter("barcode")); // 获取并设置条形码属性
		bookForm.setBookName(request.getParameter("bookName"));
		bookForm.setTypeId(Integer.parseInt(request.getParameter("typeId")));
		bookForm.setAuthor(request.getParameter("author"));
		bookForm.setTranslator(request.getParameter("translator"));
		bookForm.setIsbn(request.getParameter("isbn"));
		bookForm.setPrice(Float.valueOf(request.getParameter("price")));
		bookForm.setPage(request.getParameter("page")==""?0:Integer.parseInt(request.getParameter("page")));
		bookForm.setBookcaseid(Integer.parseInt(request
				.getParameter("bookcaseid")));
		bookForm.setOperator(request.getParameter("operator"));
		int ret = bookdaoimpl.update(bookForm); // 调用修改图书信息的方法update()
		if (ret == 0) {
			request.setAttribute("error", "修改图书信息失败！");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response); // 转到错误提示页面
		} else {
			request.getRequestDispatcher("book_ok.jsp?para=2").forward(request,
					response); // 转到修改成功页面
		}
	}

	/*********************** 删除图书信息 **************************/
	private void bookDel(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BookForm bookForm = new BookForm();
		bookForm.setId(Integer.valueOf(request.getParameter("ID")));
		int ret = bookdaoimpl.delete(bookForm);
		if (ret == 0) {
			request.setAttribute("error", "删除图书信息失败！");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else {
			request.getRequestDispatcher("book_ok.jsp?para=3").forward(request,
					response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
