package code17_bitmap;
import java.util.HashMap;
import java.util.HashSet;


///初始化：
/// 选择一个源节点，设为起始点。
/// 1.创建一个距离数组 dist，用来存储从源节点到各个节点的最短路径长度。初始化时，源节点的距离设为 0，其他节点的距离设为无穷大（∞）。
/// 2.创建一个优先队列（通常使用最小堆实现），用来存储待处理的节点及其当前的最短路径估计值。将源节点加入队列。
///
/// 处理节点：
/// 1.当优先队列不为空时，执行以下步骤：
/// 2.从优先队列中提取出距离最小的节点 u。
/// 3.对于每一个与节点 u 相邻的节点 v，检查从 u 到 v 的边的权重（假设为 weight(u, v)）。
/// 4.计算从源节点到节点 v 的新距离：new_dist = dist[u] + weight(u, v)。
/// 5.如果 new_dist 小于当前已知的 dist[v]，则更新 dist[v] 并将节点 v 加入优先队列。
public class Code09_Dijkstra {



    public static HashMap<BitmapNode, Integer> Dijkstra( BitmapNode from){
        HashMap<BitmapNode, Integer> distanceMap = new HashMap<>();
        distanceMap.put(from,0);
        //打过对号的点
        HashSet<BitmapNode> selectedNodes = new HashSet<>();
        //剩余未解锁的点中最小的点
        BitmapNode minNode = getMinDistanceAndUnselectedNode(distanceMap,selectedNodes);
        while (minNode != null){
            // 原始点-> minNode(跳转点) 最小的距离distance
            int distance = distanceMap.get(minNode);
            for (BitmapEdge edge : minNode.edges) {
                //跳转点
                BitmapNode toNode = edge.to;
                //跳转点到原始点的距离
                int nextDistance = distance + edge.weight;

                if (!distanceMap.containsKey(toNode)){//没有放入过
                    distanceMap.put(toNode,nextDistance);
                }else {//放入过的话就进行比较
                    distanceMap.put(toNode,Math.min(distanceMap.get(toNode),nextDistance));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap,selectedNodes);
        }
        return distanceMap;
    }

    private static BitmapNode getMinDistanceAndUnselectedNode(HashMap<BitmapNode, Integer> distanceMap, HashSet<BitmapNode> selectedNodes) {
        BitmapNode minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (BitmapNode node : distanceMap.keySet()) {
            if (!selectedNodes.contains(node) && distanceMap.get(node) < minDistance) {
                minNode = node;
                minDistance = distanceMap.get(node);
            }
        }
        return minNode;
    }


}
