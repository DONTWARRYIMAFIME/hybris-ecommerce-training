package com.expertsoft.search.solrfacetsearch.provider.impl;

import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractFacetValueDisplayNameProvider;
import de.hybris.platform.solrfacetsearch.search.SearchQuery;

public class ProductWarrantyFacetDisplayNameProvider extends AbstractFacetValueDisplayNameProvider
{
    @Override
    public String getDisplayName(final SearchQuery query, final IndexedProperty property, final String facetValue)
    {
        return String.format("With %s warranty year(s)", facetValue);
    }
}