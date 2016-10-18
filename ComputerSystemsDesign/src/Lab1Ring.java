import java.util.Arrays;

public class Lab1Ring {

    private final Topology topology;

    public Lab1Ring(Topology topology) {
        this.topology = topology;
    }

    private void checkValidData() {
        if (topology.getClusterSize() != topology.getCluster().length
                || topology.getCluster()[0].length != topology.getClusterSize()) {
            throw new IllegalArgumentException("cluster: not valid size");
        }
        if (topology.getClusterSize() != topology.getClusterConnections().length
                || topology.getClusterConnections()[0].length != topology.getClusterSize()) {
            throw new IllegalArgumentException("clusterConnections: not valid size");
        }
        // check cluster
        for (int i = 0; i < topology.getClusterSize(); i++) {
            for (int j = 0; j < topology.getClusterSize(); j++) {
                if (topology.getCluster()[i][j] != topology.getCluster()[j][i]) {
                    throw new IllegalArgumentException("cluster [" + i + ", " + j + "] not valid");
                }
            }
        }
    }

    public int[][] generateTopology(int clustersCount) {
        checkValidData();

        int N = topology.getClusterSize();
        int total = clustersCount * N;

        int[][] reverseClusterConnections = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                reverseClusterConnections[i][j] = topology.getClusterConnections()[j][i];
            }
        }

        int[][] top = new int[total][total];
        for (int i = 0; i < total; i++) {
            Arrays.fill(top[i], 0);
        }

        // fill diagonal
        for (int i = 0; i < clustersCount; i++) {
            copyArray(topology.getCluster(), top, i * N, i * N);
        }

        // fill top diagonal
        for (int i = 0; i < clustersCount - 1; i++) {
            copyArray(topology.getClusterConnections(), top, i * N, (i + 1) * N);
        }

        // fill bottom diagonal
        for (int i = 0; i < clustersCount - 1; i++) {
            copyArray(reverseClusterConnections, top, (i + 1) * N, i * N);
        }

        // make circle
        if (clustersCount > 2) {
            copyArray(reverseClusterConnections, top, 0, N * (clustersCount - 1));

            copyArray(topology.getClusterConnections(), top, N * (clustersCount - 1), 0);
        }

        return top;
    }

    private void copyArray(int[][] src, int dst[][], int dstI, int dstJ) {
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src[i].length; j++) {
                dst[dstI + i][dstJ + j] = src[i][j];
            }
        }
    }

}
