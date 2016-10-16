
public class Topology3 implements Topology {

    public final int[][] cluster = {
         //  1  2  3
    /* 1 */ {0, 1, 1}, // 1
    /* 2 */ {1, 0, 0}, // 2
    /* 3 */ {1, 0, 0}, // 3
            //  1  2  3
    };

    public final int[][] clusterConnections = {
         //  1  2  3
    /* 1 */ {1, 0, 1}, // 1
    /* 2 */ {0, 0, 1}, // 2
    /* 3 */ {0, 1, 0}, // 3
         //  1  2  3
    };

    private final int N = 3;

    @Override
    public int[][] getCluster() {
        return cluster;
    }

    @Override
    public int[][] getClusterConnections() {
        return clusterConnections;
    }

    @Override
    public int getClusterSize() {
        return N;
    }
}
