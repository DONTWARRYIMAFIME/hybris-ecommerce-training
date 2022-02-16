package com.expertsoft.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.converters.populator.SearchResultVariantProductPopulator;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;

import java.util.Optional;

public class SearchProductQuestionCountPopulator extends SearchResultVariantProductPopulator
{
    @Override
    public void populate(SearchResultValueData source, ProductData target) {
        super.populate(source, target);

        final Integer questionCount = (Integer) Optional.ofNullable(getValue(source, "questionCount")).orElse(0);
        target.setQuestionCount(questionCount);
    }
}