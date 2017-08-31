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

//<editor-fold defaultstate="collapsed" desc="clang::RequiresCapabilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5799,
 FQN="clang::RequiresCapabilityAttr", NM="_ZN5clang22RequiresCapabilityAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22RequiresCapabilityAttrE")
//</editor-fold>
public class RequiresCapabilityAttr extends /*public*/ InheritableAttr implements org.clang.ast.java.ArgsAttrBase {
  private /*uint*/int args_Size;
  private type$ptr<Expr/*P*/> args_;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::RequiresCapabilityAttr::Spelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5804,
   FQN="clang::RequiresCapabilityAttr::Spelling", NM="_ZN5clang22RequiresCapabilityAttr8SpellingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22RequiresCapabilityAttr8SpellingE")
  //</editor-fold>
  public enum Spelling implements Native.ComparableLower {
    GNU_requires_capability(0),
    CXX11_clang_requires_capability(1),
    GNU_exclusive_locks_required(2),
    GNU_requires_shared_capability(3),
    CXX11_clang_requires_shared_capability(4),
    GNU_shared_locks_required(5);

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
  
  //<editor-fold defaultstate="collapsed" desc="clang::RequiresCapabilityAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5813,
   FQN="clang::RequiresCapabilityAttr::CreateImplicit", NM="_ZN5clang22RequiresCapabilityAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingEPPNS_4ExprEjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22RequiresCapabilityAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingEPPNS_4ExprEjNS_11SourceRangeE")
  //</editor-fold>
  public static RequiresCapabilityAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, type$ptr<Expr/*P*/> Args, /*uint*/int ArgsSize) {
    return CreateImplicit(Ctx, S, Args, ArgsSize, new SourceRange());
  }
  public static RequiresCapabilityAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, type$ptr<Expr/*P*/> Args, /*uint*/int ArgsSize, SourceRange Loc/*= SourceRange()*/) {
    RequiresCapabilityAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new RequiresCapabilityAttr(new SourceRange(Loc), Ctx, Args, ArgsSize, S.getValue());
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RequiresCapabilityAttr::RequiresCapabilityAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5819,
   FQN="clang::RequiresCapabilityAttr::RequiresCapabilityAttr", NM="_ZN5clang22RequiresCapabilityAttrC1ENS_11SourceRangeERNS_10ASTContextEPPNS_4ExprEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22RequiresCapabilityAttrC1ENS_11SourceRangeERNS_10ASTContextEPPNS_4ExprEjj")
  //</editor-fold>
  public RequiresCapabilityAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      type$ptr<Expr/*P*/> Args, /*uint*/int ArgsSize, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::RequiresCapability, R, SI, true, true), args_Size(ArgsSize), args_(new (Ctx, 16) new Expr * [args_Size]) 
    //START JInit
    super(attr.Kind.RequiresCapability, new SourceRange(R), SI, true, true);
    this.args_Size = ArgsSize;
    this.args_ = create_type$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 16)*/ new Expr /*P*/ [args_Size]);
    //END JInit
    std.copy(Args, Args.$add(args_Size), args_);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RequiresCapabilityAttr::RequiresCapabilityAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5829,
   FQN="clang::RequiresCapabilityAttr::RequiresCapabilityAttr", NM="_ZN5clang22RequiresCapabilityAttrC1ENS_11SourceRangeERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22RequiresCapabilityAttrC1ENS_11SourceRangeERNS_10ASTContextEj")
  //</editor-fold>
  public RequiresCapabilityAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::RequiresCapability, R, SI, true, true), args_Size(0), args_(null) 
    //START JInit
    super(attr.Kind.RequiresCapability, new SourceRange(R), SI, true, true);
    this.args_Size = 0;
    this.args_ = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RequiresCapabilityAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 5438,
   FQN="clang::RequiresCapabilityAttr::clone", NM="_ZNK5clang22RequiresCapabilityAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22RequiresCapabilityAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public RequiresCapabilityAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    RequiresCapabilityAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new RequiresCapabilityAttr(new SourceRange(getLocation()), C, args_, args_Size, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RequiresCapabilityAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 5446,
   FQN="clang::RequiresCapabilityAttr::printPretty", NM="_ZNK5clang22RequiresCapabilityAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22RequiresCapabilityAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((requires_capability(");
        boolean isFirst = true;
        for (final Expr /*P*/ /*const*/ /*&*/ Val : args()) {
          if (isFirst) {
            isFirst = false;
          } else {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          OS.$out(Val);
        }
        OS.$out(/*KEEP_STR*/")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[clang::requires_capability(");
        boolean isFirst = true;
        for (final Expr /*P*/ /*const*/ /*&*/ Val : args()) {
          if (isFirst) {
            isFirst = false;
          } else {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          OS.$out(Val);
        }
        OS.$out(/*KEEP_STR*/")]]");
        break;
      }
     case 2:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((exclusive_locks_required(");
        boolean isFirst = true;
        for (final Expr /*P*/ /*const*/ /*&*/ Val : args()) {
          if (isFirst) {
            isFirst = false;
          } else {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          OS.$out(Val);
        }
        OS.$out(/*KEEP_STR*/")))");
        break;
      }
     case 3:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((requires_shared_capability(");
        boolean isFirst = true;
        for (final Expr /*P*/ /*const*/ /*&*/ Val : args()) {
          if (isFirst) {
            isFirst = false;
          } else {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          OS.$out(Val);
        }
        OS.$out(/*KEEP_STR*/")))");
        break;
      }
     case 4:
      {
        OS.$out(/*KEEP_STR*/" [[clang::requires_shared_capability(");
        boolean isFirst = true;
        for (final Expr /*P*/ /*const*/ /*&*/ Val : args()) {
          if (isFirst) {
            isFirst = false;
          } else {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          OS.$out(Val);
        }
        OS.$out(/*KEEP_STR*/")]]");
        break;
      }
     case 5:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((shared_locks_required(");
        boolean isFirst = true;
        for (final Expr /*P*/ /*const*/ /*&*/ Val : args()) {
          if (isFirst) {
            isFirst = false;
          } else {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          OS.$out(Val);
        }
        OS.$out(/*KEEP_STR*/")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RequiresCapabilityAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 5520,
   FQN="clang::RequiresCapabilityAttr::getSpelling", NM="_ZNK5clang22RequiresCapabilityAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22RequiresCapabilityAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("requires_capability");
     case 1:
      return $("requires_capability");
     case 2:
      return $("exclusive_locks_required");
     case 3:
      return $("requires_shared_capability");
     case 4:
      return $("requires_shared_capability");
     case 5:
      return $("shared_locks_required");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RequiresCapabilityAttr::getSemanticSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5841,
   FQN="clang::RequiresCapabilityAttr::getSemanticSpelling", NM="_ZNK5clang22RequiresCapabilityAttr19getSemanticSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22RequiresCapabilityAttr19getSemanticSpellingEv")
  //</editor-fold>
  public Spelling getSemanticSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown spelling list index");
     case 0:
      return Spelling.GNU_requires_capability;
     case 1:
      return Spelling.CXX11_clang_requires_capability;
     case 2:
      return Spelling.GNU_exclusive_locks_required;
     case 3:
      return Spelling.GNU_requires_shared_capability;
     case 4:
      return Spelling.CXX11_clang_requires_shared_capability;
     case 5:
      return Spelling.GNU_shared_locks_required;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RequiresCapabilityAttr::isShared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5852,
   FQN="clang::RequiresCapabilityAttr::isShared", NM="_ZNK5clang22RequiresCapabilityAttr8isSharedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22RequiresCapabilityAttr8isSharedEv")
  //</editor-fold>
  public boolean isShared() /*const*/ {
    return SpellingListIndex == $int2uint_4bits(3)
       || SpellingListIndex == $int2uint_4bits(5)
       || SpellingListIndex == $int2uint_4bits(4);
  }

  /*typedef Expr **args_iterator*/
//  public final class args_iterator extends type$ptr<Expr/*P*/> { };
  //<editor-fold defaultstate="collapsed" desc="clang::RequiresCapabilityAttr::args_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5856,
   FQN="clang::RequiresCapabilityAttr::args_begin", NM="_ZNK5clang22RequiresCapabilityAttr10args_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22RequiresCapabilityAttr10args_beginEv")
  //</editor-fold>
  public type$ptr<Expr/*P*/> args_begin() /*const*/ {
    return args_;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RequiresCapabilityAttr::args_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5857,
   FQN="clang::RequiresCapabilityAttr::args_end", NM="_ZNK5clang22RequiresCapabilityAttr8args_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22RequiresCapabilityAttr8args_endEv")
  //</editor-fold>
  public type$ptr<Expr/*P*/> args_end() /*const*/ {
    return args_.$add(args_Size);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RequiresCapabilityAttr::args_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5858,
   FQN="clang::RequiresCapabilityAttr::args_size", NM="_ZNK5clang22RequiresCapabilityAttr9args_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22RequiresCapabilityAttr9args_sizeEv")
  //</editor-fold>
  public /*uint*/int args_size() /*const*/ {
    return args_Size;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RequiresCapabilityAttr::args">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5859,
   FQN="clang::RequiresCapabilityAttr::args", NM="_ZNK5clang22RequiresCapabilityAttr4argsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22RequiresCapabilityAttr4argsEv")
  //</editor-fold>
  public iterator_range<Expr/*P*/> args() /*const*/ {
    return llvm.make_range(args_begin(), args_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RequiresCapabilityAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5864,
   FQN="clang::RequiresCapabilityAttr::classof", NM="_ZN5clang22RequiresCapabilityAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22RequiresCapabilityAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.RequiresCapability;
  }

  
  @Override public String toString() {
    return "" + "args_Size=" + args_Size // NOI18N
              + ", args_=" + args_ // NOI18N
              + super.toString(); // NOI18N
  }
}
