package multiclientchat;

import javax.swing.*;

//Class to precise who is connected : Client or Server
public class ClientServer {

	
	public static void main(String [] args){
		
		Object[] selectioValues = { "Server","Client"};
		String initialSection = "Server";
		
		Object selection = JOptionPane.showInputDialog(null, "Login as : ", "MyChatApp", JOptionPane.QUESTION_MESSAGE, null, selectioValues, initialSection);
                String portNumber = JOptionPane.showInputDialog("Enter the Server Port");
                if(portNumber==null || portNumber.equals("")){
                    JOptionPane.showMessageDialog(null, "Plsease enter port number");
                    System.exit(1);
                }
		if(selection.equals("Server")){
                        
                        String[] arguments = new String[] {portNumber};
			new MultiThreadChatServerSync().main(arguments);
		}else if(selection.equals("Client")){
			String IPServer = JOptionPane.showInputDialog("Enter the Server ip adress");
                        String[] arguments = new String[] {IPServer,portNumber};
			new ChatClient().main(arguments);
		}
		
	}

}
