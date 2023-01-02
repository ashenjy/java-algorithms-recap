package unionfind;
/**
 * Coursera - Algorithms Part I
 * Week 1 - Interview Questions - Union Find
 *
 * Question 1: Social network connectivity
 *
 * Given a social network containing N members and a log file containing M
 * timestamps at which times pairs of members formed friendships, design an
 * algorithm to determine the earliest time at which all members are connected
 * (i.e., every member is a friend of a friend of a friend ... of a friend).
 * Assume that the log file is sorted by timestamp and that friendship is an
 * equivalence relation. The running time of your algorithm should be MlogN or
 * better and use extra space proportional to N.
 */

/**
 * Solution:
 *
 * Use a union-find data structure with each site representing a social network
 * member. Add unions between sites in time order of friendships being formed.
 * After each union is added, check the number of connected components
 * within the union-find data structure. If only one, all members are connected.
 *
 * Must keep track of number of unique components. Decreases when a union occurs
 * between different components.
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Determine when all members of a social network are connected.
 */
public class SocialNetworkConnectivity {
                      //   i  0,1,2,3,4,5,6,7,8,9
    private int[] id; // id: [0,1,2,3,4,5,6,7,8,9]
    private int numOfComponents;
    int totalMembers;

    SocialNetworkConnectivity(int N){
        id = new int[N];
        numOfComponents = N;
        totalMembers = N;
        for(int i=0; i < N; i++){
            id[i] = i;
        }
    }

    private boolean isFriends(int m1, int m2){
        return id[m1] == id[m2];
    }

    private int numOfFriendships(){
        return totalMembers - numOfComponents;
    }

    private boolean fullyConnected(){
        return this.numOfComponents == 1;
    }

    private void addFriendship(int p, int q){ //p: 5  , q: 6
        if(isFriends(p,q)){
            return;
        }

        int pid = id[p]; //pid: 4
        int qid = id[q]; //qid: 5

        for(int i=0; i<id.length; i++){
            if(pid == id[i]){
                id[i] = qid;
            }
        }
        numOfComponents--;
        System.out.println(Arrays.toString(id));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int members = sc.nextInt();
        SocialNetworkConnectivity snc = new SocialNetworkConnectivity(members);

        while(sc.hasNext()){
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();
            if(!snc.isFriends(m1,m2)){
                snc.addFriendship(m1,m2);
                System.out.println(m1 + " " + m2);
                System.out.println(snc.numOfFriendships() + " Friendships");
                System.out.println( "Fully Connected :" + snc.fullyConnected());
            }
        }
    }


}
