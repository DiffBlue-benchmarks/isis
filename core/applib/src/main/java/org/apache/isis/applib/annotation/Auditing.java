/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.isis.applib.annotation;

/**
 * The available policies for auditing changes to the properties of the object.
 */
public enum Auditing {
    /**
     * The auditing of the object should be as per the default auditing policy configured in <tt>isis.properties</tt>.
     *
     * <p>
     *     If no auditing policy is configured, then the auditing is disabled.
     * </p>
     */
    AS_CONFIGURED,
    /**
     * Audit changes to this object.
     */
    ENABLED,
    /**
     * Do not audit changes to this object (even if otherwise configured to enable auditing).
     */
    DISABLED
}