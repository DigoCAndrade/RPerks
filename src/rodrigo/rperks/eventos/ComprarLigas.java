package rodrigo.rperks.eventos;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

import rodrigo.rcash.mysql.CashMethods;
import rodrigo.rperks.Main;
import rodrigo.rperks.apis.PerksAPI;
import rodrigo.rperks.apis.PerksName;

public class ComprarLigas implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void aoClicarInventario(InventoryClickEvent e) {
		if (!e.getInventory().getTitle().equals("Perks - Ligas")) return;
		e.setCancelled(true);
		if (!e.getClickedInventory().getTitle().equals("Perks - Ligas")) return;
		if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
		if (!(e.getWhoClicked() instanceof Player)) return;
		Player p = (Player) e.getWhoClicked();
		if (e.getSlot() == 18) {
			Bukkit.dispatchCommand(p, "perks");
			p.updateInventory();
			return;
		}
		if (e.getSlot() != 11 && e.getSlot() != 13 && e.getSlot() != 15) return;
		if (e.getClick() != ClickType.LEFT && e.getClick() != ClickType.RIGHT) return;
		p.closeInventory();
		if (PerksAPI.hasSpecificPerk(p.getName(), PerksName.ImpetoGlorioso1) || PerksAPI.hasSpecificPerk(p.getName(), PerksName.ImpetoGlorioso2) || PerksAPI.hasSpecificPerk(p.getName(), PerksName.ImpetoGlorioso3)) {
			p.sendMessage("§cVocê já tem uma perk ativa deste tipo.");
			return;
		}
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
		switch (e.getRawSlot()) {
		case 11:
			if (e.getClick() == ClickType.LEFT) {
				if (Main.economy.getBalance(p.getName()) < PerksAPI.calcularDesconto(650000.0, desconto)) {
					p.sendMessage("§cVocê não possui coins suficientes para comprar esta perk.");
					return;
				}
				Main.economy.withdrawPlayer(p.getName(), PerksAPI.calcularDesconto(650000.0, desconto));
			}else if (e.getClick() == ClickType.RIGHT) {
				if (CashMethods.getCash(p.getName()) < PerksAPI.calcularDesconto(175.0, desconto)) {
					p.sendMessage("§cVocê não possui cash suficiente para comprar esta perk.");
					return;
				}
				CashMethods.removeCash(p.getName(), PerksAPI.calcularDesconto(175.0, desconto));
			}
			
			PerksAPI.setSpecificPerk(p.getName(), PerksName.ImpetoGlorioso1, System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5));
			p.sendMessage("§aSucesso! Você comprou a perk §6Impeto Glorioso §8(Lvl. 1)§a.");
			break;
		case 13:
			if (e.getClick() == ClickType.LEFT) {
				if (Main.economy.getBalance(p.getName()) < PerksAPI.calcularDesconto(1300000.0, desconto)) {
					p.sendMessage("§cVocê não possui coins suficientes para comprar esta perk.");
					return;
				}
				Main.economy.withdrawPlayer(p.getName(), PerksAPI.calcularDesconto(1300000.0, desconto));
			}else if (e.getClick() == ClickType.RIGHT) {
				if (CashMethods.getCash(p.getName()) < PerksAPI.calcularDesconto(350.0, desconto)) {
					p.sendMessage("§cVocê não possui cash suficiente para comprar esta perk.");
					return;
				}
				CashMethods.removeCash(p.getName(), PerksAPI.calcularDesconto(350.0, desconto));
			}
			
			PerksAPI.setSpecificPerk(p.getName(), PerksName.ImpetoGlorioso2, System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5));
			p.sendMessage("§aSucesso! Você comprou a perk §6Impeto Glorioso §8(Lvl. 2)§a.");
			break;
		case 15:
			if (e.getClick() == ClickType.LEFT) {
				if (Main.economy.getBalance(p.getName()) < PerksAPI.calcularDesconto(1950000.0, desconto)) {
					p.sendMessage("§cVocê não possui coins suficientes para comprar esta perk.");
					return;
				}
				Main.economy.withdrawPlayer(p.getName(), PerksAPI.calcularDesconto(1950000.0, desconto));
			}else if (e.getClick() == ClickType.RIGHT) {
				if (CashMethods.getCash(p.getName()) < PerksAPI.calcularDesconto(525.0, desconto)) {
					p.sendMessage("§cVocê não possui cash suficiente para comprar esta perk.");
					return;
				}
				CashMethods.removeCash(p.getName(), PerksAPI.calcularDesconto(525.0, desconto));
			}
			
			PerksAPI.setSpecificPerk(p.getName(), PerksName.ImpetoGlorioso3, System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5));
			p.sendMessage("§aSucesso! Você comprou a perk §6Impeto Glorioso §8(Lvl. 3)§a.");
			break;
		}
	}
}
