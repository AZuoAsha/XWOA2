<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="oa.action.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>理工勤学网主页</title>
<link href="index/_css/site.css" rel="stylesheet">
<link href="index/_css/index.css" rel="stylesheet">
<link href="index/myindex/fancybox/jquery.fancybox-1.3.4.css" rel="stylesheet">
<script src="index/_js/jquery-1.7.2.min.js"></script>
<script src="index/_js/nav1.1.min.js"></script>
<script src="index/_js/jquery.easing.1.3.js"></script>
<script src="index/myindex/fancybox/jquery.fancybox-1.3.4.min.js"></script>
<script src="index/_js/site.js"></script>
<script src="index/_js/jquery-ui-1.8.13.min.js"></script>
<script>
$(document).ready(function() {
	$('#gallery a').fancybox({
		overlayColor: '#060',
		overlayOpacity: .3,
		transitionIn: 'elastic',
		transitionOut: 'elastic',
		easingIn: 'easeInSine',
		easingOut: 'easeOutSine',
		titlePosition: 'outside' ,		
		cyclic: true
	});
	 $('.answer').hide();
	    $('.main h2').toggle(
	        function() {
	            $(this).next('.answer').slideDown();
	            $(this).addClass('close');
	        },
	        function() {
	            $(this).next('.answer').fadeOut();
	            $(this).removeClass('close');
	        }
	    ); // end toggle
	    $('.tabs a').click(function() {
	        // save $(this) in a variable for efficiency
	        var $this = $(this);

	        // hide panels
	        $('.panel').hide();
	        $('.tabs a.active').removeClass('active');

	        // add active state to new tab
	        $this.addClass('active').blur();
	        // retrieve href from link (is id of panel to display)
	        var panel = $this.attr('href');
	        // show panel
	        $(panel).fadeIn(250);

	        // don't follow link down page
	        return(false);
	    }); // end click

	    // open first tab
	    $('.tabs li:first a').click();
	   
	    $("#navigation").navPlugin({
	        'itemWidth': 150,
	        'itemHeight': 30,
	        'navEffect': "slide",
	        'speed': 250
	    });
}); // end ready

</script>
</head>
<body>

<div align="center">

<div class="wrapper">
	<div class="header">
		<p class="logo">理工勤学网 <i><font size="20">&</font></i> 微信小程序</p><span><a href="login_bg.html" class="aa">登录||注册</a> </span>
	</div>
	<div class="content">
		<div class="main">
			<h1>图片展示区</h1>
			<div id="gallery">
			<a href="index/_images/large/slide1.jpg" rel="gallery" title="Lotsa golf balls"><img src="index/_images/small/slide1_h.jpg" width="70" height="70" alt="golf balls"></a>
			<a href="index/_images/large/slide2.jpg" rel="gallery" title="Someplace pretty"><img src="index/_images/small/slide2_h.jpg" width="70" height="70" alt="rock wall"></a>
			<a href="index/_images/large/slide3.jpg" rel="gallery" title="The Old Course"><img src="index/_images/small/slide3_h.jpg" width="70" height="70" alt="old course"></a>
			<a href="index/_images/large/slide4.jpg" rel="gallery" title="Lotsa tees"><img src="index/_images/small/slide4_h.jpg" width="70" height="70" alt="tees"></a>
			<a href="index/_images/large/slide5.jpg" rel="gallery" title="Tree and pond"><img src="index/_images/small/slide5_h.jpg" width="70" height="70" alt="tree"></a>
			<a href="index/_images/large/slide6.jpg" rel="gallery" title="Is that the Loch Ness Monster?"><img src="index/_images/small/slide6_h.jpg" width="70" height="70" alt="ocean course"></a>
			<a href="index/_images/large/green.jpg" rel="gallery" title="Someplace pretty"><img src="index/_images/small/green_h.jpg" width="70" height="70" alt="rock wall"></a>
			<a href="index/_images/large/orange.jpg" rel="gallery" title="The Old Course"><img src="index/_images/small/orange_h.jpg" width="70" height="70" alt="old course"></a>
			<a href="index/_images/large/yellow.jpg" rel="gallery" title="Is that the Loch Ness Monster?"><img src="index/_images/small/yellow_h.jpg" width="70" height="70" alt="ocean course"></a>
			</div>
		</div>
	</div>
