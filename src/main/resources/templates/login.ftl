<!DOCTYPE html>
<html lang="zh-CN" xmlns="http://www.w3.org/1999/html">
<!-- BEGIN HEAD -->

<head>
    <meta charset="utf-8"/>
    <title>欢迎登陆</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="login/css/plugins.min.css" rel="stylesheet" type="text/css"/>
    <link href="login/css/login-5.min.css" rel="stylesheet" type="text/css"/>
<#include "common/style.ftl"/>
    <!-- END HEAD -->

<body class=" login">
<!-- BEGIN : LOGIN PAGE 5-1 -->
<div class="user-login-5">
    <div class="row bs-reset">
        <div class="col-md-6 bs-reset">
            <div class="login-bg" style="background-image:url(login/img/login/bg1.jpg)">
                <img class="login-logo" src="login/img/login/logo.png"/></div>
        </div>
        <div class="col-md-6 login-container bs-reset">
            <div class="login-content">
                <h1>欢迎登录</h1>
                <p> 请输入用户名密码登录：</p>
                <form th:action="@{/login}" class="login-form" method="post">
                    <div class="alert alert-danger display-hide">
                        <button class="close" data-close="alert"></button>
                        <span>请输入用户名或密码后登录</span>
                    </div>
                    <div class="row">
                        <div class="col-xs-6">
                            <input class="form-control form-group" type="text"
                                   autocomplete="off" placeholder="请输入用户名" name="username"
                                   value=<#if userNameCookie?exists>${userNameCookie}</#if> required>

                            </input>
                        </div>
                        <div class="col-xs-6">
                            <input class="form-control form-group" type="password"
                                   autocomplete="off" placeholder="请输入密码" name="password" required/></div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="rem-password">
                                <label class="rememberme mt-checkbox mt-checkbox-outline">
                                    <input type="checkbox" name="remember" value="1"/> 记住用户
                                    <span></span>
                                </label>
                            </div>
                        </div>
                        <div class="col-sm-8 text-right">
                        <#--<div class="forgot-password">-->
                        <#--<a href="javascript:;" id="forget-password" class="forget-password">找回密码?</a>-->
                        <#--</div>-->
                            <button class="btn green" type="submit">登录</button>
                        </div>
                    </div>
                </form>
                <!-- BEGIN FORGOT PASSWORD FORM -->
            <#--<form class="forget-form" action="javascript:;" method="post">-->
            <#--<h3 class="font-green">Forgot Password ?</h3>-->
            <#--<p> Enter your e-mail address below to reset your password. </p>-->
            <#--<div class="form-group">-->
            <#--<input class="form-control placeholder-no-fix form-group" type="text" autocomplete="off"-->
            <#--placeholder="Email" name="email"/></div>-->
            <#--<div class="form-actions">-->
            <#--<button type="button" id="back-btn" class="btn green btn-outline">Back</button>-->
            <#--<button type="submit" class="btn btn-success uppercase pull-right">Submit</button>-->
            <#--</div>-->
            <#--</form>-->
                <!-- END FORGOT PASSWORD FORM -->
            </div>
            <div class="login-footer">
            <#--<div class="row bs-reset">-->
            <#--<div class="col-xs-5 bs-reset">-->
            <#--<ul class="login-social">-->
            <#--<li>-->
            <#--<a href="javascript:;">-->
            <#--<i class="icon-social-facebook"></i>-->
            <#--</a>-->
            <#--</li>-->
            <#--<li>-->
            <#--<a href="javascript:;">-->
            <#--<i class="icon-social-twitter"></i>-->
            <#--</a>-->
            <#--</li>-->
            <#--<li>-->
            <#--<a href="javascript:;">-->
            <#--<i class="icon-social-dribbble"></i>-->
            <#--</a>-->
            <#--</li>-->
            <#--</ul>-->
            <#--</div>-->
                <div class="col-xs-12 bs-reset">
                    <div class="login-copyright text-right">
                        <p>Copyright &copy; Jack 2016</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<#include "common/script.ftl"/>
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="login/script/jquery.validate.min.js" type="text/javascript"></script>
<script src="login/script/jquery.backstretch.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="login/script/login-5.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<#--<script type="text/javascript">-->
<#--function toIndex() {-->
<#--$("#params").validate({-->
<#--submitHandler:function(form){-->
<#--alert("submit!");-->
<#--form.submit();-->
<#--}-->
<#--});-->
<#--//        document.getElementById('params').submit();-->
<#--}-->
<#--</script>-->
</body>

</html>