package e3;

import org.junit.jupiter.api.Test;

import java.util.*;

import static e3.TopicOfInterest.MODA;
import static org.junit.jupiter.api.Assertions.*;

public class NetworkTest {
    NetworkMap networkMap = new NetworkMap();
    NetworkTab networkTab = new NetworkTab();
    Network net1 = new Network(networkMap) ;

    NetworkMap networkMap2 =new NetworkMap();


    Network net2 = new Network(networkMap2);

    Network net3 = new Network(networkTab);


    @Test
    void getInterests(){

        
        net1.addUser("Xaquin", Collections.singletonList(TopicOfInterest.FUTBOL));
        net1.addUser("Juan", Collections.singletonList(MODA));
        net1.addUser("Martín", Collections.singletonList(TopicOfInterest.FAMOSOS));
        List<TopicOfInterest> lista = Arrays.asList(TopicOfInterest.FUTBOL, TopicOfInterest.FAMOSOS);
        net1.addInterest("Xaquin", TopicOfInterest.FAMOSOS);
        assertEquals(lista, net1.getInterestsUser("Xaquin"));
        lista = Arrays.asList();
        net1.removeInterest("Juan", TopicOfInterest.MODA);
        assertEquals(lista, net1.getInterestsUser("Juan"));//no hacemos toString pq es nulo

        List<TopicOfInterest> listTopic = Arrays.asList(TopicOfInterest.FAMOSOS, TopicOfInterest.FUTBOL);
        net1.addInterest("Martín", TopicOfInterest.FUTBOL);//probamos a repetir topicos
        net1.addInterest("Martín", TopicOfInterest.FAMOSOS);
        net1.addInterest("Martín", TopicOfInterest.FUTBOL);
        assertEquals(listTopic, net1.getInterestsUser("Martín"));
        listTopic = Arrays.asList(TopicOfInterest.FAMOSOS);
        net1.removeInterest("Martín", TopicOfInterest.FUTBOL);
        assertEquals(listTopic, net1.getInterestsUser("Martín"));

        listTopic = Arrays.asList();
        net1.addUser("Sergio", null);//hay que comprobar si un usuario puede estar sin intereses en la red
        net1.addUser("Sergio", Collections.singletonList(TopicOfInterest.FUTBOL));//si existe el usuario, no crea ninguno nuevo ni actualiza.
        assertEquals(listTopic, net1.getInterestsUser("Sergio"));

        net1.addInterest("Xaquin", TopicOfInterest.HISTORIA);
        listTopic = Arrays.asList(TopicOfInterest.FUTBOL, TopicOfInterest.FAMOSOS, TopicOfInterest.HISTORIA);
        assertEquals(listTopic, net1.getInterests());

    }

    @Test
    void Users(){
        List<String> user = Arrays.asList("Alberto");
        net2.addUser("Alberto", null);
        assertEquals(user, net2.getUsers());
        user = Arrays.asList();
        net2.removeUser("Alberto");
        assertEquals(user, net2.getUsers());
        List<String> userList = Arrays.asList("Biden", "Ramon", "Messi", "Kim");

        net2.addUser("Biden", Collections.singletonList(TopicOfInterest.POLITICA));
        net2.addUser("Kim", Collections.singletonList(TopicOfInterest.REDES));
        net2.addUser("Messi", Collections.singletonList(TopicOfInterest.FUTBOL));
        net2.addUser("Ramon", null);
        assertEquals(userList, net2.getUsers());

        net2.removeUser("Kim");
        net2.removeUser("Messi");
        userList = Arrays.asList("Biden", "Ramon");
        assertEquals(userList, net2.getUsers());

        net3.addUser("Juan", Collections.singletonList(TopicOfInterest.FUTBOL));
        net3.addUser("Cristiano", Collections.singletonList(TopicOfInterest.REDES));
        net3.addUser("Rober", Collections.singletonList(TopicOfInterest.MODA));

        //net3.removeUser("Rober");

        //List<String> usersExpected = Arrays.asList("Juan", "Cristiano");

        //assertEquals(usersExpected, net3.getUsers());



    }


}
