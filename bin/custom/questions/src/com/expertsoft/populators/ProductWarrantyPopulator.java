package com.expertsoft.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.Optional;

public class ProductWarrantyPopulator implements Populator<ProductModel, ProductData>
{
    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException
    {
        productData.setWarrantyYears(Optional.ofNullable(productModel.getWarrantyYears()).orElse(0));
    }
}
