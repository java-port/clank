public UnresolvedModuleRef(UnresolvedModuleRef $Prm0) {
  this.File = $Prm0.File;
  this.Mod = $Prm0.Mod;
  this.Kind = $Prm0.Kind;
  this.ID = $Prm0.ID;
  this.IsWildcard = $Prm0.IsWildcard;
  this.String = new StringRef($Prm0.String);
}

@Override
public UnresolvedModuleRef clone() {
  return new UnresolvedModuleRef(this);
}
