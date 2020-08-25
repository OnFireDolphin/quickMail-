from script import Script
from news_getter import NewsGetter

def main():
    news_getter = NewsGetter()
    news = news_getter.get_url_to_topics()
    print(news)

main()