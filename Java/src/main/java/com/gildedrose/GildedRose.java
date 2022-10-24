package com.gildedrose;

class GildedRose {
    Item[] items;

    // Constants for items
    private final String AGED_BRIE = "Aged Brie";
    private final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            updateSellIn(item);

            if (item.name.equals(AGED_BRIE)) {
                updateQualityAgedBrie(item);
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                updateQualityBackstagePass(item);
            } else {
                if (item.quality > 0) item.quality -= 1;
            }
            // If item is expired
            if (item.sellIn < 0) {
                updateQualityExpiredItem(item);
            }
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void updateQualityAgedBrie(Item item) {
        // Quality of an item is never more than 50
        if (item.quality < 50) {
            // Aged Brie increases in Quality
            item.quality += 1;
        }
    }

    private void updateQualityBackstagePass(Item item) {
        // Quality of an item is never more than 50
        if (item.quality < 50) {
            // Backstage passes increase in Quality
            item.quality += 1;
        }

        // Quality increases by 2 for 10 days or less
        if (item.sellIn < 11 && item.quality < 50) {
            item.quality += 1;
        }

        // Quality increases by 3 for 5 days or less
        if (item.sellIn < 6 && item.quality < 50) {
            item.quality += 1;
        }
    }

    private void updateQualityExpiredItem(Item item) {
        if (item.name.equals(BACKSTAGE_PASSES)) {
            // Quality is 0 after the concert
            item.quality = 0;
        } else if (item.name.equals(AGED_BRIE)) {
            if (item.quality < 50) {
                item.quality += 1;
            }
        } else {
            // Quality degrades twice as fast passed sell by date
            if (item.quality > 0) {
                item.quality -= 1;
            }
        }
    }
}
