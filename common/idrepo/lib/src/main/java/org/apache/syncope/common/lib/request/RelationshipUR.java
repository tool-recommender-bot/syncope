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
package org.apache.syncope.common.lib.request;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.syncope.common.lib.to.RelationshipTO;

@XmlRootElement(name = "relationshipUR")
@XmlType
public class RelationshipUR extends AbstractPatch {

    private static final long serialVersionUID = 1314175521205206511L;

    public static class Builder extends AbstractPatch.Builder<RelationshipUR, Builder> {

        public Builder(final RelationshipTO relationshipTO) {
            super();
            getInstance().setRelationshipTO(relationshipTO);
        }

        @Override
        protected RelationshipUR newInstance() {
            return new RelationshipUR();
        }
    }

    private RelationshipTO relationshipTO;

    public RelationshipTO getRelationshipTO() {
        return relationshipTO;
    }

    public void setRelationshipTO(final RelationshipTO relationshipTO) {
        this.relationshipTO = relationshipTO;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().
                appendSuper(super.hashCode()).
                append(relationshipTO).
                build();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RelationshipUR other = (RelationshipUR) obj;
        return new EqualsBuilder().
                appendSuper(super.equals(obj)).
                append(relationshipTO, other.relationshipTO).
                build();
    }
}
