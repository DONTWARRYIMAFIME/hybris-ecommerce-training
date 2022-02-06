package com.expertsoft.facades;

import com.expertsoft.data.ProductData;

public interface ProductWithQuestionsFacade
{
    ProductData getProductWithQuestions(final String productId);
}
