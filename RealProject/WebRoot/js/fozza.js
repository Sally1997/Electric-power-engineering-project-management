
	function showpage() {
		aja.onreadystatechange = function() {
			if (aja.readyState == 4 && aja.status == 200) {
			var str = eval("(" + aja.responseText + ")");
			var plist = str.pi_list;
			//设置tr的block和none display属性
			var fozza_tr = document.getElementsByName("fozza_tr");

			var pro_no = document.getElementsByName("pro_no");
			var pro_pname = document.getElementsByName("pro_pname");
			var pro_name = document.getElementsByName("pro_name");
			var pro_duty = document.getElementsByName("pro_duty");
			var pro_ptype = document.getElementsByName("pro_ptype");
			var pro_pstate = document.getElementsByName("pro_pstate");

			for (var i = 0; i < 5; i++) {
				if (plist[i] != null) {
					pro_no[i].innerHTML = plist[i].pno;
					pro_pname[i].innerHTML = plist[i].pname;
					pro_name[i].innerHTML = plist[i].name;
					pro_duty[i].innerHTML = plist[i].duty;
					pro_ptype[i].innerHTML = plist[i].ptype;
					pro_pstate[i].innerHTML = plist[i].pstate;
				} else {
					fozza_tr[i].style.display = "none";
				}
			}
		}
	}
}