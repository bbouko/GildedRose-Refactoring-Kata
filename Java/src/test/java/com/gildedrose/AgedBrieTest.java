package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {

    @Test
    public void increasesInQualityAndDecreaseSellIn(){
        GildedRose app = new GildedRose(new Item("Aged Brie", 2, 0));
        app.updateQuality();
        assertEquals(app.items[0].quality, 1);
        assertEquals(app.items[0].sellIn, 1);
    }

    @Test
    void qualityNeverOver50(){
        GildedRose app = new GildedRose(new Item("Aged Brie", 5, 50));
        app.updateQuality();
        assertEquals(app.items[0].quality, 50);
        assertEquals(app.items[0].sellIn, 4);
    }

    @Test
    void qualityIncreaseTwiceWhenSellByDateHasPassed(){
        GildedRose app = new GildedRose(new Item("Aged Brie", 0, 2));
        app.updateQuality();
        assertEquals(app.items[0].quality, 4);
        assertEquals(app.items[0].sellIn, -1);
    }



}
