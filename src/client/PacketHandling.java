package client;

import attack.attackStreaming.Event;

import java.io.*;
import java.net.DatagramPacket;
import java.util.Arrays;

import static client.ClientConstants.PACKET_SIZE;

public class PacketHandling {
    public static DatagramPacket convertEventToPacket(Event event) throws IOException
    {
        return new DatagramPacket(convertEventToBytes(event), convertEventToBytes(event).length);
    }

    public static Event convertPacketToEvent(DatagramPacket packet) throws IOException, ClassNotFoundException
    {
        return convertBytesToEvent(packet.getData());
    }

    static byte[] convertEventToBytes(Event event) throws IOException
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        out = new ObjectOutputStream(bos);
        out.writeObject(event);
        out.flush();
        byte[] bytes = bos.toByteArray();
        bos.close();
        return bytes;
//        return fillArray(bytes, bytes.length);
        //byte[] data = SerializationUtils.serialize(yourObject)
    }

    static Event convertBytesToEvent(byte[] bytes) throws IOException, ClassNotFoundException
    {
//        ByteArrayInputStream bis = new ByteArrayInputStream(removeExtraBytes(bytes));
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

        ObjectInput in = null;
        in = new ObjectInputStream(bis);
        Object object = in.readObject();
        in.close();
        return (Event) object;
        //YourObject yourObject = SerializationUtils.deserialize(data)
    }

}
