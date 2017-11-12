package cn.jju.library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jju.library.daoImpl.ReaderTypeDaoImpl;
import cn.jju.library.entity.ReaderTypeForm;

/**
 * Servlet implementation class ReaderTypeServlet
 */
@WebServlet("/readerType")
public class ReaderTypeServlet extends HttpServlet {
	
	private ReaderTypeDaoImpl readertypedaoimpl = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReaderTypeServlet() {
     
        this.readertypedaoimpl = new ReaderTypeDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.println("\nreaderType*********************action=" + action);
		if (action == null || "".equals(action)) {
			request.setAttribute("error", "操作有误");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else if ("readerTypeAdd".equals(action)) {
			readerTypeAdd(request, response);
		} else if ("readerTypeQuery".equals(action)) {
			readerTypeQuery(request, response);
		} else if ("readerTypeModifyQuery".equals(action)) {
			readerTypeModifyQuery(request, response);
		} else if ("readerTypeModify".equals(action)) {
			readerTypeModify(request, response);
		} else if ("readerTypeDel".equals(action)) {
			readerTypeDel(request, response);
		}
		
	}
	
	//添加读者类型
	private void readerTypeAdd(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// TODO Auto-generated method stub
		ReaderTypeForm readerTypeForm = new ReaderTypeForm();
		System.out.println("servlet:" + request.getParameter("name"));
		readerTypeForm.setName(request.getParameter("name"));
		readerTypeForm.setNumber(Integer.parseInt(request
				.getParameter("number")));
		int a = readertypedaoimpl.insert(readerTypeForm);
		if (a == 0) {
			request.setAttribute("error", "读者类型信息添加失败！");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else if (a == 2) {
			request.setAttribute("error", "该读者类型信息已经添加！");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else {
			request.getRequestDispatcher("readerType_ok.jsp?para=1").forward(
					request, response);
		}
		
		
	}

	// 查询读者类别
	private void readerTypeQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str = null;
		request.setAttribute("readerType", readertypedaoimpl.query(str));
		request.getRequestDispatcher("readerType.jsp").forward(request,
				response);
		
	}

	//查询修改读者类型信息
	private void readerTypeModifyQuery(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// TODO Auto-generated method stub
		ReaderTypeForm readerTypeForm = new ReaderTypeForm();
		readerTypeForm.setId(Integer.valueOf(request.getParameter("ID")));
		request.setAttribute("readerTypeQueryif", readertypedaoimpl
				.queryM(readerTypeForm));
		request.getRequestDispatcher("readerType_Modify.jsp").forward(request,
				response);
		
	}

	//修改读者类型
	private void readerTypeModify(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReaderTypeForm readerTypeForm = new ReaderTypeForm();
		readerTypeForm.setId(Integer.parseInt(request.getParameter("id")));
		readerTypeForm.setName(request.getParameter("name"));
		System.out.println("数量"+request.getParameter("number1"));
		readerTypeForm.setNumber(Integer.parseInt(request
				.getParameter("number1")));
		int ret = readertypedaoimpl.update(readerTypeForm);
		if (ret == 0) {
			request.setAttribute("error", "修改读者类型信息失败！");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else {
			request.getRequestDispatcher("readerType_ok.jsp?para=2").forward(
					request, response);
		}
		
		
	}

	//删除读者类型信息
	private void readerTypeDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		ReaderTypeForm readerTypeForm = new ReaderTypeForm();
		readerTypeForm.setId(Integer.valueOf(request.getParameter("ID")));
		int ret = readertypedaoimpl.delete(readerTypeForm);
		if (ret == 0) {
			request.setAttribute("error", "删除读者类型信息失败！");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else {
			request.getRequestDispatcher("readerType_ok.jsp?para=3").forward(
					request, response);
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
