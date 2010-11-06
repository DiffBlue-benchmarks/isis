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

package org.apache.isis.runtime.testsystem;

import java.lang.reflect.Modifier;

import org.apache.isis.metamodel.runtimecontext.ObjectInstantiationException;
import org.apache.isis.runtime.persistence.objectfactory.ObjectFactoryAbstract;
import org.apache.isis.runtime.persistence.objectfactory.ObjectFactoryAbstract.Mode;

public class TestObjectFactory extends ObjectFactoryAbstract {

    public TestObjectFactory() {
    }

    public TestObjectFactory(Mode mode) {
        super(mode);
    }

    /**
     * Simply instantiates reflectively, does not enhance bytecode etc in any way.
     */
    @Override
    protected <T> T doInstantiate(Class<T> cls) throws ObjectInstantiationException {
        if (Modifier.isAbstract(cls.getModifiers())) {
            throw new ObjectInstantiationException("Cannot create an instance of an abstract class: " + cls);
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            throw new ObjectInstantiationException(e);
        } catch (InstantiationException e) {
            throw new ObjectInstantiationException(e);
        }
    }

}
