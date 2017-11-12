package cn.jju.library.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cn.jju.library.daoImpl.LibraryDaoImpl;
import cn.jju.library.entity.LibraryForm;


/**
 * Servlet implementation class LibraryServlet
 */
@WebServlet("/library")
public class LibraryServlet extends HttpServlet {
	
	LibraryDaoImpl libraryDaoImpl=null;
    
    public LibraryServlet() {
    	libraryDaoImpl =new LibraryDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String str=request.getParameter("action");
	        if("libraryQuery".equals(str)){
	            libraryModifyQuery(request,response);
	        }else if("libraryModify".equals(str)){
	            libraryModify(request,response);
	        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	 private void libraryModify(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			        LibraryForm libraryForm = new LibraryForm();
			        libraryForm.setId(1);
			        libraryForm.setLibraryname(request.getParameter("libraryname"));
			        libraryForm.setCurator(request.getParameter("curator"));
			        libraryForm.setTel(request.getParameter("tel"));
			        libraryForm.setAddress(request.getParameter("address"));
			        libraryForm.setEmail(request.getParameter("email"));
			        libraryForm.setUrl(request.getParameter("url"));
			        libraryForm.setCreateDate(request.getParameter("createDate"));
			        libraryForm.setIntroduce(request.getParameter("introduce"));        
			        int ret = libraryDaoImpl.update(libraryForm);
			        if (ret ==0) {
			            request.setAttribute("error", "图书馆信息修改失败！");
			            request.getRequestDispatcher("error.jsp").forward(request, response);
			        } else {
			        	request.getRequestDispatcher("library_ok.jsp?para=2").forward(request, response);
			        }

			    }
			    private void libraryModifyQuery(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			        request.setAttribute("libraryModifyif",libraryDaoImpl.query());
			        request.getRequestDispatcher("library_modify.jsp").forward(request, response);
			    }
}
