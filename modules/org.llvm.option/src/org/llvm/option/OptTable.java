/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.llvm.option;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.option.*;
import static org.llvm.option.impl.OptStatics.*;
import static org.llvm.option.impl.OptTableStatics.*;


/// \brief Provide access to the Option info table.
///
/// The OptTable class provides a layer of indirection which allows Option
/// instance to be created lazily. In the common case, only a few options will
/// be needed at runtime; the OptTable class maintains enough information to
/// parse command lines without instantiating Options, while letting other
/// parts of the driver still use Option instances where convenient.
//<editor-fold defaultstate="collapsed" desc="llvm::opt::OptTable">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptTable.h", line = 32,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Option/OptTable.h", old_line = 31,
 FQN = "llvm::opt::OptTable", NM = "_ZN4llvm3opt8OptTableE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3opt8OptTableE")
//</editor-fold>
public class OptTable implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Entry for a single option instance in the option data table.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptTable::Info">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptTable.h", line = 35,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/OptTable.h", old_line = 34,
   FQN = "llvm::opt::OptTable::Info", NM = "_ZN4llvm3opt8OptTable4InfoE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3opt8OptTable4InfoE")
  //</editor-fold>
  public static class/*struct*/ Info implements OpCapable {
    /// A null terminated array of prefix strings to apply to name while
    /// matching.
    public final /*const*/type$ptr<char$ptr>/*char P const P*/ Prefixes;
    public final /*const*/char$ptr/*char P*/ Name;
    public final /*const*/char$ptr/*char P*/ HelpText;
    public final /*const*/char$ptr/*char P*/ MetaVar;
    public final /*uint*/int ID;
    public final /*uchar*/byte Kind;
    public final /*uchar*/byte Param;
    public final /*ushort*/char Flags;
    public final /*ushort*/char GroupID;
    public final /*ushort*/char AliasID;
    public final /*const*/char$ptr/*char P*/ AliasArgs;
    
//public Info(String[] Prefixes, String Name, String HelpText, String MetaVar, /*uint*/int ID, 
//            //short Kind, short Param, char Flags, char GroupID, char AliasID, char$ptr AliasArgs) {
//            int Kind, int Param, int Flags, int GroupID, int AliasID, String AliasArgs) {
//      this(
//              convertPrefixes(Prefixes), 
//              $tryConstClone(create_char$ptr(Name)), 
//              $tryConstClone(create_char$ptr_or_null(HelpText)), 
//              $tryConstClone(create_char$ptr_or_null(MetaVar)), 
//              ID, 
//              Kind, 
//              Param, 
//              Flags, 
//              GroupID,
//              AliasID, 
//              $tryConstClone(create_char$ptr_or_null(AliasArgs))
//      );
//    }
//    private static char$ptr[] convertPrefixes(String[] Prefixes) {
//      char$ptr PrefixesArray[];
//      if (Prefixes == null) {
//        PrefixesArray = null;
//      } else {
//        PrefixesArray = new char$ptr[Prefixes.length];
//        for (int i = 0; i < Prefixes.length; i++) {
//          PrefixesArray[i] = $tryConstClone(create_char$ptr_or_null(Prefixes[i]));
//        }
//      }
//      return PrefixesArray;
//    };
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public Info(type$ptr<char$ptr> Prefixes, char$ptr Name, char$ptr HelpText, char$ptr MetaVar, /*uint*/int ID, 
            //short Kind, short Param, char Flags, char GroupID, char AliasID, char$ptr AliasArgs) {
            /*uchar*/byte Kind, int Param, /*ushort*/int Flags, int GroupID, int AliasID, char$ptr AliasArgs) {
      this.Prefixes = Prefixes;
      this.Name = Name;
      this.HelpText = HelpText;
      this.MetaVar = MetaVar;
      this.ID = ID;
      this.Kind = Kind;
      this.Param = $int2uchar(Param);
      this.Flags = $int2ushort(Flags);
      this.GroupID = $int2ushort(GroupID);
      this.AliasID = $int2ushort(AliasID);
      this.AliasArgs = AliasArgs;
    }

    @Override
    public Boolean $op(Op k, Object obj) {
      if (k == Op.LESS) {
        if (obj instanceof Info) {
          return $less_Info(this, (Info)obj);
        } else if (obj instanceof char$ptr) {
          return $less_Info_char$ptr$C(this, (char$ptr)obj);
        }
      } else {
        assert !(obj instanceof Info) : "do we need Op.GREATEREQ impl?";
        assert !(obj instanceof char$ptr) : "do we need Op.GREATEREQ impl?";
      }
      return null;
    }

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
  };
