package design.design_twitter_355;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        List<Integer> news1 = twitter.getNewsFeed(1);
        twitter.follow(1,2);
        twitter.postTweet(2,6);
        List<Integer> news2 = twitter.getNewsFeed(1);
        twitter.unfollow(1,2);
        List<Integer> news3 = twitter.getNewsFeed(1);
        System.out.print(news1);
        System.out.print(news2);
        System.out.print(news3);
    }
}


//["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]
//        [[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]
//["Twitter","postTweet","unfollow","getNewsFeed"]
//        [[],[1,5],[1,1],[1]]