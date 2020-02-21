package map;

import java.util.ArrayList;

public class MenuModel {
    private MenuModel parent;
    private String title;
    private ArrayList<MenuModel> childs;

    public void setChild(MenuModel child) {
        childs.add(child);
    }

    public void setParent(MenuModel parent) {
        this.parent = parent;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<MenuModel> getChild() {
        return childs;
    }

    public MenuModel getParent() {
        return parent;
    }

    public String getTitle() {
        return title;
    }
}
