public final /*virtual*/ RValue GenerateMessageSend(final CodeGenFunction /*&*/ CGF, 
                   ReturnValueSlot ReturnSlot, 
                   QualType ResultType, 
                   Selector Sel, 
                   Value /*P*/ Receiver, 
                   final /*const*/ CallArgList /*&*/ CallArgs) /* = 0*/ {
  return GenerateMessageSend(CGF, ReturnSlot, ResultType, Sel, Receiver, CallArgs, null);
}
public final /*virtual*/ RValue GenerateMessageSend(final CodeGenFunction /*&*/ CGF, 
                   ReturnValueSlot ReturnSlot, 
                   QualType ResultType, 
                   Selector Sel, 
                   Value /*P*/ Receiver, 
                   final /*const*/ CallArgList /*&*/ CallArgs, 
                   /*const*/ ObjCInterfaceDecl /*P*/ Class/*= null*/)/* = 0*/{
  return GenerateMessageSend(CGF, ReturnSlot, ResultType, Sel, Receiver, CallArgs, Class, null);
}
public final /*virtual*/ RValue GenerateMessageSendSuper(final CodeGenFunction /*&*/ CGF, 
                        ReturnValueSlot ReturnSlot, 
                        QualType ResultType, 
                        Selector Sel, 
                        /*const*/ ObjCInterfaceDecl /*P*/ Class, 
                        boolean isCategoryImpl, 
                        Value /*P*/ Self, 
                        boolean IsClassMessage, 
                        final /*const*/ CallArgList /*&*/ CallArgs)/* = 0*/ {
  return GenerateMessageSendSuper(CGF, ReturnSlot, ResultType, Sel, Class, isCategoryImpl, Self, IsClassMessage, CallArgs, null);
}
public /*virtual*/ Function /*P*/ GenerateMethod(/*const*/ ObjCMethodDecl /*P*/ OMD)/* = 0*/ {
  return GenerateMethod(OMD, null);
}
public /*virtual*/ void EmitThrowStmt(final CodeGenFunction /*&*/ CGF, 
             final /*const*/ ObjCAtThrowStmt /*&*/ S)/* = 0*/ {
  EmitThrowStmt(CGF, S, true);
}
public /*virtual*/ void EmitObjCGlobalAssign(final CodeGenFunction /*&*/ CGF, 
                    Value /*P*/ src, Address dest)/* = 0*/ {
  EmitObjCGlobalAssign(CGF, src, dest, false);
}
public /*virtual*/ GlobalVariable /*P*/ GetClassGlobal(StringRef Name)/* = 0*/{
  return GetClassGlobal(Name, false);
}
