package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
			update(item);
        }
    }

	private void update(Item item) {
		if (!isBrie(item)
		        && !isTickets(item)) {
		    if (item.quality > 0) {
		        if (!isSulfuras(item)) {
		            decreaseQuality(item);
		        }
		    }
		} else {
		    extracted(item);
		    if (isTickets(item)) {
	            if (item.sellIn < 11) {
	                extracted(item);
	            }

	            if (item.sellIn < 6) {
	                extracted(item);
	            }
	        }
		}

		if (!isSulfuras(item)) {
		    decreaseSellInDate(item);
		}

		if (isExpired(item)) {
		    if (!isBrie(item)) {
		        if (!isTickets(item)) {
		            if (item.quality > 0) {
		                if (!isSulfuras(item)) {
		                    decreaseQuality(item);
		                }
		            }
		        } else {
		            item.quality = item.quality - item.quality;
		        }
		    } else {
		        extracted(item);
		    }
		}
	}

	private void extracted(Item item) {
		if (item.quality < 50) {
		    increaseQuality(item);   
		}
	}

	private void decreaseQuality(Item item) {
		item.quality = item.quality - 1;
	}

	private void increaseQuality(Item item) {
		item.quality = item.quality + 1;
	}

	private void decreaseSellInDate(Item item) {
		item.sellIn = item.sellIn - 1;
	}

	private boolean isExpired(Item item) {
		return item.sellIn < 0;
	}

	private boolean isSulfuras(Item item) {
		return item.name.equals("Sulfuras, Hand of Ragnaros");
	}

	private boolean isTickets(Item item) {
		return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
	}

	private boolean isBrie(Item item) {
		return item.name.equals("Aged Brie");
	}
}
