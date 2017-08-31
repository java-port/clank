@Override
public FileDeclsInfo $assign(FileDeclsInfo $Prm0) {
  this.Mod = $Prm0.Mod;
  this.Decls.$assign($Prm0.Decls);
  return this;
}

@Override
public FileDeclsInfo clone() {
  return new FileDeclsInfo(Mod, Decls);
}
