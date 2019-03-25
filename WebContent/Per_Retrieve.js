// JavaScript Document
function label(){	
	var aRe=document.getElementById("retrieval");
	var oUl=aRe.getElementsByTagName('ul');
	var oLi1=oUl[0].getElementsByTagName('li');
	var oLi2=oUl[1].getElementsByTagName('li');
	var oLi3=oUl[2].getElementsByTagName('li');
	var oLi4=oUl[3].getElementsByTagName('li');
	var oLi5=oUl[4].getElementsByTagName('li');
	
	for(var i=0;i<oLi1.length;i++){
		oLi1[i].onclick=function(){
			for(var j=0;j<oLi1.length;j++){
				oLi1[j].style.background='';
			}
			this.style.background='cadetblue';
			document.location = "?DISC="+this.className;
		};
	}
	for(var i=0;i<oLi2.length;i++){
		oLi2[i].onclick=function(){
			for(var j=0;j<oLi2.length;j++){
				oLi2[j].style.background='';
			}
			this.style.background='cadetblue';
			document.location = "?Personneltypes="+this.className;
		};
	}
	for(var i=0;i<oLi3.length;i++){
		oLi3[i].onclick=function(){
			for(var j=0;j<oLi3.length;j++){
				oLi3[j].style.background='';
			}
			this.style.background='cadetblue';
			document.location = "?Sex="+this.className;
		};
	}
	for(var i=0;i<oLi4.length;i++){
		oLi4[i].onclick=function(){
			for(var j=0;j<oLi4.length;j++){
				oLi4[j].style.background='';
			}
			this.style.background='cadetblue';
			document.location = "?Area="+this.className;
		};
	}
	for(var i=0;i<oLi5.length;i++){
		oLi5[i].onclick=function(){
			for(var j=0;j<oLi5.length;j++){
				oLi5[j].style.background='';
			}
			this.style.background='cadetblue';
			document.location = "?Team="+this.className;
		};
	}
};

function proretloop(){
	var A=new Array();
	for(i=0; i<rownum; i++)
	{
		box=document.getElementById("box");

		content=document.createElement("div");
		content.className="content";
		box.appendChild(content);

		A[i]=document.createElement("a");
		A[i].href='contact/Per_Details.php?memberID='+obj[i][0];
		content.appendChild(A[i]);
		img[i]=document.createElement('img');
		img[i].className='contentImg';
		img[i].title="点击查看详情";
		img[i].src='contact/img/userimg/'+obj[i][10];
		A[i].appendChild(img[i]);

		p[i] = new Array();
		p[i][0]=document.createElement("p");
		p[i][0].className = "Name";
		p[i][0].innerHTML = "姓名："+obj[i][1];
		content.appendChild(p[i][0]);

		p[i][1]=document.createElement("p");
		p[i][1].className = "Sex";
		p[i][1].innerHTML = "性别："+obj[i][3];
		content.appendChild(p[i][1]);

		p[i][2]=document.createElement("p");
		p[i][2].className = "Bref";
		p[i][2].innerHTML = "简介："+obj[i][9];
		p[i][2].title="简介："+obj[i][9];
		content.appendChild(p[i][2]);

	}
}