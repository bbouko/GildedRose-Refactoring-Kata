package com.gildedrose;

public interface ItemUpdate {

    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;

    void updateItem();
    void updateQuality();
    void updateSellin();
    void updateExpired();

    public Item getItem();



    default void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality = item.quality - 1;
        }
    }

    default void incrementQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    default void decreaseSellin(Item item){
        item.sellIn = item.sellIn - 1;
    }
}
