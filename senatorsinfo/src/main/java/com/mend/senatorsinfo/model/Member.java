package com.mend.senatorsinfo.model;

import java.util.List;

public class Member {

	private String firstName;
	private String lastName;
	private String fullName;
	private String chartId;
	private String mobile;
	private List<Address> address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getChartId() {
		return chartId;
	}

	public void setChartId(String chartId) {
		this.chartId = chartId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		String addresses = "";
		if (this.address != null && this.address.size() > 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < this.address.size(); i++) {
				sb.append("{");
				sb.append(address.get(i).toString());
				sb.append("}");
				if (i < this.address.size() - 1) {
					sb.append(",");
				}
			}
			addresses = sb.toString();
		}
		return "\"firstName\":" + "\"" + firstName + "\"" + ", \"lastName\":" + "\"" + lastName + "\""
				+ ", \"fullName\":" + "\"" + fullName + "\"" + ", \"chartId\":"
				+ "\"" + chartId + "\"" + ", \"mobile\":" + "\"" + mobile + "\"" + ", \"address\": [" + addresses + "]";
	}

}
