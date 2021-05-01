package rodrigo.rperks.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import rodrigo.rperks.apis.ItemBuilder;
import rodrigo.rperks.apis.PerksAPI;
import rodrigo.rperks.apis.PerksName;

public class Perks implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String lbl, String[] args) {
		if (!(s instanceof Player)) {
			s.sendMessage("§cApenas jogadores podem executar este comando.");
			return false;
		}
		Player p = (Player) s;
		if (args.length >= 1 && args[0].equalsIgnoreCase("tempo")) {
			if (!PerksAPI.hasActivePerk(p.getName())) {
				p.sendMessage("§cVocê não tem nenhuma perk ativa.");
				return false;
			}
			p.sendMessage("");
			p.sendMessage(" §eInformações:");
			p.sendMessage("");
			if (PerksAPI.hasSpecificPerk(p.getName(), PerksName.LiberacaoHabilidosa3)) p.sendMessage("§f   ▪ §2Liberação Habilidosa §8(Lvl. 3) §7- §f" + PerksAPI.getTempo(p.getName(), PerksName.LiberacaoHabilidosa3));
			if (PerksAPI.hasSpecificPerk(p.getName(), PerksName.LiberacaoHabilidosa2)) p.sendMessage("§f   ▪ §2Liberação Habilidosa §8(Lvl. 2) §7- §f" + PerksAPI.getTempo(p.getName(), PerksName.LiberacaoHabilidosa2));
			if (PerksAPI.hasSpecificPerk(p.getName(), PerksName.LiberacaoHabilidosa1)) p.sendMessage("§f   ▪ §2Liberação Habilidosa §8(Lvl. 1) §7- §f" + PerksAPI.getTempo(p.getName(), PerksName.LiberacaoHabilidosa1));
			if (PerksAPI.hasSpecificPerk(p.getName(), PerksName.SorteDoConhecimento)) p.sendMessage("§f   ▪ §9Sorte do Conhecimento §8(Lvl. 1) §7- §f" + PerksAPI.getTempo(p.getName(), PerksName.SorteDoConhecimento));
			if (PerksAPI.hasSpecificPerk(p.getName(), PerksName.AprimoramentoImpetuoso3)) p.sendMessage("§f   ▪ §cAprimoramento Impetuoso §8(Lvl. 3) §7- §f" + PerksAPI.getTempo(p.getName(), PerksName.AprimoramentoImpetuoso3));
			if (PerksAPI.hasSpecificPerk(p.getName(), PerksName.AprimoramentoImpetuoso2)) p.sendMessage("§f   ▪ §cAprimoramento Impetuoso §8(Lvl. 2) §7- §f" + PerksAPI.getTempo(p.getName(), PerksName.AprimoramentoImpetuoso2));
			if (PerksAPI.hasSpecificPerk(p.getName(), PerksName.AprimoramentoImpetuoso1)) p.sendMessage("§f   ▪ §cAprimoramento Impetuoso §8(Lvl. 1) §7- §f" + PerksAPI.getTempo(p.getName(), PerksName.AprimoramentoImpetuoso1));
			if (PerksAPI.hasSpecificPerk(p.getName(), PerksName.ImpetoGlorioso3)) p.sendMessage("§f   ▪ §6Ímpeto Glorioso §8(Lvl. 3) §7- §f" + PerksAPI.getTempo(p.getName(), PerksName.ImpetoGlorioso3));
			if (PerksAPI.hasSpecificPerk(p.getName(), PerksName.ImpetoGlorioso2)) p.sendMessage("§f   ▪ §6Ímpeto Glorioso §8(Lvl. 2) §7- §f" + PerksAPI.getTempo(p.getName(), PerksName.ImpetoGlorioso2));
			if (PerksAPI.hasSpecificPerk(p.getName(), PerksName.ImpetoGlorioso1)) p.sendMessage("§f   ▪ §6Ímpeto Glorioso §8(Lvl. 1) §7- §f" + PerksAPI.getTempo(p.getName(), PerksName.ImpetoGlorioso1));
			p.sendMessage("");
			return false;
		}
		
		Inventory perks = Bukkit.createInventory(null, 3 * 9, "Perks - Início");
		perks.setItem(11, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).name("§2Perks de Encantamentos").lore("§7Encontre diversas Perks que vão auxiliar", "§7você no decorrer de sua jogabilidade.", "", "§ePerks Disponíveis:", "", "§f  ▪ §2Liberação Habilidosa §8(Lvl. 1)", "§f  ▪ §2Liberação Habilidosa §8(Lvl. 2)", "§f  ▪ §2Liberação Habilidosa §8(Lvl. 3)", "§f  ▪ §9Sorte do Conhecimento §8(Lvl. 1)", "", "§aClique para abrir esta categoria.").head("http://textures.minecraft.net/texture/18950d1a0b8ccf063e7519fe369cad15cce32056fa472a99aa30b5fb448ff614").build());
		perks.setItem(13, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).name("§cPerks de Itens Especiais").lore("§7Encontre diversas Perks que vão auxiliar", "§7você no decorrer de sua jogabilidade.", "", "§ePerks Disponíveis:", "", "§f  ▪ §cAprimoramento Impetuoso §8(Lvl. 1)", "§f  ▪ §cAprimoramento Impetuoso §8(Lvl. 2)", "§f  ▪ §cAprimoramento Impetuoso §8(Lvl. 3)", "", "§aClique para abrir esta categoria.").head("http://textures.minecraft.net/texture/a0e16b9c63ac547ff937a2cbf80e951736a1492d7eff3efa0216a3bcce6ca2ec").build());
		perks.setItem(15, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).name("§6Perks de Ligas").lore("§7Encontre diversas Perks que vão auxiliar", "§7você no decorrer de sua jogabilidade.", "", "§ePerks Disponíveis:", "", "§f  ▪ §6Ímpeto Glorioso §8(Lvl.1)", "§f  ▪ §6Ímpeto Glorioso §8(Lvl. 2)", "§f  ▪ §6Ímpeto Glorioso §8(Lvl. 3)", "", "§aClique para abrir esta categoria.").head("http://textures.minecraft.net/texture/b7fc5d1ca519d0a8ceff3ca8aa4a92908dbb5c033e1b82df1373cb6fc8564f").build());
		p.openInventory(perks);
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1f, 10f);
		return false;
	}
}
