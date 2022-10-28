package com.gildedrose;

public class AgedBrie extends Item {

    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateItem() {
        this.sellIn--;
        increaseItemQuality();
    }

    @Override
    public void updateExpiredQuality() {
        increaseItemQuality();
    }
}
