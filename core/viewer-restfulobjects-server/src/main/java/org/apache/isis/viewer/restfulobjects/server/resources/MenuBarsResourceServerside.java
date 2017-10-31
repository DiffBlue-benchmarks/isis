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
package org.apache.isis.viewer.restfulobjects.server.resources;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.isis.applib.annotation.Where;
import org.apache.isis.applib.layout.links.LinkData;
import org.apache.isis.applib.layout.menus.ActionLayoutData;
import org.apache.isis.applib.layout.menus.Menu;
import org.apache.isis.applib.layout.menus.MenuBar;
import org.apache.isis.applib.layout.menus.MenuBars;
import org.apache.isis.applib.layout.menus.MenuSection;
import org.apache.isis.applib.services.bookmark.Bookmark;
import org.apache.isis.applib.services.menu.MenuBarsService;
import org.apache.isis.viewer.restfulobjects.applib.Rel;
import org.apache.isis.viewer.restfulobjects.applib.RepresentationType;
import org.apache.isis.viewer.restfulobjects.applib.RestfulHttpMethod;
import org.apache.isis.viewer.restfulobjects.applib.RestfulMediaType;
import org.apache.isis.viewer.restfulobjects.applib.client.RestfulResponse;
import org.apache.isis.viewer.restfulobjects.applib.menubars.MenuBarsResource;
import org.apache.isis.viewer.restfulobjects.rendering.RestfulObjectsApplicationException;
import org.apache.isis.viewer.restfulobjects.rendering.service.RepresentationService;
import org.apache.isis.viewer.restfulobjects.server.resources.serialization.SerializationStrategy;

public class MenuBarsResourceServerside extends ResourceAbstract implements MenuBarsResource {

    @Override
    @Produces({
            MediaType.APPLICATION_JSON, RestfulMediaType.APPLICATION_JSON_LAYOUT_MENUBARS,
            MediaType.APPLICATION_XML, RestfulMediaType.APPLICATION_XML_LAYOUT_MENUBARS
    })
    public Response menuBars() {
        init(RepresentationType.MENUBARS, Where.ANYWHERE, RepresentationService.Intent.NOT_APPLICABLE);

        final SerializationStrategy serializationStrategy =
                SerializationStrategy.determineFrom(getResourceContext().getAcceptableMediaTypes());

        final Response.ResponseBuilder builder;

        final MenuBarsService menuBarsService =
                getResourceContext().getServicesInjector().lookupService(MenuBarsService.class);

        final MenuBars menuBars = menuBarsService.menuBars();

        // TODO: use add a visitor instead to iterate over (cf Grid)
        addLinksFor(menuBars.getPrimary());
        addLinksFor(menuBars.getSecondary());
        addLinksFor(menuBars.getTertiary());

        builder = Response.status(Response.Status.OK)
                .entity(serializationStrategy.entity(menuBars))
                .type(serializationStrategy.type(RepresentationType.MENUBARS));

        return builder.build();
    }

    private void addLinksFor(final MenuBar menuBar) {
        List<Menu> menus = menuBar.getMenus();
        for (Menu menu : menus) {
            List<MenuSection> sections = menu.getSections();
            for (MenuSection section : sections) {
                List<ActionLayoutData> actions = section.getActions();
                for (ActionLayoutData actionLayoutData : actions) {
                    String oid = actionLayoutData.getOid();
                    Bookmark bookmark = new Bookmark(oid);
                    LinkData link = new LinkData(
                            Rel.ACTION.getName(),
                            RestfulHttpMethod.GET.getJavaxRsMethod(),
                            getResourceContext().urlFor(
                                    "objects/" + bookmark.getObjectType() + "/" + bookmark.getIdentifier() + "/actions/" + actionLayoutData.getId()
                            ),
                            RepresentationType.OBJECT_ACTION.getJsonMediaType().toString());
                    actionLayoutData.setLink(link);
                }
            }
        }
    }

    @Override
    public Response deleteMenuBarsNotAllowed() {
        throw RestfulObjectsApplicationException.createWithMessage(RestfulResponse.HttpStatusCode.METHOD_NOT_ALLOWED, "Deleting the menuBars resource is not allowed.");

    }

    @Override
    public Response putMenuBarsNotAllowed() {
        throw RestfulObjectsApplicationException.createWithMessage(RestfulResponse.HttpStatusCode.METHOD_NOT_ALLOWED, "Putting to the menuBars resource is not allowed.");

    }

    @Override
    public Response postMenuBarsNotAllowed() {
        throw RestfulObjectsApplicationException.createWithMessage(RestfulResponse.HttpStatusCode.METHOD_NOT_ALLOWED, "Posting to the menuBars resource is not allowed.");
    }

}
