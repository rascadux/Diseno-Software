package e3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class NetworkTab implements NetworkManager{

    List matrix[][];
    int tamañoUser = 100;

    public NetworkTab(){
        this.matrix =  new List[this.tamañoUser][2];

    }
    @Override
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        int i;
        for (i = 0; i < this.matrix.length; i++){
            if (this.matrix[i][0] == null){
                this.matrix[i][0] = new ArrayList();
                this.matrix[i][1] = new ArrayList();
                this.matrix[i][0].add(user);
                this.matrix[i][1].add(topicsOfInterest);
                break;
            }
        }
    }

    @Override
    public void removeUser(String user) {
        List newMatrix [][] = new List[this.matrix.length - 1][2];
        //int rem = this.matrix.length - (user + 1);
        for (int i = 0; i < this.matrix.length; i++){
            if (this.matrix[i][0] != null){
                if (this.matrix[i][0].equals(user)){
                    for (int index = 0; i > index; index++){
                        newMatrix[i][0] = this.matrix[i][0];
                        newMatrix[i][1] = this.matrix[i][1];
                    }
                    for (int j = i; j < this.matrix.length - 1;j++ ){
                        newMatrix[j][0] = this.matrix[j + 1][0];
                        newMatrix[j][1] = this.matrix[j + 1][1];
                    }
                    break;
                }

            }
        }
        this.matrix = newMatrix;
    }

    @Override
    public List<String> getUsers() {
        List<String> listUser = new ArrayList<>();
        for (int i = 0; i < this.matrix.length; i++){
            if (this.matrix[i][0] != null){
                listUser.add(this.matrix[i][0].toString());
            }
        }
        return listUser;
    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        for (int i = 0; i < this.matrix.length; i++){
            if (this.matrix[i][0].get(i).equals(user)){
                this.matrix[i][1].add(topicOfInterest);
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(matrix);
    }

    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        for (int i = 0; i < this.matrix.length; i++){
            if (this.matrix[i][0].get(i).equals(user)){
                this.matrix[i][1].remove(topicOfInterest);
            }
        }

    }

    @Override
    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> newList = new ArrayList<>();
        for (int i = 0; i < this.matrix.length; i++){

        return newList;
        }
        return newList;
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String user) {
        return null;
    }
}
