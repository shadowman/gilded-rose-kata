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

}
