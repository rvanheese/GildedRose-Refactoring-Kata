package com.gildedrose;

public class QualityUpdater {

    // Degrades the item quality by one
    protected static void degradeItemQuality(Item item) {
        // The quality of an item is never negative
        if (item.quality > 0) {
            item.quality--;
        }
    }

    // Increases the item quality by one
    protected static void increaseItemQuality(Item item) {
        // Quality of an item is never more than 50
        if (item.quality < 50) {
            item.quality++;
        }
    }

    protected static void updateQualityExpiredItem(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            // Quality is 0 after the concert
            item.quality = 0;
        } else if (item.name.equals("Aged Brie")) {
            increaseItemQuality(item);
        } else {
            // Quality degrades twice as fast passed sell by date
            degradeItemQuality(item);
            // "Conjured" items degrade in Quality twice as fast as normal items
            if (item.name.toLowerCase().contains("conjured")) {
                degradeItemQuality(item);
            }
        }
    }
}
