<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>报销项表管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/expenseclaimdetails/">报销项表列表</a></li>
		<shiro:hasPermission name="sys:expenseclaimdetails:edit"><li><a href="${ctx}/sys/expenseclaimdetails/form">报销项表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="expenseclaimdetails" action="${ctx}/sys/expenseclaimdetails/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>更新日期</th>
				<th>备注</th>
				<shiro:hasPermission name="sys:expenseclaimdetails:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="expenseclaimdetails">
			<tr>
				<td><a href="${ctx}/sys/expenseclaimdetails/form?id=${expenseclaimdetails.id}">
					<fmt:formatDate value="${expenseclaimdetails.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${expenseclaimdetails.remarks}
				</td>
				<shiro:hasPermission name="sys:expenseclaimdetails:edit"><td>
    				<a href="${ctx}/sys/expenseclaimdetails/form?id=${expenseclaimdetails.id}">修改</a>
					<a href="${ctx}/sys/expenseclaimdetails/delete?id=${expenseclaimdetails.id}" onclick="return confirmx('确认要删除该报销项表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>