</div>
<div style="clear: both;"></div>
<di class="wrapper">
		<div class="content">
			<div class="main">
				<div class="tabbedPanels">
				<h1>功能说明</h1>
					<ul class="tabs">
						<li><a href="#panel1" tabindex="1">开发目的</a></li>
						<li><a href="#panel2" tabindex="2">诚信说明</a></li>
						<li><a href="#panel3" tabindex="3">系统功能</a></li>
					</ul>
					<div class="panelContainer">
						<div id="panel1" class="panel">
							<h2>目的说明</h2>
							<p><img src="index/_images/small/red_h.jpg" alt="Red" width="70" height="70" class="imgRight">持续创新，提供卓越领先的教育服务，打造中国最好的在线学习平台，我们将以长远的眼光、诚信负责的操守、共同成长的理念，发展公司的事业；坚持"用户学习成长第一"的理念，从创造用户价值开始，从而提升企业价值；与所有合作伙伴一起成长，持续创新，分享成长的价值。勤学网，职业技能高效率自学平台，致力于为学习者提供优质的在线学习服务，帮助学习者提升各方面的能力，获得更好的生活品质，为了解决广大家长对自己孩子学习成绩不理想的苦恼，我们团队开发了此网站，让孩子们对学习不会感到厌倦，不会疲劳，我们在提供学习视频的同时也提供了教学性娱乐视频，让孩子们能够带着乐趣去学习，劳逸结合，我们不求不一分钱的汇报，是纯粹免费提供教学视频，不收任何费用，不贪任何钱财，保证保密用户信息。 </p>
							<p><img src="index/_images/small/slide3_h.jpg" alt="Old Course" width="70" height="70" class="imgLeft">目前我们的课程覆盖了视频教程，教学资源，英语课程，汇聚了行业的精英人才。你可以自由选择感兴趣的网络课程在线学习，创新的个性化学习体验，自由开放的交流互动环境，邀你一起来学习和分享！我们的目标汇集精英教师视频，打造精品课程，做最高效的在线学习网站！网站宗旨：服务教育事业，倡导终身学习，培养提高学习能力，积极学习，善于学习，持续学习；目光向前，不仅去做，而且要执着地去做；坚韧不拔，任何困难和挫折也阻挡不了勤学网一往无前的意志。 通过互联网和移动互联网实现教与学的最高价值，我们通过最先进的科学技术，开发和推送最优质的学习内容，服务用户的学习成长目标；通过不断创新，提供最科学的学习工具，以实现知识的最优传播和用户的知识沉淀；通过互联网和移动互联网技术，实现用户随时随地，终身学习成长的最高价值。</p>
						</div>
						<div id="panel2" class="panel">
							<h2>我们对用户、对客户，对合作伙伴，诚信到永远</h2>
							<p style="text-align:center;margin-top: 25px;"><img src="index/_images/large/slide4.jpg" width="610" height="342" alt="tees"></p></div>
						<div id="panel3" class="panel">
							<h2>系统功能简介</h2>
							<p>理工勤学网基本功能包括用户注册，用户登录，修改密码以及注销账号，用户注册本网站时，只要填写合法信息，即可注册成功，如果用户填写的信息不合法，那么就注册不会通过，因为理工勤学网对用户信息的合法性进行了严谨的判断，所以填写信息要合法，如果用户已经注销了账号还可以再次注册，注册邮箱要仔细填写正确，因为登录时是根据用户填写的邮箱和密码登录，两次输入的密码必须一致. </p>
							<p>用户登录进来过后可以进行修改个人信息，包括生日，婚姻状况，兴趣爱好以及修改用户头像，同时用户可以查看他人的一部分信息和个人信息，用户登录进来过后可以根据上面的导航栏进行查找自己需要的信息，理工勤学网都免费提供了相应的资源，包括学习视频，娱乐视频，团队介绍，学习视频包括了小学英语，初中英语，高中英语，大学应用等等，视频都是从名校精挑细选出来的，保证用户看了过后有所提升，当然我们团队也会不定期的更换视频，我们会尽量满足广大用户的要求. </p>
						</div>
					</div>
				</div>
				<p align="left">21世纪是信息爆炸的时代，也是学习的时代，在资讯、知识更加丰富的今天，无论是个人或者是组织，如果忽略了学习，将无法取得更快的发展与更大的提高，而随着互联网的崛起，互联网改变了我们学习的方式，大大丰富了学习的途径。<br>　我们相信：不久的将来，在这个没有边界限制的大讲堂上，将聚集各行各业最优秀的教育和培训专家，为广大莘莘学子提供分门别类的优质课程，届时，无论你是大山深处的农家子弟还是繁华闹市的打工一族，只要你具备上网条件，只要你愿意学习，你就能够随时随地享受到优质的教育资源。
　
勤学网将不断完善和优化课程内容及各项服务，做学员职业发展道路上值得信赖的良师益友！让我们一起成长，成为更好的自己！公司愿景：持续创新，提供卓越领先的教育服务，打造中国最好的在线学习平台。公司使命： 通过互联网和移动互联网实现教与学的最高价值。"诚信、创新、尽责、共赢"。</p>
			</div>
		</div>
	</di>
