package udp;

import attack.attackStreaming.Event;
import attack.attackStreaming.StreamGUI;
import client.PacketHandling;
import map.Game;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Reciever extends Thread{
    private Integer port;
    private DatagramSocket ds;
    private byte[] receive = new byte[65535];
    private Event event ;
    StreamGUI streamGUI;

    DatagramPacket DpReceive = null;
    Game game;
    boolean isCountinue = true;
    public Reciever(Integer port){
        this.port = port;
    }

    public void setStreamGUI(StreamGUI streamGUI) {
        this.streamGUI = streamGUI;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setCountinue(boolean countinue) {
        isCountinue = countinue;
    }

    @Override
    public void run(){
        try {
            ds = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (isCountinue)
        {
            receive = new byte[4000];
            DpReceive = new DatagramPacket(receive, receive.length);

            try {
                ds.receive(DpReceive);
                try {
                    event = PacketHandling.convertPacketToEvent(DpReceive);
                    if(event!=null){
                        if (event.isEventType()) {
                            game.recieveBuildingEvent(event);
                            } else {
                            streamGUI.updateSoldier(event);
                        }

                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public StreamGUI getStreamGUI() {
        return streamGUI;
    }
}
