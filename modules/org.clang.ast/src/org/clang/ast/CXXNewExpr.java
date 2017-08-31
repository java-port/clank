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
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// \brief Represents a new-expression for memory allocation and constructor
/// calls, e.g: "new CXXNewExpr(foo)".
//<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1804,
 FQN="clang::CXXNewExpr", NM="_ZN5clang10CXXNewExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExprE")
//</editor-fold>
public class CXXNewExpr extends /*public*/ Expr {
  /// Contains an optional array size expression, an optional initialization
  /// expression, and any number of optional placement arguments, in that order.
  private type$ptr<Stmt /*P*/ /*P*/> SubExprs;
  /// \brief Points to the allocation function used.
  private FunctionDecl /*P*/ OperatorNew;
  /// \brief Points to the deallocation function used in case of error. May be
  /// null.
  private FunctionDecl /*P*/ OperatorDelete;
  
  /// \brief The allocated type-source information, as written in the source.
  /*friend*/public TypeSourceInfo /*P*/ AllocatedTypeInfo;
  
  /// \brief If the allocated type was expressed as a parenthesized type-id,
  /// the source range covering the parenthesized type-id.
  /*friend*/public SourceRange TypeIdParens;
  
  /// \brief Range of the entire new expression.
  /*friend*/public SourceRange Range;
  
  /// \brief Source-range of a paren-delimited initializer.
  /*friend*/public SourceRange DirectInitRange;
  
