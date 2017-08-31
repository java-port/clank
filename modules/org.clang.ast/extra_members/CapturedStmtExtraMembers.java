private type$ptr<Capture> init$StoredCaptures$Mem(int NumCaptures) {
  /*uint*/int Size =(true/*JAVA*/ ? 1 : $sizeof_CapturedStmt()) + (true/*JAVA*/ ? 1 : $sizeof_ptr(/*Stmt  */)) * (NumCaptures + 1);
//    
  // Offset of the first Capture object.
  /*uint*/int FirstCaptureOffset = $ulong2uint(llvm.alignTo($uint2ulong(Size), $uint2ulong((true/*JAVA*/ ? 1 : llvm.<Capture>alignOf(Capture.class)))));

//    return reinterpret_cast(Capture /*P*/ .class, reinterpret_cast(char$ptr/*char P*/ .class, ((/*const_cast*/CapturedStmt /*P*/ )(this))).$add(FirstCaptureOffset));
  return (type$ptr<Capture>)super.$this().$add(FirstCaptureOffset);
}
private final type$ptr</*const*/ Capture /*P*/ /*const*/ /*P*/> $Captures;

@Override public final type$ptr<?> $TrailingObjects() {
  return super.$this$plus1();
}
