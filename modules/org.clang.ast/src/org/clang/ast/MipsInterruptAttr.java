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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::MipsInterruptAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3571,
 FQN="clang::MipsInterruptAttr", NM="_ZN5clang17MipsInterruptAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17MipsInterruptAttrE")
//</editor-fold>
public class MipsInterruptAttr extends /*public*/ InheritableAttr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MipsInterruptAttr::InterruptType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3573,
   FQN="clang::MipsInterruptAttr::InterruptType", NM="_ZN5clang17MipsInterruptAttr13InterruptTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17MipsInterruptAttr13InterruptTypeE")
  //</editor-fold>
  public enum InterruptType implements Native.ComparableLower {
    sw0(0),
    sw1(sw0.getValue() + 1),
    hw0(sw1.getValue() + 1),
    hw1(hw0.getValue() + 1),
    hw2(hw1.getValue() + 1),
    hw3(hw2.getValue() + 1),
    hw4(hw3.getValue() + 1),
    hw5(hw4.getValue() + 1),
    eic(hw5.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static InterruptType valueOf(int val) {
      InterruptType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final InterruptType[] VALUES;
      private static final InterruptType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (InterruptType kind : InterruptType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new InterruptType[min < 0 ? (1-min) : 0];
        VALUES = new InterruptType[max >= 0 ? (1+max) : 0];
        for (InterruptType kind : InterruptType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private InterruptType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((InterruptType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((InterruptType)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private InterruptType interrupt;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MipsInterruptAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3588,
   FQN="clang::MipsInterruptAttr::CreateImplicit", NM="_ZN5clang17MipsInterruptAttr14CreateImplicitERNS_10ASTContextENS0_13InterruptTypeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17MipsInterruptAttr14CreateImplicitERNS_10ASTContextENS0_13InterruptTypeENS_11SourceRangeE")
  //</editor-fold>
  public static MipsInterruptAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, InterruptType Interrupt) {
    return CreateImplicit(Ctx, Interrupt, new SourceRange());
  }
  public static MipsInterruptAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, InterruptType Interrupt, SourceRange Loc/*= SourceRange()*/) {
    MipsInterruptAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new MipsInterruptAttr(new SourceRange(Loc), Ctx, Interrupt, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MipsInterruptAttr::MipsInterruptAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3594,
   FQN="clang::MipsInterruptAttr::MipsInterruptAttr", NM="_ZN5clang17MipsInterruptAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_13InterruptTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17MipsInterruptAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_13InterruptTypeEj")
  //</editor-fold>
  public MipsInterruptAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      InterruptType Interrupt, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::MipsInterrupt, R, SI, false, false), interrupt(Interrupt) 
    //START JInit
    super(attr.Kind.MipsInterrupt, new SourceRange(R), SI, false, false);
    this.interrupt = Interrupt;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MipsInterruptAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 3250,
   FQN="clang::MipsInterruptAttr::clone", NM="_ZNK5clang17MipsInterruptAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17MipsInterruptAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public MipsInterruptAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    MipsInterruptAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new MipsInterruptAttr(new SourceRange(getLocation()), C, interrupt, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MipsInterruptAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 3258,
   FQN="clang::MipsInterruptAttr::printPretty", NM="_ZNK5clang17MipsInterruptAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17MipsInterruptAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((interrupt(\"").$out(MipsInterruptAttr.ConvertInterruptTypeToStr(getInterrupt())).$out(/*KEEP_STR*/"\")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MipsInterruptAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 3270,
   FQN="clang::MipsInterruptAttr::getSpelling", NM="_ZNK5clang17MipsInterruptAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17MipsInterruptAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("interrupt");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MipsInterruptAttr::getInterrupt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3607,
   FQN="clang::MipsInterruptAttr::getInterrupt", NM="_ZNK5clang17MipsInterruptAttr12getInterruptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17MipsInterruptAttr12getInterruptEv")
  //</editor-fold>
  public InterruptType getInterrupt() /*const*/ {
    return interrupt;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MipsInterruptAttr::ConvertStrToInterruptType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3611,
   FQN="clang::MipsInterruptAttr::ConvertStrToInterruptType", NM="_ZN5clang17MipsInterruptAttr25ConvertStrToInterruptTypeEN4llvm9StringRefERNS0_13InterruptTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17MipsInterruptAttr25ConvertStrToInterruptTypeEN4llvm9StringRefERNS0_13InterruptTypeE")
  //</editor-fold>
  public static boolean ConvertStrToInterruptType(StringRef Val, final type$ref<InterruptType /*&*/> Out) {
    Optional<InterruptType> R = new StringSwitch<Optional<InterruptType> >(/*NO_COPY*/Val).
        Case(/*KEEP_STR*/"vector=sw0", new Optional<InterruptType>(JD$T$RR.INSTANCE, MipsInterruptAttr.InterruptType.sw0)).
        Case(/*KEEP_STR*/"vector=sw1", new Optional<InterruptType>(JD$T$RR.INSTANCE, MipsInterruptAttr.InterruptType.sw1)).
        Case(/*KEEP_STR*/"vector=hw0", new Optional<InterruptType>(JD$T$RR.INSTANCE, MipsInterruptAttr.InterruptType.hw0)).
        Case(/*KEEP_STR*/"vector=hw1", new Optional<InterruptType>(JD$T$RR.INSTANCE, MipsInterruptAttr.InterruptType.hw1)).
        Case(/*KEEP_STR*/"vector=hw2", new Optional<InterruptType>(JD$T$RR.INSTANCE, MipsInterruptAttr.InterruptType.hw2)).
        Case(/*KEEP_STR*/"vector=hw3", new Optional<InterruptType>(JD$T$RR.INSTANCE, MipsInterruptAttr.InterruptType.hw3)).
        Case(/*KEEP_STR*/"vector=hw4", new Optional<InterruptType>(JD$T$RR.INSTANCE, MipsInterruptAttr.InterruptType.hw4)).
        Case(/*KEEP_STR*/"vector=hw5", new Optional<InterruptType>(JD$T$RR.INSTANCE, MipsInterruptAttr.InterruptType.hw5)).
        Case(/*KEEP_STR*/"eic", new Optional<InterruptType>(JD$T$RR.INSTANCE, MipsInterruptAttr.InterruptType.eic)).
        Case(/*KEEP_STR*/"", new Optional<InterruptType>(JD$T$RR.INSTANCE, MipsInterruptAttr.InterruptType.eic)).
        Default(new Optional<InterruptType>());
    if (R.$bool()) {
      Out.$set(R.$star());
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MipsInterruptAttr::ConvertInterruptTypeToStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3631,
   FQN="clang::MipsInterruptAttr::ConvertInterruptTypeToStr", NM="_ZN5clang17MipsInterruptAttr25ConvertInterruptTypeToStrENS0_13InterruptTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17MipsInterruptAttr25ConvertInterruptTypeToStrENS0_13InterruptTypeE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ ConvertInterruptTypeToStr(InterruptType Val) {
    switch (Val) {
     case sw0:
      return $("vector=sw0");
     case sw1:
      return $("vector=sw1");
     case hw0:
      return $("vector=hw0");
     case hw1:
      return $("vector=hw1");
     case hw2:
      return $("vector=hw2");
     case hw3:
      return $("vector=hw3");
     case hw4:
      return $("vector=hw4");
     case hw5:
      return $("vector=hw5");
     case eic:
      return $("eic");
    }
    throw new llvm_unreachable("No enumerator with that value");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MipsInterruptAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3647,
   FQN="clang::MipsInterruptAttr::classof", NM="_ZN5clang17MipsInterruptAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17MipsInterruptAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.MipsInterrupt;
  }

  
  @Override public String toString() {
    return "" + "interrupt=" + interrupt // NOI18N
              + super.toString(); // NOI18N
  }
}
