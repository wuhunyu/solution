package com.wuhunyu.solution;

/**
 * 6134. 找到离给定两个节点最近的节点
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/7/31 10:44
 */

public class ClosestMeetingNode {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int node1Copy = node1;
        int node2Copy = node2;

        while (node1Copy != -1 && node2Copy != -1) {
            if (node1Copy == node2Copy) {
                return Math.min(node1, node2);
            }
            if (edges[node1Copy] == -1) {
                break;
            }
            node1Copy = edges[edges[node1Copy]];
            node2Copy = edges[node2Copy];
        }

        node1Copy = node1;
        node2Copy = node2;

        while (true) {
            if (node1Copy == node2Copy) {
                return node1Copy;
            }
            node1Copy = edges[node1Copy];
            node2Copy = edges[node2Copy];
            if (node1Copy == -1 && node2Copy == -1) {
                return -1;
            }
            if (node1Copy == -1) {
                node1Copy = node2;
            }
            if (node2Copy == -1) {
                node2Copy = node1;
            }
        }
    }

    public static void main(String[] args) {
        ClosestMeetingNode closestMeetingNode = new ClosestMeetingNode();

        System.out.println(closestMeetingNode.closestMeetingNode(new int[]{1, 2, -1}, 0, 2));
        System.out.println(closestMeetingNode.closestMeetingNode(new int[]{1, 2, -1, 4, -1}, 0, 3));
        System.out.println(closestMeetingNode.closestMeetingNode(new int[]{9, 8, 7, 0, 5, 6, 1, 3, 2, 2}, 1, 6));
    }

}
