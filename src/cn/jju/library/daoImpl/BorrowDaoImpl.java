package cn.jju.library.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;



import cn.jju.library.dao.BorrowDao;
import cn.jju.library.dao.ConnDB;
import cn.jju.library.entity.BookForm;
import cn.jju.library.entity.BorrowForm;
import cn.jju.library.entity.ReaderForm;

public class BorrowDaoImpl implements BorrowDao{
	 ConnDB conn = new ConnDB();
	    public int insert() {
	        String sql = "INSERT INTO tb_borrow (bookid) vlaues(1) ";
	        int ret = conn.executeUpdate(sql);
	        return ret;
	    }
	    //*****************************图书借阅******************************
		public int insertBorrow(ReaderForm readerForm, BookForm bookForm,
				String operator) {
			String sql1 = "select t.days from tb_bookinfo b left join tb_booktype t on"
					+ " b.typeid=t.id where b.id=" + bookForm.getId() + ""; // 获取可借天数的SQL语句
			ResultSet rs = conn.executeQuery(sql1); // 执行SQL语句
			int days = 0;
			try {
				if (rs.next()) {
					days = rs.getInt(1); // 获取可借天数
				}
			} catch (SQLException ex) {
			}
			// 计算归还时间
			Calendar calendar = Calendar.getInstance(); // 获取系统日期
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date date = java.sql.Date.valueOf(format.format(calendar
					.getTime()));// 借书日期
			calendar.add(calendar.DAY_OF_YEAR, days);// 加上可借天数
			java.sql.Date backTime = java.sql.Date.valueOf(format.format(calendar
					.getTime())); // 归还日期

			String sql = "Insert into tb_borrow (readerid,bookid,borrowTime,backTime,operator) values("
					+ readerForm.getId()
					+ ","
					+ bookForm.getId()
					+ ",'"
					+ date
					+ "','" + backTime + "','" + operator + "')";
			System.out.println("添加图书借阅信息的SQL：" + sql);
			int falg = conn.executeUpdate(sql); // 执行更新语句
			//conn.close();// 关闭数据库连接
			return falg;
		}
	      //*************************************图书继借*********************************
	      public int renew(int id){
	          String sql0="SELECT bookid FROM tb_borrow WHERE id="+id+"";	//根据借阅ID查询图书ID的SQL语句
	          ResultSet rs1=conn.executeQuery(sql0);	//执行查询语句
	          int flag=0;
	          try {
	            if (rs1.next()) {
	            	//获取可借天数
	                String sql1 = "select t.days from tb_bookinfo b left join" +
	                		" tb_booktype t on b.typeid=t.id where b.id=" 
	                		+rs1.getInt(1) + "";	//获取可借天数的SQL语句
	                ResultSet rs = conn.executeQuery(sql1);	//执行查询语句
	                int days = 0;
	                try {
	                    if (rs.next()) {
	                        days = rs.getInt(1);	//获取可借天数
	                    }
	                } catch (SQLException ex) {
	                }
	                //计算归还时间
	                Calendar calendar=Calendar.getInstance(); //获取系统日期
	                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	                java.sql.Date date=java.sql.Date.valueOf(
	                		format.format(calendar.getTime()));//借书日期
	                calendar.add(calendar.DAY_OF_YEAR, days);	//加上可借天数
	                java.sql.Date backTime= java.sql.Date.valueOf(format.format(calendar.getTime()));	//归还日期
	                String sql = "UPDATE tb_borrow SET backtime='" + backTime +
	                             "' where id=" + id + "";	//更新归还时间完成续借
	                flag = conn.executeUpdate(sql);//执行更新语句
	            }
	          } catch (Exception ex1) {}
	          //conn.close();//关闭数据库连接
	          return flag;
	      }
	      //*************************************图书归还*********************************
	      public int back(int id,String operator){
	    	  //根据借阅ID获取读者ID和图书ID
	          String sql0="SELECT readerid,bookid FROM tb_borrow WHERE id="+id+"";
	          ResultSet rs1=conn.executeQuery(sql0);	//执行查询语句
	          int flag=0;
	        try {
	            if (rs1.next()) {
	            	 Calendar calendar=Calendar.getInstance(); //获取系统日期
	                 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	                 java.sql.Date date=java.sql.Date.valueOf(format.format(calendar.getTime()));//还书日期
	                int readerid=rs1.getInt(1);	//获取读者ID
	                int bookid=rs1.getInt(2);//获取图书ID
	                String sql1="INSERT INTO tb_giveback (readerid,bookid,backTime" +
	                		",operator) VALUES("+readerid+","+bookid+",'"
	                		+date+"','"+operator+"')";	//保存归还信息
	                int ret=conn.executeUpdate(sql1);	//执行更新语句
	                if(ret==1){
	                    String sql2 = "UPDATE tb_borrow SET ifback=1 where id=" + id +
	                                 "";	//将借阅信息标记为已归还
	                    flag = conn.executeUpdate(sql2);	//执行更新语句
	                }else{
	                    flag=0;
	                }
	            }
	        } catch (Exception ex1) {
	        }
	          //conn.close();//关闭数据库连接
	          return flag;
	      }
	    //*****************************查询图书借阅信息************************
	      public Collection<BorrowForm> borrowinfo(String str){
	      String sql="select borr.*,book.bookname,book.price,pub.pubname," +
	      		"bs.name bookcasename,r.barcode from (select * from tb_borrow " +
	      		"where ifback=0) as borr left join tb_bookinfo book on borr.bookid" +
	      		"=book.id join tb_publishing pub on book.isbn=pub.isbn join" +
	      		" tb_bookcase bs on book.bookcase=bs.id join tb_reader r on" +
	      		" borr.readerid=r.id where r.barcode='"+str+"'";
	      ResultSet rs=conn.executeQuery(sql);//执行查询语句
	      Collection<BorrowForm> coll=new ArrayList<>();
	      BorrowForm form=null;
	      try {
	          while (rs.next()) {
	              form = new BorrowForm();
	              form.setId(Integer.valueOf(rs.getInt(1)));//获取ID号
	              form.setBorrowTime(rs.getString(4));//获取借阅时间
	              form.setBackTime(rs.getString(5));//获取归还时间
	              form.setBookName(rs.getString(8));//获取图书名称
	              form.setPrice(Float.valueOf(rs.getFloat(9)));//获取定价
	              form.setPubName(rs.getString(10));//获取出版社
	              form.setBookcaseName(rs.getString(11));	//获取书价名称
	              coll.add(form);//添加借阅信息到Collection集合中
	          }
	      } catch (SQLException ex) {
	          System.out.println("借阅信息："+ex.getMessage());//输出异常信息
	      }
	      //conn.close();//关闭数据库连接
	      return coll;
	      }
	      //*************************到期提醒******************************************
	    public Collection bremind(){
	    Calendar calendar=Calendar.getInstance(); //获取系统日期
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    java.sql.Date date=java.sql.Date.valueOf(format.format(calendar.getTime()));//提醒日期
	    String sql="select borr.borrowTime,borr.backTime,book.barcode,book.bookname,r.name readername,r.barcode readerbarcode from tb_borrow borr join tb_bookinfo book on book.id=borr.bookid join tb_reader r on r.id=borr.readerid where borr.backTime <='"+date+"' and borr.ifback=0";
	    ResultSet rs=conn.executeQuery(sql);
	    Collection coll=new ArrayList();
	    BorrowForm form=null;
	    try {
	        while (rs.next()) {
	            form = new BorrowForm();
	            form.setBorrowTime(rs.getString(1));
	            form.setBackTime(rs.getString(2));
	            form.setBookBarcode(rs.getString(3));
	            form.setBookName(rs.getString(4));
	            form.setReaderName(rs.getString(5));
	            form.setReaderBarcode(rs.getString(6));
	            coll.add(form);
	            System.out.println("图书条形码："+rs.getString(3));
	        }
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
	    }
	    //conn.close();
	    return coll;
	}
	//*************************图书借阅查询******************************************
	public Collection borrowQuery(String strif){
	    String sql="";
	    if(strif!="all" && strif!=null && strif!=""){
	        sql="select * from (select borr.borrowTime,borr.backTime,book.barcode,book.bookname,r.name readername,r.barcode readerbarcode,borr.ifback from tb_borrow borr join tb_bookinfo book on book.id=borr.bookid join tb_reader r on r.id=borr.readerid) as borr where borr."+strif+"";
	    }else{
	        sql="select * from (select borr.borrowTime,borr.backTime,book.barcode,book.bookname,r.name readername,r.barcode readerbarcode,borr.ifback from tb_borrow borr join tb_bookinfo book on book.id=borr.bookid join tb_reader r on r.id=borr.readerid) as borr";
	}
	ResultSet rs=conn.executeQuery(sql);
	System.out.println("图书借阅查询的SQL："+sql);
	Collection coll=new ArrayList();
	BorrowForm form=null;
	try {
	    while (rs.next()) {
	        form = new BorrowForm();
	        form.setBorrowTime(rs.getString(1));
	        form.setBackTime(rs.getString(2));
	        form.setBookBarcode(rs.getString(3));
	        form.setBookName(rs.getString(4));
	        form.setReaderName(rs.getString(5));
	        form.setReaderBarcode(rs.getString(6));
	        form.setIfBack(rs.getInt(7));
	        coll.add(form);
	    }
	} catch (SQLException ex) {
	    System.out.println(ex.getMessage());
	}
	//conn.close();
	return coll;
	    }
	      //*************************图书借阅排行******************************************
	    public Collection<BorrowForm> bookBorrowSort() {
	       String sql = "select * from (SELECT bookid,count(bookid) as degree FROM" +
	       		" tb_borrow group by bookid) as borr join (select b.*,c.name as bookcaseName" +
	       		",p.pubname,t.typename from tb_bookinfo b left join tb_bookcase" +
	       		" c on b.bookcase=c.id join tb_publishing p on b.ISBN=p.ISBN join " +
	       		"tb_booktype t on b.typeid=t.id where b.del=0)" +
	       		" as book on borr.bookid=book.id order by borr.degree desc limit 10 ";
	        Collection<BorrowForm> coll = new ArrayList<>();	//创建并实例化Collection对象
	        BorrowForm form = null;	//声明BorrowForm对象
	        ResultSet rs = conn.executeQuery(sql);	//执行查询语句


	        try {
	            while (rs.next()) {
	                form = new BorrowForm();	//实例化BorrowForm对象
	                form.setBookId(rs.getInt(1));		//获取图书ID
	                form.setDegree(rs.getInt(2));		//获取借阅次数
	                form.setBookBarcode(rs.getString(3));	//获取图书条形码
	                form.setBookName(rs.getString(4));	//获取图书名称
	                form.setAuthor(rs.getString(6));	//获取作者
	                form.setPrice(Float.valueOf(rs.getString(9)));	//获取定价
	                form.setBookcaseName(rs.getString(16));	//获取书架名称
	                form.setPubName(rs.getString(17));	//获取出版社
	                form.setBookType(rs.getString(18));	//获取图书类型
	                coll.add(form);	//保存到Collection集合中
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());	//输出异常信息
	        }
	        //conn.close();	//关闭数据库连接
	        return coll;
	    }
}
