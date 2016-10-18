
public class Main {

    public static void main(String... args) {

//        Topology topology = new Topology3();
        Topology topology = new Topology7();
//        int clusterCount = 3;
        Lab1Ring lab1 = new Lab1Ring(topology);

        System.out.println("Cluster:");
        printMatrix(topology.getCluster());


        for (int i = 0; i < 8; i++) {
            int clusterCount = 1 << i;
            int[][] top = lab1.generateTopology(clusterCount);
//        System.out.println("Topology:");
//        printMatrix(top);
            System.out.println("===================================================");
            System.out.println("i : " + (i + 1));
            System.out.println("Clusters count : " + clusterCount);
            System.out.println("Processors count : " + clusterCount * topology.getClusterSize());
            TopologyAnalyzer topologyAnalyzer = new TopologyAnalyzer(top.length, top);
            System.out.println("Ступінь топології : " + topologyAnalyzer.getTopologyDegree());
            System.out.println("Діаметр топології : " + topologyAnalyzer.getDiameter());
            System.out.println("Середній діаметр топології : " + topologyAnalyzer.getAvgDiameter());
            System.out.println("Вартість : " + topologyAnalyzer.getCost());
            System.out.println("Навантаження на вершину : " + topologyAnalyzer.getTopologyTraffic());
        }
    }

    public static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[1].length; j++) {
                if (j != m[1].length - 1) {
                    System.out.print(String.format("% 2d", m[i][j]));
                } else {
                    System.out.println(String.format("% 2d", m[i][j]));
                }
            }
        }
    }
}
