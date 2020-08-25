from newsapi import NewsApiClient
from datetime import datetime

TOPICS = ['politics']
KEY =   '8bffb1c08ad0417684c8be82224a46a2' 
TOPICS= ['politics', 'sports', 'coronavirus', 'economy']
class NewsGetter:

    def __init__(self):
        self.news_api = NewsApiClient(api_key=KEY )
    
    def get_url_to_topics(self):
        response = []
        for i in range(0, len(TOPICS)):
            response.insert(i, {"topic": TOPICS[i], "articles": self.news_api.get_top_headlines(q= TOPICS[i], language='en')["articles"]})

        topics_urls =[]
        for i in range(0, len(TOPICS)):
            for j in range(0, len(response[i]["articles"])):
                topics_urls.append({"topics": TOPICS[i], "url": response[i]["articles"][j]["url"], "source": response[i]["articles"][j]["source"]["name"]})

        return topics_urls

