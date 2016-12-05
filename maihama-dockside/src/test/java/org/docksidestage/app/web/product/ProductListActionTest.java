package org.docksidestage.app.web.product;

import org.dbflute.optional.OptionalThing;
import org.dbflute.utflute.lastaflute.mock.TestingHtmlData;
import org.docksidestage.app.web.base.paging.PagingAssist;
import org.docksidestage.app.web.base.paging.PagingNavi;
import org.docksidestage.mylasta.action.DocksideHtmlPath;
import org.docksidestage.unit.UnitDocksideTestCase;
import org.lastaflute.web.response.HtmlResponse;

/**
 * @author jflute
 */
public class ProductListActionTest extends UnitDocksideTestCase {

    public void test_index_success_by_productName() throws Exception {
        // ## Arrange ##
        ProductListAction action = new ProductListAction();
        inject(action);
        int pageNumber = 2;
        ProductSearchForm form = new ProductSearchForm();
        form.productName = "a";

        // ## Act ##
        HtmlResponse response = action.index(OptionalThing.of(pageNumber), form);

        // ## Assert ##
        TestingHtmlData htmlData = validateHtmlData(response);
        htmlData.assertHtmlForward(DocksideHtmlPath.path_Product_ProductListHtml);
        htmlData.requiredList("beans", ProductSearchRowBean.class).forEach(bean -> {
            log(bean);
            assertContainsIgnoreCase(bean.productName, form.productName);
        });
        PagingNavi pagingNavi = htmlData.required(PagingAssist.NAVI_KEY, PagingNavi.class);
        log(pagingNavi);
        assertEquals(pageNumber, pagingNavi.getCurrentPageNumber());
    }
}
