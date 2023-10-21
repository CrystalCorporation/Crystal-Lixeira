package Lixeira;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public void onLoad() {

	}

	public void onEnable() {
		// Registra na classe this (Main / a classe atual) os comandos criados na mesma.
		getCommand("lixo").setExecutor(this);
	}

	public void onDisable() {
	}

	@Override
	public boolean onCommand(CommandSender s, Command c, String lb, String[] a) {

		// Cria uma variavel para o jogador.
		Player p = (Player) s;

		// Verifica se não é um jogar, caso não seja ele retorna true; ou seja não
		// retorna nada.
		// (funciona para todos comandos executados pelo não jogador)
		if (!(s instanceof Player)) {
			return true;
		}

		// Cria um comando com o nome de "lixo" para abrir um inventário completamente
		// vázio.
		// Se o jogador colocar um item nele e depois fechar, o item irá sumir
		if (c.getName().equalsIgnoreCase("lixo")) {

			// Cria um inventário / menu / gui
			Inventory inv = Bukkit.createInventory(p, 9 * 6, "§8Lixeira");

			// Envia uma mensagem para o jogador.
			p.sendMessage(ChatColor.RED + "(!) " + ChatColor.GRAY + "Lixeira aberta com sucesso!");

			// Coleta a Localização do jogador e executa um som.
			p.playSound(p.getLocation(), Sound.NOTE_PLING, 1, 1);

			// Abre o inventário ( inv ) para o jogador.
			p.openInventory(inv);
		}

		return false;
	}

}