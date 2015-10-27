package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void IfItemIsNormalSellInDecreasesByAtLeastOne() {
        Item[] items = new Item[] { new Item("Normal", 1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].sellIn < 1);
    }
    
    @Test
	public void IfItemIsSulfurasSellInDoesNotDecrease() throws Exception {
    	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
	}
    
    @Test
	public void IfSulfurasQualityDoesNotDecrease() throws Exception {
    	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality); 
	}
    
    @Test
	public void IfItemIsNormalQualityDecreasesByAtLeastOne() throws Exception {
    	Item[] items = new Item[] { new Item("Normal", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality < 1);
	}
    
    @Test
	public void IfItemIsBrieQualityDoesNotDecrease() throws Exception {
    	Item[] items = new Item[] { new Item("Aged Brie", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality >= 1);
	}

}
