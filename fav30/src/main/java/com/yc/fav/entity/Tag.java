package com.yc.fav.entity;

public class Tag {
	private Integer tid;
	private String tname;
	private Integer tcount;
	public Tag() {
	}
	
	public Tag(String tname) {
		this.tname = tname;
	}

	public Tag(Integer tid, String tname, Integer tcount) {
		this.tid = tid;
		this.tname = tname;
		this.tcount = tcount;
	}

	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Integer getTcount() {
		return tcount;
	}
	public void setTcount(Integer tcount) {
		this.tcount = tcount;
	}

	@Override
	public String toString() {
		return "\nTag [tid=" + tid + ", tname=" + tname + ", tcount=" + tcount + "]";
	}
}
