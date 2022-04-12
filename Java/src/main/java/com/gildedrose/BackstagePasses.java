package com.gildedrose;

public class BackstagePasses implements ItemUpdate{

    private final Item item;

    public BackstagePasses(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        incrementQuality(item);
        if (item.sellIn < 11) {
            incrementQuality(item);
        }
        if (item.sellIn < 6) {
            incrementQuality(item);
        }
    }

    @Override
    public void updateSellin() {
        decreaseSellin(item);

    }

    @Override
    public void updateExpired() {
        if(isExpired(item)){
            item.quality = MIN_QUALITY;
        }
    }
}
