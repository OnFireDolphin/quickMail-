from newsapi import NewsApiClient

class Script:
    # Init
    def __init__(self):
        self.newsapi = NewsApiClient(api_key='8bffb1c08ad0417684c8be82224a46a2')

    # /v2/top-headlines
    def getTopHeadlines(self):
        top_headlines = self.newsapi.get_top_headlines(q='bitcoin',
                                                category='business',
                                                language='en',
                                                country='us')
        print(top_headlines)

