/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.http.policy.internal;

import static org.mule.runtime.config.spring.dsl.api.AttributeDefinition.Builder.fromChildCollectionConfiguration;
import static org.mule.runtime.config.spring.dsl.api.AttributeDefinition.Builder.fromChildConfiguration;
import static org.mule.runtime.config.spring.dsl.api.TypeDefinition.fromType;
import org.mule.runtime.config.spring.dsl.api.ComponentBuildingDefinition;
import org.mule.runtime.config.spring.dsl.api.ComponentBuildingDefinitionProvider;
import org.mule.runtime.core.api.MuleContext;
import org.mule.runtime.core.api.processor.Processor;

import java.util.ArrayList;
import java.util.List;

public class HttpPolicyBuildingDefinitionProvider implements ComponentBuildingDefinitionProvider {

  private ComponentBuildingDefinition.Builder baseDefintion;

  @Override
  public void init(MuleContext muleContext) {
    baseDefintion = new ComponentBuildingDefinition.Builder()
        .withNamespace("http-policy");
  }

  @Override
  public List<ComponentBuildingDefinition> getComponentBuildingDefinitions() {
    ArrayList<ComponentBuildingDefinition> definitions = new ArrayList<>();

    definitions.add(baseDefintion.copy().withIdentifier("policy")
                        .withTypeDefinition(fromType(HttpProxyPolicy.class))
                        .withSetterParameterDefinition("source", fromChildConfiguration(HttpSource.class).build())
                        .withSetterParameterDefinition("request", fromChildConfiguration(HttpRequest.class).build()).build());

    definitions.add(baseDefintion.copy().withIdentifier("source")
                        .withTypeDefinition(fromType(HttpSource.class))
                        .withSetterParameterDefinition("pre", fromChildConfiguration(HttpSourcePre.class).build())
                        .withSetterParameterDefinition("post", fromChildConfiguration(HttpSourcePost.class).build()).build());

    definitions.add(baseDefintion.copy().withIdentifier("request")
                        .withTypeDefinition(fromType(HttpRequest.class))
                        .withSetterParameterDefinition("pre", fromChildConfiguration(HttpRequestPre.class).build())
                        .withSetterParameterDefinition("post", fromChildConfiguration(HttpRequestPost.class).build()).build());

    definitions.add(baseDefintion.copy().withIdentifier("source-pre")
                        .withTypeDefinition(fromType(HttpSourcePre.class))
                        .withSetterParameterDefinition("processors", fromChildCollectionConfiguration(Processor.class).build()).build());
      
    definitions.add(baseDefintion.copy().withIdentifier("source-post")
                              .withTypeDefinition(fromType(HttpSourcePost.class))
                              .withSetterParameterDefinition("processors", fromChildCollectionConfiguration(Processor.class).build()).build());

      definitions.add(baseDefintion.copy().withIdentifier("request-pre")
                              .withTypeDefinition(fromType(HttpRequestPre.class))
                              .withSetterParameterDefinition("processors", fromChildCollectionConfiguration(Processor.class).build()).build());

      definitions.add(baseDefintion.copy().withIdentifier("request-post")
                              .withTypeDefinition(fromType(HttpRequestPost.class))
                              .withSetterParameterDefinition("processors", fromChildCollectionConfiguration(Processor.class).build()).build());
    return definitions;
  }
}
