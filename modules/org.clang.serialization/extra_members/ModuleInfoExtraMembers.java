public /*inline*/ ModuleInfo(final ModuleInfo /*&&*/$Prm0) {
  // : File(static_cast<ModuleInfo &&>().File), FileName(static_cast<ModuleInfo &&>().FileName), Size(static_cast<ModuleInfo &&>().Size), ModTime(static_cast<ModuleInfo &&>().ModTime), Dependencies(static_cast<ModuleInfo &&>().Dependencies) 
  //START JInit
  this.File = $Prm0.File;
  this.FileName = new std.string($Prm0.FileName);
  this.Size = $Prm0.Size;
  this.ModTime = $Prm0.ModTime;
  this.Dependencies = new SmallVectorUInt($Prm0.Dependencies);
  //END JInit
}

@Override public ModuleInfo clone() {
  return new ModuleInfo(this);
}

@Override public ModuleInfo move() {
  return new ModuleInfo(JD$Move.INSTANCE, this);
}
