package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredTest {

    @Test
    void increaseQualityNeverOver50(){
        GildedRose app = new GildedRose(new Item("Conjured Mana Cake", 5, 50));
        app.updateQuality();
        assertEquals(app.items[0].quality, 50);
        assertEquals(app.items[0].sellIn, 4);
    }

    @Test
    void decreaseQualityNeverUnder0(){
        GildedRose app = new GildedRose(new Item("Conjured Mana Cake", 5, 0));
        app.updateQuality();
        assertEquals(app.items[0].quality, 0);
        assertEquals(app.items[0].sellIn, 4);
    }

    @Test
    void decreaseQualityTwiceAsFastAsNormalItem(){
        GildedRose app = new GildedRose(new Item("Conjured Mana Cake", 5, 12));
        app.updateQuality();
        assertEquals(app.items[0].quality, 10);
        assertEquals(app.items[0].sellIn, 4);

    }





}
