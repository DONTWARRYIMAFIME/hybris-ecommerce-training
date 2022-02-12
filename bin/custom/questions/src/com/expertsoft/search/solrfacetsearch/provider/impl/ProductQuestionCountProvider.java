package com.expertsoft.search.solrfacetsearch.provider.impl;

import com.expertsoft.model.QuestionModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractPropertyFieldValueProvider;
import org.springframework.beans.factory.annotation.Required;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductQuestionCountProvider extends AbstractPropertyFieldValueProvider implements FieldValueProvider, Serializable
{
    private FieldNameProvider fieldNameProvider;

    @Override
    public Collection<FieldValue> getFieldValues(final IndexConfig indexConfig, final IndexedProperty indexedProperty,
                                                 final Object obj) throws FieldValueProviderException
    {
        if (obj instanceof ProductModel)
        {
            final ProductModel product = (ProductModel) obj;
            final List<FieldValue> fieldValues = createFieldValue(product, indexConfig, indexedProperty);
            return fieldValues;
        }

        throw new FieldValueProviderException("Provided obj isn't a ProductModel type");
    }

    protected List<FieldValue> createFieldValue(final ProductModel product, final IndexConfig indexConfig,
                                                final IndexedProperty indexedProperty)
    {
        final List<FieldValue> fieldValues = new ArrayList<>();
        final List<QuestionModel> questions = product.getQuestions();

        if (questions != null)
        {
            addFieldValues(fieldValues, indexedProperty, null, questions.size());
        }
        return fieldValues;
    }


    protected void addFieldValues(final List<FieldValue> fieldValues, final IndexedProperty indexedProperty,
                                  final LanguageModel language, final Object value)
    {
        final Collection<String> fieldNames = getFieldNameProvider().getFieldNames(indexedProperty, (language == null) ? null : language.getIsocode());

        for (final String fieldName : fieldNames)
        {
            fieldValues.add(new FieldValue(fieldName, value));
        }
    }

    @Required
    public FieldNameProvider getFieldNameProvider()
    {
        return fieldNameProvider;
    }

    @Required
    public void setFieldNameProvider(final FieldNameProvider fieldNameProvider)
    {
        this.fieldNameProvider = fieldNameProvider;
    }

}