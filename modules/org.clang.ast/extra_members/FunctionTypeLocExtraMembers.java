protected static int $sizeof_ptr_ParmVarDecl() { return 1; }

@Override protected final FunctionLocInfo createJavaEmptyLocalTypeLocInfo() { return new FunctionLocInfo(); }

@Override protected Class<? extends FunctionType> getTypeClass() { return FunctionType.class; }

@Override protected final void initJavaExtraLocalData(type$ptr extraLocalData$Ptr, int NumExtra) {
  assert NumExtra == getNumParams() : "expect request for extra data for param pointers only";
  if (NativeTrace.isDebugMode()) {
    assert !NativeCloneable.class.isAssignableFrom(ParmVarDecl.class) : "(see TypeLoc.DATA_DEEP_COPY) ParmVarDecl must not be cloneable, otherwise we clone values vs. keep pointers ";
    // as extra data we keep ParmVarDecl pointers, check that array size is enough and contains nulls
    for (int idx = 0; idx < NumExtra; idx++) {
      assert extraLocalData$Ptr.$at(idx) == null : "must be not occupied placeholder for ParmVarDecl *";
    }
  }
}
