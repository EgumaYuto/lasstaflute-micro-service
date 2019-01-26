package org.docksidestage.app.web.healthcheck;

import org.docksidestage.app.web.base.DocksideBaseAction;
import org.lastaflute.web.Execute;
import org.lastaflute.web.login.AllowAnyoneAccess;
import org.lastaflute.web.response.JsonResponse;

/**
 * @author cabos
 */
@AllowAnyoneAccess
public class HealthcheckAction extends DocksideBaseAction {

    @Execute
    public JsonResponse<HealthcheckResult> get$index() {
        return asJson(new HealthcheckResult());
    }
}
