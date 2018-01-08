package com.holyshit.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.holyshit.domain.PSPlan;
import com.holyshit.service.ProjectService;
import com.holyshit.service.StageTasksService;
import com.holyshit.service.impl.ProjectServiceImpl;
import com.holyshit.service.impl.StageTasksServiceImpl;

public class AutoNumber {
	//1位项目类型+4位项目编号+1位层号+1位阶段+3位任务+1位指标
	//项目编号(char 5)-->阶段编号(char 6)-->任务编号(char 10)-->指标编号(char 11)
	/**
	 * 根据项目编号获取阶段编号
	 * @return 阶段编号
	 * @throws SQLException 
	 */
	public String PNtoSN(String pn) throws SQLException{
		PSPlan pro_stage = new PSPlan();
		
		pro_stage.setPno(pn);
		//根据项目编号获取阶段编号
		ProjectService pros = new ProjectServiceImpl();
		List<Object> list = pros.getNewStageNo(pn);
		String ss = pn;
		//获取降序后的第一个阶段编号，即最大的那个
		if(list.isEmpty()){
			ss+="0";
		}
		else{
			String newsn_1 = list.get(0).toString();
			
			String s = "";
			/*//获取阶段编号的第两位
			String newsn_2 = newsn_1.substring(newsn_1.length()-2, newsn_1.length());
			int x = Integer.parseInt(newsn_2);
			//编号加1
			x++;
			if(x<10){
				s += "0";
			}*/
			//获取阶段编号最后一位
			char x = newsn_1.charAt(newsn_1.length()-1);
			if(x!=9){
				x+=1;
			}
			else{//9的话进位到a,其他情况下加一
				x='a';
			}
			s += x;
			//项目编号加上x
			ss+=s;
		}
		return ss;
	}
	
	public String SNToSN(String sn){
		//获取阶段编号最后一位
		char x = sn.charAt(sn.length()-1);
		sn = sn.substring(0,5);
		if(x!=9){
			x+=1;
		}
		else{//9的话进位到a,其他情况下加一
			x='a';
		}
		sn += x;
		//项目编号加上x
		return sn;
	}
	
	/**
	 * 任务指标表，当存入阶段编号时，用zzzz填充阶段编号的后四位
	 * @param pn1
	 * @return
	 */
	public String CreateNewTaskNo(String pn1){
		String tn = pn1;
		tn += "zzzz";
		return tn;
	}
	
	/**
	 * 根据阶段编号或任务编号生成新的任务编号
	 * @param tno
	 * @return
	 * @throws SQLException 
	 */
	public String TrueNewTaskNo(String tno) throws SQLException{
		String ntn = tno.substring(0,6);
		//阶段生成
		if(tno.length()==6){
			ntn += "000";
		}
		else{
			//任务编号的子任务编号规则：
			//最后一位表示序数，从0开始
			//倒数第二位表示层数
			//倒数三四位记录父节点的尾数
			//按照********（++）_前八位固定，第九位+1，第十位任意值查询数据库，生成新的编号
			String s2 = tno.substring(8, 10);
			ntn += s2;
			char x8 = (char) (tno.charAt(8));
			if(x8=='9'){
				x8 = 'a';
			}
			else{
				x8++;
			}
			ntn += x8;
		}
		StageTasksService sts = new StageTasksServiceImpl();
		List<Object> list1 = sts.getNewTaskNo9(ntn);
		if(list1.isEmpty()){
			ntn += "0";
		}
		else{
			String newno9 = list1.get(0).toString();
			char x = newno9.charAt(9);
			if(x=='9'){
				x = 'a';
			}
			else{
				x++;
			}
			ntn += x;
		}
		return ntn;
	}
	
