package cn.jju.library.entity;
import java.sql.*;
public class News {
	private int nid;
	private int ntid;
	private String ntitle;
	private String nauthor;
	private Timestamp ncreatedate;
	private String npicpath;
	private Timestamp modifydate;
	private String ncontent;
	private String nsummary;
	
	private String tid;
	private String tname;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public int getNtid() {
		return ntid;
	}
	public void setNtid(int ntid) {
		this.ntid = ntid;
	}
	
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNauthor() {
		return nauthor;
	}
	public void setNauthor(String nauthor) {
		this.nauthor = nauthor;
	}
	public Timestamp getNcreatedate() {
		return ncreatedate;
	}
	public void setNcreatedate(Timestamp ncreatedate) {
		this.ncreatedate = ncreatedate;
	}
	
	public String getNpicpath() {
		return npicpath;
	}
	public void setNpicpath(String npicpath) {
		this.npicpath = npicpath;
	}
	public Timestamp getModifydate() {
		return modifydate;
	}
	public void setModifydate(Timestamp modifydate) {
		this.modifydate = modifydate;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getNsummary() {
		return nsummary;
	}
	public void setNsummary(String nsummary) {
		this.nsummary = nsummary;
	}
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "News [nid=" + nid + ", ntid=" + ntid + ", ntitle=" + ntitle + ", nauthor=" + nauthor + ", ncreatedate="
				+ ncreatedate + ", npicpath=" + npicpath + ", modifydate=" + modifydate + ", ncontent=" + ncontent
				+ ", nsummary=" + nsummary + ", tid=" + tid + ", tname=" + tname + "]";
	}
	
	
}
