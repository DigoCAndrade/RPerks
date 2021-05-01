package rodrigo.rperks.eventos;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import rodrigo.rperks.apis.PerksName;

public class PlayerPerkRecive extends Event{

	private static HandlerList handlers = new HandlerList();
	
	String recebidor;
	String enviador;
	PerksName perk;
	
	public PlayerPerkRecive(String recebidor, PerksName perk) {
		this.recebidor = recebidor;
		this.perk = perk;
	}
	
	public String getRecebidor() {
		return recebidor;
	}
	
	public PerksName getPerk() {
		return perk;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}

}
