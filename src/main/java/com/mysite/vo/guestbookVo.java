package com.mysite.vo;

public class guestbookVo {
	private int no;
	private String name;
	private String password;
	private String content;
	private String leg_date;

	

	public guestbookVo(int no, String name, String password, String content, String leg_date) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.content = content;
		this.leg_date = leg_date;
	}
	
	

	public guestbookVo() {
		super();
	}



	public guestbookVo( String name, String password, String content) {
		super();
		
		this.name = name;
		this.password = password;
		this.content = content;
		
	}
	
	public guestbookVo(int no, String name, String content, String leg_date) {
		super();
		this.no = no;
		this.name = name;
		
		this.content = content;
		this.leg_date = leg_date;
	}

	public guestbookVo( String no, String password) {
		super();
		
		
		this.no = Integer.valueOf(no);
		this.name=" ";
		this.content=" ";
		this.password = password;
		
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLeg_date() {
		return leg_date;
	}

	public void setLeg_date(String leg_date) {
		this.leg_date = leg_date;
	}



	@Override
	public String toString() {
		return "guestbookVo [no=" + no + ", name=" + name + ", password=" + password + ", content=" + content
				+ ", leg_date=" + leg_date + "]";
	}
	
	
	
	

}
