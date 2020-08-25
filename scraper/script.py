from newsapi import NewsApiClient

# Init
newsapi = NewsApiClient(api_key='8bffb1c08ad0417684c8be82224a46a2')

# /v2/top-headlines
top_headlines = newsapi.get_top_headlines(q='bitcoin',
                                          category='business',
                                          language='en',
                                          country='us')
print(top_headlines)