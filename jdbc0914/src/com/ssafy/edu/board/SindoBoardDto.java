package com.ssafy.edu.board;

public class SindoBoardDto {
	private int ids;
	private String writer;
	private String title;
	private String content;
	private String wdate;	
	
	public SindoBoardDto() {
		super();
	}
	
	public int getIds() {
		return ids;
	}

	public void setIds(int ids) {
		this.ids = ids;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public SindoBoardDto(int ids, String writer, String title, String content, String wdate) {
		super();
		this.ids = ids;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
	}
	
	@Override
	public String toString() {
		return "SindoBoardDto [ids=" + ids + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", wdate=" + wdate + "]";
	}

	public SindoBoardDto(String writer, String title, String content) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	

}
