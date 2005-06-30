package org.nakedobjects.object;

import org.nakedobjects.object.control.Hint;
import org.nakedobjects.object.control.MockHint;
import org.nakedobjects.object.persistence.Oid;
import org.nakedobjects.object.reflect.Action;
import org.nakedobjects.object.reflect.ActionParameterSet;
import org.nakedobjects.object.reflect.NakedObjectAssociation;
import org.nakedobjects.object.reflect.NakedObjectField;
import org.nakedobjects.object.reflect.OneToManyAssociation;
import org.nakedobjects.object.reflect.OneToOneAssociation;
import org.nakedobjects.utility.ExpectedCalls;

import java.util.Date;
import java.util.Hashtable;


public class MockNakedObject implements NakedObject {

    public ExpectedCalls calls = new ExpectedCalls();
    private Hashtable fields = new Hashtable();
    private MockHint hint;
    private Object object;
    private Oid oid;
    private boolean persistDirty;
    private boolean resolved;
    private NakedObjectSpecification specification;
    private String titleString;
    private long version;
    private boolean viewDirty;

    public void checkLock(long version) {}

    public void clearAssociation(NakedObjectAssociation specification, NakedObject ref) {}

    public void clearCollection(OneToManyAssociation association) {}

    public void clearPersistDirty() {}

    public void clearValue(OneToOneAssociation specification) {}

    public void clearViewDirty() {}

    public void copyObject(Naked object) {}

    public void created() {}

    public void debugClearResolved() {}

    public void deleted() {}

    public Naked execute(Action action, Naked[] parameters) {
        calls.addActualMethod("execute");
        calls.addActualParameter(action);
        return null;
    }

    public NakedObject getAssociation(OneToOneAssociation field) {
        return null;
    }

    public Naked getField(NakedObjectField field) {
        return (Naked) fields.get(field.getName());
    }

    public NakedObjectField[] getFields() {
        return new NakedObjectField[0];
    }

    public Hint getHint(Action action, Naked[] parameters) {
        return hint;
    }

    public Hint getHint(NakedObjectField field, Naked value) {
        return hint;
    }

    public String getIconName() {
        return null;
    }

    public String getLabel(Action action) {
        return null;
    }

    public String getLabel(NakedObjectField field) {
        return null;
    }

    public Object getObject() {
        return object;
    }

    public Oid getOid() {
        return oid;
    }

    public ActionParameterSet getParameters(Action action) {
        return null;
    }

    public NakedObjectSpecification getSpecification() {
        return specification;
    }

    public NakedValue getValue(OneToOneAssociation field) {
        return null;
    }

    public long getVersion() {
        return version;
    }

    public NakedObjectField[] getVisibleFields() {
        return null;
    }

    public void initAssociation(NakedObjectAssociation field, NakedObject associatedObject) {}

    public void initOneToManyAssociation(OneToManyAssociation association, NakedObject[] instances) {}

    public void initValue(OneToOneAssociation field, Object object) {}

    public boolean isEmpty(NakedObjectField field) {
        return false;
    }

    public boolean isParsable() {
        return false;
    }

    public boolean isPersistDirty() {
        return persistDirty;
    }

    public boolean isPersistent() {
        return false;
    }

    public boolean isResolved() {
        return resolved;
    }

    public boolean isViewDirty() {
        return viewDirty;
    }

    public void markDirty() {}

    public void parseTextEntry(OneToOneAssociation specification, String text) throws TextEntryParseException,
            InvalidEntryException {}

    public Persistable persistable() {
        return null;
    }

    public void setAssociation(NakedObjectAssociation field, NakedObject associatedObject) {}

    public void setOid(Oid oid) {
        this.oid = oid;
    }

    public void setOptimisticLock(long version, String user, Date time) {}

    public void setResolved() {
        resolved = true;
    }

    public void setupDirty() {
        persistDirty = true;
    }

    public void setupField(String name, Naked field) {
        this.fields.put(name, field);
    }

    public void setupHint(MockHint hint) {
        this.hint = hint;
    }

    public void setupObject(Object object) {
        this.object = object;
    }

    public void setupSpecification(NakedObjectSpecification specification) {
        this.specification = specification;
    }

    public void setupTitleString(String titleString) {
        this.titleString = titleString;
    }

    public void setupViewDirty(boolean b) {
        viewDirty = b;
    }

    public void setValue(OneToOneAssociation field, Object object) {}

    public void setVersion(long version) {
        this.version = version;
    }

    public String titleString() {
        return titleString;
    }
}

/*
 * Naked Objects - a framework that exposes behaviourally complete business
 * objects directly to the user. Copyright (C) 2000 - 2005 Naked Objects Group
 * Ltd
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place, Suite 330, Boston, MA 02111-1307 USA
 * 
 * The authors can be contacted via www.nakedobjects.org (the registered address
 * of Naked Objects Group is Kingsway House, 123 Goldworth Road, Woking GU21
 * 1NR, UK).
 */