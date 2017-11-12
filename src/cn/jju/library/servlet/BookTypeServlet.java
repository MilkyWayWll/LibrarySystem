package cn.jju.library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jju.library.daoImpl.BookTypeDaoImpl;
import cn.jju.library.entity.BookTypeForm;


/**
 * Servlet implementation class BookTypeServlet
 */
@WebServlet("/bookType")
public class BookTypeServlet extends HttpServlet {
	
	private BookTypeDaoImpl booktypedaoimpl = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookTypeServlet() {
       
        this.booktypedaoimpl = new BookTypeDaoImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		System.out.println("\nbookType*********************action=" + action);
		if (action == null || "".equals(action)) {
			request.setAttribute("error", "您的操作有误");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else if ("bookTypeAdd".equals(action)) {
			bookTypeAdd(request, response);
		} else if ("bookTypeQuery".equals(action)) {
			bookTypeQuery(request, response);
		} else if ("bookTypeModifyQuery".equals(action)) {
			bookTypeModifyQuery(request, response);
		} else if ("bookTypeModify".equals(action)) {
			bookTypeModify(request, response);
		} else if ("bookTypeDel".equals(action)) {
			bookTypeDel(request, response);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	

	//添加图书类型信息
	private void bookTypeAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		BookTypeForm bookTypeForm = new BookTypeForm();
		bookTypeForm.setTypeName(request.getParameter("typeName"));
		bookTypeForm.setDays(Integer.parseInt(request.getParameter("days")));
		int a = booktypedaoimpl.insert(bookTypeForm);
		if (a == 0) {
			request.setAttribute("error", "添加图书类型失败！");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else if (a == 2) {
			request.setAttribute("error", "该图书类型信息已经添加");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else {
			request.getRequestDispatcher("bookType_ok.jsp?para=1").forward(request,
					response);
		}
		
	}
	
	//查询全部图书类型
	private void bookTypeQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String str = null;
		request.setAttribute("bookType", booktypedaoimpl.query(str));
		request.getRequestDispatcher("bookType.jsp")
				.forward(request, response);
		
	}
	// 查询修改图书类型信息
	private void bookTypeModifyQuery(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BookTypeForm bookTypeForm = new BookTypeForm();
		bookTypeForm.setId(Integer.valueOf(request.getParameter("ID")));
		request.setAttribute("bookTypeQueryif", booktypedaoimpl
				.queryM(bookTypeForm));
		request.getRequestDispatcher("bookType_Modify.jsp").forward(request,
				response);
	}
	
	// 修改图书类型
	private void bookTypeModify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BookTypeForm bookTypeForm = new BookTypeForm();
		bookTypeForm.setId(Integer.parseInt(request.getParameter("id")));
		bookTypeForm.setTypeName(request.getParameter("typeName"));
		bookTypeForm.setDays(Integer.parseInt(request.getParameter("days")));
		int ret = booktypedaoimpl.update(bookTypeForm);
		if (ret == 0) {
			request.setAttribute("error", "修改图书类型信息失败！！");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else {
			request.getRequestDispatcher("bookType_ok.jsp?para=2").forward(request,
					response);
		}
	}
	
	// 删除图书类型
	private void bookTypeDel(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BookTypeForm bookTypeForm = new BookTypeForm();
		bookTypeForm.setId(Integer.valueOf(request.getParameter("ID")));
		int ret = booktypedaoimpl.delete(bookTypeForm);
		if (ret == 0) {
			request.setAttribute("error", "删除图书类型失败");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else {
			request.getRequestDispatcher("bookType_ok.jsp?para=3").forward(request,
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
