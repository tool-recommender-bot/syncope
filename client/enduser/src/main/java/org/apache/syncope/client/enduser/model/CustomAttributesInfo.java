/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.syncope.client.enduser.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomAttributesInfo implements Serializable {

    private static final long serialVersionUID = 878444785696091916L;

    private Boolean show = Boolean.TRUE;

    private Map<String, CustomAttribute> attributes = new LinkedHashMap<>();

    public CustomAttributesInfo() {
    }

    public Boolean isShow() {
        return show;
    }

    public void setShow(final Boolean show) {
        this.show = show;
    }

    public Map<String, CustomAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(final Map<String, CustomAttribute> attributes) {
        this.attributes = attributes;
    }

    public CustomAttributesInfo show(final Boolean value) {
        this.show = value;
        return this;
    }

    public CustomAttributesInfo attributes(final Map<String, CustomAttribute> value) {
        this.attributes = value;
        return this;
    }

}