private ASTContext $BF$ASTContext = null;
private BodyFarm/*P*/ $BF = null;
// return Object vs real BodyFarm to prevent API visibility of impl BodyFarm class
public final Object/*BodyFarm*/ $getBodyFarm(final ASTContext /*&*/ C) {
  if ($BF == null) {
    assert $BF$ASTContext == null;
    $BF$ASTContext = C;
    $BF = new BodyFarm(C, this.Injector.get());
  }
  assert $BF$ASTContext == C;
  return $BF;
}

// return cache to be used by ObjCMethodCall vs static function-local variable from ObjCMethodCall.getRuntimeDefinition
public final DenseMap<std.pair</*const*/ ObjCInterfaceDecl /*P*/ , Selector>, 
                      Optional</*const*/ ObjCMethodDecl /*P*/ >> $getObjCInterfaceDecl$Selector$Cache() {
  if (ObjCInterfaceDecl$Selector$Cache == null) {
    ObjCInterfaceDecl$Selector$Cache/*J*/ = 
        new DenseMap<std.pair</*const*/ ObjCInterfaceDecl /*P*/ , Selector>,
                  Optional</*const*/ ObjCMethodDecl /*P*/ >>(
                          new DenseMapInfoPair</*const*/ ObjCInterfaceDecl /*P*/ , Selector>(DenseMapInfo$LikePtr.$Info(), DenseMapInfoSelector.$Info()),
                          new Optional</*const*/ ObjCMethodDecl /*P*/ >());
  }                      
  return ObjCInterfaceDecl$Selector$Cache;
}                      
// JAVA: see comment in ObjCMethodCall.getRuntimeDefinition about concurrent access
private DenseMap<std.pair</*const*/ ObjCInterfaceDecl /*P*/ , Selector>, 
                      Optional</*const*/ ObjCMethodDecl /*P*/ >> ObjCInterfaceDecl$Selector$Cache;
