protected AnyFunctionCall(/*const*/ Expr /*P*/ E, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
  /*const*/ LocationContext /*P*/ LCtx, JD$Clean _dparm) {
  this(E, St, LCtx);
  // do cleanup
  if (_dparm != null) St.$destroy();
}

protected AnyFunctionCall(/*const*/ Decl /*P*/ D, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
  /*const*/ LocationContext /*P*/ LCtx, JD$Clean _dparm) {
  this(D, St, LCtx);
  // do cleanup
  if (_dparm != null) St.$destroy();
}
