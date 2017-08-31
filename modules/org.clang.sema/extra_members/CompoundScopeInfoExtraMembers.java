@Override public CompoundScopeInfo clone() { 
  return new CompoundScopeInfo().$assign(this); 
}

@Override
public boolean $eq(CompoundScopeInfo other) {
  return other != null && other.HasEmptyLoopBodies == this.HasEmptyLoopBodies;
}
