package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassesTest {

    @Test
    public void qualityIncreaseByOneWhenSellByDateOver10Days(){
        GildedRose app = new GildedRose(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 3));
        app.updateQuality();
        assertEquals(app.items[0].quality, 4);
        assertEquals(app.items[0].sellIn, 14);
    }

    @Test
    public void qualityIncreaseByTwoWhenSellByDateBellowOrEqual10Days(){
        GildedRose app = new GildedRose(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 3));
        app.updateQuality();
        assertEquals(app.items[0].quality, 5);
        assertEquals(app.items[0].sellIn, 9);
    }
    @Test
    public void qualityIncreaseByThreeWhenSellByDateBellowOrEqual5Days(){
        GildedRose app = new GildedRose(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 3));
        app.updateQuality();
        assertEquals(app.items[0].quality, 6);
        assertEquals(app.items[0].sellIn, 4);
    }
    @Test
    void qualityNeverOver50(){
        GildedRose app = new GildedRose(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50));
        app.updateQuality();
        assertEquals(app.items[0].quality, 50);
        assertEquals(app.items[0].sellIn, 4);
    }

    @Test
    public void qualityDropTo0WhenSellByDateIsOver(){
        GildedRose app = new GildedRose(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10));
        app.updateQuality();
        assertEquals(app.items[0].quality, 0);
        assertEquals(app.items[0].sellIn, -1);

    }
}
