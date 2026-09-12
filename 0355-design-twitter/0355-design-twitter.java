class Twitter {

    private static class Tweet{
        int tweetId;
        int time;

        Tweet(int tweetId, int time){
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private int timestamp;
    private Map<Integer, List<Tweet>> tweets;
    private Map<Integer, Set<Integer>> following;

    public Twitter() {
        timestamp = 0;
        tweets = new HashMap<>();
        following = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b.time, a.time));

        if(tweets.containsKey(userId)){
            for(Tweet tweet : tweets.get(userId)){
                maxHeap.offer(tweet);
            }
        }

        if(following.containsKey(userId)){
            for(int followeeId : following.get(userId)){

                if(tweets.containsKey(followeeId)){
                    for(Tweet tweet : tweets.get(followeeId)){
                        maxHeap.offer(tweet);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while(!maxHeap.isEmpty() && result.size() < 10){
            result.add(maxHeap.poll().tweetId);
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }

        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!following.containsKey(followerId)) {
            return;
        }

        following.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */