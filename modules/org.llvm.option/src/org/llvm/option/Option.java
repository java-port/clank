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
import org.llvm.option.*;


/// Option - Abstract representation for a single form of driver
/// argument.
///
/// An Option class represents a form of option that the driver
/// takes, for example how many arguments the option has and how
/// they can be provided. Individual option instances store
/// additional information about what group the option is a member
/// of (if any), if the option is an alias, and a number of
/// flags. At runtime the driver parses the command line into
/// concrete Arg instances, each of which corresponds to a
/// particular Option instance.
//<editor-fold defaultstate="collapsed" desc="llvm::opt::Option">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 44,
 FQN="llvm::opt::Option", NM="_ZN4llvm3opt6OptionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3opt6OptionE")
//</editor-fold>
public class Option {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::OptionClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 46,
   FQN="llvm::opt::Option::OptionClass", NM="_ZN4llvm3opt6Option11OptionClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3opt6Option11OptionClassE")
  //</editor-fold>
  public static final class/*enum*/ OptionClass {
    public static final byte GroupClass = 0;
    public static final byte InputClass = GroupClass + 1;
    public static final byte UnknownClass = InputClass + 1;
    public static final byte FlagClass = UnknownClass + 1;
    public static final byte JoinedClass = FlagClass + 1;
    public static final byte SeparateClass = JoinedClass + 1;
    public static final byte RemainingArgsClass = SeparateClass + 1;
    public static final byte RemainingArgsJoinedClass = RemainingArgsClass + 1;
    public static final byte CommaJoinedClass = RemainingArgsJoinedClass + 1;
    public static final byte MultiArgClass = CommaJoinedClass + 1;
    public static final byte JoinedOrSeparateClass = MultiArgClass + 1;
    public static final byte JoinedAndSeparateClass = JoinedOrSeparateClass + 1;
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::RenderStyleKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 61,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", old_line = 60,
   FQN="llvm::opt::Option::RenderStyleKind", NM="_ZN4llvm3opt6Option15RenderStyleKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3opt6Option15RenderStyleKindE")
  //</editor-fold>
  public enum RenderStyleKind implements Native.ComparableLower {
    RenderCommaJoinedStyle(0),
    RenderJoinedStyle(RenderCommaJoinedStyle.getValue() + 1),
    RenderSeparateStyle(RenderJoinedStyle.getValue() + 1),
    RenderValuesStyle(RenderSeparateStyle.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static RenderStyleKind valueOf(int val) {
      RenderStyleKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final RenderStyleKind[] VALUES;
      private static final RenderStyleKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (RenderStyleKind kind : RenderStyleKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new RenderStyleKind[min < 0 ? (1-min) : 0];
        VALUES = new RenderStyleKind[max >= 0 ? (1+max) : 0];
        for (RenderStyleKind kind : RenderStyleKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private RenderStyleKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((RenderStyleKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((RenderStyleKind)obj).value);}
    //</editor-fold>
  };
/*protected:*/
  protected final OptTable.Info Info;
  protected final /*const*/ OptTable /*P*/ Owner;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::Option">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Option/Option.cpp", line = 23,
   FQN="llvm::opt::Option::Option", NM="_ZN4llvm3opt6OptionC1EPKNS0_8OptTable4InfoEPKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Option.cpp -nm=_ZN4llvm3opt6OptionC1EPKNS0_8OptTable4InfoEPKS2_")
  //</editor-fold>
  public Option(OptTable.Info info, /*const*/ OptTable /*P*/ owner) {
    /* : Info(info), Owner(owner)*/ 
    //START JInit
    this.Info = info;
    this.Owner = owner;
    //END JInit
    
    // Multi-level aliases are not supported. This just simplifies option
    // tracking, it is not an inherent limitation.
    assert ((!(Info != null) || !getAlias().isValid() || !getAlias().getAlias().isValid())) : "Multi-level aliases are not supported.";
    if ((Info != null) && (getAliasArgs() != null)) {
      assert (getAlias().isValid()) : "Only alias options can have alias args.";
      assert (getKind() == OptionClass.FlagClass) : "Only Flag aliases can have alias args.";
      assert (getAlias().getKind() != OptionClass.FlagClass) : "Cannot provide alias args to a flag option.";
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 75,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", old_line = 74,
   FQN="llvm::opt::Option::isValid", NM="_ZNK4llvm3opt6Option7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt6Option7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return Info != null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::getID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 79,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", old_line = 78,
   FQN="llvm::opt::Option::getID", NM="_ZNK4llvm3opt6Option5getIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt6Option5getIDEv")
  //</editor-fold>
  public /*uint*/int getID() /*const*/ {
    assert ((Info != null)) : "Must have a valid info!";
    return Info.ID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 84,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", old_line = 83,
   FQN="llvm::opt::Option::getKind", NM="_ZNK4llvm3opt6Option7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt6Option7getKindEv")
  //</editor-fold>
  public /*uchar*/byte getKind() /*const*/ {
    assert ((Info != null)) : "Must have a valid info!";
    return ((/*uchar*/byte)(Info.Kind));
  }

  
  /// \brief Get the name of this option without any prefix.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 90,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", old_line = 89,
   FQN="llvm::opt::Option::getName", NM="_ZNK4llvm3opt6Option7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt6Option7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    assert ((Info != null)) : "Must have a valid info!";
    return new StringRef(Info.Name);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::getGroup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 95,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", old_line = 94,
   FQN="llvm::opt::Option::getGroup", NM="_ZNK4llvm3opt6Option8getGroupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt6Option8getGroupEv")
  //</editor-fold>
  public /*const*/ Option getGroup() /*const*/ {
    assert ((Info != null)) : "Must have a valid info!";
    assert ((Owner != null)) : "Must have a valid owner!";
    return Owner.getOption(new OptSpecifier($ushort2uint(Info.GroupID)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::getAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 101,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", old_line = 100,
   FQN="llvm::opt::Option::getAlias", NM="_ZNK4llvm3opt6Option8getAliasEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt6Option8getAliasEv")
  //</editor-fold>
  public /*const*/ Option getAlias() /*const*/ {
    assert ((Info != null)) : "Must have a valid info!";
    assert ((Owner != null)) : "Must have a valid owner!";
    return Owner.getOption(new OptSpecifier($ushort2uint(Info.AliasID)));
  }

  
  /// \brief Get the alias arguments as a \0 separated list.
  /// E.g. ["foo", "bar"] would be returned as "foo\0bar\0".
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::getAliasArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 109,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", old_line = 108,
   FQN="llvm::opt::Option::getAliasArgs", NM="_ZNK4llvm3opt6Option12getAliasArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt6Option12getAliasArgsEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getAliasArgs() /*const*/ {
    assert ((Info != null)) : "Must have a valid info!";
    assert ((!(Info.AliasArgs != null) || Info.AliasArgs.$at(0) != 0)) : "AliasArgs should be either 0 or non-empty.";
    
    return Info.AliasArgs;
  }

  
  /// \brief Get the default prefix for this option.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::getPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 118,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", old_line = 117,
   FQN="llvm::opt::Option::getPrefix", NM="_ZNK4llvm3opt6Option9getPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt6Option9getPrefixEv")
  //</editor-fold>
  public StringRef getPrefix() /*const*/ {
    /*const*/char$ptr/*char P*/ Prefix = $tryClone(Info.Prefixes.$star());
    return (Prefix != null) ? new StringRef(Prefix) : new StringRef();
  }

  
  /// \brief Get the name of this option with the default prefix.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::getPrefixedName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 124,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", old_line = 123,
   FQN="llvm::opt::Option::getPrefixedName", NM="_ZNK4llvm3opt6Option15getPrefixedNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt6Option15getPrefixedNameEv")
  //</editor-fold>
  public std.string getPrefixedName() /*const*/ {
    std.string Ret = getPrefix().$string();
    $addassign_str_StringRef(Ret, getName());
    return Ret;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 130,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", old_line = 129,
   FQN="llvm::opt::Option::getNumArgs", NM="_ZNK4llvm3opt6Option10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt6Option10getNumArgsEv")
  //</editor-fold>
  public /*uint*/int getNumArgs() /*const*/ {
    return $uchar2uint(Info.Param);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::hasNoOptAsInput">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 132,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", old_line = 131,
   FQN="llvm::opt::Option::hasNoOptAsInput", NM="_ZNK4llvm3opt6Option15hasNoOptAsInputEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt6Option15hasNoOptAsInputEv")
  //</editor-fold>
  public boolean hasNoOptAsInput() /*const*/ {
    return (($ushort2int(Info.Flags) & DriverFlag.RenderAsInput) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::getRenderStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 134,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", old_line = 133,
   FQN="llvm::opt::Option::getRenderStyle", NM="_ZNK4llvm3opt6Option14getRenderStyleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt6Option14getRenderStyleEv")
  //</editor-fold>
  public RenderStyleKind getRenderStyle() /*const*/ {
    if ((($ushort2int(Info.Flags) & DriverFlag.RenderJoined) != 0)) {
      return RenderStyleKind.RenderJoinedStyle;
    }
    if ((($ushort2int(Info.Flags) & DriverFlag.RenderSeparate) != 0)) {
      return RenderStyleKind.RenderSeparateStyle;
    }
    switch (getKind()) {
     case OptionClass.GroupClass:
     case OptionClass.InputClass:
     case OptionClass.UnknownClass:
      return RenderStyleKind.RenderValuesStyle;
     case OptionClass.JoinedClass:
     case OptionClass.JoinedAndSeparateClass:
      return RenderStyleKind.RenderJoinedStyle;
     case OptionClass.CommaJoinedClass:
      return RenderStyleKind.RenderCommaJoinedStyle;
     case OptionClass.FlagClass:
     case OptionClass.SeparateClass:
     case OptionClass.MultiArgClass:
     case OptionClass.JoinedOrSeparateClass:
     case OptionClass.RemainingArgsClass:
     case OptionClass.RemainingArgsJoinedClass:
      return RenderStyleKind.RenderSeparateStyle;
    }
    throw new llvm_unreachable("Unexpected kind!");
  }

  
  /// Test if this option has the flag \a Val.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::hasFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 161,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", old_line = 159,
   FQN="llvm::opt::Option::hasFlag", NM="_ZNK4llvm3opt6Option7hasFlagEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt6Option7hasFlagEj")
  //</editor-fold>
  public boolean hasFlag(/*uint*/int Val) /*const*/ {
    return (($ushort2uint(Info.Flags) & Val) != 0);
  }

  
  /// getUnaliasedOption - Return the final option this option
  /// aliases (itself, if the option has no alias).
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::getUnaliasedOption">
  @Converted(kind = Converted.Kind.AUTO,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 167,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", old_line = 165,
   FQN="llvm::opt::Option::getUnaliasedOption", NM="_ZNK4llvm3opt6Option18getUnaliasedOptionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt6Option18getUnaliasedOptionEv")
  //</editor-fold>
  public /*const*/ Option getUnaliasedOption() /*const*/ {
    /*const*/ Option Alias = getAlias();
    if (Alias.isValid()) {
      return Alias.getUnaliasedOption();
    }
    return /*PERF*//*Deref*/this;
  }

  
  /// getRenderName - Return the name to use when rendering this
  /// option.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::getRenderName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 175,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", old_line = 173,
   FQN="llvm::opt::Option::getRenderName", NM="_ZNK4llvm3opt6Option13getRenderNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt6Option13getRenderNameEv")
  //</editor-fold>
  public StringRef getRenderName() /*const*/ {
    return getUnaliasedOption().getName();
  }

  
  /// matches - Predicate for whether this option is part of the
  /// given option (which may be a group).
  ///
  /// Note that matches against options which are an alias should never be
  /// done -- aliases do not participate in matching and so such a query will
  /// always be false.
  
  /// matches - Predicate for whether this option is part of the
  /// given option (which may be a group).
  ///
  /// Note that matches against options which are an alias should never be
  /// done -- aliases do not participate in matching and so such a query will
  /// always be false.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::matches">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Option/Option.cpp", line = 88,
   old_source = "${LLVM_SRC}/llvm/lib/Option/Option.cpp", old_line = 87,
   FQN="llvm::opt::Option::matches", NM="_ZNK4llvm3opt6Option7matchesENS0_12OptSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Option.cpp -nm=_ZNK4llvm3opt6Option7matchesENS0_12OptSpecifierE")
  //</editor-fold>
  public boolean matches(OptSpecifier Opt) /*const*/ {
    // Aliases are never considered in matching, look through them.
    /*const*/ Option Alias = getAlias();
    if (Alias.isValid()) {
      return Alias.matches(/*NO_COPY*/Opt);
    }
    
    // Check exact match.
    if (getID() == Opt.getID()) {
      return true;
    }
    
    /*const*/ Option Group = getGroup();
    if (Group.isValid()) {
      return Group.matches(/*NO_COPY*/Opt);
    }
    return false;
  }


  
  /// accept - Potentially accept the current argument, returning a
  /// new Arg instance, or 0 if the option does not accept this
  /// argument (or the argument is missing values).
  ///
  /// If the option accepts the current argument, accept() sets
  /// Index to the position where argument parsing should resume
  /// (even if the argument is missing values).
  ///
  /// \param ArgSize The number of bytes taken up by the matched Option prefix
  ///                and name. This is used to determine where joined values
  ///                start.
  
  /// accept - Potentially accept the current argument, returning a
  /// new Arg instance, or 0 if the option does not accept this
  /// argument (or the argument is missing values).
  ///
  /// If the option accepts the current argument, accept() sets
  /// Index to the position where argument parsing should resume
  /// (even if the argument is missing values).
  ///
  /// \param ArgSize The number of bytes taken up by the matched Option prefix
  ///                and name. This is used to determine where joined values
  ///                start.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::accept">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Option/Option.cpp", line = 104,
   old_source = "${LLVM_SRC}/llvm/lib/Option/Option.cpp", old_line = 103,
   FQN="llvm::opt::Option::accept", NM="_ZNK4llvm3opt6Option6acceptERKNS0_7ArgListERjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Option.cpp -nm=_ZNK4llvm3opt6Option6acceptERKNS0_7ArgListERjj")
  //</editor-fold>
  public Arg /*P*/ accept(/*const*/ ArgList /*&*/ Args, 
        uint$ref/*uint &*/ Index, 
        /*uint*/int ArgSize) /*const*/ {
    /*const*/ Option /*&*/ UnaliasedOption = getUnaliasedOption();
    StringRef Spelling/*J*/= new StringRef();
    // If the option was an alias, get the spelling from the unaliased one.
    if (getID() == UnaliasedOption.getID()) {
      Spelling.$assignMove(new StringRef(Args.getArgString(Index.$deref()), ArgSize));
    } else {
      Spelling.$assignMove(/*STRINGREF_STR*/Args.MakeArgString($add_Twine(new Twine(UnaliasedOption.getPrefix()), 
                  new Twine(UnaliasedOption.getName()))));
    }
    switch (getKind()) {
     case OptionClass.FlagClass:
      {
        if (ArgSize != strlen(Args.getArgString(Index.$deref()))) {
          return null;
        }
        
        Arg /*P*/ A = new Arg(/*NO_COPY*/UnaliasedOption, /*NO_COPY*/Spelling, Index.$set$postInc());
        if ((getAliasArgs() != null)) {
          /*const*/char$ptr/*char P*/ Val = $tryClone(getAliasArgs());
          while (Val.$star() != $$TERM) {
            A.getValues().push_back(Val);
            
            // Move past the '\0' to the next argument.
            Val.$inc(strlen(Val) + 1);
          }
        }
        if (UnaliasedOption.getKind() == OptionClass.JoinedClass && !(getAliasArgs() != null)) {
          // A Flag alias for a Joined option must provide an argument.
          A.getValues().push_back($EMPTY);
        }
        
        return A;
      }
     case OptionClass.JoinedClass:
      {
        /*const*/char$ptr/*char P*/ Value = $tryClone(Args.getArgString(Index.$deref()).$add(ArgSize));
        return new Arg(/*NO_COPY*/UnaliasedOption, /*NO_COPY*/Spelling, Index.$set$postInc(), Value);
      }
     case OptionClass.CommaJoinedClass:
      {
        // Always matches.
        /*const*/char$ptr/*char P*/ Str = $tryClone(Args.getArgString(Index.$deref()).$add(ArgSize));
        Arg /*P*/ A = new Arg(/*NO_COPY*/UnaliasedOption, /*NO_COPY*/Spelling, Index.$set$postInc());
        
        // Parse out the comma separated values.
        /*const*/char$ptr/*char P*/ Prev = $tryClone(Str);
        for (;; Str.$preInc()) {
          /*char*/byte c = Str.$star();
          if (!(c != 0) || c == $$COMMA) {
            if ($noteq_ptr(Prev, Str)) {
              char$ptr/*char P*/ Value = create_char$ptr(new$char(Str.$sub(Prev) + 1));
              memcpy(Value, Prev, Str.$sub(Prev));
              Value.$set(Str.$sub(Prev), $$TERM);
              A.getValues().push_back(Value);
            }
            if (!(c != 0)) {
              break;
            }
            
            Prev = $tryClone(Str.$add(1));
          }
        }
        A.setOwnsValues(true);
        
        return A;
      }
     case OptionClass.SeparateClass:
      // Matches iff this is an exact match.
      // FIXME: Avoid strlen.
      if (ArgSize != strlen(Args.getArgString(Index.$deref()))) {
        return null;
      }
      
      Index.$set$addassign(2);
      if ($greater_uint(Index.$deref(), Args.getNumInputArgStrings())
         || $eq_ptr(Args.getArgString(Index.$deref() - 1), null)) {
        return null;
      }
      
      return new Arg(/*NO_COPY*/UnaliasedOption, /*NO_COPY*/Spelling, 
          Index.$deref() - 2, Args.getArgString(Index.$deref() - 1));
     case OptionClass.MultiArgClass:
      {
        // Matches iff this is an exact match.
        // FIXME: Avoid strlen.
        if (ArgSize != strlen(Args.getArgString(Index.$deref()))) {
          return null;
        }
        
        Index.$set$addassign(1 + getNumArgs());
        if ($greater_uint(Index.$deref(), Args.getNumInputArgStrings())) {
          return null;
        }
        
        Arg /*P*/ A = new Arg(/*NO_COPY*/UnaliasedOption, /*NO_COPY*/Spelling, Index.$deref() - 1 - getNumArgs(), 
            Args.getArgString(Index.$deref() - getNumArgs()));
        for (/*uint*/int i = 1; i != getNumArgs(); ++i)  {
          A.getValues().push_back(Args.getArgString(Index.$deref() - getNumArgs() + i));
        }
        return A;
      }
     case OptionClass.JoinedOrSeparateClass:
      {
        // If this is not an exact match, it is a joined arg.
        // FIXME: Avoid strlen.
        if (ArgSize != strlen(Args.getArgString(Index.$deref()))) {
          /*const*/char$ptr/*char P*/ Value = $tryClone(Args.getArgString(Index.$deref()).$add(ArgSize));
          return new Arg(/*NO_COPY*//*Deref*/this, /*NO_COPY*/Spelling, Index.$set$postInc(), Value);
        }
        
        // Otherwise it must be separate.
        Index.$set$addassign(2);
        if ($greater_uint(Index.$deref(), Args.getNumInputArgStrings())
           || $eq_ptr(Args.getArgString(Index.$deref() - 1), null)) {
          return null;
        }
        
        return new Arg(/*NO_COPY*/UnaliasedOption, /*NO_COPY*/Spelling, 
            Index.$deref() - 2, Args.getArgString(Index.$deref() - 1));
      }
     case OptionClass.JoinedAndSeparateClass:
      // Always matches.
      Index.$set$addassign(2);
      if ($greater_uint(Index.$deref(), Args.getNumInputArgStrings())
         || $eq_ptr(Args.getArgString(Index.$deref() - 1), null)) {
        return null;
      }
      
      return new Arg(/*NO_COPY*/UnaliasedOption, /*NO_COPY*/Spelling, Index.$deref() - 2, 
          Args.getArgString(Index.$deref() - 2).$add(ArgSize), 
          Args.getArgString(Index.$deref() - 1));
     case OptionClass.RemainingArgsClass:
      {
        // Matches iff this is an exact match.
        // FIXME: Avoid strlen.
        if (ArgSize != strlen(Args.getArgString(Index.$deref()))) {
          return null;
        }
        Arg /*P*/ A = new Arg(/*NO_COPY*/UnaliasedOption, /*NO_COPY*/Spelling, Index.$set$postInc());
        while ($less_uint(Index.$deref(), Args.getNumInputArgStrings())
           && $noteq_ptr(Args.getArgString(Index.$deref()), null)) {
          A.getValues().push_back(Args.getArgString(Index.$set$postInc()));
        }
        return A;
      }
     case OptionClass.RemainingArgsJoinedClass:
      {
        Arg /*P*/ A = new Arg(/*NO_COPY*/UnaliasedOption, /*NO_COPY*/Spelling, Index.$deref());
        if (ArgSize != strlen(Args.getArgString(Index.$deref()))) {
          // An inexact match means there is a joined arg.
          A.getValues().push_back(Args.getArgString(Index.$deref()).$add(ArgSize));
        }
        Index.$set$postInc();
        while ($less_uint(Index.$deref(), Args.getNumInputArgStrings())
           && $noteq_ptr(Args.getArgString(Index.$deref()), null)) {
          A.getValues().push_back(Args.getArgString(Index.$set$postInc()));
        }
        return A;
      }
     default:
      throw new llvm_unreachable("Invalid option kind!");
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Option/Option.cpp", line = 39,
   FQN="llvm::opt::Option::print", NM="_ZNK4llvm3opt6Option5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Option.cpp -nm=_ZNK4llvm3opt6Option5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(raw_ostream /*&*/ O) /*const*/ {
    O.$out(/*KEEP_STR*/$LT);
    switch (getKind()) {
     case OptionClass.GroupClass:
      O.$out(/*KEEP_STR*/"GroupClass");
      break;
     case OptionClass.InputClass:
      O.$out(/*KEEP_STR*/"InputClass");
      break;
     case OptionClass.UnknownClass:
      O.$out(/*KEEP_STR*/"UnknownClass");
      break;
     case OptionClass.FlagClass:
      O.$out(/*KEEP_STR*/"FlagClass");
      break;
     case OptionClass.JoinedClass:
      O.$out(/*KEEP_STR*/"JoinedClass");
      break;
     case OptionClass.SeparateClass:
      O.$out(/*KEEP_STR*/"SeparateClass");
      break;
     case OptionClass.CommaJoinedClass:
      O.$out(/*KEEP_STR*/"CommaJoinedClass");
      break;
     case OptionClass.MultiArgClass:
      O.$out(/*KEEP_STR*/"MultiArgClass");
      break;
     case OptionClass.JoinedOrSeparateClass:
      O.$out(/*KEEP_STR*/"JoinedOrSeparateClass");
      break;
     case OptionClass.JoinedAndSeparateClass:
      O.$out(/*KEEP_STR*/"JoinedAndSeparateClass");
      break;
     case OptionClass.RemainingArgsClass:
      O.$out(/*KEEP_STR*/"RemainingArgsClass");
      break;
     case OptionClass.RemainingArgsJoinedClass:
      O.$out(/*KEEP_STR*/"RemainingArgsJoinedClass");
      break;
    }
    if ((Info.Prefixes != null)) {
      O.$out(/*KEEP_STR*/" Prefixes:[");
      for (/*const*/type$ptr<char$ptr>/*char P const P*/ Pre = $tryClone(Info.Prefixes); $noteq_ptr(Pre.$star(), null); Pre.$preInc()) {
        O.$out_char($$DBL_QUOTE).$out(Pre.$star()).$out(($eq_ptr((Pre.$add(1)).$star(), (/*const*/char$ptr/*char P*/ )null) ? $DBL_QUOTE : $("\", ")));
      }
      O.$out_char($$RSQUARE);
    }
    
    O.$out(/*KEEP_STR*/" Name:\"").$out(getName()).$out_char($$DBL_QUOTE);
    
    /*const*/ Option Group = getGroup();
    if (Group.isValid()) {
      O.$out(/*KEEP_STR*/" Group:");
      Group.print(O);
    }
    
    /*const*/ Option Alias = getAlias();
    if (Alias.isValid()) {
      O.$out(/*KEEP_STR*/" Alias:");
      Alias.print(O);
    }
    if (getKind() == OptionClass.MultiArgClass) {
      O.$out(/*KEEP_STR*/" NumArgs:").$out_uint(getNumArgs());
    }
    
    O.$out(/*KEEP_STR*/$GT_LF);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Option/Option.cpp", line = 86,
   old_source = "${LLVM_SRC}/llvm/lib/Option/Option.cpp", old_line = 85,
   FQN="llvm::opt::Option::dump", NM="_ZNK4llvm3opt6Option4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Option.cpp -nm=_ZNK4llvm3opt6Option4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::Option">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 44,
   FQN="llvm::opt::Option::Option", NM="_ZN4llvm3opt6OptionC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3opt6OptionC1ERKS1_")
  //</editor-fold>
  public /*inline*/ Option(/*const*/ Option /*&*/ $Prm0) {
    /* : Info(.Info), Owner(.Owner)*/ 
    //START JInit
    this.Info = $Prm0.Info;
    this.Owner = $Prm0.Owner;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Option::Option">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/Option.h", line = 44,
   FQN="llvm::opt::Option::Option", NM="_ZN4llvm3opt6OptionC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3opt6OptionC1EOS1_")
  //</editor-fold>
  public /*inline*/ Option(JD$Move _dparam, Option /*&&*/$Prm0) {
    /* : Info(static_cast<Option &&>().Info), Owner(static_cast<Option &&>().Owner)*/ 
    //START JInit
    this.Info = $Prm0.Info;
    this.Owner = $Prm0.Owner;
    //END JInit
  }

  
  public String toString() {
    return "" + "Info=" + Info // NOI18N
              + ", Owner=" + NativeTrace.getIdentityStr(Owner); // NOI18N
  }
}
