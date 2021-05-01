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

public class ComprarEncantamentos implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void aoClicarInventario(InventoryClickEvent e) {
		if (!e.getInventory().getTitle().equals("Perks - Encantamentos")) return;
		e.setCancelled(true);
		if (!e.getClickedInventory().getTitle().equals("Perks - Encantamentos")) return;
		if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
		if (!(e.getWhoClicked() instanceof Player)) return;
		Player p = (Player) e.getWhoClicked();
		if (e.getSlot() == 18) {
			Bukkit.dispatchCommand(p, "perks");
			p.updateInventory();
			return;
		}
		if (e.getSlot() != 11 && e.getSlot() != 12 && e.getSlot() != 13 && e.getSlot() != 15) return;
		if (e.getClick() != ClickType.LEFT && e.getClick() != ClickType.RIGHT) return;
		p.closeInventory();
		if (e.getSlot() != 15 && PerksAPI.hasSpecificPerk(p.getName(), PerksName.LiberacaoHabilidosa1) || PerksAPI.hasSpecificPerk(p.getName(), PerksName.LiberacaoHabilidosa2) || PerksAPI.hasSpecificPerk(p.getName(), PerksName.LiberacaoHabilidosa3)){
			p.sendMessage("§cVocê já tem uma perk ativa deste tipo.");
			return;
		}else if (e.getSlot() == 15 && PerksAPI.hasSpecificPerk(p.getName(), PerksName.SorteDoConhecimento)){
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
				if (Main.economy.getBalance(p.getName()) < PerksAPI.calcularDesconto(350000.0, desconto)) {
					p.sendMessage("§cVocê não possui coins suficientes para comprar esta perk.");
					return;
				}
				Main.economy.withdrawPlayer(p.getName(), PerksAPI.calcularDesconto(350000.0, desconto));
			}else if (e.getClick() == ClickType.RIGHT) {
				if (CashMethods.getCash(p.getName()) < PerksAPI.calcularDesconto(125.0, desconto)) {
					p.sendMessage("§cVocê não possui cash suficiente para comprar esta perk.");
					return;
				}
				CashMethods.removeCash(p.getName(), PerksAPI.calcularDesconto(125.0, desconto));
			}
			
			PerksAPI.setSpecificPerk(p.getName(), PerksName.LiberacaoHabilidosa1, System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(3));
			p.sendMessage("§aSucesso! Você comprou a perk §2Liberação Habilidosa §8(Lvl. 1)§a.");
			break;
		case 12:
			if (e.getClick() == ClickType.LEFT) {
				if (Main.economy.getBalance(p.getName()) < PerksAPI.calcularDesconto(700000.0, desconto)) {
					p.sendMessage("§cVocê não possui coins suficientes para comprar esta perk.");
					return;
				}
				Main.economy.withdrawPlayer(p.getName(), PerksAPI.calcularDesconto(700000.0, desconto));
			}else if (e.getClick() == ClickType.RIGHT) {
				if (CashMethods.getCash(p.getName()) < PerksAPI.calcularDesconto(250.0, desconto)) {
					p.sendMessage("§cVocê não possui cash suficiente para comprar esta perk.");
					return;
				}
				CashMethods.removeCash(p.getName(), PerksAPI.calcularDesconto(250.0, desconto));
			}
			
			PerksAPI.setSpecificPerk(p.getName(), PerksName.LiberacaoHabilidosa2, System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(3));
			p.sendMessage("§aSucesso! Você comprou a perk §2Liberação Habilidosa §8(Lvl. 2)§a.");
			break;
		case 13:
			if (e.getClick() == ClickType.LEFT) {
				if (Main.economy.getBalance(p.getName()) < PerksAPI.calcularDesconto(1050000.0, desconto)) {
					p.sendMessage("§cVocê não possui coins suficientes para comprar esta perk.");
					return;
				}
				Main.economy.withdrawPlayer(p.getName(), PerksAPI.calcularDesconto(1050000.0, desconto));
			}else if (e.getClick() == ClickType.RIGHT) {
				if (CashMethods.getCash(p.getName()) < PerksAPI.calcularDesconto(375.0, desconto)) {
					p.sendMessage("§cVocê não possui cash suficiente para comprar esta perk.");
					return;
				}
				CashMethods.removeCash(p.getName(), PerksAPI.calcularDesconto(375.0, desconto));
			}
			
			PerksAPI.setSpecificPerk(p.getName(), PerksName.LiberacaoHabilidosa3, System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(3));
			p.sendMessage("§aSucesso! Você comprou a perk §2Liberação Habilidosa §8(Lvl. 3)§a.");
			break;
		case 15:
			if (e.getClick() == ClickType.LEFT) {
				if (Main.economy.getBalance(p.getName()) < PerksAPI.calcularDesconto(950000.0, desconto)) {
					p.sendMessage("§cVocê não possui coins suficientes para comprar esta perk.");
					return;
				}
				Main.economy.withdrawPlayer(p.getName(), PerksAPI.calcularDesconto(950000.0, desconto));
			}else if (e.getClick() == ClickType.RIGHT) {
				if (CashMethods.getCash(p.getName()) < PerksAPI.calcularDesconto(275.0, desconto)) {
					p.sendMessage("§cVocê não possui cash suficiente para comprar esta perk.");
					return;
				}
				CashMethods.removeCash(p.getName(), PerksAPI.calcularDesconto(275.0, desconto));
			}
			
			PerksAPI.setSpecificPerk(p.getName(), PerksName.SorteDoConhecimento, System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5));
			p.sendMessage("§aSucesso! Você comprou a perk §9Sorte do Conhecimento §8(Lvl. 1)§a.");
			break;
		}
	}
}
