<div class="page-sidebar-wrapper">
    <div class="page-sidebar navbar-collapse collapse">
        <ul class="page-sidebar-menu page-header-fixed " data-keep-expanded="false" data-auto-scroll="true"
            data-slide-speed="200" style="padding-top: 20px">
            <li class="sidebar-toggler-wrapper hide">
                <div class="sidebar-toggler">
                    <span></span>
                </div>
            </li>
            <li class="heading">
                <span class="uppercase" style="font-size: 18px; font-weight: 600; color: #67809F;">菜单</span>
            </li>
        <#if authlist?substring(4,5)?contains("1")>
            <li class="nav-item">
                <a href="/" class="nav-link nav-toggle ">
                    <i class="fa fa-home"></i>
                    <span class="title">首页</span>
                    <span class="selected"></span>
                </a>
            </li>
        </#if>
            <li class="nav-item">
                <a href="javascript:;" class="nav-link nav-toggle ">
                    <i class="fa fa-star"></i>
                    <span class="title">示例页面</span>
                    <span class="selected"></span>
                    <span class="arrow"></span>
                </a>
                <ul class="sub-menu">
                <#--<li class="heading" style="font-size:14px;color:yellow"><i class=""></i>医院验收</li>-->
                    <li class="nav-item">
                        <a href="/queryInfo" class="ajaxify">
                            <span class="title">信息查询</span>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>
