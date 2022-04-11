package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LegendaryTest {

    @Test
    public void sellByDateAndQualityNeverChange(){
        GildedRose app = new GildedRose(new Item("Sulfuras, Hand of Ragnaros", 80, 80));
        app.updateQuality();
        assertEquals(app.items[0].quality, 80);
        assertEquals(app.items[0].sellIn, 80);
    }
}
