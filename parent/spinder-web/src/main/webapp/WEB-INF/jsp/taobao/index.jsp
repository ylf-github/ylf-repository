<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--suppress ALL -->
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Bootstrap Store</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <style>
        ::-webkit-inner-spin-button { visibility: hidden; }
        input::-webkit-input-placeholder { /* WebKit browsers */
            color: #93939e;
        }
        input:focus::-webkit-input-placeholder{
            text-indent: -999em;
            z-index: -20;
        }
        .container-fluid{
            background-color: #000000;
        }
        .container{
            padding-top: 15px ;
        }
        .item{
            width: 1150px;
            height: 350px;
            -webkit-background-size: 100%;
            background-size: 100%;
        }
        hr{
            border-top: 2px solid #eee;
        }
        #itx{
             margin-top: -5px;

        }
        #itx:focus{
            outline:none;

        }
        #datee{
            margin-top: -5px;

        }
        #datee:focus{
            outline:none;

        }
        #itt{
            margin-top: 0;
        }
        #itt:focus{
            outline:none;

        }
        #isl{


        }
        #isl:focus{
            outline:none;

        }
    </style>

</head>
<body>
<nav class="navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="ecommerce.html">响指租车</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="active dropdown-toggle" data-toggle="dropdown">
                        按品牌分类
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="category.html">柯尼塞格</a></li>
                        <li><a href="category.html">迈巴赫</a></li>
                        <li><a href="category.html">宾利</a></li>
                        <li><a href="category.html">保时捷</a></li>
                        <li><a href="category.html">阿斯顿马丁</a></li>
                        <li><a href="category.html">兰博基尼</a></li>
                        <li><a href="category.html">帕加尼</a></li>
                        <li><a href="category.html">布加迪</a></li>
                        <li><a href="category.html">法拉利拉斐尔</a></li>
                        <li class="divider"></li>
                        <li><a href="ecommerce.html">所有品牌分类</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdowm-toggle" data-toggle="dropdown">
                        按价格分类
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="category.html">柯尼塞格</a></li>
                        <li><a href="category.html">迈巴赫</a></li>
                        <li><a href="category.html">宾利</a></li>
                        <li><a href="category.html">保时捷</a></li>
                        <li><a href="category.html">阿斯顿马丁</a></li>
                        <li><a href="category.html">兰博基尼</a></li>
                        <li><a href="category.html">帕加尼</a></li>
                        <li><a href="category.html">布加迪</a></li>
                        <li><a href="category.html">法拉利拉斐尔</a></li>
                        <li class="divider"></li>
                        <li><a href="ecommerce.html">所有品牌分类</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">按级别分类
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="category.html">柯尼塞格</a></li>
                        <li><a href="category.html">迈巴赫</a></li>
                        <li><a href="category.html">宾利</a></li>
                        <li><a href="category.html">保时捷</a></li>
                        <li><a href="category.html">阿斯顿马丁</a></li>
                        <li><a href="category.html">兰博基尼</a></li>
                        <li><a href="category.html">帕加尼</a></li>
                        <li><a href="category.html">布加迪</a></li>
                        <li><a href="category.html">法拉利拉斐尔</a></li>
                        <li class="divider"></li>
                        <li><a href="ecommerce.html">所有品牌分类</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="输入关键字，例如：奥迪">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#" data-toggle="modal" id="btn2">注册</a>
                </li>
                <li>
                    <a href="#" data-toggle="modal" data-target="#myModal">登录</a>
                </li>
                <li>
                    <a href="account.html">
                        <i class="glyphicon glyphicon-user"></i>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="modal fade" id="show2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times</span>
                    <span class="sr-only">关闭</span>
                </button>
                <h3 class="modal-title" >注册</h3>
            </div>
            <div class="modal-body">
                <form role="form">
                    <div class="form-group">
                        <label>用户名</label>
                        <input type="text" class="form-control" placeholder="输入用户名" required autofocus>
                    </div>
                    <div class="form-group">
                        <label>手机号</label>
                        <input type="text" class="form-control" placeholder="输入手机号" required>
                    </div>
                    <div class="form-group">
                        <label>身份证号</label>
                        <input type="text" class="form-control" placeholder="输入身份证号" required>
                    </div>
                    <div class="form-group">
                        <label>密码</label>
                        <input type="password" class="form-control" placeholder="设置密码" required>
                    </div>
                    <button type="reset" class="btn btn-primary" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">提交</button>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button  type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times</span>
                    <span class="sr-only">关闭</span>
                </button>
                <h2 class="modal-title" id="myModalLabel">登录</h2>
            </div>
            <div class="modal-body">
                <form class="form-signin" role="form">
                    <h3 class="form-signin-heading">账号</h3>
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="手机号" required autofocus>
                    </div>
                    <div class="form-group" >
                        <input type="password" class="form-control" placeholder="密码" required>
                    </div>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me">记住用户名
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button><br>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="col-md-2">

</div>
<div class="col-md-8">
  <div class="panel panel-default" style="margin-bottom: 0px;border-left: none;border-right: none">
    <div class="panel-body">
        <h4 style="font-size: 20px;color: #60606c;margin-left: 0px;">我的信息</h4>
    </div>
  </div>
  <div class="panel panel-default" style="margin-top: 0px;margin-bottom: 0px;border-left: none;border-right: none">
    <div class="panel-body" style="margin-top: 0px;height: 60px">
         <label style="color: #777777;font-size: 16px;margin-left: 15px;font-weight:500;margin-top: 4px">姓名</label>
        <input type="text" id="itx" style="padding-left:15px;height: 35px;width: 320px;margin-left: 190px;border:#ddd 1px solid">
        <label style="margin-left: 160px;color: #c6c6ce;font-size: 16px;font-weight:500">真实姓名，方便租车时核对身份</label>
    </div>
  </div>
    <div class="panel panel-default" style="margin-top: 0px;border-left: none;border-right: none;margin-bottom: 0px">
        <div class="panel-body" style="margin-top: 0px;">
            <label style="color: #777777;font-size: 16px;margin-left: 15px;font-weight:500;margin-top: 4px">证件</label>
            <select style="margin-left: 190px;padding-left:11px;height: 35px;width: 320px;border:#ddd 1px solid;color: #93939e;font-size: 14px" id="isl">
                <option>请选择证件类型</option>
                <option>身份证</option>
                <option>台湾居民来往大陆通行证</option>
                <option>港澳居民来往大陆通行证</option>
                <option>外籍护照</option>
            </select>
            <label style="margin-left: 160px;margin-top:5px;color:#c6c6ce;font-size: 16px;font-weight:500">有效证件，方便租车时核对身份</label>
            <input type="text" id="itt" placeholder="输入证件号码"  style="height: 35px;padding-left:15px;width: 320px;margin-left: 241px;border:#ddd 1px solid">

        </div>
    </div>
    <div class="panel panel-default" style="margin-top: 0px;border-left: none;border-right: none">
        <div class="panel-body" style="margin-top: 0px;">
         <label style="color: #777777;font-size: 16px;margin-left: 15px;font-weight:500;margin-top: 4px">有效期</label>
         <input  id="datee" type="text" placeholder="请选择有效期" style="color: #93939e;padding-left:15px;margin-left: 175px;height:35px;border:#ddd 1px solid;width: 320px;">
        </div>
    </div>
</div>
<div class="col-md-2">

</div>
<script>
</script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script>
    $(function(){
        $("#btn2").click(function(){
            $("#show2").modal("show");
        });
    });
    $("#datee").focus(function()
        {
            this.type='date';
            this.focus();
        }
    )
</script>
</body>
</html>