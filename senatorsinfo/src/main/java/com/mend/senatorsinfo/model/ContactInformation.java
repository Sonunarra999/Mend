package com.mend.senatorsinfo.model;

import java.util.List;

public class ContactInformation {
	
	private List<Member> members;

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}
	
	@Override
	public String toString() {
		if (this.members != null  && this.members.size() > 0 ) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < this.members.size() ; i++) {
				sb.append("{");
				sb.append(members.get(i).toString());
				sb.append("}");
				if(i < this.members.size() -1) {
					sb.append(",");
				}
			}
			return sb.toString();
		}
		return "";
	}
}