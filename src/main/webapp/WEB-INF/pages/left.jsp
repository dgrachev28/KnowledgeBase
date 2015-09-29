<%@ page import="knowledgebase.util.TreeNode" %>
<%@ page import="knowledgebase.domain.Catalog" %>
<%@ page import="java.util.List" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/resources/scripts/left.js" ></script>
<script type="text/javascript" src="/resources/scripts/left-context-menu.js" ></script>


<div class="left">
    <div class="menu">
        <%
            List<TreeNode<Catalog>> treeList= (List<TreeNode<Catalog>>) request.getAttribute("treeList");
            for (TreeNode<Catalog> catalogTreeNode: treeList) {
        %>
            <myTags:catalogTreeNode tree="<%= catalogTreeNode %>"/>
        <% } %>
    </div>
</div>
