package org.docksidestage.mylasta.direction.sponsor;

import javax.servlet.http.HttpServletRequest;

import org.dbflute.util.DfStringUtil;
import org.docksidestage.mylasta.direction.DocksideConfig;

/**
 * @author cabos
 */
public class DocksideActionAdjustmentProvider extends MaihamaActionAdjustmentProvider {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final String API_URL_PREFIX = "/api"; // to be separated from angular request

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private final DocksideConfig config;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public DocksideActionAdjustmentProvider(DocksideConfig config) {
        this.config = config;
    }

    // ===================================================================================
    //                                                                          Adjustment
    //                                                                          ==========
    @Override
    public boolean isForcedRoutingExcept(HttpServletRequest request, String requestPath) {
        return !requestPath.contains(API_URL_PREFIX);
    }

    @Override
    public String customizeActionMappingRequestPath(String requestPath) {
        // action class name does not need 'Api' prefix
        return DfStringUtil.substringFirstRear(requestPath, API_URL_PREFIX);
    }

    @Override
    public boolean isForced404NotFoundRouting(HttpServletRequest request, String requestPath) {
        if (!config.isSwaggerEnabled() && isSwaggerRequest(requestPath)) { // e.g. swagger's html, css
            return true; // to suppress direct access to swagger resources at e.g. production
        }
        return super.isForced404NotFoundRouting(request, requestPath);
    }

    private boolean isSwaggerRequest(String requestPath) {
        return requestPath.startsWith("/webjars/swagger-ui") || requestPath.startsWith("/swagger");
    }
}