public void $MemoryCopy(final /*const*/ CXXScopeSpec /*&*/ Other) {
  this.Range.$assign(Other.Range); // It is ok to use assign here
  this.Builder.$MemoryCopy(Other.Builder);
}
