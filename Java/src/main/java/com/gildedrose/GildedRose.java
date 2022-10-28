package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.updateItem();

            // If item is expired
            if (item.sellIn < 0) {
                item.updateExpiredQuality();
            }
        }
    }
}
