private static final ThreadLocalThisSupplier<MDNode> MemorySupplier = ThreadLocalThisSupplier.Create(MDNode::assertThisConsumedByCtor, MDNode.class.getName(), false);
private final type$ptr<?> $This = MemorySupplier.consumeAssignedMemory(this);
/*friend*/type$ptr<?> $This$Ptr() { return $This; }

private static boolean assertThisConsumedByCtor(MDNode createdInstance, type$ptr Mem) {
  assert createdInstance.$This.$eq(Mem) : "expected " + Mem + " vs. " + createdInstance.$This;
  assert Mem.$star() == createdInstance : "createdInstance should be in Mem, but got: " + Mem.$star();
  return true;
}

private static <T extends MDNode> T callConstructorImpl(type$ptr<?> MemoryLocation, New$ConstructorCallback<T> $Ctor) {
  T createdInstance = $Ctor.$call(MemorySupplier.assignMemory(MemoryLocation));
  assert MemorySupplier.assertConsumed(createdInstance, MemoryLocation);
  return createdInstance;
}
protected static <T extends MDNode>/*void P*/ T $new(/*uint*/int NumOps, New$ConstructorCallback<T> $Ctor) {
  return $new(1, NumOps, $Ctor);
}