/*private:*/
  /// \brief The static option information table.
  private ArrayRef<Info> OptionInfos;
  private boolean IgnoreCase;
  
  private /*uint*/int TheInputOptionID;
  private /*uint*/int TheUnknownOptionID;
  
  /// The index of the first option which can be parsed (i.e., is not a
  /// special option like 'input' or 'unknown', and is not an option group).
  private /*uint*/int FirstSearchableIndex;
  
  /// The union of all option prefixes. If an argument does not begin with
  /// one of these, it is an input.
  private StringSet PrefixesUnion;
  private std.string PrefixChars;
/*private:*/
//<editor-fold defaultstate="collapsed" desc="llvm::opt::OptTable::getInfo">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptTable.h", line = 69,
 FQN="llvm::opt::OptTable::getInfo", NM="_ZNK4llvm3opt8OptTable7getInfoENS0_12OptSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt8OptTable7getInfoENS0_12OptSpecifierE")
//</editor-fold>
private /*const*/ Info /*&*/ getInfo(OptSpecifier Opt) /*const*/ {
  /*uint*/int id = Opt.getID();
  assert ($greater_uint(id, 0) && $less_uint(id - 1, getNumOptions())) : "Invalid Option ID.";
  return OptionInfos.$at(id - 1);
}
/*protected:*/
//<editor-fold defaultstate="collapsed" desc="llvm::opt::OptTable::OptTable">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", line = 87,
 FQN="llvm::opt::OptTable::OptTable", NM="_ZN4llvm3opt8OptTableC1ENS_8ArrayRefINS1_4InfoEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3opt8OptTableC1ENS_8ArrayRefINS1_4InfoEEEb")
