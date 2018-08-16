<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %> 

<!-- 我的博客-留言板 -->

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>My Blog|留言板</title>

  <!-- bootstrap-css -->
  <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <!-- MessageBoard-css -->
  <link rel="stylesheet" type="text/css" href="../css/messageboard.css" />
  <!-- VivaTimeline-css -->
  <link rel="stylesheet" type="text/css" href="../css/jquery.eeyellow.Timeline.css" />

  <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body >
  <!-- 导航栏 -->
  <nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
      <div class="navbar-header">
        <a href="#" class="navbar-brand">MyBlog</a>
      </div>
      <div class="">
        <ul class="nav navbar-nav">
          <li class="dropdown"><a href="#">首页</a></li>
          <li class="active"><a href="${pageContext.request.contextPath}/findmsg.action">留言板</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- 留言板 -->
  <div class="main-container ">
    <div class="container">
      <div class="row">

        <div class="col-xs-1 col-sm-2 col-md-2 col-lg-2">

        </div>

        <div id="msg-in" class="col-xs-10 col-sm-8 col-md-8 col-lg-8">
          <!-- form表单 -->
          <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/addmsg.action " method="post">
            <div class="form-group">
              <label for="name">姓名：</label>
              <input type="text" class="form-control" name="name" placeholder="请输入名称">
            </div>
            <div class="form-group">
              <label for="message">内容：</label>
              <textarea class="form-control" rows="3" name="message" placeholder="请输入内容"></textarea>
            </div>
            <div class="form-group">
              <button type="submit" name="publish" class="btn btn-success">发表</button>
            </div>
          </form>
        </div>

        <div class="col-xs-1 col-sm-2 col-md-2 col-lg-2">

        </div>
      </div>

      <div class="message">
        <div class="row">
          <div class="col-xs-1 col-sm-2 col-md-2 col-lg-2">

          </div>
          <div id="msg-out" class="col-xs-10 col-sm-8 col-md-8 col-lg-8">
            <div class="VivaTimeline">
              <dl>

                <dt>May 2016</dt>
                <dd class="pos-left clearfix">
                  
                  <s:iterator value="#session.msgs" var="msg">
	                  <div class="circ"></div>
	                  <div class="time">
							<s:property value="#msg.date" />
						</div>
	                  <div class="events">
	                    <div class="row">
	                      <div class="events-header">
								<s:property value="#msg.name" />
							</div>
	                      <div class="events-body">
	                            <div class="even+ts-desc">
										<s:property value="#msg.message" />
	                            </div>
	                        </div>
	                    </div>
	                  </div>
                  </s:iterator>
               
                </dd>

              </dl>
            </div>
          </div>
          <div class="col-xs-1 col-sm-2 col-md-2 col-lg-2">

          </div>
        </div>

        <div class="row">
            <button id="fat-btn" class="btn btn-primary" data-loading-text="Loading..."type="button">
              加载更多
            </button>
            <script>
                $(function() {
                    $("#fat-btn").click(function(){
                        $(this).button('loading').delay(1000).queue(function() {
                        });
                    });
                });
            </script>
        </div>
      </div>
    </div>
  </div>

  <script type="text/javascript" color="255,0,0" opacity='0.7' zIndex="-2" count="200" src="../js/canvas-nest.js"></script>
</body>

</html>
