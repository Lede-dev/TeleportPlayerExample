package me.lede.teleportplayer.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.lede.teleportplayer.Main;
import me.lede.teleportplayer.utils.Ticket;

public class GetTicket implements CommandExecutor{

	@SuppressWarnings("unused")
	private Main plugin;
	
	public GetTicket(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("getticket").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lebel, String[] arg) {
		
		if (!(sender instanceof Player)) return true; //sender가 플레이어가 아니라면 종료합니다.
		
		Player p = (Player) sender;

		p.getInventory().addItem(Ticket.getTicket()); // 플레이어에게 이동 아이템을 지급합니다.
		
		return true;
	}
	
	
}
