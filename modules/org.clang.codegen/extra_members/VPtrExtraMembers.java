public VPtr() {
}

public VPtr(BaseSubobject Base, CXXRecordDecl NearestVBase, CharUnits OffsetFromNearestVBase, CXXRecordDecl VTableClass) {
  this.Base = Base;
  this.NearestVBase = NearestVBase;
  this.OffsetFromNearestVBase = OffsetFromNearestVBase;
  this.VTableClass = VTableClass;
}
