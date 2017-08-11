package com.mysite.vo;

public class ReplyBoardVo {
	private int rownum;
	private int numb;
	private String title;
	private String content;
	private String names;
	private int hit;
	private String reg_date;
	private int user_num;
	private int groupno;
	private int orderno;
	private int depth;
	private int countsend;
	private int countreceive;
	
	public ReplyBoardVo() {
		super();
	}

	public ReplyBoardVo(int rownum, int numb, String title, String content, String names, int hit, String reg_date,
			int user_num, int groupno, int orderno, int depth, int countsend, int countreceive) {
		super();
		this.rownum = rownum;
		this.numb = numb;
		this.title = title;
		this.content = content;
		this.names = names;
		this.hit = hit;
		this.reg_date = reg_date;
		this.user_num = user_num;
		this.groupno = groupno;
		this.orderno = orderno;
		this.depth = depth;
		this.countsend = countsend;
		this.countreceive = countreceive;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public int getNumb() {
		return numb;
	}

	public void setNumb(int numb) {
		this.numb = numb;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public int getGroupno() {
		return groupno;
	}

	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getCountsend() {
		return countsend;
	}

	public void setCountsend(int countsend) {
		this.countsend = countsend;
	}

	public int getCountreceive() {
		return countreceive;
	}

	public void setCountreceive(int countreceive) {
		this.countreceive = countreceive;
	}

	@Override
	public String toString() {
		return "ReplyBoardVo [rownum=" + rownum + ", numb=" + numb + ", title=" + title + ", content=" + content
				+ ", names=" + names + ", hit=" + hit + ", reg_date=" + reg_date + ", user_num=" + user_num
				+ ", groupno=" + groupno + ", orderno=" + orderno + ", depth=" + depth + ", countsend=" + countsend
				+ ", countreceive=" + countreceive + "]";
	}

	
}
