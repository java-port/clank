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

package org.clang.ast;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5251,
 FQN="clang::OwnershipAttr", NM="_ZN5clang13OwnershipAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang13OwnershipAttrE")
//</editor-fold>
public class OwnershipAttr extends /*public*/ InheritableAttr {
  private IdentifierInfo /*P*/ module;
  
  private /*uint*/int args_Size;
  private uint$ptr/*uint P*/ args_;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::Spelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5258,
   FQN="clang::OwnershipAttr::Spelling", NM="_ZN5clang13OwnershipAttr8SpellingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang13OwnershipAttr8SpellingE")
  //</editor-fold>
  public enum Spelling implements Native.ComparableLower {
    GNU_ownership_holds(0),
    GNU_ownership_returns(1),
    GNU_ownership_takes(2);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Spelling valueOf(int val) {
      Spelling out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Spelling[] VALUES;
      private static final Spelling[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Spelling kind : Spelling.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Spelling[min < 0 ? (1-min) : 0];
        VALUES = new Spelling[max >= 0 ? (1+max) : 0];
        for (Spelling kind : Spelling.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Spelling(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Spelling)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Spelling)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5264,
   FQN="clang::OwnershipAttr::CreateImplicit", NM="_ZN5clang13OwnershipAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingEPNS_14IdentifierInfoEPjjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang13OwnershipAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingEPNS_14IdentifierInfoEPjjNS_11SourceRangeE")
  //</editor-fold>
  public static OwnershipAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, IdentifierInfo /*P*/ Module, uint$ptr/*uint P*/ Args, /*uint*/int ArgsSize) {
    return CreateImplicit(Ctx, S, Module, Args, ArgsSize, new SourceRange());
  }
  public static OwnershipAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, IdentifierInfo /*P*/ Module, uint$ptr/*uint P*/ Args, /*uint*/int ArgsSize, SourceRange Loc/*= SourceRange()*/) {
    OwnershipAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new OwnershipAttr(new SourceRange(Loc), Ctx, Module, Args, ArgsSize, S.getValue());
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::OwnershipAttr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*fix NPE*/,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5270,
   FQN="clang::OwnershipAttr::OwnershipAttr", NM="_ZN5clang13OwnershipAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_14IdentifierInfoEPjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang13OwnershipAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_14IdentifierInfoEPjjj")
  //</editor-fold>
  public OwnershipAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      IdentifierInfo /*P*/ Module, 
      uint$ptr/*uint P*/ Args, /*uint*/int ArgsSize, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Ownership, R, SI, false, false), module(Module), args_Size(ArgsSize), args_(new (Ctx, 16) new unsigned int [args_Size]) 
    //START JInit
    super(attr.Kind.Ownership, new SourceRange(R), SI, false, false);
    this.module = Module;
    this.args_Size = ArgsSize;
    this.args_ = create_uint$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 16)*/ new$uint(args_Size));
    //END JInit
    std.copy(Args, args_Size == 0 ? Args : Args.$add(args_Size), args_);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::OwnershipAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5282,
   FQN="clang::OwnershipAttr::OwnershipAttr", NM="_ZN5clang13OwnershipAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_14IdentifierInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang13OwnershipAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_14IdentifierInfoEj")
  //</editor-fold>
  public OwnershipAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      IdentifierInfo /*P*/ Module, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Ownership, R, SI, false, false), module(Module), args_Size(0), args_(null) 
    //START JInit
    super(attr.Kind.Ownership, new SourceRange(R), SI, false, false);
    this.module = Module;
    this.args_Size = 0;
    this.args_ = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4870,
   FQN="clang::OwnershipAttr::clone", NM="_ZNK5clang13OwnershipAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang13OwnershipAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public OwnershipAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    OwnershipAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new OwnershipAttr(new SourceRange(getLocation()), C, module, args_, args_Size, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4878,
   FQN="clang::OwnershipAttr::printPretty", NM="_ZNK5clang13OwnershipAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang13OwnershipAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((ownership_holds(").$out(getModule().getName()).$out(/*KEEP_STR*/$COMMA_SPACE);
        boolean isFirst = true;
        for (final /*const*/int/*uint &*/ Val : args()) {
          if (isFirst) {
            isFirst = false;
          } else {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          OS.$out_uint(Val);
        }
        OS.$out(/*KEEP_STR*/")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((ownership_returns(").$out(getModule().getName()).$out(/*KEEP_STR*/$COMMA_SPACE);
        boolean isFirst = true;
        for (final /*const*/int/*uint &*/ Val : args()) {
          if (isFirst) {
            isFirst = false;
          } else {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          OS.$out_uint(Val);
        }
        OS.$out(/*KEEP_STR*/")))");
        break;
      }
     case 2:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((ownership_takes(").$out(getModule().getName()).$out(/*KEEP_STR*/$COMMA_SPACE);
        boolean isFirst = true;
        for (final /*const*/int/*uint &*/ Val : args()) {
          if (isFirst) {
            isFirst = false;
          } else {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          OS.$out_uint(Val);
        }
        OS.$out(/*KEEP_STR*/")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4919,
   FQN="clang::OwnershipAttr::getSpelling", NM="_ZNK5clang13OwnershipAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang13OwnershipAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("ownership_holds");
     case 1:
      return $("ownership_returns");
     case 2:
      return $("ownership_takes");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::getSemanticSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5296,
   FQN="clang::OwnershipAttr::getSemanticSpelling", NM="_ZNK5clang13OwnershipAttr19getSemanticSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang13OwnershipAttr19getSemanticSpellingEv")
  //</editor-fold>
  public Spelling getSemanticSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown spelling list index");
     case 0:
      return Spelling.GNU_ownership_holds;
     case 1:
      return Spelling.GNU_ownership_returns;
     case 2:
      return Spelling.GNU_ownership_takes;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::isHolds">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5304,
   FQN="clang::OwnershipAttr::isHolds", NM="_ZNK5clang13OwnershipAttr7isHoldsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang13OwnershipAttr7isHoldsEv")
  //</editor-fold>
  public boolean isHolds() /*const*/ {
    return SpellingListIndex == $int2uint_4bits(0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::isReturns">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5305,
   FQN="clang::OwnershipAttr::isReturns", NM="_ZNK5clang13OwnershipAttr9isReturnsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang13OwnershipAttr9isReturnsEv")
  //</editor-fold>
  public boolean isReturns() /*const*/ {
    return SpellingListIndex == $int2uint_4bits(1);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::isTakes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5306,
   FQN="clang::OwnershipAttr::isTakes", NM="_ZNK5clang13OwnershipAttr7isTakesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang13OwnershipAttr7isTakesEv")
  //</editor-fold>
  public boolean isTakes() /*const*/ {
    return SpellingListIndex == $int2uint_4bits(2);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::getModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5307,
   FQN="clang::OwnershipAttr::getModule", NM="_ZNK5clang13OwnershipAttr9getModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang13OwnershipAttr9getModuleEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getModule() /*const*/ {
    return module;
  }

  
  /*typedef unsigned int *args_iterator*/;
  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::args_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5312,
   FQN="clang::OwnershipAttr::args_begin", NM="_ZNK5clang13OwnershipAttr10args_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang13OwnershipAttr10args_beginEv")
  //</editor-fold>
  public uint$ptr/*uint P*/ args_begin() /*const*/ {
    return args_;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::args_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5313,
   FQN="clang::OwnershipAttr::args_end", NM="_ZNK5clang13OwnershipAttr8args_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang13OwnershipAttr8args_endEv")
  //</editor-fold>
  public uint$ptr/*uint P*/ args_end() /*const*/ {
    return args_.$add(args_Size);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::args_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5314,
   FQN="clang::OwnershipAttr::args_size", NM="_ZNK5clang13OwnershipAttr9args_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang13OwnershipAttr9args_sizeEv")
  //</editor-fold>
  public /*uint*/int args_size() /*const*/ {
    return args_Size;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::args">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5315,
   FQN="clang::OwnershipAttr::args", NM="_ZNK5clang13OwnershipAttr4argsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang13OwnershipAttr4argsEv")
  //</editor-fold>
  public iterator_rangeUInt args() /*const*/ {
    return llvm.make_range(args_begin(), args_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::OwnershipKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5319,
   FQN="clang::OwnershipAttr::OwnershipKind", NM="_ZN5clang13OwnershipAttr13OwnershipKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang13OwnershipAttr13OwnershipKindE")
  //</editor-fold>
  public enum OwnershipKind implements Native.ComparableLower {
    Holds(0),
    Returns(Holds.getValue() + 1),
    Takes(Returns.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static OwnershipKind valueOf(int val) {
      OwnershipKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final OwnershipKind[] VALUES;
      private static final OwnershipKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (OwnershipKind kind : OwnershipKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new OwnershipKind[min < 0 ? (1-min) : 0];
        VALUES = new OwnershipKind[max >= 0 ? (1+max) : 0];
        for (OwnershipKind kind : OwnershipKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private OwnershipKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((OwnershipKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((OwnershipKind)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::getOwnKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5320,
   FQN="clang::OwnershipAttr::getOwnKind", NM="_ZNK5clang13OwnershipAttr10getOwnKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang13OwnershipAttr10getOwnKindEv")
  //</editor-fold>
  public OwnershipKind getOwnKind() /*const*/ {
    return isHolds() ? OwnershipKind.Holds : isTakes() ? OwnershipKind.Takes : OwnershipKind.Returns;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5327,
   FQN="clang::OwnershipAttr::classof", NM="_ZN5clang13OwnershipAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang13OwnershipAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.Ownership;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::OwnershipAttr::~OwnershipAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5251,
   FQN="clang::OwnershipAttr::~OwnershipAttr", NM="_ZN5clang13OwnershipAttrD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang13OwnershipAttrD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    // JAVA: super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "module=" + module // NOI18N
              + ", args_Size=" + args_Size // NOI18N
              + ", args_=" + args_ // NOI18N
              + super.toString(); // NOI18N
  }
}
