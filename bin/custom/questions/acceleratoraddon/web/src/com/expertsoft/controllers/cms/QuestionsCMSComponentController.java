package com.expertsoft.controllers.cms;

import com.expertsoft.controllers.QuestionsControllerConstants;
import com.expertsoft.facades.ProductWithQuestionsFacade;
import com.expertsoft.model.QuestionsCMSComponentModel;
import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Scope("tenant")
@RequestMapping(value = QuestionsControllerConstants.Actions.Cms.QuestionsComponent)
@Controller("QuestionsCMSComponentController")
public class QuestionsCMSComponentController extends AbstractCMSAddOnComponentController<QuestionsCMSComponentModel>
{
    private ProductWithQuestionsFacade productWithQuestionsFacade;

    @Autowired
    public void setProductWithQuestionsFacade(ProductWithQuestionsFacade productWithQuestionsFacade)
    {
        this.productWithQuestionsFacade = productWithQuestionsFacade;
    }

    @Override
    protected void fillModel(HttpServletRequest request, Model model, QuestionsCMSComponentModel component)
    {
        final String productCode = getRequestContextData(request).getProduct().getCode();
        final ProductData productWithQuestions = productWithQuestionsFacade.getProductWithQuestions(productCode);

        model.addAttribute("productWithQuestions", productWithQuestions);
        model.addAttribute("numberOfQuestionsToShow", Math.min(component.getNumberOfQuestionsToShow(),
                productWithQuestions.getQuestions().size()));
        model.addAttribute("fontSize", component.getFontSize());
    }
}
