public DeferredGlobal() { 
  this.GV = new TrackingVH<GlobalValue>();
  this.GD = new GlobalDecl();
}

@Override public DeferredGlobal clone() { 
  return new DeferredGlobal(this); 
}
