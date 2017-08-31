public /*inline*/ Unnamed_union3() {
  this.DeprecationData = new DD();
  this.ForbiddenTypeData = new FTD();
  this.AccessData = new AccessedEntity();
}

public /*inline*/ Unnamed_union3(final Unnamed_union3 $Prm0) {
  this.DeprecationData = new DD($Prm0.DeprecationData);
  this.ForbiddenTypeData = new FTD($Prm0.ForbiddenTypeData);
  this.AccessData = new AccessedEntity().$MemoryCopy($Prm0.AccessData);
}

@Override
public /*inline*/ Unnamed_union3 $assign(final Unnamed_union3 $Prm0) {

  this.DeprecationData.$assign($Prm0.DeprecationData);

  this.ForbiddenTypeData.$assign($Prm0.ForbiddenTypeData);

  this.AccessData.$MemoryCopy($Prm0.AccessData);

  return /*Deref*/this;
}

@Override
public boolean $eq(Unnamed_union3 other) {
  if (this == other) {
    return true;
  }
  if (other == null) {
    return false;
  }
  if (!Objects.equals(this.DeprecationData, other.DeprecationData)) {
    return false;
  }
  if (!Objects.equals(this.ForbiddenTypeData, other.ForbiddenTypeData)) {
    return false;
  }
  if (!Objects.equals(this.AccessData, other.AccessData)) {
    return false;
  }
  return true;
}

@Override
public Unnamed_union3 clone() {
  return new Unnamed_union3(this);
}
