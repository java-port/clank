@Override public abstract CallEvent clone();

protected CallEvent(/*const*/ Decl /*P*/ D, IntrusiveRefCntPtr</*const*/ ProgramState> state, /*const*/ LocationContext /*P*/ lctx, JD$Clean _dparm) {
  this(D, state, lctx);
  // do cleanup
  if (_dparm != null) state.$destroy();
}

protected CallEvent(/*const*/ Expr /*P*/ E, IntrusiveRefCntPtr</*const*/ ProgramState> state, /*const*/ LocationContext /*P*/ lctx, JD$Clean _dparm) { 
  this(E, state, lctx);
  // do cleanup
  if (_dparm != null) state.$destroy();
}
