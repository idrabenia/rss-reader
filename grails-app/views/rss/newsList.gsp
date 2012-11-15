<%@ page import="idrabenia.domain.RssItem" contentType="text/html;charset=UTF-8" %>
<r:require module="newsListResources" />

<html>
  <head>
    <meta name="layout" content="main"/>
    <title>Rss Feed</title>

    <script type="text/javascript">
      window['pageConfig'] = {
          addFeedUrl: "${g.createLink(controller: 'rss', action: 'addNewsFeed')}",
          itemsListUrl: "${g.createLink(controller: 'rss', action: 'listRssItems')}",
          removeItemUrl: "${g.createLink(controller: 'rss', action: 'removeItem')}",
          logoutUrl: "${g.createLink(controller: 'logout', action: 'index')}"
      };
    </script>
  </head>
  <body>

    <!-- Feed URL input -->
    <span class="feedUrlLabel"><g:message code="newsList.feedUrlInput.label" /></span>

    <g:field name="feedUrl" type="url" pattern="https?://.+" value="" class="feedUrlInput"
             placeholder="${g.message(code: 'newsList.feedUrlInput.placeholder')}" />

    <input id="addFeedButton" type="button" value="${g.message(code: 'feedUrlInput.addButton.label')}" />
    <tmpl:feedErrorDialog />

    <!-- Logout Button -->
    <span><g:message code="newsList.buttonsSeparator.label" /></span>

    <input id="logoutButton" type="button" value="${g.message(code: 'logout.button.message')}" />

    <!-- List of news -->
    <div id="rssItemsList">
      <tmpl:itemsList />
    </div>

  </body>
</html>