package org.docksidestage.app.web;

import java.util.Map;

import javax.annotation.Resource;

import org.docksidestage.app.web.base.DocksideBaseAction;
import org.docksidestage.mylasta.direction.DocksideConfig;
import org.lastaflute.doc.SwaggerGenerator;
import org.lastaflute.doc.agent.SwaggerAgent;
import org.lastaflute.doc.web.LaActionSwaggerable;
import org.lastaflute.web.Execute;
import org.lastaflute.web.login.AllowAnyoneAccess;
import org.lastaflute.web.response.HtmlResponse;
import org.lastaflute.web.response.JsonResponse;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * The action to show swaggar-ui.
 * @author cabos
 */
@AllowAnyoneAccess
public class SwaggerAction extends DocksideBaseAction implements LaActionSwaggerable {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Resource
    private RequestManager requestManager;
    @Resource
    private DocksideConfig config;

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    @Execute
    public HtmlResponse get$index() {
        verifySwaggerAllowed();
        String swaggerJsonUrl = toActionUrl(SwaggerAction.class, moreUrl("json"));
        return new SwaggerAgent(requestManager).prepareSwaggerUiResponse(swaggerJsonUrl);
    }

    @Execute
    public JsonResponse<Map<String, Object>> json() {
        verifySwaggerAllowed();
        return asJson(new SwaggerGenerator().generateSwaggerMap());
    }

    private void verifySwaggerAllowed() { // also check in ActionAdjustmentProvider
        verifyOrClientError("Swagger is not enabled.", config.isSwaggerEnabled());
    }
}
