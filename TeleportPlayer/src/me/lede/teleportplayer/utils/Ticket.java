package me.lede.teleportplayer.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Ticket {

	public static final String TICKET_NAME = Utils.chat("&6&l[티켓] &f이동 주문서");
	
	public static ItemStack getTicket() {
		ItemStack item = new ItemStack(Material.PAPER, 1); //ItemStack을 생성합니다.
		ItemMeta meta = item.getItemMeta(); //ItemMeta를 가져옵니다.

		meta.addEnchant(Enchantment.DURABILITY, 1, true); //ItemMeta에 인챈트를 추가합니다.
		
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS); //ItemMeta에 아이템의 인챈트를 가리는 Flag를 추가합니다.
		
		meta.setDisplayName(TICKET_NAME); //ItemMeta에 이름을 설정합니다.
		
		List<String> lore = new ArrayList<String>(); //로어를 생성합니다.
		
		lore.add(Utils.chat("&f아이템을 소모하여 다른 플레이어에게 텔레포트할 수 있습니다.")); //로어를 추가합니다.
		lore.add(Utils.chat("&e/이동 [플레이어]")); //로어를 추가합니다.
		
		meta.setLore(lore); //생성한 로어를 ItemMeta에 설정합니다.
		
		item.setItemMeta(meta); //설정한 ItemMeta를 ItemStack에 적용합니다.
		
		return item; //ItemStack을 반환하여 아이템 생성을 종료합니다.
	}
	
}
