package com.gildedrose;


class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String LEGENDARY = "Sulfuras, Hand of Ragnaros";

    public static final int MIN_QUALITY  = 0;
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
        itemUpdate.updateQuality();
        itemUpdate.updateSellin();
        if (isExpired(item)) {
            itemUpdate.updateExpired();
        }
    }

    private boolean isExpired(Item item) {
        return item.sellIn < MIN_QUALITY;
    }

    private ItemUpdate createItemUpdate(Item item){
        switch (item.name) {
            case LEGENDARY:
                return new Legendary(item);
            case AGED_BRIE:
                return new AgedBrie(item);
            case BACKSTAGE_PASSES:
                return new BackstagePasses(item);
            default:
                return new CommonItem(item);

        }
    }

}
