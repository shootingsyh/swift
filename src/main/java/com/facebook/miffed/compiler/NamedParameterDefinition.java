/*
 * Copyright 2004-present Facebook. All Rights Reserved.
 */
package com.facebook.miffed.compiler;

import com.google.common.base.Function;

import javax.annotation.Nullable;

import static com.facebook.miffed.compiler.ParameterizedType.type;

public class NamedParameterDefinition
{
    public static NamedParameterDefinition arg(Class<?> type)
    {
        return new NamedParameterDefinition(null, type(type));
    }

    public static NamedParameterDefinition arg(String name, Class<?> type)
    {
        return new NamedParameterDefinition(name, type(type));
    }

    public static NamedParameterDefinition arg(ParameterizedType type)
    {
        return new NamedParameterDefinition(null, type);
    }

    public static NamedParameterDefinition arg(String name, ParameterizedType type)
    {
        return new NamedParameterDefinition(name, type);
    }

    private final ParameterizedType type;
    private final String name;

    NamedParameterDefinition(String name, ParameterizedType type)
    {
        this.name = name;
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public ParameterizedType getType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder();
        sb.append("NamedParameterDefinition");
        sb.append("{name='").append(name).append('\'');
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }

    public static Function<NamedParameterDefinition, ParameterizedType> getNamedParameterType()
    {
        return new Function<NamedParameterDefinition, ParameterizedType>()
        {
            @Override
            public ParameterizedType apply(@Nullable NamedParameterDefinition input)
            {
                return input.getType();
            }
        };
    }
}