<div style="clear: both;"></div>
<div class="wrapper">
		<div class="content">
			<div class="main" align="left">
				<h1 align="center">关于理工勤学网</h1>
				<h2>在理工勤学网能学什么?</h2>
				<div class="answer">
					<p>理工勤学网包揽了很多教学视频，特别是英语，还有IT类视频等等，详细请点击右上角登录及注册按钮进行登录浏览，只要你看了我们提供的视频，我们保证你一定会有所收获，不管有多少收获都是值得的。精益求精，用不断提升的产品来服务我们的用户，有强烈的责任意识，有杰出的肩负责任的能力，有勇于承担责任的品格，雄厚的师资力量，优秀的课程品质，实现多方共赢局面。</p>
				</div>
				<h2>里面有什么资源?</h2>
				<div class="answer">
					<p>资源有教学视频，课本，等等，详细请点击右上登录注册按钮进行登录浏览。理工勤学网，职业技能高效率自学平台，致力于为学习者提供优质的在线学习服务，帮助学习者提升各方面的能力，获得更好的生活品质</p>
				</div>
				<h2>资源都是免费的吗?</h2>
				<div class="answer">
					<p>我们不受用户任何费用，一切资源都是免费提供，用户可以放心学习!</p>
				</div>
			</div>
		</div>
	</div>

<div style="margin-bottom: 6%;" class="wrapper" >
	<div class="content">
		<div class="main" >
			<ul id="navigation">
				<li><a href="#">返回顶部</a></li>
				<li><a href="#">网站的起源</a>
					<!--<ul>
						 <li><a href="#">我们的历史</a></li> 
						<li><a href="#">网站的起源</a></li>
					    <li><a href="#">联系我们</a></li>
					</ul> -->
				</li>
				<li><a href="#">我们的产品 </a>
					<ul>
						<li><a href="#">微信小程序</a>
							<!-- <ul>
								<li><a href="#">英语视频</a></li>
								<li><a href="#">娱乐视频</a></li>
								<li><a href="#">其它</a></li>
							</ul> -->
						</li>
						<li><a href="requirelogin.html">英语资料</a></li>
					</ul>
				</li>
			</ul>
			<p style="clear:left;padding-top: 0px;" ></p>
		</div>
	</div>
</div>

<div class="footer">
<p align="center"> <a href="hxm/hhh/aboutus/aboutus.html">关于我们</a> ||<a href="hxm/hhh/contus/coutus.html">联系我们</a>||<a href="requirelogin.html">意见反馈</a><br><span style="color:white;">地址:成都市成华区二仙桥东三路1号成都理工大学<br>联系电话:13547937119<br>联系人:微信小程序团队</span></p>
</div>
<%
    //訪問量
    String count = VisitorCounter.readCount("D:/visitCount.txt");
    if (session.getAttribute("visit") == null) {
        session.setAttribute("visit", "y");//将未访问设置为访问
        session.setMaxInactiveInterval(60 * 60 * 24);//设置最大时效    单位是秒
    
        int count1 = Integer.parseInt(count);
        count1 = count1 + 1;
        count = String.valueOf(count1).toString();
        VisitorCounter.writeCount("D:/visitCount.txt", count);
    }
%>
<span style="color: #ff0000;font-size:20px;">总访问量为:<%=count%>次</span>
<div id="resources">
    <p class="open">+</p>
    <h2>关于成都理工大学</h2>
    <ul class="nav">
      <li><a href="http://www.cist.cdut.edu.cn/">信息科学与技术学院</a></li>
      <li><a href="http://www.cnae.cdut.edu.cn/">核自学院</a></li>
      <li><a href="http://www.cim.cdut.edu.cn/">管理科学学院</a></li>
      <li><a href="http://www.cc.cdut.edu.cn/">商学院</a></li>
      <li><a href="http://www.cdut.edu.cn:8003/wgyxy/default.html">外国语学院</a></li>
      <li><a href="http://www.cdut.edu.cn/zzxy/default.html">马克思主义学院</a></li>
       <li><a href="http://www.cdut.edu.cn/default.html">更多学院请浏览理工大学官网</a></li>
    </ul>
    <h2>更多学习网站</h2>
    <ul class="nav">
      <li><a href="http://www.itcast.cn/">传智播客</a></li>
      <li><a href="http://www.zhinengshe.com/">智能社</a></li>
      <li><a href="http://www.w3school.com.cn/">w3school</a></li>
      <li><a href="https://www.imooc.com/">慕课网</a></li>
    </ul>
  </div>
</div>
</body>
</html>
