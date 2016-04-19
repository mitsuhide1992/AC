package com.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ShortPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortPath solution = new ShortPath();
		
		HashMap<Integer, HashMap<Integer, Integer>> path = new HashMap<Integer, HashMap<Integer,Integer>>();
		HashMap<Integer, Integer> path0 = new HashMap<Integer,Integer>();
		path0.put(1, 1);
		path0.put(2, 5);
		
		HashMap<Integer, Integer> path1 = new HashMap<Integer,Integer>();
		path1.put(0, 1);
		path1.put(2, 3);
		path1.put(4, 5);
		path1.put(3, 7);

		HashMap<Integer, Integer> path2 = new HashMap<Integer,Integer>();
		path2.put(0, 5);
		path2.put(1, 3);
		path2.put(4, 1);
		path2.put(5, 7);

		HashMap<Integer, Integer> path3 = new HashMap<Integer,Integer>();
		path3.put(1, 7);
		path3.put(4, 2);
		path3.put(6, 3);

		HashMap<Integer, Integer> path4 = new HashMap<Integer,Integer>();
		path4.put(1, 5);
		path4.put(3, 2);
		path4.put(6, 6);
		path4.put(7, 9);
		path4.put(5, 3);
		path4.put(2, 1);

		HashMap<Integer, Integer> path5 = new HashMap<Integer,Integer>();
		path5.put(2, 7);
		path5.put(4, 3);
		path5.put(7, 5);

		HashMap<Integer, Integer> path6 = new HashMap<Integer,Integer>();
		path6.put(3, 3);
		path6.put(4, 6);
		path6.put(7, 2);
		path6.put(8, 7);

		HashMap<Integer, Integer> path7 = new HashMap<Integer,Integer>();
		path7.put(5, 5);
		path7.put(4, 9);
		path7.put(6, 2);
		path7.put(8, 4);

		HashMap<Integer, Integer> path8 = new HashMap<Integer,Integer>();
		path8.put(6, 7);
		path8.put(7, 4);
		
		path.put(0, path0);
		path.put(1, path1);
		path.put(2, path2);
		path.put(3, path3);
		path.put(4, path4);
		path.put(5, path5);
		path.put(6, path6);
		path.put(7, path7);
		path.put(8, path8);
		
		System.out.println("0 : " + solution.dijkstra(path,0));
		System.out.println("1 : " + solution.dijkstra(path,1));
		System.out.println("2 : " + solution.dijkstra(path,2));
		System.out.println("3 : " + solution.dijkstra(path,3));
		System.out.println("4 : " + solution.dijkstra(path,4));
		System.out.println("5 : " + solution.dijkstra(path,5));
		System.out.println("6 : " + solution.dijkstra(path,6));
		System.out.println("7 : " + solution.dijkstra(path,7));
		System.out.println("8 : " + solution.dijkstra(path,8));
	}
	/*
	 * path存储边信息HashMap<Integer, HashMap<Integer, Integer>>
	 * 第一个是源节点
	 * 第二个是目标节点
	 * 第三个是边长
	 */
	public int dijkstra (final HashMap<Integer, HashMap<Integer, Integer>> path, int targetNode) {
		int node = 0;
		int pathMin = 0;
		//minPath：已经找到的从0 开始的最短路径
		HashMap<Integer, Integer> minPaths = new HashMap<Integer,Integer>();
		//finded：已经找到最短路径的点
		HashSet<Integer> finded = new HashSet<Integer>();
		
		minPaths.put(0, 0);
		
		boolean tracing = true;
		//如果finded中包括了所有节点，则停止遍历
		while (tracing) {
			tracing = false;
			 //node节点的path
			HashMap<Integer, Integer> nodePath = path.get(node);
			int nodeMin = node;
			//遍历node节点的path，更新最短距离
			for (Entry<Integer, Integer> nodeEveryPath : nodePath.entrySet()) {
				int tPath = nodeEveryPath.getValue();
				int tNode = nodeEveryPath.getKey();
				if (!finded.contains(tNode)) {
					tracing = true;
					//找到当前权值最小
					if (nodeMin == node || nodeMin > tPath) {
						nodeMin = nodeEveryPath.getKey();
					}
					//更新最短路径
					if (minPaths.get(tNode) == null || minPaths.get(tNode) > tPath + pathMin) {
						minPaths.put(tNode, tPath + pathMin);
					}
				}
			}
			finded.add(nodeMin);
			node = nodeMin;
			pathMin = minPaths.get(nodeMin);
		}
		return minPaths.get(targetNode);
	}
}
