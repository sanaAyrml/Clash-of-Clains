package udp;

import attack.attackStreaming.Event;
import client.PacketHandling;

import java.io.IOException;
import java.net.*;

public class Sender extends Thread{

    DatagramSocket ds;
    Event event;

    {
        try {
            ds = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    InetAddress ip;

    int port;
    Boolean end = false;

    public Sender(String ipString, Integer port){
            try {
                ip = InetAddress.getByName(ipString);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            this.port = port;

    }

    public void setEvent(Event event) {
        this.event = event;
    }
    @Override
    public void run(){

        while (!end)
        {

            DatagramPacket DpSend = null;
            try {
                DpSend = PacketHandling.convertEventToPacket(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
            DpSend.setAddress(ip);
            DpSend.setPort(port);

            try {
                ds.send(DpSend);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
