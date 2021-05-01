package rodrigo.rperks.apis;

import java.util.Date;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import rodrigo.numberformatter.NumberFormatter;
import rodrigo.rcash.Main;
import rodrigo.rperks.eventos.PlayerPerkExpire;
import rodrigo.rperks.eventos.PlayerPerkRecive;

public class PerksAPI {
	
	private static HashMap<String, HashMap<PerksName, Long>> perks = new HashMap<>();

	public static String getTempo(String player, PerksName perk) {
		HashMap<PerksName, Long> hash = perks.get(player);
		Date vencimento = new Date(hash.get(perk));
		Date atual = new Date();
        long variacao =  vencimento.getTime() - atual.getTime();
        long varsegundos = variacao / 1000L % 60L;
        long varminutos = variacao / 60000L % 60L;
        String segundos = String.valueOf(varsegundos);
        String minutos = String.valueOf(varminutos);
        if (varsegundos <= 0) return "§cPerk expirou.";
        return minutos.equals("0") ? "§f" + segundos + " §7segundos." : "§f" + minutos + " §7minutos §f" + segundos + " §7segundos.";
	}
	
	public static Boolean hasActivePerk(String player) {
		if (perks.containsKey(player)) return true;
		return false;
	}
	
	public static Boolean hasSpecificPerk(String player, PerksName perk) {
		if (!hasActivePerk(player)) return false;
		HashMap<PerksName, Long> hash = perks.get(player);
		if (hash.containsKey(perk)) return true;
		return false;
	}
	
	public static void setSpecificPerk(String player, PerksName perk, Long tempo) {
		HashMap<PerksName, Long> hash = (perks.containsKey(player)) ? perks.get(player) : new HashMap<>();
		hash.put(perk, tempo);
		perks.put(player, hash);
		Bukkit.getServer().getPluginManager().callEvent(new PlayerPerkRecive(player, perk));
        long cooldown = ((tempo - System.currentTimeMillis())/1000) * 20;
		new BukkitRunnable() {
			
			@Override
			public void run() {
				if (!hasSpecificPerk(player, perk)) return;
				removeSpecificPerk(player, perk);
				Player p = Bukkit.getPlayer(player);
				if (p != null) p.sendMessage("§cO tempo de sua perk acabou, agora você pode comprar outra.");
			}
		}.runTaskLater(Main.instance, cooldown);
	}
	
	public static void removeSpecificPerk(String player, PerksName perk) {
		HashMap<PerksName, Long> hash = perks.get(player);
		hash.remove(perk);
		if (hash.isEmpty()) perks.remove(player);
		if (!hash.isEmpty()) perks.put(player, hash);
		Bukkit.getServer().getPluginManager().callEvent(new PlayerPerkExpire(player, perk));
	}
	
	public static void removeAllPerks(String player) {
		perks.remove(player);
	}
	
	public static Double calcularDesconto(Double preco, Integer desconto) {
		double descontagem = (preco * desconto) / 100;
		return preco - descontagem;
	}
	
	public static String custoCash(Double preco, Integer desconto) {
		if (desconto != 0) {
			return "  §f▪ §7Custo: §6" + NumberFormatter.formatShort(calcularDesconto(preco, desconto)) + " Cash §7(" + desconto + "%) ";
		}
		return "  §f▪ §7Custo: §6" + NumberFormatter.formatShort(calcularDesconto(preco, desconto)) + " Cash ";
	}
	
	public static String custoMoneyCash(Double cash, Double money, Integer desconto) {
		if (desconto != 0) {
			return "  §f▪ §7Custo: §a" + NumberFormatter.formatShort(calcularDesconto(money, desconto)) + " Coins §7ou §6" + NumberFormatter.formatShort(calcularDesconto(cash, desconto)) + " §6Cash §7(" + desconto + "%) ";
		}
		return "  §f▪ §7Custo: §a" + NumberFormatter.formatShort(calcularDesconto(money, desconto)) + " Coins §7ou §6" + NumberFormatter.formatShort(calcularDesconto(cash, desconto)) + " §6Cash ";
	}
}