@Converted(kind = Converted.Kind.MANUAL_ADDED)
private /*inline*/ InferredDirectory(InferredDirectory /*&&*/$Prm0) {
  /* : InferModules(static_cast<InferredDirectory &&>().InferModules), Attrs(static_cast<InferredDirectory &&>().Attrs), ModuleMapFile(static_cast<InferredDirectory &&>().ModuleMapFile), ExcludedModules(static_cast<InferredDirectory &&>().ExcludedModules)*/ 
  //START JInit
  this.InferModules = $Prm0.InferModules;
  this.Attrs = new Attributes($Prm0.Attrs);
  this.ModuleMapFile = $Prm0.ModuleMapFile;
  this.ExcludedModules = new SmallVector<std.string>($Prm0.ExcludedModules);
  //END JInit
}

@Override
@Converted(kind = Converted.Kind.MANUAL_ADDED)
public InferredDirectory $assign(InferredDirectory $Prm0) {
  this.InferModules = $Prm0.InferModules;
  this.Attrs = new Attributes($Prm0.Attrs);
  this.ModuleMapFile = $Prm0.ModuleMapFile;
  this.ExcludedModules = new SmallVector<std.string>($Prm0.ExcludedModules);
  return this;
}

@Override
@Converted(kind = Converted.Kind.MANUAL_ADDED)
public InferredDirectory clone() {
  return new InferredDirectory(this);
}

@Override
@Converted(kind = Converted.Kind.MANUAL_ADDED)
public boolean $eq(InferredDirectory other) {
  if (this == other) {
    return true;
  }
  if (other == null) {
    return false;
  }
  if (this.InferModules != other.InferModules) {
    return false;
  }
  if (this.ModuleMapFile != other.ModuleMapFile) {
    return false;
  }
  if (this.ExcludedModules.$noteq(other.ExcludedModules)) {
    return false;
  }
  if (this.Attrs.$noteq(other.Attrs)) {
    return false;
  }
  return true;
}
