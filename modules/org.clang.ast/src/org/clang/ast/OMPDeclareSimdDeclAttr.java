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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.getOpenMPSimpleClauseTypeName;

//<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4253,
 FQN="clang::OMPDeclareSimdDeclAttr", NM="_ZN5clang22OMPDeclareSimdDeclAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22OMPDeclareSimdDeclAttrE")
//</editor-fold>
public class OMPDeclareSimdDeclAttr extends /*public*/ Attr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::BranchStateTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4255,
   FQN="clang::OMPDeclareSimdDeclAttr::BranchStateTy", NM="_ZN5clang22OMPDeclareSimdDeclAttr13BranchStateTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22OMPDeclareSimdDeclAttr13BranchStateTyE")
  //</editor-fold>
  public enum BranchStateTy implements Native.ComparableLower {
    BS_Undefined(0),
    BS_Inbranch(BS_Undefined.getValue() + 1),
    BS_Notinbranch(BS_Inbranch.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static BranchStateTy valueOf(int val) {
      BranchStateTy out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final BranchStateTy[] VALUES;
      private static final BranchStateTy[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (BranchStateTy kind : BranchStateTy.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new BranchStateTy[min < 0 ? (1-min) : 0];
        VALUES = new BranchStateTy[max >= 0 ? (1+max) : 0];
        for (BranchStateTy kind : BranchStateTy.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private BranchStateTy(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((BranchStateTy)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((BranchStateTy)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private BranchStateTy branchState;
  
  private Expr /*P*/ simdlen;
  
  private /*uint*/int uniforms_Size;
  private type$ptr<Expr/*P*/> uniforms_;
  
  private /*uint*/int aligneds_Size;
  private type$ptr<Expr/*P*/> aligneds_;
  
  private /*uint*/int alignments_Size;
  private type$ptr<Expr/*P*/> alignments_;
  
  private /*uint*/int linears_Size;
  private type$ptr<Expr/*P*/> linears_;
  
  private /*uint*/int modifiers_Size;
  private uint$ptr/*uint P*/ modifiers_;
  
  private /*uint*/int steps_Size;
  private type$ptr<Expr/*P*/> steps_;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4284,
   FQN="clang::OMPDeclareSimdDeclAttr::CreateImplicit", NM="_ZN5clang22OMPDeclareSimdDeclAttr14CreateImplicitERNS_10ASTContextENS0_13BranchStateTyEPNS_4ExprEPS5_jS6_jS6_jS6_jPjjS6_jNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22OMPDeclareSimdDeclAttr14CreateImplicitERNS_10ASTContextENS0_13BranchStateTyEPNS_4ExprEPS5_jS6_jS6_jS6_jPjjS6_jNS_11SourceRangeE")
  //</editor-fold>
  public static OMPDeclareSimdDeclAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, BranchStateTy BranchState, Expr /*P*/ Simdlen, type$ptr<Expr/*P*/> Uniforms, /*uint*/int UniformsSize, type$ptr<Expr/*P*/> Aligneds, /*uint*/int AlignedsSize, type$ptr<Expr/*P*/> Alignments, /*uint*/int AlignmentsSize, type$ptr<Expr/*P*/> Linears, /*uint*/int LinearsSize, uint$ptr/*uint P*/ Modifiers, /*uint*/int ModifiersSize, type$ptr<Expr/*P*/> Steps, /*uint*/int StepsSize) {
    return CreateImplicit(Ctx, BranchState, Simdlen, Uniforms, UniformsSize, Aligneds, AlignedsSize, Alignments, AlignmentsSize, Linears, LinearsSize, Modifiers, ModifiersSize, Steps, StepsSize, new SourceRange());
  }
  public static OMPDeclareSimdDeclAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, BranchStateTy BranchState, Expr /*P*/ Simdlen, type$ptr<Expr/*P*/> Uniforms, /*uint*/int UniformsSize, type$ptr<Expr/*P*/> Aligneds, /*uint*/int AlignedsSize, type$ptr<Expr/*P*/> Alignments, /*uint*/int AlignmentsSize, type$ptr<Expr/*P*/> Linears, /*uint*/int LinearsSize, uint$ptr/*uint P*/ Modifiers, /*uint*/int ModifiersSize, type$ptr<Expr/*P*/> Steps, /*uint*/int StepsSize, SourceRange Loc/*= SourceRange()*/) {
    OMPDeclareSimdDeclAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new OMPDeclareSimdDeclAttr(new SourceRange(Loc), Ctx, BranchState, Simdlen, Uniforms, UniformsSize, Aligneds, AlignedsSize, Alignments, AlignmentsSize, Linears, LinearsSize, Modifiers, ModifiersSize, Steps, StepsSize, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::OMPDeclareSimdDeclAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4290,
   FQN="clang::OMPDeclareSimdDeclAttr::OMPDeclareSimdDeclAttr", NM="_ZN5clang22OMPDeclareSimdDeclAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_13BranchStateTyEPNS_4ExprEPS6_jS7_jS7_jS7_jPjjS7_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22OMPDeclareSimdDeclAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_13BranchStateTyEPNS_4ExprEPS6_jS7_jS7_jS7_jPjjS7_jj")
  //</editor-fold>
  public OMPDeclareSimdDeclAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      BranchStateTy BranchState, 
      Expr /*P*/ Simdlen, 
      type$ptr<Expr/*P*/> Uniforms, /*uint*/int UniformsSize, 
      type$ptr<Expr/*P*/> Aligneds, /*uint*/int AlignedsSize, 
      type$ptr<Expr/*P*/> Alignments, /*uint*/int AlignmentsSize, 
      type$ptr<Expr/*P*/> Linears, /*uint*/int LinearsSize, 
      uint$ptr/*uint P*/ Modifiers, /*uint*/int ModifiersSize, 
      type$ptr<Expr/*P*/> Steps, /*uint*/int StepsSize, 
      /*uint*/int SI) {
    // : Attr(attr::OMPDeclareSimdDecl, R, SI, false, false), branchState(BranchState), simdlen(Simdlen), uniforms_Size(UniformsSize), uniforms_(new (Ctx, 16) new Expr * [uniforms_Size]), aligneds_Size(AlignedsSize), aligneds_(new (Ctx, 16) new Expr * [aligneds_Size]), alignments_Size(AlignmentsSize), alignments_(new (Ctx, 16) new Expr * [alignments_Size]), linears_Size(LinearsSize), linears_(new (Ctx, 16) new Expr * [linears_Size]), modifiers_Size(ModifiersSize), modifiers_(new (Ctx, 16) new unsigned int [modifiers_Size]), steps_Size(StepsSize), steps_(new (Ctx, 16) new Expr * [steps_Size]) 
    //START JInit
    super(attr.Kind.OMPDeclareSimdDecl, new SourceRange(R), SI, false, false);
    this.branchState = BranchState;
    this.simdlen = Simdlen;
    this.uniforms_Size = UniformsSize;
    this.uniforms_ = create_type$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 16)*/ new Expr /*P*/ [uniforms_Size]);
    this.aligneds_Size = AlignedsSize;
    this.aligneds_ = create_type$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 16)*/ new Expr /*P*/ [aligneds_Size]);
    this.alignments_Size = AlignmentsSize;
    this.alignments_ = create_type$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 16)*/ new Expr /*P*/ [alignments_Size]);
    this.linears_Size = LinearsSize;
    this.linears_ = create_type$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 16)*/ new Expr /*P*/ [linears_Size]);
    this.modifiers_Size = ModifiersSize;
    this.modifiers_ = create_uint$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 16)*/ new$uint(modifiers_Size));
    this.steps_Size = StepsSize;
    this.steps_ = create_type$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 16)*/ new Expr /*P*/ [steps_Size]);
    //END JInit
    std.copy(Uniforms, Uniforms.$add(uniforms_Size), uniforms_);
    std.copy(Aligneds, Aligneds.$add(aligneds_Size), aligneds_);
    std.copy(Alignments, Alignments.$add(alignments_Size), alignments_);
    std.copy(Linears, Linears.$add(linears_Size), linears_);
    std.copy(Modifiers, Modifiers.$add(modifiers_Size), modifiers_);
    std.copy(Steps, Steps.$add(steps_Size), steps_);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::OMPDeclareSimdDeclAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4319,
   FQN="clang::OMPDeclareSimdDeclAttr::OMPDeclareSimdDeclAttr", NM="_ZN5clang22OMPDeclareSimdDeclAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_13BranchStateTyEPNS_4ExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22OMPDeclareSimdDeclAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_13BranchStateTyEPNS_4ExprEj")
  //</editor-fold>
  public OMPDeclareSimdDeclAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      BranchStateTy BranchState, 
      Expr /*P*/ Simdlen, 
      /*uint*/int SI) {
    // : Attr(attr::OMPDeclareSimdDecl, R, SI, false, false), branchState(BranchState), simdlen(Simdlen), uniforms_Size(0), uniforms_(null), aligneds_Size(0), aligneds_(null), alignments_Size(0), alignments_(null), linears_Size(0), linears_(null), modifiers_Size(0), modifiers_(null), steps_Size(0), steps_(null) 
    //START JInit
    super(attr.Kind.OMPDeclareSimdDecl, new SourceRange(R), SI, false, false);
    this.branchState = BranchState;
    this.simdlen = Simdlen;
    this.uniforms_Size = 0;
    this.uniforms_ = null;
    this.aligneds_Size = 0;
    this.aligneds_ = null;
    this.alignments_Size = 0;
    this.alignments_ = null;
    this.linears_Size = 0;
    this.linears_ = null;
    this.modifiers_Size = 0;
    this.modifiers_ = null;
    this.steps_Size = 0;
    this.steps_ = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4061,
   FQN="clang::OMPDeclareSimdDeclAttr::clone", NM="_ZNK5clang22OMPDeclareSimdDeclAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public OMPDeclareSimdDeclAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    OMPDeclareSimdDeclAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new OMPDeclareSimdDeclAttr(new SourceRange(getLocation()), C, branchState, simdlen, uniforms_, uniforms_Size, aligneds_, aligneds_Size, alignments_, alignments_Size, linears_, linears_Size, modifiers_, modifiers_Size, steps_, steps_Size, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4069,
   FQN="clang::OMPDeclareSimdDeclAttr::printPretty", NM="_ZNK5clang22OMPDeclareSimdDeclAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/"#pragma omp declare simd ");
        printPrettyPragma(OS, Policy);
        OS.$out(/*KEEP_STR*/$LF);
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4082,
   FQN="clang::OMPDeclareSimdDeclAttr::getSpelling", NM="_ZNK5clang22OMPDeclareSimdDeclAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("declare simd");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::getBranchState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4340,
   FQN="clang::OMPDeclareSimdDeclAttr::getBranchState", NM="_ZNK5clang22OMPDeclareSimdDeclAttr14getBranchStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr14getBranchStateEv")
  //</editor-fold>
  public BranchStateTy getBranchState() /*const*/ {
    return branchState;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::ConvertStrToBranchStateTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4344,
   FQN="clang::OMPDeclareSimdDeclAttr::ConvertStrToBranchStateTy", NM="_ZN5clang22OMPDeclareSimdDeclAttr25ConvertStrToBranchStateTyEN4llvm9StringRefERNS0_13BranchStateTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22OMPDeclareSimdDeclAttr25ConvertStrToBranchStateTyEN4llvm9StringRefERNS0_13BranchStateTyE")
  //</editor-fold>
  public static boolean ConvertStrToBranchStateTy(StringRef Val, final type$ref<BranchStateTy/*&*/> Out) {
    Optional<BranchStateTy> R = new StringSwitch<Optional<BranchStateTy> >(/*NO_COPY*/Val).
        Case(/*KEEP_STR*/"", new Optional<BranchStateTy>(JD$T$RR.INSTANCE, OMPDeclareSimdDeclAttr.BranchStateTy.BS_Undefined)).
        Case(/*KEEP_STR*/"inbranch", new Optional<BranchStateTy>(JD$T$RR.INSTANCE, OMPDeclareSimdDeclAttr.BranchStateTy.BS_Inbranch)).
        Case(/*KEEP_STR*/"notinbranch", new Optional<BranchStateTy>(JD$T$RR.INSTANCE, OMPDeclareSimdDeclAttr.BranchStateTy.BS_Notinbranch)).
        Default(new Optional<BranchStateTy>());
    if (R.$bool()) {
      Out.$set(R.$star());
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::ConvertBranchStateTyToStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4357,
   FQN="clang::OMPDeclareSimdDeclAttr::ConvertBranchStateTyToStr", NM="_ZN5clang22OMPDeclareSimdDeclAttr25ConvertBranchStateTyToStrENS0_13BranchStateTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22OMPDeclareSimdDeclAttr25ConvertBranchStateTyToStrENS0_13BranchStateTyE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ ConvertBranchStateTyToStr(BranchStateTy Val) {
    switch (Val) {
     case BS_Undefined:
      return $EMPTY;
     case BS_Inbranch:
      return $("inbranch");
     case BS_Notinbranch:
      return $("notinbranch");
    }
    throw new llvm_unreachable("No enumerator with that value");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::getSimdlen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4365,
   FQN="clang::OMPDeclareSimdDeclAttr::getSimdlen", NM="_ZNK5clang22OMPDeclareSimdDeclAttr10getSimdlenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr10getSimdlenEv")
  //</editor-fold>
  public Expr /*P*/ getSimdlen() /*const*/ {
    return simdlen;
  }

  
  /*typedef Expr **uniforms_iterator*/
//  public final class uniforms_iterator extends type$ptr<Expr/*P*/> { };
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::uniforms_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4370,
   FQN="clang::OMPDeclareSimdDeclAttr::uniforms_begin", NM="_ZNK5clang22OMPDeclareSimdDeclAttr14uniforms_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr14uniforms_beginEv")
  //</editor-fold>
  public type$ptr<Expr>/*uniforms_iterator*/ uniforms_begin() /*const*/ {
    return uniforms_;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::uniforms_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4371,
   FQN="clang::OMPDeclareSimdDeclAttr::uniforms_end", NM="_ZNK5clang22OMPDeclareSimdDeclAttr12uniforms_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr12uniforms_endEv")
  //</editor-fold>
  public type$ptr<Expr>/*uniforms_iterator*/ uniforms_end() /*const*/ {
    return uniforms_.$add(uniforms_Size);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::uniforms_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4372,
   FQN="clang::OMPDeclareSimdDeclAttr::uniforms_size", NM="_ZNK5clang22OMPDeclareSimdDeclAttr13uniforms_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr13uniforms_sizeEv")
  //</editor-fold>
  public /*uint*/int uniforms_size() /*const*/ {
    return uniforms_Size;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::uniforms">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4373,
   FQN="clang::OMPDeclareSimdDeclAttr::uniforms", NM="_ZNK5clang22OMPDeclareSimdDeclAttr8uniformsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr8uniformsEv")
  //</editor-fold>
  public iterator_range<Expr/*uniforms_iterator*/> uniforms() /*const*/ {
    return llvm.make_range(uniforms_begin(), uniforms_end());
  }

  
  /*typedef Expr **aligneds_iterator*/
