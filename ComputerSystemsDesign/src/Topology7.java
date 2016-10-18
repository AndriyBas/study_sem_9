
public class Topology7 implements Topology {

    public final int[][] cluster = {
            //  1  2  3  4  5  6  7
    /* 1 */ {0, 1, 1, 0, 0, 0, 0}, // 1
    /* 2 */ {1, 0, 1, 1, 1, 0, 0}, // 2
    /* 3 */ {1, 1, 0, 0, 1, 1, 0}, // 3
    /* 4 */ {0, 1, 0, 0, 1, 0, 1}, // 4
    /* 5 */ {0, 1, 1, 1, 0, 1, 1}, // 5
    /* 6 */ {0, 0, 1, 0, 1, 0, 1}, // 6
    /* 7 */ {0, 0, 0, 1, 1, 1, 0}  // 7
            //  1  2  3  4  5  6  7
    };

    public final int[][] clusterConnections = {
            //  1  2  3  4  5  6  7
    /* 1 */ {1, 0, 0, 0, 0, 0, 0}, // 1
    /* 2 */ {0, 0, 0, 0, 0, 0, 0}, // 2
    /* 3 */ {0, 1, 0, 0, 0, 0, 0}, // 3
    /* 4 */ {0, 0, 0, 0, 0, 0, 0}, // 4
    /* 5 */ {0, 0, 0, 0, 0, 0, 0}, // 5
    /* 6 */ {0, 0, 0, 1, 0, 0, 0}, // 6
    /* 7 */ {0, 0, 0, 0, 0, 0, 1}  // 7
            //  1  2  3  4  5  6  7
    };

    private final int N = 7;


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
