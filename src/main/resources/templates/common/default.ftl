<#-- 风格1 -->
<#macro default title="Welcome">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>保险平台后台</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <#include "style.ftl"/>
</head>
<body class="page-sidebar-closed-hide-logo page-content-white page-header-fixed">
    <#include "header.ftl"/>
<div class="clearfix"></div>

<div class="page-container">
<#--<#nested/>-->
    <#include "menu.ftl"/>
    <!-- BEGIN CONTENT BODY -->
    <div class="page-content-wrapper">
        <!-- BEGIN CONTENT BODY -->
        <div class="page-content">
            <div>
                <h1>首页</h1>

                <div>
                    欢迎访问。
                </div>
            </div>
        </div>
        <!-- BEGIN PAGE HEADER-->
    </div>
    <!-- END CONTENT BODY -->
</div>
<div class="page-footer">
    <div class="page-footer-inner"> Copyright &copy; Jack 2016
    </div>
    <div class="scroll-to-top">
        <i class="icon-arrow-up"></i>
    </div>
</div>
<!-- 公用弹出警告窗口 -->
<div class="modal" id="alertModal" tabindex="-1" aria-hidden="true" style="z-index: 99999; padding-top: 10%">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="text-align: center">
                <div class="note note-info">
                    <h4 class="alert-heading"><i class="fa fa-envelope"></i> 消息</h4>
                    <div class="row">
                    </div>
                    <a class="btn blue btn-sm" style="margin-top: 10px" data-dismiss="modal">确定</a>
                </div>
            </div>
        </div>
    </div>
</div>

<#--超链接跳转提示窗口-->
<div class="modal" id="hrefJumpConfirm" tabindex="-1" aria-hidden="true" style="padding-top: 10%">
    <div class="modal-dialog">
        <div class="modal-body" style="text-align: center">
            <div class="note note-success">
                <h4 class="alert-heading"><i class="fa fa-exclamation"></i>跳转提示</h4>
                <p>当前编辑内容未保存，是否放弃当前内容</p>
                <a class="btn default btn-sm" style="margin-top: 10px" data-dismiss="modal">取消</a>
                <a class="btn blue btn-sm btn-confirm" style="margin-top: 10px" data-dismiss="modal">确定</a>
                <input type="hidden" id="riskApplyId"/>
            </div>
        </div>
    </div>
</div>
    <#include "script.ftl"/>
</body>
</html>
</#macro>