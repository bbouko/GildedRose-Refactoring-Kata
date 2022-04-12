package com.gildedrose;

public class BackstagePasses implements ItemUpdate{

    public Item getItem() {
        return item;
    }

    private final Item item;

    public BackstagePasses(Item item) {
        this.item = item;
    }


    @Override
    public void updateItem() {

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

    }

    @Override
    public void updateExpired() {

    }
}