//  public final class aligneds_iterator extends type$ptr<Expr/*P*/> { };
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::aligneds_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4377,
   FQN="clang::OMPDeclareSimdDeclAttr::aligneds_begin", NM="_ZNK5clang22OMPDeclareSimdDeclAttr14aligneds_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr14aligneds_beginEv")
  //</editor-fold>
  public type$ptr<Expr>/*aligneds_iterator*/ aligneds_begin() /*const*/ {
    return aligneds_;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::aligneds_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4378,
   FQN="clang::OMPDeclareSimdDeclAttr::aligneds_end", NM="_ZNK5clang22OMPDeclareSimdDeclAttr12aligneds_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr12aligneds_endEv")
  //</editor-fold>
  public type$ptr<Expr>/*aligneds_iterator*/ aligneds_end() /*const*/ {
    return aligneds_.$add(aligneds_Size);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::aligneds_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4379,
   FQN="clang::OMPDeclareSimdDeclAttr::aligneds_size", NM="_ZNK5clang22OMPDeclareSimdDeclAttr13aligneds_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr13aligneds_sizeEv")
  //</editor-fold>
  public /*uint*/int aligneds_size() /*const*/ {
    return aligneds_Size;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::aligneds">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4380,
   FQN="clang::OMPDeclareSimdDeclAttr::aligneds", NM="_ZNK5clang22OMPDeclareSimdDeclAttr8alignedsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr8alignedsEv")
  //</editor-fold>
  public iterator_range<Expr/*aligneds_iterator*/> aligneds() /*const*/ {
    return llvm.make_range(aligneds_begin(), aligneds_end());
  }

  
  /*typedef Expr **alignments_iterator*/
