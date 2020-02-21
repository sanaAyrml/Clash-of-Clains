package controllers;

public class Controller {
//    private ArrayList<Game> games = new ArrayList<>();
//    private ArrayList<String> names = new ArrayList<>();
//    private MenuController menuController = new MenuController();
//    private Game game ;
//    private Game defGame;
//    private AttackController attackController;
//    private String path;
//    public Controller() {
//        view.setMenuController(menuController);
//    }
//
//    //    public void menu(){
////        menuController.menu(games.get(0));
////    }
//    public void startGame(){
//        game = new Game();
//        menuController.setG(game);
////        view.check();
////        view.setMenuController(menuController);
////        view.printInVillage();
////        view.check();
//    }
////    public void upgarde(Building building){
//////        building.upgrade();
////    }
//    public void loadGame(){
//        String entry = null;
//        int i = 2;
//        System.out.println("1. load map");
//        for (Game g:games) {
////            if(!g.getName().equals(game.getName())){
//            System.out.println(i +". "+ g.getGameName());
//            i++;
////            }
//        }
//        System.out.println(i+". Back");
//        do {
//            entry = view.printMaps(games);
//        }
//        while (entry.length()<1);
//
//        if(entry.equalsIgnoreCase("Load map")){
//
//            loadMap();
//            if (defGame == null)
//            {
//                loadGame();
//            }
//            else {
//                boolean flag = true;
//                for (Game g : games){
//                    if(g.getGameName().equals(defGame.getGameName())){
//                       flag = false;
//                    }
//                }
//                if(flag)
//                games.add(defGame);
//                attackController = new AttackController(game, defGame);
//                attackController.start();
//
//                loadGame();
//                return;
//            }
//        }
//        else if(entry.equalsIgnoreCase("Back")){
////            view.printInVillage();
////            view.check();
//            return;
//        }
//        else if(entry.length()>0){
//
//            for (Game g : games){
//                if(entry.equalsIgnoreCase(g.getGameName())) {
//                    defGame = g;
//                    attackController = new AttackController(game, defGame);
//                    attackController.start();
//                    return;
//
//                }
//
//            }
//            view.invalidCommand();
//            loadGame();
//        }
//    }
//    public void loadMap(){
//        path = view.loadMap();
//        Json json = new Json();
//        try {
//            defGame = json.getGame(path);
//
//        } catch (IOException e) {
//            System.out.println("There is no valid file in this location.");
//            defGame = null;
//        }
//    }
//    public void loadMap2(String path){
//        Json json = new Json();
//        try {
//            defGame = json.getGame(path);
//
//        } catch (IOException e) {
//            System.out.println("There is no valid file in this location.");
//            defGame = null;
//        }
//    }
//    public void saveGame(Game game, String path, String name)
//    {
//        BufferedWriter writer = null;
//        YaGson yaGson = new YaGson();
//        String text = yaGson.toJson(game);
//        try{
//            File file = new File(path + "/" + name + ".json");
//            writer = new BufferedWriter(new FileWriter(file));
//            writer.write(text);
//            writer.close();
//        } catch (Exception e) {
//            System.out.println("Can't save");
////            view.check();
//        }finally {
//            try {
//                writer.close();
//            }catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void loadPathMap(String path) throws IOException {
//        try {
//            String text = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
//            YaGson yaGson = new YaGson();
//             game = yaGson.fromJson(text, Game.class);
//            menuController.setG(game);
//            view.setMenuController(menuController);
//            view.printInVillage();
////            view.check();
//        }catch (IOException e)
//        {
//            System.out.println("There is no valid file in this location.");
//            view.startGame();
//        }
//    }



}
