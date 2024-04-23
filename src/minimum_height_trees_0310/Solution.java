// https://leetcode.com/problems/minimum-height-trees

package minimum_height_trees_0310;

import java.util.*;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        HashMap<Integer, List<Integer>> nodeToNeighbourMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            nodeToNeighbourMap.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            nodeToNeighbourMap.get(edge[0]).add(edge[1]);
            nodeToNeighbourMap.get(edge[1]).add(edge[0]);
        }

        return findCenter(nodeToNeighbourMap, n);
    }

    List<Integer> findCenter(HashMap<Integer, List<Integer>> nodeToNeighbourMap, int n) {
        List<Integer> center = new ArrayList<>();
        Queue<Integer> leafs = new LinkedList<>();
        int[] neighboursCount = new int[n];

        for (int i = 0; i < n; i++) {
            neighboursCount[i] = nodeToNeighbourMap.get(i).size();
            if (neighboursCount[i] == 1) {
                leafs.offer(i);
            }
        }

        while (!leafs.isEmpty()) {
            center.clear();
            int leafsCount = leafs.size();
            for (int i = 0; i < leafsCount; i++) {
                int node = leafs.poll();
                center.add(node);
                for (int neighbor : nodeToNeighbourMap.get(node)) {
                    neighboursCount[neighbor]--;
                    if (neighboursCount[neighbor] == 1) {
                        leafs.offer(neighbor);
                    }
                }
            }
        }

        return center;
    }
}
