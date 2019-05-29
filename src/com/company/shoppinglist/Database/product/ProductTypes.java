package com.company.shoppinglist.Database.product;

public enum ProductTypes {
    FRUITS,
    VEGETABLES,
    MEAT,
    MILK,
    ALCOHOL,
    OTHER;

    public static ProductTypes getProductById(int id) {
        for (ProductTypes pt: ProductTypes.values()) {
            if (pt.ordinal() == id)
                return pt;
        }
        return null;
    }
    public static int getProductTypesCount() {
        int res=0;
        for (ProductTypes pt: ProductTypes.values()) {
            res++;
        }
        return res;
    }
}