//</editor-fold>
protected OptTable(ArrayRef<Info> OptionInfos) {
  this(OptionInfos, false);
}
protected OptTable(ArrayRef<Info> OptionInfos, boolean IgnoreCase/*= false*/) {
  /* : OptionInfos(OptionInfos), IgnoreCase(IgnoreCase), TheInputOptionID(0), TheUnknownOptionID(0), FirstSearchableIndex(0), PrefixesUnion(), PrefixChars()*/ 
  //START JInit
  this.OptionInfos = new ArrayRef<Info>(OptionInfos);
  this.IgnoreCase = IgnoreCase;
  this.TheInputOptionID = 0;
  this.TheUnknownOptionID = 0;
  this.FirstSearchableIndex = 0;
  this.PrefixesUnion = new StringSet/*<MallocAllocator>*/();
  this.PrefixChars = new std.string();
  //END JInit
  // Explicitly zero initialize the error to work around a bug in array
  // value-initialization on MinGW with gcc 4.3.5.
  
  // Find start of normal options.
  for (/*uint*/int i = 0, e = getNumOptions(); i != e; ++i) {
    /*uint*/int Kind = $uchar2uint(getInfo(new OptSpecifier(i + 1)).Kind);
    if (Kind == Option.OptionClass.InputClass) {
      assert (!(TheInputOptionID != 0)) : "Cannot have multiple input options!";
      TheInputOptionID = getInfo(new OptSpecifier(i + 1)).ID;
    } else if (Kind == Option.OptionClass.UnknownClass) {
      assert (!(TheUnknownOptionID != 0)) : "Cannot have multiple unknown options!";
      TheUnknownOptionID = getInfo(new OptSpecifier(i + 1)).ID;
    } else if (Kind != Option.OptionClass.GroupClass) {
      FirstSearchableIndex = i;
      break;
    }
  }
  assert (FirstSearchableIndex != 0) : "No searchable options?";
  // Check that everything after the first searchable option is a
  // regular option class.
  for (/*uint*/int i = FirstSearchableIndex, e = getNumOptions(); i != e; ++i) {
    /*uchar*/byte Kind = (/*uchar*/byte)getInfo(new OptSpecifier(i + 1)).Kind;
    assert ((Kind != Option.OptionClass.InputClass && Kind != Option.OptionClass.UnknownClass && Kind != Option.OptionClass.GroupClass)) : "Special options should be defined first!";
  }
  
  // Check that options are in order.
  for (/*uint*/int i = FirstSearchableIndex + 1, e = getNumOptions(); i != e; ++i) {
    if (!($less_Info(getInfo(new OptSpecifier(i)), getInfo(new OptSpecifier(i + 1))))) {
      getOption(new OptSpecifier(i)).dump();
      getOption(new OptSpecifier(i + 1)).dump();
      throw new llvm_unreachable("Options are not in order!");
    }
  }
  
  // Build prefixes.
  for (/*uint*/int i = FirstSearchableIndex + 1, e = getNumOptions() + 1;
       i != e; ++i) {
    {
      /*const*/type$ptr<char$ptr>/*char P const P*/ P = $tryClone(getInfo(new OptSpecifier(i)).Prefixes);
      if ((P != null)) {
        for (; $noteq_ptr(P.$star(), null); P.$preInc()) {
          PrefixesUnion.insert(new StringRef(P.$star()));
        }
      }
    }
  }
  
  // Build prefix chars.
  for (StringMapIteratorChar I = new StringMapIteratorChar(JD$Move.INSTANCE, PrefixesUnion.begin()), 
      E = new StringMapIteratorChar(JD$Move.INSTANCE, PrefixesUnion.end()); I.$noteq(E); I.$preInc()) {
    StringRef Prefix = I.$arrow().getKey();
    for (char$ptr C = $tryClone(Prefix.begin()), /*P*/ CE = $tryClone(Prefix.end());
         $noteq_ptr(C, CE); C.$preInc())  {
      if ($eq___normal_iterator$C(std.find(PrefixChars.begin(), PrefixChars.end(), C.$star()), 
          PrefixChars.end())) {
        PrefixChars.push_back(C.$star());
      }
    }
  }
}

/*public:*/
//<editor-fold defaultstate="collapsed" desc="llvm::opt::OptTable::~OptTable">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", line = 151,
 old_source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", old_line = 157,
 FQN="llvm::opt::OptTable::~OptTable", NM="_ZN4llvm3opt8OptTableD0Ev",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3opt8OptTableD0Ev")
//</editor-fold>
public void $destroy() {
  //START JDestroy
  PrefixChars.$destroy();
  PrefixesUnion.$destroy();
  //END JDestroy
}

  
/// \brief Return the total number of option classes.
//<editor-fold defaultstate="collapsed" desc="llvm::opt::OptTable::getNumOptions">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptTable.h", line = 82,
 FQN="llvm::opt::OptTable::getNumOptions", NM="_ZNK4llvm3opt8OptTable13getNumOptionsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt8OptTable13getNumOptionsEv")
