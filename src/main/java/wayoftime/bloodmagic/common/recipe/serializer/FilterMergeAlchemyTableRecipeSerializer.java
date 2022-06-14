package wayoftime.bloodmagic.common.recipe.serializer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;
import wayoftime.bloodmagic.recipe.RecipeFilterMergeAlchemyTable;
import wayoftime.bloodmagic.recipe.helper.SerializerHelper;
import wayoftime.bloodmagic.util.Constants;

public class FilterMergeAlchemyTableRecipeSerializer<RECIPE extends RecipeFilterMergeAlchemyTable> extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<RECIPE>
{

	private final IFactory<RECIPE> factory;

	public FilterMergeAlchemyTableRecipeSerializer(IFactory<RECIPE> factory)
	{
		this.factory = factory;
	}

	@Nonnull
	@Override
	public RECIPE fromJson(@Nonnull ResourceLocation recipeId, @Nonnull JsonObject json)
	{
		JsonElement filterElement = JSONUtils.isArrayNode(json, Constants.JSON.FILTER)
				? JSONUtils.getAsJsonArray(json, Constants.JSON.FILTER)
				: JSONUtils.getAsJsonObject(json, Constants.JSON.FILTER);
		Ingredient filter = Ingredient.fromJson(filterElement);

		List<Ingredient> inputList = new ArrayList<Ingredient>();

		if (json.has(Constants.JSON.INPUT) && JSONUtils.isArrayNode(json, Constants.JSON.INPUT))
		{
			JsonArray mainArray = JSONUtils.getAsJsonArray(json, Constants.JSON.INPUT);

			arrayLoop: for (JsonElement element : mainArray)
			{
				if (inputList.size() >= RecipeFilterMergeAlchemyTable.MAX_INPUTS)
				{
					break arrayLoop;
				}

				if (element.isJsonArray())
				{
					element = element.getAsJsonArray();
				} else
				{
					element.getAsJsonObject();
				}

				inputList.add(Ingredient.fromJson(element));
			}
		}

		ItemStack output = SerializerHelper.getItemStack(json, Constants.JSON.OUTPUT);

		int syphon = JSONUtils.getAsInt(json, Constants.JSON.SYPHON);
		int ticks = JSONUtils.getAsInt(json, Constants.JSON.TICKS);
		int minimumTier = JSONUtils.getAsInt(json, Constants.JSON.ALTAR_TIER);

		return this.factory.create(recipeId, filter, inputList, output, syphon, ticks, minimumTier);
	}

	@Override
	public RECIPE fromNetwork(@Nonnull ResourceLocation recipeId, @Nonnull PacketBuffer buffer)
	{
		try
		{
			Ingredient filter = Ingredient.fromNetwork(buffer);
			int size = buffer.readInt();
			List<Ingredient> input = new ArrayList<Ingredient>(size);

			for (int i = 0; i < size; i++)
			{
				input.add(i, Ingredient.fromNetwork(buffer));
			}

			ItemStack output = buffer.readItem();
			int syphon = buffer.readInt();
			int ticks = buffer.readInt();
			int minimumTier = buffer.readInt();

			return this.factory.create(recipeId, filter, input, output, syphon, ticks, minimumTier);
		} catch (Exception e)
		{
//Mekanism.logger.error("Error reading electrolysis recipe from packet.", e);
			throw e;
		}
	}

	@Override
	public void toNetwork(@Nonnull PacketBuffer buffer, @Nonnull RECIPE recipe)
	{
		try
		{
			recipe.write(buffer);
		} catch (Exception e)
		{
//Mekanism.logger.error("Error writing electrolysis recipe to packet.", e);
			throw e;
		}
	}

	@FunctionalInterface
	public interface IFactory<RECIPE extends RecipeFilterMergeAlchemyTable>
	{
		RECIPE create(ResourceLocation id, Ingredient filter, List<Ingredient> input, ItemStack output, int syphon, int ticks, int minimumTier);
	}
}