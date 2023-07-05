<#include "include/macros.ftl">
<@compress single_line=false>
<@header title="关于 | ${config.siteName}" description="关于${config.siteName}" canonical="/about"></@header>

<div class="container custome-container">
    <nav class="breadcrumb">
        <a class="crumbs" title="返回首页" href="${config.siteUrl}" data-toggle="tooltip" data-placement="bottom"><i class="fa fa-home"></i>首页</a>
        <i class="fa fa-angle-right"></i>关于
    </nav>
    <div class="row about-body">
        <@blogHeader title="关于本站"></@blogHeader>

        sdfdsfdsfdsfds
    </div>
</div>

<@footer>
    <#if (config.enableHitokoto == 1 || config.enableHitokoto == "1")>
        <script src="https://v1.hitokoto.cn/?encode=js&c=i&select=.hitokoto" defer></script>
    </#if>
</@footer>
</@compress>
