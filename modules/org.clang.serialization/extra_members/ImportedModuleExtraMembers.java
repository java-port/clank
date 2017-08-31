public ImportedModule() {
  this.ImportLoc = new SourceLocation();
}

@Override
public ImportedModule clone() {
  return new ImportedModule(this.Mod, this.ImportedBy, this.ImportLoc);
}
