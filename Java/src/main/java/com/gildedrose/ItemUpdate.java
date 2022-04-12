package com.gildedrose;

public interface ItemUpdate {

    int MIN_QUALITY = 0;
    int MAX_QUALITY = 50;
    int EXPIRED_DAY = 0;

    void updateQuality();
    void updateSellin();
    void updateExpired();

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

    default boolean isExpired(Item item) {
        return item.sellIn < EXPIRED_DAY;
    }
}
