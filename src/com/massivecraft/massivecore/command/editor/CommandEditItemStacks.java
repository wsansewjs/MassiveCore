package com.massivecraft.massivecore.command.editor;

import java.util.List;

import org.bukkit.inventory.ItemStack;

public class CommandEditItemStacks<O> extends CommandEditAbstract<O, List<ItemStack>>
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CommandEditItemStacks(EditSettings<O> settings, Property<O, List<ItemStack>> property)
	{
		// Super
		super(settings, property, true);
		
		// Children
		this.addChild(new CommandEditShow<>(settings, property));
		
		if (property.isNullable())
		{
			this.addChild(new CommandEditCreate<>(settings, property));
			this.addChild(new CommandEditDelete<>(settings, property));
		}
		
		if (property.isEditable())
		{
			this.addChild(new CommandEditItemStacksOpenList<O>(settings, property));
		}
	}
	
}