  /// Was the usage ::new, i.e. is the global new to be used?
  /*friend*/public /*JBIT unsigned int*/ boolean GlobalNew /*: 1*/;
  /// Do we allocate an array? If so, the first SubExpr is the size expression.
  private /*JBIT unsigned int*/ boolean Array /*: 1*/;
  /// If this is an array allocation, does the usual deallocation
  /// function for the allocated type want to know the allocated size?
  /*friend*/public /*JBIT unsigned int*/ boolean UsualArrayDeleteWantsSize /*: 1*/;
  /// The number of placement new arguments.
  private /*JCHAR unsigned int*/ char NumPlacementArgs /*: 13*/;
  /// What kind of initializer do we have? Could be none, parens, or braces.
  /// In storage, we distinguish between "none, and no initializer expr", and
  /// "none, but an implicit initializer expr".
  /*friend*/public /*JBYTE unsigned int*/ byte StoredInitializationStyle /*: 2*/;
  
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::InitializationStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1844,
   FQN="clang::CXXNewExpr::InitializationStyle", NM="_ZN5clang10CXXNewExpr19InitializationStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExpr19InitializationStyleE")
  //</editor-fold>
  public enum InitializationStyle implements Native.ComparableLower {
    NoInit(0), ///< New-expression has no initializer as written.
    CallInit(NoInit.getValue() + 1), ///< New-expression has a C++98 paren-delimited initializer.
    ListInit(CallInit.getValue() + 1); ///< New-expression has a C++11 list-initializer.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static InitializationStyle valueOf(int val) {
      InitializationStyle out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final InitializationStyle[] VALUES;
      private static final InitializationStyle[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (InitializationStyle kind : InitializationStyle.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new InitializationStyle[min < 0 ? (1-min) : 0];
        VALUES = new InitializationStyle[max >= 0 ? (1+max) : 0];
        for (InitializationStyle kind : InitializationStyle.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private InitializationStyle(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((InitializationStyle)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((InitializationStyle)obj).value);}
    //</editor-fold>
  };
  
  
  // CXXNewExpr
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::CXXNewExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 63,
   FQN="clang::CXXNewExpr::CXXNewExpr", NM="_ZN5clang10CXXNewExprC1ERKNS_10ASTContextEbPNS_12FunctionDeclES5_bN4llvm8ArrayRefIPNS_4ExprEEENS_11SourceRangeES9_NS0_19InitializationStyleES9_NS_8QualTypeEPNS_14TypeSourceInfoESB_SB_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExprC1ERKNS_10ASTContextEbPNS_12FunctionDeclES5_bN4llvm8ArrayRefIPNS_4ExprEEENS_11SourceRangeES9_NS0_19InitializationStyleES9_NS_8QualTypeEPNS_14TypeSourceInfoESB_SB_")
  //</editor-fold>
  public CXXNewExpr(final /*const*/ ASTContext /*&*/ C, boolean globalNew, 
      FunctionDecl /*P*/ operatorNew, FunctionDecl /*P*/ operatorDelete, 
      boolean usualArrayDeleteWantsSize, 
      ArrayRef<Expr /*P*/ > placementArgs, 
      SourceRange typeIdParens, Expr /*P*/ arraySize, 
      InitializationStyle initializationStyle, 
      Expr /*P*/ initializer, QualType ty, 
      TypeSourceInfo /*P*/ allocatedTypeInfo, 
      SourceRange Range, SourceRange directInitRange) {
    // : Expr(CXXNewExprClass, ty, VK_RValue, OK_Ordinary, ty->isDependentType(), ty->isDependentType(), ty->isInstantiationDependentType(), ty->containsUnexpandedParameterPack()), SubExprs(null), OperatorNew(operatorNew), OperatorDelete(operatorDelete), AllocatedTypeInfo(allocatedTypeInfo), TypeIdParens(typeIdParens), Range(Range), DirectInitRange(directInitRange), GlobalNew(globalNew), UsualArrayDeleteWantsSize(usualArrayDeleteWantsSize) 
    //START JInit
    super(StmtClass.CXXNewExprClass, new QualType(ty), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        ty.$arrow().isDependentType(), ty.$arrow().isDependentType(), 
        ty.$arrow().isInstantiationDependentType(), 
        ty.$arrow().containsUnexpandedParameterPack());
    this.SubExprs = null;
    this.OperatorNew = operatorNew;
    this.OperatorDelete = operatorDelete;
    this.AllocatedTypeInfo = allocatedTypeInfo;
    this.TypeIdParens = new SourceRange(typeIdParens);
    this.Range = new SourceRange(Range);
    this.DirectInitRange = new SourceRange(directInitRange);
    this.GlobalNew = globalNew;
    this.UsualArrayDeleteWantsSize = usualArrayDeleteWantsSize;
    //END JInit
    assert ((initializer != null || initializationStyle == InitializationStyle.NoInit)) : "Only NoInit can have no initializer.";
    StoredInitializationStyle = $uint2uint_2bits((initializer != null) ? initializationStyle.getValue() + 1 : 0);
    AllocateArgsArray(C, arraySize != (Expr /*P*/ )null, placementArgs.size(), 
        initializer != (Expr /*P*/ )null);
    /*uint*/int i = 0;
    if (Array) {
      if (arraySize.isInstantiationDependent()) {
        Unnamed_field.ExprBits.InstantiationDependent = true;
      }
      if (arraySize.containsUnexpandedParameterPack()) {
        Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
      }
      
      SubExprs.$set(i++, arraySize);
    }
    if ((initializer != null)) {
      if (initializer.isInstantiationDependent()) {
        Unnamed_field.ExprBits.InstantiationDependent = true;
      }
      if (initializer.containsUnexpandedParameterPack()) {
        Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
      }
      
      SubExprs.$set(i++, initializer);
    }
    
    for (/*uint*/int j = 0; j != placementArgs.size(); ++j) {
      if (placementArgs.$at(j).isInstantiationDependent()) {
        Unnamed_field.ExprBits.InstantiationDependent = true;
      }
      if (placementArgs.$at(j).containsUnexpandedParameterPack()) {
        Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
      }
      
      SubExprs.$set(i++, placementArgs.$at(j));
    }
    switch (getInitializationStyle()) {
     case CallInit:
      this.Range.setEnd(DirectInitRange.getEnd());
      break;
     case ListInit:
      this.Range.setEnd(getInitializer().getSourceRange().getEnd());
      break;
     default:
      if (TypeIdParens.isValid()) {
        this.Range.setEnd(TypeIdParens.getEnd());
      }
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::CXXNewExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1857,
   FQN="clang::CXXNewExpr::CXXNewExpr", NM="_ZN5clang10CXXNewExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ CXXNewExpr(EmptyShell Shell) {
    // : Expr(CXXNewExprClass, Shell), SubExprs(null), TypeIdParens(), Range(), DirectInitRange() 
    //START JInit
    super(StmtClass.CXXNewExprClass, new EmptyShell(Shell));
    this.SubExprs = null;
    this.TypeIdParens = new SourceRange();
    this.Range = new SourceRange();
    this.DirectInitRange = new SourceRange();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::AllocateArgsArray">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 127,
   FQN="clang::CXXNewExpr::AllocateArgsArray", NM="_ZN5clang10CXXNewExpr17AllocateArgsArrayERKNS_10ASTContextEbjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExpr17AllocateArgsArrayERKNS_10ASTContextEbjb")
  //</editor-fold>
  public void AllocateArgsArray(final /*const*/ ASTContext /*&*/ C, boolean isArray, 
                   /*uint*/int numPlaceArgs, boolean hasInitializer) {
    assert ($eq_ptr(SubExprs, null)) : "SubExprs already allocated";
    Array = isArray;
    NumPlacementArgs = $uint2uint_13bits(numPlaceArgs);
    
    /*uint*/int TotalSize = $bool2uint(Array) + $bool2uint(hasInitializer) + NumPlacementArgs;
    SubExprs = create_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new Stmt /*P*/ [TotalSize]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getAllocatedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1863,
   FQN="clang::CXXNewExpr::getAllocatedType", NM="_ZNK5clang10CXXNewExpr16getAllocatedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr16getAllocatedTypeEv")
  //</editor-fold>
  public QualType getAllocatedType() /*const*/ {
    assert (getType().$arrow().isPointerType());
    return getType().$arrow().getAs(PointerType.class).getPointeeType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getAllocatedTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1868,
   FQN="clang::CXXNewExpr::getAllocatedTypeSourceInfo", NM="_ZNK5clang10CXXNewExpr26getAllocatedTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr26getAllocatedTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getAllocatedTypeSourceInfo() /*const*/ {
    return AllocatedTypeInfo;
  }

  
  /// \brief True if the allocation result needs to be null-checked.
  ///
  /// C++11 [expr.new]p13:
  ///   If the allocation function returns null, initialization shall
  ///   not be done, the deallocation function shall not be called,
  ///   and the value of the new-expression shall be null.
  ///
  /// C++ DR1748:
  ///   If the allocation function is a reserved placement allocation
  ///   function that returns null, the behavior is undefined.
  ///
  /// An allocation function is not allowed to return null unless it
  /// has a non-throwing exception-specification.  The '03 rule is
  /// identical except that the definition of a non-throwing
  /// exception specification is just "is it throw()?".
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::shouldNullCheckAllocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 137,
   FQN="clang::CXXNewExpr::shouldNullCheckAllocation", NM="_ZNK5clang10CXXNewExpr25shouldNullCheckAllocationERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr25shouldNullCheckAllocationERKNS_10ASTContextE")
  //</editor-fold>
  public boolean shouldNullCheckAllocation(final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    return getOperatorNew().getType().$arrow().castAs(FunctionProtoType.class).isNothrow(Ctx)
       && !getOperatorNew().isReservedGlobalPlacementOperator();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getOperatorNew">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1889,
   FQN="clang::CXXNewExpr::getOperatorNew", NM="_ZNK5clang10CXXNewExpr14getOperatorNewEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr14getOperatorNewEv")
  //</editor-fold>
  public FunctionDecl /*P*/ getOperatorNew() /*const*/ {
    return OperatorNew;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::setOperatorNew">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1890,
   FQN="clang::CXXNewExpr::setOperatorNew", NM="_ZN5clang10CXXNewExpr14setOperatorNewEPNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExpr14setOperatorNewEPNS_12FunctionDeclE")
  //</editor-fold>
  public void setOperatorNew(FunctionDecl /*P*/ D) {
    OperatorNew = D;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getOperatorDelete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1891,
   FQN="clang::CXXNewExpr::getOperatorDelete", NM="_ZNK5clang10CXXNewExpr17getOperatorDeleteEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr17getOperatorDeleteEv")
  //</editor-fold>
  public FunctionDecl /*P*/ getOperatorDelete() /*const*/ {
    return OperatorDelete;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::setOperatorDelete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1892,
   FQN="clang::CXXNewExpr::setOperatorDelete", NM="_ZN5clang10CXXNewExpr17setOperatorDeleteEPNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExpr17setOperatorDeleteEPNS_12FunctionDeclE")
  //</editor-fold>
  public void setOperatorDelete(FunctionDecl /*P*/ D) {
    OperatorDelete = D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::isArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1894,
   FQN="clang::CXXNewExpr::isArray", NM="_ZNK5clang10CXXNewExpr7isArrayEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr7isArrayEv")
  //</editor-fold>
  public boolean isArray() /*const*/ {
    return Array;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getArraySize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1895,
   FQN="clang::CXXNewExpr::getArraySize", NM="_ZN5clang10CXXNewExpr12getArraySizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExpr12getArraySizeEv")
  //</editor-fold>
  public Expr /*P*/ getArraySize() {
    return Array ? cast_Expr(SubExprs.$at(0)) : null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getArraySize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1898,
   FQN="clang::CXXNewExpr::getArraySize", NM="_ZNK5clang10CXXNewExpr12getArraySizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr12getArraySizeEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getArraySize$Const() /*const*/ {
    return Array ? cast_Expr(SubExprs.$at(0)) : null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getNumPlacementArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1902,
   FQN="clang::CXXNewExpr::getNumPlacementArgs", NM="_ZNK5clang10CXXNewExpr19getNumPlacementArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr19getNumPlacementArgsEv")
  //</editor-fold>
  public /*uint*/int getNumPlacementArgs() /*const*/ {
    return NumPlacementArgs;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getPlacementArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1903,
   FQN="clang::CXXNewExpr::getPlacementArgs", NM="_ZN5clang10CXXNewExpr16getPlacementArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExpr16getPlacementArgsEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*P*/> getPlacementArgs() {
    return ((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, SubExprs.$add($bool2uint(Array)).$add((hasInitializer() ? 1 : 0))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getPlacementArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1907,
   FQN="clang::CXXNewExpr::getPlacementArg", NM="_ZN5clang10CXXNewExpr15getPlacementArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExpr15getPlacementArgEj")
  //</editor-fold>
  public Expr /*P*/ getPlacementArg(/*uint*/int i) {
    assert ($less_uint(i, NumPlacementArgs)) : "Index out of range";
    return getPlacementArgs().$at(i);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getPlacementArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1911,
   FQN="clang::CXXNewExpr::getPlacementArg", NM="_ZNK5clang10CXXNewExpr15getPlacementArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr15getPlacementArgEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getPlacementArg$Const(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, NumPlacementArgs)) : "Index out of range";
    return ((/*const_cast*/CXXNewExpr /*P*/ )(this)).getPlacementArg(i);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::isParenTypeId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1916,
   FQN="clang::CXXNewExpr::isParenTypeId", NM="_ZNK5clang10CXXNewExpr13isParenTypeIdEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr13isParenTypeIdEv")
  //</editor-fold>
  public boolean isParenTypeId() /*const*/ {
    return TypeIdParens.isValid();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getTypeIdParens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1917,
   FQN="clang::CXXNewExpr::getTypeIdParens", NM="_ZNK5clang10CXXNewExpr15getTypeIdParensEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr15getTypeIdParensEv")
  //</editor-fold>
  public SourceRange getTypeIdParens() /*const*/ {
    return new SourceRange(TypeIdParens);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::isGlobalNew">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1919,
   FQN="clang::CXXNewExpr::isGlobalNew", NM="_ZNK5clang10CXXNewExpr11isGlobalNewEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr11isGlobalNewEv")
  //</editor-fold>
  public boolean isGlobalNew() /*const*/ {
    return GlobalNew;
  }

  
  /// \brief Whether this new-expression has any initializer at all.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::hasInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1922,
   FQN="clang::CXXNewExpr::hasInitializer", NM="_ZNK5clang10CXXNewExpr14hasInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr14hasInitializerEv")
  //</editor-fold>
  public boolean hasInitializer() /*const*/ {
    return StoredInitializationStyle > $int2uint_2bits(0);
  }

  
  /// \brief The kind of initializer this new-expression has.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getInitializationStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1925,
   FQN="clang::CXXNewExpr::getInitializationStyle", NM="_ZNK5clang10CXXNewExpr22getInitializationStyleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr22getInitializationStyleEv")
  //</editor-fold>
  public InitializationStyle getInitializationStyle() /*const*/ {
    if (StoredInitializationStyle == $int2uint_2bits(0)) {
      return InitializationStyle.NoInit;
    }
    return /*static_cast*/InitializationStyle.valueOf(StoredInitializationStyle - $int2uint_2bits(1));
  }

  
  /// \brief The initializer of this new-expression.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getInitializer">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1932,
   FQN="clang::CXXNewExpr::getInitializer", NM="_ZN5clang10CXXNewExpr14getInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExpr14getInitializerEv")
  //</editor-fold>
  public Expr /*P*/ getInitializer() {
    return hasInitializer() ? cast_Expr(SubExprs.$at($bool2uint(Array))) : null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getInitializer">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1935,
   FQN="clang::CXXNewExpr::getInitializer", NM="_ZNK5clang10CXXNewExpr14getInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr14getInitializerEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getInitializer$Const() /*const*/ {
    return hasInitializer() ? cast_Expr(SubExprs.$at($bool2uint(Array))) : null;
  }

  
  /// \brief Returns the CXXConstructExpr from this new-expression, or null.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1940,
   FQN="clang::CXXNewExpr::getConstructExpr", NM="_ZNK5clang10CXXNewExpr16getConstructExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr16getConstructExprEv")
  //</editor-fold>
  public /*const*/ CXXConstructExpr /*P*/ getConstructExpr() /*const*/ {
    return dyn_cast_or_null_CXXConstructExpr(getInitializer$Const());
  }

  
  /// Answers whether the usual array deallocation function for the
  /// allocated type expects the size of the allocation as a
  /// parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::doesUsualArrayDeleteWantSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1947,
   FQN="clang::CXXNewExpr::doesUsualArrayDeleteWantSize", NM="_ZNK5clang10CXXNewExpr28doesUsualArrayDeleteWantSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr28doesUsualArrayDeleteWantSizeEv")
  //</editor-fold>
  public boolean doesUsualArrayDeleteWantSize() /*const*/ {
    return UsualArrayDeleteWantsSize;
  }

  
  /*typedef ExprIterator arg_iterator*/
