package com.gildedrose;


class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String LEGENDARY = "Sulfuras, Hand of Ragnaros";

    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item ... items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        updateQuality(item);
        updateSellIn(item);
        if (isExpired(item)) {
            updateExpired(item);
        }
    }

    private void updateExpired(Item item) {
            if (item.name.equals(AGED_BRIE)) {
                incrementQuality(item);
            }
            else if(item.name.equals(BACKSTAGE_PASSES)){
                item.quality = MIN_QUALITY;

            }
            else if (item.name.equals(LEGENDARY)){
            }
            else if (item.quality > MIN_QUALITY) {
                item.quality = item.quality - 1;
            }
    }

    private void incrementQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    private boolean isExpired(Item item) {
        return item.sellIn < MIN_QUALITY;
    }

    private void updateSellIn(Item item) {
        if(item.name.equals(LEGENDARY)) {}
        else{
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateQuality(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            incrementQuality(item);
        }
        else if(item.name.equals(BACKSTAGE_PASSES)){
            updateBackstagePassesQuality(item);
        }
        else if (item.name.equals(LEGENDARY)){
        }
        //standard Item
        else if(item.quality > MIN_QUALITY) {
                item.quality = item.quality - 1;
        }
    }

    private void updateBackstagePassesQuality(Item item) {
        if (item.quality < MAX_QUALITY) {

            item.quality = item.quality + 1;
            if (item.sellIn < 11) {
                incrementQuality(item);
            }
            if (item.sellIn < 6) {
                incrementQuality(item);
            }
        }
    }

}
