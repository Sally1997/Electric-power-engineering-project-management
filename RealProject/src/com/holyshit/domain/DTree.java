package com.holyshit.domain;

public class DTree {
	private String CurrentNode;
	private String ParentNode;
	private String NodeName;
	private String Mapping="javascript:getTask()";
	public String getCurrentNode() {
		return CurrentNode;
	}
	public void setCurrentNode(String currentNode) {
		CurrentNode = currentNode;
	}
	public String getParentNode() {
		return ParentNode;
	}
	public void setParentNode(String parentNode) {
		ParentNode = parentNode;
	}
	public String getNodeName() {
		return NodeName;
	}
	public String getMapping() {
		return Mapping;
	}
	public void setNodeName(String nodeName) {
		NodeName = nodeName;
	}
	
	public String toString(){
		return "DTree [CurrentNode="+CurrentNode+", ParentNode="+ParentNode+
				", NodeName="+NodeName+", Mapping="+Mapping+"]";
	}
	
}
