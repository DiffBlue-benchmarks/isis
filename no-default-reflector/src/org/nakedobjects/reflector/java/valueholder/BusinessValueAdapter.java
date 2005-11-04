package org.nakedobjects.reflector.java.valueholder;

import org.nakedobjects.application.ValueParseException;
import org.nakedobjects.application.valueholder.BusinessValueHolder;
import org.nakedobjects.object.TextEntryParseException;
import org.nakedobjects.object.value.adapter.AbstractNakedValue;

public class BusinessValueAdapter extends AbstractNakedValue {
    private final BusinessValueHolder adaptee;
    
    public BusinessValueAdapter(final BusinessValueHolder adaptee) {
        this.adaptee = adaptee;
    }
    
    public void parseTextEntry(String text) {
        try{
            adaptee.parseUserEntry(text);
        } catch(ValueParseException e) {
            throw new TextEntryParseException(e.getMessage(), e);
        }
    }

    public byte[] asEncodedString() {
        return adaptee.asEncodedString().getBytes();
    }

    public void restoreFromEncodedString(byte[] data) {
        String text = new String(data);
        adaptee.restoreFromEncodedString(text);
    }

    public Object getObject() {
        return adaptee;
    }

    public String getIconName() {
        return "text";
    }
    
    public String toString() {
        return "POJO BusinessValueAdapter: " + adaptee.titleString();
    }
    
    public String titleString() {
        return adaptee.titleString();
    }
    

    public String getValueClass() {
        return adaptee.getClass().getName();
    }
    
    public boolean canClear() {
        return true;
    }
    
    public void clear() {
      	adaptee.clear();
    }
    
    public boolean isEmpty() {
        return adaptee.isEmpty();
    }
    
}


/*
Naked Objects - a framework that exposes behaviourally complete
business objects directly to the user.
Copyright (C) 2000 - 2005  Naked Objects Group Ltd

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

The authors can be contacted via www.nakedobjects.org (the
registered address of Naked Objects Group is Kingsway House, 123 Goldworth
Road, Woking GU21 1NR, UK).
*/