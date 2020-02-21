package map;

import building.*;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.PannableCanvas;

import static map.Constants.MAP_WIDTH;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class GameGUI extends Thread {
    private PannableCanvas canvas = new PannableCanvas();
    private PannableCanvas resourceCanvas = new PannableCanvas();
    private Game game;
    private MapGUI mapGUI = new MapGUI();
    private Text elixirAmount = new Text();
    private Text goldAmount = new Text();
    private Text time = new Text();

    public GameGUI(Game game) {
        this.game = game;
        startGameGUI();
        setResources("Elixir", Constants.CELL_HEIGHT / 2);
        checkElixirAmount();
        setResources("Gold", Constants.CELL_HEIGHT);
        checkGoldAmount();
        setTime();
    }

    private void startGameGUI()
    {
        try {
            InputStream inputStream = new FileInputStream(new File(Images.ADDRESS + "background.png"));
            Image image = new Image(inputStream);
            canvas.setTranslateX(0);
            canvas.setTranslateY(0);
            canvas.getChildren().add(new ImageView(image));
            for (ImageView emptyImageView : mapGUI.getMap()) {
                canvas.getChildren().add(emptyImageView);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public GameGUI(GameTransfer gameTransfer){
        startGameGUI();
        loadGameGUI(gameTransfer);
    }

    private void setResources(String resource, int y)
    {
        try {
            InputStream inputStream = new FileInputStream(new File(Images.ADDRESS + resource +".png"));
            Image image = new Image(inputStream);
            ImageView imageView = new ImageView(image);
            imageView.setX(Images.RESOURCE_IMAGEVIEW_X);
            imageView.setY(y);
            resourceCanvas.getChildren().add(imageView);
            Text amount = getResourceText(resource);
            amount.setX(Images.RESOURCE_IMAGEVIEW_X + Constants.CELL_WIDTH / 4 + 5);
            amount.setY(y + Constants.CELL_WIDTH / 8 + 5);
            amount.setFill(resourceAmountColor(resource));
            resourceCanvas.getChildren().add(amount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private Color resourceAmountColor(String resource)
    {
        if (resource.equals("Elixir"))
            return Color.HOTPINK;
        else if (resource.equals("Gold"))
            return Color.GOLD;
        else
            return Color.BLACK;
    }

    private Text getResourceText(String resource)
    {
        if (resource.equals("Elixir"))
            return elixirAmount;
        else
            return goldAmount;
    }

    private void setTime()
    {
        resourceCanvas.getChildren().add(time);
        time.setX(Images.RESOURCE_IMAGEVIEW_X);
        time.setY(Constants.CELL_HEIGHT * 3 / 2);
        time.setFill(Color.WHITESMOKE);
    }

    @Override
    public void run() {
        while (true) {
                for (ArrayList<Cell> buildings : game.getAllBuildings()) {
                    if (buildings.equals(game.getWalls()))
                       checkWalls();
                    else if(buildings.equals(game.getTownHalls()))
                        checkTownHall(buildings);
                    else
                        checkBuildings(buildings);
                }
                if (game.isTimeChanged()) {
                    time.setText("time: " + game.getTime());
                    game.setTimeChanged(false);
                }
        }
    }

    private void checkBuildings(ArrayList<Cell> buildings)
    {
        ArrayList<Cell> temp = new ArrayList<>(buildings);
        for (Cell cell : temp) {
        if (cell.getBuilding().shouldImageBeChanged()) {
            setBuildingImage(cell);
            cell.getBuilding().imageShouldBeChanged(false);
        }
        }
    }
    private void checkTownHall(ArrayList<Cell> townHalls)
    {
        ArrayList<Cell> temp = new ArrayList<>(townHalls);
        if (temp.get(0).getBuilding().shouldImageBeChanged())
        {
            setTownHallImages(townHalls);
            townHalls.get(0).getBuilding().imageShouldBeChanged(false);
        }
    }

    private void setTownHallImages(ArrayList<Cell> townHalls)
    {
        for (int i = 0; i < 4; i++) {
            mapGUI.updateImage(townHalls.get(i).getY() * MAP_WIDTH + townHalls.get(i).getX(), Images.getLevelImageTownHall().get(townHalls.get(0).getBuilding().getLevel()).get(i));
        }
    }

    public void checkElixirAmount()
    {
        elixirAmount.setText(game.getTotalElixir().toString());
    }

    public void checkGoldAmount()
    {
        goldAmount.setText(game.getTotalGold().toString());
    }

    private void setBuildingImage(Cell cell)
    {
        try {
            mapGUI.updateImage(cell.getY() * MAP_WIDTH + cell.getX(), ((HashMap<Integer, Image>) Images.class
                    .getMethod("getLevelImage" + cell.getBuilding().getClass().getSimpleName()).invoke(Images.class)).get(cell.getBuilding().getLevel()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkWalls()
    {
        ArrayList<Cell> temp = new ArrayList<>(game.getWalls());
        for (Cell cell : temp) {
            if (cell.getBuilding().shouldImageBeChanged())
            {
                int cellNum = cell.getY() * Constants.MAP_WIDTH + cell.getX();
                mapGUI.updateImage(cellNum, Images.getDirectionImageWall().get(getDirections(cellNum)));
                cell.getBuilding().imageShouldBeChanged(false);
                if (((Wall) cell.getBuilding()).isNewBuilding()) {
                    ((Wall) cell.getBuilding()).setNewBuilding(false);
                    checkNeighbours(cellNum);
                }
            }
        }
    }

    private String getDirections(int cellNum)
    {
        //Right Left Up Down
        return checkRightCell(cellNum) + checkLeftCell(cellNum) + checkUpCell(cellNum) + checkDownCell(cellNum);
    }

    private String checkRightCell(int cellNum)
    {
        if (cellNum % Constants.MAP_WIDTH != Constants.MAP_WIDTH - 1 && !game.getMap().getMap().get(cellNum + 1).isFree() &&
                Wall.class.isInstance(game.getMap().getMap().get(cellNum + 1).getBuilding()))
            return "1";
        else
            return  "0";
    }

    private String checkLeftCell(int cellNum)
    {
        if (cellNum % Constants.MAP_WIDTH != 0 && !game.getMap().getMap().get(cellNum - 1).isFree() &&
                Wall.class.isInstance(game.getMap().getMap().get(cellNum - 1).getBuilding()))
            return "1";
        else
            return  "0";
    }

    private String checkUpCell(int cellNum)
    {
        if (cellNum / Constants.MAP_WIDTH != 0 && !game.getMap().getMap().get(cellNum - Constants.MAP_WIDTH).isFree() &&
                Wall.class.isInstance(game.getMap().getMap().get(cellNum - Constants.MAP_WIDTH).getBuilding()))
            return "1";
        else
            return  "0";
    }

    private String checkDownCell(int cellNum)
    {
        if (cellNum / Constants.MAP_WIDTH != Constants.CELL_HEIGHT - 1 && !game.getMap().getMap().get(cellNum + Constants.MAP_WIDTH).isFree() &&
                Wall.class.isInstance(game.getMap().getMap().get(cellNum + Constants.MAP_WIDTH).getBuilding()))
            return "1";
        else
            return  "0";
    }

    private void checkNeighbours(int cellNum)
    {
        if (checkRightCell(cellNum).equals("1"))
            game.getMap().getMap().get(cellNum + 1).getBuilding().imageShouldBeChanged(true);
        if (checkLeftCell(cellNum).equals("1"))
            game.getMap().getMap().get(cellNum - 1).getBuilding().imageShouldBeChanged(true);
        if (checkUpCell(cellNum).equals("1"))
            game.getMap().getMap().get(cellNum - Constants.MAP_WIDTH).getBuilding().imageShouldBeChanged(true);
        if (checkDownCell(cellNum).equals("1"))
            game.getMap().getMap().get(cellNum + Constants.MAP_WIDTH).getBuilding().imageShouldBeChanged(true);
    }

    private void setWalls(ArrayList<Cell> walls)
    {
        for (Cell wallCell : walls)
            mapGUI.updateImage(wallCell.getY() * MAP_WIDTH + wallCell.getX(),
                    Images.getDirectionImageWall().get(getDirections(wallCell.getY() * MAP_WIDTH + wallCell.getX())));
    }

    public void loadGameGUI()
    {
        for (ArrayList<Cell> buildings : game.getAllBuildings()) {
            if (buildings.equals(game.getWalls()))
                setWalls(buildings);
            else if(buildings.equals(game.getTownHalls()))
                setTownHallImages(buildings);
            else
                for (Cell cell : buildings)
                    setBuildingImage(cell);
        }
    }

    public void loadGameGUI(GameTransfer gameTransfer)
    {
        for (ArrayList<Cell> buildings : gameTransfer.getAllBuildings()) {
            if (buildings.equals(gameTransfer.getWalls()))
                setWalls(buildings);
            else if(buildings.equals(gameTransfer.getTownHalls()))
                setTownHallImages(buildings);
            else
                for (Cell cell : buildings)
                    setBuildingImage(cell);
        }
    }

    public PannableCanvas getCanvas() {
        return canvas;
    }

    public PannableCanvas getResourceCanvas() {
        return resourceCanvas;
    }

    public Game getGame() {
        return game;
    }

    public MapGUI getMapGUI() {
        return mapGUI;
    }
}