//</editor-fold>
public /*uint*/int getNumOptions() /*const*/ {
  return OptionInfos.size();
}

  
  /// \brief Get the given Opt's Option instance, lazily creating it
  /// if necessary.
  ///
  /// \return The option, or null for the INVALID option id.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptTable::getOption">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", line = 154,
   old_source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", old_line = 160,
   FQN = "llvm::opt::OptTable::getOption", NM = "_ZNK4llvm3opt8OptTable9getOptionENS0_12OptSpecifierE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt8OptTable9getOptionENS0_12OptSpecifierE")
  //</editor-fold>
  public /*const*/Option getOption(OptSpecifier Opt) /*const*/ {
    /*uint*/int id = Opt.getID();
    if (id == 0) {
      return new Option((OptTable.Info) null, (OptTable)null);
    }
    assert ($less_uint((id - 1), getNumOptions())) : "Invalid ID.";
    return new Option($AddrOf(getInfo(new OptSpecifier(id))), this);
  }

  
  /// \brief Lookup the name of the given option.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptTable::getOptionName">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptTable.h", line = 91,
   FQN = "llvm::opt::OptTable::getOptionName", NM = "_ZNK4llvm3opt8OptTable13getOptionNameENS0_12OptSpecifierE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt8OptTable13getOptionNameENS0_12OptSpecifierE")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getOptionName(OptSpecifier id) /*const*/ {
    return getInfo(id).Name;
  }

  
  /// \brief Get the kind of the given option.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptTable::getOptionKind">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptTable.h", line = 96,
   FQN = "llvm::opt::OptTable::getOptionKind", NM = "_ZNK4llvm3opt8OptTable13getOptionKindENS0_12OptSpecifierE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt8OptTable13getOptionKindENS0_12OptSpecifierE")
  //</editor-fold>
  public /*uint*/int getOptionKind(OptSpecifier id) /*const*/ {
    return getInfo(id).Kind;
  }

  
  /// \brief Get the group id for the given option.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptTable::getOptionGroupID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptTable.h", line = 101,
   FQN = "llvm::opt::OptTable::getOptionGroupID", NM = "_ZNK4llvm3opt8OptTable16getOptionGroupIDENS0_12OptSpecifierE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt8OptTable16getOptionGroupIDENS0_12OptSpecifierE")
  //</editor-fold>
  public /*uint*/int getOptionGroupID(OptSpecifier id) /*const*/ {
    return getInfo(id).GroupID;
  }

  
  /// \brief Get the help text to use to describe this option.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptTable::getOptionHelpText">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptTable.h", line = 106,
   FQN = "llvm::opt::OptTable::getOptionHelpText", NM = "_ZNK4llvm3opt8OptTable17getOptionHelpTextENS0_12OptSpecifierE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt8OptTable17getOptionHelpTextENS0_12OptSpecifierE")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getOptionHelpText(OptSpecifier id) /*const*/ {
    return getInfo(id).HelpText;
  }

  
  /// \brief Get the meta-variable name to use when describing
  /// this options values in the help text.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptTable::getOptionMetaVar">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptTable.h", line = 112,
   FQN = "llvm::opt::OptTable::getOptionMetaVar", NM = "_ZNK4llvm3opt8OptTable16getOptionMetaVarENS0_12OptSpecifierE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt8OptTable16getOptionMetaVarENS0_12OptSpecifierE")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getOptionMetaVar(OptSpecifier id) /*const*/ {
    return getInfo(id).MetaVar;
  }

  
/// \brief Parse a single argument; returning the new argument and
/// updating Index.
///
/// \param [in,out] Index - The current parsing position in the argument
/// string list; on return this will be the index of the next argument
/// string to parse.
/// \param [in] FlagsToInclude - Only parse options with any of these flags.
/// Zero is the default which includes all flags.
/// \param [in] FlagsToExclude - Don't parse options with this flag.  Zero
/// is the default and means exclude nothing.
///
/// \return The parsed argument, or 0 if the argument is missing values
/// (in which case Index still points at the conceptual next argument string
/// to parse).
//<editor-fold defaultstate="collapsed" desc="llvm::opt::OptTable::ParseOneArg">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", line = 189,
 old_source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", old_line = 195,
 FQN="llvm::opt::OptTable::ParseOneArg", NM="_ZNK4llvm3opt8OptTable11ParseOneArgERKNS0_7ArgListERjjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt8OptTable11ParseOneArgERKNS0_7ArgListERjjj")
