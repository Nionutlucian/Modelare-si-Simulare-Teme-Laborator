//package classes;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PetriNetworkSimulation {
//    public static ArrayList<Arc> arcList = new ArrayList<>();
//    public static ArrayList<Transition> transitionList = new ArrayList<>();
//    public static void create(int locationTag,int jetoane,int capacitate,boolean directie,int transitionTag){
//        Location location =  new Location(locationTag,jetoane);
//        Arc arc = new Arc(capacitate,directie,location);
//        arcList.add(arc);
//        Transition transition = new Transition(transitionTag,arcList);
//        transitionList.add(transition);
//    }
//    public static void main(String args[]){
//       create(1,4,2,true,1);
//       create(3,0,3,false,1);
//       PetriNetwork petriNetwork = new PetriNetwork(transitionList);
//       petriNetwork.exec(1);
//       for(Transition transition : transitionList){
//           System.out.println(transition.tag);
//           for(Arc arc : arcList){
//               System.out.println(arc.capacitate);
//               System.out.println(arc.directie);
//               System.out.println(arc.location.tag);
//               System.out.println(arc.location.jetoane);
//           }
//       }
//    }
//}
