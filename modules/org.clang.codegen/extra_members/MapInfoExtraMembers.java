@Converted(kind = Converted.Kind.MANUAL)
public MapInfo(ArrayRef<OMPClauseMappableExprCommon.MappableComponent> Components, OpenMPMapClauseKind MapType, OpenMPMapClauseKind MapTypeModifier) {
  this.Components = Components;
  this.MapType = MapType;
  this.MapTypeModifier = MapTypeModifier;
}