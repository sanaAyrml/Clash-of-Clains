package server;

import building.GuardianGiant;
import map.GameTransfer;
import server.refreshMessages.AttackRefreshMessage;

import java.io.Serializable;
import java.util.ArrayList;

public class ServerTransferMessage implements Serializable{
    public static final long serialVersionUID = 1234567;
    private ServerListeningMode serverListeningMode;
    private String ID;
    private String IP;
    private Integer port;
    private GameTransfer gameTransfer;
    private AttackRefreshMessage attackRefreshMessage;
    private ClientInfo clientInfo;
    private GuardianGiant guardianGiant;
    private ArrayList<Integer> numbers = new ArrayList<>();

    public ServerTransferMessage(ServerListeningMode serverListeningMode, String ID, GameTransfer gameTransfer, AttackRefreshMessage attackRefreshMessage, ClientInfo clientInfo, String IP, Integer port, GuardianGiant guardianGiant, ArrayList<Integer> numbers) {
        this.serverListeningMode = serverListeningMode;
        this.ID = ID;
        this.gameTransfer = gameTransfer;
        this.attackRefreshMessage = attackRefreshMessage;
        this.clientInfo = clientInfo;
        this.IP = IP;
        this.port = port;
        this.guardianGiant = guardianGiant;
        this.numbers =numbers;
    }

    public ServerTransferMessage(ServerListeningMode serverListeningMode, String ID) {
        this.ID = ID;
        this.serverListeningMode = serverListeningMode;
    }

    public ServerListeningMode getServerListeningMode() {
        return serverListeningMode;
    }

    public String getID() {
        return ID;
    }

    public GameTransfer getGameTransfer() {
        return gameTransfer;
    }

    public AttackRefreshMessage getAttackRefreshMessage() {
        return attackRefreshMessage;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public Integer getPort() {
        return port;
    }

    public String getIP() {
        return IP;
    }

    public void setAttackRefreshMessage(AttackRefreshMessage attackRefreshMessage) {
        this.attackRefreshMessage = attackRefreshMessage;
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
