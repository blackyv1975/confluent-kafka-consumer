/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.vinc.confluentkafkaconsumer.avro;
@org.apache.avro.specific.AvroGenerated
public enum TransactionType implements org.apache.avro.generic.GenericEnumSymbol<TransactionType> {
  WITHDRAWAL, DEPOSIT, TRANSFER  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"TransactionType\",\"namespace\":\"com.vinc.confluentkafkaconsumer.avro\",\"symbols\":[\"WITHDRAWAL\",\"DEPOSIT\",\"TRANSFER\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}