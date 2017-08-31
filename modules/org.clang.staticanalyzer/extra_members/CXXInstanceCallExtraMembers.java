protected CXXInstanceCall(/*const*/ CallExpr /*P*/ CE, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
  /*const*/ LocationContext /*P*/ LCtx, JD$Clean _dparm) {
  this(CE, St, LCtx);
  // do cleanup
  if (_dparm != null) St.$destroy();
}

protected CXXInstanceCall(/*const*/ FunctionDecl /*P*/ D, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
    /*const*/ LocationContext /*P*/ LCtx, JD$Clean _dparm) {
  this(D, St, LCtx);
  // do cleanup
  if (_dparm != null) St.$destroy();
} 
