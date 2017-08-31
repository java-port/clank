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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
/// \brief OpenMP 4.0 [2.4, Array Sections].
/// To specify an array section in an OpenMP construct, array subscript
/// expressions are extended with the following syntax:
/// \code
/// [ lower-bound : length ]
/// [ lower-bound : ]
/// [ : length ]
/// [ : ]
/// \endcode
/// The array section must be a subset of the original array.
/// Array sections are allowed on multidimensional arrays. Base language array
/// subscript expressions can be used to specify length-one dimensions of
/// multidimensional array sections.
/// The lower-bound and length are integral type expressions. When evaluated
/// they represent a set of integer values as follows:
/// \code
/// { lower-bound, lower-bound + 1, lower-bound + 2,... , lower-bound + length -
/// 1 }
/// \endcode
/// The lower-bound and length must evaluate to non-negative integers.
/// When the size of the array dimension is not known, the length must be
/// specified explicitly.
/// When the length is absent, it defaults to the size of the array dimension
/// minus the lower-bound.
/// When the lower-bound is absent it defaults to 0.
//<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 45,
 FQN="clang::OMPArraySectionExpr", NM="_ZN5clang19OMPArraySectionExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19OMPArraySectionExprE")
//</editor-fold>
public class OMPArraySectionExpr extends /*public*/ Expr {
  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 46,
   FQN="clang::OMPArraySectionExpr::(anonymous)", NM="_ZN5clang19OMPArraySectionExprE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19OMPArraySectionExprE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    BASE(0),
    LOWER_BOUND(BASE.getValue() + 1),
    LENGTH(LOWER_BOUND.getValue() + 1),
    END_EXPR(LENGTH.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
    //</editor-fold>
  };
  private Stmt /*P*/ SubExprs[/*3*/] = new Stmt /*P*/  [3];
  private SourceLocation ColonLoc;
  private SourceLocation RBracketLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::OMPArraySectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 52,
   FQN="clang::OMPArraySectionExpr::OMPArraySectionExpr", NM="_ZN5clang19OMPArraySectionExprC1EPNS_4ExprES2_S2_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19OMPArraySectionExprC1EPNS_4ExprES2_S2_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationES6_")
  //</editor-fold>
  public OMPArraySectionExpr(Expr /*P*/ Base, Expr /*P*/ LowerBound, Expr /*P*/ Length, QualType Type, 
      ExprValueKind VK, ExprObjectKind OK, 
      SourceLocation ColonLoc, SourceLocation RBracketLoc) {
    // : Expr(OMPArraySectionExprClass, Type, VK, OK, Base->isTypeDependent() || (LowerBound && LowerBound->isTypeDependent()) || (Length && Length->isTypeDependent()), Base->isValueDependent() || (LowerBound && LowerBound->isValueDependent()) || (Length && Length->isValueDependent()), Base->isInstantiationDependent() || (LowerBound && LowerBound->isInstantiationDependent()) || (Length && Length->isInstantiationDependent()), Base->containsUnexpandedParameterPack() || (LowerBound && LowerBound->containsUnexpandedParameterPack()) || (Length && Length->containsUnexpandedParameterPack())), ColonLoc(ColonLoc), RBracketLoc(RBracketLoc) 
    //START JInit
    super(StmtClass.OMPArraySectionExprClass, new QualType(Type), VK, OK, 
        Base.isTypeDependent()
           || ((LowerBound != null) && LowerBound.isTypeDependent())
           || ((Length != null) && Length.isTypeDependent()), 
        Base.isValueDependent()
           || ((LowerBound != null) && LowerBound.isValueDependent())
           || ((Length != null) && Length.isValueDependent()), 
        Base.isInstantiationDependent()
           || ((LowerBound != null) && LowerBound.isInstantiationDependent())
           || ((Length != null) && Length.isInstantiationDependent()), 
        Base.containsUnexpandedParameterPack()
           || ((LowerBound != null) && LowerBound.containsUnexpandedParameterPack())
           || ((Length != null) && Length.containsUnexpandedParameterPack()));
    this.ColonLoc = new SourceLocation(ColonLoc);
    this.RBracketLoc = new SourceLocation(RBracketLoc);
    //END JInit
    SubExprs[Unnamed_enum.BASE.getValue()] = Base;
    SubExprs[Unnamed_enum.LOWER_BOUND.getValue()] = LowerBound;
    SubExprs[Unnamed_enum.LENGTH.getValue()] = Length;
  }

  
  /// \brief Create an empty array section expression.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::OMPArraySectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 76,
   FQN="clang::OMPArraySectionExpr::OMPArraySectionExpr", NM="_ZN5clang19OMPArraySectionExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19OMPArraySectionExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ OMPArraySectionExpr(EmptyShell Shell) {
    // : Expr(OMPArraySectionExprClass, Shell), ColonLoc(), RBracketLoc() 
    //START JInit
    super(StmtClass.OMPArraySectionExprClass, new EmptyShell(Shell));
    this.ColonLoc = new SourceLocation();
    this.RBracketLoc = new SourceLocation();
    //END JInit
  }

  
  /// An array section can be written only as Base[LowerBound:Length].
  
  /// \brief Get base of the array section.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 82,
   FQN="clang::OMPArraySectionExpr::getBase", NM="_ZN5clang19OMPArraySectionExpr7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19OMPArraySectionExpr7getBaseEv")
  //</editor-fold>
  public Expr /*P*/ getBase() {
    return cast_Expr(SubExprs[Unnamed_enum.BASE.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 83,
   FQN="clang::OMPArraySectionExpr::getBase", NM="_ZNK5clang19OMPArraySectionExpr7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19OMPArraySectionExpr7getBaseEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getBase$Const() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.BASE.getValue()]);
  }

  /// \brief Set base of the array section.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::setBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 85,
   FQN="clang::OMPArraySectionExpr::setBase", NM="_ZN5clang19OMPArraySectionExpr7setBaseEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19OMPArraySectionExpr7setBaseEPNS_4ExprE")
  //</editor-fold>
  public void setBase(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.BASE.getValue()] = E;
  }

  
  /// \brief Return original type of the base expression for array section.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::getBaseOriginalType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3887,
   FQN="clang::OMPArraySectionExpr::getBaseOriginalType", NM="_ZN5clang19OMPArraySectionExpr19getBaseOriginalTypeEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19OMPArraySectionExpr19getBaseOriginalTypeEPKNS_4ExprE")
  //</editor-fold>
  public static QualType getBaseOriginalType(/*const*/ Expr /*P*/ Base) {
    /*uint*/int ArraySectionCount = 0;
    {
      /*const*/ OMPArraySectionExpr /*P*/ OASE;
      while (((/*P*/ OASE = dyn_cast_OMPArraySectionExpr(Base.IgnoreParens$Const())) != null)) {
        Base = OASE.getBase$Const();
        ++ArraySectionCount;
      }
    }
    {
      /*const*/ ArraySubscriptExpr /*P*/ ASE;
      while (((/*P*/ ASE = dyn_cast_ArraySubscriptExpr(Base.IgnoreParenImpCasts$Const())) != null)) {
        Base = ASE.getBase$Const();
        ++ArraySectionCount;
      }
    }
    Base = Base.IgnoreParenImpCasts$Const();
    QualType OriginalTy = Base.getType();
    {
      /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Base);
      if ((DRE != null)) {
        {
          /*const*/ ParmVarDecl /*P*/ PVD = dyn_cast_ParmVarDecl(DRE.getDecl$Const());
          if ((PVD != null)) {
            OriginalTy.$assignMove(PVD.getOriginalType().getNonReferenceType());
          }
        }
      }
    }
    
    for (/*uint*/int Cnt = 0; $less_uint(Cnt, ArraySectionCount); ++Cnt) {
      if (OriginalTy.$arrow().isAnyPointerType()) {
        OriginalTy.$assignMove(OriginalTy.$arrow().getPointeeType());
      } else {
        assert (OriginalTy.$arrow().isArrayType());
        OriginalTy.$assignMove(OriginalTy.$arrow().castAsArrayTypeUnsafe().getElementType());
      }
    }
    return OriginalTy;
  }

  
  /// \brief Get lower bound of array section.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::getLowerBound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 91,
   FQN="clang::OMPArraySectionExpr::getLowerBound", NM="_ZN5clang19OMPArraySectionExpr13getLowerBoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19OMPArraySectionExpr13getLowerBoundEv")
  //</editor-fold>
  public Expr /*P*/ getLowerBound() {
    return cast_or_null_Expr(SubExprs[Unnamed_enum.LOWER_BOUND.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::getLowerBound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 92,
   FQN="clang::OMPArraySectionExpr::getLowerBound", NM="_ZNK5clang19OMPArraySectionExpr13getLowerBoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19OMPArraySectionExpr13getLowerBoundEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getLowerBound$Const() /*const*/ {
    return cast_or_null_Expr(SubExprs[Unnamed_enum.LOWER_BOUND.getValue()]);
  }

  /// \brief Set lower bound of the array section.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::setLowerBound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 96,
   FQN="clang::OMPArraySectionExpr::setLowerBound", NM="_ZN5clang19OMPArraySectionExpr13setLowerBoundEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19OMPArraySectionExpr13setLowerBoundEPNS_4ExprE")
  //</editor-fold>
  public void setLowerBound(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.LOWER_BOUND.getValue()] = E;
  }

  
  /// \brief Get length of array section.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::getLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 99,
   FQN="clang::OMPArraySectionExpr::getLength", NM="_ZN5clang19OMPArraySectionExpr9getLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19OMPArraySectionExpr9getLengthEv")
  //</editor-fold>
  public Expr /*P*/ getLength() {
    return cast_or_null_Expr(SubExprs[Unnamed_enum.LENGTH.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::getLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 100,
   FQN="clang::OMPArraySectionExpr::getLength", NM="_ZNK5clang19OMPArraySectionExpr9getLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19OMPArraySectionExpr9getLengthEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getLength$Const() /*const*/ {
    return cast_or_null_Expr(SubExprs[Unnamed_enum.LENGTH.getValue()]);
  }

  /// \brief Set length of the array section.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::setLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 102,
   FQN="clang::OMPArraySectionExpr::setLength", NM="_ZN5clang19OMPArraySectionExpr9setLengthEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19OMPArraySectionExpr9setLengthEPNS_4ExprE")
  //</editor-fold>
  public void setLength(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.LENGTH.getValue()] = E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 104,
   FQN="clang::OMPArraySectionExpr::getLocStart", NM="_ZNK5clang19OMPArraySectionExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19OMPArraySectionExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getBase$Const().getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 107,
   FQN="clang::OMPArraySectionExpr::getLocEnd", NM="_ZNK5clang19OMPArraySectionExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19OMPArraySectionExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RBracketLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::getColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 109,
   FQN="clang::OMPArraySectionExpr::getColonLoc", NM="_ZNK5clang19OMPArraySectionExpr11getColonLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19OMPArraySectionExpr11getColonLocEv")
  //</editor-fold>
  public SourceLocation getColonLoc() /*const*/ {
    return new SourceLocation(ColonLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::setColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 110,
   FQN="clang::OMPArraySectionExpr::setColonLoc", NM="_ZN5clang19OMPArraySectionExpr11setColonLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19OMPArraySectionExpr11setColonLocENS_14SourceLocationE")
  //</editor-fold>
  public void setColonLoc(SourceLocation L) {
    ColonLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::getRBracketLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 112,
   FQN="clang::OMPArraySectionExpr::getRBracketLoc", NM="_ZNK5clang19OMPArraySectionExpr14getRBracketLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19OMPArraySectionExpr14getRBracketLocEv")
  //</editor-fold>
  public SourceLocation getRBracketLoc() /*const*/ {
    return new SourceLocation(RBracketLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::setRBracketLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 113,
   FQN="clang::OMPArraySectionExpr::setRBracketLoc", NM="_ZN5clang19OMPArraySectionExpr14setRBracketLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19OMPArraySectionExpr14setRBracketLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRBracketLoc(SourceLocation L) {
    RBracketLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::getExprLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 115,
   FQN="clang::OMPArraySectionExpr::getExprLoc", NM="_ZNK5clang19OMPArraySectionExpr10getExprLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19OMPArraySectionExpr10getExprLocEv")
  //</editor-fold>
  public SourceLocation getExprLoc() /*const*//* __attribute__((pure))*/ {
    return getBase$Const().getExprLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 119,
   FQN="clang::OMPArraySectionExpr::classof", NM="_ZN5clang19OMPArraySectionExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19OMPArraySectionExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.OMPArraySectionExprClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPArraySectionExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprOpenMP.h", line = 123,
   FQN="clang::OMPArraySectionExpr::children", NM="_ZN5clang19OMPArraySectionExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19OMPArraySectionExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(SubExprs)).$add(Unnamed_enum.BASE.getValue())), new StmtIterator(create_type$ptr($AddrOf(SubExprs)).$add(Unnamed_enum.END_EXPR.getValue())));
  }

  
  @Override public String toString() {
    return "" + "SubExprs=" + SubExprs // NOI18N
              + ", ColonLoc=" + ColonLoc // NOI18N
              + ", RBracketLoc=" + RBracketLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
