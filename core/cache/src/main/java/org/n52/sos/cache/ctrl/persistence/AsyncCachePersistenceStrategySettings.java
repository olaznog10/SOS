/**
 * Copyright (C) 2012-2015 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public
 * License version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 */
package org.n52.sos.cache.ctrl.persistence;

import java.util.Collections;
import java.util.Set;

import org.n52.sos.cache.ctrl.AbstractSchedulingContentCacheController;
import org.n52.sos.config.SettingDefinition;
import org.n52.sos.config.SettingDefinitionProvider;
import org.n52.sos.config.settings.IntegerSettingDefinition;
import org.n52.sos.service.ServiceSettings;

/**
 * Settings for the {@link AbstractSchedulingContentCacheController}.
 *
 * @author Christian Autermann <c.autermann@52north.org>
 *
 * @since 4.0.0
 */
public class AsyncCachePersistenceStrategySettings implements
        SettingDefinitionProvider {
    public static final String CACHE_PERSISTENCE_DELAY
            = "service.cachePersistenceDelay";

    public static final IntegerSettingDefinition CACHE_PERSISTENCE_DELAY_DEFINITION
            = new IntegerSettingDefinition()
            .setGroup(ServiceSettings.GROUP)
            .setOrder(6.1F)
            .setKey(CACHE_PERSISTENCE_DELAY)
            .setDefaultValue(30)
            .setMinimum(1)
            .setTitle("Content cache persistence delay")
            .setDescription("The time in seconds, for which writing of an updated " +
                            "cache is delayed. Incremental cache updates that are executed " +
                            "during transactional operations are not immediately persistet, " +
                            "but are delayed to reduce write operations and to improve performance. " +
                            "The delay is the maximum time the persisted and in memory cache " +
                            "can diverge.");

    @Override
    public Set<SettingDefinition<?, ?>> getSettingDefinitions() {
        return Collections.<SettingDefinition<?, ?>>singleton(CACHE_PERSISTENCE_DELAY_DEFINITION);
    }
}
