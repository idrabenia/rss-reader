<%@ page contentType="text/html;charset=UTF-8" %>
<r:require module="newsListStyles" />
<html>
  <head>
      <meta name="layout" content="main"/>
      <title>Rss Feed</title>
  </head>
  <body>

    <!-- Feed URL input -->
    <span class="feedUrlLabel"><g:message code="newsList.feedUrlInput.label" /></span>

    <g:field name="feedUrl" type="url" value="" placeholder="${g.message(code: 'newsList.feedUrlInput.placeholder')}"
             class="feedUrlInput" />

    <input type="button" value="${g.message(code: 'feedUrlInput.addButton.label')}" />

    <!-- Logout Button -->
    <span><g:message code="" /><g:message code="newsList.buttonsSeparator.label" /></span>

    <input type="button" value="${g.message(code: 'logout.button.message')}" />

  </body>
</html>