//  public final class arg_iterator extends ExprIterator{ };
  /*typedef ConstExprIterator const_arg_iterator*/
//  public final class const_arg_iterator extends ConstExprIterator{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::placement_arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1954,
   FQN="clang::CXXNewExpr::placement_arguments", NM="_ZN5clang10CXXNewExpr19placement_argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExpr19placement_argumentsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > placement_arguments() {
    return llvm.make_range(placement_arg_begin(), placement_arg_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::placement_arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1958,
   FQN="clang::CXXNewExpr::placement_arguments", NM="_ZNK5clang10CXXNewExpr19placement_argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr19placement_argumentsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> placement_arguments$Const() /*const*/ {
    return llvm.make_range(placement_arg_begin$Const(), placement_arg_end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::placement_arg_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1962,
   FQN="clang::CXXNewExpr::placement_arg_begin", NM="_ZN5clang10CXXNewExpr19placement_arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExpr19placement_arg_beginEv")
  //</editor-fold>
  public ExprIterator placement_arg_begin() {
    return new ExprIterator(SubExprs.$add($bool2uint(Array)).$add((hasInitializer() ? 1 : 0)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::placement_arg_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1965,
   FQN="clang::CXXNewExpr::placement_arg_end", NM="_ZN5clang10CXXNewExpr17placement_arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExpr17placement_arg_endEv")
  //</editor-fold>
  public ExprIterator placement_arg_end() {
    return new ExprIterator(SubExprs.$add($bool2uint(Array)).$add((hasInitializer() ? 1 : 0)).$add(getNumPlacementArgs()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::placement_arg_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1968,
   FQN="clang::CXXNewExpr::placement_arg_begin", NM="_ZNK5clang10CXXNewExpr19placement_arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr19placement_arg_beginEv")
  //</editor-fold>
  public ConstExprIterator placement_arg_begin$Const() /*const*/ {
    return new ConstExprIterator(SubExprs.$add($bool2uint(Array)).$add((hasInitializer() ? 1 : 0)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::placement_arg_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1971,
   FQN="clang::CXXNewExpr::placement_arg_end", NM="_ZNK5clang10CXXNewExpr17placement_arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr17placement_arg_endEv")
  //</editor-fold>
  public ConstExprIterator placement_arg_end$Const() /*const*/ {
    return new ConstExprIterator(SubExprs.$add($bool2uint(Array)).$add((hasInitializer() ? 1 : 0)).$add(getNumPlacementArgs()));
  }

  
  /*typedef Stmt **raw_arg_iterator*/
//  public final class raw_arg_iterator extends type$ptr<Stmt /*P*/ /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::raw_arg_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1976,
   FQN="clang::CXXNewExpr::raw_arg_begin", NM="_ZN5clang10CXXNewExpr13raw_arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExpr13raw_arg_beginEv")
  //</editor-fold>
  public type$ptr<Stmt>/*raw_arg_iterator*/ raw_arg_begin() {
    return SubExprs;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::raw_arg_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1977,
   FQN="clang::CXXNewExpr::raw_arg_end", NM="_ZN5clang10CXXNewExpr11raw_arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExpr11raw_arg_endEv")
  //</editor-fold>
  public type$ptr<Stmt>/*raw_arg_iterator*/ raw_arg_end() {
    return SubExprs.$add($bool2uint(Array)).$add((hasInitializer() ? 1 : 0)).$add(getNumPlacementArgs());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::raw_arg_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1980,
   FQN="clang::CXXNewExpr::raw_arg_begin", NM="_ZNK5clang10CXXNewExpr13raw_arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr13raw_arg_beginEv")
  //</editor-fold>
  public ConstExprIterator raw_arg_begin$Const() /*const*/ {
    return new ConstExprIterator(SubExprs);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::raw_arg_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1981,
   FQN="clang::CXXNewExpr::raw_arg_end", NM="_ZNK5clang10CXXNewExpr11raw_arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr11raw_arg_endEv")
  //</editor-fold>
  public ConstExprIterator raw_arg_end$Const() /*const*/ {
    return new ConstExprIterator(SubExprs.$add($bool2uint(Array)).$add((hasInitializer() ? 1 : 0)).$add(getNumPlacementArgs()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getStartLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1985,
   FQN="clang::CXXNewExpr::getStartLoc", NM="_ZNK5clang10CXXNewExpr11getStartLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr11getStartLocEv")
  //</editor-fold>
  public SourceLocation getStartLoc() /*const*/ {
    return Range.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1986,
   FQN="clang::CXXNewExpr::getEndLoc", NM="_ZNK5clang10CXXNewExpr9getEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr9getEndLocEv")
  //</editor-fold>
  public SourceLocation getEndLoc() /*const*/ {
    return Range.getEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getDirectInitRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1988,
   FQN="clang::CXXNewExpr::getDirectInitRange", NM="_ZNK5clang10CXXNewExpr18getDirectInitRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr18getDirectInitRangeEv")
  //</editor-fold>
  public SourceRange getDirectInitRange() /*const*/ {
    return new SourceRange(DirectInitRange);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1990,
   FQN="clang::CXXNewExpr::getSourceRange", NM="_ZNK5clang10CXXNewExpr14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(Range);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1993,
   FQN="clang::CXXNewExpr::getLocStart", NM="_ZNK5clang10CXXNewExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getStartLoc();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1994,
   FQN="clang::CXXNewExpr::getLocEnd", NM="_ZNK5clang10CXXNewExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10CXXNewExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getEndLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1996,
   FQN="clang::CXXNewExpr::classof", NM="_ZN5clang10CXXNewExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXNewExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNewExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2001,
   FQN="clang::CXXNewExpr::children", NM="_ZN5clang10CXXNewExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10CXXNewExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(raw_arg_begin()), new StmtIterator(raw_arg_end()));
  }

  
  @Override public String toString() {
    return "" + "SubExprs=" + SubExprs // NOI18N
              + ", OperatorNew=" + OperatorNew // NOI18N
              + ", OperatorDelete=" + OperatorDelete // NOI18N
              + ", AllocatedTypeInfo=" + AllocatedTypeInfo // NOI18N
              + ", TypeIdParens=" + TypeIdParens // NOI18N
              + ", Range=" + Range // NOI18N
              + ", DirectInitRange=" + DirectInitRange // NOI18N
              + ", GlobalNew=" + GlobalNew // NOI18N
              + ", Array=" + Array // NOI18N
              + ", UsualArrayDeleteWantsSize=" + UsualArrayDeleteWantsSize // NOI18N
              + ", NumPlacementArgs=" + $ushort2uint(NumPlacementArgs) // NOI18N
              + ", StoredInitializationStyle=" + $uchar2uint(StoredInitializationStyle) // NOI18N
              + super.toString(); // NOI18N
  }
}
