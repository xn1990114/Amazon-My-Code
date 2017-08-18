package chatServer;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChatServerTester {

	@Test
	public void test() {
		ChatServer cs=new ChatServer();
		// test user register/remove
		cs.registerUser(1, "Nan");
		cs.registerUser(2, "Allen");
		assertTrue(cs.um.users.size()==2);
		cs.registerUser(1, "Nanaa");
		assertTrue(cs.um.users.size()==2);
		cs.removeUser(3);
		assertTrue(cs.um.users.size()==2);
		cs.removeUser(1);
		assertTrue(cs.um.users.size()==1);
		cs.registerUser(1, "Nan");
		cs.registerUser(3, "Eric");
		assertTrue(cs.um.users.size()==3);
		assertTrue(!cs.userSignOn(1, "Allen"));
		// test sign on off
		assertTrue(cs.userSignOn(1, "Nan"));
		assertTrue(cs.userSignOn(2, "Allen"));
		assertTrue(!cs.userSignOn(1, "Nan"));
		assertTrue(cs.userSignOn(3, "Eric"));
		assertTrue(cs.um.onlineUsers.size()==3);
		assertTrue(cs.userSignOff(1));
		assertTrue(!cs.userSignOff(1));
		assertTrue(cs.um.onlineUsers.size()==2);
		assertTrue(cs.userSignOn(1, "Nan"));
		assertTrue(cs.um.onlineUsers.size()==3);
		// test create chat and add user
		assertTrue(cs.createChat(1, "Nan and Allen"));
		assertTrue(!cs.createChat(1, "Nan and Allen"));
		assertTrue(cs.createChat(2, "3 person"));
		assertTrue(cs.cm.chats.size()==2);
		// test send message
		assertTrue(!cs.sendMessage(1, "I m Nan", 1));// user not in group
		assertTrue(cs.addUserToChat(1, 1));
		assertTrue(cs.addUserToChat(1, 2));
		assertTrue(!cs.addUserToChat(1, 1));
		assertTrue(cs.addUserToChat(2,1));
		assertTrue(cs.addUserToChat(2, 2));
		assertTrue(cs.addUserToChat(3, 2));
		assertTrue(cs.cm.chats.get(1).participants.size()==2);
		assertTrue(cs.cm.chats.get(2).participants.size()==3);
		assertTrue(cs.sendMessage(1, "i m nan", 1));
		assertTrue(cs.sendMessage(1, "i m nan,anyone there", 1));
		assertTrue(cs.sendMessage(2, "i m allen", 1));
		assertTrue(!cs.sendMessage(3, "i m eric", 1));
		/*for(Message m:cs.cm.chats.get(1).history){
			System.out.println(m.content);
		}
		*/
		assertTrue(cs.sendMessage(1, "i m nan", 2));
		assertTrue(cs.sendMessage(2, "i m allen", 2));
		assertTrue(cs.sendMessage(3, "i m eric", 2));
		assertTrue(cs.sendMessage(1, "hello guys", 2));
		/*for(Message m:cs.cm.chats.get(2).history){
			System.out.println(m.content);
		}
		*/
		// test remove user from chat
		assertTrue(!cs.removeUserFromChat(3, 1));
		assertTrue(cs.removeUserFromChat(2, 1));
		assertTrue(cs.cm.chats.get(1)==null);
		assertTrue(cs.um.users.get(1).chats.size()==1);
		assertTrue(cs.removeUserFromChat(3, 2));
		assertTrue(cs.cm.chats.get(2).participants.size()==2);
		assertFalse(cs.sendMessage(3, "after quit", 2));
		assertTrue(cs.addUserToChat(3, 2));
		assertTrue(cs.sendMessage(3, "after quit", 2));
		for(Message m:cs.cm.chats.get(2).history){
			System.out.println(m.content);
		}
	}

}
