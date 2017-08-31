public AvailabilitySpec() {
  this.Version = new VersionTuple();
  this.Platform = new StringRef();
  this.BeginLoc = new SourceLocation();
  this.EndLoc = new SourceLocation();
}

public /*inline*/ AvailabilitySpec(final AvailabilitySpec /*&&*/$Prm0) {
  // : Version(static_cast<AvailabilitySpec &&>().Version), Platform(static_cast<AvailabilitySpec &&>().Platform), BeginLoc(static_cast<AvailabilitySpec &&>().BeginLoc), EndLoc(static_cast<AvailabilitySpec &&>().EndLoc) 
  //START JInit
  this.Version = new VersionTuple($Prm0.Version);
  this.Platform = new StringRef($Prm0.Platform);
  this.BeginLoc = new SourceLocation($Prm0.BeginLoc);
  this.EndLoc = new SourceLocation($Prm0.EndLoc);
  //END JInit
}

@Override public AvailabilitySpec clone() {
  return new AvailabilitySpec(this);
}

@Override public AvailabilitySpec move() {
  return new AvailabilitySpec(JD$Move.INSTANCE, this);
}
