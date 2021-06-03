package listeners;

import java.awt.Color;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class messagelistener implements MessageCreateListener{
	Random rand = new Random();
	String[] selamlama = {"iyi!","iyi, senden?","güzel...","keyifler yerinde."};
	public void onMessageCreate(MessageCreateEvent event) {
		Message message = event.getMessage();
		int a = rand.nextInt(255);
		if(message.getContent().equalsIgnoreCase(".naber")) {
			event.getChannel().sendMessage(selamlama[rand.nextInt(selamlama.length)]);
		}
		if(message.getContent().startsWith(".nasýlým")) {
			new MessageBuilder().setEmbed(new EmbedBuilder()
					.setTitle("Oran")
					.setDescription(event.getMessageAuthor().getDisplayName()+" %"+
											(rand.nextInt(100)+1)+" düzeyinde iyisin.")
					.setThumbnail("https://blog.fotografium.com/wp-content/uploads/2017/01/featured-67.png")
					.setColor(new Color(a,a,a))).send(event.getChannel());
		
		}

	}
}
