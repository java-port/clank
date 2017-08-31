protected static int $sizeof_SourceLocation() {
  return 1;
}

protected static int $sizeof_ptr_TypeSourceInfo() {
  return 1;
}

@Override
protected LocalData createJavaEmptyLocalTypeLocInfo() {
  return (LocalData) new ObjCObjectTypeLocInfo();
}

@Override
protected Class<? extends ObjCObjectType> getTypeClass() {
  return ObjCObjectType.class;
}


@Override protected final void initJavaExtraLocalData(type$ptr extraLocalData$Ptr, int NumExtra) {
  assert NumExtra == (this.getNumTypeArgs() + this.getNumProtocols()) : "expect request for extra data for TypeSourceInfo pointers and SourceLocations";
  if (NativeTrace.isDebugMode()) {
    // as extra data we keep TemplateArgumentLocInfo pointers, check that array size is enough and contains nulls
    for (int idx = 0; idx < this.getNumTypeArgs(); idx++) {
      assert extraLocalData$Ptr.$at(idx) == null : "must be not occupied placeholder for TemplateArgumentLocInfo *";
    }
  }
  // must have non-null values
  for (int idx = this.getNumTypeArgs(); idx < NumExtra; idx++) {
    assert extraLocalData$Ptr.$at(idx) == null : "must be not occupied placeholder for SourceLocation";
    extraLocalData$Ptr.$set(idx, new SourceLocation());
  }
}
