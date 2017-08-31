@Override public RequestNodeVisitor clone() {
  return new RequestNodeVisitor(this);
}

public RequestNodeVisitor(/*const*/ MemRegion /*P*/ /*const*/ MemoryRegion, 
  final /*const*/char$ptr/*&*/ ErrText) {
  this(MemoryRegion, new std.string(ErrText));
} 
