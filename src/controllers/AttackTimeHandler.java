package controllers;

import attack.attackStreaming.Event;
import attack.attackStreaming.StreamGUI;
import attack.soldiers.*;
import map.Cell;
import server.ServerListeningMode;
import server.ServerTransferMessage;
import server.refreshMessages.AttackRefreshMessage;

import java.util.ArrayList;

public class AttackTimeHandler extends Thread{
    AttackController controller;
    public boolean alive=true;
    public double time=0;

    public AttackTimeHandler(AttackController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        while (alive) {
            controller.passTime(1);
            for (int i = 0; i < 10; i++) {
                controller.graphicalPassTime();
                if(i%2==0&&controller.getClient()!=null){
                    for (Guardian guardian : controller.getGuardians()) {
                        if(guardian.passEvent()){
                            Event soldierEvent=new Event(false,guardian.getHealth(),1,controller.getGuardians().indexOf(guardian),guardian.getGraphicalX(),guardian.getGraphicalY(), StreamGUI.getNumDirectionIdentifier().get(guardian.getDirection()));
                            controller.getClient().getSender().setEvent(soldierEvent);
                            sleep20();
                        }
                    }
                    for (Archer archer : controller.getArchers()) {
                        if(archer.passEvent()){
                            Event soldierEvent=new Event(false,archer.getHealth(),2,controller.getGuardians().indexOf(archer),archer.getGraphicalX(),archer.getGraphicalY(), StreamGUI.getNumDirectionIdentifier().get(archer.getDirection()));
                            controller.getClient().getSender().setEvent(soldierEvent);
                            sleep20();
                        }
                    }
                    for (Giant giant : controller.getGiants()) {
                        if(giant.passEvent()){
                            Event soldierEvent=new Event(false,giant.getHealth(),3,controller.getGuardians().indexOf(giant),giant.getGraphicalX(),giant.getGraphicalY(), StreamGUI.getNumDirectionIdentifier().get(giant.getDirection()));
                            controller.getClient().getSender().setEvent(soldierEvent);
                            sleep20();
                        }
                    }
                    for (WallBreaker wallBreaker : controller.getWallBreakers()) {
                        if(wallBreaker.passEvent()){
                            Event soldierEvent=new Event(false,wallBreaker.getHealth(),4,controller.getGuardians().indexOf(wallBreaker),wallBreaker.getGraphicalX(),wallBreaker.getGraphicalY(), StreamGUI.getNumDirectionIdentifier().get(wallBreaker.getDirection()));
                            controller.getClient().getSender().setEvent(soldierEvent);
                            sleep20();
                        }
                    }for (Dragon dragon : controller.getDragons()) {
                        if(dragon.passEvent()){
                            Event soldierEvent=new Event(false,dragon.getHealth(),6,controller.getGuardians().indexOf(dragon),dragon.getGraphicalX(),dragon.getGraphicalY(), StreamGUI.getNumDirectionIdentifier().get(dragon.getDirection()));
                            controller.getClient().getSender().setEvent(soldierEvent);
                            sleep20();
                        }
                    }for (Healer healer: controller.getHealers()) {
                        if(healer.passEvent()){
                            Event soldierEvent=new Event(false,healer.getHealth(),5,controller.getGuardians().indexOf(healer),healer.getGraphicalX(),healer.getGraphicalY(), StreamGUI.getNumDirectionIdentifier().get(healer.getDirection()));
                            controller.getClient().getSender().setEvent(soldierEvent);
                            sleep20();
                        }
                    }


                }
                try {
                    time+=0.1;
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            controller.movePassTime();
            if(controller.getClient()!=null){
                controller.getClient().getClientMessageSender().send(new ServerTransferMessage(ServerListeningMode.REFRESH_ATTACK,controller.getClient().getID(),null,new AttackRefreshMessage(controller.getGold(),
                        controller.getElixir(),controller.getPoint(),controller.aliveSoldiers(),controller.getTotalSoldiers()-controller.aliveSoldiers(),distructed(controller.getGameDefender().getGoldMines()), distructed(controller.getGameDefender().getElixirMines()),
                        distructed(controller.getGameDefender().getGoldStorages()),distructed(controller.getGameDefender().getElixirStorages()),distructed(controller.getGameDefender().getBarrackss()),distructed(controller.getGameDefender().getCamps()),distructed(controller.getGameDefender().getWalls()),
                        distructed(controller.getGameDefender().getWizardTowers()),distructed(controller.getGameDefender().getArcherTowers()),distructed(controller.getGameDefender().getAirDefenses()), distructed(controller.getGameDefender().getCannons()),distructed(controller.getGameDefender().getGiantCastles()),
                        distructed(controller.getGameDefender().getTownHalls()),controller.getClient().getID()),null,null,null,null,null));
            }
        }
        System.err.println("attack ended");
        controller.getClient().getClientMessageSender().send(new ServerTransferMessage(ServerListeningMode.ATTACK_ENDED,controller.getClient().getID(),null,new AttackRefreshMessage(controller.getGold(),
                controller.getElixir(),controller.getPoint(),controller.aliveSoldiers(),controller.getTotalSoldiers()-controller.aliveSoldiers(),distructed(controller.getGameDefender().getGoldMines()),distructed(controller.getGameDefender().getElixirMines()),
                distructed(controller.getGameDefender().getGoldStorages()),distructed(controller.getGameDefender().getElixirStorages()),distructed(controller.getGameDefender().getBarrackss()),distructed(controller.getGameDefender().getCamps()),distructed(controller.getGameDefender().getWalls()),
                distructed(controller.getGameDefender().getWizardTowers()),distructed(controller.getGameDefender().getArcherTowers()),distructed(controller.getGameDefender().getAirDefenses()),distructed(controller.getGameDefender().getCannons()),distructed(controller.getGameDefender().getGiantCastles()),
                distructed(controller.getGameDefender().getTownHalls()),null),null,null,null,null,null));
    }

    private int distructed(ArrayList<Cell> cells){
        int sum=0;
        for (Cell cell : cells) {
            if(cell.getBuilding().getHealth()<=0){
                sum++;
            }
        }
        return sum;
    }
    private void sleep20(){
        try {
            sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
