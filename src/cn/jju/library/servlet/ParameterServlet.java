package cn.jju.library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jju.library.daoImpl.ParameterDaoImpl;
import cn.jju.library.entity.ParameterForm;

/**
 * Servlet implementation class ParameterServlet
 */
@WebServlet("/parameter")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ParameterDaoImpl parameterdaoimpl = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParameterServlet() {
        super();
        this.parameterdaoimpl = new ParameterDaoImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str = request.getParameter("action");
		if ("parameterQuery".equals(str)) {
			parameterModifyQuery(request, response);
		} else if ("parameterModify".equals(str)) {
			parameterModify(request, response);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void parameterModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		ParameterForm parameterForm = new ParameterForm();
		parameterForm.setId(1);
		parameterForm.setCost(Integer.parseInt(request.getParameter("cost")));
		parameterForm.setValidity(Integer.parseInt(request.getParameter("validity")));
		int ret = parameterdaoimpl.update(parameterForm);
		if (ret == 0) {
			request.setAttribute("error", "参数设置信息修改失败！");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else {
			request.getRequestDispatcher("parameter_ok.jsp?para=2").forward(request,
					response);
		}
		
	}

	private void parameterModifyQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		request.setAttribute("parameterModifyif", parameterdaoimpl.query());
		request.getRequestDispatcher("parameter_modify.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
