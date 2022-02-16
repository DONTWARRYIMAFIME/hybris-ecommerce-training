package com.expertsoft.populators;


import com.expertsoft.data.QuestionData;
import com.expertsoft.model.QuestionModel;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class ProductWithQuestionsPopulator implements Populator<ProductModel, ProductData>
{
    private Converter<QuestionModel, QuestionData> questionConverter;

    @Required
    public void setQuestionConverter(Converter<QuestionModel, QuestionData> questionConverter)
    {
        this.questionConverter = questionConverter;
    }

    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException
    {
        final List<QuestionModel> questionModels = productModel.getQuestions();
        final List<QuestionData> questionDataList = questionConverter.convertAll(questionModels);

        productData.setQuestions(questionDataList);
        productData.setQuestionCount(questionDataList.size());
    }
}
