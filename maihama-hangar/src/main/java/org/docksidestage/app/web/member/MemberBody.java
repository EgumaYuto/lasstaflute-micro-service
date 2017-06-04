/*
 * Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.app.web.member;

import java.time.LocalDate;

import org.docksidestage.dbflute.allcommon.CDef;
import org.lastaflute.web.validation.Required;

/**
 * @author jflute
 * @author iwamatsu0430
 * @author black-trooper
 */
public class MemberBody {

    public Integer memberId;

    @Required
    public String memberName;

    @Required
    public String memberAccount;

    @Required
    public CDef.MemberStatus memberStatusCode;

    public LocalDate birthdate;

    @Required
    public Long versionNo;
}