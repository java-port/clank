public BumpPtrAllocatorImpl(/*size_t*/int SlabSize, /*size_t*/int SizeThreshold) {
  this(new MallocAllocator(), SlabSize, SizeThreshold);
}

public BumpPtrAllocatorImpl(JavaDifferentiators.JD$Move INSTANCE, BumpPtrAllocatorImpl Memory) {
  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

public void Deallocate(Object Ptr, int Size) {
  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}
