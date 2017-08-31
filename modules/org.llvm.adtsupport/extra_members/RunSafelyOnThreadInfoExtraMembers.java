public RunSafelyOnThreadInfo(Void2Void Fn, CrashRecoveryContext CRC, boolean UseBackgroundPriority, boolean Result) {
  this.Fn = Fn;
  this.CRC = CRC;
  this.UseBackgroundPriority = UseBackgroundPriority;
  this.Result = Result;
}
