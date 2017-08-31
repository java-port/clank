public ImplicitNullDerefEvent(SVal Location, boolean IsLoad, ExplodedNode SinkNode, BugReporter BR, boolean IsDirectDereference) {
  this.Location = Location;
  this.IsLoad = IsLoad;
  this.SinkNode = SinkNode;
  this.BR = BR;
  this.IsDirectDereference = IsDirectDereference;
}