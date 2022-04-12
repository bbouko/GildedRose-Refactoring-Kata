package com.gildedrose;


class GildedRose {

    Item[] items;

    public GildedRose(Item... items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(ItemUpdateFactory.CreateItem(item));
        }
    }

    private void updateItem(ItemUpdate itemUpdate) {
        itemUpdate.updateQuality();
        itemUpdate.updateSellin();
        itemUpdate.updateExpired();
    }

}
