package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonItemTest {

    @Test
    public void qualityAndSellByDateDecrease(){
        GildedRose app = new GildedRose(new Item("foo", 20, 15));
        app.updateQuality();
        assertEquals(app.items[0].quality, 14);
        assertEquals(app.items[0].sellIn, 19);
    }

    @Test
    public void qualityDecreaseTwiceWhenSellByDateHasPassed(){
        GildedRose app = new GildedRose(new Item("foo", 0, 10));
        app.updateQuality();
        assertEquals(app.items[0].quality, 8);
        assertEquals(app.items[0].sellIn, -1);
    }

    @Test
    public void qualityIsNeverNegative(){
        GildedRose app = new GildedRose(new Item("foo", 20, 0));
        app.updateQuality();
        assertEquals(app.items[0].quality, 0);
        assertEquals(app.items[0].sellIn, 19);
    }
}
