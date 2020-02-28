package com.srikar.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution4 {

    private class ServerCoordinates {
        private int x;
        private int y;

        public ServerCoordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int minimumDays(int rows, int columns, List<List<Integer>> grid) {
        Queue<ServerCoordinates> updateableServers = new LinkedList<>();
        int maxNumberOfDays = rows * columns;
        int daysCount = 0, result = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == 1) {
                    updateableServers.offer(new ServerCoordinates(i, j));
                    daysCount++;
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!updateableServers.isEmpty()) {
            int size = updateableServers.size();
            if (daysCount == maxNumberOfDays) {
                return result;
            }
            for (int i = 0; i < size; i++) {
                ServerCoordinates currentServer = updateableServers.poll();
                for (int[] dir : dirs) {
                    int currX = currentServer.x + dir[0];
                    int currY = currentServer.y + dir[1];
                    if (currX >= 0 && currX < rows && currY >= 0 && currY < columns && grid.get(currX).get(currY) == 0) {
                        daysCount++;
                        updateableServers.offer(new ServerCoordinates(currX, currY));
                        grid.get(currX).set(currY, 1);
                    }
                }
            }
            result++;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            grid.add(new ArrayList<>());
        }

        grid.get(0).add(0);
        grid.get(0).add(1);
        grid.get(0).add(1);
        grid.get(0).add(0);
        grid.get(0).add(1);

        grid.get(1).add(0);
        grid.get(1).add(1);
        grid.get(1).add(0);
        grid.get(1).add(1);
        grid.get(1).add(0);

        grid.get(2).add(0);
        grid.get(2).add(0);
        grid.get(2).add(0);
        grid.get(2).add(0);
        grid.get(2).add(1);

        grid.get(3).add(0);
        grid.get(3).add(1);
        grid.get(3).add(0);
        grid.get(3).add(0);
        grid.get(3).add(0);

        int result = new Solution4().minimumDays(4, 5, grid);
        System.out.println(result);
    }
}