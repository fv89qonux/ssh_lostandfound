<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>招领列表</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<%@include file="../common/base-css-js.jsp"%>
	<script src="${path}/static/admin/js/user-things.js" type="text/javascript"></script>
    <style type="text/css">
    html, body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
    </style>
</head>
<body>
    <h1>招领列表信息</h1> 
    <div style="width:100%;">
        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
            <table style="width:100%;">
                <tr>
                    <td style="width:100%;">
                     	<c:if test="${admin.state == 3}">
                        	<a class="mini-button" iconCls="icon-remove" onclick="remove();">删除</a>
                        </c:if>
                        <a class="mini-button" iconCls="icon-download" onclick="exportExcel();" style="margin-left:45px;">导出Excel</a>       
                    </td>
                    <td style="white-space:nowrap;">
                        <input id="key" class="mini-textbox" emptyText="请输入物品名称/账号" style="width:150px;" onenter="onKeyEnter"/>   
                        <a class="mini-button" iconCls="icon-search" plain="true" onclick="search()">查询</a>
                    </td>
            	    </tr>	
            </table>           
        </div>
    </div>
   <!--撑满页面-->
   <div class="mini-fit" >
    <div id="datagrid1" class="mini-datagrid" style="width:100%;height:100%;" allowResize="true"
        url="${path}/admin/find-list.html" idField="id" multiSelect="true" >
        <div property="columns">
            <div type="indexcolumn"></div>
            <div type="checkcolumn" width="20"></div>
            <div field="userName" width="45" headerAlign="center" align="center">账号</div>
            <div field="thingsType" width="40" headerAlign="center" align="center" renderer="onThingsTypeRenderer">物品类型</div>       
            <div field="thingsName" width="80" headerAlign="center" align="center" allowSort="true">物品名称</div>    
            <div field="pickPlace" width="80" headerAlign="center" align="center" allowSort="true">捡到地点</div>    
            <div field="pickTime" width="50" headerAlign="center" align="center" dateFormat="yyyy-MM-dd" allowSort="true">捡到时间</div>    
            <div field="thingsDes" width="100" headerAlign="center">物品描述</div>
            <div field="storagePlace" width="100" headerAlign="center" >存储地点</div>
            <div field="publishTime" width="80" headerAlign="center" align="center" dateFormat="yyyy-MM-dd HH:mm:ss" allowSort="true">发布时间</div>
            <div field="status" width="30" headerAlign="center" align="center" renderer="onStatusRenderer">状态</div>
        </div>
    </div>
    </div>
    
    <iframe id="exportIFrame" style="display:none;"></iframe>
    
    <!--导出Excel相关HTML-->
     <form id="excelForm"  action="${path}/admin/find-toExcel.html" method="post" target="excelIFrame">
        <input type="hidden" name="columns" id="excelData" />
    </form>
    <iframe id="excelIFrame" name="excelIFrame" style="display:none;"></iframe>
    

    <script type="text/javascript">
        mini.parse();

        var grid = mini.get("datagrid1");
        grid.load();
        grid.sortBy("id", "asc");
        
        grid.on("rowdblclick", function(e) {
        	var record = e.record,
 	        column = e.column,
 	        field = e.field,
 	        value = e.value;
        	
        	var url = "${path}/admin/find-view.html";
        	var title = "查看招领信息";
        	showView(url, title, record.id);
        });
        
        // 删除
        function remove() {
            
            var rows = grid.getSelecteds();
            if (rows.length > 0) {
            	mini.confirm("确定删除选中的"+rows.length+"条记录？", "消息", function(action) {
                if (action == "ok") {
                    var ids = [];
                    for (var i = 0, l = rows.length; i < l; i++) {
                        var r = rows[i];
                        ids.push(r.id);
                    }
                    var id = ids.join(',');
                    grid.loading("操作中，请稍后......");
                    $.ajax({
                        url: "${path}/admin/remove-/find/.html",
                        type: 'post',
                        data: {ids : id},
                        success: function (text) {
                        	grid.unmask();
                        	var o = mini.decode(text);
                        	mini.alert(o.mesg, "消息", function(e) {
                        		grid.reload();
                        	});
                        },
                        error: function () {
                        	grid.unmask();
                        	mini.alert("删除失败!", "消息", function(e) {
                        		grid.reload();
                        	});
                        }
                    });
                }
               });
            } else {
                mini.alert("请选中一条记录", "消息");
            }
        }
        
        // 查询
        function search() {
            var key = mini.get("key").getValue();
            grid.load({ key: key });
        }
        
        // Enter键查询
        function onKeyEnter(e) {
            search();
        }
        
        function onStatusRenderer(e) {
            if (e.value == 0) 
            	return "已发布";
            else if(e.value == 1)
            	return "成功贴";
            else 
            	return "已删除";
        }

    </script>
    
</body>
</html>