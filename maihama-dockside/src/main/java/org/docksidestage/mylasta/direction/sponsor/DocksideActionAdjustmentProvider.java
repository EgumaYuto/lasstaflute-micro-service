package org.docksidestage.mylasta.direction.sponsor;

import javax.servlet.http.HttpServletRequest;

import org.dbflute.util.DfStringUtil;

/**
 * @author cabos
 */
public class DocksideActionAdjustmentProvider extends MaihamaActionAdjustmentProvider {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final String API_URL_PREFIX = "/api"; // to be separated from angular request

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
}