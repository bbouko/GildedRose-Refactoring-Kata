package com.gildedrose;

public class ItemUpdateFactory {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String LEGENDARY = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";

    public static ItemUpdate CreateItem(Item item)    {

        switch (item.name)
        {
            case LEGENDARY:
                return new Legendary(item);
            case AGED_BRIE:
                return new AgedBrie(item);
            case BACKSTAGE_PASSES:
                return new BackstagePasses(item);
            case CONJURED:
                return new ConjuredItem(item);
            default:
                return new CommonItem(item);
        }
    }
}
