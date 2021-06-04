import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import listeners.messagelistener;

public class Main{

	public static void main(String[] args) {
		String token = "token";

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
        System.out.println("Acildi");
        api.addListener(new messagelistener());
	}
	
}
