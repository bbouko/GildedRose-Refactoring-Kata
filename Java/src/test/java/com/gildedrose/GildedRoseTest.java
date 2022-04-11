package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        GildedRose app = new GildedRose(new Item("foo", 0, 0));
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

}
