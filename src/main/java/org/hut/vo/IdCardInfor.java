package org.hut.vo;

import java.util.Date;

public class IdCardInfor {
	private String area;
	private String sex;
	private Date birthday;
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "IdCardInfor [area=" + area + ", sex=" + sex + ", birthday=" + birthday + "]";
	}
}
