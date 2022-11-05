public interface Observer {
    public void follow(Observer follower);
    public void notifyObserver();
    public void updateFollower(Observer follow);
    public void receive(String str);
}
