package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    // Start section regression tests
    @Test
    void testAgedBrie() {
        Item[] items = new Item[] {
            new AgedBrie(5,20),
            new AgedBrie(0,50),
            new AgedBrie(0,40),
            new AgedBrie(-1,50),
            new AgedBrie(-3,30)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        // Aged Brie quality checks
        assertEquals(21, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
        assertEquals(42, app.items[2].quality);
        assertEquals(50, app.items[3].quality);
        assertEquals(32, app.items[4].quality);

        // Aged Brie SellIn checks
        assertEquals(4, app.items[0].sellIn);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(-1, app.items[2].sellIn);
        assertEquals(-2, app.items[3].sellIn);
        assertEquals(-4, app.items[4].sellIn);
    }

    @Test
    void testSulfuras() {
        Item[] items = new Item[] {
            new Sulfuras(15, 80),
            new Sulfuras(0, 80),
            new Sulfuras(-1, 80)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        // Sulfuras quality checks
        assertEquals(80, app.items[0].quality);
        assertEquals(80, app.items[1].quality);
        assertEquals(80, app.items[2].quality);

        // Sulfuras sellIn checks
        assertEquals(15, app.items[0].sellIn);
        assertEquals(0, app.items[1].sellIn);
        assertEquals(-1, app.items[2].sellIn);
    }

    @Test
    void testBackstagePasses() {
        Item[] items = new Item[] {
            new BackstagePass(15,10),
            new BackstagePass(10,10),
            new BackstagePass(5,10),
            new BackstagePass(-1,30),
            new BackstagePass(1,50)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        // Backstage passes quality checks
        assertEquals(11, app.items[0].quality);
        assertEquals(12, app.items[1].quality);
        assertEquals(13, app.items[2].quality);
        assertEquals(0, app.items[3].quality);
        assertEquals(50, app.items[4].quality);

        // Backstage passes sellIn checks
        assertEquals(14, app.items[0].sellIn);
        assertEquals(9, app.items[1].sellIn);
        assertEquals(4, app.items[2].sellIn);
        assertEquals(-2, app.items[3].sellIn);
        assertEquals(0, app.items[4].sellIn);
    }

    @Test
    void testOtherItem() {
        Item[] items = new Item[] {
            new InventoryItem("Alterac Swiss", 5, 10),
            new InventoryItem("Wild Hog Shank", -1, 10),
            new InventoryItem("Heaven Peach", -1, 1),
            new InventoryItem("Moon Harvest Pumpkin", -1, -1)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        // Item quality checks
        assertEquals(9, app.items[0].quality);
        assertEquals(8, app.items[1].quality);
        assertEquals(0, app.items[2].quality);
        assertEquals(-1, app.items[3].quality);

        // Item sellIn checks
        assertEquals(4, app.items[0].sellIn);
        assertEquals(-2, app.items[1].sellIn);
        assertEquals(-2, app.items[2].sellIn);
        assertEquals(-2, app.items[3].sellIn);
    }

    // End section regression tests

    // Start section new feature test

    @Test
    void testConjuredItems() {
        Item[] items = new Item[] {
            new InventoryItem("Mana cake", 5, 10),
            new InventoryItem("Conjured Mana cake", 5, 10),
            new InventoryItem("Orange Juice", -1, 10),
            new InventoryItem("Conjured Orange Juice", -1, 10),
            new InventoryItem("Health Potion", -1, 3),
            new InventoryItem("Conjured Health Potion", -1, 3),
            new InventoryItem("Conjured Cheese", 1, 1)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        // Conjured item quality checks
        assertEquals(9, app.items[0].quality);
        assertEquals(8, app.items[1].quality);
        assertEquals(8, app.items[2].quality);
        assertEquals(6, app.items[3].quality);
        assertEquals(1, app.items[4].quality);
        assertEquals(0, app.items[5].quality);
        assertEquals(0, app.items[6].quality);
    }

    // End section new feature test
}
