SourceMappingRegion(Counter counter, SourceLocation NestedLoc, SourceLocation EndLoc) {
  this.Count = new Counter(Count);
  this.LocStart = Optional.<SourceLocation>create(NestedLoc);
  this.LocEnd = Optional.<SourceLocation>create(EndLoc);
}

public SourceMappingRegion() {
}
