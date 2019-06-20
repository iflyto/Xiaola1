package com.xj.xiaola.zero;

public class GoodsBiaoqianBean {

	private int id;
	private String name;
	private String desc;

	
	public String oneFen;
	public String twoFen;
	public String threeFen;
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "HotBiaoqianBean [oneFen=" + oneFen + ", twoFen=" + twoFen + ", threeFen=" + threeFen + "]";
	}

	public GoodsBiaoqianBean() {
	}

	public GoodsBiaoqianBean(int id, String name, String desc) {
		this.id = id;
		this.name = name;
		this.desc = desc;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}
}