//</editor-fold>
public Arg /*P*/ ParseOneArg(/*const*/ ArgList /*&*/ Args, uint$ref/*uint &*/ Index) /*const*/ {
  return ParseOneArg(Args, Index, 
           0, 
           0);
}
public Arg /*P*/ ParseOneArg(/*const*/ ArgList /*&*/ Args, uint$ref/*uint &*/ Index, 
           /*uint*/int FlagsToInclude/*= 0*/) /*const*/ {
  return ParseOneArg(Args, Index, 
           FlagsToInclude, 
           0);
}
public Arg /*P*/ ParseOneArg(/*const*/ ArgList /*&*/ Args, uint$ref/*uint &*/ Index, 
           /*uint*/int FlagsToInclude/*= 0*/, 
           /*uint*/int FlagsToExclude/*= 0*/) /*const*/ {
  /*uint*/int Prev = Index.$deref();
  /*const*/char$ptr/*char P*/ Str = $tryClone(Args.getArgString(Index.$deref()));
  
  // Anything that doesn't start with PrefixesUnion is an input, as is '-'
  // itself.
  if (isInput(PrefixesUnion, new StringRef(Str))) {
    return new Arg(getOption(new OptSpecifier(TheInputOptionID)), new StringRef(Str), Index.$set$postInc(), Str);
  }
  
  type$ptr<Info> Start = $tryClone(OptionInfos.begin().$add(FirstSearchableIndex));
  type$ptr<Info> End = $tryClone(OptionInfos.end());
  StringRef Name = new StringRef(Str).ltrim(new StringRef(PrefixChars));
  
  // Search for the first next option which could be a prefix.
  Start = $tryClone(std.lower_bound(Start, End, Name.data()));
  
  // Options are stored in sorted order, with '\0' at the end of the
  // alphabet. Since the only options which can accept a string must
  // prefix it, we iteratively search for the next option which could
  // be a prefix.
  //
  // FIXME: This is searching much more than necessary, but I am
  // blanking on the simplest way to make it fast. We can solve this
  // problem when we move to TableGen.
  for (; $noteq_ptr(Start, End); Start.$preInc()) {
    /*uint*/int ArgSize = 0;
    // Scan for first option which is a proper prefix.
    for (; $noteq_ptr(Start, End); Start.$preInc())  {
      if (((ArgSize = matchOption(Start, new StringRef(Str), IgnoreCase)) != 0)) {
        break;
      }
    }
    if ($eq_ptr(Start, End)) {
      break;
    }
    
    Option Opt/*J*/= new Option(Start.$star(), this);
    if ((FlagsToInclude != 0) && !Opt.hasFlag(FlagsToInclude)) {
      continue;
    }
    if (Opt.hasFlag(FlagsToExclude)) {
      continue;
    }
    {
      
      // See if this option matches.
      Arg /*P*/ A = Opt.accept(Args, Index, ArgSize);
      if ((A != null)) {
        return A;
      }
    }
    
    // Otherwise, see if this argument was missing values.
    if (Prev != Index.$deref()) {
      return null;
    }
  }
  
  // If we failed to find an option and this arg started with /, then it's
  // probably an input path.
  if (Str.$at(0) == $$SLASH) {
    return new Arg(getOption(new OptSpecifier(TheInputOptionID)), new StringRef(Str), Index.$set$postInc(), Str);
  }
  
  return new Arg(getOption(new OptSpecifier(TheUnknownOptionID)), new StringRef(Str), Index.$set$postInc(), Str);
}

  
/// \brief Parse an list of arguments into an InputArgList.
///
/// The resulting InputArgList will reference the strings in [\p ArgBegin,
/// \p ArgEnd), and their lifetime should extend past that of the returned
/// InputArgList.
///
/// The only error that can occur in this routine is if an argument is
/// missing values; in this case \p MissingArgCount will be non-zero.
///
/// \param MissingArgIndex - On error, the index of the option which could
/// not be parsed.
/// \param MissingArgCount - On error, the number of missing options.
/// \param FlagsToInclude - Only parse options with any of these flags.
/// Zero is the default which includes all flags.
/// \param FlagsToExclude - Don't parse options with this flag.  Zero
/// is the default and means exclude nothing.
/// \return An InputArgList; on error this will contain all the options
/// which could be parsed.
//<editor-fold defaultstate="collapsed" desc="llvm::opt::OptTable::ParseArgs">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", line = 248,
 FQN="llvm::opt::OptTable::ParseArgs", NM="_ZNK4llvm3opt8OptTable9ParseArgsENS_8ArrayRefIPKcEERjS6_jj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt8OptTable9ParseArgsENS_8ArrayRefIPKcEERjS6_jj")
