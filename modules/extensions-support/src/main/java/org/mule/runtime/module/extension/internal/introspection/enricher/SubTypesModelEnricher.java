/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.module.extension.internal.introspection.enricher;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.mule.runtime.module.extension.internal.introspection.describer.MuleExtensionAnnotationParser.parseRepeatableAnnotation;
import static org.mule.runtime.module.extension.internal.util.IntrospectionUtils.getMetadataType;
import org.mule.metadata.api.ClassTypeLoader;
import org.mule.runtime.core.util.collection.ImmutableListCollector;
import org.mule.runtime.extension.api.annotation.SubTypeMapping;
import org.mule.runtime.extension.api.annotation.SubTypesMapping;
import org.mule.runtime.extension.api.exception.IllegalModelDefinitionException;
import org.mule.runtime.extension.api.introspection.declaration.DescribingContext;
import org.mule.runtime.api.meta.model.declaration.fluent.ExtensionDeclaration;
import org.mule.runtime.api.meta.model.declaration.fluent.ExtensionDeclarer;
import org.mule.runtime.extension.api.introspection.declaration.type.ExtensionsTypeLoaderFactory;
import org.mule.runtime.api.meta.model.ImportedTypeModel;

import java.util.List;

/**
 * Test the extension type to be annotated with {@link SubTypeMapping}, in which case it adds an
 * {@link ImportedTypeModel} on the extension level.
 *
 * @since 4.0
 */
public final class SubTypesModelEnricher extends AbstractAnnotatedModelEnricher {

  private ClassTypeLoader typeLoader;

  @Override
  public void enrich(DescribingContext describingContext) {
    ExtensionDeclarer declarer = describingContext.getExtensionDeclarer();
    ExtensionDeclaration extensionDeclaration = declarer.getDeclaration();

    Class<?> type = extractExtensionType(extensionDeclaration);
    typeLoader = ExtensionsTypeLoaderFactory.getDefault().createTypeLoader(type.getClassLoader());

    List<SubTypeMapping> typeMappings = parseRepeatableAnnotation(type, SubTypeMapping.class, c -> ((SubTypesMapping) c).value());
    if (!typeMappings.isEmpty()) {
      declareSubTypesMapping(declarer, typeMappings, extensionDeclaration.getName());
    }
  }

  private void declareSubTypesMapping(ExtensionDeclarer declarer, List<SubTypeMapping> typeMappings, String name) {
    if (typeMappings.stream().map(SubTypeMapping::baseType).distinct().collect(toList()).size() != typeMappings.size()) {
      throw new IllegalModelDefinitionException(String
          .format("There should be only one SubtypeMapping for any given base type in extension [%s]."
              + " Duplicated base types are not allowed", name));
    }

    typeMappings.forEach(mapping -> declarer.withSubTypes(getMetadataType(mapping.baseType(), typeLoader),
                                                          stream(mapping.subTypes())
                                                              .map(subType -> getMetadataType(subType, typeLoader))
                                                              .collect(new ImmutableListCollector<>())));
  }

}