//  public final class alignments_iterator extends type$ptr<Expr/*P*/> { };
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::alignments_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4384,
   FQN="clang::OMPDeclareSimdDeclAttr::alignments_begin", NM="_ZNK5clang22OMPDeclareSimdDeclAttr16alignments_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr16alignments_beginEv")
  //</editor-fold>
  public type$ptr<Expr>/*alignments_iterator*/ alignments_begin() /*const*/ {
    return alignments_;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::alignments_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4385,
   FQN="clang::OMPDeclareSimdDeclAttr::alignments_end", NM="_ZNK5clang22OMPDeclareSimdDeclAttr14alignments_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr14alignments_endEv")
  //</editor-fold>
  public type$ptr<Expr>/*alignments_iterator*/ alignments_end() /*const*/ {
    return alignments_.$add(alignments_Size);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::alignments_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4386,
   FQN="clang::OMPDeclareSimdDeclAttr::alignments_size", NM="_ZNK5clang22OMPDeclareSimdDeclAttr15alignments_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr15alignments_sizeEv")
  //</editor-fold>
  public /*uint*/int alignments_size() /*const*/ {
    return alignments_Size;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::alignments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4387,
   FQN="clang::OMPDeclareSimdDeclAttr::alignments", NM="_ZNK5clang22OMPDeclareSimdDeclAttr10alignmentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr10alignmentsEv")
  //</editor-fold>
  public iterator_range<Expr/*alignments_iterator*/> alignments() /*const*/ {
    return llvm.make_range(alignments_begin(), alignments_end());
  }

  
  /*typedef Expr **linears_iterator*/
