package rodrigo.rperks;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import rodrigo.rperks.apis.PerksName;
import rodrigo.rperks.comandos.Perks;
import rodrigo.rperks.eventos.ComprarEncantamentos;
import rodrigo.rperks.eventos.ComprarEspeciais;
import rodrigo.rperks.eventos.ComprarLigas;
import rodrigo.rperks.eventos.PlayerPerkExpire;
import rodrigo.rperks.eventos.PlayerPerkRecive;
import rodrigo.rperks.eventos.SelecionarCategoria;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Main extends JavaPlugin implements Listener{

	public static Permission permission = null;
	public static Economy economy = null;
	public static Chat chat = null;

	@Override
	public void onEnable() {
		setupEconomy();
		getCommand("perks").setExecutor(new Perks());
		Bukkit.getPluginManager().registerEvents(new SelecionarCategoria(), this);
		Bukkit.getPluginManager().registerEvents(new ComprarEncantamentos(), this);
		Bukkit.getPluginManager().registerEvents(new ComprarEspeciais(), this);
		Bukkit.getPluginManager().registerEvents(new ComprarLigas(), this);
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null) economy = economyProvider.getProvider();
		return (economy != null);
	}
	
	@EventHandler
	public void aoReceberPerk(PlayerPerkRecive e) {
		if (e.getPerk().equals(PerksName.LiberacaoHabilidosa1) || e.getPerk().equals(PerksName.LiberacaoHabilidosa2) || e.getPerk().equals(PerksName.LiberacaoHabilidosa3)) {
			switch (e.getPerk()) {
			case LiberacaoHabilidosa1:
				PermissionsEx.getUser(e.getRecebidor()).addPermission("rencantar.vip");
				break;
			case LiberacaoHabilidosa2:
				PermissionsEx.getUser(e.getRecebidor()).addPermission("rencantar.vip+");
				break;
			case LiberacaoHabilidosa3:
				PermissionsEx.getUser(e.getRecebidor()).addPermission("rencantar.mvp");
				break;

			default: break;
			}
		}
	}
	
	@EventHandler
	public void aoExpirarPerk(PlayerPerkExpire e) {
		if (e.getPerk().equals(PerksName.LiberacaoHabilidosa1) || e.getPerk().equals(PerksName.LiberacaoHabilidosa2) || e.getPerk().equals(PerksName.LiberacaoHabilidosa3)) {
			switch (e.getPerk()) {
			case LiberacaoHabilidosa1:
				PermissionsEx.getUser(e.getRecebidor()).removePermission("rencantar.vip");
				break;
			case LiberacaoHabilidosa2:
				PermissionsEx.getUser(e.getRecebidor()).removePermission("rencantar.vip+");
				break;
			case LiberacaoHabilidosa3:
				PermissionsEx.getUser(e.getRecebidor()).removePermission("rencantar.mvp");
				break;

			default: break;
			}
		}
	}
}
