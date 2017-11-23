function getUserLogoUrl(id,img) {
	// 创建请求
	var req = new XMLHttpRequest();
	req.responseType = "blob";
	req.onreadystatechange = function() {
		if (req.readyState == 4) {
			if (req.status == 200) {
				var res=req.response;
				img.src=window.URL.createObjectURL(res);
			}else if(req.status==404){
				img.src="/RealProject/image/unlogin.jpg";
			}
		}
	};
	// 连接服务器
	req.open("get","/RealProject/web/servlet/getuserlogobyid?id="+id);
	// 发送请求
	req.send(null);
}