//  public final class linears_iterator extends type$ptr<Expr/*P*/> { };
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::linears_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4391,
   FQN="clang::OMPDeclareSimdDeclAttr::linears_begin", NM="_ZNK5clang22OMPDeclareSimdDeclAttr13linears_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr13linears_beginEv")
  //</editor-fold>
  public type$ptr<Expr>/*linears_iterator*/ linears_begin() /*const*/ {
    return linears_;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::linears_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4392,
   FQN="clang::OMPDeclareSimdDeclAttr::linears_end", NM="_ZNK5clang22OMPDeclareSimdDeclAttr11linears_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr11linears_endEv")
  //</editor-fold>
  public type$ptr<Expr>/*linears_iterator*/ linears_end() /*const*/ {
    return linears_.$add(linears_Size);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::linears_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4393,
   FQN="clang::OMPDeclareSimdDeclAttr::linears_size", NM="_ZNK5clang22OMPDeclareSimdDeclAttr12linears_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr12linears_sizeEv")
  //</editor-fold>
  public /*uint*/int linears_size() /*const*/ {
    return linears_Size;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::linears">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4394,
   FQN="clang::OMPDeclareSimdDeclAttr::linears", NM="_ZNK5clang22OMPDeclareSimdDeclAttr7linearsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr7linearsEv")
  //</editor-fold>
  public iterator_range<Expr/*linears_iterator*/> linears() /*const*/ {
    return llvm.make_range(linears_begin(), linears_end());
  }

  
  /*typedef unsigned int *modifiers_iterator*/;
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::modifiers_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4398,
   FQN="clang::OMPDeclareSimdDeclAttr::modifiers_begin", NM="_ZNK5clang22OMPDeclareSimdDeclAttr15modifiers_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr15modifiers_beginEv")
  //</editor-fold>
  public uint$ptr/*uint P*/ modifiers_begin() /*const*/ {
    return modifiers_;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::modifiers_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4399,
   FQN="clang::OMPDeclareSimdDeclAttr::modifiers_end", NM="_ZNK5clang22OMPDeclareSimdDeclAttr13modifiers_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr13modifiers_endEv")
  //</editor-fold>
  public uint$ptr/*uint P*/ modifiers_end() /*const*/ {
    return modifiers_.$add(modifiers_Size);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::modifiers_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4400,
   FQN="clang::OMPDeclareSimdDeclAttr::modifiers_size", NM="_ZNK5clang22OMPDeclareSimdDeclAttr14modifiers_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr14modifiers_sizeEv")
  //</editor-fold>
  public /*uint*/int modifiers_size() /*const*/ {
    return modifiers_Size;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::modifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4401,
   FQN="clang::OMPDeclareSimdDeclAttr::modifiers", NM="_ZNK5clang22OMPDeclareSimdDeclAttr9modifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr9modifiersEv")
  //</editor-fold>
  public iterator_rangeUInt/*uint P*/ modifiers() /*const*/ {
    return llvm.make_range(modifiers_begin(), modifiers_end());
  }

  
  /*typedef Expr **steps_iterator*/
