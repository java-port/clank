@Override
protected void initJavaExtraLocalData(type$ptr extraLocalData$Ptr, int NumExtra) {
  assert NumExtra == getNumArgs() : "expect request for extra data for arguments pointers only";
  // as extra data we keep TemplateArgumentLocInfo pointers, check that array size is enough and contains nulls
  for (int idx = 0; idx < NumExtra; idx++) {
    assert extraLocalData$Ptr.$at(idx) == null : "must be not occupied placeholder for TemplateArgumentLocInfo *";
    extraLocalData$Ptr.$set(idx, new TemplateArgumentLocInfo());
  }
}

protected static int $sizeof_TemplateArgumentLocInfo() { 
  return 1; 
}

@Override
protected TemplateSpecializationLocInfo createJavaEmptyLocalTypeLocInfo() {
  return new TemplateSpecializationLocInfo();
}

@Override
protected Class<TemplateSpecializationType> getTypeClass() {
  return TemplateSpecializationType.class;
}