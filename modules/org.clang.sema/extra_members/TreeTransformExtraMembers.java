@Override public void $destroy() {}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public QualType TransformFunctionProtoType(final TypeLocBuilder /*&*/ TLB, 
                            FunctionProtoTypeLoc TL, 
                            CXXRecordDecl /*P*/ ThisContext, 
                            /*uint*/int ThisTypeQuals, 
                            TwoTypes2Bool<ExceptionSpecInfo, bool$ref> TransformExceptionSpec) {
  return TransformFunctionProtoType$TreeTransform(
    TLB, TL, ThisContext, ThisTypeQuals, TransformExceptionSpec
  );
}