	public String TNToTn(String tn){
		//获取阶段编号最后一位
		char x = tn.charAt(tn.length()-1);
		tn = tn.substring(0,9);
		if(x!=9){
			x+=1;
		}
		else{//9的话进位到a,其他情况下加一
			x='a';
		}
		tn += x;
		//项目编号加上x
		return tn;
	}
	
	
	/**
	 * 根据任务编号获得索引编号
	 * @param tn 任务编号
	 * @return
	 * @throws SQLException 
	 */
	public String TNtoIN(String tn) throws SQLException{
		String in = tn;
		StageTasksService sts = new StageTasksServiceImpl();
		List<Object> list = sts.getNewIndexNo(tn);
		if(list.isEmpty()){
			in+="0";
		}
		else{
			String newtn_1 = list.get(0).toString();
			char x = newtn_1.charAt(newtn_1.length()-1);
			if(x!=9){
				x+=1;
			}
			else{
				x='a';//进位到a
			}
			in+=x;
		}
		return in;
	}
	
	//项目编号生成 0/1 获取降序后的第一个项目编号，即最大的那个
	public String PTypeToPNo(String x){
		String Pno = "";
		ProjectService ps = new ProjectServiceImpl();
		List<Object> list = new ArrayList<Object>();
		list = ps.getNewProjectNo(x);
		if(list.isEmpty()){//如果链表为空，则直接返回
			Pno = x + "0000";
			return Pno;
		}
		String str = list.get(0).toString();
		
		//最后一位
		char c5 = str.charAt(str.length()-1);
		char c4 = str.charAt(str.length()-2);
		char c3 = str.charAt(str.length()-3);
		char c2 = str.charAt(str.length()-4);
		if(c5=='9'){
			c5='a';
		}
		else if(c5=='z'){
			c5='0';
			//纯偷懒行为，发现当初没写进制~~~不过只有四位，情况不大,相当于做了循环展开，优化代码
			if(c4=='9'){
				c4='a';
			}
			else if(c4=='z'){
				c4='0';
				//c3进位
				if(c3=='9'){
					c3='a';
				}
				else if(c3=='z'){
					c3='0';
					//第二位的进位
					if(c2=='9'){
						c2='a';
					}
					else if(c2=='z'){
						
					}
					else{
						c2++;
					}
					//第二位进位结束
				}
				else{
					c3++;
				}
				//c3进位
			}
			else{
				c4++;
			}
		}
		else{
			c5++;
		}
		
		Pno += x+c2+c3+c4+c5;
		return Pno;
	}
	
	//state从数字映射到字符串
	
	/**
     * json大写转小写
     * 
     * @param jSONArray1 jSONArray1
     * @return JSONObject
     */
    public static JSONObject transToLowerObject(String json) {
        JSONObject jSONArray2 = new JSONObject();
        JSONObject jSONArray1 = JSONObject.fromObject(json);
        Iterator it = jSONArray1.keys();
        while (it.hasNext()) {
            String key = (String) it.next();
            Object object = jSONArray1.get(key);
            if (object.getClass().toString().endsWith("JSONObject")) {
                jSONArray2.accumulate(key.toLowerCase(), transToLowerObject(object.toString()));
            } else if (object.getClass().toString().endsWith("JSONArray")) {
                jSONArray2.accumulate(key.toLowerCase(), transToArray(jSONArray1.getJSONArray(key).toString()));
            }else{
                 jSONArray2.accumulate(key.toLowerCase(), object);
            }
        }
        return jSONArray2;
    }

    /**
     * jsonArray转jsonArray
     * 
     * @param jSONArray1 jSONArray1
     * @return JSONArray
     */
    public static JSONArray transToArray(String jsonArray) {
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray1 = JSONArray.fromObject(jsonArray);
        for (int i = 0; i < jSONArray1.size(); i++) {
            Object jArray = jSONArray1.getJSONObject(i);
            if (jArray.getClass().toString().endsWith("JSONObject")) {
                jSONArray2.add(transToLowerObject( jArray.toString()));
            } else if (jArray.getClass().toString().endsWith("JSONArray")) {
                jSONArray2.add(transToArray(jArray.toString()));
            }
        }
        return jSONArray2;
    }
	
}
