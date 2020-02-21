package client;

import building.GuardianGiant;
import map.GameTransfer;
import server.ClientInfo;
import server.refreshMessages.AttackRefreshMessage;

import java.io.Serializable;
import java.util.ArrayList;

public class ClientTransferMessage implements Serializable{
    private ClientListeningMode clientListeningMode;
    private ArrayList<ClientInfo> serverClientInfos;
    private GameTransfer gameTransfer;
    private String ID;
    private Integer port;
    private String IP;
    private AttackRefreshMessage refreshMessage=null;
    private GuardianGiant guardianGiant;
    private ArrayList<Integer> numbers = new ArrayList<>();
//    int guardians, int wallBreakers, int giants, int dragons, int archers, int healers
    private int elixir;
    private int gold;
    private ArrayList<AttackRefreshMessage> warboardRefreshMessages;


    public int getElixir() {
        return elixir;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setElixir(int elixir) {
        this.elixir = elixir;
    }

    public ArrayList<AttackRefreshMessage> getWarboardRefreshMessages() {
        return warboardRefreshMessages;
    }

    public ClientTransferMessage(ClientListeningMode clientListeningMode, ArrayList<ClientInfo> serverClientInfos, GameTransfer gameTransfer, String ID, Integer port, String IP, GuardianGiant guardianGiant, ArrayList<Integer> numbers) {
        this.clientListeningMode = clientListeningMode;
        this.serverClientInfos = serverClientInfos;
        this.gameTransfer = gameTransfer;
        this.ID = ID;
        this.IP = IP;
        this.port = port;
        this.guardianGiant = guardianGiant;
        this.numbers =numbers;
    }

    public ClientTransferMessage(ClientListeningMode clientListeningMode, ArrayList<AttackRefreshMessage> warboardRefreshMessages) {
        this.clientListeningMode = clientListeningMode;
        this.warboardRefreshMessages = warboardRefreshMessages;
    }

    public Integer getPort() {
        return port;
    }

    public String getIP() {
        return IP;
    }

    public ClientListeningMode getClientListeningMode() {
        return clientListeningMode;
    }

    public ArrayList<ClientInfo> getServerClientInfos() {
        return serverClientInfos;
    }

    public GameTransfer getGameTransfer() {
        return gameTransfer;
    }

    public String getID() {
        return ID;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public GuardianGiant getGuardianGiant() {
        return guardianGiant;
    }

    public void setGuardianGiant(GuardianGiant guardianGiant) {
        this.guardianGiant = guardianGiant;
    }
}
