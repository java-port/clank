public AccessedEntity() {
  this.Access = 0;
  this.IsMember = false;
  this.Target = null;
  this.NamingClass = null;
  this.BaseObjectType = new QualType();
  this.Diag = new PartialDiagnostic(new PartialDiagnostic.NullDiagnostic());
}

public /*inline*/ AccessedEntity /*&*/ $assignMove(final AccessedEntity /*&&*/$Prm0) {
  this.Access = $Prm0.Access;
  this.IsMember = $Prm0.IsMember;
  this.Target = $Prm0.Target;
  $Prm0.Target = null;
  this.NamingClass = $Prm0.NamingClass;
  $Prm0.NamingClass = null;
  this.BaseObjectType = $Prm0.BaseObjectType;
  $Prm0.BaseObjectType = null;
  this.Diag = $Prm0.Diag;
  $Prm0.Diag = null;
  return /*Deref*/this;
}  

public /*inline*/ AccessedEntity /*&*/ $MemoryCopy(final AccessedEntity /*&&*/$Prm0) {
  this.Access = $Prm0.Access;
  this.IsMember = $Prm0.IsMember;
  this.Target = $Prm0.Target;
  this.NamingClass = $Prm0.NamingClass;
  this.BaseObjectType.$assign($Prm0.BaseObjectType);
  this.Diag.$MemoryCopy($Prm0.Diag);
  return /*Deref*/this;
}
