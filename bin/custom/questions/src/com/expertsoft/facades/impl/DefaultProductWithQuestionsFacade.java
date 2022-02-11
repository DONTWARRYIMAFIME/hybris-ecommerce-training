package com.expertsoft.facades.impl;

import com.expertsoft.facades.ProductWithQuestionsFacade;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.beans.factory.annotation.Required;

public class DefaultProductWithQuestionsFacade implements ProductWithQuestionsFacade
{
    private ProductService productService;

    private Converter<ProductModel, ProductData> productWithQuestionsConverter;

    @Required
    public void setProductService(ProductService productService)
    {
        this.productService = productService;
    }

    @Required
    public void setProductWithQuestionsConverter(Converter<ProductModel, ProductData> productWithQuestionsConverter)
    {
        this.productWithQuestionsConverter = productWithQuestionsConverter;
    }

    @Override
    public ProductData getProductWithQuestions(final String productId)
    {
        if (productId == null)
        {
            throw new IllegalArgumentException("Product id cannot be null");
        }

        final ProductModel productModel = productService.getProductForCode(productId);
        final ProductData productData = productWithQuestionsConverter.convert(productModel);

        return productData;
    }
}
