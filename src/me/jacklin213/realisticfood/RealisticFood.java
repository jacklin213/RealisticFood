package me.jacklin213.realisticfood;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RealisticFood extends JavaPlugin implements Listener{
	
	public static RealisticFood plugin;
	public Logger log = Logger.getLogger("Minecraft");
	public UpdateChecker updateChecker;
	
	@Override
	public void onEnable(){
		
		createConfig();
		//Update Checking (Disabled to uploaded to bukkitdev)
		/*Boolean updateCheck = Boolean.valueOf(getConfig().getBoolean("UpdateCheck"));
		 
		this.updateChecker = new UpdateChecker(this, "http://dev.bukkit.org/server-mods/needcombined/files.rss");

		if ((updateCheck) && (this.updateChecker.updateNeeded())) {
			log.info(String.format("[%s] A new update is avalible, Version: %s", getDescription().getName(), this.updateChecker.getVersion()));
			log.info(String.format("[%s] Get it now from: %s", getDescription().getName(), this.updateChecker.getLink()));
		}*/
		
		//Register events
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
		
		log.info(String.format(
				"[%s] Version %s by jacklin213 has been Enabled!",
				getDescription().getName(), getDescription().getVersion()));
	}
	
	@Override
	public void onDisable(){
		log.info(String.format("[%s] Disabled Version %s", getDescription()
				.getName(), getDescription().getVersion()));
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]){
		Player player = (Player) sender;
		if (commandLabel.equalsIgnoreCase("sethunger") && args.length == 1){
			int i = Integer.parseInt(args[0]);
			player.setFoodLevel(i);
			return true;
		}
		if (commandLabel.equalsIgnoreCase("sethealth")){
			int i = Integer.parseInt(args[0]);
			player.setHealth(i);
			return true;
		}
		return false;
	}
	
	@EventHandler
	public void onEat(PlayerItemConsumeEvent event){
		Player player = event.getPlayer();
		ItemStack is = event.getItem();
		int health = player.getHealth();
		int hunger = player.getFoodLevel();
		int foodID = is.getTypeId();
		switch (foodID){
		case 260:
			int AppleModifier = Integer.parseInt(getConfig().getString("Food.Apple.modifier"));
			String AppleHeal = getConfig().getString("Food.Apple.heal");
			if (AppleHeal == "health"){
				if (health + AppleModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + AppleModifier);
				}
			} else {
				if (hunger + AppleModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + AppleModifier);
				}
			};
			break;
		case 393:
			int BakedPotatoModifier = Integer.parseInt(getConfig().getString("Food.BakedPotato.modifier"));
			String BakedPotatoHeal = getConfig().getString("Food.BakedPotato.heal");
			if (BakedPotatoHeal == "health"){
				if (health + BakedPotatoModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + BakedPotatoModifier);
				}
			} else {
				if (hunger + BakedPotatoModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + BakedPotatoModifier);
				}
			};
			break;
		case 297:
			int BreadModifier = Integer.parseInt(getConfig().getString("Food.Bread.modifier"));
			String BreadHeal = getConfig().getString("Food.Bread.heal");
			if (BreadHeal == "health"){
				if (health + BreadModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + BreadModifier);
				}
			} else {
				if (hunger + BreadModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + BreadModifier);
				}
			};
			break;
		case 354:
			int CakeModifier = Integer.parseInt(getConfig().getString("Food.Cake.modifier"));
			String CakeHeal = getConfig().getString("Food.Cake.heal");
			if (CakeHeal == "health"){
				if (health + CakeModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + CakeModifier);
				}
			} else {
				if (hunger + CakeModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + CakeModifier);
				}
			};
			break;
		case 391:
			int CarrotModifier = Integer.parseInt(getConfig().getString("Food.Carrot.modifier"));
			String CarrotHeal = getConfig().getString("Food.Carrot.heal");
			if (CarrotHeal == "health"){
				if (health + CarrotModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + CarrotModifier);
				}
			} else {
				if (hunger + CarrotModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + CarrotModifier);
				}
			};
			break;
		case 366:
			int CookedChickenModifier = Integer.parseInt(getConfig().getString("Food.CookedChicken.modifier"));
			String CookedChickenHeal = getConfig().getString("Food.CookedChicken.heal");
			if (CookedChickenHeal == "health"){
				if (health + CookedChickenModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + CookedChickenModifier);
				}
			} else {
				if (hunger + CookedChickenModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + CookedChickenModifier);
				}
			};
			break;  
		case 350:
			int CookedFishModifier = Integer.parseInt(getConfig().getString("Food.CookedFish.modifierier"));
			String CookedFishHeal = getConfig().getString("Food.CookedFish.heal");
			if (CookedFishHeal == "health"){
				if (health + CookedFishModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + CookedFishModifier);
				}
			} else {
				if (hunger + CookedFishModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + CookedFishModifier);
				}
			};
			break;
		case 320:
			int CookedPorkchopModifier = Integer.parseInt(getConfig().getString("Food.BakedPotato.modifier"));
			String CookedPorkchopHeal = getConfig().getString("Food.BakedPotato.heal");
			if (CookedPorkchopHeal == "health"){
				if (health + CookedPorkchopModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + CookedPorkchopModifier);
				}
			} else {
				if (hunger + CookedPorkchopModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + CookedPorkchopModifier);
				}
			};
			break;
		case 357:
			int CookieModifier = Integer.parseInt(getConfig().getString("Food.Cookie.modifier"));
			String CookieHeal = getConfig().getString("Food.Cookie.heal");
			if (CookieHeal == "health"){
				if (health + CookieModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + CookieModifier);
				}
			} else {
				if (hunger + CookieModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + CookieModifier);
				}
			};
			break;
		case 322:
			int GoldenAppleModifier = Integer.parseInt(getConfig().getString("Food.GoldenApple.modifier"));
			String GoldenAppleHeal = getConfig().getString("Food.GoldenApple.heal");
			if (GoldenAppleHeal == "health"){
				if (health + GoldenAppleModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + GoldenAppleModifier);
				}
			} else {
				if (hunger + GoldenAppleModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + GoldenAppleModifier);
				}
			};
			break;
		case 396:
			int GoldenCarrotModifier = Integer.parseInt(getConfig().getString("Food.GoldenCarrot.modifier"));
			String GoldenCarrotHeal = getConfig().getString("Food.GoldenCarrot.heal");
			if (GoldenCarrotHeal == "health"){
				if (health + GoldenCarrotModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + GoldenCarrotModifier);
				}
			} else {
				if (hunger + GoldenCarrotModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + GoldenCarrotModifier);
				}
			};
			break;
		case 360:
			int MelonModifier = Integer.parseInt(getConfig().getString("Food.Melon.modifier"));
			String MelonHeal = getConfig().getString("Food.Melon.heal");
			if (MelonHeal == "health"){
				if (health + MelonModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + MelonModifier);
				}
			} else {
				if (hunger + MelonModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + MelonModifier);
				}
			};
			break;
		case 282:
			int MushroomStewModifier = Integer.parseInt(getConfig().getString("Food.MushroomStew.modifier"));
			String MushroomStewHeal = getConfig().getString("Food.MushroomStew.heal");
			if (MushroomStewHeal == "health"){
				if (health + MushroomStewModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + MushroomStewModifier);
				}
			} else {
				if (hunger + MushroomStewModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + MushroomStewModifier);
				}
			};
			break;
		case 394:
			int PoisonousPotatoModifier = Integer.parseInt(getConfig().getString("Food.PoisonousPotato.modifier"));
			String PoisonousPotatoHeal = getConfig().getString("Food.PoisonousPotato.heal");
			if (PoisonousPotatoHeal == "health"){
				if (health + PoisonousPotatoModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + PoisonousPotatoModifier);
				}
			} else {
				if (hunger + PoisonousPotatoModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + PoisonousPotatoModifier);
				}
			};
			break;
		case 392:
			int PotatoModifier = Integer.parseInt(getConfig().getString("Food.Potato.modifier"));
			String PotatoHeal = getConfig().getString("Food.Potato.heal");
			if (PotatoHeal == "health"){
				if (health + PotatoModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + PotatoModifier);
				}
			} else {
				if (hunger + PotatoModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + PotatoModifier);
				}
			};
			break;
		case 400:
			int PumpkinPieModifier = Integer.parseInt(getConfig().getString("Food.PumpkinPie.modifier"));
			String PumpkinPieHeal = getConfig().getString("Food.PumpkinPie.heal");
			if (PumpkinPieHeal == "health"){
				if (health + PumpkinPieModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + PumpkinPieModifier);
				}
			} else {
				if (hunger + PumpkinPieModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + PumpkinPieModifier);
				}
			};
			break;
		case 363:
            int RawBeefModifier = Integer.parseInt(getConfig().getString("Food.RawBeef.modifier"));
			String RawBeefHeal = getConfig().getString("Food.RawBeef.heal");
			if (RawBeefHeal == "health"){
				if (health + RawBeefModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + RawBeefModifier);
				}
			} else {
				if (hunger + RawBeefModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + RawBeefModifier);
				}
			};
			break;
		case 365:
            int RawChickenModifier = Integer.parseInt(getConfig().getString("Food.RawChicken.modifier"));
			String RawChickenHeal = getConfig().getString("Food.RawChicken.heal");
			if (RawChickenHeal == "health"){
				if (health + RawChickenModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + RawChickenModifier);
				}
			} else {
				if (hunger + RawChickenModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + RawChickenModifier);
				}
			};
			break;
		case 349:
            int RawFishModifier = Integer.parseInt(getConfig().getString("Food.RawFish.modifier"));
			String RawFishHeal = getConfig().getString("Food.RawFish.heal");
			if (RawFishHeal == "health"){
				if (health + RawFishModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + RawFishModifier);
				}
			} else {
				if (hunger + RawFishModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + RawFishModifier);
				}
			};
			break;
		case 319:
            int RawPorkchopModifier = Integer.parseInt(getConfig().getString("Food.RawPorkchop.modifier"));
			String RawPorkchopHeal = getConfig().getString("Food.RawPorkchop.heal");
			if (RawPorkchopHeal == "health"){
				if (health + RawPorkchopModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + RawPorkchopModifier);
				}
			} else {
				if (hunger + RawPorkchopModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + RawPorkchopModifier);
				}
			};
			break;
		case 367:
            int RottenFleshModifier = Integer.parseInt(getConfig().getString("Food.RottenFlesh.modifier"));
			String RottenFleshHeal = getConfig().getString("Food.RottenFlesh.heal");
			if (RottenFleshHeal == "health"){
				if (health + RottenFleshModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + RottenFleshModifier);
				}
			} else {
				if (hunger + RottenFleshModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + RottenFleshModifier);
				}
			};
			break;
		case 375:
            int SpiderEyeModifier = Integer.parseInt(getConfig().getString("Food.SpiderEye.modifier"));
			String SpiderEyeHeal = getConfig().getString("Food.SpiderEye.heal");
			if (SpiderEyeHeal == "health"){
				if (health + SpiderEyeModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + SpiderEyeModifier);
				}
			} else {
				if (hunger + SpiderEyeModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + SpiderEyeModifier);
				}
			};
			break;
		case 364:			
            int SteakModifier = Integer.parseInt(getConfig().getString("Food.Steak.modifier"));
			String SteakHeal = getConfig().getString("Food.Steak.heal");
			if (SteakHeal == "health"){
				if (health + SteakModifier > 20){
					player.setHealth(20);
				} else {
					player.setHealth(health + SteakModifier);
				}
			} else {
				if (hunger + SteakModifier > 20){
					player.setFoodLevel(20);
				} else {
					player.setHealth(hunger + SteakModifier);
				}
			};
			break;
		}
	}
	
	//Creates config
	public void createConfig(){
		File configfile = new File(getDataFolder() + File.separator
				+ "config.yml");
		if (!configfile.exists()) {
			this.getConfig().options().copyDefaults(true);
			this.saveDefaultConfig();
			log.info(String.format("[%s] Config created Successfully", getDescription().getName()));
		}
	}
}
