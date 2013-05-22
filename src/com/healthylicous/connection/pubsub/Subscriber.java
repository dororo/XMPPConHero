package com.healthylicous.connection.pubsub;

import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

public class Subscriber {
	public static final String TOPIC = "Topic";
	private static final String USER = "sue";
	private static final String PASSWORD = "openfire";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SASLAuthentication.supportSASLMechanism("PLAIN");
		XMPPConnection.DEBUG_ENABLED = true;
		try {
			PubSubHandler con = new PubSubHandler();
			con.connect();
			con.login(USER, PASSWORD);
			if(con.isConnected()){
				System.out.println("Connection Success!!");
			}
			con.listener(TOPIC);
			con.subscribe(con.getUser(), TOPIC);
			con.discoItems(TOPIC);
			con.getChildElXML(TOPIC);
			con.deListener(TOPIC);
			con.getItem(TOPIC);
//			con.getPersistedItems(TOPIC);
			con.getCurrentItems(TOPIC);
//			con.getAffiliation(TOPIC);
			con.unSubscribe(con.getUser(), TOPIC);

		} catch (XMPPException e) {
			e.printStackTrace();
		}

	}

}
