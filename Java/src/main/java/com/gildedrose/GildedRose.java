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
        updateExpired(item);
    }

    private void updateExpired(Item item) {
        if (isExpired(item)) {
            if (!item.name.equals(AGED_BRIE)) {
                if (!item.name.equals(BACKSTAGE_PASSES)) {
                    if (item.quality > MIN_QUALITY) {
                        if (!item.name.equals(LEGENDARY)) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = MIN_QUALITY;
                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    private boolean isExpired(Item item) {
        return item.sellIn < MIN_QUALITY;
    }

    private void updateSellIn(Item item) {
        if (!item.name.equals(LEGENDARY)) {
            item.sellIn = item.sellIn - 1;

        }
    }

    private void updateQuality(Item item) {
        if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES)) {
            if (item.quality > MIN_QUALITY) {
                if (!item.name.equals(LEGENDARY)) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < MAX_QUALITY) {
                item.quality = item.quality + 1;

                if (item.name.equals(BACKSTAGE_PASSES)) {
                    if (item.sellIn < 11) {
                        if (item.quality < MAX_QUALITY) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < MAX_QUALITY) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }
    }
}
