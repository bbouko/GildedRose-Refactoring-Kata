package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String LEGENDARY = "Sulfuras, Hand of Ragnaros";

    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item... items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item,createItemUpdate(item));
        }
    }

    private void updateItem(Item item, ItemUpdate itemUpdate) {
        //updateQuality(itemUpdate.getItem());
        itemUpdate.updateQuality();
        updateSellIn(itemUpdate.getItem());
        if (isExpired(itemUpdate.getItem())) {
            updateExpired(itemUpdate.getItem());
        }
    }

    private void updateQuality(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            incrementQuality(item);
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            updateBackstagePassesQuality(item);
        } else if (item.name.equals(LEGENDARY)) {
        }
        //standard Item
        else decreaseQuality(item);
    }

    private void updateSellIn(Item item) {
        if (item.name.equals(LEGENDARY)) {
        } else {
            item.sellIn = item.sellIn - 1;
        }
    }


    private void updateExpired(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            incrementQuality(item);
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            item.quality = MIN_QUALITY;

        } else if (item.name.equals(LEGENDARY)) {
        } else {
            decreaseQuality(item);
        }
    }

    private boolean isExpired(Item item) {
        return item.sellIn < MIN_QUALITY;
    }





    private void updateBackstagePassesQuality(Item item) {
        incrementQuality(item);

        if (item.sellIn < 11) {
            incrementQuality(item);
        }
        if (item.sellIn < 6) {
            incrementQuality(item);
        }

    }


    private void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality = item.quality - 1;
        }
    }

    private void incrementQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    private ItemUpdate createItemUpdate(Item item){
        if(item.name.equals(LEGENDARY)){
            return new Legendary(item);
        }
        else if(item.name.equals(AGED_BRIE)){
            return new AgedBrie(item);

        }
        else if(item.name.equals(BACKSTAGE_PASSES)){
            return new BackstagePasses(item);
        }
        else{
            return new CommonItem(item);

        }


    }

}
