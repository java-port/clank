@Converted(kind = Converted.Kind.MANUAL_ADDED)
public /*inline*/ DeductionFailureInfo(final DeductionFailureInfo /*&*/$Prm0) {
  this.Result = $uint2uint_8bits($8bits_uint2uint($Prm0.Result));
  this.HasDiagnostic = $Prm0.HasDiagnostic;
  this.Data = $Prm0.Data;
  this.Unnamed_field3 = new Unnamed_union1(JD$Move.INSTANCE, $Prm0.Unnamed_field3);
}