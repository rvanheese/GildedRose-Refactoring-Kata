package com.gildedrose;

public abstract class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateItem() {
        this.sellIn--;
        // The quality of an item is never negative
        degradeItemQuality();
        handleConjuredItem();
    }

    public void updateExpiredQuality() {
        degradeItemQuality();
        handleConjuredItem();
    }

    private void handleConjuredItem() {
        // "Conjured" items degrade in Quality twice as fast as normal items
        if (this.name.toLowerCase().contains("conjured")) {
            degradeItemQuality();
        }
    }

    // Degrades the item quality by one
    private void degradeItemQuality() {
        // The quality of an item is never negative
        if (this.quality > 0) {
            this.quality--;
        }
    }

    // Increases the item quality by one
    protected void increaseItemQuality() {
        // Quality of an item is never more than 50
        if (this.quality < 50) {
            this.quality++;
        }
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
