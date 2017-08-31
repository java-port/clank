public NeonIntrinsicInfo(char$ptr NameHint, int BuiltinID, int LLVMIntrinsic, int AltLLVMIntrinsic, int TypeModifier) {
  this.NameHint = $toConst(NameHint);
  this.BuiltinID = BuiltinID;
  this.LLVMIntrinsic = LLVMIntrinsic;
  this.AltLLVMIntrinsic = AltLLVMIntrinsic;
  this.TypeModifier = TypeModifier;
}
