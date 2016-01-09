/*
 * Copyright 2015-2016 the original author or authors.
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

/**
 * 会員一覧で利用する画面項目DTO。
 * @author jflute
 * @author iwamatsu0430
 */
public class MemberSearchRowBean {

    public Integer memberId;
    public String memberName;
    public String memberStatusName;
    public String formalizedDate;
    public String updateDatetime;
    public boolean withdrawalMember;
    public Integer purchaseCount;
}
