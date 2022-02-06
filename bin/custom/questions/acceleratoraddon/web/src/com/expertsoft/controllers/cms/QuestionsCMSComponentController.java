package com.expertsoft.controllers.cms;

import com.expertsoft.controllers.QuestionsControllerConstants;
import com.expertsoft.data.ProductData;
import com.expertsoft.facades.ProductWithQuestionsFacade;
import com.expertsoft.model.QuestionsCMSComponentModel;
import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Scope("tenant")
@RequestMapping(value = QuestionsControllerConstants.Actions.Cms.QuestionsComponent)
@Controller("QuestionsCMSComponentController")
public class QuestionsCMSComponentController extends AbstractCMSAddOnComponentController<QuestionsCMSComponentModel>
{
//    private static final String PRODUCT_CODE_PATH_VARIABLE_PATTERN = "/{productCode:.*}";

//    @Resource
//    private ProductWithQuestionsFacade productWithQuestionsFacade;
//
//    @GetMapping(PRODUCT_CODE_PATH_VARIABLE_PATTERN)
//    @ModelAttribute("productWithQuestions")
//    public ProductData fillModelWith(@PathVariable String productCode)
//    {
//        return productWithQuestionsFacade.getProductWithQuestions(productCode);
//    }

    @Override
    protected void fillModel(HttpServletRequest request, Model model, QuestionsCMSComponentModel component)
    {
        model.addAttribute("numberOfQuestionsToShow", component.getNumberOfQuestionsToShow());
        model.addAttribute("fontSize", component.getFontSize());
    }
}
