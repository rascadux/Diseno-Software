package e3;

import java.util.*;

public class Network implements NetworkManager {
    NetworkManager networkManager ;

    public Network(NetworkManager o){
        this.networkManager =  o;
    }

    @Override
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        networkManager.addUser(user, topicsOfInterest);
    }

    @Override
    public List<String> getUsers() {
        return this.networkManager.getUsers();
    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        this.networkManager.addInterest(user, topicOfInterest);
    }

    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        this.networkManager.removeInterest(user, topicOfInterest);
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        return this.networkManager.getInterests();
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String user) {
        return this.networkManager.getInterestsUser(user);
    }


    public void removeUser(String user){
        this.networkManager.removeUser(user);
    }


}
