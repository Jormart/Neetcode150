import java.util.*;

class Twitter {
    // Timestamp to keep track of the order of tweets
    private static int timestamp = 0;

    // User class to store user information
    private class User {
        int id;
        Set<Integer> followed;
        Tweet tweet_head;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // first follow itself
            tweet_head = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            if (id != this.id) {
                followed.remove(id);
            }
        }

        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = tweet_head;
            tweet_head = t;
        }
    }

    // Tweet class to store tweet information
    private class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timestamp++;
            next = null;
        }
    }

    // Map to store user information
    private Map<Integer, User> userMap;

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        // If user is not pnewsFeedent, create a new user
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }
    
    /*
     * Retrieve the 10 most recent tweet ids in the user's news feed. 
     * Each item in the news feed must be posted by users who the user followed 
     * or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return newsFeed;
        }
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));
        for (int user : users) {
            Tweet t = userMap.get(user).tweet_head;
            if (t != null) {
                pq.add(t);
            }
        }
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            Tweet t = pq.poll();
            newsFeed.add(t.id);
            count++;
            if (t.next != null) {
                pq.add(t.next);
            }
        }
        return newsFeed;
    }
    
    /** Follower follows a followee. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if (!userMap.containsKey(followeeId)) {
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
    public static void main(String[] args) {
        Twitter obj = new Twitter();
        obj.postTweet(1, 5);
        System.out.println(obj.getNewsFeed(1));
        obj.follow(1, 2);
        obj.postTweet(2, 6);
        System.out.println(obj.getNewsFeed(1));
        obj.unfollow(1, 2);
        System.out.println(obj.getNewsFeed(1));
    }
    
}

