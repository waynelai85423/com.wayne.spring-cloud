package com.wayne.utils;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class UpperCasePhysicalNamingStrategy implements PhysicalNamingStrategy {

    private static final CamelCaseToUnderscoresNamingStrategy strategy = new CamelCaseToUnderscoresNamingStrategy();

    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        Identifier physicalTableName = strategy.toPhysicalTableName(identifier, jdbcEnvironment);
        Identifier physicalTableNameUpdated = new Identifier(physicalTableName.toString().toLowerCase(Locale.ROOT).replace("_entity", ""),false);
        return physicalTableNameUpdated;
    }

    @Override
    public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return strategy.toPhysicalCatalogName(identifier, jdbcEnvironment);
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return strategy.toPhysicalSchemaName(identifier, jdbcEnvironment);
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return strategy.toPhysicalSequenceName(identifier,jdbcEnvironment);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        return strategy.toPhysicalColumnName(logicalName, jdbcEnvironment);
    }

}
