protected Type(Type $Prm0) { 
  this.Context = $Prm0.Context; 
  this.ID = $Prm0.ID;
  this.SubclassData = $Prm0.SubclassData;
  this.NumContainedTys = $Prm0.NumContainedTys;
  this.ContainedTys = Native.$Clone($Prm0.ContainedTys);
}

protected static <T> T $new_uint_BumpPtrAllocatorImpl$AllocatorT$SlabSize$SizeThreshold(NativeMemory.BumpAllocator alloc, NativeCallback.New$ConstructorCallback<T/*P*/> New$Type) {
  return New$SExpr.$call(null);
}
