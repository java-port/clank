public ImportedSubmodule() {
  this.ID = 0;
  this.ImportLoc = new SourceLocation();
}

@Override
public ImportedSubmodule clone() {
  return new ImportedSubmodule(this.ID, this.ImportLoc);
}
