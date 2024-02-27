<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="keywords" content="" />
	<meta name="author" content="" />
	<meta name="robots" content="" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Fillow : Fillow Saas Admin  Bootstrap 5 Template" />
	
	
	<meta property="og:image" content="https:/fillow.dexignlab.com/xhtml/social-image.png" />
	<meta name="format-detection" content="telephone=no">
	
	<!-- PAGE TITLE HERE -->
	<title>作业管理系统</title>
	
	<!-- FAVICONS ICON -->
	<link rel="shortcut icon" type="image/png" href="resource/images/favicon.png" />
	<link href="resource/vendor/jquery-nice-select/css/nice-select.css" rel="stylesheet">
	<link href="resource/vendor/owl-carousel/owl.carousel.css" rel="stylesheet">
	<link rel="stylesheet" href="resource/vendor/nouislider/nouislider.min.css">
	
	<!-- Style css -->
    <link href="resource/css/style.css" rel="stylesheet">
	
</head>
<body>
    <div id="preloader">
		<div class="lds-ripple">
			<div></div>
			<div></div>
		</div>
    </div>
    <div id="main-wrapper">
	
      <jsp:include page="/WEB-INF/common/form_header.jsp"/>
      <jsp:include page="/WEB-INF/common/line.jsp"/>
      
      

        <div class="content-body">
            <!-- row -->
			<div class="container-fluid">
				<div class="row">
					<div class="col-xl-12">
						<div class="row">
							<div class="col-xl-12">
								<div class="row">
									
									<div class="col-xl-12">
										<div class="card">
											<div class="card-header border-0 flex-wrap">
												<h4 class="fs-20 font-w700 mb-2">欢迎来到作业管理系统</h4>
											</div>
												<div class="card-body">
										     	<div class="d-flex justify-content-between align-items-center flex-wrap">
												<h4 class="fs-24 font-w700 ">作业等级数量统计</h4>
												</div>
												<div class="tab-content">
													<div class="tab-pane fade active show" >
														<div id="main1" class="chartBar" style="width:100%;height:500px;"></div>
													</div>	
												</div>
												
											</div>
										</div>
									</div>
								
								</div>
								
							</div>
						</div>
					</div>
				</div>
            </div>
        </div>
        <div class="footer">
            <div class="copyright">
                <p>泰迪专属2022</p>
            </div>
        </div>


	</div>
    <script src="resource/vendor/global/global.min.js"></script>
	<script src="resource/vendor/chart.js/Chart.bundle.min.js"></script>
	<script src="vendor/jquery-nice-select/js/jquery.nice-select.min.js"></script>
	
	<!-- Apex Chart -->
	<script src="resource/vendor/apexchart/apexchart.js"></script>
	
	<script src="resource/vendor/chart.js/Chart.bundle.min.js"></script>
	
	<!-- Chart piety plugin files -->
    <script src="resource/vendor/peity/jquery.peity.min.js"></script>
	<!-- Dashboard 1 -->
	<script src="resource/js/dashboard/dashboard-1.js"></script>
	
	<script src="resource/vendor/owl-carousel/owl.carousel.js"></script>
	
    <script src="resource/js/custom.min.js"></script>
	<script src="resource/js/dlabnav-init.js"></script>
	<script src="resource/js/demo.js"></script>
    <script src="resource/js/styleSwitcher.js"></script>
      <script src="resource/echarts/echarts.js"></script>
    
	<script>
	
	
	
	  $.ajax({
	        cache : true,
	        type : "post",
	        url : "XszyServlet?action=selectStaticsXszy",
	        async : false,
	        success : function(e) {
	            if (e) {
	                var list = eval(e);
	                console.log(list);
	                if(list.length > 0){
	                    var message = [];
	                    var counts = [];
	                    for(var i= 0;i<list.length;i++){
	                        message.push(list[i].names);
	                        counts.push(list[i].counts);
	                    }
	                    echarts.init(document.getElementById('main1')).setOption({
	                      /*   title: {
	                            text: '订单统计（每个人反馈的次数）'
	                        }, */
	                        xAxis: {
	                            type: 'category',
	                            data: message
	                        },
	                        yAxis: {
	                            type: 'value'
	                        },
	                        series: [{
	                            data: counts,
	                            type: 'bar'
	                        }]
	                    });

	                }

	            } else {
	                alert("查询失败！");
	            }
	        }
	    })
	
	
		function cardsCenter()
		{
			
			/*  testimonial one function by = owl.carousel.js */
			
	
			
			jQuery('.card-slider').owlCarousel({
				loop:true,
				margin:0,
				nav:true,
				//center:true,
				slideSpeed: 3000,
				paginationSpeed: 3000,
				dots: true,
				navText: ['<i class="fas fa-arrow-left"></i>', '<i class="fas fa-arrow-right"></i>'],
				responsive:{
					0:{
						items:1
					},
					576:{
						items:1
					},	
					800:{
						items:1
					},			
					991:{
						items:1
					},
					1200:{
						items:1
					},
					1600:{
						items:1
					}
				}
			})
		}
		
		jQuery(window).on('load',function(){
			setTimeout(function(){
				cardsCenter();
			}, 1000); 
		});
		
	</script>

</body>
</html>