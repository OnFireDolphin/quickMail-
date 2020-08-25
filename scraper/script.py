from newsapi import NewsApiClient

# Init
newsapi = NewsApiClient(api_key='Your Key')

# /v2/top-headlines
top_headlines = newsapi.get_top_headlines(q='bitcoin',
                                          sources='bbc-news,the-verge',
                                          language='en',
                                          )

print(top_headlines)
