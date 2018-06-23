package tinder.models;

public class Opinion {
    private int userId;
    private int likedUserId;
    private int like;

    public Opinion(){}

    public Opinion(int userId, int likedUserId, int like) {
        this.userId = userId;
        this.likedUserId = likedUserId;
        this.like = like;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLikedUserId() {
        return likedUserId;
    }

    public void setLikedUserId(int likedUserId) {
        this.likedUserId = likedUserId;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
