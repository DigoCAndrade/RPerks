package rodrigo.rperks.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import rodrigo.rperks.apis.ItemBuilder;
import rodrigo.rperks.apis.PerksAPI;

public class SelecionarCategoria implements Listener{
	
	@EventHandler
	public void aoClicarInventario(InventoryClickEvent e) {
		if (!e.getInventory().getTitle().equals("Perks - Início")) return;
		e.setCancelled(true);
		if (!e.getClickedInventory().getTitle().equals("Perks - Início")) return;
		if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
		if (!(e.getWhoClicked() instanceof Player)) return;
		Player p = (Player) e.getWhoClicked();
		int desconto = 0;
		if (p.hasPermission("rshop.mvp+")) {
			desconto = 20;
		} else if (p.hasPermission("rshop.mvp")) {
			desconto = 15;
		} else if (p.hasPermission("rshop.vip+")) {
			desconto = 10;
		} else if (p.hasPermission("rshop.vip")) {
			desconto = 5;
		}
		ItemStack voltar = new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).name("§cVoltar").head("http://textures.minecraft.net/texture/bd69e06e5dadfd84e5f3d1c21063f2553b2fa945ee1d4d7152fdc5425bc12a9").build();
		switch (e.getSlot()) {
		case 11:
			Inventory encantamentos = Bukkit.createInventory(null, 3 * 9, "Perks - Encantamentos");
			encantamentos.setItem(11, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).name("§2Liberação Habilidosa §8(Lvl. 1)").lore("§fDuração: §73 minutos", "", "§7Com esta perk ativada você libera todos ", "§7os livros encantados do §6VIP§7.", "", PerksAPI.custoMoneyCash(125.0, 350000.0, desconto), "").head("http://textures.minecraft.net/texture/d53fa1b57e4f784d16e5a2daa2f746b2ecfe624ccd74a4d4acc6a2e6a083f54e").build());
			encantamentos.setItem(12, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).name("§2Liberação Habilidosa §8(Lvl. 2)").lore("§fDuração: §73 minutos", "", "§7Com esta perk ativada você libera todos ", "§7os livros encantados do §6VIP§b+§7.", "", PerksAPI.custoMoneyCash(250.0, 700000.0, desconto), "").head("http://textures.minecraft.net/texture/36505b1befba242170a46e8947b52aea54a59060f3e1c36f21cebb44690f8b0c").build());
			encantamentos.setItem(13, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).name("§2Liberação Habilidosa §8(Lvl. 3)").lore("§fDuração: §73 minutos", "", "§7Com esta perk ativada você libera todos ", "§7os livros encantados do §bMVP§7.", "", PerksAPI.custoMoneyCash(375.0, 1050000.0, desconto), "").head("http://textures.minecraft.net/texture/8be2baf40fd85eb573fe5b2e5b6c8817cf50f883d95769415807ab07288a47cd").build());
			encantamentos.setItem(15, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).name("§9Sorte do Conhecimento §8(Lvl. 1)").lore("§fDuração: §75 minutos", "", "§7Com esta perk ativada ao minerar no mundo ", "§7de mineração você ganha §f3x §7mais", "§9Pedras do Conhecimento§7.", "", PerksAPI.custoMoneyCash(275.0, 950000.0, desconto), "").head("http://textures.minecraft.net/texture/e87cfcce6724cf7382d6c65232cd66696d426461c82161a78f2224ca23c31c").build());
			encantamentos.setItem(18, voltar);
			p.openInventory(encantamentos);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1f, 10f);
			break;
		case 13:
			Inventory especiais = Bukkit.createInventory(null, 3 * 9, "Perks - Itens Especiais");
			especiais.setItem(11, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).name("§cAprimoramento Impetuoso §8(Lvl. 1)").lore("§fDuração: §73 minutos", "", "§7Com esta perk ativada os itens especiais", "§7ficam §f2x §7níveis mais fortes.", "", "§e Aprimoramentos:", "", "§9   Olho Revelador: §810s §7e §830b §e➟§8 15s §7e §840b", "§d   Olho Divino: §810s §e➟§8 15s", "§b   Gelo Verdadeiro: §83s §7e §84b §e➟§8 4s §7e §86b", "§6   Fogo Primordial: §85s §7e §84b §e➟§8 6s §7e §86b", "§4   Escudo Visionário: §85m §e➟§8 7mb", "§8   Aspecto Noturno: §85s §7e §84b §e➟§8 6s §7e §86b", "§6   Centelha Final: §84b §7e §81.3a §e➟§8 4b §7e §81.4a", "", PerksAPI.custoCash(250.0, desconto), "").head("http://textures.minecraft.net/texture/d0d549f367abcbea39252ba275f5c3c1cb16945fcf472123ee26d9c9dd40e").build());
			especiais.setItem(13, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).name("§cAprimoramento Impetuoso §8(Lvl. 2)").lore("§fDuração: §73 minutos", "", "§7Com esta perk ativada ao matar um player", "§7você ganha §f2x §7mais pontos de liga.", "", "§e Aprimoramentos:", "", "§9   Olho Revelador: §810s §7e §830b §e➟§8 20s §7e §856b", "§d   Olho Divino: §810s §e➟§8 20s", "§b   Gelo Verdadeiro: §83s §7e §84b §e➟§8 5s §7e §88b", "§c   Fogo Primordial: §85s §7e §84b §e➟§8 7s §7e §88b", "§4   Escudo Visionário: §85m §e➟§8 9m", "§8   Aspecto Noturno: §85s §7e §84b §e➟§8 7s §7e §88b", "§6   Centelha Final: §84b §7e §81.3a §e➟§8 6b §7e §81.5a", "", PerksAPI.custoCash(500.0, desconto), "").head("http://textures.minecraft.net/texture/b9c8acc6ce7c45a5b9d977e24821d87841731b55a13b5866b1edff1abb73a1").build());
			especiais.setItem(15, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).name("§cAprimoramento Impetuoso §8(Lvl. 3)").lore("§fDuração: §73 minutos", "", "§7Com esta perk ativada ao matar um player", "§7você ganha §f3x §7mais pontos de liga.", "", "§e Aprimoramentos:", "", "§9   Olho Revelador: §810s §7e §830b §e➟§8 25s §7e §872b", "§d   Olho Divino: §810s §e➟§8 25s", "§b   Gelo Verdadeiro: §83s §7e §84b §e➟§8 6s §7e §810b", "§c   Fogo Primordial: §85s §7e §84b §e➟§8 8s §7e §810b", "§4   Escudo Visionário: §85m §e➟§8 11m", "§8   Aspecto Noturno: §85s §7e §84b §e➟§8 8s §7e §810b", "§6   Centelha Final: §84b §7e §81.3a §e➟§8 8b §7e §81.6a", "", PerksAPI.custoCash(750.0, desconto), "").head("http://textures.minecraft.net/texture/ba1ec7975240ebad1ccede3426cfbaba0b04a5b2b2ea1e241cf263f3bd22be5").build());
			especiais.setItem(18, voltar);
			p.openInventory(especiais);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1f, 10f);
			break;
		case 15:
			Inventory ligas = Bukkit.createInventory(null, 3 * 9, "Perks - Ligas");
			ligas.setItem(11, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).name("§6Ímpeto Glorioso §8(Lvl. 1)").lore("§fDuração: §75 minutos", "", "§7Com esta perk ativada ao matar um player ", "§7você ganha §f2x §7mais pontos de liga.", "", PerksAPI.custoMoneyCash(175.0, 650000.0, desconto), "").head("http://textures.minecraft.net/texture/d7469bbac7d73ff7dfd29ecdf8b1493fc2367b2b5f496a0538966ac9ba349df").build());
			ligas.setItem(13, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).name("§6Ímpeto Glorioso §8(Lvl. 2)").lore("§fDuração: §75 minutos", "", "§7Com esta perk ativada ao matar um player ", "§7você ganha §f3x §7mais pontos de liga.", "", PerksAPI.custoMoneyCash(350.0, 1300000.0, desconto), "").head("http://textures.minecraft.net/texture/c6f94852eac03ef5f3c16c6ae6d821eda2f7ed98790463c249b9205142126c").build());
			ligas.setItem(15, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).name("§6Ímpeto Glorioso §8(Lvl. 3)").lore("§fDuração: §75 minutos", "", "§7Com esta perk ativada ao matar um player ", "§7você ganha §f4x §7mais pontos de liga.", "", PerksAPI.custoMoneyCash(525.0, 1950000.0, desconto), "").head("http://textures.minecraft.net/texture/4aec4bed1410fbd4c19f8c3ca5342344b584ef18521a42684da915964ee155").build());
			ligas.setItem(18, voltar);
			p.openInventory(ligas);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1f, 10f);
			break;
		}
	}
}
