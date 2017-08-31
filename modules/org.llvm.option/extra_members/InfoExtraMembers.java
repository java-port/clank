@Override
public String toString() {
  StringBuilder out = new StringBuilder("Info{");
  out.append("Name=").append(Casts.toJavaString(Name)).append(",");
  if ((Prefixes != null)) {
    out.append("Prefixes=[");
    type$ptr<char$ptr> P = $Clone(Prefixes);
    for (; $noteq_ptr(P.$star(), null); P.$preInc()) {
      if ($noteq_ptr(P, Prefixes)) {
        out.append(", ");
      }
      out.append(Casts.toJavaString(P.$star()));
    }
    out.append("],");
  }      
  out.append("HelpText=[").append(Casts.toJavaString(HelpText)).append("],\n");
  out.append("ID=(ID.OPT_").append(ID).append(", ");
  out.append("Kind=(Option.OptionClass)").append($uchar2uint(Kind)).append(", ");
  out.append("Param=").append($uchar2uint(Param)).append(", ");
  out.append("Flags=(ClangFlags)").append(Integer.toBinaryString($ushort2uint(Flags))).append(",\n");
  out.append("GroupID=(ID.OPT_").append($ushort2int(GroupID)).append(", ");
  out.append("AliasID=(ID.OPT_").append($ushort2int(AliasID)).append(", ");
  out.append("AliasArgs=[").append(Casts.toJavaString(AliasArgs)).append("], ");
  out.append("MetaVar=[").append(Casts.toJavaString(MetaVar)).append("]}");

  return out.toString();
}
