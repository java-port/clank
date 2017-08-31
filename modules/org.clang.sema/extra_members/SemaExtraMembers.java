public void AddBuiltinCandidate(QualType ResultTy, QualType[] /*P*/ ParamTys, 
                   ArrayRef<Expr /*P*/ > Args, 
                   final OverloadCandidateSet /*&*/ CandidateSet) {
  AddBuiltinCandidate(ResultTy, create_type$ptr(ParamTys), Args, CandidateSet);
}
public void AddBuiltinCandidate(QualType ResultTy, QualType[] /*P*/ ParamTys, 
                   ArrayRef<Expr /*P*/ > Args, 
                   final OverloadCandidateSet /*&*/ CandidateSet,
                   boolean IsAssignmentOperator/*= false*/) {
  AddBuiltinCandidate(ResultTy, create_type$ptr(ParamTys), Args, CandidateSet, IsAssignmentOperator);
}
public void AddBuiltinCandidate(QualType ResultTy, QualType[] /*P*/ ParamTys, 
                   ArrayRef<Expr /*P*/ > Args, 
                   final OverloadCandidateSet /*&*/ CandidateSet,
                   boolean IsAssignmentOperator/*= false*/, 
       /*uint*/int NumContextualBoolArguments/*= 0*/) {
  AddBuiltinCandidate(ResultTy, create_type$ptr(ParamTys), Args, CandidateSet, IsAssignmentOperator, NumContextualBoolArguments);
}
public void AddBuiltinCandidate(QualType ResultTy, QualType /*P*/ ParamTy, 
                   ArrayRef<Expr /*P*/ > Args, 
                   final OverloadCandidateSet /*&*/ CandidateSet) {
  AddBuiltinCandidate(ResultTy, create_type$ptr(ParamTy), Args, CandidateSet);
}
public void AddBuiltinCandidate(QualType ResultTy, QualType /*P*/ ParamTy, 
                   ArrayRef<Expr /*P*/ > Args, 
                   final OverloadCandidateSet /*&*/ CandidateSet,
                   boolean IsAssignmentOperator/*= false*/) {
  AddBuiltinCandidate(ResultTy, create_type$ptr(ParamTy), Args, CandidateSet, IsAssignmentOperator);
}
public void AddBuiltinCandidate(QualType ResultTy, QualType /*P*/ ParamTy, 
                   ArrayRef<Expr /*P*/ > Args, 
                   final OverloadCandidateSet /*&*/ CandidateSet,
                   boolean IsAssignmentOperator/*= false*/,
       /*uint*/int NumContextualBoolArguments/*= 0*/) {
  AddBuiltinCandidate(ResultTy, create_type$ptr(ParamTy), Args, CandidateSet, IsAssignmentOperator, NumContextualBoolArguments);
}

private static final Comparator<pair<CXXRecordDecl, CXXSpecialMember>> SpecialMembersBeingDeclared$Comparator = new Comparator<pair<CXXRecordDecl, CXXSpecialMember>>() {
  @Override
  public int compare(pair<CXXRecordDecl/*P*/, CXXSpecialMember> lhs, pair<CXXRecordDecl/*P*/, CXXSpecialMember> rhs) {
    if (lhs.first == rhs.first) {
      return lhs.second.getValue() - rhs.second.getValue();
    } else {
      return System.identityHashCode(lhs.first) - System.identityHashCode(rhs.first);
    }
  }    
};