<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
	<div region="center" style="padding: 0px; border: 0px">
		<t:datagrid name="wpNewsList" filterBtn="true" pagination="true" fitColumns="true" actionUrl="postsController.do?newsDatagrid" idField="id" fit="true" queryMode="group" pageSize="20">
			<t:dgCol title="common.code" field="id" hidden="true" queryMode="single" />
			<t:dgCol title="common.title" field="postTitle" queryMode="single" />
			<t:dgCol title="common.author" field="postAuthor" queryMode="single" />
			<t:dgCol title="common.categories" field="categories" queryMode="single" />
			<t:dgCol title="common.tag" field="postTags" queryMode="single" />
			<t:dgCol title="common.comment.count" field="commentCount" />
			<t:dgCol title="common.updateDate" field="postModified" />
		</t:datagrid>
	</div>
</div>