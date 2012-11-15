<%@ page import="idrabenia.domain.RssItem" contentType="text/html;charset=UTF-8" %>
<%--
    Template for render list of RSS items stored in database
--%>

<table class="rssItemsTable">
  <g:each status="index" var="it" in="${RssItem.list(sort: 'creationDate', order: 'desc')}">
    <tr>
      <td>${index + 1}.</td>
      <td>
        <a href="${it.link}">${it.title.encodeAsHTML()}</a>
      </td>
      <td>
        <g:formatDate date="${it.creationDate}" format="dd-MM-yyyy"/>
      </td>
      <td>
        <input class="removeItemButton" type="button" value="${g.message(code: 'newsList.removeFeedButton.label')}"
               data-itemGuid="${it.guid}" />
      </td>
    </tr>
  </g:each>
</table>