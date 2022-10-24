package com.gildedrose;

import static com.gildedrose.QualityUpdater.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            if (item.name.equals("Aged Brie")) {
                updateAgedBrieItem(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstagePassItem(item);
            } else {
                updateOtherItem(item);
            }
            // If item is expired
            if (item.sellIn < 0) {
                updateQualityExpiredItem(item);
            }
        }
    }

    private void updateOtherItem(Item item) {
        item.sellIn--;
        degradeItemQuality(item);
        if (item.name.toLowerCase().contains("conjured")) {
            degradeItemQuality(item);
        }
    }

    private void updateAgedBrieItem(Item item) {
        item.sellIn--;
        // Aged Brie increases in Quality
        increaseItemQuality(item);
    }

    private void updateBackstagePassItem(Item item) {
        item.sellIn--;
        // Backstage passes increase in Quality
        increaseItemQuality(item);

        // Quality increases by 2 for 10 days or less
        if (item.sellIn < 11) {
            increaseItemQuality(item);
        }

        // Quality increases by 3 for 5 days or less
        if (item.sellIn < 6) {
            increaseItemQuality(item);
        }
    }
}
