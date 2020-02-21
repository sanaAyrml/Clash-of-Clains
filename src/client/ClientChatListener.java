package client;

import javafx.animation.AnimationTimer;
import map.Message;
import view.MessageGUI;

import java.io.ObjectInputStream;

public class ClientChatListener extends Thread{
    private Client client;

   private MessageGUI messageGUI ;
    private ObjectInputStream objectInputStream;

    public ClientChatListener(ObjectInputStream objectInputStream,Client client) {
        this.client=client;
        messageGUI=new MessageGUI(client);
        this.objectInputStream = objectInputStream;
    }



    public void run(){
        while(true){
            try {
               Message message = (Message) objectInputStream.readObject();
                AnimationTimer timer =new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        if(!messageGUI.called){
                            messageGUI.setText(message.getText(),message.getId());

                        }
                    }
                };
                timer.start();
                sleep(100);
                timer.stop();
                messageGUI.called=false;
            }
            catch (Exception e){
            }


        }
    }

    public MessageGUI getMessageGUI() {
        return messageGUI;
    }
}
