package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    // Start section regression tests
    @Test
    void testAgedBrie() {
        String AGED_BRIE = "Aged Brie";
        Item[] items = new Item[] {
            new Item(AGED_BRIE, 5, 20),
            new Item(AGED_BRIE, 0, 50),
            new Item(AGED_BRIE, 0, 40),
            new Item(AGED_BRIE, -1, 50),
            new Item(AGED_BRIE, -3, 30)
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
        String SULFURAS = "Sulfuras, Hand of Ragnaros";
        Item[] items = new Item[] {
            new Item(SULFURAS, 15, 80),
            new Item(SULFURAS, 0, 80),
            new Item(SULFURAS, -1, 80)
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
        String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] {
            new Item(BACKSTAGE_PASSES, 15, 10),
            new Item(BACKSTAGE_PASSES, 10, 10),
            new Item(BACKSTAGE_PASSES, 5, 10),
            new Item(BACKSTAGE_PASSES, -1, 30),
            new Item(BACKSTAGE_PASSES, 1, 50)
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
            new Item("Alterac Swiss", 5, 10),
            new Item("Wild Hog Shank", -1, 10),
            new Item("Heaven Peach", -1, 1),
            new Item("Moon Harvest Pumpkin", -1, -1)
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
            new Item("Mana cake", 5, 10),
            new Item("Conjured Mana cake", 5, 10),
            new Item("Orange Juice", -1, 10),
            new Item("Conjured Orange Juice", -1, 10),
            new Item("Health Potion", -1, 3),
            new Item("Conjured Health Potion", -1, 3),
            new Item("Conjured Cheese", 1, 1)
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
