package me.lede.teleportplayer.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.lede.teleportplayer.Main;
import me.lede.teleportplayer.utils.Ticket;
import me.lede.teleportplayer.utils.Utils;

public class TeleportPlayer implements CommandExecutor{

	@SuppressWarnings("unused")
	private Main plugin;
	
	public TeleportPlayer(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("teleportplayer").setExecutor(this);
	}
	
	
	/**
	 * 이동 커맨드
	 * 커맨드: teleportplayer, 이동, 티피
	 * 펄미션: user.teleportplayer.cmd
	 * ./teleportplayer [target]
	 * ./이동 [타겟]
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		
		if (!(sender instanceof Player)) return true; //sender가 플레이어가 아니라면 종료합니다. 
		
		Player p = (Player) sender;
		
		if (arg.length == 0) return true; // 상대 플레이어를 입력받지 않았다면 종료합니다.
		
		if (arg.length > 1) return true; // 인자를 더 많이 입력하였다면 종료합니다.
		
		teleport(p, Bukkit.getPlayer(arg[0])); //String으로 입력받은 플레이어를 Player로 Casting 합니다.
		
		
		return true;
	}
	
	/**
	 * 명령어가 정상적으로 입력되었다면 실행합니다.
	 * @param p : 플레이어
	 */
	private void teleport(Player p, Player target) {
		
		for (ItemStack item : p.getInventory().getContents()) { //플레이어 인벤토리의 아이템을 가져옵니다.
			
			try {
				
				if (item.getItemMeta().getDisplayName().equals(Ticket.TICKET_NAME)) { // 이동주문서 아이템과 이름이 같은지 체크합니다.
					p.getInventory().remove(item); // 티켓 아이템을 제거합니다.
					item.setAmount(item.getAmount()-1); //아이템의 개수를 1개 감소시킵니다.
					p.getInventory().addItem(item); //개수를 감소시킨 아이템을 지급합니다.
					p.teleport(target); //플레이어를 이동시킵니다.
					p.sendMessage(Utils.chat("&a이동을 완료하였습니다.")); //메세지를 출력합니다.
					return; //함수의 실행을 종료합니다.
				}
				
			}
			catch(Exception ex) {
				//이름 체크중 오류 발생시 다음 루프로 넘어갑니다. continue;
				continue; //명시하지 않아도 다음 루프로 넘어갑니다. 이해를 돕기 위해 명시하였습니다.
			}
			
		}
		
		p.sendMessage(Utils.chat("&c이동 아이템이 부족합니다.")); //위에서 함수가 종료되지 않았다면, 아이템 미보유 메세지를 출력합니다.
	}
	
}
