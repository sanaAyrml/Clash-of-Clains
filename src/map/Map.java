package map;

import attack.soldiers.Situation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static map.Constants.MAP_WIDTH;

public class Map implements Serializable{
    private final Integer NOWHERE = -5000;

    private ArrayList<Cell> map = new ArrayList<>();

    public ArrayList<Cell> getMap() {
        return map;
    }

    public void setMap(ArrayList<Cell> map) {
        this.map = map;
    }

    private ArrayList<Integer> queue = new ArrayList<>();

    private HashMap<Integer, Integer> parent = new HashMap<>();

    public Map() {
        for (int i = 0; i < Constants.MAP_HEGHT; i++)
            for (int j = 0; j < MAP_WIDTH; j++)
                map.add(new Cell(j, i));
    }

    public Direction move(Cell beginningCell, ArrayList<Cell> destinationsCell, Situation situation)
    {
        HashMap<Integer, Integer> distanceNextCellNum = new HashMap<>();
        int beginningCellNum = beginningCell.getX() + MAP_WIDTH * beginningCell.getY();
        int nextCellNum ;
        for (Cell c:destinationsCell)
        {
            int destinationCellNum = c.getX() + MAP_WIDTH * c.getY();

            nextCellNum = findBestCellNum(beginningCellNum, destinationCellNum, situation);

            if (nextCellNum != NOWHERE) {
              distanceNextCellNum.put(getDistance(beginningCellNum), nextCellNum);
            }
        }

        if (distanceNextCellNum.size() == 0) {
            return Direction.NONE;
        }
        ArrayList<Integer> keyArrayList = new ArrayList<>(distanceNextCellNum.keySet());
        Collections.sort(keyArrayList);
        return getDirection(beginningCellNum, distanceNextCellNum.get(keyArrayList.get(0)));

    }

    private Integer getDistance (int beginningCellNum)
    {
        int distance = 0;
        while (parent.get(beginningCellNum) != beginningCellNum)
        {
            distance++;
            beginningCellNum = parent.get(beginningCellNum);
        }
        return distance;
    }

    private Direction getDirection(int beginingCellNum,int nextCellNum)
    {
        if (beginingCellNum - nextCellNum == -1)
            return Direction.RIGHT;
        if (beginingCellNum - nextCellNum == 1)
            return Direction.LEFT;
        if (beginingCellNum - nextCellNum == -MAP_WIDTH)
            return Direction.DOWN;
        if (beginingCellNum - nextCellNum == MAP_WIDTH)
            return Direction.UP;
        if (beginingCellNum == nextCellNum) {
            return Direction.REACHED;
        }
        return Direction.NONE;
    }

    private int findBestCellNum(int beginingCellNum, int desCellNum, Situation situation)
    {
        queue.clear();
        parent.clear();
        parent.put(desCellNum, desCellNum);
        bfs(desCellNum, situation);
        parent.putIfAbsent(beginingCellNum, NOWHERE);
        return parent.get(beginingCellNum);

    }

    private void bfs(int destination, Situation situation)
    {

        //Up
        if (destination / MAP_WIDTH != 0 && !parent.containsKey(destination - MAP_WIDTH) && (situation == Situation.AIR || map.get(destination - MAP_WIDTH).isFree())) {
            queue.add(destination - MAP_WIDTH);
            parent.put(destination - MAP_WIDTH, destination);
        }

        //Down
        if (destination / MAP_WIDTH != Constants.MAP_HEGHT - 1 && !parent.containsKey(destination + MAP_WIDTH) &&(situation == Situation.AIR || map.get(destination + MAP_WIDTH).isFree())) {
            queue.add(destination + MAP_WIDTH);
            parent.put(destination + MAP_WIDTH, destination);
        }

        //Right
        if (destination % MAP_WIDTH != MAP_WIDTH - 1 && !parent.containsKey(destination + 1) && (situation == Situation.AIR || map.get(destination + 1).isFree())) {
            queue.add(destination + 1);
            parent.put(destination + 1, destination);
        }

        //Left
        if (destination % MAP_WIDTH != 0 && !parent.containsKey(destination - 1) && (situation == Situation.AIR || map.get(destination - 1).isFree())) {
            queue.add(destination - 1);
            parent.put(destination - 1, destination);
        }
        while (queue.size() != 0)
        {
            int temp = queue.get(0);
            queue.remove(0);
            bfs(temp, situation);
        }
    }

}