//</editor-fold>
public InputArgList ParseArgs(ArrayRef</*const*/char$ptr/*char P*/ > ArgArr, 
         uint$ref/*uint &*/ MissingArgIndex, 
         uint$ref/*uint &*/ MissingArgCount) /*const*/ {
  return ParseArgs(ArgArr, 
         MissingArgIndex, 
         MissingArgCount, 
         0, 
         0);
}
public InputArgList ParseArgs(ArrayRef</*const*/char$ptr/*char P*/ > ArgArr, 
         uint$ref/*uint &*/ MissingArgIndex, 
         uint$ref/*uint &*/ MissingArgCount, 
         /*uint*/int FlagsToInclude/*= 0*/) /*const*/ {
  return ParseArgs(ArgArr, 
         MissingArgIndex, 
         MissingArgCount, 
         FlagsToInclude, 
         0);
}
public InputArgList ParseArgs(ArrayRef</*const*/char$ptr/*char P*/ > ArgArr, 
         uint$ref/*uint &*/ MissingArgIndex, 
         uint$ref/*uint &*/ MissingArgCount, 
         /*uint*/int FlagsToInclude/*= 0*/, 
         /*uint*/int FlagsToExclude/*= 0*/) /*const*/ {
  InputArgList Args = null;
  try {
    Args/*J*/= new InputArgList(ArgArr.begin(), ArgArr.end());
    
    // FIXME: Handle '@' args (or at least error on them).
    MissingArgIndex.$set(MissingArgCount.$set(0));
    /*uint*/ uint$ref Index = create_uint$ref(0); 
    int End = ArgArr.size();
    while ($less_uint(Index, End)) {
      // Ingore nullptrs, they are response file's EOL markers
      if ($eq_ptr(Args.getArgString(Index.$deref()), null)) {
        Index.$set$preInc();
        continue;
      }
      // Ignore empty arguments (other things may still take them as arguments).
      StringRef Str = new StringRef(Args.getArgString(Index.$deref()));
      if ($eq_StringRef(/*NO_COPY*/Str, /*STRINGREF_STR*/"")) {
        Index.$set$preInc();
        continue;
      }
      
      /*uint*/int Prev = Index.$deref();
      Arg /*P*/ A = ParseOneArg(Args, Index, FlagsToInclude, FlagsToExclude);      
      assert ($greater_uint(Index, Prev)) : "Parser failed to consume argument.";
      
      // Check for missing argument error.
      if (!(A != null)) {
        assert ($greatereq_uint(Index, End)) : "Unexpected parser error.";
        assert (((Index.$deref() - Prev - 1) != 0)) : "No missing arguments!";
        MissingArgIndex.$set(Prev);
        MissingArgCount.$set(Index.$deref() - Prev - 1);
        break;
      }
      
      Args.append(A);
    }
    
    return new InputArgList(JD$Move.INSTANCE, Args);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}

  /// \brief Render the help text for an option table.
  ///
  /// \param OS - The stream to write the help text to.
  /// \param Name - The name to use in the usage line.
  /// \param Title - The title to use in the usage line.
  /// \param FlagsToInclude - If non-zero, only include options with any
  ///                         of these flags set.
  /// \param FlagsToExclude - Exclude options with any of these flags set.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptTable::PrintHelp">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", line = 391,
   old_source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", old_line = 398,
   FQN = "llvm::opt::OptTable::PrintHelp", NM = "_ZNK4llvm3opt8OptTable9PrintHelpERNS_11raw_ostreamEPKcS5_jj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt8OptTable9PrintHelpERNS_11raw_ostreamEPKcS5_jj")
  //</editor-fold>
  public void PrintHelp(raw_ostream /*&*/ OS, /*const*/char$ptr/*char P*/ Name, /*const*/char$ptr/*char P*/ Title, /*uint*/int FlagsToInclude, /*uint*/int FlagsToExclude) /*const*/ {
    std.mapTypeType<std.string, std.vector<std.pair<std.string, /*const*/char$ptr/*char P*/ > > > GroupedOptionHelp = null;
    try {
      OS.$out("OVERVIEW: ").$out(Title).$out($LF);
      OS.$out_char($$LF);
      OS.$out("USAGE: ").$out(Name).$out(" [options] <inputs>\n");
      OS.$out_char($$LF);
      
      // Render help text into a map of group-name to a list of (option, help)
      // pairs.
      /*typedef std::map<std::string, std::vector<std::pair<std::string, const char *> > > helpmap_ty*/
//      final class helpmap_ty extends std.map<std.string, std.vector<std.pair<std.string, /*const*/char$ptr/*char P*/ > > >{ };
      GroupedOptionHelp/*J*/= new std.mapTypeType<std.string, std.vector<std.pair<std.string, /*const*/char$ptr/*char P*/ > > >(new std.vector(std.make_pair(new std.string(), null)));
      
      for (/*uint*/int i = 0, e = getNumOptions(); i != e; ++i) {
        /*uint*/int Id = i + 1;
        
        // FIXME: Split out option groups.
        if (getOptionKind(new OptSpecifier(Id)) == Option.OptionClass.GroupClass) {
          continue;
        }
        
        /*uint*/int Flags = getInfo(new OptSpecifier(Id)).Flags;
        if ((FlagsToInclude != 0) && !((Flags & FlagsToInclude) != 0)) {
          continue;
        }
        if (((Flags & FlagsToExclude) != 0)) {
          continue;
        }
        {
          
          /*const*/char$ptr/*char P*/ Text = $tryClone(getOptionHelpText(new OptSpecifier(Id)));
          if ((Text != null)) {
            /*const*/std.string/*&*/  OptName = null;
            try {
              /*const*/char$ptr/*char P*/ HelpGroup = $tryClone(getOptionHelpGroup(/*Deref*/this, new OptSpecifier(Id)));
              OptName = getOptionHelpName(/*Deref*/this, new OptSpecifier(Id));
              GroupedOptionHelp.$at(new std.string(HelpGroup)).push_back(std.make_pair(OptName, Text));
            } finally {
              if (OptName != null) { OptName.$destroy(); }
            }
          }
        }
      }
      
      for (std.mapTypeType.iterator<std.string, std.vector<std.pair<std.string, /*const*/char$ptr/*char P*/ > >> it = GroupedOptionHelp.begin(), ie = GroupedOptionHelp.end(); it.$noteq(ie); it.$preInc()) {
        if (it.$noteq(GroupedOptionHelp.begin())) {
          OS.$out($LF);
        }
        PrintHelpOptionList(OS, new StringRef(it.$arrow().first), it.$arrow().second);
      }
      
      OS.flush();
    } finally {
      if (GroupedOptionHelp != null) { GroupedOptionHelp.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptTable::PrintHelp">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", line = 384,
   old_source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", old_line = 391,
   FQN = "llvm::opt::OptTable::PrintHelp", NM = "_ZNK4llvm3opt8OptTable9PrintHelpERNS_11raw_ostreamEPKcS5_b",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt8OptTable9PrintHelpERNS_11raw_ostreamEPKcS5_b")
  //</editor-fold>
  public void PrintHelp(raw_ostream /*&*/ OS, /*const*/char$ptr/*char P*/ Name, /*const*/char$ptr/*char P*/ Title) /*const*/ {
    PrintHelp(OS, Name, Title, false);
  }
  public void PrintHelp(raw_ostream /*&*/ OS, /*const*/char$ptr/*char P*/ Name, /*const*/char$ptr/*char P*/ Title, boolean ShowHidden/*= false*/) /*const*/ {
    PrintHelp(OS, Name, Title, 0, (ShowHidden ? 0 : DriverFlag.HelpHidden));
  }

}
