package com.gildedrose;

public class ConjuredItem extends CommonItem{
    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        super.updateQuality();
        super.updateQuality();
    }

    @Override
    public void updateExpired() {
        super.updateExpired();
        super.updateExpired();
    }
}
