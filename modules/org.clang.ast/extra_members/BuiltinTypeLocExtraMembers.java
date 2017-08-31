@Override protected final void initJavaExtraLocalData(type$ptr extraLocalData$Ptr, int NumExtra) {
  assert NumExtra == 1;
  assert needsExtraLocalData();
  assert extraLocalData$Ptr.$star() == null : "Must be null: " + extraLocalData$Ptr.$star();
  extraLocalData$Ptr.$set(new WrittenBuiltinSpecs());
}

@Override protected final BuiltinLocInfo createJavaEmptyLocalTypeLocInfo() { return new BuiltinLocInfo(); }

protected static int $sizeof_WrittenBuiltinSpecs() { return 1;  }    
@Override protected Class<BuiltinType> getTypeClass() { return BuiltinType.class; }
