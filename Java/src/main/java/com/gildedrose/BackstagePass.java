package com.gildedrose;

public class BackstagePass extends Item {

    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void updateItem() {
        this.sellIn--;
        increaseItemQuality();

        // Quality increases by 2 for 10 days or less
        if (this.sellIn < 11) {
            increaseItemQuality();
        }

        // Quality increases by 3 for 5 days or less
        if (this.sellIn < 6) {
            increaseItemQuality();
        }
    }

    @Override
    public void updateExpiredQuality() {
        this.quality = 0;
    }
}
