package server;

import java.util.ArrayList;
import java.util.Collections;

public class LeaderBoard {
    ArrayList<Client> clients;

    public LeaderBoard(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public void refresh()
    {
        Collections.sort(clients);
    }
}
