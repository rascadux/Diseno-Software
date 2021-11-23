package e3;

import java.util.*;

public class NetworkMap implements NetworkManager{
    Map<String, List<TopicOfInterest>> topicOfInterests;
    List<String> topicList;

    public NetworkMap(){
        this.topicOfInterests = new HashMap<>();
        this.topicList = new ArrayList<>();

    }

    @Override
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        if (!this.topicOfInterests.containsKey(user)){
            this.topicOfInterests.put(user, topicsOfInterest); //introduce nueva entrada en el map
        }
    }

    //update de users.
    @Override
    public void removeUser(String user) {
        if (this.topicOfInterests.containsKey(user)){
            this.topicOfInterests.remove(user);

        }else{
            throw new IllegalArgumentException(); //si no contiene la clave, lanza excepcion
        }
    }

    @Override
    public List<String> getUsers() {
        List<String> userList = new ArrayList<>();
        for (Map.Entry<String, List<TopicOfInterest>> entry : topicOfInterests.entrySet()){
            userList.add(entry.getKey());//recorremos mapa y guardamos las claves(users) en una lista de Strings definida arriba
        }
        return userList;
    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {

        if (!this.topicOfInterests.get(user).contains(topicOfInterest) ){ //hay que comprobar si un usuario puede estar sin intereses en la red
            List<TopicOfInterest> newList = new ArrayList<>();
            for (int i = 0; i < this.topicOfInterests.get(user).size(); i++){//add interest funcional
                newList.add(this.topicOfInterests.get(user).get(i));
            }
            newList.add(topicOfInterest);
            this.topicOfInterests.put(user, newList);
        }
    }



    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        List<TopicOfInterest> newList = new ArrayList<>();

        for (int i = 0; i < this.topicOfInterests.get(user).size(); i++){
            newList.add(this.topicOfInterests.get(user).get(i)); //copiamos la lista en una nueva
        }
        newList.remove(topicOfInterest);
        if (newList.size() == 0){
            this.topicOfInterests.put(user, null); // si es una lista vacía, añadimos null
        }else{
            this.topicOfInterests.put(user, newList);//si no, añadimos la lista resultante
        }

    }

    @Override
    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> InterestsList = new ArrayList<>();
        for (Map.Entry<String, List<TopicOfInterest>> entry : topicOfInterests.entrySet()){
            if(entry.getValue() == null){
                return InterestsList;
            }else return entry.getValue();
        }
        throw new IllegalArgumentException();

    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String user) {
        List<TopicOfInterest> lista = new ArrayList<>();
        for (Map.Entry<String, List<TopicOfInterest>> entry : this.topicOfInterests.entrySet()){
            if (entry.getKey().equals(user)){
                if(entry.getValue() == null){//Si no tiene interests devuelve lista vacia
                    return lista;
                }else return entry.getValue();
            }
        }
        throw new IllegalArgumentException();
    }
}