//  public final class steps_iterator extends type$ptr<Expr/*P*/> { };
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::steps_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4405,
   FQN="clang::OMPDeclareSimdDeclAttr::steps_begin", NM="_ZNK5clang22OMPDeclareSimdDeclAttr11steps_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr11steps_beginEv")
  //</editor-fold>
  public type$ptr<Expr>/*steps_iterator*/ steps_begin() /*const*/ {
    return steps_;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::steps_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4406,
   FQN="clang::OMPDeclareSimdDeclAttr::steps_end", NM="_ZNK5clang22OMPDeclareSimdDeclAttr9steps_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr9steps_endEv")
  //</editor-fold>
  public type$ptr<Expr>/*steps_iterator*/ steps_end() /*const*/ {
    return steps_.$add(steps_Size);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::steps_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4407,
   FQN="clang::OMPDeclareSimdDeclAttr::steps_size", NM="_ZNK5clang22OMPDeclareSimdDeclAttr10steps_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr10steps_sizeEv")
  //</editor-fold>
  public /*uint*/int steps_size() /*const*/ {
    return steps_Size;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::steps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4408,
   FQN="clang::OMPDeclareSimdDeclAttr::steps", NM="_ZNK5clang22OMPDeclareSimdDeclAttr5stepsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr5stepsEv")
  //</editor-fold>
  public iterator_range<Expr/*steps_iterator*/> steps() /*const*/ {
    return llvm.make_range(steps_begin(), steps_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::printPrettyPragma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4412,
   FQN="clang::OMPDeclareSimdDeclAttr::printPrettyPragma", NM="_ZNK5clang22OMPDeclareSimdDeclAttr17printPrettyPragmaERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22OMPDeclareSimdDeclAttr17printPrettyPragmaERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPrettyPragma(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    if (getBranchState() != BranchStateTy.BS_Undefined) {
      OS.$out(ConvertBranchStateTyToStr(getBranchState())).$out(/*KEEP_STR*/$SPACE);
    }
    {
      Expr /*P*/ E = getSimdlen();
      if ((E != null)) {
        OS.$out(/*KEEP_STR*/"simdlen(");
        E.printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
        OS.$out(/*KEEP_STR*/") ");
      }
    }
    if ($greater_uint(uniforms_size(), 0)) {
      OS.$out(/*KEEP_STR*/"uniform");
      StringRef Sep = new StringRef(/*KEEP_STR*/$LPAREN);
      for (Expr /*P*/ E : uniforms()) {
        OS.$out(/*NO_COPY*/Sep);
        E.printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
        Sep.$assignMove(/*STRINGREF_STR*/$COMMA_SPACE);
      }
      OS.$out(/*KEEP_STR*/") ");
    }
    type$ptr<Expr>/*alignments_iterator*/ NI = $tryClone(alignments_begin());
    for (Expr /*P*/ E : aligneds()) {
      OS.$out(/*KEEP_STR*/"aligned(");
      E.printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
      if ((NI.$star() != null)) {
        OS.$out(/*KEEP_STR*/": ");
        (NI.$star()).printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
      }
      OS.$out(/*KEEP_STR*/") ");
      NI.$preInc();
    }
    type$ptr<Expr>/*steps_iterator*/ I = $tryClone(steps_begin());
    uint$ptr/*uint P*/ MI = $tryClone(modifiers_begin());
    for (Expr /*P*/ E : linears()) {
      OS.$out(/*KEEP_STR*/"linear(");
      if (MI.$star() != OpenMPLinearClauseKind.OMPC_LINEAR_unknown.getValue()) {
        OS.$out(getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_linear, MI.$star())).$out(/*KEEP_STR*/$LPAREN);
      }
      E.printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
      if (MI.$star() != OpenMPLinearClauseKind.OMPC_LINEAR_unknown.getValue()) {
        OS.$out(/*KEEP_STR*/$RPAREN);
      }
      if ((I.$star() != null)) {
        OS.$out(/*KEEP_STR*/": ");
        (I.$star()).printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
      }
      OS.$out(/*KEEP_STR*/") ");
      I.$preInc();
      MI.$preInc();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareSimdDeclAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4462,
   FQN="clang::OMPDeclareSimdDeclAttr::classof", NM="_ZN5clang22OMPDeclareSimdDeclAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22OMPDeclareSimdDeclAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.OMPDeclareSimdDecl;
  }

  
  @Override public String toString() {
    return "" + "branchState=" + branchState // NOI18N
              + ", simdlen=" + simdlen // NOI18N
              + ", uniforms_Size=" + uniforms_Size // NOI18N
              + ", uniforms_=" + uniforms_ // NOI18N
              + ", aligneds_Size=" + aligneds_Size // NOI18N
              + ", aligneds_=" + aligneds_ // NOI18N
              + ", alignments_Size=" + alignments_Size // NOI18N
              + ", alignments_=" + alignments_ // NOI18N
              + ", linears_Size=" + linears_Size // NOI18N
              + ", linears_=" + linears_ // NOI18N
              + ", modifiers_Size=" + modifiers_Size // NOI18N
              + ", modifiers_=" + modifiers_ // NOI18N
              + ", steps_Size=" + steps_Size // NOI18N
              + ", steps_=" + steps_ // NOI18N
              + super.toString(); // NOI18N
  }
}
