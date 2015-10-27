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
    
    @Test
    public void IfItemIsBrieAndExpiredQualityIncreasesByTwo() throws Exception {
    	Item[] items = new Item[] { new Item("Aged Brie", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
	}
    
    @Test
    public void IfItemIsBrieAndExpiredAndMaxedInQualityThenQualityDoesNotIncrease() throws Exception {
    	Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
	}
    
    @Test
	public void IfItemIsConcertTicketWithMoreThan10DaysThenQualityIncreasesByOne() throws Exception {
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
	}
    
    @Test
	public void IfItemIsConcertTicketWithMoreThan5DaysThenQualityShouldIncreaseByTwo() throws Exception {
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
	}
    

}
