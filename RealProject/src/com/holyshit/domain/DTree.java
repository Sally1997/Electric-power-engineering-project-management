package com.holyshit.domain;

public class DTree {
	private String currentnode;
	private String parentnode;
	private String nodename;
	private String mapping="javascript:getTask()";
	
	
	
	public String getCurrentnode() {
		return currentnode;
	}



	public void setCurrentnode(String currentnode) {
		this.currentnode = currentnode;
	}



	public String getParentnode() {
		return parentnode;
	}



	public void setParentnode(String parentnode) {
		this.parentnode = parentnode;
	}



	public String getNodename() {
		return nodename;
	}



	public void setNodename(String nodename) {
		this.nodename = nodename;
	}



	public String getMapping() {
		return mapping;
	}



	public void setMapping(String mapping) {
		this.mapping = mapping;
	}


	public String toString(){
		return "dtree [currentnode="+currentnode+", parentnode="+parentnode+
				", nodename="+nodename+", mapping="+mapping+"]";
	}
	
}
