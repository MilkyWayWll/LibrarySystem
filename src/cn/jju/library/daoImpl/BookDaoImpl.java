package cn.jju.library.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


import cn.jju.library.dao.BookDao;
import cn.jju.library.dao.ConnDB;
import cn.jju.library.entity.BookForm;

public class BookDaoImpl implements BookDao {
	private ConnDB conn = new ConnDB();
	

	@Override
	public Collection query(String strif) {

		BookForm bookForm = null;
		Collection bookColl = new ArrayList();
		String sql = "";
		if (strif != "all" && strif != null && strif != "") {
			sql = "select * from (select b.*,c.name as bookcaseName,p.pubname as publishing,t.typename from tb_bookinfo b left join tb_bookcase c on b.bookcase=c.id join tb_publishing p on b.ISBN=p.ISBN join tb_booktype t on b.typeid=t.id where b.del=0)  as book where book."
					+ strif + "'";
		} else {
			sql = "select b.*,c.name as bookcaseName,p.pubname as publishing,t.typename from tb_bookinfo b left join tb_bookcase c on b.bookcase=c.id join tb_publishing p on b.ISBN=p.ISBN join tb_booktype t on b.typeid=t.id where b.del=0";
		}
		System.out.println("图书查询时的SQL：" + sql);
		ResultSet rs = conn.executeQuery(sql);
		try {
			while (rs.next()) {
				bookForm = new BookForm();
				bookForm.setBarcode(rs.getString(1));
				bookForm.setBookName(rs.getString(2));
				bookForm.setTypeId(rs.getInt(3));
				bookForm.setAuthor(rs.getString(4));
				bookForm.setTranslator(rs.getString(5));
				bookForm.setIsbn(rs.getString(6));
				bookForm.setPrice(Float.valueOf(rs.getString(7))); // 此处必须进行类型转换
				bookForm.setPage(rs.getInt(8));
				bookForm.setBookcaseid(rs.getInt(9));
				bookForm.setInTime(rs.getString(10));
				bookForm.setOperator(rs.getString(11));
				bookForm.setDel(rs.getInt(12));
				bookForm.setId(Integer.valueOf(rs.getString(13)));
				bookForm.setBookcaseName(rs.getString(14));
				bookForm.setPublishing(rs.getString(15));
				bookForm.setTypeName(rs.getString(16));
				bookColl.add(bookForm);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		//conn.close();
		return bookColl;
	}

	@Override
	public BookForm queryM(BookForm bookForm1) {//用于修改的查询
		BookForm bookForm=null;
		String sql="select b.*,c.name as bookcaseName,p.pubname as publishing,t.typename from tb_bookinfo b left join tb_bookcase c on b.bookcase=c.id join tb_publishing p on b.ISBN=p.ISBN join tb_booktype t on b.typeid=t.id where b.id="+bookForm1.getId()+"";
		System.out.println("修改时的SQL："+sql);
		ResultSet rs=conn.executeQuery(sql);
		try {
		    while (rs.next()) {
		        bookForm=new BookForm();
		        bookForm.setBarcode(rs.getString(1));
		        bookForm.setBookName(rs.getString(2));
		        bookForm.setTypeId(rs.getInt(3));
		        bookForm.setAuthor(rs.getString(4));
		        bookForm.setTranslator(rs.getString(5));
		        bookForm.setIsbn(rs.getString(6));
		        bookForm.setPrice(Float.valueOf(rs.getString(7)));  //此处必须进行类型转换
		        bookForm.setPage(rs.getInt(8));
		        bookForm.setBookcaseid(rs.getInt(9));     
		        bookForm.setInTime(rs.getString(10));
		        bookForm.setOperator(rs.getString(11));
		        bookForm.setDel(rs.getInt(12));
		        bookForm.setId(Integer.valueOf(rs.getString(13)));
		        bookForm.setBookcaseName(rs.getString(14));
		        bookForm.setPublishing(rs.getString(15));
		        bookForm.setTypeName(rs.getString(16));
		    }
		} catch (SQLException ex) {
		}
		//conn.close();
		return bookForm;
	}

	@Override
	public BookForm queryB(String f, String key) {//借阅书籍的查询
		BookForm bookForm=null;
		   String sql="select b.*,c.name as bookcaseName,p.pubname as publishing,t.typename" +
		   		" from tb_bookinfo b left join tb_bookcase c on b.bookcase=c.id join" +
		   		" tb_publishing p on b.ISBN=p.ISBN join tb_booktype t on" +
		   		" b.typeid=t.id where b."+f+"='"+key+"'";	//查询图书信息的SQL语句
		   ResultSet rs=conn.executeQuery(sql);	//执行查询语句
		   try {
		       if (rs.next()) {
		           bookForm=new BookForm();
		           bookForm.setBarcode(rs.getString(1));	//获取图书条形码
		           bookForm.setBookName(rs.getString(2));	//获取图书名称
		           bookForm.setTypeId(rs.getInt(3));//获取图书类型ID
		           bookForm.setAuthor(rs.getString(4));//获取作者
		           bookForm.setTranslator(rs.getString(5));	//获取译者
		           bookForm.setIsbn(rs.getString(6));	//获取图书的ISBN号
		           bookForm.setPrice(Float.valueOf(rs.getString(7)));  //此处必须进行类型转换
		           bookForm.setPage(rs.getInt(8));//获取页码
		           bookForm.setBookcaseid(rs.getInt(9));    //获取书架ID 
		           bookForm.setInTime(rs.getString(10));	//获取入库时间
		           bookForm.setOperator(rs.getString(11));//获取操作员
		           bookForm.setDel(rs.getInt(12));//获取是否删除
		           bookForm.setId(Integer.valueOf(rs.getString(13)));//获取图书ID号
		           bookForm.setBookcaseName(rs.getString(14));//获取书架名称
		           bookForm.setPublishing(rs.getString(15));//获取出版社
		           bookForm.setTypeName(rs.getString(16));//获取类型名称
		       }
		   } catch (SQLException ex) {
		   }
		   //conn.close();//关闭数据库连接
		   return bookForm;
	}

	@Override
	public int insert(BookForm bookForm) {//添加图书
		String sql1="SELECT * FROM tb_bookinfo WHERE barcode='"+bookForm.getBarcode()+"' or bookname='"+bookForm.getBookName()+"'";
		ResultSet rs = conn.executeQuery(sql1);
		String sql = "";
		int falg = 0;
		try {
		if (rs.next()) {
		    falg = 2;
		} else {
		    sql ="Insert into tb_bookinfo (barcode,bookname,typeid,author,translator,isbn,price,page,bookcase,inTime,operator) values('"+bookForm.getBarcode()+"','"+bookForm.getBookName()+"',"+bookForm.getTypeId()+",'"+bookForm.getAuthor()+"','"+bookForm.getTranslator()+"','"+bookForm.getIsbn()+"',"+bookForm.getPrice()+","+bookForm.getPage()+","+bookForm.getBookcaseid()+",'"+bookForm.getInTime()+"','"+bookForm.getOperator()+"')";
		    falg = conn.executeUpdate(sql);
		    System.out.println("添加图书的SQL：" + sql);
		    //conn.close();
		}
		} catch (SQLException ex) {
		falg = 0;
		}
		System.out.println("falg:"+falg);
		return falg;
	}

	@Override
	public int update(BookForm bookForm) {//修改图书信息
		String sql="Update tb_bookinfo set typeid="+bookForm.getTypeId()+",author='"+bookForm.getAuthor()+"',translator='"+bookForm.getTranslator()+"',isbn='"+bookForm.getIsbn()+"',price="+bookForm.getPrice()+",page="+bookForm.getPage()+",bookcase="+bookForm.getBookcaseid()+" where id="+bookForm.getId()+"";
		int falg=conn.executeUpdate(sql);
		System.out.println("修改数据时的SQL："+sql);
		//conn.close();
		return falg;
	}

	@Override
	public int delete(BookForm bookForm) {
		String sql="UPDATE tb_bookinfo SET del=1 where id="+bookForm.getId()+"";
		int falg=conn.executeUpdate(sql);
		System.out.println("删除时的SQL："+sql);
		return falg;
	}
}
	

	
