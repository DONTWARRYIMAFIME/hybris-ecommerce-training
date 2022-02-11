package com.expertsoft.facades;

import de.hybris.platform.commercefacades.product.data.ProductData;

public interface ProductWithQuestionsFacade
{
    ProductData getProductWithQuestions(final String productId);
}
