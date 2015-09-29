<%@ tag import="knowledgebase.util.TreeNode" %>
<%@ tag import="knowledgebase.domain.Catalog" %>

<%@ attribute name="tree" type="knowledgebase.util.TreeNode<knowledgebase.domain.Catalog>" required="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<% if (tree.getData().getIsArticle() == 0) { %>
<div class="menu__folder">
    <div class="menu__icon menu__icon-folder"></div>
    <div class="menu__title" data-id="<%= tree.getData().getId() %>">
        ${tree.data.title}
        <%--<img src=\"/resources/image/foldericon.png\" class=\"menu__icon\"> &nbsp;" + currentCatalog.getTitle() +--%>
    </div>
    <div class="menu__content">
        <% for (TreeNode<Catalog> childTree: tree.getChildren()) { %>
            <myTags:catalogTreeNode tree="<%= childTree %>"/>
        <% } %>
    </div>
</div>
<% } else { %>
<div class="menu__article">
    <div class="menu__icon menu__icon-article"></div>
    <div class="menu__title" data-id="<%= tree.getData().getId() %>">
        ${tree.data.title}
    </div>
</div>
<% } %>