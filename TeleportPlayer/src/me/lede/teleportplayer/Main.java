package me.lede.teleportplayer;

import org.bukkit.plugin.java.JavaPlugin;

import me.lede.teleportplayer.commands.GetTicket;
import me.lede.teleportplayer.commands.TeleportPlayer;

public class Main extends JavaPlugin{

	
	@Override
	public void onEnable() {
		registCommands();
	}
	
	/**
	 * 커맨드 등록
	 * 커맨드 객체를 생성합니다.
	 */
	private void registCommands() {
		new TeleportPlayer(this);
		new GetTicket(this);
	}
}
