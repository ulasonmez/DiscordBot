package listeners;

import java.awt.Color;

import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import com.vdurmont.emoji.EmojiParser;

public class suggestion implements MessageCreateListener{
	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		ServerTextChannel SVC = event.getChannel().asServerTextChannel().get();
		Message message = event.getMessage();
		if(SVC.getName().equals("suggestions")) {
			if(message.getContent().startsWith(".suggestion")) {
				String messageRenew = message.getContent();
				messageRenew=messageRenew.replaceAll(".suggestion", "");
				event.deleteMessage();
				if(messageRenew.length()!=0 && messageRenew.length()>5) {
					new MessageBuilder().setEmbed(new EmbedBuilder()
							.setTitle("PLUGIN SUGGESTION")
							.setDescription("**Idea Owner**"+"\n"+event.getMessageAuthor().getName()+"\n\n**Plugin Idea**\n"+messageRenew)
							.setThumbnail(event.getMessageAuthor().getAvatar())
							.setColor(new Color(0,255,0))).send(event.getChannel());
				}
			}
			else {
				if(event.getMessageAuthor().getName().equalsIgnoreCase("blumebot")) return;
				event.deleteMessage();
			}
			if(event.getMessageAuthor().getName().equalsIgnoreCase("blumebot")) {
				message.addReaction(EmojiParser.parseToUnicode(":white_check_mark:"));
				message.addReaction(EmojiParser.parseToUnicode(":x:"));
			}
		}
	}
}
