package unionfind;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class QuickFindUF {

    private int[] id;

    QuickFindUF(int N){
        id = new int[N];
        for(int i=0; i < N; i++){
            id[i] = i;
        }
    }

    /* are p and q in the same component*/
    boolean connected(int p, int q){
        return id[p] == id[q];
    }

    /*add connection between p and q*/
    void union(int p, int q){ //  p: 5, q: 6
        int pid = id[p]; //id[p]: 11
        int qid = id[q]; //id[q]: 8

        for(int i=0; i < id.length; i++){
            if(id[i] == pid){ //id[i]: 11     pid: 11
                id[i] = qid;
                System.out.println(Arrays.toString(id));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        QuickFindUF uf = new QuickFindUF(N);

        while(sc.hasNext()){
            int p = sc.nextInt();
            int q = sc.nextInt();
            if(!uf.connected(p,q)){
                uf.union(p,q);
                System.out.println(p + " " + q);
            }
        }
    }

}

