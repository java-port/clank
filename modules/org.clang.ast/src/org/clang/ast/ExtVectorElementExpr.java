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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

//===----------------------------------------------------------------------===//
// Clang Extensions
//===----------------------------------------------------------------------===//

/// ExtVectorElementExpr - This represents access to specific elements of a
/// vector, and may occur on the left hand side or right hand side.  For example
/// the following is legal:  "V.xy = V.zw" if V is a 4 element extended vector.
///
/// Note that the base may have either vector or pointer to vector type, just
/// like a struct field reference.
///
//<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4509,
 FQN="clang::ExtVectorElementExpr", NM="_ZN5clang20ExtVectorElementExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20ExtVectorElementExprE")
//</editor-fold>
public class ExtVectorElementExpr extends /*public*/ Expr {
  private Stmt /*P*/ Base;
  private IdentifierInfo /*P*/ Accessor;
  private SourceLocation AccessorLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr::ExtVectorElementExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4514,
   FQN="clang::ExtVectorElementExpr::ExtVectorElementExpr", NM="_ZN5clang20ExtVectorElementExprC1ENS_8QualTypeENS_13ExprValueKindEPNS_4ExprERNS_14IdentifierInfoENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20ExtVectorElementExprC1ENS_8QualTypeENS_13ExprValueKindEPNS_4ExprERNS_14IdentifierInfoENS_14SourceLocationE")
  //</editor-fold>
  public ExtVectorElementExpr(QualType ty, ExprValueKind VK, Expr /*P*/ base, 
      final IdentifierInfo /*&*/ accessor, SourceLocation loc) {
    // : Expr(ExtVectorElementExprClass, ty, VK, (VK == VK_RValue ? OK_Ordinary : OK_VectorComponent), base->isTypeDependent(), base->isValueDependent(), base->isInstantiationDependent(), base->containsUnexpandedParameterPack()), Base(base), Accessor(&accessor), AccessorLoc(loc) 
    //START JInit
    super(StmtClass.ExtVectorElementExprClass, new QualType(ty), VK, 
        (VK == ExprValueKind.VK_RValue ? ExprObjectKind.OK_Ordinary : ExprObjectKind.OK_VectorComponent), 
        base.isTypeDependent(), base.isValueDependent(), 
        base.isInstantiationDependent(), 
        base.containsUnexpandedParameterPack());
    this.Base = base;
    this.Accessor = $AddrOf(accessor);
    this.AccessorLoc = new SourceLocation(loc);
    //END JInit
  }

  
  /// \brief Build an empty vector element expression.
  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr::ExtVectorElementExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4524,
   FQN="clang::ExtVectorElementExpr::ExtVectorElementExpr", NM="_ZN5clang20ExtVectorElementExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20ExtVectorElementExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ExtVectorElementExpr(EmptyShell Empty) {
    // : Expr(ExtVectorElementExprClass, Empty), AccessorLoc() 
    //START JInit
    super(StmtClass.ExtVectorElementExprClass, new EmptyShell(Empty));
    this.AccessorLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4527,
   FQN="clang::ExtVectorElementExpr::getBase", NM="_ZNK5clang20ExtVectorElementExpr7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20ExtVectorElementExpr7getBaseEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getBase$Const() /*const*/ {
    return cast_Expr(Base);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4528,
   FQN="clang::ExtVectorElementExpr::getBase", NM="_ZN5clang20ExtVectorElementExpr7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20ExtVectorElementExpr7getBaseEv")
  //</editor-fold>
  public Expr /*P*/ getBase() {
    return cast_Expr(Base);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr::setBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4529,
   FQN="clang::ExtVectorElementExpr::setBase", NM="_ZN5clang20ExtVectorElementExpr7setBaseEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20ExtVectorElementExpr7setBaseEPNS_4ExprE")
  //</editor-fold>
  public void setBase(Expr /*P*/ E) {
    Base = E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr::getAccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4531,
   FQN="clang::ExtVectorElementExpr::getAccessor", NM="_ZNK5clang20ExtVectorElementExpr11getAccessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20ExtVectorElementExpr11getAccessorEv")
  //</editor-fold>
  public IdentifierInfo /*&*/ getAccessor() /*const*/ {
    return $Deref(Accessor);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr::setAccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4532,
   FQN="clang::ExtVectorElementExpr::setAccessor", NM="_ZN5clang20ExtVectorElementExpr11setAccessorEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20ExtVectorElementExpr11setAccessorEPNS_14IdentifierInfoE")
  //</editor-fold>
  public void setAccessor(IdentifierInfo /*P*/ II) {
    Accessor = II;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr::getAccessorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4534,
   FQN="clang::ExtVectorElementExpr::getAccessorLoc", NM="_ZNK5clang20ExtVectorElementExpr14getAccessorLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20ExtVectorElementExpr14getAccessorLocEv")
  //</editor-fold>
  public SourceLocation getAccessorLoc() /*const*/ {
    return new SourceLocation(AccessorLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr::setAccessorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4535,
   FQN="clang::ExtVectorElementExpr::setAccessorLoc", NM="_ZN5clang20ExtVectorElementExpr14setAccessorLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20ExtVectorElementExpr14setAccessorLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAccessorLoc(SourceLocation L) {
    AccessorLoc.$assign(L);
  }

  
  /// getNumElements - Get the number of components being selected.
  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr::getNumElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3368,
   FQN="clang::ExtVectorElementExpr::getNumElements", NM="_ZNK5clang20ExtVectorElementExpr14getNumElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20ExtVectorElementExpr14getNumElementsEv")
  //</editor-fold>
  public /*uint*/int getNumElements() /*const*/ {
    {
      /*const*/ VectorType /*P*/ VT = getType().$arrow().getAs(VectorType.class);
      if ((VT != null)) {
        return VT.getNumElements();
      }
    }
    return 1;
  }

  
  /// containsDuplicateElements - Return true if any element access is
  /// repeated.
  
  /// containsDuplicateElements - Return true if any element access is repeated.
  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr::containsDuplicateElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3375,
   FQN="clang::ExtVectorElementExpr::containsDuplicateElements", NM="_ZNK5clang20ExtVectorElementExpr25containsDuplicateElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20ExtVectorElementExpr25containsDuplicateElementsEv")
  //</editor-fold>
  public boolean containsDuplicateElements() /*const*/ {
    // FIXME: Refactor this code to an accessor on the AST node which returns the
    // "type" of component access, and share with code below and in Sema.
    StringRef Comp = Accessor.getName();
    
    // Halving swizzles do not contain duplicate elements.
    if ($eq_StringRef(/*NO_COPY*/Comp, /*STRINGREF_STR*/"hi") || $eq_StringRef(/*NO_COPY*/Comp, /*STRINGREF_STR*/"lo") || $eq_StringRef(/*NO_COPY*/Comp, /*STRINGREF_STR*/"even") || $eq_StringRef(/*NO_COPY*/Comp, /*STRINGREF_STR*/"odd")) {
      return false;
    }
    
    // Advance past s-char prefix on hex swizzles.
    if (Comp.$at(0) == $$s || Comp.$at(0) == $$S) {
      Comp.$assignMove(Comp.substr(1));
    }
    
    for (/*uint*/int i = 0, e = Comp.size(); i != e; ++i)  {
      if (Comp.substr(i + 1).find(Comp.$at(i)) != StringRef.npos) {
        return true;
      }
    }
    
    return false;
  }

  
  /// getEncodedElementAccess - Encode the elements accessed into an llvm
  /// aggregate Constant of ConstantInt(s).
  
  /// getEncodedElementAccess - We encode the fields as a llvm ConstantArray.
  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr::getEncodedElementAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3396,
   FQN="clang::ExtVectorElementExpr::getEncodedElementAccess", NM="_ZNK5clang20ExtVectorElementExpr23getEncodedElementAccessERN4llvm15SmallVectorImplIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20ExtVectorElementExpr23getEncodedElementAccessERN4llvm15SmallVectorImplIjEE")
  //</editor-fold>
  public void getEncodedElementAccess(final SmallVectorImplUInt /*&*/ Elts) /*const*/ {
    StringRef Comp = Accessor.getName();
    if (Comp.$at(0) == $$s || Comp.$at(0) == $$S) {
      Comp.$assignMove(Comp.substr(1));
    }
    
    boolean isHi = $eq_StringRef(/*NO_COPY*/Comp, /*STRINGREF_STR*/"hi");
    boolean isLo = $eq_StringRef(/*NO_COPY*/Comp, /*STRINGREF_STR*/"lo");
    boolean isEven = $eq_StringRef(/*NO_COPY*/Comp, /*STRINGREF_STR*/"even");
    boolean isOdd = $eq_StringRef(/*NO_COPY*/Comp, /*STRINGREF_STR*/"odd");
    
    for (/*uint*/int i = 0, e = getNumElements(); i != e; ++i) {
      long/*uint64_t*/ Index;
      if (isHi) {
        Index = $uint2ulong(e + i);
      } else if (isLo) {
        Index = $uint2ulong(i);
      } else if (isEven) {
        Index = $uint2ulong(2 * i);
      } else if (isOdd) {
        Index = $uint2ulong(2 * i + 1);
      } else {
        Index = $int2ulong(ExtVectorType.getAccessorIdx(Comp.$at(i)));
      }
      
      Elts.push_back($ulong2uint(Index));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4548,
   FQN="clang::ExtVectorElementExpr::getLocStart", NM="_ZNK5clang20ExtVectorElementExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20ExtVectorElementExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getBase$Const().getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4551,
   FQN="clang::ExtVectorElementExpr::getLocEnd", NM="_ZNK5clang20ExtVectorElementExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20ExtVectorElementExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(AccessorLoc);
  }

  
  /// isArrow - Return true if the base expression is a pointer to vector,
  /// return false if the base expression is a vector.
  
  /// isArrow - Return true if the base expression is a pointer to vector,
  /// return false if the base expression is a vector.
  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr::isArrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3364,
   FQN="clang::ExtVectorElementExpr::isArrow", NM="_ZNK5clang20ExtVectorElementExpr7isArrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20ExtVectorElementExpr7isArrowEv")
  //</editor-fold>
  public boolean isArrow() /*const*/ {
    return getBase$Const().getType().$arrow().isPointerType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4557,
   FQN="clang::ExtVectorElementExpr::classof", NM="_ZN5clang20ExtVectorElementExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20ExtVectorElementExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ExtVectorElementExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorElementExpr::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4562,
   FQN="clang::ExtVectorElementExpr::children", NM="_ZN5clang20ExtVectorElementExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20ExtVectorElementExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Base))), new StmtIterator(create_type$ptr($AddrOf(Base)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "Base=" + Base // NOI18N
              + ", Accessor=" + Accessor // NOI18N
              + ", AccessorLoc=" + AccessorLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
