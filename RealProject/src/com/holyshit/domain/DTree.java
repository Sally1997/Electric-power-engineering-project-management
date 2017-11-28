package com.holyshit.domain;

public class DTree {
	public String CurrentNode;
	public String ParentNode;
	public String NodeName;
	public String Mapping="javascript:getTask()";
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
	public void setNodeName(String nodeName) {
		NodeName = nodeName;
	}
	
	
}
