package map;

import attack.attackStreaming.Event;
import building.Building;
import building.DefenseTower;
import building.ElixirMine;
import building.GoldMine;
import client.AttackPosition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.PannableCanvas;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

import static map.Constants.*;

public class GameDef extends Thread {
    private PannableCanvas defenseSoldierCanvas = new PannableCanvas();
    private PannableCanvas buildingsHealthCanvas = new PannableCanvas();
    private ArrayList<Rectangle> buildingHealths = new ArrayList<>();


    private MapGUI defenseSoldierMapGUI = new MapGUI();
    private GameGUI gameGUI;
    private boolean end = false;
    private AttackPosition attackPosition;

    public GameDef(GameGUI gameGUI, AttackPosition attackPosition)
    {
        this.attackPosition = attackPosition;
        this.gameGUI = gameGUI;
        for (ImageView emptyImageView : defenseSoldierMapGUI.getMap()) {
            defenseSoldierCanvas.getChildren().add(emptyImageView);
        }
        addBuildingsHealth();
    }

    private void addBuildingsHealth(){
        for (int i = 0; i < MAP_WIDTH * Constants.MAP_HEGHT; i++) {
            Rectangle rectangle = new Rectangle();
            rectangle.setX(i % MAP_WIDTH * CELL_WIDTH + CELL_WIDTH / 4);
            rectangle.setY(i / MAP_WIDTH * CELL_HEIGHT - 6);
            rectangle.setHeight(6);
            rectangle.setFill(Color.GREEN);
            rectangle.setOpacity(0);
            buildingHealths.add(rectangle);
            buildingsHealthCanvas.getChildren().add(rectangle);
        }
        setVisibleHealths();
    }

    private void setVisibleHealths()
    {
        for (ArrayList<Cell> cells : gameGUI.getGame().getAllBuildings()) {
            if (cells.equals(gameGUI.getGame().getTownHalls()))
                buildingHealths.get(cells.get(0).getY() * MAP_WIDTH + cells.get(0).getX()).setOpacity(1);
            else
            for (Cell cell : cells) {
                buildingHealths.get(cell.getY() * MAP_WIDTH + cell.getX()).setOpacity(1);
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
        while (!end)
        {
            checkRuinedBuildings();
            checkDefensesDirection();
            checkHealths();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkHealths()
    {
        ArrayList<ArrayList<Cell>> allBuildings = gameGUI.getGame().getAllBuildings();
        for (int i = 0; i < allBuildings.size(); i++) {
            ArrayList<Cell> buildings = allBuildings.get(i);
            if (buildings.equals(gameGUI.getGame().getTownHalls()))
                setHealth(buildings.get(0).getBuilding(), i, 0);
            for (int j = 0; j < buildings.size(); j++) {
                Building building = buildings.get(j).getBuilding();
                if (!building.getLastHealth().equals(building.getHealth()))
                    setHealth(building, i, j);
            }
        }
    }

    private void setHealth(Building building, int allBuildingsNum, int buildingsNum)
    {
        if (attackPosition == AttackPosition.ATTACKER && !building.getHealth().equals(building.getStability())) {
            if (building instanceof GoldMine)
                System.err.println(building.getHealth());
            sendEventToDefender(new Event(building.getHealth(), allBuildingsNum, buildingsNum));
        }
        building.setLastHealth(building.getHealth());
        buildingHealths.get(building.getY() * MAP_WIDTH + building.getX()).setWidth(1.0 * CELL_WIDTH * building.getLastHealth() / building.getStability() / 2);
        buildingHealths.get(building.getY() * MAP_WIDTH + building.getX()).setFill(getHealthColor(building));
    }

    private Color getHealthColor(Building building)
    {
        if (building.getLastHealth() < building.getStability() / 4)
            return Color.RED;
        else if (building.getLastHealth() < building.getStability() / 2)
            return Color.ORANGE;
        else
            return Color.GREEN;
    }

    private void checkRuinedBuildings()
    {
        for (ArrayList<Cell> buildings : gameGUI.getGame().getAllBuildings()) {
            if (buildings.equals(gameGUI.getGame().getTownHalls()))
                checkTownHall(buildings);
            else
                checkBuildings(buildings);
        }
    }

    //TODO in dotaro yeki kon
    private void checkDefensesDirection()
    {
        for (Cell archerTowerCell : gameGUI.getGame().getArcherTowers()) {
            if (archerTowerCell.getBuilding().getHealth() != 0)
            defenseSoldierMapGUI.updateImage(archerTowerCell.getY() * MAP_WIDTH + archerTowerCell.getX(),
                    Images.getDirectionImageArcher().get(((DefenseTower) archerTowerCell.getBuilding()).getDefenseDirection()));
            else
                defenseSoldierMapGUI.updateImage(archerTowerCell.getY() * MAP_WIDTH + archerTowerCell.getX(), Images.getEmptyImage());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Cell wizardTowerCell : gameGUI.getGame().getWizardTowers()) {
            if (wizardTowerCell.getBuilding().getHealth() != 0)
                defenseSoldierMapGUI.updateImage(wizardTowerCell.getY() * MAP_WIDTH + wizardTowerCell.getX(),
                    Images.getDirectionImageWizard().get(((DefenseTower) wizardTowerCell.getBuilding()).getDefenseDirection()));
            else
                defenseSoldierMapGUI.updateImage(wizardTowerCell.getY() * MAP_WIDTH + wizardTowerCell.getX(), Images.getEmptyImage());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkTownHall(ArrayList<Cell> townHalls)
    {
        Building building = townHalls.get(0).getBuilding();
        if (!building.isRuined() && building.getHealth() == 0)
        {
            for (int i = 0; i < 4; i++) {
                gameGUI.getMapGUI().updateImage(townHalls.get(i).getY() * MAP_WIDTH + townHalls.get(i).getX(), Images.getLevelImageTownHall().get(0).get(i));
            }
            building.setRuined(true);
        }
    }

    private void checkBuildings(ArrayList<Cell> buildings)
    {
        for (Cell cell : buildings) {
            if (!cell.getBuilding().isRuined() && cell.getBuilding().getHealth() <= 9) {
                try {
                    gameGUI.getMapGUI().updateImage(cell.getY() * MAP_WIDTH + cell.getX(), ((HashMap<Integer, Image>) Images.class
                            .getMethod("getLevelImage" + cell.getBuilding().getClass().getSimpleName()).invoke(Images.class)).get(0));
                    cell.getBuilding().setRuined(true);
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void sendEventToDefender(Event event)
    {
        gameGUI.getGame().getSender().setEvent(event);
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public PannableCanvas getDefenseSoldierCanvas() {
        return defenseSoldierCanvas;
    }

    public GameGUI getGameGUI() {
        return gameGUI;
    }

    public PannableCanvas getBuildingsHealthCanvas() {
        return buildingsHealthCanvas;
    }
}
